package c.b.a.a.f.b;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.k.i;
import c.b.a.a.c.l.s.a;
import com.google.android.gms.common.api.Status;
import java.util.List;

public final class h extends a implements i {
    public static final Parcelable.Creator<h> CREATOR = new j();

    /* renamed from: b  reason: collision with root package name */
    public final List<String> f2838b;

    /* renamed from: c  reason: collision with root package name */
    public final String f2839c;

    public h(List<String> list, String str) {
        this.f2838b = list;
        this.f2839c = str;
    }

    @Override // c.b.a.a.c.k.i
    public final Status getStatus() {
        return this.f2839c != null ? Status.f : Status.i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        List<String> list = this.f2838b;
        if (list != null) {
            int C1 = i.j.C1(parcel, 1);
            parcel.writeStringList(list);
            i.j.F1(parcel, C1);
        }
        i.j.z1(parcel, 2, this.f2839c, false);
        i.j.F1(parcel, e2);
    }
}
