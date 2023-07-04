package com.study.domain.repository

import com.study.domain.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Int> {
    fun findByName(name: String): User?
}