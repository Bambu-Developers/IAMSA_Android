package com.grupo.iamsa.android.Models.DTO

import com.google.gson.annotations.SerializedName
import com.grupo.iamsa.android.Models.StringObject
import org.simpleframework.xml.*

@Root(name = "soapenv:Envelope",strict = false)
@NamespaceList(
    Namespace(reference = "http://schemas.xmlsoap.org/soap/envelope/",prefix = "soapenv"),
    Namespace(reference = "http://PortalMultiventaWS.org",prefix = "por")
)

data class RequestRegisterDTO (
    @field:Element(name = "soapenv:Header")
    var header:String = "",
    @field:Element(name = "soapenv:Body")
    var body: BodyRequestRegisterDTO = BodyRequestRegisterDTO()
)

data class BodyRequestRegisterDTO(
    @field:Element(name = "por:Crea_ActualizaInterlocutorComer")
    var user: UserRegisterRequestDTO = UserRegisterRequestDTO()
)

data class UserRegisterRequestDTO (
    @field:Element(name = "por:Usuario")
    var user:String = "APPVJM",
    @field:Element(name = "por:Password")
    var password:String = "TESTVJM",
    @field:Element(name = "por:CreandoActualizando")
    var crate:String ="0",
    @field:Element(name = "por:Datos")
    var datos: UserRegisterDataDTO = UserRegisterDataDTO()
)

@Order(elements=["APELLIDO_MATERNO", "APELLIDO_PATERNO","CORREO_ELECTRONICO","NOMBRE"])
data class UserRegisterDataDTO(
    @field:Element(name = "APELLIDO_MATERNO")
    var maternal:String = "",

    @field:Element(name = "APELLIDO_PATERNO")
    var paternal:String = "",

    @field:Element(name = "CORREO_ELECTRONICO")
    var email:String = "",

    @field:Element(name = "NOMBRE")
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