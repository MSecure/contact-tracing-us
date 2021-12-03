package androidx.work.impl.diagnostics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.workers.DiagnosticsWorker;
import e.b0.a0.l;
import e.b0.n;
import e.b0.p;

public class DiagnosticsReceiver extends BroadcastReceiver {
    public static final String a = n.e("DiagnosticsRcvr");

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            n.c().a(a, "Requesting diagnostics", new Throwable[0]);
            try {
                l.g(context).c((p) new p.a(DiagnosticsWorker.class).a());
            } catch (IllegalStateException e2) {
                n.c().b(a, "WorkManager is not initialized", e2);
            }
        }
    }
}
