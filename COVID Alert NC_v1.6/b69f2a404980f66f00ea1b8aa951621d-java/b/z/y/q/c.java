package b.z.y.q;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.impl.foreground.SystemForegroundService;
import b.z.g;
import b.z.m;
import b.z.y.b;
import b.z.y.k;
import b.z.y.p.d;
import b.z.y.r.p;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class c implements b.z.y.p.c, b {
    public static final String l = m.e("SystemFgDispatcher");

    /* renamed from: b  reason: collision with root package name */
    public Context f2059b;

    /* renamed from: c  reason: collision with root package name */
    public k f2060c;

    /* renamed from: d  reason: collision with root package name */
    public final b.z.y.s.s.a f2061d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f2062e = new Object();
    public String f;
    public final Map<String, g> g;
    public final Map<String, p> h;
    public final Set<p> i;
    public final d j;
    public a k;

    public interface a {
    }

    public c(Context context) {
        this.f2059b = context;
        k b2 = k.b(this.f2059b);
        this.f2060c = b2;
        this.f2061d = b2.f1972d;
        this.f = null;
        this.g = new LinkedHashMap();
        this.i = new HashSet();
        this.h = new HashMap();
        this.j = new d(this.f2059b, this.f2061d, this);
        this.f2060c.f.b(this);
    }

    public static Intent b(Context context, String str, g gVar) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction("ACTION_NOTIFY");
        intent.putExtra("KEY_NOTIFICATION_ID", gVar.f1919a);
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", gVar.f1920b);
        intent.putExtra("KEY_NOTIFICATION", gVar.f1921c);
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent d(Context context, String str, g gVar) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction("ACTION_START_FOREGROUND");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NOTIFICATION_ID", gVar.f1919a);
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", gVar.f1920b);
        intent.putExtra("KEY_NOTIFICATION", gVar.f1921c);
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent f(Context context) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction("ACTION_STOP_FOREGROUND");
        return intent;
    }

    @Override // b.z.y.b
    public void a(String str, boolean z) {
        Map.Entry<String, g> next;
        synchronized (this.f2062e) {
            p remove = this.h.remove(str);
            if (remove != null ? this.i.remove(remove) : false) {
                this.j.b(this.i);
            }
        }
        g remove2 = this.g.remove(str);
        if (str.equals(this.f) && this.g.size() > 0) {
            Iterator<Map.Entry<String, g>> it = this.g.entrySet().iterator();
            do {
                next = it.next();
            } while (it.hasNext());
            this.f = next.getKey();
            if (this.k != null) {
                g value = next.getValue();
                ((SystemForegroundService) this.k).b(value.f1919a, value.f1920b, value.f1921c);
                SystemForegroundService systemForegroundService = (SystemForegroundService) this.k;
                systemForegroundService.f339c.post(new e(systemForegroundService, value.f1919a));
            }
        }
        a aVar = this.k;
        if (remove2 != null && aVar != null) {
            m.c().a(l, String.format("Removing Notification (id: %s, workSpecId: %s ,notificationType: %s)", Integer.valueOf(remove2.f1919a), str, Integer.valueOf(remove2.f1920b)), new Throwable[0]);
            SystemForegroundService systemForegroundService2 = (SystemForegroundService) aVar;
            systemForegroundService2.f339c.post(new e(systemForegroundService2, remove2.f1919a));
        }
    }

    @Override // b.z.y.p.c
    public void c(List<String> list) {
    }

    @Override // b.z.y.p.c
    public void e(List<String> list) {
        if (!list.isEmpty()) {
            for (String str : list) {
                m.c().a(l, String.format("Constraints unmet for WorkSpec %s", str), new Throwable[0]);
                k kVar = this.f2060c;
                b.z.y.s.s.a aVar = kVar.f1972d;
                ((b.z.y.s.s.b) aVar).f2183a.execute(new b.z.y.s.k(kVar, str, true));
            }
        }
    }

    public final void g(Intent intent) {
        int i2 = 0;
        int intExtra = intent.getIntExtra("KEY_NOTIFICATION_ID", 0);
        int intExtra2 = intent.getIntExtra("KEY_FOREGROUND_SERVICE_TYPE", 0);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        Notification notification = (Notification) intent.getParcelableExtra("KEY_NOTIFICATION");
        m.c().a(l, String.format("Notifying with (id: %s, workSpecId: %s, notificationType: %s)", Integer.valueOf(intExtra), stringExtra, Integer.valueOf(intExtra2)), new Throwable[0]);
        if (!(notification == null || this.k == null)) {
            this.g.put(stringExtra, new g(intExtra, notification, intExtra2));
            if (TextUtils.isEmpty(this.f)) {
                this.f = stringExtra;
                ((SystemForegroundService) this.k).b(intExtra, intExtra2, notification);
                return;
            }
            SystemForegroundService systemForegroundService = (SystemForegroundService) this.k;
            systemForegroundService.f339c.post(new d(systemForegroundService, intExtra, notification));
            if (intExtra2 != 0 && Build.VERSION.SDK_INT >= 29) {
                for (Map.Entry<String, g> entry : this.g.entrySet()) {
                    i2 |= entry.getValue().f1920b;
                }
                g gVar = this.g.get(this.f);
                if (gVar != null) {
                    ((SystemForegroundService) this.k).b(gVar.f1919a, i2, gVar.f1921c);
                }
            }
        }
    }

    public void h() {
        this.k = null;
        synchronized (this.f2062e) {
            this.j.c();
        }
        this.f2060c.f.e(this);
    }
}
