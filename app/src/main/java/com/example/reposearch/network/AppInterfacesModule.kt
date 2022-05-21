package com.example.reposearch.network

import com.example.reposearch.localapi.ILoginLocalApi
import com.example.reposearch.localapi.LoginLocalApi
import com.example.reposearch.repository.ILoginRepository
import com.example.reposearch.repository.LoginRepository
import com.example.reposearch.usecases.ILoginUseCase
import com.example.reposearch.usecases.LoginUseCase
import com.example.reposearch.usecases.observerUseCases.ILoginObserverUseCase
import com.example.reposearch.usecases.observerUseCases.LoginObserverUseCase
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
    @Binds
    abstract fun bindLoginObserverUseCase(impl: LoginObserverUseCase): ILoginObserverUseCase

    //region Repository
    @Binds
    abstract fun bindLoginRepository(impl: LoginRepository): ILoginRepository

    //region LocalApi
    @Binds
    abstract fun bindLoginLocalApi(impl: LoginLocalApi): ILoginLocalApi
}