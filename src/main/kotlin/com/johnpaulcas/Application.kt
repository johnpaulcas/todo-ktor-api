package com.johnpaulcas

import com.johnpaulcas.core.security.PasswordHasher
import com.johnpaulcas.plugins.*
import com.johnpaulcas.user.data.UserRepositoryImpl
import com.johnpaulcas.user.domain.UserRepository
import com.johnpaulcas.user.domain.UserService
import com.johnpaulcas.user.domain.UserServiceImpl
import io.ktor.server.application.*

fun Application.module() {

    // user dependency
    val userRepository: UserRepository = UserRepositoryImpl()

    val hasher = PasswordHasher()
    val userService: UserService = UserServiceImpl(userRepository, hasher)

    configureDatabase()
    configureSerialization()
    configureSecurity()
    configureMonitoring()
    configureStatusPages()
    configureRouting(userService)
}