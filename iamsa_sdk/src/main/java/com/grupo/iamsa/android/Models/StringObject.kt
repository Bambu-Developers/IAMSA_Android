package com.grupo.iamsa.android.Models

import com.google.gson.annotations.SerializedName

class StringObject {

    @SerializedName("xmlns")
    var xml: String? = null

    @SerializedName("content")
    var value: String? = null
}

class IntObject {

    @SerializedName("xmlns")
    var xml: String? = null

    @SerializedName("content")
    var value: Int? = null
}

