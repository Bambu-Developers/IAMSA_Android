package com.grupo.iamsa.android.Network

import android.util.Log
import com.google.gson.Gson
import com.grupo.iamsa.android.Models.*
import com.grupo.iamsa.android.Models.DTO.*
import com.grupo.iamsa.android.Network.API.APIMethod
import fr.arnaudguyon.xmltojsonlib.XmlToJson
import okhttp3.*
import java.io.IOException

object AccountManager :RequestManager(){


    fun loginEmail(email:String, pass:String,callResponce:(user: LecturaInterlocutorResultDTO?, error:String?) -> Unit){
        val requestBody = RequestUserDTO()
        requestBody.body.user.password = pass
        requestBody.body.user.email = email
        requestBody.body.user.idIdentifier = "1"
        requestBody.body.user.indentificacion = "CNTS5UW1U"
        login(getXMLRootRequest(requestBody),callResponce)
    }

    fun loginMembetship(idMembership:String, pass:String,callResponce:(user: LecturaInterlocutorResultDTO?, error:String?) -> Unit){
        val requestBody = RequestUserDTO()
        requestBody.body.user.password = pass
        requestBody.body.user.idMembership = idMembership
        requestBody.body.user.idIdentifier = "1"
        requestBody.body.user.indentificacion = "CNTS5UW1U"
        login(getXMLRootRequest(requestBody),callResponce)
    }
    fun loginUserName(user:String, pass:String,callResponce:(user: LecturaInterlocutorResultDTO?, error:String?) -> Unit){
        val requestBody = RequestUserDTO()
        requestBody.body.user.usuario = user
        requestBody.body.user.password = pass
        requestBody.body.user.idIdentifier = "1"
        requestBody.body.user.indentificacion = "CNTS5UW1U"
        login(getXMLRootRequest(requestBody),callResponce)

    }
    private fun login(body:String,callResponce:(user: LecturaInterlocutorResultDTO?, error:String?) -> Unit){

        val call = getClient().newCall(
            getRequest(body.toString(),
            APIMethod.login))
        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("Error","Error Request")
                callResponce.invoke(null,e.toString())
            }
            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful){
                    val resBody = response.body?.string() ?: ""
                    Log.e("Error","onResponse $resBody")
                    val json = XmlToJson.Builder(resBody).build().toJson()
                    val gson = Gson()
                    try {
                        val responceUser = gson.fromJson(json.toString(), ResponceUser::class.java)
                        callResponce.invoke(responceUser.responce?.body?.responce?.result,null)
                    }catch (e:Exception){
                        callResponce.invoke(null,"Cant not cast the responce")
                    }
                } else {
                    callResponce.invoke(null,response.message)
                }
            }
        })
    }

    fun getRegisterDTO(user:UserIAMSA):String {
        val requestBody = RequestRegisterDTO()
        requestBody.body.user.datos.email = user.email
        requestBody.body.user.datos.maternal = user.motherName
        requestBody.body.user.datos.paternal = user.fatherName
        requestBody.body.user.datos.name = user.name
        return getXMLRootRequest(requestBody)
    }

    fun register(user:UserIAMSA,callResponce:(user: ResgisterResponceData?,error:String?) -> Unit){
        val call = getClient().newCall(getRequest(getRegisterDTO(user), APIMethod.register))
        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("Error","Error Request")
                callResponce.invoke(null,e.toString())
            }
            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful){
                    val resBody = response.body?.string() ?: ""
                    Log.e("Error","onResponse $resBody")
                    val json = XmlToJson.Builder(resBody).build().toJson()
                    val gson = Gson()
                    try {
                        val responceUser = gson.fromJson(json.toString(), RegisterResponce::class.java)
                        if (responceUser.responce?.body?.responce?.result?.idResponce?.value != "1") {
                            val messaje = responceUser.responce?.body?.responce?.result?.responce?.value ?: "No data"
                            callResponce.invoke(null,messaje)
                        }else {
                            callResponce.invoke(responceUser.responce?.body?.responce?.result,null)
                        }
                    }catch (e:Exception){
                        callResponce.invoke(null,"Cant not cast the responce")
                    }
                } else {
                    callResponce.invoke(null,response.message)
                }
            }
        })
    }

}