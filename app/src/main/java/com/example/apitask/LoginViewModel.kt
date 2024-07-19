package com.example.apitask

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LoginViewModel:ViewModel() {
    private val repository = LoginRepository()
   private var _loginResult: LiveData<Result<UserLoginResponse>>? = null

    fun login(request: Request): LiveData<Result<UserLoginResponse>> {
        _loginResult = repository.loginUser(request)
        return _loginResult!!
    }
}