package com.mobigods.akwkw.di.component

import com.mobigods.akwkw.AkwukwoApp
import com.mobigods.akwkw.di.modules.ActivityInjectorModules
import com.mobigods.cache.module.LocalImplModule
import com.mobigods.core.di.component.CoreComponent
import com.mobigods.presentation.di.modules.ViewModelModule
import com.mobigods.remote.modules.RemoteImplModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton


@Component(
    dependencies = [CoreComponent::class],
    modules = [ AndroidInjectionModule::class, ViewModelModule::class, ActivityInjectorModules::class,
        LocalImplModule::class, RemoteImplModule::class ]
)
@Singleton
interface AppComponent: AndroidInjector<AkwukwoApp>