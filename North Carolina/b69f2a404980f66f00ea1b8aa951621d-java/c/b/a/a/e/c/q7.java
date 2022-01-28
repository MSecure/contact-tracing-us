package c.b.a.a.e.c;

import android.os.Parcel;

public abstract class q7 extends a implements r7 {
    public q7() {
        super("com.google.android.gms.nearby.internal.connection.IStartAdvertisingResultListener");
    }

    @Override // c.b.a.a.e.c.a
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 2) {
            return false;
        }
        V((q8) s1.a(parcel, q8.CREATOR));
        return true;
    }
}
