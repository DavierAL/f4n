package com.f4n

import android.os.Bundle
import com.f4n.View.PlayerProfileScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.f4n.View.LastMatch
import com.f4n.View.PlayerData

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val playerData = PlayerData(
                name = "Harry Kane",
                team = "FC BAYERN MÜNCHEN",
                nationality = "Inglaterra",
                birthDate = "28 JUL 1993",
                height = "188 CM",
                gamesPlayed = 542,
                goals = 378,
                assists = 83,
                yellowCards = 55,
                redCards = 0,
                lastMatch = LastMatch(
                    date = "17 SEP",
                    opponent = "Manchester United",
                    score = "4-2",
                    playerGoals = 2,
                    minutes = 90,
                    rating = 9.9
                )
            )

            PlayerProfileScreen(playerData)
        }
    }
}