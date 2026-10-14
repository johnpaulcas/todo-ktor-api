package com.johnpaulcas.user.data

import com.johnpaulcas.core.db.dbQuery
import com.johnpaulcas.core.db.tables.UsersTable
import com.johnpaulcas.user.domain.User
import com.johnpaulcas.user.domain.UserRepository
import org.jetbrains.exposed.v1.core.ResultRow
import org.jetbrains.exposed.v1.core.eq
import org.jetbrains.exposed.v1.jdbc.insertReturning
import org.jetbrains.exposed.v1.jdbc.selectAll
import java.time.Instant
import java.util.*

class UserRepositoryImpl : UserRepository {

    override suspend fun findByEmail(email: String): User? = dbQuery {
        UsersTable.selectAll()
            .where { UsersTable.email eq email }
            .map { it.toUser() }
            .singleOrNull()
    }

    override suspend fun save(email: String, password: String) = dbQuery {
        val userId = UUID.randomUUID()
         UsersTable.insertReturning {
            it[UsersTable.id] = userId
            it[UsersTable.email] = email
            it[UsersTable.password] = password
            it[UsersTable.createdAt] = Instant.now()
        }.single().toUser()
    }
}

