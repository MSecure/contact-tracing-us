package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.Hex;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class TemporaryExposureKey extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<TemporaryExposureKey> CREATOR = new zzf();
    private byte[] zza;
    private int zzb;
    private int zzc;
    private int zzd;
    private int zze;

    TemporaryExposureKey(byte[] bArr, int i, int i2, int i3, int i4) {
        this.zza = bArr;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i3;
        this.zze = i4;
    }

    /* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
    public static final class TemporaryExposureKeyBuilder {
        private byte[] zza = new byte[0];
        private int zzb = 0;
        private int zzc = 0;
        private int zzd = 0;
        private int zze = 0;

        public final TemporaryExposureKeyBuilder setKeyData(byte[] bArr) {
            this.zza = Arrays.copyOf(bArr, bArr.length);
            return this;
        }

        public final TemporaryExposureKeyBuilder setRollingStartIntervalNumber(int i) {
            Preconditions.checkArgument(i >= 0, "rollingStartIntervalNumber (%s) must be >= 0", Integer.valueOf(i));
            this.zzb = i;
            return this;
        }

        public final TemporaryExposureKeyBuilder setTransmissionRiskLevel(int i) {
            Preconditions.checkArgument(i >= 0 && i <= 8, "transmissionRiskLevel (%s) must be >= 0 and <= 8", Integer.valueOf(i));
            this.zzc = i;
            return this;
        }

        public final TemporaryExposureKeyBuilder setRollingPeriod(int i) {
            Preconditions.checkArgument(i >= 0, "rollingPeriod (%s) must be >= 0", Integer.valueOf(i));
            this.zzd = i;
            return this;
        }

        public final TemporaryExposureKeyBuilder setReportType(int i) {
            Preconditions.checkArgument(i >= 0 && i <= 5, "reportType (%s) must be >= 0 and <= 5", Integer.valueOf(i));
            this.zze = i;
            return this;
        }

        public final TemporaryExposureKey build() {
            return new TemporaryExposureKey(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArray(parcel, 1, getKeyData(), false);
        SafeParcelWriter.writeInt(parcel, 2, getRollingStartIntervalNumber());
        SafeParcelWriter.writeInt(parcel, 3, getTransmissionRiskLevel());
        SafeParcelWriter.writeInt(parcel, 4, getRollingPeriod());
        SafeParcelWriter.writeInt(parcel, 5, getReportType());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final byte[] getKeyData() {
        byte[] bArr = this.zza;
        return Arrays.copyOf(bArr, bArr.length);
    }

    public final int getRollingStartIntervalNumber() {
        return this.zzb;
    }

    public final int getTransmissionRiskLevel() {
        return this.zzc;
    }

    public final int getRollingPeriod() {
        return this.zzd;
    }

    public final int getReportType() {
        return this.zze;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof TemporaryExposureKey) {
            TemporaryExposureKey temporaryExposureKey = (TemporaryExposureKey) obj;
            if (!Arrays.equals(this.zza, temporaryExposureKey.getKeyData()) || !Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(temporaryExposureKey.getRollingStartIntervalNumber())) || !Objects.equal(Integer.valueOf(this.zzc), Integer.valueOf(temporaryExposureKey.getTransmissionRiskLevel())) || !Objects.equal(Integer.valueOf(this.zzd), Integer.valueOf(temporaryExposureKey.getRollingPeriod())) || !Objects.equal(Integer.valueOf(this.zze), Integer.valueOf(temporaryExposureKey.getReportType()))) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd), Integer.valueOf(this.zze));
    }

    public final String toString() {
        return String.format(Locale.US, "TemporaryExposureKey<keyData: %s, rollingStartIntervalNumber: %s, transmissionRiskLevel: %d, rollingPeriod: %d, reportType: %d>", Hex.bytesToStringLowercase(this.zza), new Date(TimeUnit.MINUTES.toMillis(((long) this.zzb) * 10)), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd), Integer.valueOf(this.zze));
    }
}
