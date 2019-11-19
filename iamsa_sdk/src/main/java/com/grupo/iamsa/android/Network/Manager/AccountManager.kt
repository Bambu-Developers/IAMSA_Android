package com.grupo.iamsa.android.Network.Manager

import android.util.Log
import com.google.gson.Gson
import com.grupo.iamsa.android.Models.*
import com.grupo.iamsa.android.Models.DTO.*
import com.grupo.iamsa.android.Network.API.APIMethod
import fr.arnaudguyon.xmltojsonlib.XmlToJson
import okhttp3.*
import java.io.IOException

object AccountManager : RequestManager(){


    fun loginEmail(email:String, pass:String,callResponce:(user: LecturaInterlocutorResultDTO?, error:String?) -> Unit){
        val requestBody = RequestUserDTO()
        requestBody.body.user.email = email
        requestBody.body.user.indentificacion = pass
        login(requestBody, callResponce)
    }

    fun loginMembetship(idMembership:String, pass:String,callResponce:(user: LecturaInterlocutorResultDTO?, error:String?) -> Unit){
        val requestBody = RequestUserDTO()
        login(requestBody,callResponce)
    }
    fun loginUserName(user:String, pass:String,callResponce:(user: LecturaInterlocutorResultDTO?, error:String?) -> Unit){
        val requestBody = RequestUserDTO()
        login(requestBody,callResponce)
    }

    private fun login(body:IAMSAModel,callResponce:(user: LecturaInterlocutorResultDTO?, error:String?) -> Unit){
        getCall(body,APIMethod.login).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("Error","Error Request")
                callResponce.invoke(null,e.toString())
            }
            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful){
                    val resBody = response.body?.string() ?: ""
                    Log.e("isSuccessful","onResponse $resBody")
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

    fun getRegisterDTO(user:UserIAMSA):IAMSAModel {
        val requestBody = RequestRegisterDTO()
        val datosUser = UserRegisterDataDTO()
        datosUser.maternal = user.motherName
        datosUser.paternal = user.fatherName
        datosUser.email = user.email
        datosUser.name = user.name
        requestBody.body.user.datos = datosUser
        return requestBody
    }

    fun register(user:UserIAMSA,callResponce:(user: ResgisterResponceData?,error:String?) -> Unit){
        getCall(getRegisterDTO(user),APIMethod.register).enqueue(object : Callback {
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


    fun changePassword(lastPass:String,newPass:String,email:String,callResponce:(user: ChangePasswordResponceData?,error:String?) -> Unit){
        val requestBody = RequestChangePasswordDTO()
        requestBody.body.data.correo = email
        requestBody.body.data.lastPassword = lastPass
        requestBody.body.data.newPass = newPass
        getCall(requestBody,APIMethod.chanePassword).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("Error","Error Request")
                callResponce.invoke(null,e.toString())
            }
            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful){
                    val resBody = response.body?.string() ?: ""
                    Log.e("isSuccessful","onResponse $resBody")
                    val json = XmlToJson.Builder(resBody).build().toJson()
                    try {
                        val responceUser = Gson().fromJson(json.toString(), ChangePasswordResponce::class.java)
                        callResponce.invoke(responceUser.responce?.body?.responce?.result,null)
                    }catch (e:Exception){
                        e.printStackTrace()
                        callResponce.invoke(null,"Cant not cast the responce")
                    }
                } else {
                    callResponce.invoke(null,response.message)
                }
            }
        })


    }
    fun recoverAccount(email:String,callResponce:(user: RecoverAccountResponceData?,error:String?) -> Unit){
        val requestBody = RecoverAccountRequestDTO()
        requestBody.body.data.email = email
        getCall(requestBody,APIMethod.recoverAccount).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("Error","Error Request")
                callResponce.invoke(null,e.toString())
            }
            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful){
                    val resBody = response.body?.string() ?: ""
                    Log.e("isSuccessful","onResponse $resBody")
                    val json = XmlToJson.Builder(resBody).build().toJson()
                    try {
                        val responceUser = Gson().fromJson(json.toString(), RecoverAccountResponce::class.java)
                        callResponce.invoke(responceUser.responce?.body?.responce?.result,null)
                    }catch (e:Exception){
                        e.printStackTrace()
                        callResponce.invoke(null,"Cant not cast the responce")
                    }
                } else {
                    callResponce.invoke(null,response.message)
                }
            }
        })
    }
}