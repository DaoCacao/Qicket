package core.legion.qicket.qr

import android.graphics.Bitmap
import io.reactivex.Single

interface IQRManager {
    fun encode(text: String): Single<Bitmap>
    fun decode(qr: Bitmap): Single<String>

    fun getQR(): Single<Bitmap>
}