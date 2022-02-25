package f.b.a.c.f.b;

import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import java.util.Arrays;
import java.util.Locale;

@Deprecated
public final class b extends f.b.a.c.b.m.n.a {
    public static final Parcelable.Creator<b> CREATOR = new j();
    public int b;
    public int[] c;

    /* renamed from: d  reason: collision with root package name */
    public int f2513d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f2514e;

    /* renamed from: f  reason: collision with root package name */
    public int f2515f;

    /* renamed from: g  reason: collision with root package name */
    public int[] f2516g;

    /* renamed from: h  reason: collision with root package name */
    public int f2517h;

    /* renamed from: i  reason: collision with root package name */
    public int[] f2518i;

    /* renamed from: j  reason: collision with root package name */
    public int f2519j;

    /* renamed from: k  reason: collision with root package name */
    public int[] f2520k;

    public static final class a {
        public int[] a = {4, 4, 4, 4, 4, 4, 4, 4};
        public int[] b = {4, 4, 4, 4, 4, 4, 4, 4};
        public int[] c = {4, 4, 4, 4, 4, 4, 4, 4};

        /* renamed from: d  reason: collision with root package name */
        public int[] f2521d = {4, 4, 4, 4, 4, 4, 4, 4};

        /* renamed from: e  reason: collision with root package name */
        public int[] f2522e = {50, 74};
    }

    public b(int i2, int[] iArr, int i3, int[] iArr2, int i4, int[] iArr3, int i5, int[] iArr4, int i6, int[] iArr5) {
        this.b = i2;
        this.c = iArr;
        this.f2513d = i3;
        this.f2514e = iArr2;
        this.f2515f = i4;
        this.f2516g = iArr3;
        this.f2517h = i5;
        this.f2518i = iArr4;
        this.f2519j = i6;
        this.f2520k = iArr5;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!m.h.U(Integer.valueOf(this.b), Integer.valueOf(bVar.b))) {
            return false;
        }
        int[] iArr = this.c;
        int[] iArr2 = bVar.c;
        if (!Arrays.equals(iArr, Arrays.copyOf(iArr2, iArr2.length)) || !m.h.U(Integer.valueOf(this.f2513d), Integer.valueOf(bVar.f2513d))) {
            return false;
        }
        int[] iArr3 = this.f2514e;
        int[] iArr4 = bVar.f2514e;
        if (!Arrays.equals(iArr3, Arrays.copyOf(iArr4, iArr4.length)) || !m.h.U(Integer.valueOf(this.f2515f), Integer.valueOf(bVar.f2515f))) {
            return false;
        }
        int[] iArr5 = this.f2516g;
        int[] iArr6 = bVar.f2516g;
        if (!Arrays.equals(iArr5, Arrays.copyOf(iArr6, iArr6.length)) || !m.h.U(Integer.valueOf(this.f2517h), Integer.valueOf(bVar.f2517h))) {
            return false;
        }
        int[] iArr7 = this.f2518i;
        int[] iArr8 = bVar.f2518i;
        if (!Arrays.equals(iArr7, Arrays.copyOf(iArr8, iArr8.length)) || !m.h.U(Integer.valueOf(this.f2519j), Integer.valueOf(bVar.f2519j))) {
            return false;
        }
        int[] iArr9 = this.f2520k;
        int[] iArr10 = bVar.f2520k;
        return Arrays.equals(iArr9, Arrays.copyOf(iArr10, iArr10.length));
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.b), this.c, Integer.valueOf(this.f2513d), this.f2514e, Integer.valueOf(this.f2515f), this.f2516g, Integer.valueOf(this.f2517h), this.f2518i, Integer.valueOf(this.f2519j), this.f2520k});
    }

    public final String toString() {
        return String.format(Locale.US, "ExposureConfiguration<minimumRiskScore: %d, attenuationScores: %s, attenuationWeight: %d, daysSinceLastExposureScores: %s, daysSinceLastExposureWeight: %d, durationScores: %s, durationWeight: %d, transmissionRiskScores: %s, transmissionRiskWeight: %d, durationAtAttenuationThresholds: %s>", Integer.valueOf(this.b), Arrays.toString(this.c), Integer.valueOf(this.f2513d), Arrays.toString(this.f2514e), Integer.valueOf(this.f2515f), Arrays.toString(this.f2516g), Integer.valueOf(this.f2517h), Arrays.toString(this.f2518i), Integer.valueOf(this.f2519j), Arrays.toString(this.f2520k));
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int H1 = m.h.H1(parcel, 20293);
        int i3 = this.b;
        m.h.L1(parcel, 1, 4);
        parcel.writeInt(i3);
        int[] iArr = this.c;
        m.h.B1(parcel, 2, Arrays.copyOf(iArr, iArr.length), false);
        int i4 = this.f2513d;
        m.h.L1(parcel, 3, 4);
        parcel.writeInt(i4);
        int[] iArr2 = this.f2514e;
        m.h.B1(parcel, 4, Arrays.copyOf(iArr2, iArr2.length), false);
        int i5 = this.f2515f;
        m.h.L1(parcel, 5, 4);
        parcel.writeInt(i5);
        int[] iArr3 = this.f2516g;
        m.h.B1(parcel, 6, Arrays.copyOf(iArr3, iArr3.length), false);
        int i6 = this.f2517h;
        m.h.L1(parcel, 7, 4);
        parcel.writeInt(i6);
        int[] iArr4 = this.f2518i;
        m.h.B1(parcel, 8, Arrays.copyOf(iArr4, iArr4.length), false);
        int i7 = this.f2519j;
        m.h.L1(parcel, 9, 4);
        parcel.writeInt(i7);
        int[] iArr5 = this.f2520k;
        m.h.B1(parcel, 10, Arrays.copyOf(iArr5, iArr5.length), false);
        m.h.M1(parcel, H1);
    }
}
