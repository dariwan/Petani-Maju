package com.dariwan.petanimaju.view.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.dariwan.petanimaju.R
import com.dariwan.petanimaju.adapter.FlashSaleAdapter
import com.dariwan.petanimaju.databinding.FragmentHomeBinding
import com.dariwan.petanimaju.model.ProductModel
import com.dariwan.petanimaju.view.shop.TokoFragment

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAction()
    }

    private fun setupAction() {
        binding.rvHome.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val dataList: MutableList<ProductModel> = mutableListOf()
        val flashSaleTitle: Array<String> = resources.getStringArray(R.array.title_home)
        val flashSalePrice: IntArray = resources.getIntArray(R.array.price_home)

        val flashSaleImage : List<Int> = listOf(
            R.drawable.img_product_1,
            R.drawable.img_product_2,
            R.drawable.img_product_3,
            R.drawable.img_product_4,
        )

        flashSaleTitle.forEachIndexed { index, name ->
            dataList.add(ProductModel(flashSaleImage.get(index), name, flashSalePrice[index]))
        }

        val adapter = FlashSaleAdapter(dataList)
        binding.rvHome.adapter = adapter
        binding.imageView7.setOnClickListener{
            val intent = Intent(requireContext(), TokoFragment::class.java)
            startActivity(intent)
        }
    }

}