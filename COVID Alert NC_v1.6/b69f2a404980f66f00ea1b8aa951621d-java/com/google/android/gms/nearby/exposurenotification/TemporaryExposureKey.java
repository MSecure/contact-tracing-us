package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import c.b.a.a.c.n.d;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class TemporaryExposureKey extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<TemporaryExposureKey> CREATOR = new zzo();
    public static final int DAYS_SINCE_ONSET_OF_SYMPTOMS_UNKNOWN = Integer.MAX_VALUE;
    public byte[] zza;
    public int zzb;
    @RiskLevel
    public int zzc;
    public int zzd;
    @ReportType
    public int zze;
    public int zzf;

    public static final class TemporaryExposureKeyBuilder {
        public byte[] zza = new byte[0];
        public int zzb = 0;
        @RiskLevel
        public int zzc = 0;
        public int zzd = 1;
        @ReportType
        public int zze = 0;
        public int zzf = Integer.MAX_VALUE;

        public final TemporaryExposureKey build() {
            return new TemporaryExposureKey(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf);
        }

        public final TemporaryExposureKeyBuilder setDaysSinceOnsetOfSymptoms(int i) {
            i.j.j(i >= -14 && i <= 14, "daysSinceOnsetOfSymptoms (%d) must be >= -14 and <= 14", Integer.valueOf(i));
            this.zzf = i;
            return this;
        }

        public final TemporaryExposureKeyBuilder setKeyData(byte[] bArr) {
            this.zza = Arrays.copyOf(bArr, bArr.length);
            return this;
        }

        public final TemporaryExposureKeyBuilder setReportType(@ReportType int i) {
            i.j.t(Boolean.valueOf(i >= 0 && i <= 5), String.format(Locale.getDefault(), "reportType (%d) is invalid", Integer.valueOf(i)));
            this.zze = i;
            return this;
        }

        public final TemporaryExposureKeyBuilder setRollingPeriod(int i) {
            i.j.j(i > 0, "rollingPeriod (%s) must be > 0", Integer.valueOf(i));
            this.zzd = i;
            return this;
        }

        public final TemporaryExposureKeyBuilder setRollingStartIntervalNumber(int i) {
            i.j.j(i >= 0, "rollingStartIntervalNumber (%s) must be >= 0", Integer.valueOf(i));
            this.zzb = i;
            return this;
        }

        public final TemporaryExposureKeyBuilder setTransmissionRiskLevel(@RiskLevel int i) {
            i.j.j(i >= 0 && i <= 8, "transmissionRiskLevel (%s) must be >= 0 and <= 8", Integer.valueOf(i));
            this.zzc = i;
            return this;
        }
    }

    public TemporaryExposureKey(byte[] bArr, int i, @RiskLevel int i2, int i3, @ReportType int i4, int i5) {
        this.zza = bArr;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i3;
        this.zze = i4;
        this.zzf = i5;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof TemporaryExposureKey) {
            TemporaryExposureKey temporaryExposureKey = (TemporaryExposureKey) obj;
            return Arrays.equals(this.zza, temporaryExposureKey.getKeyData()) && i.j.X(Integer.valueOf(this.zzb), Integer.valueOf(temporaryExposureKey.getRollingStartIntervalNumber())) && i.j.X(Integer.valueOf(this.zzc), Integer.valueOf(temporaryExposureKey.getTransmissionRiskLevel())) && i.j.X(Integer.valueOf(this.zzd), Integer.valueOf(temporaryExposureKey.getRollingPeriod())) && i.j.X(Integer.valueOf(this.zze), Integer.valueOf(temporaryExposureKey.getReportType())) && this.zzf == temporaryExposureKey.zzf;
        }
    }

    public final int getDaysSinceOnsetOfSymptoms() {
        return this.zzf;
    }

    public final byte[] getKeyData() {
        byte[] bArr = this.zza;
        return Arrays.copyOf(bArr, bArr.length);
    }

    @ReportType
    public final int getReportType() {
        return this.zze;
    }

    public final int getRollingPeriod() {
        return this.zzd;
    }

    public final int getRollingStartIntervalNumber() {
        return this.zzb;
    }

    @RiskLevel
    public final int getTransmissionRiskLevel() {
        return this.zzc;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd), Integer.valueOf(this.zze), Integer.valueOf(this.zzf)});
    }

    public final String toString() {
        Locale locale = Locale.US;
        Object[] objArr = new Object[6];
        byte[] bArr = this.zza;
        char[] cArr = new char[(bArr.length << 1)];
        int i = 0;
        for (byte b2 : bArr) {
            int i2 = b2 & 255;
            int i3 = i + 1;
            char[] cArr2 = d.f2498b;
            cArr[i] = cArr2[i2 >>> 4];
            i = i3 + 1;
            cArr[i3] = cArr2[i2 & 15];
        }
        objArr[0] = new String(cArr);
        objArr[1] = new Date(TimeUnit.MINUTES.toMillis(((long) this.zzb) * 10));
        objArr[2] = Integer.valueOf(this.zzc);
        objArr[3] = Integer.valueOf(this.zzd);
        objArr[4] = Integer.valueOf(this.zze);
        int i4 = this.zzf;
        objArr[5] = i4 == Integer.MAX_VALUE ? "unknown" : Integer.valueOf(i4);
        return String.format(locale, "TemporaryExposureKey<keyData: %s, rollingStartIntervalNumber: %s, transmissionRiskLevel: %d, rollingPeriod: %d, reportType: %d, daysSinceOnsetOfSymptoms: %s>", objArr);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.q1(parcel, 1, getKeyData(), false);
        i.j.u1(parcel, 2, getRollingStartIntervalNumber());
        i.j.u1(parcel, 3, getTransmissionRiskLevel());
        i.j.u1(parcel, 4, getRollingPeriod());
        i.j.u1(parcel, 5, getReportType());
        i.j.u1(parcel, 6, getDaysSinceOnsetOfSymptoms());
        i.j.F1(parcel, e2);
    }
}
