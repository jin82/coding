package cn.jin.reactive;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * Created by jin on 2019/2/6.
 */
public class GreetWebClient {

    private WebClient webClient = WebClient.create("http://localhost:8080");

    private Mono<ClientResponse> responseMono = webClient.get()
            .uri("/hello")
            .accept(MediaType.TEXT_PLAIN)
            .exchange();

    public String getResult() {
        return responseMono.flatMap(res -> res.bodyToMono(String.class)).block();
    }
}
