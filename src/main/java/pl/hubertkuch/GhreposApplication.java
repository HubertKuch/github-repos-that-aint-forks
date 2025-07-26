package pl.hubertkuch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.http.client.ClientHttpRequestFactorySettings;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@SpringBootApplication
public class GhreposApplication {

    public static void main(String[] args) {
        SpringApplication.run(GhreposApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        final var timeout = Duration.ofSeconds(5);

        return builder
                .redirects(ClientHttpRequestFactorySettings.Redirects.FOLLOW)
                .connectTimeout(timeout)
                .readTimeout(timeout)
                .build();
    }
}
