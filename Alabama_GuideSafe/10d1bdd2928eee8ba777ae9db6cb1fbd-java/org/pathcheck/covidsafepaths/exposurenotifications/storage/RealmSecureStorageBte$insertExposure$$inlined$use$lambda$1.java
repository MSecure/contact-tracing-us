package org.pathcheck.covidsafepaths.exposurenotifications.storage;

import io.realm.Realm;
import org.pathcheck.covidsafepaths.exposurenotifications.storage.objects.ExposureEntity;

/* compiled from: RealmSecureStorageBte.kt */
public final class RealmSecureStorageBte$insertExposure$$inlined$use$lambda$1 implements Realm.Transaction {
    public final /* synthetic */ ExposureEntity $exposure$inlined;

    public RealmSecureStorageBte$insertExposure$$inlined$use$lambda$1(ExposureEntity exposureEntity) {
        this.$exposure$inlined = exposureEntity;
    }

    @Override // io.realm.Realm.Transaction
    public final void execute(Realm realm) {
        realm.insert(this.$exposure$inlined);
    }
}
