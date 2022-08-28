package com.path_studio.moviecatalogue.di

import com.path_studio.moviecatalogue.data.TmdbRepository
import org.koin.dsl.module

val repoModule = module {
    single { TmdbRepository(get(), get(), get()) }
}
