package com.johnpaulcas.core.db.tables

import org.jetbrains.exposed.v1.core.Table
import org.jetbrains.exposed.v1.core.java.javaUUID
import org.jetbrains.exposed.v1.javatime.timestamp

object TodosTable : Table("todos") {
    val id = javaUUID("id")
    val userId = javaUUID("user_id").references(UsersTable.id)
    val title = varchar("title", 500)
    val done = bool("done").default(false)
    val createdAt = timestamp("created_at")
    val updatedAt = timestamp("updated_at")

    override val primaryKey = PrimaryKey(id)
}