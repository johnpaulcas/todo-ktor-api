package com.johnpaulcas.user.route.endpoint

import com.johnpaulcas.user.route.dto.toResponse
import com.johnpaulcas.user.domain.UserService
import com.johnpaulcas.user.route.dto.LoginRequest
import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.createUser(userService: UserService) {
    post {
        val userRequest = call.receive<LoginRequest>()

        val createdUser = userService.save(
            userRequest.email, userRequest.password
        )

        call.respond(
            HttpStatusCode.Created,
            createdUser.toResponse()
        )
    }
}