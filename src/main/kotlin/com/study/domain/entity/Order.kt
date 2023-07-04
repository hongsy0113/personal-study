package com.study.domain.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "order_test")
data class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val productId: Int? = null,
    val name: String
) {
    fun changeName(name: String): Order =
        this.copy(name = name)
}
