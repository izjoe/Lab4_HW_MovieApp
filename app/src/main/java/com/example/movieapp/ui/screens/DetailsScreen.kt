package com.example.movieapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Text
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.movieapp.model.Movie
import com.example.movieapp.ui.theme.*

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun DetailsScreen(
    movie: Movie,
    onBackPressed: () -> Unit = {}
) {
    Box(modifier = Modifier.fillMaxSize()) {

        // ── Full-screen backdrop ────────────────────────────────────────────
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(movie.backgroundImageUrl)
                .crossfade(true)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Dark gradient overlay
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.horizontalGradient(
                        0.0f to Color(0xEE000000),
                        0.5f to Color(0xAA000000),
                        1.0f to Color(0x44000000)
                    )
                )
        )

        // ── Left blue accent bar ───────────────────────────────────────────
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(6.dp)
                .background(TvBlue)
        )

        // ── Content ────────────────────────────────────────────────────────
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 64.dp, vertical = 48.dp),
            horizontalArrangement = Arrangement.spacedBy(40.dp)
        ) {

            // Left: Movie poster card
            Box(
                modifier = Modifier
                    .width(240.dp)
                    .height(340.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .border(2.dp, TvBlue, RoundedCornerShape(12.dp))
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(movie.cardImageUrl)
                        .crossfade(true)
                        .build(),
                    contentDescription = movie.title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }

            // Right: Movie info
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                // Studio badge
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(4.dp))
                        .background(TvBlue.copy(alpha = 0.8f))
                        .padding(horizontal = 12.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = movie.studio,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium,
                        color = TextPrimary
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Movie title
                Text(
                    text = movie.title,
                    fontSize = 44.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary,
                    lineHeight = 50.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Category tag
                Text(
                    text = movie.category,
                    fontSize = 16.sp,
                    color = TvBlueLight,
                    fontWeight = FontWeight.Medium
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Description
                Text(
                    text = movie.description,
                    fontSize = 17.sp,
                    color = TextSecondary,
                    lineHeight = 26.sp,
                    modifier = Modifier.widthIn(max = 560.dp)
                )

                Spacer(modifier = Modifier.height(36.dp))

                // Action buttons row
                Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    ActionButton(
                        label = "▶  Play",
                        isPrimary = true,
                        onClick = { /* TODO: launch player */ }
                    )
                    ActionButton(
                        label = "+ Watchlist",
                        isPrimary = false,
                        onClick = { /* TODO: add to watchlist */ }
                    )
                    ActionButton(
                        label = "← Back",
                        isPrimary = false,
                        onClick = onBackPressed
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
private fun ActionButton(
    label: String,
    isPrimary: Boolean,
    onClick: () -> Unit
) {
    var isFocused by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(
                color = when {
                    isFocused && isPrimary -> TvBlueLight
                    isPrimary             -> TvBlue
                    isFocused             -> Color.White.copy(alpha = 0.15f)
                    else                  -> Color.White.copy(alpha = 0.08f)
                }
            )
            .border(
                width = if (!isPrimary) 1.dp else 0.dp,
                color = if (!isPrimary) TvBlue.copy(alpha = 0.6f) else Color.Transparent,
                shape = RoundedCornerShape(8.dp)
            )
            .onFocusChanged { isFocused = it.isFocused }
            .focusable()
            .padding(horizontal = 28.dp, vertical = 14.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = label,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = TextPrimary
        )
    }
}
