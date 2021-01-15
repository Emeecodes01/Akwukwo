package com.mobigods.akwkw.di.modules

import com.mobigods.akwkw.di.modules.fragments.FragmentInjectorModule
import com.mobigods.akwkw.di.scopes.PerActivity
import com.mobigods.akwkw.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityInjectorModules {

    @PerActivity
    @ContributesAndroidInjector(modules = [FragmentInjectorModule::class])
    abstract fun provideMainActivityInjector(): MainActivity

}