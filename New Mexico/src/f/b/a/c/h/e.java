package f.b.a.c.h;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import f.b.a.c.b.l.a;
import f.b.a.c.b.l.d;
import f.b.a.c.b.m.c;
/*  JADX ERROR: UnsupportedOperationException in pass: OverrideMethodVisitor
    java.lang.UnsupportedOperationException
    	at jadx.core.utils.ImmutableList.listIterator(ImmutableList.java:198)
    	at java.util.AbstractList.equals(AbstractList.java:519)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.fixMethodArgTypes(OverrideMethodVisitor.java:297)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.processMth(OverrideMethodVisitor.java:71)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.processCls(OverrideMethodVisitor.java:56)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.visit(OverrideMethodVisitor.java:48)
    */
/* loaded from: classes.dex */
public final class e extends a.AbstractC0082a<f.b.a.c.h.b.a, a> {
    @Override // f.b.a.c.b.l.a.AbstractC0082a
    public final f.b.a.c.h.b.a a(Context context, Looper looper, c cVar, Object obj, d dVar, f.b.a.c.b.l.e eVar) {
        a aVar = (a) obj;
        a aVar2 = cVar.f2723g;
        Integer num = cVar.f2724h;
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
