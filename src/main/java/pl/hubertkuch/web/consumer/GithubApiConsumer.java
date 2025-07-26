package pl.hubertkuch.web.consumer;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import pl.hubertkuch.models.api.github.parsed.GithubBranch;
import pl.hubertkuch.models.api.github.parsed.GithubRepo;
import pl.hubertkuch.models.api.github.parsed.GithubRepos;
import pl.hubertkuch.models.api.github.raw.GithubRawBranch;
import pl.hubertkuch.models.api.github.raw.GithubRawRepo;
import pl.hubertkuch.web.exceptions.GithubRepoException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GithubApiConsumer extends HttpConsumer {

    private final String BASE ="http://api.github.com";

    public GithubApiConsumer(RestTemplate restTemplate) {
        super(restTemplate);
    }

    public final GithubRepos getReposByOwner(String owner) {
        try {
            var reposHttpEntity = restTemplate.getForEntity(buildReposUrl(owner), GithubRawRepo[].class);

            if (!reposHttpEntity.getStatusCode().is2xxSuccessful() || reposHttpEntity.getBody() == null) {
                System.out.println(reposHttpEntity.getStatusCode());
                throw new GithubRepoException("Owner not found");
            }

            var reposThatAintForks = Arrays.stream(reposHttpEntity.getBody())
                    .filter(repo -> !repo.fork())
                    .map(repo -> new GithubRepo(owner, repo.name(), getBranchesForRepo(owner, repo.name())))
                    .collect(Collectors.toList());

            return new GithubRepos(owner, reposThatAintForks);
        } catch (RestClientException e) {
            throw new GithubRepoException(e.getMessage());
        }
    }

    public final List<GithubBranch> getBranchesForRepo(String owner, String repo) {
        try {
            var branches = restTemplate.getForObject(buildBranchesUrl(owner, repo), GithubRawBranch[].class);

            return Arrays.stream(branches).map(GithubBranch::ofRaw).toList();
        } catch (RestClientException e) {
            throw new GithubRepoException(e.getMessage());
        }
    }

    private String buildReposUrl(String owner) {
        return BASE + "/users/%s/repos".formatted(owner);
    }

    private String buildBranchesUrl(String owner, String repo) {
        return BASE + "/repos/%s/%s/branches".formatted(owner, repo);
    }
}
