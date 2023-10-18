package com.dariwan.petanimaju.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ShopModel(
    val image: Int,
    val title: String,
    val price: Int,
    var isSelected: Boolean,
):Parcelable