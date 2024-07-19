package com.example.apitask

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginRepository {
    private val apiService = RetrofitHelper.apiService

    fun loginUser(request: Request): LiveData<Result<UserLoginResponse>> {
        val loginResult = MutableLiveData<Result<UserLoginResponse>>()

        apiService.apiService(request).enqueue(object :Callback<UserLoginResponse>{
            override fun onResponse(
                call: Call<UserLoginResponse>,
                response: Response<UserLoginResponse>
            ) {
                Log.d("API Response", response.body()?.toString() ?: "No response body")
                if (response.isSuccessful) {
                    response.body().let {
                        loginResult.value = Result.success(it!!)
                    }

                    Log.e("Tag123",response.body().toString())
                } else {
                    loginResult.value = Result.failure(Throwable("Error code: ${response.code()}"))
                    Log.e("Tag123",response.message().toString())
                }
            }

            override fun onFailure(call: Call<UserLoginResponse>, t: Throwable) {
                Log.e("Tag123",t.message.toString())
            }

        })
        return loginResult
    }
}
