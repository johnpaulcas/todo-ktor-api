package com.johnpaulcas.core.error

sealed class AppException(message: String) : RuntimeException(message) {
    class Validation(message: String) : AppException(message)

    class Conflict(message: String) : AppException(message)

    class NotFound(message: String) : AppException(message)
}