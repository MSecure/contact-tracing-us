package c.b.a.a.c.k.o;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import c.b.a.a.e.a.b;
import c.b.a.a.e.a.c;
import com.google.android.gms.common.api.Status;

public interface h extends IInterface {

    public static abstract class a extends c.b.a.a.e.a.a implements h {

        /* renamed from: c.b.a.a.c.k.o.h$a$a  reason: collision with other inner class name */
        public static class C0058a extends b implements h {
            public C0058a(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.api.internal.IStatusCallback");
            }

            @Override // c.b.a.a.c.k.o.h
            public final void l(Status status) {
                Parcel obtain = Parcel.obtain();
                obtain.writeInterfaceToken(this.f2510b);
                c.b(obtain, status);
                try {
                    this.f2509a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public a() {
            super("com.google.android.gms.common.api.internal.IStatusCallback");
        }

        public static h i0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.api.internal.IStatusCallback");
            return queryLocalInterface instanceof h ? (h) queryLocalInterface : new C0058a(iBinder);
        }

        @Override // c.b.a.a.e.a.a
        public boolean h0(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1) {
                return false;
            }
            l((Status) c.a(parcel, Status.CREATOR));
            return true;
        }
    }

    void l(Status status);
}
