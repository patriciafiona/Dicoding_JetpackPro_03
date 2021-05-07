package com.path_studio.moviecatalogue.di

import android.content.Context
import com.path_studio.moviecatalogue.data.source.TmdbRepository
import com.path_studio.moviecatalogue.data.source.remote.RemoteDataSource

object Injection {
    fun provideImdbRepository(context: Context): TmdbRepository {
        val remoteDataSource = RemoteDataSource.getInstance()
        return TmdbRepository.getInstance(remoteDataSource)
    }
}