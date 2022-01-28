package com.proudcrowd.exposure.storage;

import java.util.Objects;

public class ExposureEntity {
    private long createdTimestampMs;
    private long dateTimestampMs;
    private boolean hasViewed;

    ExposureEntity(long j, long j2, boolean z) {
        this.hasViewed = z;
        this.dateTimestampMs = j;
        this.createdTimestampMs = j2;
    }

    public static ExposureEntity create(long j) {
        return new ExposureEntity(j, System.currentTimeMillis(), false);
    }

    public long getDateTimestampMs() {
        return this.dateTimestampMs;
    }

    public void setDateTimestampMs(long j) {
        this.dateTimestampMs = j;
    }

    public boolean getHasViewed() {
        return this.hasViewed;
    }

    public void setHasViewed(boolean z) {
        this.hasViewed = z;
    }

    public long getCreatedTimestampMs() {
        return this.createdTimestampMs;
    }

    public void setCreatedTimestampMs(long j) {
        this.createdTimestampMs = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ExposureEntity exposureEntity = (ExposureEntity) obj;
        return this.dateTimestampMs == exposureEntity.dateTimestampMs && this.hasViewed == exposureEntity.hasViewed && this.createdTimestampMs == exposureEntity.createdTimestampMs;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.dateTimestampMs), Boolean.valueOf(this.hasViewed), Long.valueOf(this.createdTimestampMs));
    }
}
