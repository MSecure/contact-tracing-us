package c.b.a.a.c.o;

import android.content.Context;

public class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f2500b = new b();

    /* renamed from: a  reason: collision with root package name */
    public a f2501a = null;

    public static a a(Context context) {
        a aVar;
        b bVar = f2500b;
        synchronized (bVar) {
            if (bVar.f2501a == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                bVar.f2501a = new a(context);
            }
            aVar = bVar.f2501a;
        }
        return aVar;
    }
}
