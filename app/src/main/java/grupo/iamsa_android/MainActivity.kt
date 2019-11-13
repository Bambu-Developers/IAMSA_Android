package grupo.iamsa_android


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.grupo.iamsa.android.Models.UserIAMSA
import com.grupo.iamsa.android.Network.AccountManager
import com.grupo.iamsa.android.Network.LocationManager
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        make_request.setOnClickListener {
            AccountManager.loginUserName("APPVJM","TESTVJM") { responce,error ->
                Log.e("Responce","Responce : ")
            }
        }
        make_request2.setOnClickListener {
            var user = UserIAMSA()
            user.motherName = "ramirez"
            user.fatherName = "sanchez"
            user.email = "omarr22r@adhotmadil.com"
            user.name = "omar"
            AccountManager.register(user) { responce ,error ->
                Log.e("Responce","Responce : ")
            }
        }
    }
}
