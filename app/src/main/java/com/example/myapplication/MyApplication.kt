package com.example.myapplication

import android.app.Application
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

class MyApplication: Application(), KodeinAware {
    override lateinit var kodein: Kodein

    public fun initKodein() {
        kodein = Kodein.lazy {
//            import(androidXModule(this@MyApplication))
//            bind() from singleton { AppCommon(instance()) }

//            bind() from singleton { Gson() }


// NETWORK RELATED
//            bind() from singleton { NetworkConnectionInterceptor(instance()) }
//            bind() from singleton { AppApi(instance()) }


        }
    }
}