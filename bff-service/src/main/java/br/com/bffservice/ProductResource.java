package br.com.bffservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/api/products")
public class ProductResource {

    private static final Logger log = LoggerFactory.getLogger(ProductResource.class);

    private final WebClient webClient;

    public ProductResource(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8081").build();
    }

    @GetMapping
    public ResponseEntity getProducts() {
        log.info("GET /api/products - start");

        return ResponseEntity.ok(
                this.webClient
                        .get()
                        .uri("/api/products")
                        .retrieve()
                        .bodyToMono(String.class)
                        .block()
        );
    }

}
