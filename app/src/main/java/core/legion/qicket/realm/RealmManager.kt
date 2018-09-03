package core.legion.qicket.realm

import core.legion.qicket.pojo.Ticket
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.realm.Realm
import io.realm.RealmConfiguration
import javax.inject.Inject

class RealmManager @Inject constructor() : IRealmManager {

    private val realm by lazy {
        Realm.getInstance(
                RealmConfiguration
                        .Builder()
                        .deleteRealmIfMigrationNeeded()
                        .build())
    }

    override fun generateNewTicket(): Single<Long> {
        return Single.create {
            realm.beginTransaction()
            val ticket = realm.copyToRealm(Ticket())
            realm.commitTransaction()
            it.onSuccess(ticket.id)
        }
    }
}
