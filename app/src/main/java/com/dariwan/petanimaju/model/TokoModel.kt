package com.dariwan.petanimaju.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TokoModel(
    var titleImage: Int,
    var title: String,
    var addres: String

): Parcelable
