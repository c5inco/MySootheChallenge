package com.example.androiddevchallenge.ui

import com.example.androiddevchallenge.R

data class CollectionItem(
    val title: String,
    val imageId: Int
)

val SampleCollectionItems = listOf(
    CollectionItem(title = "Short mantras", imageId = R.drawable.inversions),
    CollectionItem(title = "Stress and anxiety", imageId = R.drawable.stress_and_anxiety),
    CollectionItem(title = "Overwhelmed", imageId = R.drawable.overwhelmed),
    CollectionItem(title = "Nature meditations", imageId = R.drawable.nature_meditations),
    CollectionItem(title = "Self-massage", imageId = R.drawable.self_massage),
    CollectionItem(title = "Nightly wind down", imageId = R.drawable.nightly_wind_down)
)

data class AlignBodyItem(
    val title: String,
    val imageId: Int
)

val SampleAlignBodyItems = listOf(
    AlignBodyItem(title = "Inversions", imageId = R.drawable.inversions),
    AlignBodyItem(title = "Quick yoga", imageId = R.drawable.quick_yoga),
    AlignBodyItem(title = "Stretching", imageId = R.drawable.stretching),
    AlignBodyItem(title = "Tabata", imageId = R.drawable.tabata),
    AlignBodyItem(title = "HIIT", imageId = R.drawable.hiit),
    AlignBodyItem(title = "Pre-natal yoga", imageId = R.drawable.pre_natal_yoga)
)

data class AlignMindItem(
    val title: String,
    val imageId: Int
)

val SampleAlignMindItems = listOf(
    AlignMindItem(title = "Meditate", imageId = R.drawable.meditate),
    AlignMindItem(title = "With kids", imageId = R.drawable.with_kids),
    AlignMindItem(title = "Aromatherapy", imageId = R.drawable.aromatherapy),
    AlignMindItem(title = "On the go", imageId = R.drawable.on_the_go),
    AlignMindItem(title = "With pets", imageId = R.drawable.with_pets),
    AlignMindItem(title = "High stress", imageId = R.drawable.high_stress)
)