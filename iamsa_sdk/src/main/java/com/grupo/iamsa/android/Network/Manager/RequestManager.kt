package com.grupo.iamsa.android.Network.Manager

import com.google.gson.Gson
import com.grupo.iamsa.android.Models.DTO.HeaderViajamas
import com.grupo.iamsa.android.Models.IAMSAModel
import com.grupo.iamsa.android.Network.API.APIMethod
import com.grupo.iamsa.android.Network.BuildConfig
import fr.arnaudguyon.xmltojsonlib.JsonToXml
import okhttp3.Call
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import java.util.concurrent.TimeUnit

open class RequestManager() {

    fun getCall(body: IAMSAModel, method:APIMethod): Call {
        val rootRequest = getXMLRootRequest(body,method)
        val call = getClient().newCall(getRequest(rootRequest,method))
        return call
    }

    private fun getClient():OkHttpClient{
        val builder = OkHttpClient.Builder()
        builder.connectTimeout(5, TimeUnit.MINUTES)
            .writeTimeout(5, TimeUnit.MINUTES)
            .readTimeout(5, TimeUnit.MINUTES)
       return builder.build()
    }

    private fun getXMLRootRequest(requestBody:IAMSAModel,method:APIMethod):String{
        when(method){
            APIMethod.login,APIMethod.recoverAccount,APIMethod.chanePassword -> {
                val viajamas  = HeaderViajamas()
                viajamas.request = requestBody
                val body = addNameSpace(Gson().toJson(viajamas),method)
                return body
            }
            APIMethod.register -> {
                val viajamas  = HeaderViajamas()
                viajamas.request = requestBody
                var jsonRep = viajamas.toJSON()
                val body = addNameSpace(jsonRep.toString(),method)
                return body
            }
        }
    }

    private fun addNameSpace(jsonString:String,method:APIMethod):String{
        val stringWriter = JsonToXml.Builder(jsonString)
                    .forceAttribute("/soapenv:Envelope/xmlns:soapenv")
                    .forceAttribute("/soapenv:Envelope/xmlns:por")
                    .build()
        return stringWriter.toString()
    }

    private fun getURLBase(method:APIMethod):String{
        when(method){
            APIMethod.register,APIMethod.login,APIMethod.recoverAccount,APIMethod.chanePassword-> {
              return  BuildConfig.aplicationType.urlViajaMas()
            }
        }
    }

    private fun getRequest(bodyString:String, method:APIMethod):Request{
        val mediaType = "charset=utf-8".toMediaTypeOrNull()
        val fullURL = getURLBase(method)
        val body = RequestBody.create(mediaType,bodyString.toString())
        val soapAction = method.SOAPAction()
        val request = Request.Builder()
            .url(fullURL)
            .post(body)
            .addHeader("Content-Type", "text/xml")
            .addHeader("SOAPAction",soapAction)
            .addHeader("Accept", "*/*")
            .addHeader("Content-Length", "575")
            .addHeader("Connection", "keep-alive")
            .build()
        return request
    }
}
