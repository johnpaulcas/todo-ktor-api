package com.johnpaulcas.user.domain

interface UserService {

    suspend fun getByEmail(email: String): User

    suspend fun save(email: String, password: String): User
}