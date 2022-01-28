package c.b.a.a.i.b;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.k.i;
import c.b.a.a.d.m.o.a;
import com.google.android.gms.common.api.Status;
import java.util.List;

public final class h extends a implements i {
    public static final Parcelable.Creator<h> CREATOR = new j();

    /* renamed from: b  reason: collision with root package name */
    public final List<String> f4090b;

    /* renamed from: c  reason: collision with root package name */
    public final String f4091c;

    public h(List<String> list, String str) {
        this.f4090b = list;
        this.f4091c = str;
    }

    @Override // c.b.a.a.d.k.i
    public final Status getStatus() {
        return this.f4091c != null ? Status.f5979g : Status.j;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        List<String> list = this.f4090b;
        if (list != null) {
            int N3 = t.N3(parcel, 1);
            parcel.writeStringList(list);
            t.w4(parcel, N3);
        }
        t.w3(parcel, 2, this.f4091c, false);
        t.w4(parcel, m);
    }
}
