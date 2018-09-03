package core.legion.qicket.qr

import android.graphics.Bitmap
import android.graphics.Color
import com.google.zxing.BarcodeFormat
import com.google.zxing.Binarizer
import com.google.zxing.BinaryBitmap
import com.google.zxing.qrcode.QRCodeReader
import com.google.zxing.qrcode.QRCodeWriter
import io.reactivex.Single
import javax.inject.Inject
import com.google.zxing.common.HybridBinarizer
import com.google.zxing.RGBLuminanceSource
import com.google.zxing.LuminanceSource
import android.graphics.BitmapFactory




class QRManager @Inject constructor() : IQRManager {

    private lateinit var qrCode: Bitmap

    override fun encode(text: String): Single<Bitmap> {
        return Single.create {
            val matrix = QRCodeWriter().encode(text, BarcodeFormat.QR_CODE, 1024, 1024)
            val width = matrix.width
            val height = matrix.height

            val pixels = IntArray(width * height)

            for (y in 0 until height) {
                for (x in 0 until width) {
                    pixels[y * width + x] = if (matrix.get(x, y)) Color.BLACK else Color.WHITE
                }
            }

            qrCode = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565).apply {
                setPixels(pixels, 0, width, 0, 0, width, height)
            }

            it.onSuccess(qrCode)
        }
    }

    override fun decode(qr: Bitmap): Single<String> {

        val intArray = IntArray(qr.width * qr.height)

        qr.getPixels(intArray, 0, qr.width, 0, 0, qr.width, qr.height)

        val source = RGBLuminanceSource(qr.width, qr.height, intArray)
        val bitmap = BinaryBitmap(HybridBinarizer(source))


        return Single.just(QRCodeReader().decode(bitmap).text)
    }

    override fun getQR() = Single.just(qrCode)!!
}

