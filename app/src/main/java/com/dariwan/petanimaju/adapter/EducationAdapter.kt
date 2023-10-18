package com.dariwan.petanimaju.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dariwan.petanimaju.databinding.EducationItemBinding
import com.dariwan.petanimaju.model.EducationModel

class EducationAdapter(private val list: List<EducationModel>): RecyclerView.Adapter<EducationAdapter.ViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback
    interface OnItemClickCallback {
        fun onItemClicked(data: EducationModel)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    class ViewHolder(val binding: EducationItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = EducationItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val (image, title, desc) = list[position]
        holder.binding.imgView.setImageResource(image)
        holder.binding.tvTitle.text = title
        holder.binding.tvDesc.text = desc

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(list[holder.adapterPosition])
        }
    }
}