package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public class DiagnosisKeysDataMapping extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<DiagnosisKeysDataMapping> CREATOR = new zzc();
    public List<Integer> zza;
    public int zzb;
    public int zzc;

    public DiagnosisKeysDataMapping(List<Integer> list, int i, int i2) {
        this.zza = list;
        this.zzb = i;
        this.zzc = i2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof DiagnosisKeysDataMapping) {
            DiagnosisKeysDataMapping diagnosisKeysDataMapping = (DiagnosisKeysDataMapping) obj;
            if (this.zza.equals(diagnosisKeysDataMapping.zza) && this.zzb == diagnosisKeysDataMapping.zzb && this.zzc == diagnosisKeysDataMapping.zzc) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, Integer.valueOf(this.zzb), Integer.valueOf(this.zzc)});
    }

    public String toString() {
        Locale locale = Locale.US;
        Object[] objArr = new Object[3];
        HashMap hashMap = new HashMap(39);
        for (int i = 0; i < this.zza.size(); i++) {
            hashMap.put(Integer.valueOf(i - 14), this.zza.get(i));
        }
        objArr[0] = hashMap;
        objArr[1] = Integer.valueOf(this.zzb);
        objArr[2] = Integer.valueOf(this.zzc);
        return String.format(locale, "DiagnosisKeysDataMapping<daysSinceOnsetToInfectiousness: %s, reportTypeWhenMissing: %d, infectiousnessWhenDaysSinceOnsetMissing: %d>", objArr);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = ReactYogaConfigProvider.beginObjectHeader(parcel);
        ReactYogaConfigProvider.writeIntegerList(parcel, 1, new ArrayList(this.zza), false);
        ReactYogaConfigProvider.writeInt(parcel, 2, this.zzb);
        ReactYogaConfigProvider.writeInt(parcel, 3, this.zzc);
        ReactYogaConfigProvider.zzb(parcel, beginObjectHeader);
    }
}
