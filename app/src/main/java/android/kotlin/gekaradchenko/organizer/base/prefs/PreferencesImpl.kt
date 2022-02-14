package android.kotlin.gekaradchenko.organizer.base.prefs

import android.content.Context
import android.content.SharedPreferences
import android.kotlin.gekaradchenko.organizer.util.add
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferencesImpl @Inject constructor(context: Context) : PreferencesManager {

    companion object {
        //for const
        private const val NAME = "shared_pref"

        private const val NAME_TEST = "name_test"
    }

    private val prefs = context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
    private val TAG by lazy { javaClass.simpleName }


    override var name: String
        get() = prefs.getString(NAME_TEST, "") ?: ""
        set(value) {
            prefs.add(NAME_TEST, value)
        }
}


