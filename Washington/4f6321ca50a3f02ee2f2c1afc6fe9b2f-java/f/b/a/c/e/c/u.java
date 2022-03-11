package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public class u implements IInterface {
    public final IBinder a;
    public final String b;

    public u(IBinder iBinder, String str) {
        this.a = iBinder;
        this.b = str;
    }

    public IBinder asBinder() {
        return this.a;
    }

    public final Parcel l() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.b);
        return obtain;
    }

    public final void n(int i2, Parcel parcel) {
        try {
            this.a.transact(i2, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
