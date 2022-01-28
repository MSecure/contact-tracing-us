package androidx.work.impl.diagnostics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.workers.DiagnosticsWorker;
import b.z.m;
import b.z.o;
import b.z.y.k;

public class DiagnosticsReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static final String f338a = m.e("DiagnosticsRcvr");

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            m.c().a(f338a, "Requesting diagnostics", new Throwable[0]);
            try {
                k.b(context).a((o) new o.a(DiagnosticsWorker.class).a());
            } catch (IllegalStateException e2) {
                m.c().b(f338a, "WorkManager is not initialized", e2);
            }
        }
    }
}
