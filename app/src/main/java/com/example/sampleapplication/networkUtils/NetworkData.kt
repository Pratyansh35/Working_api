package com.example.sampleapplication.networkUtils

import androidx.annotation.StringRes
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET
import java.lang.ref.PhantomReference

data class BreedDetails(
    @SerializedName("name")
    val name: String,

    @SerializedName("breed_group")
    val category: String,
    @SerializedName("origin")
    val origin: String,

    @SerializedName("image")
    val iamgeReference: DogImage
    )
data class DogImage(
    @SerializedName("url")
    val imageUrl: String
)
