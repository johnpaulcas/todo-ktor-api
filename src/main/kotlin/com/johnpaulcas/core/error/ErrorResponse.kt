package com.johnpaulcas.core.error

import kotlinx.serialization.Serializable

@Serializable
data class ErrorResponse(val error: String)
