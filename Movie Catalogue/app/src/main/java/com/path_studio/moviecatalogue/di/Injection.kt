package com.path_studio.moviecatalogue.di

import android.content.Context
import com.path_studio.moviecatalogue.data.TmdbRepository
import com.path_studio.moviecatalogue.data.source.local.LocalDataSource
import com.path_studio.moviecatalogue.data.source.local.room.TmdbDatabase
import com.path_studio.moviecatalogue.data.source.remote.RemoteDataSource
import com.path_studio.moviecatalogue.util.AppExecutors

object Injection {
    fun provideImdbRepository(context: Context): TmdbRepository {

        val database = TmdbDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance()
        val localDataSource = LocalDataSource.getInstance(database.tmdbDao())
        val appExecutors = AppExecutors()

        return TmdbRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}