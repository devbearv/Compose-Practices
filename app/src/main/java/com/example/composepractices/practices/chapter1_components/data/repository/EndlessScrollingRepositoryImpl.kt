package com.example.composepractices.practices.chapter1_components.data.repository

import com.example.composepractices.practices.chapter1_components.data.models.ItemListModel
import com.example.composepractices.practices.chapter1_components.domain.repository.EndlessScrollingRepository
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class EndlessScrollingRepositoryImpl @Inject constructor(

): EndlessScrollingRepository {

    fun recoveredItemsList(): List<ItemListModel> {
        return emptyList()
    }



}