package com.johnpaulcas.user.data

import com.johnpaulcas.core.db.tables.UsersTable
import com.johnpaulcas.user.domain.User
import org.jetbrains.exposed.v1.core.ResultRow

// Map data to domain model
fun ResultRow.toUser(): User = User(
    id = this[UsersTable.id],
    email = this[UsersTable.email],
    createdAt = this[UsersTable.createdAt]
)
