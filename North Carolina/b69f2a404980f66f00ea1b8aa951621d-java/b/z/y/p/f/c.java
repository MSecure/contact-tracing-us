package b.z.y.p.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import b.z.m;

public abstract class c<T> extends d<T> {
    public static final String h = m.e("BrdcstRcvrCnstrntTrckr");
    public final BroadcastReceiver g = new a();

    public class a extends BroadcastReceiver {
        public a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                c.this.g(context, intent);
            }
        }
    }

    public c(Context context, b.z.y.s.s.a aVar) {
        super(context, aVar);
    }

    @Override // b.z.y.p.f.d
    public void d() {
        m.c().a(h, String.format("%s: registering receiver", getClass().getSimpleName()), new Throwable[0]);
        this.f2043b.registerReceiver(this.g, f());
    }

    @Override // b.z.y.p.f.d
    public void e() {
        m.c().a(h, String.format("%s: unregistering receiver", getClass().getSimpleName()), new Throwable[0]);
        this.f2043b.unregisterReceiver(this.g);
    }

    public abstract IntentFilter f();

    public abstract void g(Context context, Intent intent);
}
