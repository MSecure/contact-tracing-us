package b.b0.y.q;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.impl.foreground.SystemForegroundService;
import b.b0.g;
import b.b0.m;
import b.b0.y.b;
import b.b0.y.k;
import b.b0.y.p.d;
import b.b0.y.r.p;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class c implements b.b0.y.p.c, b {
    public static final String l = m.e("SystemFgDispatcher");

    /* renamed from: b  reason: collision with root package name */
    public Context f1200b;

    /* renamed from: c  reason: collision with root package name */
    public k f1201c;

    /* renamed from: d  reason: collision with root package name */
    public final b.b0.y.s.s.a f1202d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f1203e = new Object();

    /* renamed from: f  reason: collision with root package name */
    public String f1204f;

    /* renamed from: g  reason: collision with root package name */
    public final Map<String, g> f1205g;
    public final Map<String, p> h;
    public final Set<p> i;
    public final d j;
    public a k;

    public interface a {
    }

    public c(Context context) {
        this.f1200b = context;
        k b2 = k.b(this.f1200b);
        this.f1201c = b2;
        this.f1202d = b2.f1097d;
        this.f1204f = null;
        this.f1205g = new LinkedHashMap();
        this.i = new HashSet();
        this.h = new HashMap();
        this.j = new d(this.f1200b, this.f1202d, this);
        this.f1201c.f1099f.b(this);
    }

    public static Intent b(Context context, String str, g gVar) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction("ACTION_NOTIFY");
        intent.putExtra("KEY_NOTIFICATION_ID", gVar.f1035a);
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", gVar.f1036b);
        intent.putExtra("KEY_NOTIFICATION", gVar.f1037c);
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent d(Context context, String str, g gVar) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction("ACTION_START_FOREGROUND");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NOTIFICATION_ID", gVar.f1035a);
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", gVar.f1036b);
        intent.putExtra("KEY_NOTIFICATION", gVar.f1037c);
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent f(Context context) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction("ACTION_STOP_FOREGROUND");
        return intent;
    }

    @Override // b.b0.y.b
    public void a(String str, boolean z) {
        Map.Entry<String, g> next;
        synchronized (this.f1203e) {
            p remove = this.h.remove(str);
            if (remove != null ? this.i.remove(remove) : false) {
                this.j.b(this.i);
            }
        }
        g remove2 = this.f1205g.remove(str);
        if (str.equals(this.f1204f) && this.f1205g.size() > 0) {
            Iterator<Map.Entry<String, g>> it = this.f1205g.entrySet().iterator();
            do {
                next = it.next();
            } while (it.hasNext());
            this.f1204f = next.getKey();
            if (this.k != null) {
                g value = next.getValue();
                ((SystemForegroundService) this.k).b(value.f1035a, value.f1036b, value.f1037c);
                SystemForegroundService systemForegroundService = (SystemForegroundService) this.k;
                systemForegroundService.f474c.post(new e(systemForegroundService, value.f1035a));
            }
        }
        a aVar = this.k;
        if (remove2 != null && aVar != null) {
            m.c().a(l, String.format("Removing Notification (id: %s, workSpecId: %s ,notificationType: %s)", Integer.valueOf(remove2.f1035a), str, Integer.valueOf(remove2.f1036b)), new Throwable[0]);
            SystemForegroundService systemForegroundService2 = (SystemForegroundService) aVar;
            systemForegroundService2.f474c.post(new e(systemForegroundService2, remove2.f1035a));
        }
    }

    @Override // b.b0.y.p.c
    public void c(List<String> list) {
    }

    @Override // b.b0.y.p.c
    public void e(List<String> list) {
        if (!list.isEmpty()) {
            for (String str : list) {
                m.c().a(l, String.format("Constraints unmet for WorkSpec %s", str), new Throwable[0]);
                k kVar = this.f1201c;
                b.b0.y.s.s.a aVar = kVar.f1097d;
                ((b.b0.y.s.s.b) aVar).f1334a.execute(new b.b0.y.s.k(kVar, str, true));
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
            this.f1205g.put(stringExtra, new g(intExtra, notification, intExtra2));
            if (TextUtils.isEmpty(this.f1204f)) {
                this.f1204f = stringExtra;
                ((SystemForegroundService) this.k).b(intExtra, intExtra2, notification);
                return;
            }
            SystemForegroundService systemForegroundService = (SystemForegroundService) this.k;
            systemForegroundService.f474c.post(new d(systemForegroundService, intExtra, notification));
            if (intExtra2 != 0 && Build.VERSION.SDK_INT >= 29) {
                for (Map.Entry<String, g> entry : this.f1205g.entrySet()) {
                    i2 |= entry.getValue().f1036b;
                }
                g gVar = this.f1205g.get(this.f1204f);
                if (gVar != null) {
                    ((SystemForegroundService) this.k).b(gVar.f1035a, i2, gVar.f1037c);
                }
            }
        }
    }

    public void h() {
        this.k = null;
        synchronized (this.f1203e) {
            this.j.c();
        }
        this.f1201c.f1099f.e(this);
    }
}
