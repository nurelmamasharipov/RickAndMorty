package com.example.rickandmorty.ui.module

import com.example.rickandmorty.ui.viewModule.CharacterDetailViewModel
import com.example.rickandmorty.ui.viewModule.CharacterViewModule
import com.example.rickandmorty.ui.viewModule.EpisodeViewModule
import com.example.rickandmorty.ui.viewModule.LocationViewModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { CharacterViewModule(get()) }
    viewModel { LocationViewModule(get()) }
    viewModel { EpisodeViewModule(get()) }
    viewModel { CharacterDetailViewModel(get()) }
}