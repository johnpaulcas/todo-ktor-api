package com.johnpaulcas.user.route.dto

import com.johnpaulcas.user.domain.User

fun User.toResponse(): UserResponse = UserResponse(
    id = this.id,
    email = this.email,
    createdAt = createdAt.toString()
)