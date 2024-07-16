/**
 * Created by Dmitry Popov on 16.07.2024.
 */
package ru.vsibi.reactiveapp_rx.data

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import ru.vsibi.reactiveapp_rx.di.CommonModule

class ReactiveApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@ReactiveApp)
            modules(CommonModule())
        }
    }

}