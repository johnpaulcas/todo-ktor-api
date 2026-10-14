package com.johnpaulcas.core.db

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.flywaydb.core.Flyway
import org.jetbrains.exposed.v1.jdbc.Database
import javax.sql.DataSource

object DatabaseFactory {
    fun init() {
        val config = HikariConfig().apply {
            jdbcUrl = requireEnv("DB_URL")
            username = requireEnv("DB_USERNAME")
            password = requireEnv("DB_PASSWORD")
            driverClassName = "org.postgresql.Driver"
            maximumPoolSize = 10
        }
        val datasource = HikariDataSource(config)
        runMigrations(datasource)
        Database.connect(datasource)
    }

    private fun runMigrations(datasource: DataSource) {
        Flyway.configure()
            .dataSource(datasource)
            .load()
            .migrate()
    }

}


fun requireEnv(name: String): String =
    System.getenv(name) ?: error("Missing required environment variable: $name")
