package gov.michigan.MiCovidExposure.network;

import c.a.a.a.a;
import gov.michigan.MiCovidExposure.network.DiagnosisKey;

public final class AutoValue_DiagnosisKey extends DiagnosisKey {
    public final int intervalNumber;
    public final DiagnosisKey.ByteArrayValue key;
    public final int rollingPeriod;

    public static final class Builder extends DiagnosisKey.Builder {
        public Integer intervalNumber;
        public DiagnosisKey.ByteArrayValue key;
        public Integer rollingPeriod;

        @Override // gov.michigan.MiCovidExposure.network.DiagnosisKey.Builder
        public DiagnosisKey build() {
            String str = this.key == null ? " key" : "";
            if (this.intervalNumber == null) {
                str = a.q(str, " intervalNumber");
            }
            if (this.rollingPeriod == null) {
                str = a.q(str, " rollingPeriod");
            }
            if (str.isEmpty()) {
                return new AutoValue_DiagnosisKey(this.key, this.intervalNumber.intValue(), this.rollingPeriod.intValue());
            }
            throw new IllegalStateException(a.q("Missing required properties:", str));
        }

        @Override // gov.michigan.MiCovidExposure.network.DiagnosisKey.Builder
        public DiagnosisKey.Builder setIntervalNumber(int i) {
            this.intervalNumber = Integer.valueOf(i);
            return this;
        }

        @Override // gov.michigan.MiCovidExposure.network.DiagnosisKey.Builder
        public DiagnosisKey.Builder setKey(DiagnosisKey.ByteArrayValue byteArrayValue) {
            if (byteArrayValue != null) {
                this.key = byteArrayValue;
                return this;
            }
            throw new NullPointerException("Null key");
        }

        @Override // gov.michigan.MiCovidExposure.network.DiagnosisKey.Builder
        public DiagnosisKey.Builder setRollingPeriod(int i) {
            this.rollingPeriod = Integer.valueOf(i);
            return this;
        }
    }

    public AutoValue_DiagnosisKey(DiagnosisKey.ByteArrayValue byteArrayValue, int i, int i2) {
        this.key = byteArrayValue;
        this.intervalNumber = i;
        this.rollingPeriod = i2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DiagnosisKey)) {
            return false;
        }
        DiagnosisKey diagnosisKey = (DiagnosisKey) obj;
        return this.key.equals(diagnosisKey.getKey()) && this.intervalNumber == diagnosisKey.getIntervalNumber() && this.rollingPeriod == diagnosisKey.getRollingPeriod();
    }

    @Override // gov.michigan.MiCovidExposure.network.DiagnosisKey
    public int getIntervalNumber() {
        return this.intervalNumber;
    }

    @Override // gov.michigan.MiCovidExposure.network.DiagnosisKey
    public DiagnosisKey.ByteArrayValue getKey() {
        return this.key;
    }

    @Override // gov.michigan.MiCovidExposure.network.DiagnosisKey
    public int getRollingPeriod() {
        return this.rollingPeriod;
    }

    public int hashCode() {
        return ((((this.key.hashCode() ^ 1000003) * 1000003) ^ this.intervalNumber) * 1000003) ^ this.rollingPeriod;
    }
}
