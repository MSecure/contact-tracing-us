package gov.nc.dhhs.exposurenotification.network;

import c.b.b.a.i;
import c.b.b.c.a;
import e.c.a.d;
import gov.nc.dhhs.exposurenotification.network.AutoValue_DiagnosisKey;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public abstract class DiagnosisKey {
    public static final a BASE16 = a.f3353c.e();
    public static final a BASE64 = a.f3351a;
    public static final int DEFAULT_PERIOD = 144;
    public static final int DEFAULT_TRANSMISSION_RISK = 1;
    public static final long INTERVAL_LEN_MS = TimeUnit.MINUTES.toMillis(10);

    public static abstract class Builder {
        public abstract DiagnosisKey autoBuild();

        public DiagnosisKey build() {
            setTransmissionRisk(getTransmissionRisk() > 0 ? getTransmissionRisk() : 1);
            setRollingPeriod(getRollingPeriod() > 0 ? getRollingPeriod() : 144);
            return autoBuild();
        }

        public abstract int getRollingPeriod();

        public abstract int getTransmissionRisk();

        public abstract Builder setIntervalNumber(int i);

        public abstract Builder setKey(ByteArrayValue byteArrayValue);

        public Builder setKeyBytes(byte[] bArr) {
            setKey(new ByteArrayValue(bArr));
            return this;
        }

        public abstract Builder setRollingPeriod(int i);

        public abstract Builder setTransmissionRisk(int i);
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

    public static int instantToInterval(d dVar) {
        return (int) (dVar.C() / INTERVAL_LEN_MS);
    }

    public static d intervalToInstant(int i) {
        return d.v(((long) i) * INTERVAL_LEN_MS);
    }

    public static Builder newBuilder() {
        return new AutoValue_DiagnosisKey.Builder().setRollingPeriod(144).setTransmissionRisk(1);
    }

    public abstract int getIntervalNumber();

    public abstract ByteArrayValue getKey();

    public byte[] getKeyBytes() {
        return getKey().getBytes();
    }

    public abstract int getRollingPeriod();

    public abstract int getTransmissionRisk();

    public String toString() {
        i iVar = new i(getClass().getSimpleName(), null);
        StringBuilder g = c.a.a.a.a.g("[");
        g.append(BASE16.c(getKeyBytes()));
        g.append("]");
        iVar.b("key:hex", g.toString());
        iVar.b("key:base64", "[" + BASE64.c(getKeyBytes()) + "]");
        iVar.a("interval_number", getIntervalNumber());
        iVar.a("rolling_period", getRollingPeriod());
        iVar.a("transmission_risk", getTransmissionRisk());
        return iVar.toString();
    }
}
