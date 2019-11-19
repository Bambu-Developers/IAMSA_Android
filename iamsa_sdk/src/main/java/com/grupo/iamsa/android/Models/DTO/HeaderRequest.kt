package com.grupo.iamsa.android.Models.DTO

import com.google.gson.annotations.SerializedName
import com.grupo.iamsa.android.Models.IAMSAModel
import org.json.JSONObject

open class HeaderRequestIAMSA(){

}
class HeaderViajamas:HeaderRequestIAMSA(){

    @SerializedName("soapenv:Envelope")
    var request: IAMSAModel? = null

    fun toJSON():JSONObject{
        val json = JSONObject()
        json.put("soapenv:Envelope",request?.toJSON())
        return json
    }

}