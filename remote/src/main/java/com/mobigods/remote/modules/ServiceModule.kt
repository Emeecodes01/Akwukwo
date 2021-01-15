package com.mobigods.remote.modules

import com.mobigods.remote.services.AkwukwoContentService
import com.mobigods.remote.utils.service
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton


@Module(includes = [RetrofitModule::class])
class ServiceModule {

    @Provides
    @Singleton
    fun provideAuthServiceService(retrofit: Retrofit):
            AkwukwoContentService {
        return service(retrofit)
    }

}