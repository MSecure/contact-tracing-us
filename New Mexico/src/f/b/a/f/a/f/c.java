package f.b.a.f.a.f;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import f.b.a.f.a.e.a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes.dex */
public abstract class c<StateT> {
    public final a a;
    public final IntentFilter b;
    public final Context c;

    /* renamed from: d */
    public final Set<a<StateT>> f3368d = new HashSet();

    /* renamed from: e */
    public b f3369e = null;

    /* renamed from: f */
    public volatile boolean f3370f = false;

    public c(a aVar, IntentFilter intentFilter, Context context) {
        this.a = aVar;
        this.b = intentFilter;
        Context applicationContext = context.getApplicationContext();
        this.c = applicationContext != null ? applicationContext : context;
    }

    public abstract void a(Context context, Intent intent);

    public final void b() {
        b bVar;
        if ((this.f3370f || !this.f3368d.isEmpty()) && this.f3369e == null) {
            b bVar2 = new b(this);
            this.f3369e = bVar2;
            this.c.registerReceiver(bVar2, this.b);
        }
        if (!this.f3370f && this.f3368d.isEmpty() && (bVar = this.f3369e) != null) {
            this.c.unregisterReceiver(bVar);
            this.f3369e = null;
        }
    }

    public final synchronized void c(StateT statet) {
        Iterator it = new HashSet(this.f3368d).iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(statet);
        }
    }
}
