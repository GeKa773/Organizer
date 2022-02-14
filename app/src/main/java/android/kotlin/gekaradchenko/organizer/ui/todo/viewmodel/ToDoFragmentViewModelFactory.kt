package android.kotlin.gekaradchenko.organizer.ui.todo.viewmodel

import android.kotlin.gekaradchenko.organizer.base.data.DataManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

import javax.inject.Inject

class ToDoFragmentViewModelFactory
@Inject constructor(private val dataManager: DataManager) :
    ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ToDoFragmentViewModel::class.java)) {
            return ToDoFragmentViewModel(dataManager) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }


}