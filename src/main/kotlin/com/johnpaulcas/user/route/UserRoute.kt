package com.johnpaulcas.user.route

import com.johnpaulcas.user.domain.UserService
import com.johnpaulcas.user.route.endpoint.createUser
import com.johnpaulcas.user.route.endpoint.getAllUsers
import com.johnpaulcas.user.route.endpoint.getUserByEmail
import io.ktor.server.routing.*

fun Route.userRoutes(userService: UserService) {
    route("/users") {
        createUser(userService)
        getAllUsers(userService)
        getUserByEmail(userService)
    }
}