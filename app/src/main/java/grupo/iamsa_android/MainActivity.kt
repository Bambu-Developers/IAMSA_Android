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
            LocationManager.getOriginis()
        }
        make_request2.setOnClickListener {

        }
    }
}
