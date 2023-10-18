package com.dariwan.petanimaju.view.shop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dariwan.petanimaju.R
import com.dariwan.petanimaju.databinding.ActivityBerhasilBinding
import com.dariwan.petanimaju.databinding.ActivityStrukBinding

class BerhasilActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBerhasilBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBerhasilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupAction()
    }

    private fun setupAction() {
        binding.btnBerhasil.setOnClickListener {
            val intent = Intent(this, StrukActivity::class.java)
            startActivity(intent)
        }
    }
}
