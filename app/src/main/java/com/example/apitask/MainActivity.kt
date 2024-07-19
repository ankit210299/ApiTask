package com.example.apitask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private val viewModel: LoginViewModel by lazy {
        ViewModelProvider(this).get(LoginViewModel::class.java)
    }
    lateinit var edtEmail:EditText
    lateinit var edtPassword:EditText
    lateinit var img_password:ImageView
    lateinit var button: Button
    private var isPasswordVisible = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edtEmail=findViewById(R.id.emailEditText)
        edtPassword=findViewById(R.id.passwordEditText)
        img_password=findViewById(R.id.showPassword)
        button=findViewById(R.id.loginButton)

        button.setOnClickListener {
            var email=edtEmail.text.trim().toString()
            var password=edtPassword.text.trim().toString()
            if (email.isNotEmpty() && password.isNotEmpty()) {
                val req = Request(email, password)
                viewModel.login(req).observe(this, Observer { result ->
                    result.onSuccess { response ->
                        navigateToDashboard(response.profile)
                        Log.e("Tag1231", response.toString())
                    }.onFailure { error ->
                        Log.e("Tag1231", error.message.toString())
                    }
                })
            } else {
                Log.e("Tag1231", "Email or Password is empty")
            }
        }


    }
    private fun navigateToDashboard(profile:Profile) {
        val intent = Intent(this, UserProfileData::class.java).apply {
            putExtra("user_name", profile.user_name)
            putExtra("user_email", profile.email)
            putExtra("user_phone", profile.mobile_number)
            putExtra("user_profile_image_url", profile.profile_image)
        }
        startActivity(intent)
    }
}