package core.legion.qicket.qr

import dagger.Binds
import dagger.Module

@Module
abstract class QRManagerModule {

    @Binds
    abstract fun qrManager(qrManager: QRManager): IQRManager
}