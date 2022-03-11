package f.b.a.f.a.b;

import android.app.NotificationManager;
import android.content.Context;
import f.b.a.f.a.e.a;
import f.b.a.f.a.e.i0;
/* loaded from: classes.dex */
public final class w extends i0 {
    public final a a = new a("AssetPackExtractionService");
    public final Context b;
    public final d0 c;

    /* renamed from: d */
    public final i3 f3328d;

    /* renamed from: e */
    public final x0 f3329e;

    /* renamed from: f */
    public final NotificationManager f3330f;

    public w(Context context, d0 d0Var, i3 i3Var, x0 x0Var) {
        this.b = context;
        this.c = d0Var;
        this.f3328d = i3Var;
        this.f3329e = x0Var;
        this.f3330f = (NotificationManager) context.getSystemService("notification");
    }
}
