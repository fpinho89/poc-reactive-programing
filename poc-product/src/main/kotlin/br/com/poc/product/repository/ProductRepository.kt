package br.com.poc.product.repository

import br.com.poc.product.domain.Product
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Mono

@Repository
@Transactional
interface ProductRepository : ReactiveCrudRepository<Product, Long> {

    fun findByName(name:String) : Mono<Product>
}