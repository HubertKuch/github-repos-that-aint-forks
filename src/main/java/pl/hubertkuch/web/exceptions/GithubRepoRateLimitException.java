package pl.hubertkuch.web.exceptions;

public class GithubRepoRateLimitException extends GithubRepoException {

    public GithubRepoRateLimitException(String message) {
        super(message);
    }
}
