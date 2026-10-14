package com.johnpaulcas.plugins

import com.johnpaulcas.user.domain.UserService
import com.johnpaulcas.user.route.userRoutes
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting(userService: UserService) {

    routing {
        route("/api/v1") {
            userRoutes(userService)
        }
    }
}