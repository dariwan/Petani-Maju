package com.dariwan.petanimaju.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.dariwan.petanimaju.R
import com.dariwan.petanimaju.view.home.penjualan.harga.HargaFragment
import com.dariwan.petanimaju.view.home.penjualan.pasar.PasarFragment

class SectionPagerAdapter(private val mCtx: Context, fm: FragmentManager, data: Bundle) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    private val TAB_TITLES = intArrayOf(
        R.string.pasar,
        R.string.harga
    )

    private var fragmentBundle: Bundle

    init {
        fragmentBundle = data
    }

    @SuppressLint("ResourceType")
    @StringRes
    override fun getCount(): Int = 2

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = PasarFragment()
            1 -> fragment = HargaFragment()
        }
        fragment?.arguments = this.fragmentBundle
        return fragment as Fragment
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mCtx.resources.getString(TAB_TITLES[position])
    }
}