package br.com.poc.client

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux

@Component
class ProductClient {

    @Value("\${api.product}")
    lateinit var apiProduct: String

    fun getProducts(): Flux<Product> {

        val client = WebClient.create(this.apiProduct)

        return client.get()
                .uri("/product")
                .retrieve()
                .bodyToFlux(Product::class.java)

    }

}