package somiah.jad.googlemap

import java.io.Serializable

data class Categories(
    var title: String,
    var items : List<Places>
):Serializable