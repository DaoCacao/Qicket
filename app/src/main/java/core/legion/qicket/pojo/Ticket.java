package core.legion.qicket.pojo;

import io.realm.RealmObject;

public class Ticket extends RealmObject {

    private long id;

    public Ticket() {
        id = System.nanoTime();
    }

    public long getId() {
        return id;
    }
}
