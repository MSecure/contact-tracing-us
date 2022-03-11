package f.b.a.c.h;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import f.b.a.c.b.l.a;
import f.b.a.c.b.l.d;
import f.b.a.c.b.m.c;

public final class e extends a.AbstractC0083a<f.b.a.c.h.b.a, a> {
    /* Return type fixed from 'f.b.a.c.b.l.a$e' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, android.os.Looper, f.b.a.c.b.m.c, java.lang.Object, f.b.a.c.b.l.d, f.b.a.c.b.l.e] */
    @Override // f.b.a.c.b.l.a.AbstractC0083a
    public final f.b.a.c.h.b.a a(Context context, Looper looper, c cVar, a aVar, d dVar, f.b.a.c.b.l.e eVar) {
        a aVar2 = cVar.f2539g;
        Integer num = cVar.f2540h;
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", cVar.a);
        if (num != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", num.intValue());
        }
        if (aVar2 != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", null);
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", null);
            bundle.putString("com.google.android.gms.signin.internal.logSessionId", null);
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
        }
        return new f.b.a.c.h.b.a(context, looper, true, cVar, bundle, dVar, eVar);
    }
}
