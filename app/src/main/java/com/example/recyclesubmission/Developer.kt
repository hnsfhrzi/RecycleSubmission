package com.example.recyclesubmission

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Developer(
    var userName: String,
    var name: String,
    var location: String,
    var repository: String,
    var company: String,
    var followers: String,
    var following: String,
    var avatar: Int
):Parcelable
