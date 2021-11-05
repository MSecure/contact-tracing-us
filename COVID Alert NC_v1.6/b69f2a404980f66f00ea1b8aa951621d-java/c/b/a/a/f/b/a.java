package c.b.a.a.f.b;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import b.b.k.i;
import c.b.a.a.c.k.e;
import c.b.a.a.c.k.o.l0;
import c.b.a.a.c.k.o.m0;
import c.b.a.a.c.l.b;
import c.b.a.a.c.l.c;
import c.b.a.a.c.l.g;
import c.b.a.a.c.l.p;
import c.b.a.a.f.f;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public class a extends g<f> implements f {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f2831a;

    /* renamed from: b  reason: collision with root package name */
    public final c f2832b;

    /* renamed from: c  reason: collision with root package name */
    public final Bundle f2833c;

    /* renamed from: d  reason: collision with root package name */
    public Integer f2834d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Context context, Looper looper, c cVar, e.a aVar, e.b bVar) {
        super(context, looper, 44, cVar, aVar, bVar);
        c.b.a.a.f.a aVar2 = cVar.g;
        Integer num = cVar.h;
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", cVar.f2431a);
        if (num != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", num.intValue());
        }
        if (aVar2 != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", aVar2.f2826a);
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", aVar2.f2827b);
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", aVar2.f2828c);
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", aVar2.f2829d);
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", aVar2.f2830e);
            bundle.putString("com.google.android.gms.signin.internal.logSessionId", aVar2.f);
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", aVar2.g);
            Long l = aVar2.h;
            if (l != null) {
                bundle.putLong("com.google.android.gms.signin.internal.authApiSignInModuleVersion", l.longValue());
            }
            Long l2 = aVar2.i;
            if (l2 != null) {
                bundle.putLong("com.google.android.gms.signin.internal.realClientLibraryVersion", l2.longValue());
            }
        }
        this.f2831a = true;
        this.f2832b = cVar;
        this.f2833c = bundle;
        this.f2834d = cVar.h;
    }

    @Override // c.b.a.a.f.f
    public final void a() {
        connect(new b.d());
    }

    @Override // c.b.a.a.f.f
    public final void b(d dVar) {
        i.j.t(dVar, "Expecting a valid ISignInCallbacks");
        try {
            Account account = this.f2832b.f2431a;
            if (account == null) {
                account = new Account(b.DEFAULT_ACCOUNT, "com.google");
            }
            GoogleSignInAccount googleSignInAccount = null;
            if (b.DEFAULT_ACCOUNT.equals(account.name)) {
                googleSignInAccount = c.b.a.a.a.a.a.a.a.a(getContext()).b();
            }
            ((f) getService()).K(new l(new p(account, this.f2834d.intValue(), googleSignInAccount)), dVar);
        } catch (RemoteException e2) {
            try {
                l0 l0Var = (l0) dVar;
                l0Var.f2382b.post(new m0(l0Var, new n()));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e2);
            }
        }
    }

    @Override // c.b.a.a.c.l.b
    public /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return queryLocalInterface instanceof f ? (f) queryLocalInterface : new i(iBinder);
    }

    @Override // c.b.a.a.c.l.b
    public Bundle getGetServiceRequestExtraArgs() {
        if (!getContext().getPackageName().equals(this.f2832b.f2435e)) {
            this.f2833c.putString("com.google.android.gms.signin.internal.realClientPackageName", this.f2832b.f2435e);
        }
        return this.f2833c;
    }

    @Override // c.b.a.a.c.l.g, c.b.a.a.c.l.b, c.b.a.a.c.k.a.f
    public int getMinApkVersion() {
        return c.b.a.a.c.g.f2295a;
    }

    @Override // c.b.a.a.c.l.b
    public String getServiceDescriptor() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // c.b.a.a.c.l.b
    public String getStartServiceAction() {
        return "com.google.android.gms.signin.service.START";
    }

    @Override // c.b.a.a.c.l.b, c.b.a.a.c.k.a.f
    public boolean requiresSignIn() {
        return this.f2831a;
    }
}
