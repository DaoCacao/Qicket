package core.legion.qicket.app

import core.legion.qicket.qr.QRManagerModule
import core.legion.qicket.realm.RealmManagerModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class, AppModule::class, ActivityBindingModule::class,
    RealmManagerModule::class, QRManagerModule::class])
interface AppComponent : AndroidInjector<AppLoader>