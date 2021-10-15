package c.b.a.a.d.m;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.annotation.RecentlyNonNull;
import c.b.a.a.g.c.b;
import c.b.a.a.g.c.c;

public interface h extends IInterface {

    public static abstract class a extends c.b.a.a.g.c.a implements h {

        /* renamed from: c.b.a.a.d.m.h$a$a  reason: collision with other inner class name */
        public static class C0067a extends b implements h {
            public C0067a(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
            }

            @Override // c.b.a.a.d.m.h
            public final Account zza() {
                Parcel obtain = Parcel.obtain();
                obtain.writeInterfaceToken(this.f3493b);
                obtain = Parcel.obtain();
                try {
                    this.f3492a.transact(2, obtain, obtain, 0);
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

        @RecentlyNonNull
        public static h f0(@RecentlyNonNull IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            return queryLocalInterface instanceof h ? (h) queryLocalInterface : new C0067a(iBinder);
        }
    }

    @RecentlyNonNull
    Account zza();
}
