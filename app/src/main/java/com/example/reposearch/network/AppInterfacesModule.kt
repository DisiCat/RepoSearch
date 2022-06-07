package com.example.reposearch.network

import com.example.reposearch.localapi.ILoginLocalApi
import com.example.reposearch.localapi.LoginLocalApi
import com.example.reposearch.repository.interfaces.ILoginRepository
import com.example.reposearch.repository.LoginRepository
import com.example.reposearch.repository.SearchRepository
import com.example.reposearch.repository.interfaces.ISearchRepository
import com.example.reposearch.requesters.IRepoRequester
import com.example.reposearch.requesters.RepoRequester
import com.example.reposearch.usecases.interfaces.ILoginUseCase
import com.example.reposearch.usecases.LoginUseCase
import com.example.reposearch.usecases.SearchUseCase
import com.example.reposearch.usecases.interfaces.ILoginObserverUseCase
import com.example.reposearch.usecases.interfaces.ISearchUseCase
import com.example.reposearch.usecases.observerUseCases.LoginObserverUseCase
import com.example.reposearch.utils.ISharedPreferencesUtils
import com.example.reposearch.utils.SharedPreferencesUtils
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

    @Binds
    abstract fun bindSearchUseCase(impl: SearchUseCase): ISearchUseCase

    //region Repository
    @Binds
    abstract fun bindLoginRepository(impl: LoginRepository): ILoginRepository

    @Binds
    abstract fun bindSearchRepository(impl: SearchRepository): ISearchRepository

    //region LocalApi
    @Binds
    abstract fun bindLoginLocalApi(impl: LoginLocalApi): ILoginLocalApi

    //requester
    @Binds
    abstract fun bindRepoRequester(impl: RepoRequester): IRepoRequester

    //utils
    @Binds
    abstract fun bindSharedPreferenceUtils(impl: SharedPreferencesUtils) : ISharedPreferencesUtils
}