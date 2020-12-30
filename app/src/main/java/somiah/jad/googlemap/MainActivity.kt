package somiah.jad.googlemap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.gms.maps.model.LatLng

class MainActivity : AppCompatActivity() {
    lateinit var mapBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mapBtn = findViewById(R.id.map_btn)
        mapBtn.setOnClickListener {

            val placeThawraHospital = Places("مستشفى الثورة",
                "مستشفى الثورة العام النموذجي",
                15.3508298 ,
                44.2199057
            )
            val placeRepublicanHospital = Places("المستشفى الجمهوري",
                "هيئة المستشفى الجمهوري التعليمي في صنعاء",
                15.3456139 ,
                44.1928109
            )
            val placeAlOmHospital = Places("مستشفى الأم",
                "مستشفى الأم التخصصي",
                15.3428921 ,
                44.1929849
            )

            val places = mutableListOf<Places>()
            places.add(placeThawraHospital)
            places.add(placeRepublicanHospital)
            places.add(placeAlOmHospital)
            val hospital = Categories("قائمة المستشفيات",places)

            val intent = Intent(this,MapActivity::class.java)
            intent.apply {
                putExtra("category item" , hospital)
            }
            startActivity(intent)
        }
    }
}