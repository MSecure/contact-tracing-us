package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.util.Hex;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public final class TemporaryExposureKey extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<TemporaryExposureKey> CREATOR = new zzo();
    public byte[] zza;
    public int zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public int zzf;

    public TemporaryExposureKey(byte[] bArr, int i, int i2, int i3, int i4, int i5) {
        this.zza = bArr;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i3;
        this.zze = i4;
        this.zzf = i5;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof TemporaryExposureKey)) {
            return false;
        }
        TemporaryExposureKey temporaryExposureKey = (TemporaryExposureKey) obj;
        return Arrays.equals(this.zza, temporaryExposureKey.getKeyData()) && ReactYogaConfigProvider.equal(Integer.valueOf(this.zzb), Integer.valueOf(temporaryExposureKey.zzb)) && ReactYogaConfigProvider.equal(Integer.valueOf(this.zzc), Integer.valueOf(temporaryExposureKey.zzc)) && ReactYogaConfigProvider.equal(Integer.valueOf(this.zzd), Integer.valueOf(temporaryExposureKey.zzd)) && ReactYogaConfigProvider.equal(Integer.valueOf(this.zze), Integer.valueOf(temporaryExposureKey.zze)) && this.zzf == temporaryExposureKey.zzf;
    }

    public final byte[] getKeyData() {
        byte[] bArr = this.zza;
        return Arrays.copyOf(bArr, bArr.length);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd), Integer.valueOf(this.zze), Integer.valueOf(this.zzf)});
    }

    public final String toString() {
        Object obj;
        Locale locale = Locale.US;
        Object[] objArr = new Object[6];
        byte[] bArr = this.zza;
        char[] cArr = new char[(bArr.length << 1)];
        int i = 0;
        for (byte b : bArr) {
            int i2 = b & 255;
            int i3 = i + 1;
            char[] cArr2 = Hex.zzb;
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
        if (i4 == Integer.MAX_VALUE) {
            obj = "unknown";
        } else {
            obj = Integer.valueOf(i4);
        }
        objArr[5] = obj;
        return String.format(locale, "TemporaryExposureKey<keyData: %s, rollingStartIntervalNumber: %s, transmissionRiskLevel: %d, rollingPeriod: %d, reportType: %d, daysSinceOnsetOfSymptoms: %s>", objArr);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = ReactYogaConfigProvider.beginObjectHeader(parcel);
        ReactYogaConfigProvider.writeByteArray(parcel, 1, getKeyData(), false);
        ReactYogaConfigProvider.writeInt(parcel, 2, this.zzb);
        ReactYogaConfigProvider.writeInt(parcel, 3, this.zzc);
        ReactYogaConfigProvider.writeInt(parcel, 4, this.zzd);
        ReactYogaConfigProvider.writeInt(parcel, 5, this.zze);
        ReactYogaConfigProvider.writeInt(parcel, 6, this.zzf);
        ReactYogaConfigProvider.zzb(parcel, beginObjectHeader);
    }
}
