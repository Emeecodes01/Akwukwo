package com.mobigods.remote.modules

import com.mobigods.domain.repository.remote.AkwukwoSubjectsRemoteRepository
import com.mobigods.remote.impl.AkwukwoSubjectsRemoteRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module(includes = [ServiceModule::class])
abstract class RemoteImplModule {

    @Binds
    @Singleton
    abstract fun bindSubjectImpl(
        impl: AkwukwoSubjectsRemoteRepositoryImpl
    ): AkwukwoSubjectsRemoteRepository


}