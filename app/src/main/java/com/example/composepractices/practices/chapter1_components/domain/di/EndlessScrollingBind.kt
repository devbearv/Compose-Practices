package com.example.composepractices.practices.chapter1_components.domain.di

import com.example.composepractices.practices.chapter1_components.data.repository.EndlessScrollingRepositoryImpl
import com.example.composepractices.practices.chapter1_components.domain.repository.EndlessScrollingRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class EndlessScrollingBind {

    @Binds
    abstract fun bindEndlessScrollingRepository(
        impl: EndlessScrollingRepositoryImpl
    ): EndlessScrollingRepository
}