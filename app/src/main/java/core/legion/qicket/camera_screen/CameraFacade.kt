package core.legion.qicket.camera_screen

interface CameraFacade {

    interface View {
        fun startCamera()
        fun stopCamera()

        fun hasCameraPermission(): Boolean
        fun askCameraPermission()

        fun enableTorch(isTorchOn: Boolean)
    }

    interface Presenter {

        fun onResume()
        fun onPause()

        fun onPermissionGranted()

        fun onTorchClick()
    }
}