package c.b.a.a.c.l;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import c.b.a.a.e.b.b;
import c.b.a.a.e.b.c;

public interface j extends IInterface {

    public static abstract class a extends c.b.a.a.e.b.a implements j {

        /* renamed from: c.b.a.a.c.l.j$a$a  reason: collision with other inner class name */
        public static class C0060a extends b implements j {
            public C0060a(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
            }

            @Override // c.b.a.a.c.l.j
            public final Account b() {
                Parcel obtain = Parcel.obtain();
                obtain.writeInterfaceToken(this.f2512b);
                obtain = Parcel.obtain();
                try {
                    this.f2511a.transact(2, obtain, obtain, 0);
                    obtain.readException();
                    obtain.recycle();
                    return (Account) c.a(obtain, Account.CREATOR);
                } catch (RuntimeException e2) {
                    throw e2;
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static j d(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            return queryLocalInterface instanceof j ? (j) queryLocalInterface : new C0060a(iBinder);
        }
    }

    Account b();
}
