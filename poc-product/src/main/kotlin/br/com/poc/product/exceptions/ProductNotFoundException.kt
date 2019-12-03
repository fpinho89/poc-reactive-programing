package br.com.poc.product.exceptions

import java.lang.RuntimeException

class ProductNotFoundException(override val message: String) : RuntimeException(message) {

}