package com.dariwan.petanimaju.view.shop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dariwan.petanimaju.databinding.ActivityBayar2Binding
import com.dariwan.petanimaju.databinding.ActivityBayarBinding

class BayarActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBayar2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBayar2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        setupAction()
    }
    private fun setupAction() {
        binding.btnBayar.setOnClickListener {
            val intent = Intent(this, BerhasilActivity::class.java)
            startActivity(intent)
        }
    }
}