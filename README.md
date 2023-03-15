
<div align="center">


  <h1>HumaAnalytics</h1>
  
  <p>
    A Library For Sending Event And User Attribute For All Huma Apps
  </p>
  
</div>

<!-- About the Library -->
## :star2: About the Project



<!-- TechStack -->
### :space_invader: How to use


Installation
-----------
add this dependency in your build.gradle(app level)
```
implementation 'com.github.humatv:HumaAnalytics:1.1.1'
implementation 'com.google.android.gms:play-services-auth:20.4.1'
```

and add repository in your project level

```
 repositories {
        google()
       ...
        maven { url 'https://jitpack.io' }
    }
```

sync and build your project then follow below steps: 



1. step 1:

extentend your application class from AnalyticsApplication and pass your BuildConfig.DEBUG, and BuildConfig.FLAVOR
```
class MyExampleApplication : AnalyticsApplication(
    isBuildConfigDebug = BuildConfig.DEBUG,
    buildConfigFlavor =  BuildConfig.FLAVOR) {
}
```
- FLAVOR must be "prod" and "dev"

If you can not use inheritance for your Application class so you can add this line at the end of onCreat in your Application class instead

```
WebEngageConfig().initializeWebEngage(this, webEngageLicensesKey, isDebugMode)
```

2. Step 2 :

Disable automatic backup inside the application tag in your AndroidManifest.xml file.
```
<application
        ...
        android:allowBackup="false"
        ....
                >
```
If your application needs allowBackup to be set as true, then call me :)

3. Step 3 :

call AnalyticsUtil.loginUser() in first level of entrance to your application (for Example in Application Class)
you can pass 3 argument for login user :
```
 /**
         * You acn login with "user_unique_Id_from_user_manager" which you got from
         * UserManager Server
         * it's recommend to pass userManagerUserId */
        AnalyticsUtil.loginUser(userManagerUserId = "user_unique_Id_from_user_manager",isDevFlavor)


        /**
         * Or You acn login with user's "phoneNumber"
         * example : "09151646562"
         */
        AnalyticsUtil.loginUser(userManagerUserId = null,phoneNumber = "09151646562", isDevFlavor = isDevFlavor, )


        /**
         * Or You acn login with "device mac Address" which you got from
         * UserManager Server
         * it's not Recommended*/
        AnalyticsUtil.loginUser(userManagerUserId = null, macAddress = "4f:54:23:fs:50", isDevFlavor = isDevFlavor, )

                >
```


Usage
-----

* Send Events:
example of events without parameters:
```
        AnalyticsUtil.sendEvent("test_event_name")
```
example of events with parameters:
```

        val addedToCartAttributes: MutableMap<String, Any> = HashMap()
        addedToCartAttributes["Product ID"] = 1337
        addedToCartAttributes["Price"] = 39.80
        addedToCartAttributes["Quantity"] = 1
        addedToCartAttributes["Product"] = "Givenchy Pour Homme Cologne"
        addedToCartAttributes["Category"] = "Fragrance"
        addedToCartAttributes["Currency"] = "USD"
        addedToCartAttributes["Discounted"] = true

        AnalyticsUtil.sendEvent("test_event_name",addedToCartAttributes)
```

* SetUser Attributes: (just for HumaStore Project when user update profile)

```
 AnalyticsUtil.setUserAttribute(
            UserAttributes(firstName = "first_name",
                lastName = "last_name",
                phoneNumber = "phoneNumber",
                city = "city",
                email = "email",
                avatarUrl = "avatarUrl"
            ))
```

* Login User: 
be careful to login user when user log in 

* Logout User: 

```
AnalyticsUtil.logoutUser()

```

<!-- Contributing -->
## :wave: Contributing

<a href="https://github.com/Louis3797/awesome-readme-template/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=Louis3797/awesome-readme-template" />
</a>


Contributions are always welcome!


<!-- Contact -->
## :handshake: Contact

BaseTeam Huma 


