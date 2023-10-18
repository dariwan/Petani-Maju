package com.dariwan.petanimaju.view.shop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dariwan.petanimaju.databinding.ActivityBayarBinding

class BayarActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBayarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBayarBinding.inflate(layoutInflater)
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