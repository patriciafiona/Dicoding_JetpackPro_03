package com.path_studio.moviecatalogue.helper.di

import android.content.Context
import com.path_studio.moviecatalogue.data.source.local.LocalDataSource
import com.path_studio.moviecatalogue.data.source.local.room.TmdbDatabase
import com.path_studio.moviecatalogue.data.source.remote.RemoteDataSource
import com.path_studio.moviecatalogue.util.AppExecutors
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single{ provideDatabase(androidContext()) }
    single{ provideRemoteDataSource() }
    single{ provideLocalDataSource(get()) }
    single { provideAppExecutors() }
}

private fun provideDatabase(context: Context): TmdbDatabase = TmdbDatabase.getInstance(context)
private fun provideRemoteDataSource() = RemoteDataSource.getInstance()
private fun provideLocalDataSource(database:TmdbDatabase) = LocalDataSource.getInstance(database.tmdbDao())
private fun provideAppExecutors() = AppExecutors()