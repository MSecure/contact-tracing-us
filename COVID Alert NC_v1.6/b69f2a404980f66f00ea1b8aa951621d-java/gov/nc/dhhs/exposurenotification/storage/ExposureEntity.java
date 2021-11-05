package gov.nc.dhhs.exposurenotification.storage;

import java.util.Objects;

public class ExposureEntity {
    public long dateMillisSinceEpoch;
    public long id;
    public long receivedTimestampMs;

    public ExposureEntity(long j, long j2) {
        this.receivedTimestampMs = j2;
        this.dateMillisSinceEpoch = j;
    }

    public static ExposureEntity create(long j, long j2) {
        return new ExposureEntity(j, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ExposureEntity.class != obj.getClass()) {
            return false;
        }
        ExposureEntity exposureEntity = (ExposureEntity) obj;
        return this.id == exposureEntity.id && this.dateMillisSinceEpoch == exposureEntity.dateMillisSinceEpoch && this.receivedTimestampMs == exposureEntity.receivedTimestampMs;
    }

    public long getDateMillisSinceEpoch() {
        return this.dateMillisSinceEpoch;
    }

    public long getId() {
        return this.id;
    }

    public long getReceivedTimestampMs() {
        return this.receivedTimestampMs;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.id), Long.valueOf(this.dateMillisSinceEpoch), Long.valueOf(this.receivedTimestampMs));
    }

    public void setDateMillisSinceEpoch(long j) {
        this.dateMillisSinceEpoch = j;
    }

    public void setId(long j) {
        this.id = j;
    }

    public void setReceivedTimestampMs(long j) {
        this.receivedTimestampMs = j;
    }
}
