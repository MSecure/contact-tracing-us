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
    public int f2755d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f2756e;

    /* renamed from: f  reason: collision with root package name */
    public int f2757f;

    /* renamed from: g  reason: collision with root package name */
    public int[] f2758g;

    /* renamed from: h  reason: collision with root package name */
    public int f2759h;

    /* renamed from: i  reason: collision with root package name */
    public int[] f2760i;

    /* renamed from: j  reason: collision with root package name */
    public int f2761j;

    /* renamed from: k  reason: collision with root package name */
    public int[] f2762k;

    public static final class a {
        public int[] a = {4, 4, 4, 4, 4, 4, 4, 4};
        public int[] b = {4, 4, 4, 4, 4, 4, 4, 4};
        public int[] c = {4, 4, 4, 4, 4, 4, 4, 4};

        /* renamed from: d  reason: collision with root package name */
        public int[] f2763d = {4, 4, 4, 4, 4, 4, 4, 4};

        /* renamed from: e  reason: collision with root package name */
        public int[] f2764e = {50, 74};
    }

    public b(int i2, int[] iArr, int i3, int[] iArr2, int i4, int[] iArr3, int i5, int[] iArr4, int i6, int[] iArr5) {
        this.b = i2;
        this.c = iArr;
        this.f2755d = i3;
        this.f2756e = iArr2;
        this.f2757f = i4;
        this.f2758g = iArr3;
        this.f2759h = i5;
        this.f2760i = iArr4;
        this.f2761j = i6;
        this.f2762k = iArr5;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!m.e.W(Integer.valueOf(this.b), Integer.valueOf(bVar.b))) {
            return false;
        }
        int[] iArr = this.c;
        int[] iArr2 = bVar.c;
        if (!Arrays.equals(iArr, Arrays.copyOf(iArr2, iArr2.length)) || !m.e.W(Integer.valueOf(this.f2755d), Integer.valueOf(bVar.f2755d))) {
            return false;
        }
        int[] iArr3 = this.f2756e;
        int[] iArr4 = bVar.f2756e;
        if (!Arrays.equals(iArr3, Arrays.copyOf(iArr4, iArr4.length)) || !m.e.W(Integer.valueOf(this.f2757f), Integer.valueOf(bVar.f2757f))) {
            return false;
        }
        int[] iArr5 = this.f2758g;
        int[] iArr6 = bVar.f2758g;
        if (!Arrays.equals(iArr5, Arrays.copyOf(iArr6, iArr6.length)) || !m.e.W(Integer.valueOf(this.f2759h), Integer.valueOf(bVar.f2759h))) {
            return false;
        }
        int[] iArr7 = this.f2760i;
        int[] iArr8 = bVar.f2760i;
        if (!Arrays.equals(iArr7, Arrays.copyOf(iArr8, iArr8.length)) || !m.e.W(Integer.valueOf(this.f2761j), Integer.valueOf(bVar.f2761j))) {
            return false;
        }
        int[] iArr9 = this.f2762k;
        int[] iArr10 = bVar.f2762k;
        return Arrays.equals(iArr9, Arrays.copyOf(iArr10, iArr10.length));
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.b), this.c, Integer.valueOf(this.f2755d), this.f2756e, Integer.valueOf(this.f2757f), this.f2758g, Integer.valueOf(this.f2759h), this.f2760i, Integer.valueOf(this.f2761j), this.f2762k});
    }

    public String toString() {
        return String.format(Locale.US, "ExposureConfiguration<minimumRiskScore: %d, attenuationScores: %s, attenuationWeight: %d, daysSinceLastExposureScores: %s, daysSinceLastExposureWeight: %d, durationScores: %s, durationWeight: %d, transmissionRiskScores: %s, transmissionRiskWeight: %d, durationAtAttenuationThresholds: %s>", Integer.valueOf(this.b), Arrays.toString(this.c), Integer.valueOf(this.f2755d), Arrays.toString(this.f2756e), Integer.valueOf(this.f2757f), Arrays.toString(this.f2758g), Integer.valueOf(this.f2759h), Arrays.toString(this.f2760i), Integer.valueOf(this.f2761j), Arrays.toString(this.f2762k));
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int b2 = m.e.b2(parcel, 20293);
        int i3 = this.b;
        m.e.f2(parcel, 1, 4);
        parcel.writeInt(i3);
        int[] iArr = this.c;
        m.e.V1(parcel, 2, Arrays.copyOf(iArr, iArr.length), false);
        int i4 = this.f2755d;
        m.e.f2(parcel, 3, 4);
        parcel.writeInt(i4);
        int[] iArr2 = this.f2756e;
        m.e.V1(parcel, 4, Arrays.copyOf(iArr2, iArr2.length), false);
        int i5 = this.f2757f;
        m.e.f2(parcel, 5, 4);
        parcel.writeInt(i5);
        int[] iArr3 = this.f2758g;
        m.e.V1(parcel, 6, Arrays.copyOf(iArr3, iArr3.length), false);
        int i6 = this.f2759h;
        m.e.f2(parcel, 7, 4);
        parcel.writeInt(i6);
        int[] iArr4 = this.f2760i;
        m.e.V1(parcel, 8, Arrays.copyOf(iArr4, iArr4.length), false);
        int i7 = this.f2761j;
        m.e.f2(parcel, 9, 4);
        parcel.writeInt(i7);
        int[] iArr5 = this.f2762k;
        m.e.V1(parcel, 10, Arrays.copyOf(iArr5, iArr5.length), false);
        m.e.g2(parcel, b2);
    }
}
