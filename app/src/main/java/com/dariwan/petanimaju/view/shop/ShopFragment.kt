package com.dariwan.petanimaju.view.shop

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.dariwan.petanimaju.R
import com.dariwan.petanimaju.adapter.ShopAdapter
import com.dariwan.petanimaju.databinding.FragmentShopBinding
import com.dariwan.petanimaju.model.ShopModel


class ShopFragment : Fragment() {

    private var _binding: FragmentShopBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentShopBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shop, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAction()
    }

    private fun setupAction() {
        binding.rvShop.layoutManager = LinearLayoutManager(requireContext())
        val dataList: MutableList<ShopModel> = mutableListOf()
        val shopTitle: Array<String> = resources.getStringArray(R.array.title_home)
        val shopPrice: IntArray = resources.getIntArray(R.array.price_home)

        val shopImage : List<Int> = listOf(
            R.drawable.img_product_1,
            R.drawable.img_product_2,
            R.drawable.img_product_3,
            R.drawable.img_product_4,
        )

        shopTitle.forEachIndexed { index, name ->
            dataList.add(ShopModel(shopImage.get(index), name, shopPrice[index], false))
        }

        val adapter = ShopAdapter(dataList)
        binding.rvShop.adapter = adapter

        val totalPrice = calculateTotalPrice(dataList)
        binding.tvNominal.text = "Rp. $totalPrice"

        binding.btnCheckout.setOnClickListener {
            val intent = Intent(requireContext(), MetodeActivity::class.java)
            startActivity(intent)
        }
    }

    private fun calculateTotalPrice(dataList: List<ShopModel>): Int {
        var totalPrice = 0

        for (item in dataList) {
            if (item.isSelected) {
                totalPrice += item.price
            }
            totalPrice
        }
        return totalPrice
    }
}