package com.dariwan.petanimaju.view.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dariwan.petanimaju.R
import com.dariwan.petanimaju.databinding.ActivitySplashScreenBinding
import com.dariwan.petanimaju.view.MainActivity

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setupAction()
    }

    private fun setupAction() {
        binding.btnSplashscreen.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}