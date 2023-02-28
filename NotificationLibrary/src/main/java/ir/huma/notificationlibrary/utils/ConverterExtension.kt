package ir.huma.notificationlibrary.utils

import java.util.regex.Matcher
import java.util.regex.Pattern

object ConverterExtension {
    fun String.getValidPhone(): String? {
        val phone = if (this.startsWith("0")) {
            this.replaceFirst("0", "+98")
        }
        else
            this

        if (checkValidFormatE164(phone)) {
            return phone
        }
        return null
    }

    private fun checkValidFormatE164(phoneNumber: String): Boolean {
        val a = phoneNumber.length
        val patternE164: Pattern = Pattern.compile("^\\+[1-9]\\d{1,14}$")
        val matcher: Matcher = patternE164.matcher(phoneNumber)

        return matcher.matches() && phoneNumber.startsWith("+989") && phoneNumber.length == 13
    }
}