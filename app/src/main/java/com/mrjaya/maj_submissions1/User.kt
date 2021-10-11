package com.mrjaya.maj_submissions1

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var avatar: Int,
    var name: String,
    var username: String,
    var followers: String,
    var following: String,
    var repository: String,
    var company: String,
    var location: String,
) : Parcelable