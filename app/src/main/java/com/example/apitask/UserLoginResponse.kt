package com.example.apitask

data class UserLoginResponse(
    val status: Boolean,
    val message: Any,
    val profile: Profile,
    val token: String
)


data class Profile(
    val id: Int,
    val email: String,
    val first_name: String,
    val last_name: String,
    val user_name: String,
    val user_id: String,
    val badge_number: String,
    val mobile_number: String,
    val profile_image: String
)