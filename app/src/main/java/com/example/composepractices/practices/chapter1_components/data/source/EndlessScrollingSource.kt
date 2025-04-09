package com.example.composepractices.practices.chapter1_components.data.source

import com.example.composepractices.practices.chapter1_components.data.models.ItemListModel
import javax.inject.Inject

class EndlessScrollingSource @Inject constructor() {

    private var lastItePmosition: Int? = null

    internal fun fetchItems(limit: Int = 5): List<ItemListModel> {
        // simulate insertion data
//        val generateList =
//        return

        return emptyList()
    }
}