package com.audronf.compose.model

data class Movie(
    val image: String,
    val name: String,
    val age: String,
    val duration: String,
    val genre: String,
    val synopsis: String,
    val stars: Double
) {
    val wholePart: Int
        get() = stars.toString().split('.').first().toInt()

    val decimalPart: Int
        get() = stars.toString().split('.')[1].toInt()
}
