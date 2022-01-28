package c.b.a.a.g.e;

import android.os.Parcel;

public abstract class a7 extends a implements x6 {
    public a7() {
        super("com.google.android.gms.nearby.internal.connection.IConnectionLifecycleListener");
    }

    @Override // c.b.a.a.g.e.a
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 2) {
            x((z7) s1.a(parcel, z7.CREATOR));
            return true;
        } else if (i == 3) {
            I((b8) s1.a(parcel, b8.CREATOR));
            return true;
        } else if (i == 4) {
            O((d8) s1.a(parcel, d8.CREATOR));
            return true;
        } else if (i != 5) {
            return false;
        } else {
            t((x7) s1.a(parcel, x7.CREATOR));
            return true;
        }
    }
}
