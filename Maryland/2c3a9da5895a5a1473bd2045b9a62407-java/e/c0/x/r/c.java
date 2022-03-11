package e.c0.x.r;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.impl.foreground.SystemForegroundService;
import e.c0.h;
import e.c0.l;
import e.c0.x.b;
import e.c0.x.q.d;
import e.c0.x.s.o;
import e.c0.x.t.k;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class c implements e.c0.x.q.c, b {

    /* renamed from: l  reason: collision with root package name */
    public static final String f1123l = l.e("SystemFgDispatcher");
    public Context b;
    public e.c0.x.l c;

    /* renamed from: d  reason: collision with root package name */
    public final e.c0.x.t.q.a f1124d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f1125e = new Object();

    /* renamed from: f  reason: collision with root package name */
    public String f1126f;

    /* renamed from: g  reason: collision with root package name */
    public final Map<String, h> f1127g;

    /* renamed from: h  reason: collision with root package name */
    public final Map<String, o> f1128h;

    /* renamed from: i  reason: collision with root package name */
    public final Set<o> f1129i;

    /* renamed from: j  reason: collision with root package name */
    public final d f1130j;

    /* renamed from: k  reason: collision with root package name */
    public a f1131k;

    public interface a {
    }

    public c(Context context) {
        this.b = context;
        e.c0.x.l d2 = e.c0.x.l.d(this.b);
        this.c = d2;
        e.c0.x.t.q.a aVar = d2.f1048d;
        this.f1124d = aVar;
        this.f1126f = null;
        this.f1127g = new LinkedHashMap();
        this.f1129i = new HashSet();
        this.f1128h = new HashMap();
        this.f1130j = new d(this.b, aVar, this);
        this.c.f1050f.b(this);
    }

    @Override // e.c0.x.b
    public void a(String str, boolean z) {
        Map.Entry<String, h> next;
        synchronized (this.f1125e) {
            o remove = this.f1128h.remove(str);
            if (remove != null ? this.f1129i.remove(remove) : false) {
                this.f1130j.b(this.f1129i);
            }
        }
        h remove2 = this.f1127g.remove(str);
        if (str.equals(this.f1126f) && this.f1127g.size() > 0) {
            Iterator<Map.Entry<String, h>> it = this.f1127g.entrySet().iterator();
            do {
                next = it.next();
            } while (it.hasNext());
            this.f1126f = next.getKey();
            if (this.f1131k != null) {
                h value = next.getValue();
                ((SystemForegroundService) this.f1131k).e(value.a, value.b, value.c);
                SystemForegroundService systemForegroundService = (SystemForegroundService) this.f1131k;
                systemForegroundService.c.post(new e(systemForegroundService, value.a));
            }
        }
        if (remove2 != null && this.f1131k != null) {
            l.c().a(f1123l, String.format("Removing Notification (id: %s, workSpecId: %s ,notificationType: %s)", Integer.valueOf(remove2.a), str, Integer.valueOf(remove2.b)), new Throwable[0]);
            SystemForegroundService systemForegroundService2 = (SystemForegroundService) this.f1131k;
            systemForegroundService2.c.post(new e(systemForegroundService2, remove2.a));
        }
    }

    public final void b(Intent intent) {
        int i2 = 0;
        int intExtra = intent.getIntExtra("KEY_NOTIFICATION_ID", 0);
        int intExtra2 = intent.getIntExtra("KEY_FOREGROUND_SERVICE_TYPE", 0);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        Notification notification = (Notification) intent.getParcelableExtra("KEY_NOTIFICATION");
        l.c().a(f1123l, String.format("Notifying with (id: %s, workSpecId: %s, notificationType: %s)", Integer.valueOf(intExtra), stringExtra, Integer.valueOf(intExtra2)), new Throwable[0]);
        if (!(notification == null || this.f1131k == null)) {
            this.f1127g.put(stringExtra, new h(intExtra, notification, intExtra2));
            if (TextUtils.isEmpty(this.f1126f)) {
                this.f1126f = stringExtra;
                ((SystemForegroundService) this.f1131k).e(intExtra, intExtra2, notification);
                return;
            }
            SystemForegroundService systemForegroundService = (SystemForegroundService) this.f1131k;
            systemForegroundService.c.post(new d(systemForegroundService, intExtra, notification));
            if (intExtra2 != 0 && Build.VERSION.SDK_INT >= 29) {
                for (Map.Entry<String, h> entry : this.f1127g.entrySet()) {
                    i2 |= entry.getValue().b;
                }
                h hVar = this.f1127g.get(this.f1126f);
                if (hVar != null) {
                    ((SystemForegroundService) this.f1131k).e(hVar.a, i2, hVar.c);
                }
            }
        }
    }

    @Override // e.c0.x.q.c
    public void c(List<String> list) {
    }

    public void d() {
        this.f1131k = null;
        synchronized (this.f1125e) {
            this.f1130j.c();
        }
        this.c.f1050f.e(this);
    }

    @Override // e.c0.x.q.c
    public void e(List<String> list) {
        if (!list.isEmpty()) {
            for (String str : list) {
                l.c().a(f1123l, String.format("Constraints unmet for WorkSpec %s", str), new Throwable[0]);
                e.c0.x.l lVar = this.c;
                e.c0.x.t.q.a aVar = lVar.f1048d;
                ((e.c0.x.t.q.b) aVar).a.execute(new k(lVar, str, true));
            }
        }
    }
}
