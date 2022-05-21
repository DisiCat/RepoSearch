package com.example.reposearch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reposearch.data.AccessToken
import com.example.reposearch.enums.EResultType
import com.example.reposearch.usecases.ILoginUseCase
import com.example.reposearch.usecases.observerUseCases.ILoginObserverUseCase
import com.example.reposearch.usecases.observerUseCases.LoginObserverUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: ILoginUseCase,
    private val loginObserverUseCase: ILoginObserverUseCase
) : ViewModel() {

    private val state = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())
    val githubAuthURLFull =
        AppDefaultValues.AUTH_URL + "?client_id=" + AppDefaultValues.CLIENT_ID + "&scope=" + AppDefaultValues.SCOPE + "&redirect_uri=" + AppDefaultValues.REDIRECT_URI + "&state=" + state

    private val _resultType = MutableLiveData<EResultType>()
    val resultType: LiveData<EResultType>
        get() = _resultType

    init {
        viewModelScope.launch {
            loginObserverUseCase.subscribeToken().collect{
                _resultType.value = it
            }
        }
    }

    fun getAccessToken(code: String){
        viewModelScope.launch {
            loginUseCase.getAccessToken(code)
        }
    }
}