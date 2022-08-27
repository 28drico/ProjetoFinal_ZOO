package br.com.zup.projetofinalindividual.data.model


import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "animals")
data class AnimalResponseItem(
    @SerializedName("active_time")
    @ColumnInfo(name = "active_time") val activeTime: String,
    @SerializedName("animal_type")
    @ColumnInfo(name = "animal_type") val animalType: String,
    @SerializedName("diet")
    val diet: String ,
    @SerializedName("geo_range")
    @ColumnInfo(name = "geo_range")val geoRange: String,
    @SerializedName("habitat")
    val habitat: String ,
    @SerializedName("id")
    @PrimaryKey
    val id: Int,
    @SerializedName("image_link")
    @ColumnInfo(name = "image_link")val imageLink: String,
    @SerializedName("latin_name")
    @ColumnInfo(name = "latin_name")val latinName: String,
    @SerializedName("length_max")
    @ColumnInfo(name = "length_max")val lengthMax: String,
    @SerializedName("length_min")
    @ColumnInfo(name = "length_min")val lengthMin: String,
    @SerializedName("lifespan")
    val lifespan: String ,
    @SerializedName("name")
    val name: String ,
    @SerializedName("weight_max")
    @ColumnInfo(name = "weight_max")val weightMax: String,
    @SerializedName("weight_min")
    @ColumnInfo(name = "weight_min")val weightMin: String
):Parcelable