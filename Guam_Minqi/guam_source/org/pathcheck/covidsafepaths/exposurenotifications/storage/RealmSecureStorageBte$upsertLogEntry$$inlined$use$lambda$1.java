package org.pathcheck.covidsafepaths.exposurenotifications.storage;

import io.realm.Realm;
import org.pathcheck.covidsafepaths.exposurenotifications.storage.objects.SymptomLogEntry;

/* compiled from: RealmSecureStorageBte.kt */
public final class RealmSecureStorageBte$upsertLogEntry$$inlined$use$lambda$1 implements Realm.Transaction {
    public final /* synthetic */ SymptomLogEntry $logEntry$inlined;

    public RealmSecureStorageBte$upsertLogEntry$$inlined$use$lambda$1(SymptomLogEntry symptomLogEntry) {
        this.$logEntry$inlined = symptomLogEntry;
    }

    @Override // io.realm.Realm.Transaction
    public final void execute(Realm realm) {
        realm.insertOrUpdate(this.$logEntry$inlined);
    }
}
