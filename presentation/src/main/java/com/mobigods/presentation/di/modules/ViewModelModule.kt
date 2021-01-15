package com.mobigods.presentation.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mobigods.core.di.keys.ViewModelKey
import com.mobigods.presentation.viewmodels.AkwukwoViewModelFactory
import com.mobigods.presentation.viewmodels.dashboard.DashBoardViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
abstract class ViewModelModule {

    @Binds
    @Singleton
    abstract fun bindToViewModelFactory(
        factory: AkwukwoViewModelFactory
    ): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(DashBoardViewModel::class)
    abstract fun bindDashBoardViewModel(
        viewModel: DashBoardViewModel
    ): ViewModel



}