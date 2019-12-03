package br.com.poc.inventory.repository

import br.com.poc.inventory.domain.Inventory
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
interface InventoryRepository : ReactiveCrudRepository<Inventory, Long> {

    fun findByProductId(productId:Long) : Mono<Inventory>
}