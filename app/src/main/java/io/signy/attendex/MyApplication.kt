package io.signy.attendex

import android.app.Application
import com.google.gson.Gson
import com.tbc.xid.apiservices.network.NetworkConnectionInterceptor
import io.signy.attendex.AppCommon
import io.signy.attendex.apiServices.network.AppApi
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton


class MyApplication : Application(), KodeinAware {
    override lateinit var kodein: Kodein

    override fun onCreate() {
        super.onCreate()

        initKodein()
    }

    public fun initKodein() {
        kodein = Kodein.lazy {
            import(androidXModule(this@MyApplication))
            bind() from singleton { AppCommon(instance()) }

            bind() from singleton { Gson() }


// NETWORK RELATED
            bind() from singleton { NetworkConnectionInterceptor(instance()) }
            bind() from singleton { AppApi(instance()) }


        }

//MVVM
//        bind() from singleton {
//            AccountRepositories(
//                instance()
//            )
//        }

//        bind() from provider { AddDocumentViewModelFactory(instance()) }
    }
}