package com.f4n.View

import androidx.compose.foundation.Image
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.futbol.R


@Composable
fun infoTeamView(){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,//Alinear a los extremos
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.loguito ),
                contentDescription = "login logo",
                modifier = Modifier.size(60.dp))
            Column (
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.End
            ){
                Image(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "Share",
                modifier = Modifier.size(34.dp)
            )}

            Spacer(modifier = Modifier.height(24.dp))}

        //fila extremos
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween //  // Alinear logo y texto a extremos
        ){//logo del equipo
            Image(
                painter = painterResource(id = R.drawable.logo_real_madrid),
                contentDescription = "Team logo",
                modifier = Modifier.size(150.dp)
            )
            Column (
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ){ //Info del equipo
                Text(
                    text = "FC REAL MADRID",
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "6 MARZO 1902\n122 AÑOS",
                    color = Color(0xFF00FF00),
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center
                )
            }
        }

        Spacer(modifier = Modifier.height(6.dp))

        //Contiene el estadio y jugadores superpuestos
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.santiago_bernabeu),
                contentDescription = "Estadio img",
                modifier = Modifier
                    .size(200.dp)
                    .align(Alignment.TopEnd)
            )
            Column(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(start = 8.dp)
            ) {
                Text(
                    text = "JUGADORES",
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(50.dp))

                // Primera fila de jugadores
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    PlayerCard(R.drawable.carvajal, "CARVAJAL")
                    PlayerCard(R.drawable.modric, "MODRIC")
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Segunda fila de jugadores
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    PlayerCard(R.drawable.vini_jr, "VINI JR")
                    PlayerCard(R.drawable.rodrygo, "RODRIGO")
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))
        // Menú inferior
        BottonMenu()
    }
}



@Composable
fun PlayerCard(playerImage: Int, playerName: String) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(id = playerImage),
            contentDescription = playerName,
            modifier = Modifier
                .size(60.dp)
                .background(Color.Transparent)
        )
        Text(text = playerName, color = Color.White, fontSize = 7.sp)
    }

}
@Composable
fun BottonMenu(){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(9.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ){
        //Home Icono
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_home),
                contentDescription = "Home",
                modifier = Modifier.size(30.dp)
            )
            Text(text = "Home", color = Color.White, fontSize = 10.sp)
        }
        //Home Profile
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_profile),
                contentDescription = "Profile",
                modifier = Modifier.size(30.dp)
            )
            Text(text = "Perfil", color = Color.White, fontSize = 10.sp)
        }
        //Home logout
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_logout),
                contentDescription = "Home",
                modifier = Modifier.size(30.dp)
            )
            Text(text = "Logout", color = Color.White, fontSize = 10.sp)

        }
    }
}
