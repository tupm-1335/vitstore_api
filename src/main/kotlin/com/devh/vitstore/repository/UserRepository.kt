package com.devh.vitstore.repository

import com.devh.vitstore.model.user.UserDao
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<UserDao?, Long> {
    fun findByUsername(username: String?): UserDao?
    fun findByEmailIgnoreCase(email: String): UserDao?
    fun existsByEmail(email: String): Boolean
    fun findByActiveToken(activeToken: String): UserDao?
}
