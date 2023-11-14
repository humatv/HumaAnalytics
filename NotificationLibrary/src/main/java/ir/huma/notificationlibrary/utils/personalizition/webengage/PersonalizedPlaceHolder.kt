package ir.huma.notificationlibrary.utils.personalizition.webengage

import android.util.Log
import com.webengage.personalization.data.WECampaignData
import ir.huma.notificationlibrary.utils.personalizition.webengage.mapper.PersonalizationMapper
import ir.huma.notificationlibrary.utils.personalizition.webengage.mapper.PersonalizationMapperImpl
import ir.huma.notificationlibrary.utils.personalizition.webengage.models.PersonalizationModel

abstract class PersonalizedPlaceHolder<T: PersonalizationModel>(private val onDataReceivedCallback: (data: T?) -> Unit):CustomPlaceholderCallback {
    private val personalizationMapper: PersonalizationMapper = PersonalizationMapperImpl()

    override fun onDataReceived(data: WECampaignData) {
        data.apply {
            stopRendering()
            trackImpression()
        }
        val personalizationModel = personalizationMapper.mapToPersonalization(data)
        if (personalizationModel==null)
            onDataReceivedCallback.invoke(null)
        else
            onDataPrepared(personalizationModel)
    }

    override fun onPlaceholderException(
        campaignId: String?,
        targetViewId: String,
        error: Exception,
    ) {
        Log.e(
            "AnalyticHuma",
            "onPlaceholderException PersonalizedData: campaignId:$campaignId  targetViewId:$targetViewId \n ${error.message}",
        )
        onDataReceivedCallback.invoke(null)
    }

    private inline fun <reified T> PersonalizationModel.checkType(): Boolean = this is T
    abstract fun onDataPrepared(data: PersonalizationModel)

}