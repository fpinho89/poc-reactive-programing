package br.com.poc

import br.com.poc.client.Agregator
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class PocClientApplication {

	@Bean
	fun init(aggregator: Agregator) = CommandLineRunner{
		aggregator.exec()
	}


}

fun main(args: Array<String>) {
	runApplication<PocClientApplication>(*args)
}
