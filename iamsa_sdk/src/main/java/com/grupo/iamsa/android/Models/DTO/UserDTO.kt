package com.grupo.iamsa.android.Models.DTO

import com.google.gson.annotations.SerializedName
import com.grupo.iamsa.android.Models.StringObject
import org.simpleframework.xml.Element
import org.simpleframework.xml.Namespace
import org.simpleframework.xml.NamespaceList
import org.simpleframework.xml.Root

@Root(name = "soapenv:Envelope",strict = false)
@NamespaceList(
    Namespace(reference = "http://schemas.xmlsoap.org/soap/envelope/",prefix = "soapenv"),
    Namespace(reference = "http://PortalMultiventaWS.org",prefix = "por")
)
data class RequestUserDTO (
    @field:Element(name = "soapenv:Body")
    var body: BodyRequestUserDTO = BodyRequestUserDTO(),
    @field:Element(name = "soapenv:Header")
    var header:String = ""
)

data class BodyRequestUserDTO(
    @field:Element(name = "por:LecturaInterlocutor")
    var user: UserRequestDTO = UserRequestDTO()
)

data class UserRequestDTO (
    @field:Element(name = "por:Usuario")
    var usuario:String = "APPVJM",
    @field:Element(name = "por:Password")
    var password:String = "TESTVJM",
    @field:Element(name = "por:Id_Indetificacion")
    var idIdentifier:String = "1",
    @field:Element(name = "por:Indetificacion")
    var indentificacion:String = "CNTS5UW1U",
    @field:Element(name = "por:ID_MEMBRESIA")
    var idMembership:String = "3000020946",
    @field:Element(name = "por:_CORREO_ELEC")
    var email:String = "3000020946"
)



class ResponceUser(){
    @SerializedName("soap:Envelope")
    var responce: UserResponceDTO?=null
}
data class UserResponceDTO (
    @SerializedName(  "soap:Body")
    var body: UserResponceBodyDTO? = null)

data class UserResponceBodyDTO (
    @SerializedName("LecturaInterlocutorResponse")
    var responce: LecturaInterlocutorResponseDTO? = null)

data class LecturaInterlocutorResponseDTO (
    @SerializedName("LecturaInterlocutorResult")
    var result: LecturaInterlocutorResultDTO? = null)

class LecturaInterlocutorResultDTO() {
    @SerializedName("APELLIDO_MATERNO")
    var maternal: StringObject? = null
    @SerializedName("APELLIDO_PATERNO")
    var paternal: StringObject? = null
    @SerializedName("BANCO")
    var bank: StringObject? = null
    @SerializedName("COMIDA_FAVORITA")
    var favoriteFood: StringObject? = null
    @SerializedName("COMPANIA_PREFERIDA")
    var favoriteCompany: StringObject? = null
    @SerializedName("CORREO_ELECTRONICO")
    var email: StringObject? = null
    @SerializedName("CUENTA_FACEBOOK")
    var facebook: StringObject? = null
    @SerializedName("CUENTA_TWITTER")
    var twitter: StringObject? = null
    @SerializedName("DEC_RESPUESTA")
    var dec_responce: StringObject? = null
    @SerializedName("DEPORTE")
    var sport: StringObject? = null
    @SerializedName("DESTINOS_PREFERIDOS")
    var favoriteDestinations: StringObject? = null
    @SerializedName("DIVERSIONES")
    var amusements: StringObject? = null
    @SerializedName("DONDE_HOSPEDA")
    var hostPlace: StringObject? = null
    @SerializedName("EQUIPO")
    var team: StringObject? = null
    @SerializedName("ESTADO_CIVIL")
    var civilStatus: StringObject? = null
    @SerializedName("EVENTOS")
    var events: StringObject? = null
    @SerializedName("FECHA_NACIMIENTO")
    var birthDate: StringObject? = null
    @SerializedName("FECHA_REGISTRO")
    var registerDate: StringObject? = null
    @SerializedName("GIRO_EMPRESA")
    var enterprice: StringObject? = null
    @SerializedName("ID_RESPUESTA")
    var idResponce: StringObject? = null
    @SerializedName("INGRESO_PERSONAL")
    var incomePersonal: StringObject? = null
    @SerializedName("LUGAR_NACIMIENTO")
    var birthPlace: StringObject? = null
    @SerializedName("MEDIO_COMPRA")
    var mediumBuy: StringObject? = null
    @SerializedName("MEDIO_ENTERO")
    var mediumEnter: StringObject? = null
    @SerializedName("MOTIVO_VIAJE")
    var travel: StringObject? = null
    @SerializedName("MUSICA_PREFERIDA")
    var favoriteMusic: StringObject? = null
    @SerializedName("NACIONALIDAD")
    var nationality: StringObject? = null
    @SerializedName("NOMBRE")
    var name: StringObject? = null
    @SerializedName("NUMERO_ENVIOS")
    var numberSend: StringObject? = null
    @SerializedName("NUMERO_HIJOS")
    var numberChilds: StringObject? = null
    @SerializedName("NUMERO_VIAJES")
    var numberTravels: StringObject? = null
    @SerializedName("PRODUCTO_REGULAR")
    var regularProducts: StringObject? = null
    @SerializedName("PROFESION")
    var profesion: StringObject? = null
    @SerializedName("PROGRAMA_LEALTAD")
    var loyaltyProgram: StringObject? = null
    @SerializedName("PROMOCIONES")
    var promotion: StringObject? = null
    @SerializedName("RED_SOCIAL")
    var socialNetwork: StringObject? = null
    @SerializedName("RFC")
    var RFC: StringObject? = null
    @SerializedName("SEXO")
    var gender: StringObject? = null
    @SerializedName("TELEFONO")
    var phone: StringObject? = null
    @SerializedName("TELEFONO_CELULAR")
    var cellPhone: StringObject? = null
    @SerializedName("TIPO_AUTOBUS")
    var typeBus: StringObject? = null
    @SerializedName("TIPO_CELULAR")
    var typeCell: StringObject? = null
    @SerializedName("TIPO_ENVIO")
    var typeSend: StringObject? = null
    @SerializedName("TIPO_SERVICIO")
    var typeService: StringObject? = null
    @SerializedName("Pushnotifications")
    var notifications: StringObject? = null
    @SerializedName("Newsletters")
    var newsletters: StringObject? = null
    @SerializedName("Imagen_Perfil")
    var imageProfile: StringObject? = null
    @SerializedName("Idioma")
    var language: StringObject? = null

}


