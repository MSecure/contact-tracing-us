package c.b.a.a.e.c;

import android.os.Parcel;

public abstract class a7 extends a implements x6 {
    public a7() {
        super("com.google.android.gms.nearby.internal.connection.IConnectionLifecycleListener");
    }

    @Override // c.b.a.a.e.c.a
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 2) {
            A((z7) s1.a(parcel, z7.CREATOR));
            return true;
        } else if (i == 3) {
            L((b8) s1.a(parcel, b8.CREATOR));
            return true;
        } else if (i == 4) {
            R((d8) s1.a(parcel, d8.CREATOR));
            return true;
        } else if (i != 5) {
            return false;
        } else {
            w((x7) s1.a(parcel, x7.CREATOR));
            return true;
        }
    }
}
