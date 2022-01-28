package org.pathcheck.covidsafepaths.exposurenotifications.storage;

import io.realm.Realm;
import org.pathcheck.covidsafepaths.exposurenotifications.storage.objects.KeyValues;

/* compiled from: RealmSecureStorageBte.kt */
public final class RealmSecureStorageBte$upsertRevisionToken$$inlined$use$lambda$1 implements Realm.Transaction {
    public final /* synthetic */ String $revisionToken$inlined;

    public RealmSecureStorageBte$upsertRevisionToken$$inlined$use$lambda$1(String str) {
        this.$revisionToken$inlined = str;
    }

    @Override // io.realm.Realm.Transaction
    public final void execute(Realm realm) {
        realm.insertOrUpdate(new KeyValues(KeyValues.REVISION_TOKEN_KEY, this.$revisionToken$inlined));
    }
}
