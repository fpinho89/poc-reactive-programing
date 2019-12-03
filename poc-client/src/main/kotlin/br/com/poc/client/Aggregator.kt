package br.com.poc.client

import br.com.poc.domain.ProductInventory
import br.com.poc.repository.InventoryRepository
import br.com.poc.repository.ProductRepository
import org.springframework.stereotype.Component

@Component
class Aggregator(private val productClient: ProductRepository,
                 private val inventoryClient: InventoryRepository) {

    fun exec() {
        productClient.getProducts().flatMap {
            p -> inventoryClient.getInventoryByProductId(p.id).map { ProductInventory(p, it.amount) }
        }.collectList().subscribe(System.out::println)
    }
}