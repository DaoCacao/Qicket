package core.legion.qicket.realm

import io.reactivex.Single

interface IRealmManager {

    fun generateNewTicket(): Single<Long>
}