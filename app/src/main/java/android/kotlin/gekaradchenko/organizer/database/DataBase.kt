package android.kotlin.gekaradchenko.organizer.database

import android.kotlin.gekaradchenko.organizer.database.dao.UserDao
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    version = VERSION,
    exportSchema = false,
    entities = [UserTable::class]
)
@TypeConverters()
abstract class DataBase : RoomDatabase() {
    abstract fun userDao(): UserDao
}


const val VERSION = 1
const val DATABASE_NAME = "Database"