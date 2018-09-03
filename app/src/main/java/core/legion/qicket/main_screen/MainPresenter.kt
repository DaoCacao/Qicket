package core.legion.qicket.main_screen

import core.legion.qicket.qr.IQRManager
import core.legion.qicket.realm.IRealmManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainPresenter @Inject constructor() : MainFacade.Presenter {

    @Inject lateinit var view: MainFacade.View
    @Inject lateinit var realmManager: IRealmManager
    @Inject lateinit var qrManager: IQRManager

    override fun onAddClick() {
        realmManager
                .generateNewTicket()
                .map { qrManager.encode(it.toString()) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { qr -> view.showQR(qr) }
    }

    override fun onCheckClick() {
    }
}