package com.grupo.iamsa.android.Models.DTO

import com.google.gson.annotations.SerializedName
import org.simpleframework.xml.*

@Root(name = "s:Envelope",strict = false)
@NamespaceList(
    Namespace(reference = "http://schemas.xmlsoap.org/soap/envelope/",prefix = "s"),
    Namespace(reference = "http://citec.com/",prefix = "ns1"))
data class RequestDTO (
    @field:Element(name = "s:Body")
    var body: BodyRequestDTO = BodyRequestDTO()
)

data class BodyRequestDTO(
    @field:Element(name = "ns1:Origenes")
    var origins: OriginisRequestDTO = OriginisRequestDTO()
)

data class OriginisRequestDTO(
    @field:Element(name = "ns1:E_aEmpresaviaja")
    var empresaViaja:String = "ABA",
    @field:Element(name = "ns1:E_aEsInternacional")
    var isInternacional:Boolean = false,
    @field:Element(name = "ns1:E_aEmpresaSolicita")
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



