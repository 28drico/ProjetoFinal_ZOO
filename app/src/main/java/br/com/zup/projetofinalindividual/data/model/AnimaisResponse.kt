package br.com.zup.projetofinalindividual.data.model


import com.google.gson.annotations.SerializedName

data class AnimaisResponse(
    @SerializedName("active_time")
    val activeTime: String = "",
    @SerializedName("animal_type")
    val animalType: String = "",
    @SerializedName("diet")
    val diet: String = "",
    @SerializedName("geo_range")
    val geoRange: String = "",
    @SerializedName("habitat")
    val habitat: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("image_link")
    val imageLink: String = "",
    @SerializedName("latin_name")
    val latinName: String = "",
    @SerializedName("length_max")
    val lengthMax: String = "",
    @SerializedName("length_min")
    val lengthMin: String = "",
    @SerializedName("lifespan")
    val lifespan: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("weight_max")
    val weightMax: String = "",
    @SerializedName("weight_min")
    val weightMin: String = "",

    @SerializedName("results")
    val animaisResult: List<AnimalResult>

)