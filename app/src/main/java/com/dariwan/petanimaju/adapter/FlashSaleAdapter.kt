package com.dariwan.petanimaju.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dariwan.petanimaju.databinding.ActivityDetailEducationBinding
import com.dariwan.petanimaju.databinding.FlashSaleItemBinding
import com.dariwan.petanimaju.model.ProductModel

class FlashSaleAdapter(private val list: List<ProductModel>): RecyclerView.Adapter<FlashSaleAdapter.ViewHolder>() {
    class ViewHolder(val binding: FlashSaleItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlashSaleAdapter.ViewHolder {
        val binding = FlashSaleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FlashSaleAdapter.ViewHolder, position: Int) {
        val (image, title, harga) = list[position]
        holder.binding.imgProduct.setImageResource(image)
        holder.binding.tvProductName.text = title
        holder.binding.tvPrice.text = harga.toString()
    }

    override fun getItemCount(): Int {
        return list.size
    }
}