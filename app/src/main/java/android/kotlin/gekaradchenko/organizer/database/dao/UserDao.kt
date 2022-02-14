package android.kotlin.gekaradchenko.organizer.database.dao

import android.kotlin.gekaradchenko.organizer.database.UserTable
import androidx.room.Dao

@Dao
abstract class UserDao : BaseDao<UserTable>() {
}