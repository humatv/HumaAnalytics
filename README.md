
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
implementation 'com.github.humatv:HumaAnalytics:1.3.1'
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

extend your application class from AnalyticsApplication and pass your BuildConfig.DEBUG, and BuildConfig.FLAVOR
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

AppPersonalization InLineContent 
-----
config: 
if Your Application class extended from **AnalyticsApplication** all thing is set up
on the other way add below code after setting up webengage

```
 WebengagePersonalizationConfig.initPersonalization()

```
           


whe have some type which can find in 
'''
ir.huma.notificationlibrary.utils.personalizition.webengage.models.PersonalizationType
'''
* miniPromotion
* miniPromotionList
* footer
* vote
* json
* rowData

can send your campain based on it and receive your data like below

```
 AnalyticsUtil.screenNavigated("ScreenName")
 PersonalizationUtil.getVoteData("parentId"){
    //yourData
 }

[//]: # can also call :(
 getVoteData
getPromotionData
getPromotionListData
getRawData
getJsonData
getJsonStringData)
```

**please be attention that you must call screenNavigated first**

* VoteData:
  | Attribute | Description | isOptional |
  | --- | --- | --- |
  | `type` | `vote` | NO |
  | `id` | for handel campaign id | NO |
  | `questionId` | for handel campaign different A/B testing | YES |
  | `title` | by using `title` and  `description` you can ask your vote by app UI | YES |
  | `description` | by using `title` and  `description` you can ask your vote by app UI | YES |
  | `condition` | can set any String to set condition and handle in your app| YES |
  | `positiveButtonTitle` | positive Button title in dialog | YES |
  | `negativeButtonTitle` | negative Button title in dialog | YES |
  | `metaData` | any meta data for mor information or handleable | YES |
  | `choice0` | choice in order | YES |
  | `choice1` | choice in order | YES |
  | `choice2` | choice in order | YES |
  | `choice3` | choice in order | YES |
  | `choice4` | choice in order | YES |
  | `choice5` | choice in order | YES |
  | `choice6` | choice in order | YES |

* miniPromotion:
  | Attribute | Description | isOptional |
  | --- | --- | --- |
  | `type` | `miniPromotion` | NO |
  | `id` | for handel campaign id | NO |
  | `title` | by using `title` and  `description` you can set by app UI | YES |
  | `description` | by using `title` and  `description` you can set by app UI | YES |
  | `imageUrl` | promotion image Url | NO |
  | `linkUrl` | promotion Link Url | YES |
  | `senderPackageName` | promotion owner packageName | YES |
  | `headerId` | any meta data for mor information or handleable | YES |
  | `badgeImageUrl` | badge image on promotion | YES |
  | `badgeTitle` | badge title text on promotion | YES |
  | `index` | order of item in mini promotion list | YES |

```
   `senderPackageName` and `linkUrl` is required for launcher mini promotion 
    in launcher `headerId` is mini promotion server headerId 
   in launcher just use one of `badgeImageUrl` or `badgeTitle` because overlays 
```



* footer:
  | Attribute | Description | isOptional |
  | --- | --- | --- |
  | `type` | `footer` | NO |
  | `title` | by using `title` and  `description` you can set by app UI | YES |
  | `description` | by using `title` and  `description` you can set by app UI | YES |
  | `linkUrl` | promotion Link Url | YES |
  | `senderPackageName` | promotion owner packageName | YES |

* miniPromotionList:
  | Attribute | Description | isOptional |
  | --- | --- | --- |
  | `type` | `miniPromotionList` | NO |
  | `id` | for handel campaign id | NO |
  | `title` | by using `title` and  `description` you can set by app UI | YES |
  | `senderPackageName` | promotion owner packageName | YES |
  | `index` | order of list page | YES |
  | `image1` | image of item in mini promotion list | YES |
  | `link1` | deepLink of item in mini promotion list | YES |
  | `image2` | image of item in mini promotion list | YES |
  | `link2` | deepLink of item in mini promotion list | YES |
  | `image3` | image of item in mini promotion list | YES |
  | `link3` | deepLink of item in mini promotion list | YES |
  | `image4` | image of item in mini promotion list | YES |
  | `link4` | deepLink of item in mini promotion list | YES |
  | `image5` | image of item in mini promotion list | YES |
  | `link5` | deepLink of item in mini promotion list | YES |

```
  ** `senderPackageName` is required for launcher mini promotion **
```

* json:
  | Attribute | Description | isOptional |
  | --- | --- | --- |
  | `type` | `json` | NO |
  | `jsonData` | Json valid format type of your data  | NO |

* rawData:
  | Attribute | Description | isOptional |
  | --- | --- | --- |
  | `type` | `rawData` | NO |

  ``` you can use key an value to use it and handle by yourself ```


<!-- Contributing -->

## :wave: Contributing

<a href="https://github.com/Louis3797/awesome-readme-template/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=Louis3797/awesome-readme-template" />
</a>


Contributions are always welcome!


<!-- Contact -->
## :handshake: Contact

BaseTeam Huma 


