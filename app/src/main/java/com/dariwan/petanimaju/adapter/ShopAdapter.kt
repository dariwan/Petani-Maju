package com.dariwan.petanimaju.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dariwan.petanimaju.databinding.ProductItemBinding
import com.dariwan.petanimaju.model.EducationModel
import com.dariwan.petanimaju.model.ShopModel

class ShopAdapter(private val list: List<ShopModel>): RecyclerView.Adapter<ShopAdapter.ViewHolder>() {

    class ViewHolder (val binding: ProductItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ProductItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val (image, title, price) = list[position]

        holder.binding.imgProduct.setImageResource(image)
        holder.binding.tvProductName.text = title
        holder.binding.tvPrice.text = price.toString()

    }
}