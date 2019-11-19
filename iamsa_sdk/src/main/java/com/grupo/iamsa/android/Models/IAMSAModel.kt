package com.grupo.iamsa.android.Models

import org.json.JSONObject

open class IAMSAModel() {

    open fun toJSON():JSONObject{
        return  JSONObject()
    }
}