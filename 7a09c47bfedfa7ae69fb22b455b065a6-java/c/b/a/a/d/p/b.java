package c.b.a.a.d.p;

import android.content.Context;
import androidx.annotation.RecentlyNonNull;

public class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f3181b = new b();

    /* renamed from: a  reason: collision with root package name */
    public a f3182a = null;

    @RecentlyNonNull
    public static a a(@RecentlyNonNull Context context) {
        a aVar;
        b bVar = f3181b;
        synchronized (bVar) {
            if (bVar.f3182a == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                bVar.f3182a = new a(context);
            }
            aVar = bVar.f3182a;
        }
        return aVar;
    }
}
