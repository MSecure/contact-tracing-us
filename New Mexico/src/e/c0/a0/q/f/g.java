package e.c0.a0.q.f;

import android.content.Context;
import e.c0.a0.t.t.a;
/* loaded from: classes.dex */
public class g {

    /* renamed from: e */
    public static g f1178e;
    public a a;
    public b b;
    public e c;

    /* renamed from: d */
    public f f1179d;

    public g(Context context, a aVar) {
        Context applicationContext = context.getApplicationContext();
        this.a = new a(applicationContext, aVar);
        this.b = new b(applicationContext, aVar);
        this.c = new e(applicationContext, aVar);
        this.f1179d = new f(applicationContext, aVar);
    }

    public static synchronized g a(Context context, a aVar) {
        g gVar;
        synchronized (g.class) {
            if (f1178e == null) {
                f1178e = new g(context, aVar);
            }
            gVar = f1178e;
        }
        return gVar;
    }
}
