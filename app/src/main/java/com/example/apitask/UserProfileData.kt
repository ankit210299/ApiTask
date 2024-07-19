package com.example.apitask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class UserProfileData : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile_data)
        val profileImageView: ImageView = findViewById(R.id.profile_image)
        val nameTextView: TextView = findViewById(R.id.name)
        val emailTextView: TextView = findViewById(R.id.email)
        val phoneTextView: TextView = findViewById(R.id.phone)

        val email = intent.getStringExtra("user_email")
        val userName = intent.getStringExtra("user_name")
        val mobileNumber = intent.getStringExtra("user_phone")
        val profileImage = intent.getStringExtra("user_profile_image_url")


        val fullName = userName
        nameTextView.text = fullName
        emailTextView.text = email
        phoneTextView.text = mobileNumber


        if (profileImage.isNullOrEmpty()) {
            profileImageView.setImageResource(R.drawable.baseline_person_off_24)
        } else {
            Glide.with(this)
                .load(profileImage)
                .placeholder(R.drawable.baseline_person_24)
                .into(profileImageView)
        }
    }
}