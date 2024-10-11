package com.example.futbol

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.futbol.ui.theme.FutbolTheme

class TERCERAPANTALLA : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FutbolTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        TopSection()
        LeagueSection()
        UpcomingMatchesSection()
        ResultsSection()
    }
}

@Composable
fun TopSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Logo
            Image(
                painter = painterResource(id = R.drawable.logo), // Reemplaza con el logo adecuado
                contentDescription = "Logo",
                modifier = Modifier.size(100.dp)
            )

            // Icono de búsqueda
            IconButton(
                onClick = { /* Acción de búsqueda */ },
                modifier = Modifier.size(35.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.buscador), // Reemplaza con el ícono de búsqueda
                    contentDescription = "Buscar",
                    tint = Color.White,
                    modifier = Modifier.size(70.dp)
                )
            }
        }

        // Imagen que contiene todos los logos de equipos
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF00D084))
                .padding(vertical = 8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.clubes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp) // Ajusta el tamaño según tus necesidades
            )
        }
    }
}

@Composable
fun LeagueSection() {
    Text(
        text = "LIGAS POPULARES",
        color = Color.White,
        modifier = Modifier.padding(vertical = 8.dp)
    )

    // Fila para las ligas populares
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Agrega las imágenes de las ligas populares
        LeagueLogo(R.drawable.premier) // Reemplaza con el logo de la liga
        LeagueLogo(R.drawable.mls) // Reemplaza con el logo de la liga
        LeagueLogo(R.drawable.liga) // Reemplaza con el logo de la liga
        LeagueLogo(R.drawable.copa) // Reemplaza con el logo de la liga
    }
}

@Composable
fun LeagueLogo(resourceId: Int) {
    Image(
        painter = painterResource(id = resourceId),
        contentDescription = null,
        modifier = Modifier.size(40.dp) // Tamaño de los logos de ligas
    )
}

@Composable
fun UpcomingMatchesSection() {
    Text(
        text = "PRÓXIMOS PARTIDOS",
        color = Color.White,
        modifier = Modifier.padding(vertical = 8.dp)
    )

    // Imagen que contiene ambos partidos
    Image(
        painter = painterResource(id = R.drawable.proximos), // Cambia por la imagen que contiene ambos partidos
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp) // Ajusta el tamaño según tus necesidades
            .padding(vertical = 8.dp) // Espaciado vertical
    )
}

@Composable
fun ResultsSection() {
    Text(
        text = "RESULTADOS DE PARTIDOS",
        color = Color.White,
        modifier = Modifier.padding(vertical = 8.dp)
    )

    // Imagen que contiene los resultados de los partidos
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.resultado), // Imagen que contiene los resultados
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp) // Ajusta el tamaño según tus necesidades
        )
    }
}

@Composable
fun ResultItem(team1: String, score1: String, score2: String, team2: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = team1, color = Color.White, modifier = Modifier.weight(1f))
        Text(text = "$score1 - $score2", color = Color.White)
        Text(text = team2, color = Color.White, modifier = Modifier.weight(1f))
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    MainScreen()
}
