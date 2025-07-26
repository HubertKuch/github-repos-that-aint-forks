package pl.hubertkuch.models.api.github.parsed;

import pl.hubertkuch.models.api.github.raw.GithubRawBranch;

public record GithubBranch(
        String name,
        String lastCommitSha
) {
    public static GithubBranch ofRaw(GithubRawBranch branch) {
        return new GithubBranch(branch.name(), branch.commit().sha());
    }
}
