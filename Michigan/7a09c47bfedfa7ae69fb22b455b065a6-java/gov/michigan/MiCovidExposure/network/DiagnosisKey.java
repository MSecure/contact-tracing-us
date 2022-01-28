package gov.michigan.MiCovidExposure.network;

import b.x.t;
import c.b.a.a.d.m.m;
import c.b.b.c.a;
import gov.michigan.MiCovidExposure.network.AutoValue_DiagnosisKey;
import java.util.Arrays;

public abstract class DiagnosisKey {
    public static final a BASE16 = a.f4694c.e();
    public static final a BASE64 = a.f4692a;
    public static final int DEFAULT_PERIOD = 144;

    public static abstract class Builder {
        public abstract DiagnosisKey build();

        public abstract Builder setIntervalNumber(int i);

        public abstract Builder setKey(ByteArrayValue byteArrayValue);

        public Builder setKeyBytes(byte[] bArr) {
            setKey(new ByteArrayValue(bArr));
            return this;
        }

        public abstract Builder setRollingPeriod(int i);
    }

    public static class ByteArrayValue {
        public final byte[] bytes;

        public ByteArrayValue(byte[] bArr) {
            this.bytes = (byte[]) bArr.clone();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ByteArrayValue)) {
                return false;
            }
            return Arrays.equals(this.bytes, ((ByteArrayValue) obj).bytes);
        }

        public byte[] getBytes() {
            return (byte[]) this.bytes.clone();
        }

        public int hashCode() {
            return Arrays.hashCode(this.bytes);
        }

        public String toString() {
            return Arrays.toString(this.bytes);
        }
    }

    public static Builder newBuilder() {
        return new AutoValue_DiagnosisKey.Builder().setRollingPeriod(144);
    }

    public abstract int getIntervalNumber();

    public abstract ByteArrayValue getKey();

    public byte[] getKeyBytes() {
        return getKey().getBytes();
    }

    public abstract int getRollingPeriod();

    public String toString() {
        m a3 = t.a3(this);
        StringBuilder h = c.a.a.a.a.h("[");
        h.append(BASE16.c(getKeyBytes()));
        h.append("]");
        a3.a("key:hex", h.toString());
        a3.a("key:base64", "[" + BASE64.c(getKeyBytes()) + "]");
        a3.a("interval_number", Integer.valueOf(getIntervalNumber()));
        a3.a("rolling_period", Integer.valueOf(getRollingPeriod()));
        return a3.toString();
    }
}
