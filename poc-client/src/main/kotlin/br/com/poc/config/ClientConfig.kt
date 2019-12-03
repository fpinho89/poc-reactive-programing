package br.com.poc.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class ClientConfig {

    @Bean
    fun productWebClient(@Value("\${api.product}") uri : String) = WebClient.create(uri)

    @Bean
    fun inventoryWebClient(@Value("\${api.inventory}") uri : String) = WebClient.create(uri)
}