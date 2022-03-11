package e.b0.x.q.f;

import android.content.Context;
import e.b0.x.t.q.a;

public class g {

    /* renamed from: e  reason: collision with root package name */
    public static g f1100e;
    public a a;
    public b b;
    public e c;

    /* renamed from: d  reason: collision with root package name */
    public f f1101d;

    public g(Context context, a aVar) {
        Context applicationContext = context.getApplicationContext();
        this.a = new a(applicationContext, aVar);
        this.b = new b(applicationContext, aVar);
        this.c = new e(applicationContext, aVar);
        this.f1101d = new f(applicationContext, aVar);
    }

    public static synchronized g a(Context context, a aVar) {
        g gVar;
        synchronized (g.class) {
            if (f1100e == null) {
                f1100e = new g(context, aVar);
            }
            gVar = f1100e;
        }
        return gVar;
    }
}
