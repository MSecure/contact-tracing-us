package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import e.b.a.m;
import f.b.a.c.b.m.n.a;
import f.b.a.c.f.b.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class DiagnosisKeysDataMapping extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<DiagnosisKeysDataMapping> CREATOR = new j();
    public List<Integer> b;
    public int c;

    /* renamed from: d */
    public int f485d;

    public DiagnosisKeysDataMapping(List<Integer> list, int i2, int i3) {
        this.b = list;
        this.c = i2;
        this.f485d = i3;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj instanceof DiagnosisKeysDataMapping) {
            DiagnosisKeysDataMapping diagnosisKeysDataMapping = (DiagnosisKeysDataMapping) obj;
            if (this.b.equals(diagnosisKeysDataMapping.b) && this.c == diagnosisKeysDataMapping.c && this.f485d == diagnosisKeysDataMapping.f485d) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, Integer.valueOf(this.c), Integer.valueOf(this.f485d)});
    }

    @Override // java.lang.Object
    public String toString() {
        Locale locale = Locale.US;
        Object[] objArr = new Object[3];
        HashMap hashMap = new HashMap(39);
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            hashMap.put(Integer.valueOf(i2 - 14), this.b.get(i2));
        }
        objArr[0] = hashMap;
        objArr[1] = Integer.valueOf(this.c);
        objArr[2] = Integer.valueOf(this.f485d);
        return String.format(locale, "DiagnosisKeysDataMapping<daysSinceOnsetToInfectiousness: %s, reportTypeWhenMissing: %d, infectiousnessWhenDaysSinceOnsetMissing: %d>", objArr);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int j2 = m.e.j2(parcel, 20293);
        m.e.e2(parcel, 1, new ArrayList(this.b), false);
        int i3 = this.c;
        m.e.n2(parcel, 2, 4);
        parcel.writeInt(i3);
        int i4 = this.f485d;
        m.e.n2(parcel, 3, 4);
        parcel.writeInt(i4);
        m.e.o2(parcel, j2);
    }
}
