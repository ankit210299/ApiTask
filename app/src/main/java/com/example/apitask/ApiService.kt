package com.example.apitask

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("user/login")
    fun apiService(@Body request: Request):Call<UserLoginResponse>

}