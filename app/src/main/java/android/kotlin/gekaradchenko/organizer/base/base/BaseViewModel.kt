package android.kotlin.gekaradchenko.organizer.base.base

import android.kotlin.gekaradchenko.organizer.base.data.DataManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

abstract class BaseViewModel : ViewModel() {
    private val viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.IO)

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    abstract fun create()
}