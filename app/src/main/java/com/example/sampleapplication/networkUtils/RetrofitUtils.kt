package com.example.sampleapplication.networkUtils

import com.example.sampleapplication.BASE_URL
import com.example.sampleapplication.BREED_ENDPOINT
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
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