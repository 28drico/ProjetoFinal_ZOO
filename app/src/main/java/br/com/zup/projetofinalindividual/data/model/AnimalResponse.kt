package br.com.zup.projetofinalindividual.data.model

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class AnimalResponse (
        @SerializedName("info")
        val info: Info,
        @SerializedName("results")
        val animaisResult: List<AnimalResult>
        )