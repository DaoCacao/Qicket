package core.legion.qicket.main_screen

import android.graphics.PointF
import core.legion.qicket.mediaManager.IMediaManager
import core.legion.qicket.qr.IQRManager
import core.legion.qicket.realm.IRealmManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainPresenter @Inject constructor() : MainFacade.Presenter {

    @Inject lateinit var view: MainFacade.View
    @Inject lateinit var realmManager: IRealmManager
    @Inject lateinit var qrManager: IQRManager
    @Inject lateinit var mediaManager: IMediaManager

    override fun onAddClick() {
        realmManager
                .generateNewTicket()
                .flatMap { qrManager.encode(it.toString()) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(view::showQR)
    }

    override fun onCheckClick() {
        view.navigateToCamera()
    }

    override fun onQRClick() {
        qrManager
                .getQR()
                .flatMap(mediaManager::saveToTemp)
                .subscribe(view::shareQR)
    }

    override fun onQRCodeRead(text: String?, points: Array<out PointF>?) {
        view.showToast(text!!)
    }
}