package android.kotlin.gekaradchenko.organizer

import android.app.Application
import android.content.Context
import android.kotlin.gekaradchenko.organizer.di.AppComponent
import android.kotlin.gekaradchenko.organizer.di.DaggerAppComponent
import dagger.android.support.DaggerAppCompatActivity


class MainApp : Application() {
    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
    }
}

val Context.appComponent: AppComponent
    get() = when (this) {
        is MainApp -> appComponent
        else -> this.applicationContext.appComponent
    }