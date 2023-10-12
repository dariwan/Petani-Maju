package com.dariwan.petanimaju.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dariwan.petanimaju.databinding.ProductItemBinding
import com.dariwan.petanimaju.model.ShopModel

class ShopAdapter(private val list: List<ShopModel>): RecyclerView.Adapter<ShopAdapter.ViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback
    interface OnItemClickCallback {
        fun onItemClicked(data: ShopModel)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    class ViewHolder (val binding: ProductItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ProductItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val (image, title, price, isSelected) = list[position]

        holder.binding.imgProduct.setImageResource(image)
        holder.binding.tvProductName.text = title
        holder.binding.tvPrice.text = price.toString()
        holder.binding.checkBoxProduct.isChecked = isSelected


        holder.binding.checkBoxProduct.setOnCheckedChangeListener { _, isChecked ->
            list[position].isSelected = isChecked
            notifyDataSetChanged()
            if (isChecked) {
                val newPrice = price + price
                "Rp.${newPrice}"
            } else{
                "Rp.${price}"
            }
        }
    }
}