package android.kotlin.gekaradchenko.organizer.ui.todo.viewmodel

import android.kotlin.gekaradchenko.organizer.base.base.BaseViewModel
import android.kotlin.gekaradchenko.organizer.base.data.DataManager
import android.kotlin.gekaradchenko.organizer.data.pojo.CalendarData
import android.kotlin.gekaradchenko.organizer.util.CalendarUtil
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList


class ToDoFragmentViewModel
@Inject constructor(val dataManager: DataManager) : BaseViewModel() {

    override fun create() {
        getCalendarArray()
    }

    private val _calendarList = MutableLiveData<ArrayList<CalendarData>>()
    val calendarList: LiveData<ArrayList<CalendarData>> = _calendarList

//    fun setCalendarList() {
//        val array = ArrayList<CalendarData>()
//        repeat(30) {
//            array.add(CalendarData(it, "$it", false, it, false))
//        }
//        _calendarList.value = array
//    }

    fun focusOnDate(item: CalendarData) {
        val array = calendarList.value ?: ArrayList<CalendarData>()
        array.forEach {
            it.isFocus = it.id == item.id
            it.isFocusLiveData.value = it.id == item.id
        }
        _calendarList.value = array
    }

    fun getCalendarArray() {
        val array = ArrayList<CalendarData>()
        val calendarUtil = CalendarUtil()
        val todayDay = calendarUtil.getCalendar()[Calendar.DAY_OF_MONTH]
        repeat(calendarUtil.maxMonth()) {
            val day = it + 1
            array.add(CalendarData(day,
                "$day",
                day == todayDay,
                0,
                day == todayDay,
                MutableLiveData(day == todayDay)))
        }
        _calendarList.value = array

    }


}