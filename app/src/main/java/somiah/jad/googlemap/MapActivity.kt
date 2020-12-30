package somiah.jad.googlemap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.dynamic.SupportFragmentWrapper
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapActivity : AppCompatActivity() , OnMapReadyCallback {

    lateinit var category: Categories

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map_fragment) as SupportMapFragment
        mapFragment.getMapAsync(this)
        category = intent.getSerializableExtra("category item") as Categories
        supportActionBar?.title  = category.title
    }

    override fun onMapReady(p0: GoogleMap?) {

        for(place in category.items){
            val latlng = LatLng(place.lat,place.lng)
            p0?.addMarker((MarkerOptions().position(latlng).title(place.name).snippet(place.address)))
            p0?.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng,16.91f))
        }

    }
}