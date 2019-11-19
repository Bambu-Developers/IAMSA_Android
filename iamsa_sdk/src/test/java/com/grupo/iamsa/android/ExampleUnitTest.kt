package com.grupo.iamsa.android

import android.util.Log
import com.grupo.iamsa.android.Network.Manager.AccountManager
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun addition_isCorrect() {
        AccountManager.loginUserName("APPVJM","TESTVJM") { responce, error ->
            Log.e("Test","Responce Error")
        }
    }
}
