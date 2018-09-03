package core.legion.qicket.main_screen

import android.graphics.Bitmap
import android.net.Uri
import com.dlazaro66.qrcodereaderview.QRCodeReaderView

interface MainFacade {

    interface View {
        fun navigateToCamera()

        fun showQR(qr: Bitmap)
        fun showToast(text: String)

        fun shareQR(uri: Uri)
    }

    interface Presenter: QRCodeReaderView.OnQRCodeReadListener {

        fun onAddClick()
        fun onCheckClick()

        fun onQRClick()
    }
}