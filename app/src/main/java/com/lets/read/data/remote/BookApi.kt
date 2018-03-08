package com.lets.read.data.remote

/**
 * @author Mateus Andrade
 * @since 06/03/2018
 */

import com.lets.read.data.model.ResponseApi
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface BookApi {

    @GET("volumes")
    abstract fun getBooks(@Query("q") q: String): Call<ResponseApi>

    companion object Factory {
        fun create(): BookApi {
            val retrofit = Retrofit.Builder()
                    .baseUrl("https://www.googleapis.com/books/v1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            return retrofit.create(BookApi::class.java)
        }
    }
}