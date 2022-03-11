package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.b.l.l.f;
import f.b.a.c.b.m.n.a;
import f.b.a.c.f.b.b;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class k2 extends a {
    public static final Parcelable.Creator<k2> CREATOR = new l2();
    public f b;
    public b c;

    public k2() {
    }

    public k2(IBinder iBinder, b bVar) {
        this.b = f.a.U(iBinder);
        this.c = bVar;
    }

    public /* synthetic */ k2(j2 j2Var) {
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof k2) {
            k2 k2Var = (k2) obj;
            if (m.e.X(this.b, k2Var.b) && m.e.X(this.c, k2Var.c)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.c});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int j2 = m.e.j2(parcel, 20293);
        m.e.c2(parcel, 3, this.b.asBinder(), false);
        m.e.f2(parcel, 4, this.c, i2, false);
        m.e.o2(parcel, j2);
    }
}
