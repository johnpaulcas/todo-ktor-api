package com.johnpaulcas.user.route.endpoint

import com.johnpaulcas.core.error.AppException
import com.johnpaulcas.user.domain.UserService
import com.johnpaulcas.user.route.dto.toResponse
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.getUserByEmail(userService: UserService) {
    get("/{email}") {
        val email = call.pathParameters["email"] ?: throw AppException.Validation("Parameter missing")

        val user = userService.getByEmail(email) ?: throw AppException.NotFound("Email not found")

        call.respond(user.toResponse())
    }
}