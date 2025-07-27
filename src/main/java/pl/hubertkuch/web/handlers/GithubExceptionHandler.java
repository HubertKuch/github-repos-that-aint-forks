package pl.hubertkuch.web.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.hubertkuch.models.api.MessageStatusResponse;
import pl.hubertkuch.web.exceptions.GithubRepoException;
import pl.hubertkuch.web.exceptions.GithubRepoRateLimitException;

@Component
@RestControllerAdvice
public class GithubExceptionHandler {

    @ExceptionHandler(GithubRepoException.class)
    public MessageStatusResponse ghExp(GithubRepoException exp) {
        return new MessageStatusResponse(
            exp.getMessage(),
            exp instanceof GithubRepoRateLimitException
                ? HttpStatus.BAD_REQUEST.value()
                : HttpStatus.NOT_FOUND.value()
        );
    }

    @ExceptionHandler(InternalError.class)
    public MessageStatusResponse internal(InternalError exp) {
        return new MessageStatusResponse(
            "internal error",
            HttpStatus.INTERNAL_SERVER_ERROR.value()
        );
    }
}
