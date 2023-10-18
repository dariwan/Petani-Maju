package com.dariwan.petanimaju.view.shop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dariwan.petanimaju.R
import com.dariwan.petanimaju.databinding.ActivityStrukBinding

class BerhasilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_berhasil)
    }

    class BerhasilActivity : AppCompatActivity() {
        private lateinit var binding: ActivityStrukBinding
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityStrukBinding.inflate(layoutInflater)
            setContentView(binding.root)

            setupAction()
        }

        private fun setupAction() {
            binding.button1.setOnClickListener {
                val intent = Intent(this, StrukActivity::class.java)
                startActivity(intent)
            }
        }
    }
}