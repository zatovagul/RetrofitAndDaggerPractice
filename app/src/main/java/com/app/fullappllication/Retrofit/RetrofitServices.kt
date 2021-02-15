package com.app.fullappllication.Retrofit

import com.app.fullappllication.Model.Movie
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitServices {
    @GET("marvel")
    fun getMovieList(): Call<MutableList<Movie>>
}