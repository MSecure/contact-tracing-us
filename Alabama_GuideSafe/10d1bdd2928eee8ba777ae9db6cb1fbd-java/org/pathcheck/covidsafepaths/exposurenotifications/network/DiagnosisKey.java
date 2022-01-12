package org.pathcheck.covidsafepaths.exposurenotifications.network;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.internal.Objects$ToStringHelper;
import com.google.common.io.BaseEncoding;
import java.util.Arrays;
import org.pathcheck.covidsafepaths.exposurenotifications.network.AutoValue_DiagnosisKey;

public abstract class DiagnosisKey {
    public static final BaseEncoding BASE16 = BaseEncoding.BASE16.lowerCase();
    public static final BaseEncoding BASE64 = BaseEncoding.BASE64;

    public static abstract class Builder {
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

        public int hashCode() {
            return Arrays.hashCode(this.bytes);
        }

        public String toString() {
            return Arrays.toString(this.bytes);
        }
    }

    public static Builder newBuilder() {
        AutoValue_DiagnosisKey.Builder builder = new AutoValue_DiagnosisKey.Builder();
        builder.setRollingPeriod(144);
        builder.transmissionRisk = 1;
        return builder;
    }

    public byte[] getKeyBytes() {
        return (byte[]) ((AutoValue_DiagnosisKey) this).key.bytes.clone();
    }

    public String toString() {
        Objects$ToStringHelper stringHelper = ReactYogaConfigProvider.toStringHelper(this);
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("[");
        outline17.append(BASE16.encode(getKeyBytes()));
        outline17.append("]");
        stringHelper.add("key:hex", outline17.toString());
        stringHelper.add("key:base64", "[" + BASE64.encode(getKeyBytes()) + "]");
        AutoValue_DiagnosisKey autoValue_DiagnosisKey = (AutoValue_DiagnosisKey) this;
        stringHelper.add("interval_number", Integer.valueOf(autoValue_DiagnosisKey.intervalNumber));
        stringHelper.add("rolling_period", Integer.valueOf(autoValue_DiagnosisKey.rollingPeriod));
        stringHelper.add("transmission_risk", Integer.valueOf(autoValue_DiagnosisKey.transmissionRisk));
        return stringHelper.toString();
    }
}
