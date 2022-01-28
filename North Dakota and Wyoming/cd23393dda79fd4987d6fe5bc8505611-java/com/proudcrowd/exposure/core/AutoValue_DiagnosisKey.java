package com.proudcrowd.exposure.core;

import com.proudcrowd.exposure.core.DiagnosisKey;
import java.util.Objects;

final class AutoValue_DiagnosisKey extends DiagnosisKey {
    private final String key;
    private final int reportType;
    private final int rollingPeriod;
    private final int rollingStartNumber;
    private final int transmissionRisk;

    private AutoValue_DiagnosisKey(String str, int i, int i2, int i3, int i4) {
        this.key = str;
        this.rollingStartNumber = i;
        this.rollingPeriod = i2;
        this.transmissionRisk = i3;
        this.reportType = i4;
    }

    @Override // com.proudcrowd.exposure.core.DiagnosisKey
    public String getKey() {
        return this.key;
    }

    @Override // com.proudcrowd.exposure.core.DiagnosisKey
    public int getRollingStartNumber() {
        return this.rollingStartNumber;
    }

    @Override // com.proudcrowd.exposure.core.DiagnosisKey
    public int getRollingPeriod() {
        return this.rollingPeriod;
    }

    @Override // com.proudcrowd.exposure.core.DiagnosisKey
    public int getTransmissionRisk() {
        return this.transmissionRisk;
    }

    @Override // com.proudcrowd.exposure.core.DiagnosisKey
    public int getReportType() {
        return this.reportType;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DiagnosisKey)) {
            return false;
        }
        DiagnosisKey diagnosisKey = (DiagnosisKey) obj;
        return this.key.equals(diagnosisKey.getKey()) && this.rollingStartNumber == diagnosisKey.getRollingStartNumber() && this.rollingPeriod == diagnosisKey.getRollingPeriod() && this.transmissionRisk == diagnosisKey.getTransmissionRisk() && this.reportType == diagnosisKey.getReportType();
    }

    public int hashCode() {
        return ((((((((this.key.hashCode() ^ 1000003) * 1000003) ^ this.rollingStartNumber) * 1000003) ^ this.rollingPeriod) * 1000003) ^ this.transmissionRisk) * 1000003) ^ this.reportType;
    }

    /* access modifiers changed from: package-private */
    public static final class Builder extends DiagnosisKey.Builder {
        private String key;
        private Integer reportType;
        private Integer rollingPeriod;
        private Integer rollingStartNumber;
        private Integer transmissionRisk;

        Builder() {
        }

        @Override // com.proudcrowd.exposure.core.DiagnosisKey.Builder
        public DiagnosisKey.Builder setKey(String str) {
            Objects.requireNonNull(str, "Null key");
            this.key = str;
            return this;
        }

        @Override // com.proudcrowd.exposure.core.DiagnosisKey.Builder
        public DiagnosisKey.Builder setRollingStartNumber(int i) {
            this.rollingStartNumber = Integer.valueOf(i);
            return this;
        }

        @Override // com.proudcrowd.exposure.core.DiagnosisKey.Builder
        public DiagnosisKey.Builder setRollingPeriod(int i) {
            this.rollingPeriod = Integer.valueOf(i);
            return this;
        }

        /* access modifiers changed from: package-private */
        @Override // com.proudcrowd.exposure.core.DiagnosisKey.Builder
        public int getRollingPeriod() {
            Integer num = this.rollingPeriod;
            if (num != null) {
                return num.intValue();
            }
            throw new IllegalStateException("Property \"rollingPeriod\" has not been set");
        }

        @Override // com.proudcrowd.exposure.core.DiagnosisKey.Builder
        public DiagnosisKey.Builder setTransmissionRisk(int i) {
            this.transmissionRisk = Integer.valueOf(i);
            return this;
        }

        /* access modifiers changed from: package-private */
        @Override // com.proudcrowd.exposure.core.DiagnosisKey.Builder
        public int getTransmissionRisk() {
            Integer num = this.transmissionRisk;
            if (num != null) {
                return num.intValue();
            }
            throw new IllegalStateException("Property \"transmissionRisk\" has not been set");
        }

        @Override // com.proudcrowd.exposure.core.DiagnosisKey.Builder
        public DiagnosisKey.Builder setReportType(int i) {
            this.reportType = Integer.valueOf(i);
            return this;
        }

        /* access modifiers changed from: package-private */
        @Override // com.proudcrowd.exposure.core.DiagnosisKey.Builder
        public DiagnosisKey autoBuild() {
            String str = "";
            if (this.key == null) {
                str = str + " key";
            }
            if (this.rollingStartNumber == null) {
                str = str + " rollingStartNumber";
            }
            if (this.rollingPeriod == null) {
                str = str + " rollingPeriod";
            }
            if (this.transmissionRisk == null) {
                str = str + " transmissionRisk";
            }
            if (this.reportType == null) {
                str = str + " reportType";
            }
            if (str.isEmpty()) {
                return new AutoValue_DiagnosisKey(this.key, this.rollingStartNumber.intValue(), this.rollingPeriod.intValue(), this.transmissionRisk.intValue(), this.reportType.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
