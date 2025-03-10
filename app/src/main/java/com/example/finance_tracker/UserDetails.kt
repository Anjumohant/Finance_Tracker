package com.example.finance_tracker

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.finance_tracker.databinding.ActivityUserDetailsBinding

class UserDetails: AppCompatActivity() {
    lateinit var binding: ActivityUserDetailsBinding
    lateinit var userDetails: SharedPreferences
    var isFirstTime:Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        setData()
        setTheme(R.style.Base_Theme_Finance_Tracker)
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        binding = ActivityUserDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    private fun setData() {
        userDetails = this.getSharedPreferences("UserDetails", AppCompatActivity.MODE_PRIVATE)
        isFirstTime = userDetails.getBoolean("isFirstTime",true)
        if (!isFirstTime){
            goToNextScreen()
            finish()
        }
    }

    private fun goToNextScreen() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}