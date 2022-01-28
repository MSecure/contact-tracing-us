package c.b.a.a.d.k.o;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.annotation.RecentlyNonNull;
import c.b.a.a.g.a.b;
import c.b.a.a.g.a.c;
import com.google.android.gms.common.api.Status;

public interface h extends IInterface {

    public static abstract class a extends c.b.a.a.g.a.a implements h {

        /* renamed from: c.b.a.a.d.k.o.h$a$a  reason: collision with other inner class name */
        public static class C0065a extends b implements h {
            public C0065a(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.api.internal.IStatusCallback");
            }

            @Override // c.b.a.a.d.k.o.h
            public final void i(Status status) {
                Parcel obtain = Parcel.obtain();
                obtain.writeInterfaceToken(this.f3211b);
                c.b(obtain, status);
                try {
                    this.f3210a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public a() {
            super("com.google.android.gms.common.api.internal.IStatusCallback");
        }

        @RecentlyNonNull
        public static h f0(@RecentlyNonNull IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.api.internal.IStatusCallback");
            return queryLocalInterface instanceof h ? (h) queryLocalInterface : new C0065a(iBinder);
        }

        @Override // c.b.a.a.g.a.a
        @RecentlyNonNull
        public final boolean e0(@RecentlyNonNull int i, @RecentlyNonNull Parcel parcel, @RecentlyNonNull Parcel parcel2, @RecentlyNonNull int i2) {
            if (i != 1) {
                return false;
            }
            i((Status) c.a(parcel, Status.CREATOR));
            return true;
        }
    }

    void i(@RecentlyNonNull Status status);
}
