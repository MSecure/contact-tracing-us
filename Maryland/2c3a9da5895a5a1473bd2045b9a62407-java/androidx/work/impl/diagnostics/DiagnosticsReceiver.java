package androidx.work.impl.diagnostics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.workers.DiagnosticsWorker;
import e.c0.l;
import e.c0.n;

public class DiagnosticsReceiver extends BroadcastReceiver {
    public static final String a = l.e("DiagnosticsRcvr");

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            l.c().a(a, "Requesting diagnostics", new Throwable[0]);
            try {
                e.c0.x.l.d(context).a((n) new n.a(DiagnosticsWorker.class).a());
            } catch (IllegalStateException e2) {
                l.c().b(a, "WorkManager is not initialized", e2);
            }
        }
    }
}
