package f.b.a.c.f.b;

import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import java.util.Arrays;
import java.util.Locale;

@Deprecated
public final class b extends f.b.a.c.b.m.n.a {
    public static final Parcelable.Creator<b> CREATOR = new k();
    public int b;
    public int[] c;

    /* renamed from: d  reason: collision with root package name */
    public int f2701d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f2702e;

    /* renamed from: f  reason: collision with root package name */
    public int f2703f;

    /* renamed from: g  reason: collision with root package name */
    public int[] f2704g;

    /* renamed from: h  reason: collision with root package name */
    public int f2705h;

    /* renamed from: i  reason: collision with root package name */
    public int[] f2706i;

    /* renamed from: j  reason: collision with root package name */
    public int f2707j;

    /* renamed from: k  reason: collision with root package name */
    public int[] f2708k;

    public static final class a {
        public int[] a = {4, 4, 4, 4, 4, 4, 4, 4};
        public int[] b = {4, 4, 4, 4, 4, 4, 4, 4};
        public int[] c = {4, 4, 4, 4, 4, 4, 4, 4};

        /* renamed from: d  reason: collision with root package name */
        public int[] f2709d = {4, 4, 4, 4, 4, 4, 4, 4};

        /* renamed from: e  reason: collision with root package name */
        public int[] f2710e = {50, 74};
    }

    public b(int i2, int[] iArr, int i3, int[] iArr2, int i4, int[] iArr3, int i5, int[] iArr4, int i6, int[] iArr5) {
        this.b = i2;
        this.c = iArr;
        this.f2701d = i3;
        this.f2702e = iArr2;
        this.f2703f = i4;
        this.f2704g = iArr3;
        this.f2705h = i5;
        this.f2706i = iArr4;
        this.f2707j = i6;
        this.f2708k = iArr5;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!m.h.U(Integer.valueOf(this.b), Integer.valueOf(bVar.b))) {
            return false;
        }
        int[] iArr = this.c;
        int[] iArr2 = bVar.c;
        if (!Arrays.equals(iArr, Arrays.copyOf(iArr2, iArr2.length)) || !m.h.U(Integer.valueOf(this.f2701d), Integer.valueOf(bVar.f2701d))) {
            return false;
        }
        int[] iArr3 = this.f2702e;
        int[] iArr4 = bVar.f2702e;
        if (!Arrays.equals(iArr3, Arrays.copyOf(iArr4, iArr4.length)) || !m.h.U(Integer.valueOf(this.f2703f), Integer.valueOf(bVar.f2703f))) {
            return false;
        }
        int[] iArr5 = this.f2704g;
        int[] iArr6 = bVar.f2704g;
        if (!Arrays.equals(iArr5, Arrays.copyOf(iArr6, iArr6.length)) || !m.h.U(Integer.valueOf(this.f2705h), Integer.valueOf(bVar.f2705h))) {
            return false;
        }
        int[] iArr7 = this.f2706i;
        int[] iArr8 = bVar.f2706i;
        if (!Arrays.equals(iArr7, Arrays.copyOf(iArr8, iArr8.length)) || !m.h.U(Integer.valueOf(this.f2707j), Integer.valueOf(bVar.f2707j))) {
            return false;
        }
        int[] iArr9 = this.f2708k;
        int[] iArr10 = bVar.f2708k;
        return Arrays.equals(iArr9, Arrays.copyOf(iArr10, iArr10.length));
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.b), this.c, Integer.valueOf(this.f2701d), this.f2702e, Integer.valueOf(this.f2703f), this.f2704g, Integer.valueOf(this.f2705h), this.f2706i, Integer.valueOf(this.f2707j), this.f2708k});
    }

    public String toString() {
        return String.format(Locale.US, "ExposureConfiguration<minimumRiskScore: %d, attenuationScores: %s, attenuationWeight: %d, daysSinceLastExposureScores: %s, daysSinceLastExposureWeight: %d, durationScores: %s, durationWeight: %d, transmissionRiskScores: %s, transmissionRiskWeight: %d, durationAtAttenuationThresholds: %s>", Integer.valueOf(this.b), Arrays.toString(this.c), Integer.valueOf(this.f2701d), Arrays.toString(this.f2702e), Integer.valueOf(this.f2703f), Arrays.toString(this.f2704g), Integer.valueOf(this.f2705h), Arrays.toString(this.f2706i), Integer.valueOf(this.f2707j), Arrays.toString(this.f2708k));
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int O1 = m.h.O1(parcel, 20293);
        int i3 = this.b;
        m.h.S1(parcel, 1, 4);
        parcel.writeInt(i3);
        int[] iArr = this.c;
        m.h.I1(parcel, 2, Arrays.copyOf(iArr, iArr.length), false);
        int i4 = this.f2701d;
        m.h.S1(parcel, 3, 4);
        parcel.writeInt(i4);
        int[] iArr2 = this.f2702e;
        m.h.I1(parcel, 4, Arrays.copyOf(iArr2, iArr2.length), false);
        int i5 = this.f2703f;
        m.h.S1(parcel, 5, 4);
        parcel.writeInt(i5);
        int[] iArr3 = this.f2704g;
        m.h.I1(parcel, 6, Arrays.copyOf(iArr3, iArr3.length), false);
        int i6 = this.f2705h;
        m.h.S1(parcel, 7, 4);
        parcel.writeInt(i6);
        int[] iArr4 = this.f2706i;
        m.h.I1(parcel, 8, Arrays.copyOf(iArr4, iArr4.length), false);
        int i7 = this.f2707j;
        m.h.S1(parcel, 9, 4);
        parcel.writeInt(i7);
        int[] iArr5 = this.f2708k;
        m.h.I1(parcel, 10, Arrays.copyOf(iArr5, iArr5.length), false);
        m.h.T1(parcel, O1);
    }
}
