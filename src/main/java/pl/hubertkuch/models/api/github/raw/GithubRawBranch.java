package pl.hubertkuch.models.api.github.raw;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GithubRawBranch(
        String name,
        GithubRawBranchCommit commit
) {
}
