package pl.hubertkuch.web.consumer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.hubertkuch.models.api.github.parsed.GithubRepo;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GithubApiConsumerTest {

    @Autowired
    GithubApiConsumer githubApiConsumer;

    @Test
    public void shouldReturnValid() {
        // given
        final var OWNER = "torvalds";

        assertDoesNotThrow(() -> {
            var reposByOwner = githubApiConsumer.getReposByOwner(OWNER);

            assertNotNull(reposByOwner);

            assertNotNull(reposByOwner.owner());
            assertNotNull(reposByOwner.repos());
            assertNotEquals(0, reposByOwner.repos().size());

            assertInstanceOf(GithubRepo.class, reposByOwner.repos().get(0));
        });
    }

}