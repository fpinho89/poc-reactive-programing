package br.com.poc.repository

import br.com.poc.domain.Inventory
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class InventoryRepository(private val inventoryWebClient: WebClient) {

    fun getInventoryByProductId(productId:Long): Mono<Inventory> {

        return this.inventoryWebClient.get()
                .uri("/inventory?productId={productId}", productId)
                .retrieve()
                .bodyToMono(Inventory::class.java)

    }

    fun getAllInventory(): Flux<Inventory> {

        return this.inventoryWebClient.get()
                .uri("/inventory")
                .retrieve()
                .bodyToFlux(Inventory::class.java)

    }
}