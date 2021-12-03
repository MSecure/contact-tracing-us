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
        return this.c != null ? Status.f452g : Status.f454i;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int O1 = m.h.O1(parcel, 20293);
        List<String> list = this.b;
        if (list != null) {
            int O12 = m.h.O1(parcel, 1);
            parcel.writeStringList(list);
            m.h.T1(parcel, O12);
        }
        m.h.L1(parcel, 2, this.c, false);
        m.h.T1(parcel, O1);
    }
}
