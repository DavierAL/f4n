package com.f4n.View

data class PlayerData(
    val name: String,
    val team: String,
    val nationality: String,
    val birthDate: String,
    val height: String,
    val gamesPlayed: Int,
    val goals: Int,
    val assists: Int,
    val yellowCards: Int,
    val redCards: Int,
    val lastMatch: LastMatch
)

data class LastMatch(
    val date: String,
    val opponent: String,
    val score: String,
    val playerGoals: Int,
    val minutes: Int,
    val rating: Double
)