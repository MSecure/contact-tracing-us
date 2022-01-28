package c.b.a.a.g.e;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;
import java.util.Arrays;

public final class d9 extends a {
    public static final Parcelable.Creator<d9> CREATOR = new i9();

    /* renamed from: b  reason: collision with root package name */
    public m7 f3537b;

    /* renamed from: c  reason: collision with root package name */
    public String[] f3538c;

    /* renamed from: d  reason: collision with root package name */
    public w8 f3539d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3540e;

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
        this.f3537b = m7Var;
        this.f3538c = strArr;
        this.f3539d = w8Var;
        this.f3540e = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d9) {
            d9 d9Var = (d9) obj;
            return t.j1(this.f3537b, d9Var.f3537b) && Arrays.equals(this.f3538c, d9Var.f3538c) && t.j1(this.f3539d, d9Var.f3539d) && t.j1(Boolean.valueOf(this.f3540e), Boolean.valueOf(d9Var.f3540e));
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3537b, Integer.valueOf(Arrays.hashCode(this.f3538c)), this.f3539d, Boolean.valueOf(this.f3540e)});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        m7 m7Var = this.f3537b;
        t.p3(parcel, 1, m7Var == null ? null : m7Var.asBinder(), false);
        t.x3(parcel, 2, this.f3538c, false);
        t.v3(parcel, 3, this.f3539d, i, false);
        t.j3(parcel, 4, this.f3540e);
        t.w4(parcel, m);
    }

    public d9(g9 g9Var) {
    }
}
