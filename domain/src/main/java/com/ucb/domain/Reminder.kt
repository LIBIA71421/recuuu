package com.ucb.domain

import kotlinx.serialization.Serializable

@Serializable
data class Reminder(
    val name: String,
    val date: String,
    val importance: ImportanceLevel
)

enum class ImportanceLevel {
    NORMAL, IMPORTANT, VERY_IMPORTANT
}
