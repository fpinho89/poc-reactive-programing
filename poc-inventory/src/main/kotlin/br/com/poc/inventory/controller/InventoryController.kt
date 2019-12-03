package br.com.poc.inventory.controller

import br.com.poc.inventory.domain.Inventory
import br.com.poc.inventory.service.InventoryService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class InventoryController(private val inventoryService: InventoryService) {

    @GetMapping("/inventory/product/{productId}")
    @ResponseStatus(HttpStatus.OK)
    fun findByProductId(@PathVariable("productId") productId: Long) : Mono<Inventory> {
        return this.inventoryService.findByProductId(productId)
    }

    @GetMapping("/inventory")
    @ResponseStatus(HttpStatus.OK)
    fun findAll() : Flux<Inventory> {
        return  this.inventoryService.findAll()
    }
}