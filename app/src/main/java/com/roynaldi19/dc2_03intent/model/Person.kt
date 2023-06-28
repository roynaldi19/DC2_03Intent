package com.roynaldi19.dc2_03intent.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(
    val name: String?,
    val age: Int?,
    val email: String?,
    val city: String?
) : Parcelable