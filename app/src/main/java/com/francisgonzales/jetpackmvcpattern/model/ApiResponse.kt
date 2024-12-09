package com.francisgonzales.jetpackmvcpattern.model

data class ApiResponse(
    val success: Boolean,
    val testing: Boolean,
    val notes: List<Note>
)