package com.johnpaulcas.user.domain

interface UserRepository {

    suspend fun findByEmail(email: String): User?

    suspend fun save(email: String, password: String): User
}