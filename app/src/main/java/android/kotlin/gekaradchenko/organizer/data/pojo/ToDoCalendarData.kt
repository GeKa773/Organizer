package android.kotlin.gekaradchenko.organizer.data.pojo

import androidx.annotation.Keep

@Keep
data class ToDoCalendarData(
    val id: Long,
    val title: String,
    val text: String,
)