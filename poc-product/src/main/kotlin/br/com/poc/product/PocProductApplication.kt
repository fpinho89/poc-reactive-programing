package br.com.poc.product

import br.com.poc.product.repository.ProductRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class PocProductApplication {

	@Bean
	fun init(repository: ProductRepository) = CommandLineRunner {
		//repository.save(Product(2, "Shampoo")).subscribe()
	}

}

fun main(args: Array<String>) {
	runApplication<PocProductApplication>(*args)
}
