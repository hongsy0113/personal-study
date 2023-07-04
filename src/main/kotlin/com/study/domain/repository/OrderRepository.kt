package com.study.domain.repository

import com.study.domain.entity.Order
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository : JpaRepository<Order, Int> {
    fun findByName(name: String): Order?
}