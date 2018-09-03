package core.legion.qicket.main_screen

import android.graphics.Bitmap

interface MainFacade {

    interface View {
        fun showQR(qr: Bitmap)
        fun showToast(text: String)
    }

    interface Presenter {

        fun onAddClick()
        fun onCheckClick()
    }
}