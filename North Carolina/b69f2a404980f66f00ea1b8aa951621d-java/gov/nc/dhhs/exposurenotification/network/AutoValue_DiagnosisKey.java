package gov.nc.dhhs.exposurenotification.network;

import c.a.a.a.a;
import gov.nc.dhhs.exposurenotification.network.DiagnosisKey;

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

        @Override // gov.nc.dhhs.exposurenotification.network.DiagnosisKey.Builder
        public DiagnosisKey autoBuild() {
            String str = this.key == null ? " key" : "";
            if (this.intervalNumber == null) {
                str = a.o(str, " intervalNumber");
            }
            if (this.rollingPeriod == null) {
                str = a.o(str, " rollingPeriod");
            }
            if (this.transmissionRisk == null) {
                str = a.o(str, " transmissionRisk");
            }
            if (str.isEmpty()) {
                return new AutoValue_DiagnosisKey(this.key, this.intervalNumber.intValue(), this.rollingPeriod.intValue(), this.transmissionRisk.intValue());
            }
            throw new IllegalStateException(a.o("Missing required properties:", str));
        }

        @Override // gov.nc.dhhs.exposurenotification.network.DiagnosisKey.Builder
        public int getRollingPeriod() {
            Integer num = this.rollingPeriod;
            if (num != null) {
                return num.intValue();
            }
            throw new IllegalStateException("Property \"rollingPeriod\" has not been set");
        }

        @Override // gov.nc.dhhs.exposurenotification.network.DiagnosisKey.Builder
        public int getTransmissionRisk() {
            Integer num = this.transmissionRisk;
            if (num != null) {
                return num.intValue();
            }
            throw new IllegalStateException("Property \"transmissionRisk\" has not been set");
        }

        @Override // gov.nc.dhhs.exposurenotification.network.DiagnosisKey.Builder
        public DiagnosisKey.Builder setIntervalNumber(int i) {
            this.intervalNumber = Integer.valueOf(i);
            return this;
        }

        @Override // gov.nc.dhhs.exposurenotification.network.DiagnosisKey.Builder
        public DiagnosisKey.Builder setKey(DiagnosisKey.ByteArrayValue byteArrayValue) {
            if (byteArrayValue != null) {
                this.key = byteArrayValue;
                return this;
            }
            throw new NullPointerException("Null key");
        }

        @Override // gov.nc.dhhs.exposurenotification.network.DiagnosisKey.Builder
        public DiagnosisKey.Builder setRollingPeriod(int i) {
            this.rollingPeriod = Integer.valueOf(i);
            return this;
        }

        @Override // gov.nc.dhhs.exposurenotification.network.DiagnosisKey.Builder
        public DiagnosisKey.Builder setTransmissionRisk(int i) {
            this.transmissionRisk = Integer.valueOf(i);
            return this;
        }
    }

    public AutoValue_DiagnosisKey(DiagnosisKey.ByteArrayValue byteArrayValue, int i, int i2, int i3) {
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
        DiagnosisKey diagnosisKey = (DiagnosisKey) obj;
        return this.key.equals(diagnosisKey.getKey()) && this.intervalNumber == diagnosisKey.getIntervalNumber() && this.rollingPeriod == diagnosisKey.getRollingPeriod() && this.transmissionRisk == diagnosisKey.getTransmissionRisk();
    }

    @Override // gov.nc.dhhs.exposurenotification.network.DiagnosisKey
    public int getIntervalNumber() {
        return this.intervalNumber;
    }

    @Override // gov.nc.dhhs.exposurenotification.network.DiagnosisKey
    public DiagnosisKey.ByteArrayValue getKey() {
        return this.key;
    }

    @Override // gov.nc.dhhs.exposurenotification.network.DiagnosisKey
    public int getRollingPeriod() {
        return this.rollingPeriod;
    }

    @Override // gov.nc.dhhs.exposurenotification.network.DiagnosisKey
    public int getTransmissionRisk() {
        return this.transmissionRisk;
    }

    public int hashCode() {
        return ((((((this.key.hashCode() ^ 1000003) * 1000003) ^ this.intervalNumber) * 1000003) ^ this.rollingPeriod) * 1000003) ^ this.transmissionRisk;
    }
}
