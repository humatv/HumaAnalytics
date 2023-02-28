package ir.huma.notificationlibrary.utils.webengage

import android.util.Log
import com.webengage.sdk.android.Analytics
import com.webengage.sdk.android.WebEngage
import ir.huma.notificationlibrary.data.AuthenticationApi
import ir.huma.notificationlibrary.data.model.AuthenticationRequestParameter
import ir.huma.notificationlibrary.data.model.UserAttributes
import ir.huma.notificationlibrary.data.model.UserUniqueIdInfo
import ir.huma.notificationlibrary.data.util.ServiceBuilder
import ir.huma.notificationlibrary.utils.AnalyticsUtil
import ir.huma.notificationlibrary.utils.ConverterExtension.getValidPhone
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*


class WebEngageAnalyticsUtil : AnalyticsUtil {
    private  val TAG = "WebEngageAnalyticsUtil"

    override fun loginUser(
        userManagerUserId: String?,
        isDevFlavor: Boolean,
        phoneNumber: String?,
        macAddress: String?
    ) {
        Log.i(TAG, "setLoginUniqueIdForWebEngage: Start")
        if(!userManagerUserId.isNullOrBlank()){
            WebEngage.get().user().login(userManagerUserId)
        }
        else if(!phoneNumber.isNullOrBlank()){
            getUserIdFromServer(isDevFlavor = isDevFlavor,phoneNumber = phoneNumber,macAddress = null){userId->
                WebEngage.get().user().login(userId)
            }
        }
        else if(!macAddress.isNullOrBlank()){
            getUserIdFromServer(isDevFlavor = isDevFlavor,phoneNumber = null,macAddress = macAddress){userId->
                WebEngage.get().user().login(userId)
            }
        }
        else{
            Log.e(TAG, "setLoginUniqueIdForWebEngage: All input arguments are Null")
        }
    }


    override fun logoutUser() {
        WebEngage.get().user().logout()
    }

    override fun sendEvent(
        eventName: String,
        inputEventParameters: Map<String, Any>?,
        option: Analytics.Options?
    ) {
        if (eventName.startsWith("we_"))
            throw InputMismatchException("Event name must not start with we_")

        val weAnalytics = WebEngage.get().analytics()
        if (inputEventParameters==null){
            weAnalytics.track(eventName,option)
        }
        else{
            weAnalytics.track(eventName,inputEventParameters,option)
        }
    }

    override fun setUserAttribute(userAttributes: UserAttributes) {
        val user = WebEngage.get().user()
        userAttributes.phoneNumber?.let {phoneNumber->
            val validPhoneNumber = phoneNumber.getValidPhone()
            if (validPhoneNumber==null){
                Log.e(TAG, "setUserAttribute: Not Correct User Phone Number")
            }
            else{
                user.setPhoneNumber(validPhoneNumber)
            }
            userAttributes.firstName?.let{user.setFirstName(it)}
            userAttributes.lastName?.let{user.setLastName(it)}
            userAttributes.city?.let{user.setAttribute("city",it)}
            userAttributes.email?.let{user.setEmail(it)}
            userAttributes.avatarUrl?.let{user.setAttribute("avatar_url",it)}
        }


    }

    private fun getUserIdFromServer(
        phoneNumber: String?,
        macAddress: String?,
        isDevFlavor:Boolean=false,
        onServerResponse:(userId:String)->Unit){
        if(phoneNumber.isNullOrBlank() && macAddress.isNullOrBlank())
            throw NullPointerException("All input arguments are Null")

        val serverResponse =if(isDevFlavor)
            ServiceBuilder.DevServiceBuilder.buildService(AuthenticationApi::class.java)
        else
            ServiceBuilder.ProdServiceBuilder.buildService(AuthenticationApi::class.java)

        serverResponse.getUserUniqueId(AuthenticationRequestParameter(macAddress = macAddress?:"",phone = phoneNumber?:"")).enqueue(
            object : Callback<UserUniqueIdInfo?> {
                override fun onResponse(
                    call: Call<UserUniqueIdInfo?>,
                    response: Response<UserUniqueIdInfo?>,
                ) {
                    if (response.isSuccessful) {
                        if(response.body() == null){
                            onFailure(call,NullPointerException("body is null"))
                        } else {
                            val responseBody = response.body()
                            val userId = responseBody?.userId
                            if(!userId.isNullOrBlank()){
                                onServerResponse(userId)
                            }
                        }
                    } else if (response.code() == 401) {
                        Log.e("Retrofit", "onResponse: 401 for ${call.request().body()}", )
                    }
                    Log.d(TAG, "onResponse: ")
                }

                override fun onFailure(call: Call<UserUniqueIdInfo?>, t: Throwable) {
                    Log.e(TAG, "onFailure: $t")
                }

            }
        )
    }

}