package com.dariwan.petanimaju.view.shop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dariwan.petanimaju.R
import com.dariwan.petanimaju.adapter.ShopAdapter
import com.dariwan.petanimaju.databinding.FragmentShopBinding
import com.dariwan.petanimaju.model.ShopModel


class ShopFragment : Fragment() {

    private var _binding: FragmentShopBinding? = null
    private val binding get() = _binding!!
    private lateinit var shopViewModel: ShopFragmentViewModel

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
        shopViewModel = ViewModelProvider(requireActivity())[ShopFragmentViewModel::class.java]
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

//        val totalPrice = calculateTotalPrice(dataList)
//        binding.tvNominal.text = "Rp. $totalPrice"


//        val shopObserver: Observer<Int> = Observer{ priceTotal ->
//            binding.tvNominal.setText("Rp. ${priceTotal}")
//        }
//        shopViewModel.getTotalPrice().observe(requireActivity(), shopObserver)

        adapter.setOnItemClickCallback(object : ShopAdapter.OnItemClickCallback{
            override fun onItemClicked(data: ShopModel) {
                shopViewModel.getTotalPrice().observe(viewLifecycleOwner) { totalPrice ->
                    binding.tvNominal.text = "Rp. $totalPrice"
                }
            }

        })




    }
}