package c.b.a.a.g.d;

import android.os.IInterface;
import android.os.Parcel;

public class b {
    static {
        b.class.getClassLoader();
    }

    public static void a(Parcel parcel, boolean z) {
        parcel.writeInt(z ? 1 : 0);
    }

    public static void b(Parcel parcel, IInterface iInterface) {
        parcel.writeStrongBinder(iInterface == null ? null : iInterface.asBinder());
    }

    public static boolean c(Parcel parcel) {
        return parcel.readInt() != 0;
    }
}
