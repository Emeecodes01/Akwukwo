package com.mobigods.akwkw.di.modules.fragments

import com.mobigods.akwkw.di.scopes.PerFragment
import com.mobigods.akwkw.ui.chapter.ChapterFragment
import com.mobigods.akwkw.ui.subject.DashboardFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class FragmentInjectorModule {

    @PerFragment
    @ContributesAndroidInjector
    abstract fun provideDashBoardFragmentInjector(): DashboardFragment


    @PerFragment
    @ContributesAndroidInjector
    abstract fun provideChapterFragmentInjector(): ChapterFragment


}