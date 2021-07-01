package com.example.newsapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsInterface {

    @GET("v2/top-headlines")
    fun fetchHeadlines(@Query("country") country: String, @Query("apiKey") apiKey: String): Call<News>

    // https://newsapi.org/v2/top-headlines?country=in&apiKey=API_KEY
}