package c.b.a.a.c;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.c.a;
import c.b.a.a.d.m.o.a;
import c.b.a.a.g.b.g5;
import c.b.a.a.g.b.w4;
import java.util.Arrays;

public final class f extends a {
    public static final Parcelable.Creator<f> CREATOR = new g();

    /* renamed from: b  reason: collision with root package name */
    public g5 f2910b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f2911c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f2912d;

    /* renamed from: e  reason: collision with root package name */
    public String[] f2913e;

    /* renamed from: f  reason: collision with root package name */
    public int[] f2914f;

    /* renamed from: g  reason: collision with root package name */
    public byte[][] f2915g;
    public c.b.a.a.h.a[] h;
    public boolean i;
    public final w4 j;
    public final a.c k;
    public final a.c l;

    public f(g5 g5Var, w4 w4Var, a.c cVar, int[] iArr, int[] iArr2, boolean z) {
        this.f2910b = g5Var;
        this.j = w4Var;
        this.k = null;
        this.l = null;
        this.f2912d = null;
        this.f2913e = null;
        this.f2914f = null;
        this.f2915g = null;
        this.h = null;
        this.i = z;
    }

    public f(g5 g5Var, byte[] bArr, int[] iArr, String[] strArr, int[] iArr2, byte[][] bArr2, boolean z, c.b.a.a.h.a[] aVarArr) {
        this.f2910b = g5Var;
        this.f2911c = bArr;
        this.f2912d = iArr;
        this.f2913e = strArr;
        this.j = null;
        this.k = null;
        this.l = null;
        this.f2914f = iArr2;
        this.f2915g = bArr2;
        this.h = aVarArr;
        this.i = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            return t.j1(this.f2910b, fVar.f2910b) && Arrays.equals(this.f2911c, fVar.f2911c) && Arrays.equals(this.f2912d, fVar.f2912d) && Arrays.equals(this.f2913e, fVar.f2913e) && t.j1(this.j, fVar.j) && t.j1(this.k, fVar.k) && t.j1(this.l, fVar.l) && Arrays.equals(this.f2914f, fVar.f2914f) && Arrays.deepEquals(this.f2915g, fVar.f2915g) && Arrays.equals(this.h, fVar.h) && this.i == fVar.i;
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2910b, this.f2911c, this.f2912d, this.f2913e, this.j, this.k, this.l, this.f2914f, this.f2915g, this.h, Boolean.valueOf(this.i)});
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("LogEventParcelable[");
        sb.append(this.f2910b);
        sb.append(", LogEventBytes: ");
        sb.append(this.f2911c == null ? null : new String(this.f2911c));
        sb.append(", TestCodes: ");
        sb.append(Arrays.toString(this.f2912d));
        sb.append(", MendelPackages: ");
        sb.append(Arrays.toString(this.f2913e));
        sb.append(", LogEvent: ");
        sb.append(this.j);
        sb.append(", ExtensionProducer: ");
        sb.append(this.k);
        sb.append(", VeProducer: ");
        sb.append(this.l);
        sb.append(", ExperimentIDs: ");
        sb.append(Arrays.toString(this.f2914f));
        sb.append(", ExperimentTokens: ");
        sb.append(Arrays.toString(this.f2915g));
        sb.append(", ExperimentTokensParcelables: ");
        sb.append(Arrays.toString(this.h));
        sb.append(", AddPhenotypeExperimentTokens: ");
        sb.append(this.i);
        sb.append("]");
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int m = t.m(parcel);
        t.v3(parcel, 2, this.f2910b, i2, false);
        t.l3(parcel, 3, this.f2911c, false);
        t.r3(parcel, 4, this.f2912d, false);
        t.x3(parcel, 5, this.f2913e, false);
        t.r3(parcel, 6, this.f2914f, false);
        t.m3(parcel, 7, this.f2915g, false);
        t.j3(parcel, 8, this.i);
        t.y3(parcel, 9, this.h, i2, false);
        t.w4(parcel, m);
    }
}
