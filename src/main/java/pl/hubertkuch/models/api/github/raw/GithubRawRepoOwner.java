package pl.hubertkuch.models.api.github.raw;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GithubRawRepoOwner(
        String login,
        @JsonProperty("branches_url")
        String branchesUrl
) {
}
