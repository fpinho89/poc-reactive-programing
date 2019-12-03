package br.com.poc.client

import org.springframework.stereotype.Component

@Component
class Aggregator(private val productClient: ProductClient,
                 private val inventoryClient: InventoryClient) {

    fun exec() {
        productClient.getProducts().flatMap {
            p -> inventoryClient.getInventoryByProductId(p.id).map { ProductInventory(p, it.amount) }
        }.collectList().subscribe(System.out::println)
    }
}