package gov.michigan.MiCovidExposure.storage;

import g.b.a.s;
import java.util.Objects;

public class PositiveDiagnosisEntity {
    public long createdTimestampMs = System.currentTimeMillis();
    public long id;
    public boolean shared;
    public s testTimestamp;

    public PositiveDiagnosisEntity(s sVar, boolean z) {
        this.testTimestamp = sVar;
        this.shared = z;
    }

    public static PositiveDiagnosisEntity create(s sVar, boolean z) {
        if (sVar != null) {
            return new PositiveDiagnosisEntity(sVar, z);
        }
        throw null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PositiveDiagnosisEntity.class != obj.getClass()) {
            return false;
        }
        PositiveDiagnosisEntity positiveDiagnosisEntity = (PositiveDiagnosisEntity) obj;
        return this.id == positiveDiagnosisEntity.id && this.createdTimestampMs == positiveDiagnosisEntity.createdTimestampMs && this.shared == positiveDiagnosisEntity.shared && this.testTimestamp.equals(positiveDiagnosisEntity.testTimestamp);
    }

    public long getCreatedTimestampMs() {
        return this.createdTimestampMs;
    }

    public long getId() {
        return this.id;
    }

    public s getTestTimestamp() {
        return this.testTimestamp;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.id), Long.valueOf(this.createdTimestampMs), this.testTimestamp, Boolean.valueOf(this.shared));
    }

    public boolean isShared() {
        return this.shared;
    }

    public void setCreatedTimestampMs(long j) {
        this.createdTimestampMs = j;
    }

    public void setShared(boolean z) {
        this.shared = z;
    }

    public void setTestTimestamp(s sVar) {
        if (sVar != null) {
            this.testTimestamp = sVar;
            return;
        }
        throw null;
    }
}
