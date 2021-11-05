package c.b.a.a.e.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import java.util.Arrays;

public final class d9 extends a {
    public static final Parcelable.Creator<d9> CREATOR = new i9();

    /* renamed from: b  reason: collision with root package name */
    public m7 f2552b;

    /* renamed from: c  reason: collision with root package name */
    public String[] f2553c;

    /* renamed from: d  reason: collision with root package name */
    public w8 f2554d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2555e;

    public d9() {
    }

    public d9(IBinder iBinder, String[] strArr, w8 w8Var, boolean z) {
        m7 m7Var;
        if (iBinder == null) {
            m7Var = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IResultListener");
            m7Var = queryLocalInterface instanceof m7 ? (m7) queryLocalInterface : new p7(iBinder);
        }
        this.f2552b = m7Var;
        this.f2553c = strArr;
        this.f2554d = w8Var;
        this.f2555e = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d9) {
            d9 d9Var = (d9) obj;
            return i.j.X(this.f2552b, d9Var.f2552b) && Arrays.equals(this.f2553c, d9Var.f2553c) && i.j.X(this.f2554d, d9Var.f2554d) && i.j.X(Boolean.valueOf(this.f2555e), Boolean.valueOf(d9Var.f2555e));
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2552b, Integer.valueOf(Arrays.hashCode(this.f2553c)), this.f2554d, Boolean.valueOf(this.f2555e)});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        m7 m7Var = this.f2552b;
        i.j.t1(parcel, 1, m7Var == null ? null : m7Var.asBinder(), false);
        String[] strArr = this.f2553c;
        if (strArr != null) {
            int C1 = i.j.C1(parcel, 2);
            parcel.writeStringArray(strArr);
            i.j.F1(parcel, C1);
        }
        i.j.y1(parcel, 3, this.f2554d, i, false);
        i.j.o1(parcel, 4, this.f2555e);
        i.j.F1(parcel, e2);
    }

    public d9(g9 g9Var) {
    }
}
