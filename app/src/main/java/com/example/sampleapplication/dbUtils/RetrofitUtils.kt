package com.example.sampleapplication.dbUtils

import com.example.sampleapplication.networkUtils.BASE_URL
import com.example.sampleapplication.networkUtils.BREED_ENDPOINT
import com.example.sampleapplication.networkUtils.BreedDetails
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface DogDataService {
    @GET(BREED_ENDPOINT)
    fun fetchDogBreeds(): Call<List<BreedDetails>>
}

val api by lazy {
    Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(DogDataService::class.java)
}