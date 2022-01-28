package c.b.a.a.g.b;

import android.os.Parcel;
import c.b.a.a.c.d;
import c.b.a.a.c.f;
import c.b.a.a.d.k.i;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

public abstract class b5 extends w implements a5 {
    public b5() {
        super("com.google.android.gms.clearcut.internal.IClearcutLoggerCallbacks");
    }

    @Override // c.b.a.a.g.b.w
    public final boolean e0(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                ((y4) this).f3480a.setResult((i) ((Status) s0.a(parcel, Status.CREATOR)));
                return true;
            case 2:
                Status status = (Status) s0.a(parcel, Status.CREATOR);
                throw new UnsupportedOperationException();
            case 3:
                Status status2 = (Status) s0.a(parcel, Status.CREATOR);
                parcel.readLong();
                throw new UnsupportedOperationException();
            case 4:
                Status status3 = (Status) s0.a(parcel, Status.CREATOR);
                throw new UnsupportedOperationException();
            case 5:
                Status status4 = (Status) s0.a(parcel, Status.CREATOR);
                parcel.readLong();
                throw new UnsupportedOperationException();
            case 6:
                Status status5 = (Status) s0.a(parcel, Status.CREATOR);
                f[] fVarArr = (f[]) parcel.createTypedArray(f.CREATOR);
                throw new UnsupportedOperationException();
            case 7:
                DataHolder dataHolder = (DataHolder) s0.a(parcel, DataHolder.CREATOR);
                throw new UnsupportedOperationException();
            case 8:
                Status status6 = (Status) s0.a(parcel, Status.CREATOR);
                d dVar = (d) s0.a(parcel, d.CREATOR);
                throw new UnsupportedOperationException();
            case 9:
                Status status7 = (Status) s0.a(parcel, Status.CREATOR);
                d dVar2 = (d) s0.a(parcel, d.CREATOR);
                throw new UnsupportedOperationException();
            default:
                return false;
        }
    }
}
