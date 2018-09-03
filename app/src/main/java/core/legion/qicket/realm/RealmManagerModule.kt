package core.legion.qicket.realm

import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RealmManagerModule {

    @Binds
    @Singleton
    abstract fun realmManager(realmManager: RealmManager): IRealmManager
}