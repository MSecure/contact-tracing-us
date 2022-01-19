package org.pathcheck.covidsafepaths.exposurenotifications.storage.objects;

import io.realm.RealmObject;
import io.realm.internal.RealmObjectProxy;
import io.realm.org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_KeyValuesRealmProxyInterface;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KeyValues.kt */
public class KeyValues extends RealmObject implements org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_KeyValuesRealmProxyInterface {
    public static final Companion Companion = new Companion(null);
    public static final String LAST_PROCESSED_FILE_NAME_KEY = "LAST_PROCESSED_FILE_NAME";
    public static final String REVISION_TOKEN_KEY = "REVISION_TOKEN";
    public String id;
    public String value;

    /* compiled from: KeyValues.kt */
    public static final class Companion {
        public Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public KeyValues() {
        this("", null);
        boolean z = this instanceof RealmObjectProxy;
        if (z) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
        if (z) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
    }

    @Override // io.realm.org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_KeyValuesRealmProxyInterface
    public String realmGet$id() {
        return this.id;
    }

    @Override // io.realm.org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_KeyValuesRealmProxyInterface
    public String realmGet$value() {
        return this.value;
    }

    @Override // io.realm.org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_KeyValuesRealmProxyInterface
    public void realmSet$id(String str) {
        this.id = str;
    }

    @Override // io.realm.org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_KeyValuesRealmProxyInterface
    public void realmSet$value(String str) {
        this.value = str;
    }

    public KeyValues(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
        realmSet$id(str);
        realmSet$value(str2);
    }
}
