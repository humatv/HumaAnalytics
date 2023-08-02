package ir.huma.notificationlibrary.utils.personalizition.webengage

import com.webengage.personalization.callbacks.WEPlaceholderCallback
import com.webengage.personalization.data.WECampaignData

interface CustomPlaceholderCallback:WEPlaceholderCallback {
    override fun onRendered(data: WECampaignData) {
        // no need to handle this callback because custom type Inline content
    }
}