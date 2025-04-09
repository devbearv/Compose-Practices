package com.example.composepractices.practices.chapter1_components.data.models

import java.util.UUID

data class ItemListModel(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val description: String,
)
