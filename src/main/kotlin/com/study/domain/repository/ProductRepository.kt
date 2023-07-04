package com.study.domain.repository

import com.study.domain.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Int> {
    fun findByName(name: String): Product?
}