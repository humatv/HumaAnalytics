package ir.huma.notificationlibrary.utils.personalizition.webengage

import ir.huma.notificationlibrary.utils.personalizition.PersonalizationUtil
import org.junit.Test
import org.junit.Before

internal class WebEngagePersonalizationUtilTestClass {

    @Before
    fun setUp() {
    }

    @Test
    fun getVoteDataFromWebEngage() {
    }

    @Test
    fun getPromotionDataFromWebEngage() {
    }

    @Test
    fun getRawDataFromWebEngage() {
    }

    @Test
    fun getJsonDataFromWebEngage() {
        PersonalizationUtil.getJsonDataFromWebEngage<TestModel>("test"){

        }
    }

    @Test
    fun getJsonStringDataFromWebEngage() {
    }
    data class TestModel(
        val id:String
    )
}