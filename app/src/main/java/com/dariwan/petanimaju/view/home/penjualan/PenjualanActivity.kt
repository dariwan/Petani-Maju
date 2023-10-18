package com.dariwan.petanimaju.view.home.penjualan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dariwan.petanimaju.R
import com.dariwan.petanimaju.adapter.SectionPagerAdapter
import com.dariwan.petanimaju.databinding.ActivityPenjualanBinding

class PenjualanActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPenjualanBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPenjualanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupFragment()
    }

    private fun setupFragment() {
        val bundle = Bundle()
        val sectionsPagerAdapter = SectionPagerAdapter(this, supportFragmentManager, bundle)
        binding.apply {
            viewPager.adapter = sectionsPagerAdapter
            tabs.setupWithViewPager(viewPager)
        }
    }
}