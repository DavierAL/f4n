@file:OptIn(ExperimentalMaterial3Api::class)

package com.f4n.View
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.f4n.R


@Preview(showSystemUi = true)
@Composable
fun DashBoardView() {
    Scaffold (
        topBar = { myTopBar()},
        content = { innerPadding ->
            Surface(modifier = Modifier.padding(innerPadding)) {
                myContent()
            }
        },
        bottomBar = { myBottomBar()},
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun myTopBar() {
    TopAppBar(
        modifier = Modifier.fillMaxWidth(),
        title = {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.f4nlogo),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .size(100.dp)   // Mismo tamaño que el ícono
                        .padding(10.dp)
                        .offset(y = 9.dp),
                    contentScale = ContentScale.Fit
                )

                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Buscar",
                    tint = Color.White,
                    modifier = Modifier
                        .size(70.dp)   // Mismo tamaño que la imagen
                        .padding(10.dp).
                        offset(y = -10.dp)
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF161616),
            titleContentColor = Color(0xFFFFFFFF)
        )
    )
}

@Composable
fun myContent() {

}

@Composable
fun myBottomBar() {
    BottomAppBar(
        modifier = Modifier.height(120.dp),
        containerColor = Color(0xFF161616),
        contentColor = Color(0xFFFFFFFF),
        actions = {
            Box() {
                Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 30.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Outlined.Home,
                            contentDescription = null,
                            tint = Color(0xFFFFFFFF), modifier =
                            Modifier.size(50.dp)
                        )
                    }
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Outlined.Person,
                            contentDescription = null,
                            modifier =
                            Modifier.size(50.dp)
                        )
                    }
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Outlined.FavoriteBorder,
                            contentDescription = null,
                            tint = Color(0xFFFFFFFF), modifier =
                            Modifier.size(50.dp)
                        )
                    }
                }
            }
        },
    )
}


