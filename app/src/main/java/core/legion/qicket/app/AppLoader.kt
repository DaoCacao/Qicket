package core.legion.qicket.app

import dagger.android.support.DaggerApplication
import io.realm.Realm

class AppLoader : DaggerApplication() {

    override fun applicationInjector() = DaggerAppComponent.create()!!

    override fun onCreate() {
        super.onCreate()

        Realm.init(applicationContext)
    }
}