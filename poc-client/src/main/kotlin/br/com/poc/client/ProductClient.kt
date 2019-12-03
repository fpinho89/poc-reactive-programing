package br.com.poc.client

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux

@Component
class ProductClient {

    fun getProducts(): Flux<Product> {

        val client = WebClient.create("http://localhost:8080")

        return client.get()
                .uri("/product")
                .retrieve()
                .bodyToFlux(Product::class.java)

    }

}