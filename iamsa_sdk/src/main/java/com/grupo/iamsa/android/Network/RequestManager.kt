package com.grupo.iamsa.android.Network

import com.google.gson.Gson
import com.grupo.iamsa.android.Models.DTO.HeaderRequest
import com.grupo.iamsa.android.Network.API.APIMethod
import fr.arnaudguyon.xmltojsonlib.JsonToXml
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import java.util.concurrent.TimeUnit

open class RequestManager() {

    var aplicationType = ApplicationAPI.ETN

    fun getClient():OkHttpClient{
        val builder = OkHttpClient.Builder()
        builder.connectTimeout(5, TimeUnit.MINUTES)
            .writeTimeout(5, TimeUnit.MINUTES)
            .readTimeout(5, TimeUnit.MINUTES)
       return builder.build()
    }

    fun getXMLRootRequest(requestBody:Any):String{
        var requestRoot = HeaderRequest()
        requestRoot.request = requestBody
        val jsonString = Gson().toJson(requestRoot)
        val stringWriter =
            JsonToXml.Builder(jsonString)
                .forceAttribute("/soap:Envelope/xmlns:xsi")
                .forceAttribute("/soap:Envelope/xmlns:xsd")
                .forceAttribute("/soap:Envelope/xmlns:soap")
                .build()
        return stringWriter.toString()
    }
    fun getRequest(bodyString:String, method:APIMethod):Request{
        val mediaType = "charset=utf-8".toMediaTypeOrNull()
        val fullURL = aplicationType.url()+method.path()
        val body = RequestBody.create(mediaType,bodyString.toString())
        val soapAction = method.SOAPAction()
        val request = Request.Builder()
            .url(fullURL)
            .post(body)
            .addHeader("Content-Type", "text/xml")
            .addHeader("SOAPAction",soapAction)
            .addHeader("Host", aplicationType.host())
            .addHeader("Accept", "*/*")
            .addHeader("Accept-Encoding", "gzip, deflate")
            .addHeader("Content-Length", "575")
            .addHeader("Connection", "keep-alive")
            .build()
        return request
    }
}


enum class ApplicationAPI {
    ETN{
        override fun url(): String { return "http://201.131.2.199/" }
        override fun host(): String { return "201.131.2.199" }
    },
    CostaLine{
        override fun url(): String { return "http://201.131.2.199/" }
        override fun host(): String { return "201.131.2.199" }
    };
    abstract fun url(): String
    abstract fun host(): String
}