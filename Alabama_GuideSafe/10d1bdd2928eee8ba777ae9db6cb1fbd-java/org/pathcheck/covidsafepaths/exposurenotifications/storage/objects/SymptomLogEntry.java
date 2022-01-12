package org.pathcheck.covidsafepaths.exposurenotifications.storage.objects;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.internal.RealmObjectProxy;
import io.realm.org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_SymptomLogEntryRealmProxyInterface;
import java.util.UUID;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.Instant;

/* compiled from: SymptomLogEntry.kt */
public class SymptomLogEntry extends RealmObject implements org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_SymptomLogEntryRealmProxyInterface {
    public static final Companion Companion = new Companion(null);
    public long date;
    public String id;
    public RealmList<String> symptoms;

    /* compiled from: SymptomLogEntry.kt */
    public static final class Companion {
        public Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public SymptomLogEntry() {
        this(r0, Instant.now().toEpochMilli(), new RealmList());
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "UUID.randomUUID().toString()");
        boolean z = this instanceof RealmObjectProxy;
        if (z) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
        if (z) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
    }

    @Override // io.realm.org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_SymptomLogEntryRealmProxyInterface
    public long realmGet$date() {
        return this.date;
    }

    @Override // io.realm.org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_SymptomLogEntryRealmProxyInterface
    public String realmGet$id() {
        return this.id;
    }

    @Override // io.realm.org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_SymptomLogEntryRealmProxyInterface
    public RealmList realmGet$symptoms() {
        return this.symptoms;
    }

    @Override // io.realm.org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_SymptomLogEntryRealmProxyInterface
    public void realmSet$date(long j) {
        this.date = j;
    }

    @Override // io.realm.org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_SymptomLogEntryRealmProxyInterface
    public void realmSet$id(String str) {
        this.id = str;
    }

    @Override // io.realm.org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_SymptomLogEntryRealmProxyInterface
    public void realmSet$symptoms(RealmList realmList) {
        this.symptoms = realmList;
    }

    public SymptomLogEntry(String str, long j, RealmList<String> realmList) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(realmList, "symptoms");
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
        realmSet$id(str);
        realmSet$date(j);
        realmSet$symptoms(realmList);
    }
}
