package core.legion.qicket.app

import android.content.Context
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    abstract fun context(appLoader: AppLoader): Context
}