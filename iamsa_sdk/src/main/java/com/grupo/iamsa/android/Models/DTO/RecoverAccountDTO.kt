package com.grupo.iamsa.android.Models.DTO

import com.google.gson.annotations.SerializedName
import com.grupo.iamsa.android.Models.IAMSAModel
import com.grupo.iamsa.android.Models.IntObject
import com.grupo.iamsa.android.Models.StringObject
import com.grupo.iamsa.android.Network.BuildConfig
import org.json.JSONObject


class RecoverAccountRequestDTO : IAMSAModel(){
    @SerializedName("soapenv:Header")
    var header: String = ""
    @SerializedName("soapenv:Body")
    var body = BodyRecoberAccountRequestDTO()

    @SerializedName("xmlns:soapenv")
    val soapenv = "http://schemas.xmlsoap.org/soap/envelope/"

    @SerializedName("xmlns:por")
    val por = "http://PortalMultiventaWS.org"

}

class BodyRecoberAccountRequestDTO:IAMSAModel() {
    @SerializedName("por:RecuperacionContrasena")
    var data = RecoverAccountDataDTO()
}

class RecoverAccountDataDTO:IAMSAModel(){
    @SerializedName("por:Usuario")
    var user = BuildConfig.aplicationType.user()
    @SerializedName("por:Password")
    var pass = BuildConfig.aplicationType.password()
    @SerializedName("por:email")
    var email = ""
}


class RecoverAccountResponce: IAMSAModel(){
    @SerializedName("soap:Envelope")
    var responce: RecoverAccountResponceBodyDTO?=null
}
data class RecoverAccountResponceBodyDTO (
    @SerializedName(  "soap:Body")
    var body: RecoverAccountResponceResponceResultDTO? = null
): IAMSAModel()

data class RecoverAccountResponceResponceResultDTO (
    @SerializedName("RecuperacionContrasenaResponse")
    var responce: RecoverAccountResponceResultDTO? = null
): IAMSAModel()

data class RecoverAccountResponceResultDTO (
    @SerializedName("RecuperacionContrasenaResult")
    var result: RecoverAccountResponceData? = null
): IAMSAModel()

class RecoverAccountResponceData :IAMSAModel(){
    @SerializedName("nError")
    var nError: String? = null
    @SerializedName("aMembresia")
    var aMembresia: String? = null
}