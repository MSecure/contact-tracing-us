package c.b.a.a.g.e;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.k.o.h;
import c.b.a.a.d.m.o.a;
import com.google.android.gms.nearby.exposurenotification.ExposureConfiguration;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;
import java.util.Arrays;
import java.util.List;

public final class a3 extends a {
    public static final Parcelable.Creator<a3> CREATOR = new b3();

    /* renamed from: b  reason: collision with root package name */
    public List<TemporaryExposureKey> f3494b;

    /* renamed from: c  reason: collision with root package name */
    public h f3495c;

    /* renamed from: d  reason: collision with root package name */
    public List<ParcelFileDescriptor> f3496d;

    /* renamed from: e  reason: collision with root package name */
    public ExposureConfiguration f3497e;

    /* renamed from: f  reason: collision with root package name */
    public String f3498f;

    /* renamed from: g  reason: collision with root package name */
    public m1 f3499g;

    public a3() {
    }

    public a3(z2 z2Var) {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a3) {
            a3 a3Var = (a3) obj;
            return t.j1(this.f3494b, a3Var.f3494b) && t.j1(this.f3495c, a3Var.f3495c) && t.j1(this.f3496d, a3Var.f3496d) && t.j1(this.f3497e, a3Var.f3497e) && t.j1(this.f3498f, a3Var.f3498f) && t.j1(this.f3499g, a3Var.f3499g);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3494b, this.f3495c, this.f3496d, this.f3497e, this.f3498f, this.f3499g});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        t.z3(parcel, 1, this.f3494b, false);
        t.p3(parcel, 2, this.f3495c.asBinder(), false);
        t.z3(parcel, 3, this.f3496d, false);
        t.v3(parcel, 4, this.f3497e, i, false);
        t.w3(parcel, 5, this.f3498f, false);
        m1 m1Var = this.f3499g;
        t.p3(parcel, 6, m1Var == null ? null : m1Var.asBinder(), false);
        t.w4(parcel, m);
    }

    public a3(List<TemporaryExposureKey> list, IBinder iBinder, List<ParcelFileDescriptor> list2, ExposureConfiguration exposureConfiguration, String str, IBinder iBinder2) {
        m1 m1Var;
        h f0 = h.a.f0(iBinder);
        if (iBinder2 == null) {
            m1Var = null;
        } else {
            IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IDiagnosisKeyFileSupplier");
            m1Var = queryLocalInterface instanceof m1 ? (m1) queryLocalInterface : new o1(iBinder2);
        }
        this.f3494b = list;
        this.f3495c = f0;
        this.f3496d = list2;
        this.f3497e = exposureConfiguration;
        this.f3498f = str;
        this.f3499g = m1Var;
    }
}
