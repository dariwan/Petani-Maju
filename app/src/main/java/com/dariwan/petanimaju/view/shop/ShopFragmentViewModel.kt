package com.dariwan.petanimaju.view.shop

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dariwan.petanimaju.model.ShopModel

class ShopFragmentViewModel: ViewModel() {
    val totalPrice = MutableLiveData<Int>()
    val dataList : MutableList<ShopModel> = mutableListOf()

    init {
        var total = 0
        for (item in dataList){
            if (item.isSelected){
                total += item.price
            }
            totalPrice.postValue(total)
        }
        totalPrice.postValue(total)
    }

    fun getTotalPrice(): LiveData<Int>{
        return  totalPrice
    }
}