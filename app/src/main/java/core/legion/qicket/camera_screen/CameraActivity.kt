package core.legion.qicket.camera_screen

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.widget.Toast
import core.legion.qicket.R
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_camera.*
import javax.inject.Inject

class CameraActivity : DaggerAppCompatActivity(), CameraFacade.View {

    @Inject lateinit var presenter: CameraFacade.Presenter

    private val requestCode = 666

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)

        ivTorch.setOnClickListener { presenter.onTorchClick() }

        qrDecoderView.setOnQRCodeReadListener { text, _ ->
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (this.requestCode == requestCode) presenter.onPermissionGranted()
    }

    override fun startCamera() {
        qrDecoderView.setAutofocusInterval(2000L)
        qrDecoderView.setBackCamera()
        qrDecoderView.startCamera()
    }

    override fun stopCamera() = qrDecoderView.stopCamera()

    override fun hasCameraPermission() = ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
    override fun askCameraPermission() = ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), requestCode)

    override fun enableTorch(isTorchOn: Boolean) {
        qrDecoderView.setTorchEnabled(isTorchOn)
    }
}