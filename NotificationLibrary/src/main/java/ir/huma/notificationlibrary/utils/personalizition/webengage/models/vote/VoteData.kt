package ir.huma.notificationlibrary.utils.personalizition.webengage.models.vote

import androidx.annotation.Keep
import ir.huma.notificationlibrary.utils.personalizition.webengage.models.PersonalizationModel

@Keep
data class VoteData(
    val id:String?,
    val questionId: String?,
    val title:String?,
    val description:String?,
    val choiceList: List<String>?,
    val condition: String?,
    val positiveButtonTitle:String?,
    val negativeButtonTitle:String?,
    val metaData:String?,
): PersonalizationModel{
    companion object{
        const val minChoice = 1
        const val maxChoice = 6
    }
}
