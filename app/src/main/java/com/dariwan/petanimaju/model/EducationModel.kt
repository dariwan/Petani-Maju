package com.dariwan.petanimaju.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class EducationModel (
    val image: Int,
    val title: String,
    val desc: String
): Parcelable