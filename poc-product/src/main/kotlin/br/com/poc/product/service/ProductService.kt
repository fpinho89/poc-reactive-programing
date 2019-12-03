package br.com.poc.product.service

import br.com.poc.product.domain.Product
import br.com.poc.product.repository.ProductRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class ProductService(private val repository: ProductRepository) {

    fun findByName(name:String) : Mono<Product> {
        return this.repository.findByName(name)
    }

    fun findAll(): Flux<Product> {
        return this.repository.findAll()
    }

    fun findById(id:Long) : Mono<Product> {
        return this.repository.findById(id)
    }

    fun delete(id:Long): Mono<Void> {
        return this.repository.deleteById(id)
    }
}