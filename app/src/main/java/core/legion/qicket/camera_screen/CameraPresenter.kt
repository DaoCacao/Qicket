package core.legion.qicket.camera_screen

import javax.inject.Inject

class CameraPresenter @Inject constructor() : CameraFacade.Presenter {

    @Inject lateinit var view: CameraFacade.View

    private var isTorchOn = false

    override fun onResume() {
        if (view.hasCameraPermission()) view.startCamera()
        else view.askCameraPermission()
    }
    override fun onPause() = view.stopCamera()

    override fun onPermissionGranted() = view.startCamera()

    override fun onTorchClick() {
        isTorchOn = !isTorchOn
        view.enableTorch(isTorchOn)
    }
}