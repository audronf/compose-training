package com.audronf.compose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.audronf.compose.R
import com.audronf.compose.model.Movie

@Composable
fun MovieRate(movie: Movie) {
    var ent = movie.wholePart
    var dec = movie.decimalPart
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        LazyRow(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
            items(5) {
                when {
                    ent != 0 -> {
                        Image(
                            painter = painterResource(id = R.drawable.ic_star),
                            contentDescription = ""
                        )
                        ent--
                    }
                    dec != 0 -> {
                        Box {
                            Image(
                                painter = painterResource(id = R.drawable.ic_half_star),
                                contentDescription = ""
                            )
                            Image(
                                painter = painterResource(id = R.drawable.ic_empty_star),
                                contentDescription = ""
                            )
                        }

                        dec = 0
                    }
                    else -> {
                        Image(
                            painter = painterResource(id = R.drawable.ic_empty_star),
                            contentDescription = ""
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = movie.stars.toString(), fontSize = 12.sp, fontWeight = FontWeight.Light)
    }
}
