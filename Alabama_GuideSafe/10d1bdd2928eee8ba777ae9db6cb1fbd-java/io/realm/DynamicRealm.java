package io.realm;

import io.realm.internal.OsObjectStore;
import io.realm.internal.OsSharedRealm;

public class DynamicRealm extends BaseRealm {
    public final RealmSchema schema;

    public DynamicRealm(final RealmCache realmCache, OsSharedRealm.VersionID versionID) {
        super(realmCache, null, versionID);
        RealmConfiguration realmConfiguration = realmCache.configuration;
        AnonymousClass1 r0 = new Object() {
            /* class io.realm.DynamicRealm.AnonymousClass1 */

            public void onResult(int i) {
                if (i <= 0 && !realmCache.configuration.readOnly && OsObjectStore.nativeGetSchemaVersion(DynamicRealm.this.sharedRealm.getNativePtr()) == -1) {
                    DynamicRealm.this.sharedRealm.beginTransaction();
                    if (OsObjectStore.nativeGetSchemaVersion(DynamicRealm.this.sharedRealm.getNativePtr()) == -1) {
                        OsObjectStore.nativeSetSchemaVersion(DynamicRealm.this.sharedRealm.getNativePtr(), -1);
                    }
                    DynamicRealm.this.sharedRealm.commitTransaction();
                }
            }
        };
        synchronized (RealmCache.cachesList) {
            RealmCache cache = RealmCache.getCache(realmConfiguration.canonicalPath, false);
            if (cache == null) {
                r0.onResult(0);
            } else {
                synchronized (cache) {
                    r0.onResult(cache.getTotalGlobalRefCount());
                }
            }
        }
        this.schema = new MutableRealmSchema(this);
    }

    @Override // io.realm.BaseRealm
    public RealmSchema getSchema() {
        return this.schema;
    }

    public DynamicRealm(OsSharedRealm osSharedRealm) {
        super(osSharedRealm);
        this.schema = new MutableRealmSchema(this);
    }
}
