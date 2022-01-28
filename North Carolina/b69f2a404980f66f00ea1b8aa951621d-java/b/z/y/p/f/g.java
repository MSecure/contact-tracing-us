package b.z.y.p.f;

import android.content.Context;
import b.z.y.s.s.a;

public class g {

    /* renamed from: e  reason: collision with root package name */
    public static g f2051e;

    /* renamed from: a  reason: collision with root package name */
    public a f2052a;

    /* renamed from: b  reason: collision with root package name */
    public b f2053b;

    /* renamed from: c  reason: collision with root package name */
    public e f2054c;

    /* renamed from: d  reason: collision with root package name */
    public f f2055d;

    public g(Context context, a aVar) {
        Context applicationContext = context.getApplicationContext();
        this.f2052a = new a(applicationContext, aVar);
        this.f2053b = new b(applicationContext, aVar);
        this.f2054c = new e(applicationContext, aVar);
        this.f2055d = new f(applicationContext, aVar);
    }

    public static synchronized g a(Context context, a aVar) {
        g gVar;
        synchronized (g.class) {
            if (f2051e == null) {
                f2051e = new g(context, aVar);
            }
            gVar = f2051e;
        }
        return gVar;
    }
}
