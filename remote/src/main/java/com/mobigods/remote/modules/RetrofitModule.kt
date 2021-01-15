package com.mobigods.remote.modules

import com.mobigods.remote.BuildConfig
import com.mobigods.remote.utils.retrofit
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module(includes = [
    OkhttpModule::class,
    ConverterFactoryModule::class,
    InterceptorModule::class
])
class RetrofitModule {

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gson: GsonConverterFactory
    ): Retrofit {
        return retrofit {
            baseUrl(BuildConfig.BASE_URL)
            addConverterFactory(gson)
            client(okHttpClient)
        }
    }

}