package com.example.myapplication.apiServices.network


import com.example.myapplication.Constant.SERVER_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


interface AppApi {

    companion object {
        operator fun invoke(
            networkConnectionInterceptor: NetworkConnectionInterceptor
        ): AppApi {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            val okkHttpclient = OkHttpClient.Builder()
                .addInterceptor(networkConnectionInterceptor)
                .addInterceptor(logging)
                .readTimeout(2, TimeUnit.MINUTES)
                .build()

            return Retrofit.Builder()
                .client(okkHttpclient)
                .baseUrl(SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())

                .build()
                .create(AppApi::class.java)
        }
    }

}


