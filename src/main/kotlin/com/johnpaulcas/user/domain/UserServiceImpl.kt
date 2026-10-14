package com.johnpaulcas.user.domain

import com.johnpaulcas.core.error.AppException
import com.johnpaulcas.core.security.PasswordHasher
import org.slf4j.LoggerFactory

class UserServiceImpl(
    private val userRepository: UserRepository,
    val hasher: PasswordHasher
) : UserService {

    private val logger = LoggerFactory.getLogger(UserServiceImpl::class.java)

    override suspend fun getByEmail(email: String): User {
        return userRepository.findByEmail(email) ?: throw AppException.NotFound("Email not found")
    }

    override suspend fun save(email: String, password: String): User {
        val userExist = userRepository.findByEmail(email)

        if (userExist != null) {
            throw AppException.Conflict("Email already exist")
        }

        val user = userRepository.save(email, hasher.hash(password))
        return user
    }
}