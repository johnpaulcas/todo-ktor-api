package com.johnpaulcas.core.db

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jetbrains.exposed.v1.jdbc.JdbcTransaction
import org.jetbrains.exposed.v1.jdbc.transactions.suspendTransaction

suspend fun <T> dbQuery(dispatcher: CoroutineDispatcher = Dispatchers.IO, block: suspend JdbcTransaction.() -> T): T =
    withContext(dispatcher) {
        suspendTransaction {
            block()
        }
    }