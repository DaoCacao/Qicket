package core.legion.qicket.mediaManager

import android.graphics.Bitmap
import android.net.Uri
import android.content.Context
import io.reactivex.Single
import java.io.File
import java.io.FileOutputStream
import javax.inject.Inject


class MediaManager @Inject constructor(private val context: Context) : IMediaManager {

    override fun saveToTemp(image: Bitmap): Single<Uri> =
            Single.create {
                val file = File.createTempFile("Qicket", ".png", context.externalCacheDir)
                image.compress(Bitmap.CompressFormat.PNG, 100, FileOutputStream(file))

                it.onSuccess(Uri.fromFile(file))
            }
}