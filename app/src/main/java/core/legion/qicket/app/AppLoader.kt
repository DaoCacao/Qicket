package core.legion.qicket.app

import dagger.android.support.DaggerApplication
import io.realm.Realm
import javax.inject.Inject

class AppLoader @Inject constructor() : DaggerApplication() {

    override fun applicationInjector() = DaggerAppComponent.builder().appModule(AppModule(this)).build()!!

    override fun onCreate() {
        super.onCreate()

        Realm.init(applicationContext)
    }
}