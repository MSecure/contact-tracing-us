package c.b.a.a.i;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import c.b.a.a.d.k.a;
import c.b.a.a.d.k.e;
import c.b.a.a.d.m.c;

public final class e extends a.AbstractC0062a<c.b.a.a.i.b.a, a> {
    /* Return type fixed from 'c.b.a.a.d.k.a$f' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, android.os.Looper, c.b.a.a.d.m.c, java.lang.Object, c.b.a.a.d.k.e$a, c.b.a.a.d.k.e$b] */
    @Override // c.b.a.a.d.k.a.AbstractC0062a
    public final c.b.a.a.i.b.a buildClient(Context context, Looper looper, c cVar, a aVar, e.a aVar2, e.b bVar) {
        a aVar3 = cVar.f3092g;
        Integer num = cVar.h;
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", cVar.f3086a);
        if (num != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", num.intValue());
        }
        if (aVar3 != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", null);
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", null);
            bundle.putString("com.google.android.gms.signin.internal.logSessionId", null);
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
        }
        return new c.b.a.a.i.b.a(context, looper, true, cVar, bundle, aVar2, bVar);
    }
}
