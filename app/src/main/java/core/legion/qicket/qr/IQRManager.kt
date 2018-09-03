package core.legion.qicket.qr

import android.graphics.Bitmap

interface IQRManager {
    fun encode(text: String): Bitmap
    fun decode(qr: Bitmap): String
}