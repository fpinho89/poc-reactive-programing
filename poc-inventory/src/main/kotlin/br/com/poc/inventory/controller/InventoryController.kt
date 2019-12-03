package br.com.poc.inventory.controller

import br.com.poc.inventory.domain.Inventory
import br.com.poc.inventory.service.InventoryService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class InventoryController(private val inventoryService: InventoryService) {

    @GetMapping("/inventory")
    @ResponseStatus(HttpStatus.OK)
    fun findByProductId(@RequestParam("productId") productId: Long) : Mono<Inventory> {
        return this.inventoryService.findByProductId(productId)
    }

    @GetMapping("/inventories")
    @ResponseStatus(HttpStatus.OK)
    fun findAll() : Flux<Inventory> {
        return  this.inventoryService.findAll()
    }
}