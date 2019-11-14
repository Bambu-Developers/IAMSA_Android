package com.grupo.iamsa.android.Models.DTO

import com.google.gson.annotations.SerializedName
import com.grupo.iamsa.android.Models.StringObject

data class RequestRegisterDTO (
    @SerializedName("soapenv:Header")
    var header:String = "",
    @SerializedName("soapenv:Body")
    var body: BodyRequestRegisterDTO = BodyRequestRegisterDTO()
)

data class BodyRequestRegisterDTO(
    @SerializedName("por:Crea_ActualizaInterlocutorComer")
    var user: UserRegisterRequestDTO = UserRegisterRequestDTO()
)

data class UserRegisterRequestDTO (
    @SerializedName( "por:Usuario")
    var user:String = "APPVJM",
    @SerializedName("por:Password")
    var password:String = "TESTVJM",
    @SerializedName("por:CreandoActualizando")
    var crate:String ="0",
    @SerializedName( "por:Datos")
    var datos: UserRegisterDataDTO = UserRegisterDataDTO()
)

data class UserRegisterDataDTO(
    @SerializedName("APELLIDO_MATERNO")
    var maternal:String = "",

    @SerializedName("APELLIDO_PATERNO")
    var paternal:String = "",

    @SerializedName("CORREO_ELECTRONICO")
    var email:String = "",

    @SerializedName("NOMBRE")
    var name:String = "")

class RegisterResponce(){
    @SerializedName("soap:Envelope")
    var responce: RegisterResponceBodyDTO?=null
}
data class RegisterResponceBodyDTO (
    @SerializedName(  "soap:Body")
    var body: RegisterResponceResponceResultDTO? = null)

data class RegisterResponceResponceResultDTO (
    @SerializedName("Crea_ActualizaInterlocutorComerResponse")
    var responce: RegisterResponceResultDTO? = null)

data class RegisterResponceResultDTO (
    @SerializedName("Crea_ActualizaInterlocutorComerResult")
    var result: ResgisterResponceData? = null)

class ResgisterResponceData() {
    @SerializedName("DEC_RESPUESTA")
    var responce: StringObject? = null
    @SerializedName("ID_MEMBRESIA")
    var idMembership: StringObject? = null
    @SerializedName("ID_RESPUESTA")
    var idResponce: StringObject? = null
    @SerializedName("Imagen_Perfil")
    var imProf: StringObject? = null
}