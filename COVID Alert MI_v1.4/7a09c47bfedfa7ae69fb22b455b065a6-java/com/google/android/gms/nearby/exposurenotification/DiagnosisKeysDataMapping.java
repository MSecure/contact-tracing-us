package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class DiagnosisKeysDataMapping extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<DiagnosisKeysDataMapping> CREATOR = new zzc();
    public List<Integer> zza;
    @ReportType
    public int zzb;
    @Infectiousness
    public int zzc;

    public static final class DiagnosisKeysDataMappingBuilder {
        public List<Integer> zza = null;
        @ReportType
        public int zzb = 0;
        @Infectiousness
        public Integer zzc = null;

        public final DiagnosisKeysDataMapping build() {
            boolean z = true;
            t.r(this.zza != null, "Must set daysSinceOnsetToInfectiousness");
            t.r(this.zzb != 0, "Must set reportTypeWhenMissing");
            if (this.zzc == null) {
                z = false;
            }
            t.r(z, "Must set infectiousnessWhenDaysSinceOnsetMissing");
            return new DiagnosisKeysDataMapping(this.zza, this.zzb, this.zzc.intValue());
        }

        public final DiagnosisKeysDataMappingBuilder setDaysSinceOnsetToInfectiousness(Map<Integer, Integer> map) {
            t.r(map != null, "daysSinceOnsetToInfectiousness must not be null.");
            t.u(map.size() <= 29, "the size of daysSinceOnsetToInfectiousness exceeds maximum size %d.", 29);
            Integer[] numArr = new Integer[29];
            Arrays.fill((Object[]) numArr, (Object) 0);
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int intValue = entry.getKey().intValue();
                int intValue2 = entry.getValue().intValue();
                t.u(Math.abs(intValue) <= 14, "Invalid day since onset %d", Integer.valueOf(intValue));
                t.u(zzi.zza(intValue2) != null, "Invalid value of Infectiousness %d", Integer.valueOf(intValue2));
                numArr[intValue + 14] = Integer.valueOf(intValue2);
            }
            this.zza = Arrays.asList(numArr);
            return this;
        }

        public final DiagnosisKeysDataMappingBuilder setInfectiousnessWhenDaysSinceOnsetMissing(@Infectiousness int i) {
            t.u(zzi.zza(i) != null, "Invalid value of Infectiousness %d", Integer.valueOf(i));
            this.zzc = Integer.valueOf(i);
            return this;
        }

        public final DiagnosisKeysDataMappingBuilder setReportTypeWhenMissing(@ReportType int i) {
            t.r(i != 0, "Invalid reportTypeWhenMissing value");
            t.u(i >= 0 && i <= 5, "Invalid value of ReportType %d", Integer.valueOf(i));
            this.zzb = i;
            return this;
        }
    }

    public DiagnosisKeysDataMapping(List<Integer> list, @ReportType int i, @Infectiousness int i2) {
        this.zza = list;
        this.zzb = i;
        this.zzc = i2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof DiagnosisKeysDataMapping) {
            DiagnosisKeysDataMapping diagnosisKeysDataMapping = (DiagnosisKeysDataMapping) obj;
            return this.zza.equals(diagnosisKeysDataMapping.zza) && this.zzb == diagnosisKeysDataMapping.zzb && this.zzc == diagnosisKeysDataMapping.zzc;
        }
    }

    public Map<Integer, Integer> getDaysSinceOnsetToInfectiousness() {
        HashMap hashMap = new HashMap(39);
        for (int i = 0; i < this.zza.size(); i++) {
            hashMap.put(Integer.valueOf(i - 14), this.zza.get(i));
        }
        return hashMap;
    }

    @Infectiousness
    public int getInfectiousnessWhenDaysSinceOnsetMissing() {
        return this.zzc;
    }

    @ReportType
    public int getReportTypeWhenMissing() {
        return this.zzb;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, Integer.valueOf(this.zzb), Integer.valueOf(this.zzc)});
    }

    public String toString() {
        return String.format(Locale.US, "DiagnosisKeysDataMapping<daysSinceOnsetToInfectiousness: %s, reportTypeWhenMissing: %d, infectiousnessWhenDaysSinceOnsetMissing: %d>", getDaysSinceOnsetToInfectiousness(), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc));
    }

    public void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        t.s3(parcel, 1, new ArrayList(this.zza), false);
        t.q3(parcel, 2, getReportTypeWhenMissing());
        t.q3(parcel, 3, getInfectiousnessWhenDaysSinceOnsetMissing());
        t.w4(parcel, m);
    }
}
