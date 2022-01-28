package e.b0.a0.p.b;

import android.content.Context;
import android.content.Intent;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import e.b0.a0.e;
import e.b0.a0.s.o;
import e.b0.n;

public class f implements e {
    public static final String c = n.e("SystemAlarmScheduler");
    public final Context b;

    public f(Context context) {
        this.b = context.getApplicationContext();
    }

    @Override // e.b0.a0.e
    public void b(String str) {
        Context context = this.b;
        String str2 = b.f1057e;
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_STOP_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        this.b.startService(intent);
    }

    @Override // e.b0.a0.e
    public void d(o... oVarArr) {
        for (o oVar : oVarArr) {
            n.c().a(c, String.format("Scheduling work with workSpecId %s", oVar.a), new Throwable[0]);
            this.b.startService(b.d(this.b, oVar.a));
        }
    }

    @Override // e.b0.a0.e
    public boolean f() {
        return true;
    }
}
