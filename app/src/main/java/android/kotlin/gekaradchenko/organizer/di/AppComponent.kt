package android.kotlin.gekaradchenko.organizer.di

import android.app.Application
import android.content.Context
import android.kotlin.gekaradchenko.organizer.MainApp
import android.kotlin.gekaradchenko.organizer.base.data.AppDataManager
import android.kotlin.gekaradchenko.organizer.base.data.DataManager
import android.kotlin.gekaradchenko.organizer.base.prefs.PreferencesImpl
import android.kotlin.gekaradchenko.organizer.base.prefs.PreferencesManager
import android.kotlin.gekaradchenko.organizer.database.DATABASE_NAME
import android.kotlin.gekaradchenko.organizer.database.DataBase
import android.kotlin.gekaradchenko.organizer.ui.todo.ToDoFragment
import androidx.room.Room
import dagger.*
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent : AndroidInjector<MainApp> {

    fun inject(fragment: ToDoFragment)
    override fun inject(app: MainApp)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

}

@Module(includes = [AppBindModule::class])
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    internal fun provideDataBase(context: Context): DataBase {
        return Room.databaseBuilder(context, DataBase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration().build()
    }
}

@Module
interface AppBindModule {

    @Suppress("FunctionName")
    @Binds
    fun bindAppDataManager_to_DataManager(appDataManager: AppDataManager): DataManager

}