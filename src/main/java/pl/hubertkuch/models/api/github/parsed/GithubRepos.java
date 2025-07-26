package pl.hubertkuch.models.api.github.parsed;

import java.util.List;

public record GithubRepos(
        String owner,
        List<GithubRepo> repos
) {
}
