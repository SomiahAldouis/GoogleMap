package somiah.jad.googlemap

import java.io.Serializable

data class Places(
    var name: String,
    var address: String,
    var lat: Double,
    var lng: Double
):Serializable