package com.f4n.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.futbol.R


@Composable
fun PlayerSearchScreen(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF161616))
    ) {
        SearchHeader(onBackClick)
        FilterSection()
        PlayerList()
    }
}

@Composable
fun SearchHeader(onBackClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = onBackClick) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = Color.White
            )
        }

        Box(
            modifier = Modifier
                .weight(1f)
                .height(40.dp)
                .background(
                    color = Color(0xFF262626),
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(horizontal = 8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = Color.Gray
                )

                Text(
                    text = "Erling Haaland",
                    color = Color.White,
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 8.dp)
                )

                IconButton(
                    onClick = { /* Clear search */ }
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Clear",
                        tint = Color.Gray
                    )
                }
            }
        }
    }
}

@Composable
fun FilterSection() {
    var selectedFilter by remember { mutableStateOf(FilterOption.ALL) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        FilterOption.values().forEach { filter ->
            FilterChip(
                filter = filter,
                isSelected = selectedFilter == filter,
                onSelected = { selectedFilter = filter }
            )
        }
    }
}

@Composable
fun FilterChip(
    filter: FilterOption,
    isSelected: Boolean,
    onSelected: () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(
                if (isSelected) Color(0xFF3D3D3D)
                else Color(0xFF262626)
            )
            .clickable(onClick = onSelected)
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = filter.name.lowercase()
                .replaceFirstChar { it.uppercase() },
            color = if (isSelected) Color.White else Color.Gray,
            fontSize = 14.sp
        )
    }
}

@Composable
fun PlayerList() {
    val players = remember {
        listOf(
            Player(
                id = 1,
                name = "Erling Haaland",
                imageUrl = "haaland_image",
                team = "Manchester City",
                teamLogo = "city_logo",
                followers = "206k",
                category = "soccer"
            ),
            Player(
                id = 2,
                name = "Harry Kane",
                imageUrl = "kane_image",
                team = "Bayern München",
                teamLogo = "bayern_logo",
                followers = "206k",
                category = "soccer"
            )
        )
    }

    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        items(players) { player ->
            PlayerListItem(player)
        }
    }
}

@Composable
fun PlayerListItem(player: Player) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Player Image
        Image(
            painter = painterResource(id = R.drawable.rodrygo),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        // Player Info
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 12.dp)
        ) {
            Text(
                text = player.name,
                color = Color.White,
                fontSize = 16.sp
            )

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.vini_jr),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )

                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = player.team,
                    color = Color.Gray,
                    fontSize = 14.sp
                )
            }
        }

        // Followers
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = null,
                tint = Color.Gray,
                modifier = Modifier.size(16.dp)
            )

            Spacer(modifier = Modifier.width(4.dp))

            Text(
                text = player.followers,
                color = Color.Gray,
                fontSize = 14.sp
            )
        }
    }
}