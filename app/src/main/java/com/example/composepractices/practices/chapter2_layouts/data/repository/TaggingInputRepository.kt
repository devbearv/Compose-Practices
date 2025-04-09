package com.example.composepractices.practices.chapter2_layouts.data.repository

import com.example.composepractices.practices.chapter2_layouts.data.models.TaggingInputUser
import javax.inject.Inject

class TaggingInputRepository @Inject constructor(private val taggingInputDataSource: TaggingInputDataSource) {

    fun getAllUsers(): List<TaggingInputUser> {
        return taggingInputDataSource.users
    }
}