package b.b0.y.p.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import b.b0.m;

public abstract class c<T> extends d<T> {
    public static final String h = m.e("BrdcstRcvrCnstrntTrckr");

    /* renamed from: g  reason: collision with root package name */
    public final BroadcastReceiver f1179g = new a();

    public class a extends BroadcastReceiver {
        public a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                c.this.g(context, intent);
            }
        }
    }

    public c(Context context, b.b0.y.s.s.a aVar) {
        super(context, aVar);
    }

    @Override // b.b0.y.p.f.d
    public void d() {
        m.c().a(h, String.format("%s: registering receiver", getClass().getSimpleName()), new Throwable[0]);
        this.f1183b.registerReceiver(this.f1179g, f());
    }

    @Override // b.b0.y.p.f.d
    public void e() {
        m.c().a(h, String.format("%s: unregistering receiver", getClass().getSimpleName()), new Throwable[0]);
        this.f1183b.unregisterReceiver(this.f1179g);
    }

    public abstract IntentFilter f();

    public abstract void g(Context context, Intent intent);
}
