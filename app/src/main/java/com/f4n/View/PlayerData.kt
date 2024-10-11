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

// PlayerSearchData.kt
data class Player(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val team: String,
    val teamLogo: String,
    val followers: String,
    val category: String
)

// FilterOption.kt
enum class FilterOption {
    ALL, TEAM, PLAYER, TOURNAMENT
}