package core.legion.qicket.mediaManager

import android.graphics.Bitmap
import android.net.Uri
import io.reactivex.Single

interface IMediaManager {
    fun saveToTemp(image: Bitmap): Single<Uri>
}