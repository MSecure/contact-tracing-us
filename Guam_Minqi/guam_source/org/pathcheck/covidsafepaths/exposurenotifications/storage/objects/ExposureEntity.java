package org.pathcheck.covidsafepaths.exposurenotifications.storage.objects;

import io.realm.RealmObject;
import io.realm.internal.RealmObjectProxy;
import io.realm.org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_ExposureEntityRealmProxyInterface;
import java.util.Objects;
import java.util.UUID;

public class ExposureEntity extends RealmObject implements org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_ExposureEntityRealmProxyInterface {
    public long dateMillisSinceEpoch;
    public long id;
    public long receivedTimestampMs;

    public ExposureEntity() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
        realmSet$id(UUID.randomUUID().getMostSignificantBits());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ExposureEntity exposureEntity = (ExposureEntity) obj;
        return realmGet$id() == exposureEntity.realmGet$id() && realmGet$dateMillisSinceEpoch() == exposureEntity.realmGet$dateMillisSinceEpoch() && realmGet$receivedTimestampMs() == exposureEntity.realmGet$receivedTimestampMs();
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(realmGet$id()), Long.valueOf(realmGet$dateMillisSinceEpoch()), Long.valueOf(realmGet$receivedTimestampMs()));
    }

    @Override // io.realm.org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_ExposureEntityRealmProxyInterface
    public long realmGet$dateMillisSinceEpoch() {
        return this.dateMillisSinceEpoch;
    }

    @Override // io.realm.org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_ExposureEntityRealmProxyInterface
    public long realmGet$id() {
        return this.id;
    }

    @Override // io.realm.org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_ExposureEntityRealmProxyInterface
    public long realmGet$receivedTimestampMs() {
        return this.receivedTimestampMs;
    }

    @Override // io.realm.org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_ExposureEntityRealmProxyInterface
    public void realmSet$dateMillisSinceEpoch(long j) {
        this.dateMillisSinceEpoch = j;
    }

    @Override // io.realm.org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_ExposureEntityRealmProxyInterface
    public void realmSet$id(long j) {
        this.id = j;
    }

    @Override // io.realm.org_pathcheck_covidsafepaths_exposurenotifications_storage_objects_ExposureEntityRealmProxyInterface
    public void realmSet$receivedTimestampMs(long j) {
        this.receivedTimestampMs = j;
    }

    public ExposureEntity(long j, long j2) {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
        realmSet$id(UUID.randomUUID().getMostSignificantBits());
        realmSet$receivedTimestampMs(j2);
        realmSet$dateMillisSinceEpoch(j);
    }
}
