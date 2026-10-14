package com.johnpaulcas.plugins

import com.johnpaulcas.core.error.AppException
import com.johnpaulcas.core.error.ErrorResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.BadRequestException
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*

fun Application.configureStatusPages() {
    install(StatusPages) {

        // domain error
        exception<AppException.Validation> { call, cause ->
            call.respond(
                HttpStatusCode.BadRequest, ErrorResponse(
                    cause.message ?: "Invalid Input"
                )
            )
        }

        exception<AppException.Conflict> { call, cause ->
            call.respond(HttpStatusCode.Conflict, ErrorResponse(
                cause.message ?: "Conflict"
            ))
        }

        exception<AppException.NotFound> { call, cause ->
            call.respond(HttpStatusCode.NotFound, ErrorResponse(
                cause.message ?: "Not Found"
            ))
        }

        // bad request or malformed JSON sent by the client
        exception<BadRequestException> {call, _ ->
            call.respond(HttpStatusCode.BadRequest, ErrorResponse("Malformed request body"))
        }

        // anything unhandled
        exception<Throwable> { call, cause ->
            call.application.log.error("Unhandled error", cause)
            call.respond(HttpStatusCode.InternalServerError, ErrorResponse("Something went wrong"))
        }

        // unknown url
        status(HttpStatusCode.NotFound) {call, _ ->
            call.respond(HttpStatusCode.NotFound, ErrorResponse("Unknown API route"))
        }
    }
}
