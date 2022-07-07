package es.ipow.sharedpreferences

import android.app.Application

// Al heredar de Application() esta clase se ejecutará
// al principio, antes de ejecutar MainActivity
class SharedPreferences:Application() {
    companion object{
        lateinit var prefs: Prefs
    }
    override fun onCreate() {
        super.onCreate()
        prefs = Prefs(applicationContext)
    }
}