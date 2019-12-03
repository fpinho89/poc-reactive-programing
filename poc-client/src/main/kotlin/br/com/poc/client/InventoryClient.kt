package br.com.poc.client

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class InventoryClient {

    @Value("\${api.inventory}")
    lateinit var apiInventory: String

    fun getInventoryByProductId(productId:Long): Mono<Inventory> {

        val client = WebClient.create(this.apiInventory)

        return client.get()
                .uri("/inventory/product/{productId}", productId)
                .retrieve()
                .bodyToMono(Inventory::class.java)

    }

    fun getAllInventory(): Flux<Inventory> {

        val client = WebClient.create(this.apiInventory)

        return client.get()
                .uri("/inventory")
                .retrieve()
                .bodyToFlux(Inventory::class.java)

    }
}