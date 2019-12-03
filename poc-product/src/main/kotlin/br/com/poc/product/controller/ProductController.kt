package br.com.poc.product.controller

import br.com.poc.product.domain.Product
import br.com.poc.product.exceptions.ProductNotFoundException
import br.com.poc.product.service.ProductService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration

@RestController
class ProductController(private val productService: ProductService) {
/*
    @GetMapping("/product/{name}")
    @ResponseStatus(HttpStatus.OK)
    fun getProductByName(@PathVariable("name") name:String) : Mono<Product> {
        return this.productService.findByName(name)
                .switchIfEmpty(Mono.error(ProductNotFoundException(name)))
    }*/

    @GetMapping("/product/{id}")
    fun getProductById(@PathVariable("id") id:Long) : Mono<Product> {
        return this.productService.findById(id)
    }

    @GetMapping("/product", produces = ["application/stream+json"])
    @ResponseStatus(HttpStatus.OK)
    fun getAll(): Flux<Product> {
        return this.productService.findAll()
                .delayElements(Duration.ofMillis(300))
    }

    @DeleteMapping("/product/{code}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun delete(@PathVariable("code") code: Long) : Mono<Void> {
        return this.productService.delete(code)
    }

    /*@GetMapping("/product-available")
    fun getAllAvailable(): Flux<ProductInventory> {

        //val isNotZero: (ProductInventory) -> Boolean = {it.amount > 0}

        return  this.productService.findAll()
                .flatMap { product ->
                    Flux.combineLatest(
                            Mono.just(product),
                            this.inventoryService.findByProductId(product.id),
                            BiFunction<Product, Inventory, ProductInventory>{ p,i -> ProductInventory(p, i.amount)}
                    )//.filter(isNotZero)//.filter{it.amount > 20}
                }
    }*/
}