package br.com.poc.repository

import br.com.poc.domain.Product
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux

@Component
class ProductRepository(private val productWebClient: WebClient) {

    fun getProducts(): Flux<Product> {

        return this.productWebClient.get()
                .uri("/product")
                .retrieve()
                .bodyToFlux(Product::class.java)

    }
}

