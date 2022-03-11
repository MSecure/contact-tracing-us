package e.c0.x.p.b;

import android.content.Context;
import android.content.Intent;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import e.c0.l;
import e.c0.x.e;
import e.c0.x.s.o;

public class f implements e {
    public static final String c = l.e("SystemAlarmScheduler");
    public final Context b;

    public f(Context context) {
        this.b = context.getApplicationContext();
    }

    @Override // e.c0.x.e
    public void b(String str) {
        Context context = this.b;
        String str2 = b.f1078e;
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_STOP_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        this.b.startService(intent);
    }

    @Override // e.c0.x.e
    public void d(o... oVarArr) {
        for (o oVar : oVarArr) {
            l.c().a(c, String.format("Scheduling work with workSpecId %s", oVar.a), new Throwable[0]);
            this.b.startService(b.d(this.b, oVar.a));
        }
    }

    @Override // e.c0.x.e
    public boolean f() {
        return true;
    }
}
