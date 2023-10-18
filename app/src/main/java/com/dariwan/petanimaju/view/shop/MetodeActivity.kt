package com.dariwan.petanimaju.view.shop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dariwan.petanimaju.R
import com.dariwan.petanimaju.databinding.ActivityMetodeBinding

class MetodeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMetodeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMetodeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupAction()
    }

    private fun setupAction() {
        binding.btnPayment.setOnClickListener {
            val intent = Intent(this, BayarActivity::class.java)
            startActivity(intent)
        }
    }


}


