package core.legion.qicket.app

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {

    @Provides
    @Singleton
    fun context() = context
}