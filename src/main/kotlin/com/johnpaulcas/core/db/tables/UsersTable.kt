package com.johnpaulcas.core.db.tables

import org.jetbrains.exposed.v1.core.Table
import org.jetbrains.exposed.v1.core.java.javaUUID
import org.jetbrains.exposed.v1.javatime.timestamp

object UsersTable : Table("users") {
    val id = javaUUID("id")
    val email = varchar("email", 255).uniqueIndex()
    val password = text("password")
    val createdAt = timestamp("created_at")

    override val primaryKey = PrimaryKey(id)
}