package br.com.productservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping(value = "/api/products")
public class ProductResource {

    private static final Logger log = LoggerFactory.getLogger(ProductResource.class);

    @GetMapping
    public ResponseEntity<Stream<String>> getProducts() {
        log.info("GET /api/products - start");
        return ResponseEntity.ok(Stream.of("Product 1", "Product 2", "Product 3"));
    }

}
