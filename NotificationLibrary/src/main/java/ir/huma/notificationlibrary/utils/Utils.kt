package ir.huma.notificationlibrary.utils

import android.content.Context
import android.net.wifi.WifiManager
import java.lang.Exception
import java.net.NetworkInterface
import java.util.*

object Utils {
    fun getMacAddress(context: Context): String? {

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
            try {
                val wifiManager = context.getSystemService(WifiManager::class.java) as WifiManager
                val getFactoryMacAddresses = WifiManager::class.java.getMethod("getFactoryMacAddresses")
                getFactoryMacAddresses.isAccessible = true
                val macAddress = getFactoryMacAddresses.invoke(wifiManager) as Array<*>
                return macAddress[0].toString()
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return null
        } else {
            try {
                val all: List<NetworkInterface> = Collections.list(NetworkInterface.getNetworkInterfaces())
                for (nif in all) {
                    if (!nif.name.equals("wlan0", ignoreCase = true)) continue
                    val macBytes = nif.hardwareAddress ?: return ""
                    val res1 = StringBuilder()
                    for (b in macBytes) {
                        //res1.append(Integer.toHexString(b & 0xFF) + ":");
                        res1.append(String.format("%02X:", b))
                    }
                    if (res1.isNotEmpty()) {
                        res1.deleteCharAt(res1.lastIndex)
                    }
                    return res1.toString()
                }
            } catch (ex: Exception) {
                ex.printStackTrace()
            }
            return null
        }
    }


}