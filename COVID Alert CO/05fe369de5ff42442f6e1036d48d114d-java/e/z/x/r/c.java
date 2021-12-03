package e.z.x.r;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.impl.foreground.SystemForegroundService;
import e.z.h;
import e.z.l;
import e.z.x.b;
import e.z.x.q.d;
import e.z.x.s.o;
import e.z.x.t.k;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class c implements e.z.x.q.c, b {

    /* renamed from: l  reason: collision with root package name */
    public static final String f1978l = l.e("SystemFgDispatcher");
    public Context b;
    public e.z.x.l c;

    /* renamed from: d  reason: collision with root package name */
    public final e.z.x.t.q.a f1979d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f1980e = new Object();

    /* renamed from: f  reason: collision with root package name */
    public String f1981f;

    /* renamed from: g  reason: collision with root package name */
    public final Map<String, h> f1982g;

    /* renamed from: h  reason: collision with root package name */
    public final Map<String, o> f1983h;

    /* renamed from: i  reason: collision with root package name */
    public final Set<o> f1984i;

    /* renamed from: j  reason: collision with root package name */
    public final d f1985j;

    /* renamed from: k  reason: collision with root package name */
    public a f1986k;

    public interface a {
    }

    public c(Context context) {
        this.b = context;
        e.z.x.l f2 = e.z.x.l.f(this.b);
        this.c = f2;
        e.z.x.t.q.a aVar = f2.f1903d;
        this.f1979d = aVar;
        this.f1981f = null;
        this.f1982g = new LinkedHashMap();
        this.f1984i = new HashSet();
        this.f1983h = new HashMap();
        this.f1985j = new d(this.b, aVar, this);
        this.c.f1905f.b(this);
    }

    @Override // e.z.x.b
    public void a(String str, boolean z) {
        Map.Entry<String, h> next;
        synchronized (this.f1980e) {
            o remove = this.f1983h.remove(str);
            if (remove != null ? this.f1984i.remove(remove) : false) {
                this.f1985j.b(this.f1984i);
            }
        }
        h remove2 = this.f1982g.remove(str);
        if (str.equals(this.f1981f) && this.f1982g.size() > 0) {
            Iterator<Map.Entry<String, h>> it = this.f1982g.entrySet().iterator();
            do {
                next = it.next();
            } while (it.hasNext());
            this.f1981f = next.getKey();
            if (this.f1986k != null) {
                h value = next.getValue();
                ((SystemForegroundService) this.f1986k).e(value.a, value.b, value.c);
                SystemForegroundService systemForegroundService = (SystemForegroundService) this.f1986k;
                systemForegroundService.c.post(new e(systemForegroundService, value.a));
            }
        }
        if (remove2 != null && this.f1986k != null) {
            l.c().a(f1978l, String.format("Removing Notification (id: %s, workSpecId: %s ,notificationType: %s)", Integer.valueOf(remove2.a), str, Integer.valueOf(remove2.b)), new Throwable[0]);
            SystemForegroundService systemForegroundService2 = (SystemForegroundService) this.f1986k;
            systemForegroundService2.c.post(new e(systemForegroundService2, remove2.a));
        }
    }

    public final void b(Intent intent) {
        int i2 = 0;
        int intExtra = intent.getIntExtra("KEY_NOTIFICATION_ID", 0);
        int intExtra2 = intent.getIntExtra("KEY_FOREGROUND_SERVICE_TYPE", 0);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        Notification notification = (Notification) intent.getParcelableExtra("KEY_NOTIFICATION");
        l.c().a(f1978l, String.format("Notifying with (id: %s, workSpecId: %s, notificationType: %s)", Integer.valueOf(intExtra), stringExtra, Integer.valueOf(intExtra2)), new Throwable[0]);
        if (!(notification == null || this.f1986k == null)) {
            this.f1982g.put(stringExtra, new h(intExtra, notification, intExtra2));
            if (TextUtils.isEmpty(this.f1981f)) {
                this.f1981f = stringExtra;
                ((SystemForegroundService) this.f1986k).e(intExtra, intExtra2, notification);
                return;
            }
            SystemForegroundService systemForegroundService = (SystemForegroundService) this.f1986k;
            systemForegroundService.c.post(new d(systemForegroundService, intExtra, notification));
            if (intExtra2 != 0 && Build.VERSION.SDK_INT >= 29) {
                for (Map.Entry<String, h> entry : this.f1982g.entrySet()) {
                    i2 |= entry.getValue().b;
                }
                h hVar = this.f1982g.get(this.f1981f);
                if (hVar != null) {
                    ((SystemForegroundService) this.f1986k).e(hVar.a, i2, hVar.c);
                }
            }
        }
    }

    @Override // e.z.x.q.c
    public void c(List<String> list) {
    }

    public void d() {
        this.f1986k = null;
        synchronized (this.f1980e) {
            this.f1985j.c();
        }
        this.c.f1905f.e(this);
    }

    @Override // e.z.x.q.c
    public void e(List<String> list) {
        if (!list.isEmpty()) {
            for (String str : list) {
                l.c().a(f1978l, String.format("Constraints unmet for WorkSpec %s", str), new Throwable[0]);
                e.z.x.l lVar = this.c;
                e.z.x.t.q.a aVar = lVar.f1903d;
                ((e.z.x.t.q.b) aVar).a.execute(new k(lVar, str, true));
            }
        }
    }
}
