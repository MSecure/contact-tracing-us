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

public final class TemporaryExposureKey extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<TemporaryExposureKey> CREATOR = new q();
    public byte[] b;
    public int c;

    /* renamed from: d  reason: collision with root package name */
    public int f476d;

    /* renamed from: e  reason: collision with root package name */
    public int f477e;

    /* renamed from: f  reason: collision with root package name */
    public int f478f;

    /* renamed from: g  reason: collision with root package name */
    public int f479g;

    public TemporaryExposureKey(byte[] bArr, int i2, int i3, int i4, int i5, int i6) {
        this.b = bArr;
        this.c = i2;
        this.f476d = i3;
        this.f477e = i4;
        this.f478f = i5;
        this.f479g = i6;
    }

    public byte[] d() {
        byte[] bArr = this.b;
        return Arrays.copyOf(bArr, bArr.length);
    }

    public boolean equals(Object obj) {
        if (obj instanceof TemporaryExposureKey) {
            TemporaryExposureKey temporaryExposureKey = (TemporaryExposureKey) obj;
            if (!Arrays.equals(this.b, temporaryExposureKey.d()) || !m.e.W(Integer.valueOf(this.c), Integer.valueOf(temporaryExposureKey.c)) || !m.e.W(Integer.valueOf(this.f476d), Integer.valueOf(temporaryExposureKey.f476d)) || !m.e.W(Integer.valueOf(this.f477e), Integer.valueOf(temporaryExposureKey.f477e)) || !m.e.W(Integer.valueOf(this.f478f), Integer.valueOf(temporaryExposureKey.f478f)) || this.f479g != temporaryExposureKey.f479g) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(Arrays.hashCode(this.b)), Integer.valueOf(this.c), Integer.valueOf(this.f476d), Integer.valueOf(this.f477e), Integer.valueOf(this.f478f), Integer.valueOf(this.f479g)});
    }

    public String toString() {
        Locale locale = Locale.US;
        Object[] objArr = new Object[6];
        byte[] bArr = this.b;
        char[] cArr = new char[(bArr.length << 1)];
        int i2 = 0;
        for (byte b2 : bArr) {
            int i3 = b2 & 255;
            int i4 = i2 + 1;
            char[] cArr2 = c.a;
            cArr[i2] = cArr2[i3 >>> 4];
            i2 = i4 + 1;
            cArr[i4] = cArr2[i3 & 15];
        }
        objArr[0] = new String(cArr);
        objArr[1] = new Date(TimeUnit.MINUTES.toMillis(((long) this.c) * 10));
        objArr[2] = Integer.valueOf(this.f476d);
        objArr[3] = Integer.valueOf(this.f477e);
        objArr[4] = Integer.valueOf(this.f478f);
        int i5 = this.f479g;
        objArr[5] = i5 == Integer.MAX_VALUE ? "unknown" : Integer.valueOf(i5);
        return String.format(locale, "TemporaryExposureKey<keyData: %s, rollingStartIntervalNumber: %s, transmissionRiskLevel: %d, rollingPeriod: %d, reportType: %d, daysSinceOnsetOfSymptoms: %s>", objArr);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int b2 = m.e.b2(parcel, 20293);
        m.e.S1(parcel, 1, d(), false);
        int i3 = this.c;
        m.e.f2(parcel, 2, 4);
        parcel.writeInt(i3);
        int i4 = this.f476d;
        m.e.f2(parcel, 3, 4);
        parcel.writeInt(i4);
        int i5 = this.f477e;
        m.e.f2(parcel, 4, 4);
        parcel.writeInt(i5);
        int i6 = this.f478f;
        m.e.f2(parcel, 5, 4);
        parcel.writeInt(i6);
        int i7 = this.f479g;
        m.e.f2(parcel, 6, 4);
        parcel.writeInt(i7);
        m.e.g2(parcel, b2);
    }
}
