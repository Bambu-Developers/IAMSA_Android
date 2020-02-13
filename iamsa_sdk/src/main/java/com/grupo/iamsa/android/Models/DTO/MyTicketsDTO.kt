package com.grupo.iamsa.android.Models.DTO

import com.google.gson.annotations.SerializedName
import com.grupo.iamsa.android.Models.IAMSAModel
import com.grupo.iamsa.android.Network.BuildConfig
import org.json.JSONObject


class MyTicketsRequestDTO : IAMSAModel(){
    @SerializedName("soapenv:Body")
    var body = BodyMyTicketsRequestDTO()
    @SerializedName("xmlns:soapenv")
    val soapenv = "http://schemas.xmlsoap.org/soap/envelope/"
    @SerializedName("xmlns:cit")
    val cit = "http://citec.com/"

    override fun toJSON(): JSONObject {
        val json = JSONObject()
        json.put("soapenv:Body",body.toJSON())
        json.put("xmlns:soapenv",soapenv)
        json.put("xmlns:cit",cit)
        return json
    }
}

class BodyMyTicketsRequestDTO: IAMSAModel() {
    @SerializedName("cit:ProgramaMiViaje")
    var data = ProgramaMiViajeDTO()

    override fun toJSON(): JSONObject {
        val json = JSONObject()
        json.put("cit:ProgramaMiViaje",data.toJSON())
        return json
    }
}

class ProgramaMiViajeDTO: IAMSAModel(){
    @SerializedName("cit:pE_aModo")
    var pE_aModo = "itin"
    @SerializedName("cit:pE_aCorreo")
    var email = ""
    @SerializedName("cit:pE_bWS")
    var pE_bWS = 1

    override fun toJSON(): JSONObject {
        val json = JSONObject()
        json.put("cit:pE_aModo",pE_aModo)
        json.put("cit:pE_aCorreo",email)
        json.put("cit:pE_bWS",pE_bWS)
        return json
    }
}


class MyTicketsResponce: IAMSAModel(){
    @SerializedName("s:Envelope")
    var responce: MyTicketsResponceBodyDTO?=null
}
data class MyTicketsResponceBodyDTO (
    @SerializedName(  "s:Body")
    var body: MyTicketsResponceResponceResultDTO? = null
): IAMSAModel()

data class MyTicketsResponceResponceResultDTO (
    @SerializedName("ProgramaMiViajeResponse")
    var responce: MyTicketsResponceResultDTO? = null
): IAMSAModel()

data class MyTicketsResponceResultDTO (
    @SerializedName("ProgramaMiViajeResult")
    var result: ProgramaMiViajeResponce? = null
): IAMSAModel()

class ProgramaMiViajeResponce :IAMSAModel(){
    @SerializedName("ProgramaMiViaje")
    var programaMiViaje: ProgramaMiViajeResponceDTO? = null
}

class ProgramaMiViajeResponceDTO:IAMSAModel(){
    @SerializedName("Itinerarios")
    var itinerarios:Itinerarios? = null
}
class Itinerarios:IAMSAModel(){
    @SerializedName("CorridaTransbordo")
    var corridasTransbordos:ArrayList<CorridaTransbordo> ? = null
}
class CorridaTransbordo:IAMSAModel(){
    @SerializedName("Resumen")
    var resumen:CorridaResumen? = null

    @SerializedName("ResumenReg")
    var resumenReg:RegistroGral? = null
}

class CorridaResumen:IAMSAModel(){
    @SerializedName("oper")
    var oper:String? = null
    @SerializedName("asiento")
    var  asiento:String? = null
    @SerializedName("tipopasajero")
    var tipopasajero:String? = null
    @SerializedName("nombrePasajero")
    var nombrePasajero:String? = null
    @SerializedName("monto")
    var monto:String? = null
    @SerializedName("promo")
    var promo:String? = null
    @SerializedName("visiblepromoInd")
    var visiblepromoInd:String? = null
    @SerializedName("visiblepromo")
    var visiblepromo:String? = null
    @SerializedName("Subtotal")
    var Subtotal:String? = null
    @SerializedName("Iva")
    var Iva:String? = null
}

class RegistroGral:IAMSAModel(){
    @SerializedName("FechaSalida")
    var FechaSalida:String? = null
    @SerializedName("HoraSalida")
    var HoraSalida:String? = null
    @SerializedName("HoraLlegada")
    var HoraLlegada:String? = null
    @SerializedName("claseservicio")
    var claseservicio:String? = null
    @SerializedName("Empresa")
    var Empresa:String? = null
    @SerializedName("TipoAutobus")
    var TipoAutobus:String? = null
    @SerializedName("Origen")
    var Origen:String? = null
    @SerializedName("Destino")
    var Destino:String? = null
    @SerializedName("FechaSalidaBRegreso")
    var FechaSalidaBRegreso:String? = null
    @SerializedName("HoraSalidaBRegreso")
    var HoraSalidaBRegreso:String? = null
    @SerializedName("HoraLlegadaRegreso")
    var HoraLlegadaRegreso:String? = null
    @SerializedName("claseservreg")
    var claseservreg:String? = null
    @SerializedName("EmpresaRegreso")
    var EmpresaRegreso:String? = null
    @SerializedName("TipoAutobusRegreso")
    var TipoAutobusRegreso:String? = null
    @SerializedName("Redondo")
    var Redondo:String? = null
    @SerializedName("OpRegistro")
    var OpRegistro:String? = null
    @SerializedName("coma_2")
    var coma_2:String? = null
    @SerializedName("RedondoCon")
    var RedondoCon:String? = null
    @SerializedName("isOpen")
    var isOpen:String? = null
    @SerializedName("PDFUrl")
    var PDFUrl:String? = null
    @SerializedName("Nit")
    var Nit:String? = null
    @SerializedName("ImageCode")
    var ImageCode:String? = null
    @SerializedName("Status")
    var Status:String? = null
}