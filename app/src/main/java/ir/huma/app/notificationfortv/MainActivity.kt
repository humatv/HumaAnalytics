package ir.huma.app.notificationfortv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.huma.notificationlibrary.utils.analytics.AnalyticsUtil

class MainActivity : AppCompatActivity() {
    // Get an instance of ‘Analytics’ object


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addedToCartAttributes: MutableMap<String, Any> = HashMap()
        addedToCartAttributes["Product ID"] = 1337
        addedToCartAttributes["Price"] = 39.80
        addedToCartAttributes["Quantity"] = 1
        addedToCartAttributes["Product"] = "Givenchy Pour Homme Cologne"
        addedToCartAttributes["Category"] = "Fragrance"
        addedToCartAttributes["Currency"] = "USD"
        addedToCartAttributes["Discounted"] = true

        AnalyticsUtil.sendEvent("test_event_name",addedToCartAttributes)


    }
}