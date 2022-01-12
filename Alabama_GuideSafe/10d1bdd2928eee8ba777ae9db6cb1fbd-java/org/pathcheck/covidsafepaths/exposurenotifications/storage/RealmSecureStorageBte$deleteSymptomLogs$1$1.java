package org.pathcheck.covidsafepaths.exposurenotifications.storage;

import io.realm.Realm;
import org.pathcheck.covidsafepaths.exposurenotifications.storage.objects.SymptomLogEntry;

/* compiled from: RealmSecureStorageBte.kt */
public final class RealmSecureStorageBte$deleteSymptomLogs$1$1 implements Realm.Transaction {
    public static final RealmSecureStorageBte$deleteSymptomLogs$1$1 INSTANCE = new RealmSecureStorageBte$deleteSymptomLogs$1$1();

    @Override // io.realm.Realm.Transaction
    public final void execute(Realm realm) {
        realm.delete(SymptomLogEntry.class);
    }
}
