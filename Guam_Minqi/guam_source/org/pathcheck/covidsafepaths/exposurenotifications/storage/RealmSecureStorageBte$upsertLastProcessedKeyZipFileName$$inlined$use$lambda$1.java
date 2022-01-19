package org.pathcheck.covidsafepaths.exposurenotifications.storage;

import io.realm.Realm;
import org.pathcheck.covidsafepaths.exposurenotifications.storage.objects.KeyValues;

/* compiled from: RealmSecureStorageBte.kt */
public final class RealmSecureStorageBte$upsertLastProcessedKeyZipFileName$$inlined$use$lambda$1 implements Realm.Transaction {
    public final /* synthetic */ String $name$inlined;

    public RealmSecureStorageBte$upsertLastProcessedKeyZipFileName$$inlined$use$lambda$1(String str) {
        this.$name$inlined = str;
    }

    @Override // io.realm.Realm.Transaction
    public final void execute(Realm realm) {
        realm.insertOrUpdate(new KeyValues(KeyValues.LAST_PROCESSED_FILE_NAME_KEY, this.$name$inlined));
    }
}
