package pl.hubertkuch.models.api.github.parsed;

import pl.hubertkuch.models.api.github.raw.GithubRawBranch;
import pl.hubertkuch.models.api.github.raw.GithubRawBranchCommit;
import pl.hubertkuch.models.api.github.raw.GithubRawRepo;

import java.util.List;

public record GithubRepo(
        String ownerLogin,
        String name,
        List<GithubBranch> branches
) {
    public static GithubRepo ofRaw(GithubRawRepo repo, List<GithubRawBranch> branches) {
        return new GithubRepo(
                repo.owner().login(),
                repo.name(),
                branches.stream().map(GithubBranch::ofRaw).toList()
        );
    }
}
