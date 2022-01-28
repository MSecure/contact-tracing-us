package c.b.a.a.i.b;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import b.x.t;
import c.b.a.a.d.g;
import c.b.a.a.d.k.e;
import c.b.a.a.d.k.o.i0;
import c.b.a.a.d.k.o.j0;
import c.b.a.a.d.m.b;
import c.b.a.a.d.m.c;
import c.b.a.a.d.m.f;
import c.b.a.a.d.m.w;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public class a extends f<f> implements c.b.a.a.i.f {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f4083a;

    /* renamed from: b  reason: collision with root package name */
    public final c f4084b;

    /* renamed from: c  reason: collision with root package name */
    public final Bundle f4085c;

    /* renamed from: d  reason: collision with root package name */
    public final Integer f4086d;

    public a(@RecentlyNonNull Context context, @RecentlyNonNull Looper looper, @RecentlyNonNull boolean z, @RecentlyNonNull c cVar, @RecentlyNonNull Bundle bundle, @RecentlyNonNull e.a aVar, @RecentlyNonNull e.b bVar) {
        super(context, looper, 44, cVar, aVar, bVar);
        this.f4083a = z;
        this.f4084b = cVar;
        this.f4085c = bundle;
        this.f4086d = cVar.h;
    }

    @Override // c.b.a.a.i.f
    public final void a(d dVar) {
        t.D(dVar, "Expecting a valid ISignInCallbacks");
        try {
            Account account = this.f4084b.f3086a;
            if (account == null) {
                account = new Account(b.DEFAULT_ACCOUNT, "com.google");
            }
            GoogleSignInAccount googleSignInAccount = null;
            if (b.DEFAULT_ACCOUNT.equals(account.name)) {
                googleSignInAccount = c.b.a.a.a.a.a.a.a.a(getContext()).b();
            }
            Integer num = this.f4086d;
            t.C(num);
            ((f) getService()).H(new l(new w(account, num.intValue(), googleSignInAccount)), dVar);
        } catch (RemoteException e2) {
            try {
                i0 i0Var = (i0) dVar;
                i0Var.f3003b.post(new j0(i0Var, new n()));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e2);
            }
        }
    }

    @Override // c.b.a.a.i.f
    public final void b() {
        connect(new b.d());
    }

    @Override // c.b.a.a.d.m.b
    @RecentlyNonNull
    public /* synthetic */ IInterface createServiceInterface(@RecentlyNonNull IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return queryLocalInterface instanceof f ? (f) queryLocalInterface : new i(iBinder);
    }

    @Override // c.b.a.a.d.m.b
    @RecentlyNonNull
    public Bundle getGetServiceRequestExtraArgs() {
        if (!getContext().getPackageName().equals(this.f4084b.f3090e)) {
            this.f4085c.putString("com.google.android.gms.signin.internal.realClientPackageName", this.f4084b.f3090e);
        }
        return this.f4085c;
    }

    @Override // c.b.a.a.d.m.b, c.b.a.a.d.k.a.f
    @RecentlyNonNull
    public int getMinApkVersion() {
        return g.f2932a;
    }

    @Override // c.b.a.a.d.m.b
    @RecentlyNonNull
    public String getServiceDescriptor() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // c.b.a.a.d.m.b
    @RecentlyNonNull
    public String getStartServiceAction() {
        return "com.google.android.gms.signin.service.START";
    }

    @Override // c.b.a.a.d.m.b, c.b.a.a.d.k.a.f
    @RecentlyNonNull
    public boolean requiresSignIn() {
        return this.f4083a;
    }
}
