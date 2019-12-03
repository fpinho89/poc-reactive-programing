package br.com.poc.inventory.service

import br.com.poc.inventory.domain.Inventory
import br.com.poc.inventory.repository.InventoryRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class InventoryService(private val inventoryRepository: InventoryRepository) {

    fun save(inventory: Inventory): Mono<Inventory> {
        return this.inventoryRepository.save(inventory)
    }

    fun findByProductId(productId: Long) : Mono<Inventory> {
        return this.inventoryRepository.findByProductId(productId)
    }

    fun findAll() : Flux<Inventory> {
        return this.inventoryRepository.findAll()
    }
}