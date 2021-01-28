package com.devh.vitstore.controller.api.v1.product

import com.devh.vitstore.model.product.ProductDao
import com.devh.vitstore.model.product.ProductDto
import com.devh.vitstore.service.product.ProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.PostMapping
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/products")
class ProductController(
    private val productService: ProductService
) {
    @GetMapping("/{id}")
    fun findOneById(@PathVariable("id") id: Long): ResponseEntity<ProductDao> {
        return ResponseEntity.ok(productService.findOneById(id))
    }

    @PostMapping
    fun createProduct(@Valid @RequestBody product: ProductDto): ResponseEntity<Any> {
        return ResponseEntity.ok(productService.create(product))
    }

    @PostMapping("/{id}")
    fun updateProduct(
        @PathVariable("id") id: Long,
        @Valid @RequestBody product: ProductDto
    ): ResponseEntity<ProductDao> {
        return ResponseEntity.ok(productService.update(id, product))
    }

    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable("id") id: Long): ResponseEntity<Any> {
        return ResponseEntity.ok(productService.delete(id))
    }
}
