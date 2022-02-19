package android.kotlin.gekaradchenko.organizer.data.pojo

import androidx.annotation.Keep
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

@Keep
data class CalendarData(
    val id: Int,
    val text: String,
    val isToday:Boolean,
    val recordsCount: Int,
    var isFocus: Boolean,
    val isFocusLiveData: MutableLiveData<Boolean> = MutableLiveData(false),
)