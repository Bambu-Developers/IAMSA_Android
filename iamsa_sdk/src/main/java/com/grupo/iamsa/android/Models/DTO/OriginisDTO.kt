package com.grupo.iamsa.android.Models.DTO

import com.google.gson.annotations.SerializedName


class HeaderRequest{
    @SerializedName("soap:Envelope")
    var request: Any? = null

}
class RequestDTO {
    @SerializedName("soap:Body")
    var body: BodyRequestDTO = BodyRequestDTO()
    @SerializedName("xmlns:xsi")
    var xsi = "http://www.w3.org/2001/XMLSchema-instance"
    @SerializedName("xmlns:xsd")
    var xsd = "http://www.w3.org/2001/XMLSchema"
    @SerializedName("xmlns:soap")
    var soap = "http://schemas.xmlsoap.org/soap/envelope/"
}

data class BodyRequestDTO(
    @SerializedName("Origenes")
    var origins: OriginisRequestDTO = OriginisRequestDTO()
)

data class OriginisRequestDTO(
    @SerializedName("E_aEmpresaviaja")
    var empresaViaja:String = "ABA",
    @SerializedName("E_aEsInternacional")
    var isInternacional:Int = 0,
    @SerializedName("E_aEmpresaSolicita")
    var empresaSolicita:String = "asd"
)


class ResponceRoot{
    @SerializedName( "soap:Envelope")
    var responce: ResponceDTO? = null
}

class ResponceDTO {
    @SerializedName( "soap:Body")
    var body: BodyResponceDTO? = null
}

data class BodyResponceDTO(
    @SerializedName("OrigenesResponse")
    var origins: OrigenesResponse?= null
)

data class OrigenesResponse(
    @SerializedName("OrigenesResult")
    var result:String = ""
)



