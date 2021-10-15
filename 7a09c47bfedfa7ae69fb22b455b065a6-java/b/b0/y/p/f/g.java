package b.b0.y.p.f;

import android.content.Context;
import b.b0.y.s.s.a;

public class g {

    /* renamed from: e  reason: collision with root package name */
    public static g f1192e;

    /* renamed from: a  reason: collision with root package name */
    public a f1193a;

    /* renamed from: b  reason: collision with root package name */
    public b f1194b;

    /* renamed from: c  reason: collision with root package name */
    public e f1195c;

    /* renamed from: d  reason: collision with root package name */
    public f f1196d;

    public g(Context context, a aVar) {
        Context applicationContext = context.getApplicationContext();
        this.f1193a = new a(applicationContext, aVar);
        this.f1194b = new b(applicationContext, aVar);
        this.f1195c = new e(applicationContext, aVar);
        this.f1196d = new f(applicationContext, aVar);
    }

    public static synchronized g a(Context context, a aVar) {
        g gVar;
        synchronized (g.class) {
            if (f1192e == null) {
                f1192e = new g(context, aVar);
            }
            gVar = f1192e;
        }
        return gVar;
    }
}
