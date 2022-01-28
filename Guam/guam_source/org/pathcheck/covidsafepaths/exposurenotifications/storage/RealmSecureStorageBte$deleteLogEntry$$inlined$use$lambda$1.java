package org.pathcheck.covidsafepaths.exposurenotifications.storage;

import io.realm.Realm;
import io.realm.RealmQuery;
import org.pathcheck.covidsafepaths.exposurenotifications.storage.objects.SymptomLogEntry;

/* compiled from: RealmSecureStorageBte.kt */
public final class RealmSecureStorageBte$deleteLogEntry$$inlined$use$lambda$1 implements Realm.Transaction {
    public final /* synthetic */ String $id$inlined;

    public RealmSecureStorageBte$deleteLogEntry$$inlined$use$lambda$1(String str) {
        this.$id$inlined = str;
    }

    @Override // io.realm.Realm.Transaction
    public final void execute(Realm realm) {
        realm.checkIfValid();
        RealmQuery realmQuery = new RealmQuery(realm, SymptomLogEntry.class);
        realmQuery.equalTo("id", this.$id$inlined);
        SymptomLogEntry symptomLogEntry = (SymptomLogEntry) realmQuery.findFirst();
        if (symptomLogEntry != null) {
            symptomLogEntry.deleteFromRealm();
        }
    }
}
