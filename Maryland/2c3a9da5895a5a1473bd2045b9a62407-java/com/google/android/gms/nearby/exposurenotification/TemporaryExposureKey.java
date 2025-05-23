package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
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
    @RecentlyNonNull
    public static final Parcelable.Creator<TemporaryExposureKey> CREATOR = new q();
    public byte[] b;
    public int c;

    /* renamed from: d  reason: collision with root package name */
    public int f452d;

    /* renamed from: e  reason: collision with root package name */
    public int f453e;

    /* renamed from: f  reason: collision with root package name */
    public int f454f;

    /* renamed from: g  reason: collision with root package name */
    public int f455g;

    public TemporaryExposureKey(byte[] bArr, int i2, int i3, int i4, int i5, int i6) {
        this.b = bArr;
        this.c = i2;
        this.f452d = i3;
        this.f453e = i4;
        this.f454f = i5;
        this.f455g = i6;
    }

    @RecentlyNonNull
    public byte[] d() {
        byte[] bArr = this.b;
        return Arrays.copyOf(bArr, bArr.length);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TemporaryExposureKey)) {
            return false;
        }
        TemporaryExposureKey temporaryExposureKey = (TemporaryExposureKey) obj;
        return Arrays.equals(this.b, temporaryExposureKey.d()) && m.h.U(Integer.valueOf(this.c), Integer.valueOf(temporaryExposureKey.c)) && m.h.U(Integer.valueOf(this.f452d), Integer.valueOf(temporaryExposureKey.f452d)) && m.h.U(Integer.valueOf(this.f453e), Integer.valueOf(temporaryExposureKey.f453e)) && m.h.U(Integer.valueOf(this.f454f), Integer.valueOf(temporaryExposureKey.f454f)) && this.f455g == temporaryExposureKey.f455g;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, Integer.valueOf(this.c), Integer.valueOf(this.f452d), Integer.valueOf(this.f453e), Integer.valueOf(this.f454f), Integer.valueOf(this.f455g)});
    }

    @RecentlyNonNull
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
        objArr[2] = Integer.valueOf(this.f452d);
        objArr[3] = Integer.valueOf(this.f453e);
        objArr[4] = Integer.valueOf(this.f454f);
        int i5 = this.f455g;
        objArr[5] = i5 == Integer.MAX_VALUE ? "unknown" : Integer.valueOf(i5);
        return String.format(locale, "TemporaryExposureKey<keyData: %s, rollingStartIntervalNumber: %s, transmissionRiskLevel: %d, rollingPeriod: %d, reportType: %d, daysSinceOnsetOfSymptoms: %s>", objArr);
    }

    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i2) {
        int I1 = m.h.I1(parcel, 20293);
        m.h.z1(parcel, 1, d(), false);
        int i3 = this.c;
        m.h.M1(parcel, 2, 4);
        parcel.writeInt(i3);
        int i4 = this.f452d;
        m.h.M1(parcel, 3, 4);
        parcel.writeInt(i4);
        int i5 = this.f453e;
        m.h.M1(parcel, 4, 4);
        parcel.writeInt(i5);
        int i6 = this.f454f;
        m.h.M1(parcel, 5, 4);
        parcel.writeInt(i6);
        int i7 = this.f455g;
        m.h.M1(parcel, 6, 4);
        parcel.writeInt(i7);
        m.h.N1(parcel, I1);
    }
}
