package pl.hubertkuch.web.consumer;

import org.springframework.web.client.RestTemplate;

public abstract class HttpConsumer {
    protected final RestTemplate restTemplate;

    public HttpConsumer(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
