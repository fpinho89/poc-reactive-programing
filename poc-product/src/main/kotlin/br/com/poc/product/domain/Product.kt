package br.com.poc.product.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "product")
data class Product(@Id val id: Long
                   , val name: String)