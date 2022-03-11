package f.b.a.c.b.m;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.annotation.RecentlyNonNull;
import f.b.a.c.e.b.b;
import f.b.a.c.e.b.c;

public interface h extends IInterface {

    public static abstract class a extends f.b.a.c.e.b.a implements h {

        /* renamed from: f.b.a.c.b.m.h$a$a  reason: collision with other inner class name */
        public static class C0085a extends b implements h {
            public C0085a(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
            }

            @Override // f.b.a.c.b.m.h
            public final Account e() {
                Parcel n = n(2, l());
                Account account = (Account) c.a(n, Account.CREATOR);
                n.recycle();
                return account;
            }
        }

        @RecentlyNonNull
        public static h n(@RecentlyNonNull IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            return queryLocalInterface instanceof h ? (h) queryLocalInterface : new C0085a(iBinder);
        }
    }

    @RecentlyNonNull
    Account e();
}
