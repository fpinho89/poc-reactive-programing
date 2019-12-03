package br.com.poc.inventory.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "inventory")
class Inventory(@Id val id: Long, val productId: Long, val amount: Int)