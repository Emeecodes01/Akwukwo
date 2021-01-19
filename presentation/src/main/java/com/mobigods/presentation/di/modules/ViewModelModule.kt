package com.mobigods.presentation.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mobigods.core.di.keys.ViewModelKey
import com.mobigods.presentation.viewmodels.AkwukwoViewModelFactory
import com.mobigods.presentation.viewmodels.chapter.ChapterViewModel
import com.mobigods.presentation.viewmodels.dashboard.DashBoardViewModel
import com.mobigods.presentation.viewmodels.player.PlayerViewModel
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


    @Binds
    @IntoMap
    @ViewModelKey(PlayerViewModel::class)
    abstract fun bindPlayerViewModel(
        viewModel: PlayerViewModel
    ): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ChapterViewModel::class)
    abstract fun bindChapterViewModel(
        viewModel: ChapterViewModel
    ): ViewModel
}