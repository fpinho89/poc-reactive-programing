package br.com.poc.inventory

import br.com.poc.inventory.domain.Inventory
import br.com.poc.inventory.repository.InventoryRepository
import br.com.poc.inventory.service.InventoryService
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class PocInventoryApplication {

	@Bean
	fun init(inventoryService: InventoryService) = CommandLineRunner {
//		inventoryService.save(Inventory(1,1,10)).block()
//		inventoryService.save(Inventory(2,2,50)).block()
//		inventoryService.save(Inventory(3,3,70)).block()
	}

}

fun main(args: Array<String>) {
	runApplication<PocInventoryApplication>(*args)
}
