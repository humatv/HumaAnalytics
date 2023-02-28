package ir.huma.notificationlibrary.data


import ir.huma.notificationlibrary.data.model.AuthenticationRequestParameter
import ir.huma.notificationlibrary.data.model.UserUniqueIdInfo
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Url

interface AuthenticationApi {

    @POST("client/getUserId")
    fun getUserUniqueId(@Body authenticationInput: AuthenticationRequestParameter,): Call<UserUniqueIdInfo?>

}