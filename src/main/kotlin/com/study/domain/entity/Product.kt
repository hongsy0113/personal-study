package com.study.domain.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val productId: Int? = null,
    val name: String
) {
    fun changeName(name: String): Product =
        this.copy(name = name)
}
