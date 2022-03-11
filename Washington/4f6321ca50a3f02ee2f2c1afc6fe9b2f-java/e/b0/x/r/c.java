package e.b0.x.r;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.impl.foreground.SystemForegroundService;
import e.b0.h;
import e.b0.l;
import e.b0.x.b;
import e.b0.x.q.d;
import e.b0.x.s.o;
import e.b0.x.t.k;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class c implements e.b0.x.q.c, b {

    /* renamed from: l  reason: collision with root package name */
    public static final String f1103l = l.e("SystemFgDispatcher");
    public Context b;
    public e.b0.x.l c;

    /* renamed from: d  reason: collision with root package name */
    public final e.b0.x.t.q.a f1104d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f1105e = new Object();

    /* renamed from: f  reason: collision with root package name */
    public String f1106f;

    /* renamed from: g  reason: collision with root package name */
    public final Map<String, h> f1107g;

    /* renamed from: h  reason: collision with root package name */
    public final Map<String, o> f1108h;

    /* renamed from: i  reason: collision with root package name */
    public final Set<o> f1109i;

    /* renamed from: j  reason: collision with root package name */
    public final d f1110j;

    /* renamed from: k  reason: collision with root package name */
    public a f1111k;

    public interface a {
    }

    public c(Context context) {
        this.b = context;
        e.b0.x.l d2 = e.b0.x.l.d(this.b);
        this.c = d2;
        e.b0.x.t.q.a aVar = d2.f1028d;
        this.f1104d = aVar;
        this.f1106f = null;
        this.f1107g = new LinkedHashMap();
        this.f1109i = new HashSet();
        this.f1108h = new HashMap();
        this.f1110j = new d(this.b, aVar, this);
        this.c.f1030f.b(this);
    }

    @Override // e.b0.x.b
    public void a(String str, boolean z) {
        Map.Entry<String, h> next;
        synchronized (this.f1105e) {
            o remove = this.f1108h.remove(str);
            if (remove != null ? this.f1109i.remove(remove) : false) {
                this.f1110j.b(this.f1109i);
            }
        }
        h remove2 = this.f1107g.remove(str);
        if (str.equals(this.f1106f) && this.f1107g.size() > 0) {
            Iterator<Map.Entry<String, h>> it = this.f1107g.entrySet().iterator();
            do {
                next = it.next();
            } while (it.hasNext());
            this.f1106f = next.getKey();
            if (this.f1111k != null) {
                h value = next.getValue();
                ((SystemForegroundService) this.f1111k).e(value.a, value.b, value.c);
                SystemForegroundService systemForegroundService = (SystemForegroundService) this.f1111k;
                systemForegroundService.c.post(new e(systemForegroundService, value.a));
            }
        }
        if (remove2 != null && this.f1111k != null) {
            l.c().a(f1103l, String.format("Removing Notification (id: %s, workSpecId: %s ,notificationType: %s)", Integer.valueOf(remove2.a), str, Integer.valueOf(remove2.b)), new Throwable[0]);
            SystemForegroundService systemForegroundService2 = (SystemForegroundService) this.f1111k;
            systemForegroundService2.c.post(new e(systemForegroundService2, remove2.a));
        }
    }

    public final void b(Intent intent) {
        int i2 = 0;
        int intExtra = intent.getIntExtra("KEY_NOTIFICATION_ID", 0);
        int intExtra2 = intent.getIntExtra("KEY_FOREGROUND_SERVICE_TYPE", 0);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        Notification notification = (Notification) intent.getParcelableExtra("KEY_NOTIFICATION");
        l.c().a(f1103l, String.format("Notifying with (id: %s, workSpecId: %s, notificationType: %s)", Integer.valueOf(intExtra), stringExtra, Integer.valueOf(intExtra2)), new Throwable[0]);
        if (!(notification == null || this.f1111k == null)) {
            this.f1107g.put(stringExtra, new h(intExtra, notification, intExtra2));
            if (TextUtils.isEmpty(this.f1106f)) {
                this.f1106f = stringExtra;
                ((SystemForegroundService) this.f1111k).e(intExtra, intExtra2, notification);
                return;
            }
            SystemForegroundService systemForegroundService = (SystemForegroundService) this.f1111k;
            systemForegroundService.c.post(new d(systemForegroundService, intExtra, notification));
            if (intExtra2 != 0 && Build.VERSION.SDK_INT >= 29) {
                for (Map.Entry<String, h> entry : this.f1107g.entrySet()) {
                    i2 |= entry.getValue().b;
                }
                h hVar = this.f1107g.get(this.f1106f);
                if (hVar != null) {
                    ((SystemForegroundService) this.f1111k).e(hVar.a, i2, hVar.c);
                }
            }
        }
    }

    @Override // e.b0.x.q.c
    public void c(List<String> list) {
    }

    public void d() {
        this.f1111k = null;
        synchronized (this.f1105e) {
            this.f1110j.c();
        }
        this.c.f1030f.e(this);
    }

    @Override // e.b0.x.q.c
    public void e(List<String> list) {
        if (!list.isEmpty()) {
            for (String str : list) {
                l.c().a(f1103l, String.format("Constraints unmet for WorkSpec %s", str), new Throwable[0]);
                e.b0.x.l lVar = this.c;
                e.b0.x.t.q.a aVar = lVar.f1028d;
                ((e.b0.x.t.q.b) aVar).a.execute(new k(lVar, str, true));
            }
        }
    }
}
