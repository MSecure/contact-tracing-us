package e.b0.a0.r;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.impl.foreground.SystemForegroundService;
import e.b0.a0.b;
import e.b0.a0.l;
import e.b0.a0.q.d;
import e.b0.a0.s.o;
import e.b0.i;
import e.b0.n;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class c implements e.b0.a0.q.c, b {

    /* renamed from: l  reason: collision with root package name */
    public static final String f1102l = n.e("SystemFgDispatcher");
    public Context b;
    public l c;

    /* renamed from: d  reason: collision with root package name */
    public final e.b0.a0.t.t.a f1103d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f1104e = new Object();

    /* renamed from: f  reason: collision with root package name */
    public String f1105f;

    /* renamed from: g  reason: collision with root package name */
    public final Map<String, i> f1106g;

    /* renamed from: h  reason: collision with root package name */
    public final Map<String, o> f1107h;

    /* renamed from: i  reason: collision with root package name */
    public final Set<o> f1108i;

    /* renamed from: j  reason: collision with root package name */
    public final d f1109j;

    /* renamed from: k  reason: collision with root package name */
    public a f1110k;

    public interface a {
    }

    public c(Context context) {
        this.b = context;
        l g2 = l.g(this.b);
        this.c = g2;
        e.b0.a0.t.t.a aVar = g2.f1027d;
        this.f1103d = aVar;
        this.f1105f = null;
        this.f1106g = new LinkedHashMap();
        this.f1108i = new HashSet();
        this.f1107h = new HashMap();
        this.f1109j = new d(this.b, aVar, this);
        this.c.f1029f.b(this);
    }

    public static Intent b(Context context, String str, i iVar) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction("ACTION_NOTIFY");
        intent.putExtra("KEY_NOTIFICATION_ID", iVar.a);
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", iVar.b);
        intent.putExtra("KEY_NOTIFICATION", iVar.c);
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent d(Context context, String str, i iVar) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction("ACTION_START_FOREGROUND");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NOTIFICATION_ID", iVar.a);
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", iVar.b);
        intent.putExtra("KEY_NOTIFICATION", iVar.c);
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    @Override // e.b0.a0.b
    public void a(String str, boolean z) {
        Map.Entry<String, i> next;
        synchronized (this.f1104e) {
            o remove = this.f1107h.remove(str);
            if (remove != null ? this.f1108i.remove(remove) : false) {
                this.f1109j.b(this.f1108i);
            }
        }
        i remove2 = this.f1106g.remove(str);
        if (str.equals(this.f1105f) && this.f1106g.size() > 0) {
            Iterator<Map.Entry<String, i>> it = this.f1106g.entrySet().iterator();
            do {
                next = it.next();
            } while (it.hasNext());
            this.f1105f = next.getKey();
            if (this.f1110k != null) {
                i value = next.getValue();
                ((SystemForegroundService) this.f1110k).e(value.a, value.b, value.c);
                SystemForegroundService systemForegroundService = (SystemForegroundService) this.f1110k;
                systemForegroundService.c.post(new e(systemForegroundService, value.a));
            }
        }
        a aVar = this.f1110k;
        if (remove2 != null && aVar != null) {
            n.c().a(f1102l, String.format("Removing Notification (id: %s, workSpecId: %s ,notificationType: %s)", Integer.valueOf(remove2.a), str, Integer.valueOf(remove2.b)), new Throwable[0]);
            SystemForegroundService systemForegroundService2 = (SystemForegroundService) aVar;
            systemForegroundService2.c.post(new e(systemForegroundService2, remove2.a));
        }
    }

    @Override // e.b0.a0.q.c
    public void c(List<String> list) {
    }

    @Override // e.b0.a0.q.c
    public void e(List<String> list) {
        if (!list.isEmpty()) {
            for (String str : list) {
                n.c().a(f1102l, String.format("Constraints unmet for WorkSpec %s", str), new Throwable[0]);
                l lVar = this.c;
                e.b0.a0.t.t.a aVar = lVar.f1027d;
                ((e.b0.a0.t.t.b) aVar).a.execute(new e.b0.a0.t.l(lVar, str, true));
            }
        }
    }

    public final void f(Intent intent) {
        int i2 = 0;
        int intExtra = intent.getIntExtra("KEY_NOTIFICATION_ID", 0);
        int intExtra2 = intent.getIntExtra("KEY_FOREGROUND_SERVICE_TYPE", 0);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        Notification notification = (Notification) intent.getParcelableExtra("KEY_NOTIFICATION");
        n.c().a(f1102l, String.format("Notifying with (id: %s, workSpecId: %s, notificationType: %s)", Integer.valueOf(intExtra), stringExtra, Integer.valueOf(intExtra2)), new Throwable[0]);
        if (!(notification == null || this.f1110k == null)) {
            this.f1106g.put(stringExtra, new i(intExtra, notification, intExtra2));
            if (TextUtils.isEmpty(this.f1105f)) {
                this.f1105f = stringExtra;
                ((SystemForegroundService) this.f1110k).e(intExtra, intExtra2, notification);
                return;
            }
            SystemForegroundService systemForegroundService = (SystemForegroundService) this.f1110k;
            systemForegroundService.c.post(new d(systemForegroundService, intExtra, notification));
            if (intExtra2 != 0 && Build.VERSION.SDK_INT >= 29) {
                for (Map.Entry<String, i> entry : this.f1106g.entrySet()) {
                    i2 |= entry.getValue().b;
                }
                i iVar = this.f1106g.get(this.f1105f);
                if (iVar != null) {
                    ((SystemForegroundService) this.f1110k).e(iVar.a, i2, iVar.c);
                }
            }
        }
    }

    public void g() {
        this.f1110k = null;
        synchronized (this.f1104e) {
            this.f1109j.c();
        }
        this.c.f1029f.e(this);
    }
}
