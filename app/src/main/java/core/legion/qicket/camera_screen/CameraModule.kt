package core.legion.qicket.camera_screen

import dagger.Binds
import dagger.Module

@Module
abstract class CameraModule {

    @Binds
    abstract fun view(activity: CameraActivity): CameraFacade.View

    @Binds
    abstract fun presenter(presenter: CameraPresenter): CameraFacade.Presenter
}