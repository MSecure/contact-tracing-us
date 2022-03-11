package f.b.a.c.b.m;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.annotation.RecentlyNonNull;
import f.b.a.c.e.b.b;
import f.b.a.c.e.b.c;
/* loaded from: classes.dex */
public interface h extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class a extends f.b.a.c.e.b.a implements h {

        /* renamed from: f.b.a.c.b.m.h$a$a */
        /* loaded from: classes.dex */
        public static class C0087a extends b implements h {
            public C0087a(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
            }

            @Override // f.b.a.c.b.m.h
            public final Account a() {
                Parcel z = z(2, p());
                Account account = (Account) c.a(z, Account.CREATOR);
                z.recycle();
                return account;
            }
        }

        @RecentlyNonNull
        public static h z(@RecentlyNonNull IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            return queryLocalInterface instanceof h ? (h) queryLocalInterface : new C0087a(iBinder);
        }
    }

    @RecentlyNonNull
    Account a();
}
