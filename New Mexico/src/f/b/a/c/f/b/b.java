package f.b.a.c.f.b;

import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import java.util.Arrays;
import java.util.Locale;
@Deprecated
/* loaded from: classes.dex */
public final class b extends f.b.a.c.b.m.n.a {
    public static final Parcelable.Creator<b> CREATOR = new k();
    public int b;
    public int[] c;

    /* renamed from: d */
    public int f2796d;

    /* renamed from: e */
    public int[] f2797e;

    /* renamed from: f */
    public int f2798f;

    /* renamed from: g */
    public int[] f2799g;

    /* renamed from: h */
    public int f2800h;

    /* renamed from: i */
    public int[] f2801i;

    /* renamed from: j */
    public int f2802j;

    /* renamed from: k */
    public int[] f2803k;

    /* loaded from: classes.dex */
    public static final class a {
        public int[] a = {4, 4, 4, 4, 4, 4, 4, 4};
        public int[] b = {4, 4, 4, 4, 4, 4, 4, 4};
        public int[] c = {4, 4, 4, 4, 4, 4, 4, 4};

        /* renamed from: d */
        public int[] f2804d = {4, 4, 4, 4, 4, 4, 4, 4};

        /* renamed from: e */
        public int[] f2805e = {50, 74};
    }

    public b(int i2, int[] iArr, int i3, int[] iArr2, int i4, int[] iArr3, int i5, int[] iArr4, int i6, int[] iArr5) {
        this.b = i2;
        this.c = iArr;
        this.f2796d = i3;
        this.f2797e = iArr2;
        this.f2798f = i4;
        this.f2799g = iArr3;
        this.f2800h = i5;
        this.f2801i = iArr4;
        this.f2802j = i6;
        this.f2803k = iArr5;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!m.e.X(Integer.valueOf(this.b), Integer.valueOf(bVar.b))) {
            return false;
        }
        int[] iArr = this.c;
        int[] iArr2 = bVar.c;
        if (!Arrays.equals(iArr, Arrays.copyOf(iArr2, iArr2.length)) || !m.e.X(Integer.valueOf(this.f2796d), Integer.valueOf(bVar.f2796d))) {
            return false;
        }
        int[] iArr3 = this.f2797e;
        int[] iArr4 = bVar.f2797e;
        if (!Arrays.equals(iArr3, Arrays.copyOf(iArr4, iArr4.length)) || !m.e.X(Integer.valueOf(this.f2798f), Integer.valueOf(bVar.f2798f))) {
            return false;
        }
        int[] iArr5 = this.f2799g;
        int[] iArr6 = bVar.f2799g;
        if (!Arrays.equals(iArr5, Arrays.copyOf(iArr6, iArr6.length)) || !m.e.X(Integer.valueOf(this.f2800h), Integer.valueOf(bVar.f2800h))) {
            return false;
        }
        int[] iArr7 = this.f2801i;
        int[] iArr8 = bVar.f2801i;
        if (!Arrays.equals(iArr7, Arrays.copyOf(iArr8, iArr8.length)) || !m.e.X(Integer.valueOf(this.f2802j), Integer.valueOf(bVar.f2802j))) {
            return false;
        }
        int[] iArr9 = this.f2803k;
        int[] iArr10 = bVar.f2803k;
        return Arrays.equals(iArr9, Arrays.copyOf(iArr10, iArr10.length));
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.b), this.c, Integer.valueOf(this.f2796d), this.f2797e, Integer.valueOf(this.f2798f), this.f2799g, Integer.valueOf(this.f2800h), this.f2801i, Integer.valueOf(this.f2802j), this.f2803k});
    }

    @Override // java.lang.Object
    public String toString() {
        return String.format(Locale.US, "ExposureConfiguration<minimumRiskScore: %d, attenuationScores: %s, attenuationWeight: %d, daysSinceLastExposureScores: %s, daysSinceLastExposureWeight: %d, durationScores: %s, durationWeight: %d, transmissionRiskScores: %s, transmissionRiskWeight: %d, durationAtAttenuationThresholds: %s>", Integer.valueOf(this.b), Arrays.toString(this.c), Integer.valueOf(this.f2796d), Arrays.toString(this.f2797e), Integer.valueOf(this.f2798f), Arrays.toString(this.f2799g), Integer.valueOf(this.f2800h), Arrays.toString(this.f2801i), Integer.valueOf(this.f2802j), Arrays.toString(this.f2803k));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int j2 = m.e.j2(parcel, 20293);
        int i3 = this.b;
        m.e.n2(parcel, 1, 4);
        parcel.writeInt(i3);
        int[] iArr = this.c;
        m.e.d2(parcel, 2, Arrays.copyOf(iArr, iArr.length), false);
        int i4 = this.f2796d;
        m.e.n2(parcel, 3, 4);
        parcel.writeInt(i4);
        int[] iArr2 = this.f2797e;
        m.e.d2(parcel, 4, Arrays.copyOf(iArr2, iArr2.length), false);
        int i5 = this.f2798f;
        m.e.n2(parcel, 5, 4);
        parcel.writeInt(i5);
        int[] iArr3 = this.f2799g;
        m.e.d2(parcel, 6, Arrays.copyOf(iArr3, iArr3.length), false);
        int i6 = this.f2800h;
        m.e.n2(parcel, 7, 4);
        parcel.writeInt(i6);
        int[] iArr4 = this.f2801i;
        m.e.d2(parcel, 8, Arrays.copyOf(iArr4, iArr4.length), false);
        int i7 = this.f2802j;
        m.e.n2(parcel, 9, 4);
        parcel.writeInt(i7);
        int[] iArr5 = this.f2803k;
        m.e.d2(parcel, 10, Arrays.copyOf(iArr5, iArr5.length), false);
        m.e.o2(parcel, j2);
    }
}
