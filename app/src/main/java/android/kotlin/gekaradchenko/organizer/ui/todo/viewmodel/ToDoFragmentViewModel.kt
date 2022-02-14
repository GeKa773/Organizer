package android.kotlin.gekaradchenko.organizer.ui.todo.viewmodel

import android.kotlin.gekaradchenko.organizer.base.base.BaseViewModel
import android.kotlin.gekaradchenko.organizer.base.data.DataManager
import android.kotlin.gekaradchenko.organizer.data.pojo.CalendarData
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject


class ToDoFragmentViewModel
@Inject constructor(val dataManager: DataManager) : BaseViewModel() {

    private val _calendarList = MutableLiveData<ArrayList<CalendarData>>()
    val calendarList: LiveData<ArrayList<CalendarData>> = _calendarList

    fun setCalendarList() {
        val array = ArrayList<CalendarData>()
        repeat(30) {
            array.add(CalendarData(it, "$it", it, false))
        }
        _calendarList.value = array
    }

    fun focusOnDate(item: CalendarData) {
        val array = calendarList.value ?: ArrayList<CalendarData>()
        array.forEach {
            it.isFocus = it.id == item.id
            it.isFocusLiveData.value = it.id == item.id
        }
        _calendarList.value = array
    }


}