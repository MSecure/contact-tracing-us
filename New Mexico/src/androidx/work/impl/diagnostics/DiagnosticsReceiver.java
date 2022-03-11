package androidx.work.impl.diagnostics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.workers.DiagnosticsWorker;
import e.c0.a0.l;
import e.c0.n;
import e.c0.p;
/* loaded from: classes.dex */
public class DiagnosticsReceiver extends BroadcastReceiver {
    public static final String a = n.e("DiagnosticsRcvr");

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            n.c().a(a, "Requesting diagnostics", new Throwable[0]);
            try {
                l.h(context).c(new p.a(DiagnosticsWorker.class).a());
            } catch (IllegalStateException e2) {
                n.c().b(a, "WorkManager is not initialized", e2);
            }
        }
    }
}
