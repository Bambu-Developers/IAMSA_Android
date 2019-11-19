package com.grupo.iamsa.android.Models.DTO

import com.google.gson.annotations.SerializedName
import com.grupo.iamsa.android.Models.IAMSAModel
import com.grupo.iamsa.android.Models.StringObject
import org.json.JSONObject

class RequestRegisterDTO :IAMSAModel(){
     @SerializedName("soapenv:Header")
     var header: String = ""
     @SerializedName("soapenv:Body")
     var body: BodyRequestRegisterDTO = BodyRequestRegisterDTO()

     @SerializedName("xmlns:soapenv")
     val soapenv = "http://schemas.xmlsoap.org/soap/envelope/"

     @SerializedName("xmlns:por")
     val por = "http://PortalMultiventaWS.org"

    override fun toJSON():JSONObject{
        val json = JSONObject()
        json.put("soapenv:Header",header)
        json.put("soapenv:Body",body.toJSON())
        json.put("xmlns:soapenv",soapenv)
        json.put("xmlns:por",por)
        return json
    }
 }

class BodyRequestRegisterDTO: IAMSAModel(){
    @SerializedName("por:Crea_ActualizaInterlocutorComer")
    var user: UserRegisterRequestDTO = UserRegisterRequestDTO()
    override fun toJSON():JSONObject{
        val json = JSONObject()
        json.put("por:Crea_ActualizaInterlocutorComer",user.toJSON())
        return json
    }
}

class UserRegisterRequestDTO:IAMSAModel() {
    @SerializedName("por:Usuario")
    var user: String = "APPVJM"
    @SerializedName("por:Password")
    var password: String = "TESTVJM"
    @SerializedName("por:CreandoActualizando")
    var crate: String = "0"

    @SerializedName("por:Datos")
    var datos: UserRegisterDataDTO = UserRegisterDataDTO()

    override fun toJSON():JSONObject{
        val json = JSONObject()
        json.put("por:Usuario","APPVJM")
        json.put("por:Password","TESTVJM")
        json.put("por:CreandoActualizando","0")
        json.put("por:Datos",datos.toJSON())
        return json
    }
}

class UserRegisterDataDTO:IAMSAModel() {

    @SerializedName("APELLIDO_MATERNO")
    var maternal : String = ""

    @SerializedName("APELLIDO_PATERNO")
    var paternal: String = ""

    @SerializedName("CORREO_ELECTRONICO")
    var email: String = ""

    @SerializedName("NOMBRE")
    var name: String = ""

    override fun toJSON():JSONObject{
        val json = JSONObject()
        json.put("APELLIDO_MATERNO",maternal)
        json.put("APELLIDO_PATERNO",paternal)
        json.put("CORREO_ELECTRONICO",email)
        json.put("NOMBRE",name)
        return json
    }
}

class RegisterResponce(): IAMSAModel(){
    @SerializedName("soap:Envelope")
    var responce: RegisterResponceBodyDTO?=null
}
data class RegisterResponceBodyDTO (
    @SerializedName(  "soap:Body")
    var body: RegisterResponceResponceResultDTO? = null
): IAMSAModel()

data class RegisterResponceResponceResultDTO (
    @SerializedName("Crea_ActualizaInterlocutorComerResponse")
    var responce: RegisterResponceResultDTO? = null
): IAMSAModel()

data class RegisterResponceResultDTO (
    @SerializedName("Crea_ActualizaInterlocutorComerResult")
    var result: ResgisterResponceData? = null
): IAMSAModel()

class ResgisterResponceData() : IAMSAModel(){
    @SerializedName("DEC_RESPUESTA")
    var responce: StringObject? = null
    @SerializedName("ID_MEMBRESIA")
    var idMembership: StringObject? = null
    @SerializedName("ID_RESPUESTA")
    var idResponce: StringObject? = null
    @SerializedName("Imagen_Perfil")
    var imProf: StringObject? = null
}