package com.example.reposearch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reposearch.data.AccessToken
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    private val state = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())
    val githubAuthURLFull =
        AppDefaultValues.AUTH_URL + "?client_id=" + AppDefaultValues.CLIENT_ID + "&scope=" + AppDefaultValues.SCOPE + "&redirect_uri=" + AppDefaultValues.REDIRECT_URI + "&state=" + state

    private val _accessToken = MutableLiveData<AccessToken>()
    val accessToken: LiveData<AccessToken>
        get() = _accessToken

    fun getAccessToken(code: String){
        viewModelScope.launch {
            _accessToken.value = // get token
        }
    }
}