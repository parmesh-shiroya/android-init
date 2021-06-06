package io.signy.attendex

import android.content.Context
import android.content.SharedPreferences
import android.os.Handler
import java.io.File

class AppCommon(context: Context) {
//    val appFolder: File = File(dirChecker(context.filesDir.path + "/AppData"))
    private val sp: SharedPreferences =
        context.getSharedPreferences(Constant.PREF_NAME, Context.MODE_PRIVATE)
    private var mHandler: Handler? = null
    fun saveInSP(key: String, value: Any) {
        when (value) {
            is String -> sp.edit().putString(key, value).apply()
            is Boolean -> sp.edit().putBoolean(key, value).apply()
            is Int -> sp.edit().putInt(key, value).apply()
        }
    }


    fun getFromSP(key: String, def: Any): Any? {
        return when (def) {
            is String -> sp.getString(key, def)
            is Boolean -> sp.getBoolean(key, def)
            is Int -> sp.getInt(key, def)
            else -> null
        }
    }

    fun deleteFromSP(key: String) {
        try {
            sp.edit().remove(key).apply()
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }
}
