package com.f4n.View

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.futbol.R


@Composable
fun PlayerProfileScreen(player: PlayerData) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF161616))
    ) {
        PlayerHeader(player)
        PlayerStats(player)
        LastMatchSection(player.lastMatch)
        BottomNavigation()
    }
}

@Composable
fun PlayerHeader(player: PlayerData) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Imagen del jugador con fondo oscuro
        Box(
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .background(Color(0xFF262626))
        ) {
            AsyncImage(
                model = R.drawable.harrykane,
                contentDescription = "Player photo",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Nombre del jugador
        Text(
            text = player.name,
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        // Equipo
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            AsyncImage(
                model = R.drawable.teamlogo,
                contentDescription = "Team logo",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = player.team,
                color = Color.White,
                fontSize = 16.sp
            )
        }
    }
}

@Composable
fun PlayerStats(player: PlayerData) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        // Info básica
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            StatItem("NACIONALIDAD", player.nationality, showFlag = true)
            StatItem("EDAD", "${player.birthDate}\n${calculateAge(player.birthDate)} AÑOS")
            StatItem("ALTURA", player.height)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Estadísticas principales
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            StatItem("PARTIDOS JUGADOS", player.gamesPlayed.toString())
            StatItem("GOLES", player.goals.toString())
            StatItem("ASISTENCIAS", player.assists.toString())
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Tarjetas
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            StatItem("TARJETAS AMARILLAS", player.yellowCards.toString(), Color.Yellow)
            StatItem("TARJETAS ROJAS", player.redCards.toString(), Color.Red)
        }
    }
}

@Composable
fun LastMatchSection(lastMatch: LastMatch) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "ÚLTIMO PARTIDO",
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF262626))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = lastMatch.date,
                        color = Color.White,
                        fontSize = 14.sp
                    )
                    Text(
                        text = "${lastMatch.score} ${lastMatch.opponent}",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Row {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "GOLES",
                            color = Color.Gray,
                            fontSize = 12.sp
                        )
                        Text(
                            text = lastMatch.playerGoals.toString(),
                            color = Color.White,
                            fontSize = 16.sp
                        )
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "MIN",
                            color = Color.Gray,
                            fontSize = 12.sp
                        )
                        Text(
                            text = lastMatch.minutes.toString(),
                            color = Color.White,
                            fontSize = 16.sp
                        )
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .background(Color(0xFF1E5128), CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = lastMatch.rating.toString(),
                                color = Color.White,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun BottomNavigation() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        IconButton(onClick = {  }) {
            Icon(
                Icons.Default.Home,
                contentDescription = "Home",
                tint = Color.White
            )
        }
        IconButton(onClick = { }) {
            Icon(
                Icons.Default.Person,
                contentDescription = "Profile",
                tint = Color.White
            )
        }
        IconButton(onClick = {  }) {
            Icon(
                Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = Color.White
            )
        }
    }
}

@Composable
fun StatItem(
    label: String,
    value: String,
    color: Color = Color.White,
    showFlag: Boolean = false
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = label,
            color = Color.Gray,
            fontSize = 12.sp
        )
        if (showFlag) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Aquí irá la bandera
                Text(
                    text = value,
                    color = color,
                    fontSize = 16.sp
                )
            }
        } else {
            Text(
                text = value,
                color = color,
                fontSize = 16.sp
            )
        }
    }
}

// Función auxiliar para calcular la edad
fun calculateAge(birthDate: String): Int {
    // Implementar lógica para calcular edad
    return 0
}