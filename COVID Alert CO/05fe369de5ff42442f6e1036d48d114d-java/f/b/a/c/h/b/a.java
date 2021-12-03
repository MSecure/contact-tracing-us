package f.b.a.c.h.b;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import e.b.a.m;
import f.b.a.c.b.l.d;
import f.b.a.c.b.l.e;
import f.b.a.c.b.m.b;
import f.b.a.c.b.m.c;
import f.b.a.c.b.m.f;
import f.b.a.c.b.m.u;
import java.util.Objects;

public class a extends f<f> implements f.b.a.c.h.f {
    public final Bundle A;
    public final Integer B;
    public final boolean y;
    public final c z;

    public a(@RecentlyNonNull Context context, @RecentlyNonNull Looper looper, @RecentlyNonNull boolean z2, @RecentlyNonNull c cVar, @RecentlyNonNull Bundle bundle, @RecentlyNonNull d dVar, @RecentlyNonNull e eVar) {
        super(context, looper, 44, cVar, dVar, eVar);
        this.y = z2;
        this.z = cVar;
        this.A = bundle;
        this.B = cVar.f2629h;
    }

    @Override // f.b.a.c.b.l.a.e, f.b.a.c.b.m.b
    @RecentlyNonNull
    public boolean l() {
        return this.y;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r6 = (f.b.a.c.b.l.l.x) r6;
        r6.b.post(new f.b.a.c.b.l.l.y(r6, new f.b.a.c.h.b.n()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0047 */
    @Override // f.b.a.c.h.f
    public final void m(d dVar) {
        m.h.p(dVar, "Expecting a valid ISignInCallbacks");
        Account account = this.z.a;
        if (account == null) {
            account = new Account("<<default account>>", "com.google");
        }
        GoogleSignInAccount googleSignInAccount = null;
        if ("<<default account>>".equals(account.name)) {
            googleSignInAccount = f.b.a.c.a.a.a.a.a.a(this.c).b();
        }
        Integer num = this.B;
        Objects.requireNonNull(num, "null reference");
        ((f) t()).u(new l(new u(account, num.intValue(), googleSignInAccount)), dVar);
    }

    @Override // f.b.a.c.h.f
    public final void n() {
        b.d dVar = new b.d();
        m.h.p(dVar, "Connection progress callbacks cannot be null.");
        this.f2615i = dVar;
        B(2, null);
    }

    @Override // f.b.a.c.b.l.a.e, f.b.a.c.b.m.b
    @RecentlyNonNull
    public int p() {
        return 12451000;
    }

    @Override // f.b.a.c.b.m.b
    @RecentlyNonNull
    public /* synthetic */ IInterface q(@RecentlyNonNull IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return queryLocalInterface instanceof f ? (f) queryLocalInterface : new i(iBinder);
    }

    @Override // f.b.a.c.b.m.b
    @RecentlyNonNull
    public Bundle s() {
        if (!this.c.getPackageName().equals(this.z.f2626e)) {
            this.A.putString("com.google.android.gms.signin.internal.realClientPackageName", this.z.f2626e);
        }
        return this.A;
    }

    @Override // f.b.a.c.b.m.b
    @RecentlyNonNull
    public String u() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // f.b.a.c.b.m.b
    @RecentlyNonNull
    public String v() {
        return "com.google.android.gms.signin.service.START";
    }
}
