package c.b.a.a.e.c;

import android.os.Parcel;

public abstract class h7 extends a implements e7 {
    public h7() {
        super("com.google.android.gms.nearby.internal.connection.IDiscoveryListener");
    }

    @Override // c.b.a.a.e.c.a
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 2) {
            b0((h8) s1.a(parcel, h8.CREATOR));
            return true;
        } else if (i == 3) {
            f0((j8) s1.a(parcel, j8.CREATOR));
            return true;
        } else if (i == 4) {
            d0((s8) s1.a(parcel, s8.CREATOR));
            return true;
        } else if (i != 5) {
            return false;
        } else {
            W((f8) s1.a(parcel, f8.CREATOR));
            return true;
        }
    }
}
