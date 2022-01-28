package org.pathcheck.covidsafepaths.exposurenotifications.network;

import org.pathcheck.covidsafepaths.exposurenotifications.network.DiagnosisKey;

public final class AutoValue_DiagnosisKey extends DiagnosisKey {
    public final int intervalNumber;
    public final DiagnosisKey.ByteArrayValue key;
    public final int rollingPeriod;
    public final int transmissionRisk;

    public static final class Builder extends DiagnosisKey.Builder {
        public Integer intervalNumber;
        public DiagnosisKey.ByteArrayValue key;
        public Integer rollingPeriod;
        public Integer transmissionRisk;

        @Override // org.pathcheck.covidsafepaths.exposurenotifications.network.DiagnosisKey.Builder
        public DiagnosisKey.Builder setRollingPeriod(int i) {
            this.rollingPeriod = Integer.valueOf(i);
            return this;
        }
    }

    public AutoValue_DiagnosisKey(DiagnosisKey.ByteArrayValue byteArrayValue, int i, int i2, int i3, AnonymousClass1 r5) {
        this.key = byteArrayValue;
        this.intervalNumber = i;
        this.rollingPeriod = i2;
        this.transmissionRisk = i3;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DiagnosisKey)) {
            return false;
        }
        AutoValue_DiagnosisKey autoValue_DiagnosisKey = (AutoValue_DiagnosisKey) ((DiagnosisKey) obj);
        return this.key.equals(autoValue_DiagnosisKey.key) && this.intervalNumber == autoValue_DiagnosisKey.intervalNumber && this.rollingPeriod == autoValue_DiagnosisKey.rollingPeriod && this.transmissionRisk == autoValue_DiagnosisKey.transmissionRisk;
    }

    public int hashCode() {
        return ((((((this.key.hashCode() ^ 1000003) * 1000003) ^ this.intervalNumber) * 1000003) ^ this.rollingPeriod) * 1000003) ^ this.transmissionRisk;
    }
}
