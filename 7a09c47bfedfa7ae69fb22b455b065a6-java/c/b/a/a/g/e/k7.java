package c.b.a.a.g.e;

import android.os.Parcel;

public abstract class k7 extends a implements l7 {
    public k7() {
        super("com.google.android.gms.nearby.internal.connection.IPayloadListener");
    }

    @Override // c.b.a.a.g.e.a
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 2) {
            G((m8) s1.a(parcel, m8.CREATOR));
            return true;
        } else if (i != 3) {
            return false;
        } else {
            L((o8) s1.a(parcel, o8.CREATOR));
            return true;
        }
    }
}
