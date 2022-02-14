package android.kotlin.gekaradchenko.organizer.base.data

import android.kotlin.gekaradchenko.organizer.base.prefs.PreferencesImpl
import android.kotlin.gekaradchenko.organizer.database.DataBase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppDataManager @Inject constructor(
    private val preferences: PreferencesImpl,
    private val dataBase: DataBase,
) : DataManager {


    /*-----------------------------PREFS-------------------------------*/

    override var name: String
        get() = preferences.name
        set(value) {
            preferences.name = value
        }


    /*-----------------------------ROOM-------------------------------*/
}