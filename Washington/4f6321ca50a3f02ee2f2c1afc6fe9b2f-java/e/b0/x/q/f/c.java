package e.b0.x.q.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import e.b0.l;

public abstract class c<T> extends d<T> {

    /* renamed from: h  reason: collision with root package name */
    public static final String f1090h = l.e("BrdcstRcvrCnstrntTrckr");

    /* renamed from: g  reason: collision with root package name */
    public final BroadcastReceiver f1091g = new a();

    public class a extends BroadcastReceiver {
        public a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                c.this.g(context, intent);
            }
        }
    }

    public c(Context context, e.b0.x.t.q.a aVar) {
        super(context, aVar);
    }

    @Override // e.b0.x.q.f.d
    public void d() {
        l.c().a(f1090h, String.format("%s: registering receiver", getClass().getSimpleName()), new Throwable[0]);
        this.b.registerReceiver(this.f1091g, f());
    }

    @Override // e.b0.x.q.f.d
    public void e() {
        l.c().a(f1090h, String.format("%s: unregistering receiver", getClass().getSimpleName()), new Throwable[0]);
        this.b.unregisterReceiver(this.f1091g);
    }

    public abstract IntentFilter f();

    public abstract void g(Context context, Intent intent);
}
