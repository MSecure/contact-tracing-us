package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import e.b.a.m;
import f.b.a.c.b.m.n.a;
import f.b.a.c.f.b.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class DiagnosisKeysDataMapping extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<DiagnosisKeysDataMapping> CREATOR = new i();
    public List<Integer> b;
    public int c;

    /* renamed from: d  reason: collision with root package name */
    public int f434d;

    public DiagnosisKeysDataMapping(List<Integer> list, int i2, int i3) {
        this.b = list;
        this.c = i2;
        this.f434d = i3;
    }

    public boolean equals(Object obj) {
        if (obj instanceof DiagnosisKeysDataMapping) {
            DiagnosisKeysDataMapping diagnosisKeysDataMapping = (DiagnosisKeysDataMapping) obj;
            return this.b.equals(diagnosisKeysDataMapping.b) && this.c == diagnosisKeysDataMapping.c && this.f434d == diagnosisKeysDataMapping.f434d;
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, Integer.valueOf(this.c), Integer.valueOf(this.f434d)});
    }

    public String toString() {
        Locale locale = Locale.US;
        Object[] objArr = new Object[3];
        HashMap hashMap = new HashMap(39);
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            hashMap.put(Integer.valueOf(i2 - 14), this.b.get(i2));
        }
        objArr[0] = hashMap;
        objArr[1] = Integer.valueOf(this.c);
        objArr[2] = Integer.valueOf(this.f434d);
        return String.format(locale, "DiagnosisKeysDataMapping<daysSinceOnsetToInfectiousness: %s, reportTypeWhenMissing: %d, infectiousnessWhenDaysSinceOnsetMissing: %d>", objArr);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int I1 = m.h.I1(parcel, 20293);
        m.h.D1(parcel, 1, new ArrayList(this.b), false);
        int i3 = this.c;
        m.h.M1(parcel, 2, 4);
        parcel.writeInt(i3);
        int i4 = this.f434d;
        m.h.M1(parcel, 3, 4);
        parcel.writeInt(i4);
        m.h.N1(parcel, I1);
    }
}
