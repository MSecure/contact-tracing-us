package org.pathcheck.covidsafepaths.exposurenotifications.storage;

import io.realm.Realm;
import io.realm.RealmQuery;
import org.pathcheck.covidsafepaths.exposurenotifications.storage.objects.ExposureEntity;
import org.pathcheck.covidsafepaths.exposurenotifications.storage.objects.KeyValues;

/* compiled from: RealmSecureStorageBte.kt */
public final class RealmSecureStorageBte$resetExposures$1$1 implements Realm.Transaction {
    public static final RealmSecureStorageBte$resetExposures$1$1 INSTANCE = new RealmSecureStorageBte$resetExposures$1$1();

    @Override // io.realm.Realm.Transaction
    public final void execute(Realm realm) {
        realm.delete(ExposureEntity.class);
        realm.checkIfValid();
        RealmQuery realmQuery = new RealmQuery(realm, KeyValues.class);
        realmQuery.equalTo("id", KeyValues.LAST_PROCESSED_FILE_NAME_KEY);
        KeyValues keyValues = (KeyValues) realmQuery.findFirst();
        if (keyValues != null) {
            keyValues.deleteFromRealm();
        }
    }
}
