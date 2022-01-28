package c.b.a.a.e.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import com.google.android.gms.nearby.exposurenotification.DailySummariesConfig;
import java.util.Arrays;

public final class c0 extends a {
    public static final Parcelable.Creator<c0> CREATOR = new g0();

    /* renamed from: b  reason: collision with root package name */
    public l1 f2537b;

    /* renamed from: c  reason: collision with root package name */
    public DailySummariesConfig f2538c;

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
        this.f2537b = l1Var;
        this.f2538c = dailySummariesConfig;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c0) {
            c0 c0Var = (c0) obj;
            return i.j.X(this.f2537b, c0Var.f2537b) && i.j.X(this.f2538c, c0Var.f2538c);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2537b, this.f2538c});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.t1(parcel, 1, this.f2537b.asBinder(), false);
        i.j.y1(parcel, 2, this.f2538c, i, false);
        i.j.F1(parcel, e2);
    }

    public c0(e0 e0Var) {
    }
}
