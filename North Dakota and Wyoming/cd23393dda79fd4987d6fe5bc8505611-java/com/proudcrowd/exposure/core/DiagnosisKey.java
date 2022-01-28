package com.proudcrowd.exposure.core;

import com.google.android.gms.common.internal.Objects;
import com.google.common.io.BaseEncoding;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.proudcrowd.exposure.core.AutoValue_DiagnosisKey;

public abstract class DiagnosisKey {
    private static final BaseEncoding BASE64 = BaseEncoding.base64();
    private static final int DEFAULT_PERIOD = 144;
    private static final int DEFAULT_TRANSMISSION_RISK = 2;

    public abstract String getKey();

    public abstract int getReportType();

    public abstract int getRollingPeriod();

    public abstract int getRollingStartNumber();

    public abstract int getTransmissionRisk();

    public static Builder newBuilder() {
        return new AutoValue_DiagnosisKey.Builder().setRollingPeriod(DEFAULT_PERIOD).setTransmissionRisk(2);
    }

    public static abstract class Builder {
        /* access modifiers changed from: package-private */
        public abstract DiagnosisKey autoBuild();

        /* access modifiers changed from: package-private */
        public abstract int getRollingPeriod();

        /* access modifiers changed from: package-private */
        public abstract int getTransmissionRisk();

        public abstract Builder setKey(String str);

        public abstract Builder setReportType(int i);

        public abstract Builder setRollingPeriod(int i);

        public abstract Builder setRollingStartNumber(int i);

        public abstract Builder setTransmissionRisk(int i);

        public DiagnosisKey build() {
            setTransmissionRisk(getTransmissionRisk() > 0 ? getTransmissionRisk() : 2);
            setRollingPeriod(getRollingPeriod() > 0 ? getRollingPeriod() : DiagnosisKey.DEFAULT_PERIOD);
            return autoBuild();
        }

        public Builder setKeyBytes(byte[] bArr) {
            setKey(DiagnosisKey.BASE64.encode(bArr));
            return this;
        }
    }

    public String toString() {
        return Objects.toStringHelper(this).add("key:", getKey()).add("interval_number", Integer.valueOf(getRollingStartNumber())).add("rolling_period", Integer.valueOf(getRollingPeriod())).add("transmission_risk", Integer.valueOf(getTransmissionRisk())).add("report_type", Integer.valueOf(getReportType())).toString();
    }

    public static class SerializationExclusionStrategy implements ExclusionStrategy {
        @Override // com.google.gson.ExclusionStrategy
        public boolean shouldSkipClass(Class<?> cls) {
            return false;
        }

        @Override // com.google.gson.ExclusionStrategy
        public boolean shouldSkipField(FieldAttributes fieldAttributes) {
            return fieldAttributes != null && fieldAttributes.getName().equals("reportType") && fieldAttributes.getDeclaringClass() == AutoValue_DiagnosisKey.class;
        }
    }
}
