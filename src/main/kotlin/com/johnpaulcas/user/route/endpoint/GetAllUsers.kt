package com.johnpaulcas.user.route.endpoint

import com.johnpaulcas.user.domain.UserService
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.getAllUsers(userService: UserService) {
    get {
//        val users = userService.findAll().map { it.toResponse() }
//        call.respond(HttpStatusCode.OK, users)
    }
}