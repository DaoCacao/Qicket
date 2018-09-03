package core.legion.qicket.app

import core.legion.qicket.camera_screen.CameraActivity
import core.legion.qicket.camera_screen.CameraModule
import core.legion.qicket.main_screen.MainActivity
import core.legion.qicket.main_screen.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityBindingModule {

    @ContributesAndroidInjector(modules = [MainModule::class])
    fun mainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [CameraModule::class])
    fun cameraActivity(): CameraActivity
}