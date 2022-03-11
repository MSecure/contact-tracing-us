package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import e.b.a.m;
import f.b.a.c.b.m.n.a;
import f.b.a.c.b.o.c;
import f.b.a.c.f.b.q;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public final class TemporaryExposureKey extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<TemporaryExposureKey> CREATOR = new q();
    public byte[] b;
    public int c;

    /* renamed from: d */
    public int f486d;

    /* renamed from: e */
    public int f487e;

    /* renamed from: f */
    public int f488f;

    /* renamed from: g */
    public int f489g;

    /* renamed from: h */
    public int f490h;

    public TemporaryExposureKey(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.b = bArr;
        this.c = i2;
        this.f486d = i3;
        this.f487e = i4;
        this.f488f = i5;
        this.f489g = i6;
        this.f490h = i7;
    }

    public byte[] d() {
        byte[] bArr = this.b;
        return Arrays.copyOf(bArr, bArr.length);
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj instanceof TemporaryExposureKey) {
            TemporaryExposureKey temporaryExposureKey = (TemporaryExposureKey) obj;
            if (Arrays.equals(this.b, temporaryExposureKey.d()) && m.e.X(Integer.valueOf(this.c), Integer.valueOf(temporaryExposureKey.c)) && m.e.X(Integer.valueOf(this.f486d), Integer.valueOf(temporaryExposureKey.f486d)) && m.e.X(Integer.valueOf(this.f487e), Integer.valueOf(temporaryExposureKey.f487e)) && m.e.X(Integer.valueOf(this.f488f), Integer.valueOf(temporaryExposureKey.f488f)) && this.f489g == temporaryExposureKey.f489g && this.f490h == temporaryExposureKey.f490h) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(Arrays.hashCode(this.b)), Integer.valueOf(this.c), Integer.valueOf(this.f486d), Integer.valueOf(this.f487e), Integer.valueOf(this.f488f), Integer.valueOf(this.f489g), Integer.valueOf(this.f490h)});
    }

    @Override // java.lang.Object
    public String toString() {
        Locale locale = Locale.US;
        Object[] objArr = new Object[6];
        byte[] bArr = this.b;
        char[] cArr = new char[bArr.length << 1];
        int i2 = 0;
        for (byte b : bArr) {
            int i3 = b & 255;
            int i4 = i2 + 1;
            char[] cArr2 = c.a;
            cArr[i2] = cArr2[i3 >>> 4];
            i2 = i4 + 1;
            cArr[i4] = cArr2[i3 & 15];
        }
        objArr[0] = new String(cArr);
        objArr[1] = new Date(TimeUnit.MINUTES.toMillis(((long) this.c) * 10));
        objArr[2] = Integer.valueOf(this.f486d);
        objArr[3] = Integer.valueOf(this.f487e);
        objArr[4] = Integer.valueOf(this.f488f);
        int i5 = this.f489g;
        objArr[5] = i5 == Integer.MAX_VALUE ? "unknown" : Integer.valueOf(i5);
        return String.format(locale, "TemporaryExposureKey<keyData: %s, rollingStartIntervalNumber: %s, transmissionRiskLevel: %d, rollingPeriod: %d, reportType: %d, daysSinceOnsetOfSymptoms: %s>", objArr);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int j2 = m.e.j2(parcel, 20293);
        m.e.a2(parcel, 1, d(), false);
        int i3 = this.c;
        m.e.n2(parcel, 2, 4);
        parcel.writeInt(i3);
        int i4 = this.f486d;
        m.e.n2(parcel, 3, 4);
        parcel.writeInt(i4);
        int i5 = this.f487e;
        m.e.n2(parcel, 4, 4);
        parcel.writeInt(i5);
        int i6 = this.f488f;
        m.e.n2(parcel, 5, 4);
        parcel.writeInt(i6);
        int i7 = this.f489g;
        m.e.n2(parcel, 6, 4);
        parcel.writeInt(i7);
        int i8 = this.f490h;
        m.e.n2(parcel, 7, 4);
        parcel.writeInt(i8);
        m.e.o2(parcel, j2);
    }
}
