package f.b.a.c.h.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import e.b.a.m;
import f.b.a.c.b.l.i;
import f.b.a.c.b.m.n.a;
import java.util.List;

public final class h extends a implements i {
    public static final Parcelable.Creator<h> CREATOR = new j();
    public final List<String> b;
    public final String c;

    public h(List<String> list, String str) {
        this.b = list;
        this.c = str;
    }

    @Override // f.b.a.c.b.l.i
    public final Status getStatus() {
        return this.c != null ? Status.f408g : Status.f410i;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int I1 = m.h.I1(parcel, 20293);
        List<String> list = this.b;
        if (list != null) {
            int I12 = m.h.I1(parcel, 1);
            parcel.writeStringList(list);
            m.h.N1(parcel, I12);
        }
        m.h.F1(parcel, 2, this.c, false);
        m.h.N1(parcel, I1);
    }
}
