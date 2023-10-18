package com.dariwan.petanimaju.view.shop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.dariwan.petanimaju.R
import com.dariwan.petanimaju.adapter.TokoAdapter
import com.dariwan.petanimaju.databinding.ActivityTokoBinding
import com.dariwan.petanimaju.model.TokoModel

class TokoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTokoBinding
    private lateinit var tokoAdapter: TokoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTokoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupAction()
    }

    private fun setupAction() {
        binding.rvToko.layoutManager = LinearLayoutManager(this)
        val dataList: MutableList<TokoModel> = mutableListOf()
        val tokoTitle: Array<String> = resources.getStringArray(R.array.name_toko)
        val tokoAddres: Array<String> = resources.getStringArray(R.array.almt_toko)

        val tokoImage : List<Int> = listOf(
            R.drawable.toko_1,
            R.drawable.toko_2,
            R.drawable.toko_3,
            R.drawable.toko_4,
            R.drawable.toko_5,
        )

        tokoTitle.forEachIndexed { index, name ->
            dataList.add(TokoModel(tokoImage[index], name, tokoAddres[index]))
        }
        tokoAdapter = TokoAdapter(dataList)
        binding.rvToko.adapter = tokoAdapter
    }
}