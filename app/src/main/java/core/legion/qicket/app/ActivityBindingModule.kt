package core.legion.qicket.app

import core.legion.qicket.main_screen.MainActivity
import core.legion.qicket.main_screen.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityBindingModule {

    @ContributesAndroidInjector(modules = [MainModule::class])
    fun mainActivity(): MainActivity
}