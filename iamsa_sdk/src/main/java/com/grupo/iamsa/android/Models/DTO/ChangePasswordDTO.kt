package com.grupo.iamsa.android.Models.DTO

import com.google.gson.annotations.SerializedName
import com.grupo.iamsa.android.Models.IAMSAModel
import com.grupo.iamsa.android.Network.BuildConfig

class RequestChangePasswordDTO: IAMSAModel() {
    @SerializedName("soapenv:Body")
    var body: BodyChangePasswordDTO = BodyChangePasswordDTO()

    @SerializedName("soapenv:Header")
    var header: String = ""

    @SerializedName("xmlns:soapenv")
    val soapenv="http://schemas.xmlsoap.org/soap/envelope/"

    @SerializedName("xmlns:por")
    val por = "http://PortalMultiventaWS.org"
}

data class BodyChangePasswordDTO(
    @SerializedName( "por:getCambioContrasena")
    var data: ChangePasswordRequestDTO = ChangePasswordRequestDTO()
): IAMSAModel()

class ChangePasswordRequestDTO: IAMSAModel()  {
    @SerializedName( "por:Usuario")
    private var usuario:String = BuildConfig.aplicationType.user()
    @SerializedName( "por:Password")
    private var password:String = BuildConfig.aplicationType.password()
    @SerializedName( "por:aCorreo")
    var correo:String? = null
    @SerializedName( "por:aContasenaAnt")
    var lastPassword:String? = null
    @SerializedName( "por:aContasenaNueva")
    var newPass:String? = null
}


class ChangePasswordResponce: IAMSAModel(){
    @SerializedName("soap:Envelope")
    var responce: ChangePasswordResponceBodyDTO?=null
}
data class ChangePasswordResponceBodyDTO (
    @SerializedName(  "soap:Body")
    var body: ChangePasswordResponceResponceResultDTO? = null
): IAMSAModel()

data class ChangePasswordResponceResponceResultDTO (
    @SerializedName("getCambioContrasenaResponse")
    var responce: ChangePasswordResponceResultDTO? = null
): IAMSAModel()

data class ChangePasswordResponceResultDTO (
    @SerializedName("getCambioContrasenaResult")
    var result: ChangePasswordResponceData? = null
): IAMSAModel()

class ChangePasswordResponceData :IAMSAModel(){
    @SerializedName("nError")
    var nError: String? = null
    @SerializedName("aMensaje")
    var aMensaje: String? = null
}
