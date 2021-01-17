package com.mobigods.akwkw

import android.app.Application
import com.mobigods.akwkw.di.component.DaggerAppComponent
import com.mobigods.core.di.component.CoreComponent
import com.mobigods.core.di.component.DaggerCoreComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class AkwukwoApp: DaggerApplication() {

    private val coreComponent by lazy {
        DaggerCoreComponent.builder()
            .addContext(this)
            .build()
    }

    private val appComponent by lazy {
        DaggerAppComponent.builder().coreComponent(coreComponent)
            .build()
    }


    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return appComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }
}