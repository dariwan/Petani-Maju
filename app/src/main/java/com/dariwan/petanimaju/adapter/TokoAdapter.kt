package com.dariwan.petanimaju.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dariwan.petanimaju.databinding.ListTokoBinding
import com.dariwan.petanimaju.model.TokoModel
import kotlin.contracts.Returns

class TokoAdapter (private val list: List<TokoModel>): RecyclerView.Adapter<TokoAdapter.ViewHolder>(){
    class ViewHolder (val binding: ListTokoBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListTokoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val (titleImage, title) = list[position]
        holder.binding.imgToko.setImageResource(titleImage)
        holder.binding.tvAddres.text = title

    }

}