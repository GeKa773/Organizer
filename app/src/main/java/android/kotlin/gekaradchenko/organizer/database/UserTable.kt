package android.kotlin.gekaradchenko.organizer.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = USER_TABLE)
class UserTable(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = USER_ID)
    val id: Long,
    @ColumnInfo(name = NAME)
    val name: String,
    @ColumnInfo(name = LAST_NAME)
    val lastName: String,
    @ColumnInfo(name = BIRTH_DATE)
    val birthDate: String,
    @ColumnInfo(name = ADDRESS)
    val address: String,
    @ColumnInfo(name = PHONE)
    val phone: String,
    @ColumnInfo(name = EMAIL)
    val email: String,
    @ColumnInfo(name = ICON_URL)
    val icon: String?,
    )

const val USER_TABLE = "user"
const val USER_ID = "user_id"
const val NAME = "name"
const val PROMO = "promo"
const val LAST_NAME = "last_name"
const val PHONE = "phone"
const val EMAIL = "email"
const val BIRTH_DATE = "birth_date"
const val SEX = "sex"
const val KINSHIP = "kinship_"
const val ADDRESS = "address"
const val POLICY_NUMBER = "policy_number"
const val ICON_URL = "icon_url"
const val SUBSCRIPTION = "subscription"