package f.b.a.c.f.b;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import e.b.a.m;
import java.util.Arrays;
import java.util.Locale;

@Deprecated
public final class b extends f.b.a.c.b.m.n.a {
    @RecentlyNonNull
    public static final Parcelable.Creator<b> CREATOR = new k();
    public int b;
    public int[] c;

    /* renamed from: d  reason: collision with root package name */
    public int f2611d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f2612e;

    /* renamed from: f  reason: collision with root package name */
    public int f2613f;

    /* renamed from: g  reason: collision with root package name */
    public int[] f2614g;

    /* renamed from: h  reason: collision with root package name */
    public int f2615h;

    /* renamed from: i  reason: collision with root package name */
    public int[] f2616i;

    /* renamed from: j  reason: collision with root package name */
    public int f2617j;

    /* renamed from: k  reason: collision with root package name */
    public int[] f2618k;

    public static final class a {
        public int[] a = {4, 4, 4, 4, 4, 4, 4, 4};
        public int[] b = {4, 4, 4, 4, 4, 4, 4, 4};
        public int[] c = {4, 4, 4, 4, 4, 4, 4, 4};

        /* renamed from: d  reason: collision with root package name */
        public int[] f2619d = {4, 4, 4, 4, 4, 4, 4, 4};

        /* renamed from: e  reason: collision with root package name */
        public int[] f2620e = {50, 74};
    }

    public b(int i2, int[] iArr, int i3, int[] iArr2, int i4, int[] iArr3, int i5, int[] iArr4, int i6, int[] iArr5) {
        this.b = i2;
        this.c = iArr;
        this.f2611d = i3;
        this.f2612e = iArr2;
        this.f2613f = i4;
        this.f2614g = iArr3;
        this.f2615h = i5;
        this.f2616i = iArr4;
        this.f2617j = i6;
        this.f2618k = iArr5;
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
        if (!Arrays.equals(iArr, Arrays.copyOf(iArr2, iArr2.length)) || !m.h.U(Integer.valueOf(this.f2611d), Integer.valueOf(bVar.f2611d))) {
            return false;
        }
        int[] iArr3 = this.f2612e;
        int[] iArr4 = bVar.f2612e;
        if (!Arrays.equals(iArr3, Arrays.copyOf(iArr4, iArr4.length)) || !m.h.U(Integer.valueOf(this.f2613f), Integer.valueOf(bVar.f2613f))) {
            return false;
        }
        int[] iArr5 = this.f2614g;
        int[] iArr6 = bVar.f2614g;
        if (!Arrays.equals(iArr5, Arrays.copyOf(iArr6, iArr6.length)) || !m.h.U(Integer.valueOf(this.f2615h), Integer.valueOf(bVar.f2615h))) {
            return false;
        }
        int[] iArr7 = this.f2616i;
        int[] iArr8 = bVar.f2616i;
        if (!Arrays.equals(iArr7, Arrays.copyOf(iArr8, iArr8.length)) || !m.h.U(Integer.valueOf(this.f2617j), Integer.valueOf(bVar.f2617j))) {
            return false;
        }
        int[] iArr9 = this.f2618k;
        int[] iArr10 = bVar.f2618k;
        return Arrays.equals(iArr9, Arrays.copyOf(iArr10, iArr10.length));
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.b), this.c, Integer.valueOf(this.f2611d), this.f2612e, Integer.valueOf(this.f2613f), this.f2614g, Integer.valueOf(this.f2615h), this.f2616i, Integer.valueOf(this.f2617j), this.f2618k});
    }

    @RecentlyNonNull
    public String toString() {
        return String.format(Locale.US, "ExposureConfiguration<minimumRiskScore: %d, attenuationScores: %s, attenuationWeight: %d, daysSinceLastExposureScores: %s, daysSinceLastExposureWeight: %d, durationScores: %s, durationWeight: %d, transmissionRiskScores: %s, transmissionRiskWeight: %d, durationAtAttenuationThresholds: %s>", Integer.valueOf(this.b), Arrays.toString(this.c), Integer.valueOf(this.f2611d), Arrays.toString(this.f2612e), Integer.valueOf(this.f2613f), Arrays.toString(this.f2614g), Integer.valueOf(this.f2615h), Arrays.toString(this.f2616i), Integer.valueOf(this.f2617j), Arrays.toString(this.f2618k));
    }

    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i2) {
        int I1 = m.h.I1(parcel, 20293);
        int i3 = this.b;
        m.h.M1(parcel, 1, 4);
        parcel.writeInt(i3);
        int[] iArr = this.c;
        m.h.C1(parcel, 2, Arrays.copyOf(iArr, iArr.length), false);
        int i4 = this.f2611d;
        m.h.M1(parcel, 3, 4);
        parcel.writeInt(i4);
        int[] iArr2 = this.f2612e;
        m.h.C1(parcel, 4, Arrays.copyOf(iArr2, iArr2.length), false);
        int i5 = this.f2613f;
        m.h.M1(parcel, 5, 4);
        parcel.writeInt(i5);
        int[] iArr3 = this.f2614g;
        m.h.C1(parcel, 6, Arrays.copyOf(iArr3, iArr3.length), false);
        int i6 = this.f2615h;
        m.h.M1(parcel, 7, 4);
        parcel.writeInt(i6);
        int[] iArr4 = this.f2616i;
        m.h.C1(parcel, 8, Arrays.copyOf(iArr4, iArr4.length), false);
        int i7 = this.f2617j;
        m.h.M1(parcel, 9, 4);
        parcel.writeInt(i7);
        int[] iArr5 = this.f2618k;
        m.h.C1(parcel, 10, Arrays.copyOf(iArr5, iArr5.length), false);
        m.h.N1(parcel, I1);
    }
}
