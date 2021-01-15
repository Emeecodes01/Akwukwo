package com.mobigods.remote.modules

import com.google.gson.Gson
import com.mobigods.remote.utils.gson
import dagger.Module
import dagger.Provides
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ConverterFactoryModule {

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return gson {  }
    }


    @Provides
    @Singleton
    fun provideConverterFactory(gson: Gson): GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }

}