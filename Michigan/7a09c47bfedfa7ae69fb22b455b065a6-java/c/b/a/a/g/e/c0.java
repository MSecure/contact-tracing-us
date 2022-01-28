package c.b.a.a.g.e;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;
import com.google.android.gms.nearby.exposurenotification.DailySummariesConfig;
import java.util.Arrays;

public final class c0 extends a {
    public static final Parcelable.Creator<c0> CREATOR = new g0();

    /* renamed from: b  reason: collision with root package name */
    public l1 f3522b;

    /* renamed from: c  reason: collision with root package name */
    public DailySummariesConfig f3523c;

    public c0() {
    }

    public c0(IBinder iBinder, DailySummariesConfig dailySummariesConfig) {
        l1 l1Var;
        if (iBinder == null) {
            l1Var = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IDailySummaryListCallback");
            l1Var = queryLocalInterface instanceof l1 ? (l1) queryLocalInterface : new n1(iBinder);
        }
        this.f3522b = l1Var;
        this.f3523c = dailySummariesConfig;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c0) {
            c0 c0Var = (c0) obj;
            return t.j1(this.f3522b, c0Var.f3522b) && t.j1(this.f3523c, c0Var.f3523c);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3522b, this.f3523c});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        t.p3(parcel, 1, this.f3522b.asBinder(), false);
        t.v3(parcel, 2, this.f3523c, i, false);
        t.w4(parcel, m);
    }

    public c0(e0 e0Var) {
    }
}
