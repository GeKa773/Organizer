package android.kotlin.gekaradchenko.organizer.database.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Update

abstract class BaseDao<T> {
    @Insert(onConflict = IGNORE)
    abstract fun insert(t: T): Long

    @Insert(onConflict = IGNORE)
    abstract fun insertAll(t: List<T>)

    @Delete
    abstract fun delete(t: T)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    abstract fun update(t: T): Int

    open fun upsert(t:T){
        if (insert(t) == -1L) {
            update(t)
        }
    }
}