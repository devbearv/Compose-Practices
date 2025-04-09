package com.example.composepractices.practices.chapter1_components.ui.practice1_2_endless_scrolling

import androidx.lifecycle.ViewModel
import com.example.composepractices.practices.chapter1_components.data.models.ItemListModel
import com.example.composepractices.practices.chapter1_components.domain.repository.EndlessScrollingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class EndlessScrollingViewModel @Inject constructor(
    private val endlessScrollingRepository: EndlessScrollingRepository
): ViewModel() {

    private val _listItems = MutableStateFlow<List<ItemListModel>>(emptyList<ItemListModel>())
    val listItems: StateFlow<List<ItemListModel>> = _listItems.asStateFlow()



}