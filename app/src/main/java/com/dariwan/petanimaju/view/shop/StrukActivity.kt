package com.dariwan.petanimaju.view.shop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dariwan.petanimaju.R
import com.dariwan.petanimaju.databinding.ActivityStrukBinding
import com.dariwan.petanimaju.view.MainActivity
import com.dariwan.petanimaju.view.home.HomeFragment

class StrukActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStrukBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStrukBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDone.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}