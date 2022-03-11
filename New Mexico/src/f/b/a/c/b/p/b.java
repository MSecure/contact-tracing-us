package f.b.a.c.b.p;

import android.content.Context;
import androidx.annotation.RecentlyNonNull;
/* loaded from: classes.dex */
public class b {
    public static b b = new b();
    public a a = null;

    @RecentlyNonNull
    public static a a(@RecentlyNonNull Context context) {
        a aVar;
        b bVar = b;
        synchronized (bVar) {
            if (bVar.a == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                bVar.a = new a(context);
            }
            aVar = bVar.a;
        }
        return aVar;
    }
}
