package com.johnpaulcas.plugins

import com.johnpaulcas.core.db.DatabaseFactory
import io.ktor.server.application.Application


fun Application.configureDatabase() {
    DatabaseFactory.init()
}