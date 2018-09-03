package core.legion.qicket.mediaManager

import dagger.Binds
import dagger.Module

@Module
abstract class MediaManagerModule {

    @Binds
    abstract fun mediaManager(mediaManager: MediaManager): IMediaManager
}