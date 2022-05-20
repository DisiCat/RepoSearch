package com.example.reposearch.network

import com.example.reposearch.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppInterfacesModule {
    //region UseCases
    @Binds
    abstract fun bindLoginUseCase(impl: LoginUseCase): ILoginUseCase

    //region Repository
    @Binds
    abstract fun bindLoginRepository(impl: LoginRepository): ILoginRepository

    //region LocalApi
    @Binds
    abstract fun bindLoginLocalApi(impl: LoginLocalApi): ILoginLocalApi
}