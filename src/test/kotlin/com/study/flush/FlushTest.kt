package com.study.flush

import com.study.domain.repository.ProductRepository
import com.study.domain.repository.UserRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
class FlushTest @Autowired constructor(
    private val productRepository: ProductRepository,
    private val userRepository: UserRepository,
) {
    @Transactional
    @Test
    fun `JPQL이 실행될 때 관련이 있는 엔티티에 대해서만 flush를 한다`() {
        // given
        val user = userRepository.findByName("user1")!!
        val product = productRepository.findByName("product1")!!

        // when

        // 1. user 테이블 update
        user.changeName("user11").also {
            userRepository.save(it)
        }

        // 2. product 테이블 update
        product.changeName("product11").also {
            productRepository.save(it)
        }

        // 3. user 테이블 select
        userRepository.findByName("user11")

        // 4. product 테이블 select
        productRepository.findByName("product1")
    }
}