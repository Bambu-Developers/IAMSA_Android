package com.grupo.iamsa.android.Network

import android.util.Log
import com.google.gson.Gson
import com.grupo.iamsa.android.Models.DTO.HeaderRequest
import com.grupo.iamsa.android.Models.DTO.RequestDTO
import com.grupo.iamsa.android.Models.DTO.ResponceRoot
import fr.arnaudguyon.xmltojsonlib.JsonToXml
import fr.arnaudguyon.xmltojsonlib.XmlToJson
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import java.io.StringWriter
import java.io.IOException



object LocationManager: RequestManager(){



    fun getOriginis(){
        val requestBody = RequestDTO()
        requestBody.body.origins.empresaSolicita = "APAE"
        requestBody.body.origins.empresaViaja = "ARS"

        var requestRoot = HeaderRequest()
        requestRoot.request = requestBody
        val jsonString = Gson().toJson(requestRoot)
        val stringWriter =
            JsonToXml.Builder(jsonString)
                .forceAttribute("/soap:Envelope/xmlns:xsi")
                .forceAttribute("/soap:Envelope/xmlns:xsd")
                .forceAttribute("/soap:Envelope/xmlns:soap")
                .build()
        Log.e("Responce","Responce : ${stringWriter.toString()}")


        val client = OkHttpClient()
        val mediaType = "charset=utf-8".toMediaTypeOrNull()
        val  body = RequestBody.create(mediaType,stringWriter.toString())
        val request = Request.Builder()
            .url("http://201.131.2.102/ARS_WS/CitecWS_Venta.asmx")
            .post(body)
            .addHeader("Content-Type", "text/xml")
            .addHeader("SOAPAction", "http://citec.com/Origenes")
            .addHeader("Host", "201.131.2.102")
            .build()
        val call= client.newCall(request)
        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("Error","Error Request")
            }
            override fun onResponse(call: Call, response: Response) {
                val resBody = response.body?.string() ?: ""
                val json =XmlToJson.Builder(resBody).build().toJson()
                val gson = Gson()
                val responce = gson.fromJson(json.toString(), ResponceRoot::class.java)
            }
        })
    }



    fun userExample(){
        val client = OkHttpClient()

        val mediaType = "charset=utf-8".toMediaTypeOrNull()
        val body = RequestBody.create(
            mediaType,
            "<soapenv:Envelope\n\txmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"\n\txmlns:por=\"http://PortalMultiventaWS.org\">\n\t<soapenv:Header></soapenv:Header>\n\t<soapenv:Body>\n\t\t<por:LecturaInterlocutor>\n\t\t\t<por:Usuario>APPVJM</por:Usuario>\n\t\t\t<por:Password>TESTVJM</por:Password>\n\t\t\t<por:Id_Indetificacion>1</por:Id_Indetificacion>\n\t\t\t<por:Indetificacion>CNTS5UW1U</por:Indetificacion>\n\t\t\t<por:ID_MEMBRESIA>3000020946</por:ID_MEMBRESIA>\n\t\t\t<!--<por:_CORREO_ELEC>SAUL.GARCIA@BAMBU-MOBILE.COM</por:_CORREO_ELEC>-->\n\t\t</por:LecturaInterlocutor>\n\t</soapenv:Body>\n</soapenv:Envelope>"
        )
        val request = Request.Builder()
            .url("http://201.131.2.199/portalmultiventaws/PortalMultiventaWS.asmx")
            .post(body)
            .addHeader("Content-Type", "text/xml")
            .addHeader("SOAPAction", "http://PortalMultiventaWS.org/LecturaInterlocutor")
            .addHeader("User-Agent", "PostmanRuntime/7.19.0")
            .addHeader("Accept", "*/*")
            .addHeader("Cache-Control", "no-cache")
            .addHeader(
                "Postman-Token",
                "78cbb876-9b0d-40d8-a07a-be941b9ddb0a,e3fd6ef3-fc22-418e-a1d8-f7c9d1612e98"
            )
            .addHeader("Host", "201.131.2.199")
            .addHeader("Accept-Encoding", "gzip, deflate")
            .addHeader("Content-Length", "575")
            .addHeader("Cookie", "ASP.NET_SessionId=j0iy5xalatsfdbdbgkkflnno")
            .addHeader("Connection", "keep-alive")
            .addHeader("cache-control", "no-cache")
            .build()

        val call= client.newCall(request)
        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("Error","Error Request")
            }
            override fun onResponse(call: Call, response: Response) {
                val resBody = response.body?.string() ?: ""
                val json =XmlToJson.Builder(resBody).build().toJson()
                val gson = Gson()
                val responce = gson.fromJson(json.toString(), ResponceRoot::class.java)
            }
        })

    }
}