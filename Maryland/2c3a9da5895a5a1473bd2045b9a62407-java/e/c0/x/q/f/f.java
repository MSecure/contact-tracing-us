package e.c0.x.q.f;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import e.c0.l;
import e.c0.x.t.q.a;

public class f extends c<Boolean> {

    /* renamed from: i  reason: collision with root package name */
    public static final String f1119i = l.e("StorageNotLowTracker");

    public f(Context context, a aVar) {
        super(context, aVar);
    }

    @Override // e.c0.x.q.f.d
    public Object a() {
        Boolean bool = Boolean.TRUE;
        Context context = this.b;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
        Intent registerReceiver = context.registerReceiver(null, intentFilter);
        if (registerReceiver == null || registerReceiver.getAction() == null) {
            return bool;
        }
        String action = registerReceiver.getAction();
        action.hashCode();
        if (action.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
            return Boolean.FALSE;
        }
        if (!action.equals("android.intent.action.DEVICE_STORAGE_OK")) {
            return null;
        }
        return bool;
    }

    @Override // e.c0.x.q.f.c
    public IntentFilter f() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
        return intentFilter;
    }

    @Override // e.c0.x.q.f.c
    public void g(Context context, Intent intent) {
        Boolean bool;
        if (intent.getAction() != null) {
            l.c().a(f1119i, String.format("Received %s", intent.getAction()), new Throwable[0]);
            String action = intent.getAction();
            action.hashCode();
            if (action.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
                bool = Boolean.FALSE;
            } else if (action.equals("android.intent.action.DEVICE_STORAGE_OK")) {
                bool = Boolean.TRUE;
            } else {
                return;
            }
            c(bool);
        }
    }
}
