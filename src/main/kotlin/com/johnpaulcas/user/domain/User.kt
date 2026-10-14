package com.johnpaulcas.user.domain

import java.time.Instant
import java.util.UUID

data class User(
    val id: UUID,
    val email: String,
    val createdAt: Instant
)