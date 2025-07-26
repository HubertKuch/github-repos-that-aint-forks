package pl.hubertkuch.web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.hubertkuch.models.api.github.parsed.GithubRepos;
import pl.hubertkuch.web.consumer.GithubApiConsumer;

@RestController
@RequestMapping("/api/v1/gh")
public class GithubController {
    private final GithubApiConsumer ghConsumer;

    public GithubController(GithubApiConsumer ghConsumer) {
        this.ghConsumer = ghConsumer;
    }

    @GetMapping("/repos/{owner}")
    public GithubRepos repos(@PathVariable String owner) {
        return ghConsumer.getReposByOwner(owner);
    }
}
