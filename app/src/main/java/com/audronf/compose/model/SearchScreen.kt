package com.audronf.compose.model

data class SearchScreen(
    val genres: List<Genre>,
    val popular: List<MoviePreview>,
    val acclaimed: List<MoviePreview>
)

