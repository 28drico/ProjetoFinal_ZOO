package br.com.zup.projetofinalindividual.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "animals")
data class AnimalResult (
    @SerializedName("id")
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0,

    @SerializedName("name")
    var name: String = "",

    @SerializedName("latin_name")
    var latinName: String = "",

    @SerializedName("animal_type")
    var typeAnimal: String = "",

    @SerializedName("active_time")
    var activeTime: String = "",

    @SerializedName("length_min")
    var lengthMin: String = "",

    @SerializedName("length_max")
    var lengthMax: String = "",

    @SerializedName("weight_min")
    var weightMin: String = "",

    @SerializedName("weight_max")
    var weightMax: String = "",

    @SerializedName("lifespan")
    var lifespan: String = "",

    @SerializedName("habitat")
    var habitat: String = "",

    @SerializedName("diet")
    var diet: String = "",

    @SerializedName("geo_range")
    var geo_range: String = "",

    @SerializedName("image_link")
    var image_link: String = "",

    var isFavorite : Boolean
        ):Parcelable