package com.dariwan.petanimaju.view.shop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dariwan.petanimaju.R
import com.dariwan.petanimaju.adapter.TokoAdapter
import com.dariwan.petanimaju.databinding.FragmentTokoBinding
import com.dariwan.petanimaju.model.TokoModel


class TokoFragment : Fragment() {
    private var _binding: FragmentTokoBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTokoBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_toko, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAction()
    }
    private fun setupAction() {
        binding.rvToko.layoutManager = LinearLayoutManager(requireContext())
        val dataList: MutableList<TokoModel> = mutableListOf()
        val tokoTitle: Array<String> = resources.getStringArray(R.array.name_toko)
        val tokoAddres: Array<String> = resources.getStringArray(R.array.almt_toko)

        val tokoImage : List<Int> = listOf(
            R.drawable.img_product_1,
            R.drawable.img_product_2,
            R.drawable.img_product_3,
            R.drawable.img_product_4,
        )

        tokoTitle.forEachIndexed { index, name ->
            dataList.add(TokoModel(tokoImage.get(index), name, tokoAddres.toString()))
        }
        val adapter= TokoAdapter(dataList)
        binding.rvToko.adapter = adapter




    }
}