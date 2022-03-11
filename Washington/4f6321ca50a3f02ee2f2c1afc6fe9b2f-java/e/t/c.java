package e.t;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface c extends IInterface {

    public static abstract class a extends Binder implements c {

        /* renamed from: e.t.c$a$a  reason: collision with other inner class name */
        public static class C0052a implements c {
            public IBinder a;

            public C0052a(IBinder iBinder) {
                this.a = iBinder;
            }

            public IBinder asBinder() {
                return this.a;
            }

            @Override // e.t.c
            public void t(String[] strArr) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationCallback");
                    obtain.writeStringArray(strArr);
                    this.a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static c l(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("androidx.room.IMultiInstanceInvalidationCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof c)) ? new C0052a(iBinder) : (c) queryLocalInterface;
        }
    }

    void t(String[] strArr);
}
