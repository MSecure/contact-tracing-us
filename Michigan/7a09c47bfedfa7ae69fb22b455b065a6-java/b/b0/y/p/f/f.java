package b.b0.y.p.f;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import b.b0.m;
import b.b0.y.s.s.a;

public class f extends c<Boolean> {
    public static final String i = m.e("StorageNotLowTracker");

    public f(Context context, a aVar) {
        super(context, aVar);
    }

    @Override // b.b0.y.p.f.d
    public Object a() {
        Context context = this.f1183b;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
        Intent registerReceiver = context.registerReceiver(null, intentFilter);
        if (!(registerReceiver == null || registerReceiver.getAction() == null)) {
            String action = registerReceiver.getAction();
            char c2 = 65535;
            int hashCode = action.hashCode();
            if (hashCode != -1181163412) {
                if (hashCode == -730838620 && action.equals("android.intent.action.DEVICE_STORAGE_OK")) {
                    c2 = 0;
                }
            } else if (action.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
                c2 = 1;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    return null;
                }
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    @Override // b.b0.y.p.f.c
    public IntentFilter f() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
        return intentFilter;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003c, code lost:
        if (r6.equals("android.intent.action.DEVICE_STORAGE_OK") == false) goto L_0x0049;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0052  */
    @Override // b.b0.y.p.f.c
    public void g(Context context, Intent intent) {
        Boolean bool;
        if (intent.getAction() != null) {
            boolean z = false;
            m.c().a(i, String.format("Received %s", intent.getAction()), new Throwable[0]);
            String action = intent.getAction();
            int hashCode = action.hashCode();
            if (hashCode != -1181163412) {
                if (hashCode == -730838620) {
                }
            } else if (action.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
                z = true;
                if (z) {
                    bool = Boolean.TRUE;
                } else if (z) {
                    bool = Boolean.FALSE;
                } else {
                    return;
                }
                c(bool);
            }
            z = true;
            if (z) {
            }
            c(bool);
        }
    }
}
