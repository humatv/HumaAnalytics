package ir.huma.notificationlibrary.data.util

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {
    object DevServiceBuilder {

        private val retrofit =buildRetrofitService("https://oauth2-dev.huma.ir/api/")

        fun<T> buildService(service: Class<T>): T{
            return retrofit.create(service)
        }
    }
    object ProdServiceBuilder {

        private val retrofit =buildRetrofitService("https://oauth2.huma.ir/api/")

        fun<T> buildService(service: Class<T>): T{
            return retrofit.create(service)
        }
    }

    private fun buildRetrofitService(baseUrl:String): Retrofit {
         val client = OkHttpClient.Builder()
             .build()
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
}