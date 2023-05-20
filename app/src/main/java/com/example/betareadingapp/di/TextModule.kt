package com.example.betareadingapp.di

import android.app.Application
import android.content.Context

import com.example.betareadingapp.feature_text.data.repository.AuthRepository
import com.example.betareadingapp.feature_text.data.repository.UserRepositoryImpl
import com.example.betareadingapp.feature_text.domain.repository.TextRepository
import com.example.betareadingapp.feature_text.domain.repository.UserRepository
import com.example.betareadingapp.feature_text.domain.use_case.DeleteText
import com.example.betareadingapp.feature_text.domain.use_case.FilterTexts
import com.example.betareadingapp.feature_text.domain.use_case.GetTexts
import com.example.betareadingapp.feature_text.domain.use_case.TextUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TextModule {
    @Provides
    @Singleton
    fun provideContext(@ApplicationContext appContext: Context): Context {
        return appContext
    }



    @Provides
    @Singleton
    fun provideTextUseCases(repository: TextRepository): TextUseCases{
        return TextUseCases(
            getTexts = GetTexts(repository),
            deleteText = DeleteText(repository),
            filterTexts = FilterTexts()
        )
    }

    @Provides
    @Singleton
    fun provideUserRepository() : UserRepository{
        return UserRepositoryImpl()
    }

}