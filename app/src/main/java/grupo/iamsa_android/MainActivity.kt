package grupo.iamsa_android


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.grupo.iamsa.android.Models.UserIAMSA
import com.grupo.iamsa.android.Network.Manager.AccountManager
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        make_request.setOnClickListener {
            /*
            AccountManager.changePassword("Prueba123","1234565","CARLOS@BAMBU-MOBILE.COM") { responce, error ->
                Log.e("Login","Responce : ${responce?.aMensaje}")
            }

            AccountManager.recoverAccount("omar@bambu-mobile.com"){ responce, error ->
                Log.e("Login","Responce : ${responce?.nError}")
            }
            AccountManager.loginEmail("omar@bambu-mobile.com","IJ8EUB227") { responce, error ->
                Log.e("Login","Responce : ${responce?.dec_responce?.value}")
            }
            */
        }
        make_request2.setOnClickListener {
            var user = UserIAMSA()
            user.motherName = "ramirez"
            user.fatherName = "sanchez"
            user.email = "rswomarrrrs@ciencias.unam.mx"
            user.name = "omar"
            AccountManager.register(user) { responce ,error ->
                Log.e("Responce","Responce :${responce.toString()} ")
            }
        }
    }
}
