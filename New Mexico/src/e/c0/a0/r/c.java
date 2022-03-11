package e.c0.a0.r;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.impl.foreground.SystemForegroundService;
import e.c0.a0.b;
import e.c0.a0.l;
import e.c0.a0.q.d;
import e.c0.a0.s.o;
import e.c0.i;
import e.c0.n;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class c implements e.c0.a0.q.c, b {

    /* renamed from: l */
    public static final String f1181l = n.e("SystemFgDispatcher");
    public Context b;
    public l c;

    /* renamed from: d */
    public final e.c0.a0.t.t.a f1182d;

    /* renamed from: j */
    public final d f1188j;

    /* renamed from: k */
    public a f1189k;

    /* renamed from: e */
    public final Object f1183e = new Object();

    /* renamed from: f */
    public String f1184f = null;

    /* renamed from: g */
    public final Map<String, i> f1185g = new LinkedHashMap();

    /* renamed from: i */
    public final Set<o> f1187i = new HashSet();

    /* renamed from: h */
    public final Map<String, o> f1186h = new HashMap();

    /* loaded from: classes.dex */
    public interface a {
    }

    public c(Context context) {
        this.b = context;
        l h2 = l.h(this.b);
        this.c = h2;
        e.c0.a0.t.t.a aVar = h2.f1106d;
        this.f1182d = aVar;
        this.f1188j = new d(this.b, aVar, this);
        this.c.f1108f.b(this);
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

    @Override // e.c0.a0.b
    public void a(String str, boolean z) {
        Map.Entry<String, i> next;
        synchronized (this.f1183e) {
            o remove = this.f1186h.remove(str);
            if (remove != null ? this.f1187i.remove(remove) : false) {
                this.f1188j.b(this.f1187i);
            }
        }
        i remove2 = this.f1185g.remove(str);
        if (str.equals(this.f1184f) && this.f1185g.size() > 0) {
            Iterator<Map.Entry<String, i>> it = this.f1185g.entrySet().iterator();
            do {
                next = it.next();
            } while (it.hasNext());
            this.f1184f = next.getKey();
            if (this.f1189k != null) {
                i value = next.getValue();
                ((SystemForegroundService) this.f1189k).e(value.a, value.b, value.c);
                SystemForegroundService systemForegroundService = (SystemForegroundService) this.f1189k;
                systemForegroundService.c.post(new e(systemForegroundService, value.a));
            }
        }
        a aVar = this.f1189k;
        if (remove2 != null && aVar != null) {
            n.c().a(f1181l, String.format("Removing Notification (id: %s, workSpecId: %s ,notificationType: %s)", Integer.valueOf(remove2.a), str, Integer.valueOf(remove2.b)), new Throwable[0]);
            SystemForegroundService systemForegroundService2 = (SystemForegroundService) aVar;
            systemForegroundService2.c.post(new e(systemForegroundService2, remove2.a));
        }
    }

    @Override // e.c0.a0.q.c
    public void c(List<String> list) {
    }

    @Override // e.c0.a0.q.c
    public void e(List<String> list) {
        if (!list.isEmpty()) {
            for (String str : list) {
                n.c().a(f1181l, String.format("Constraints unmet for WorkSpec %s", str), new Throwable[0]);
                l lVar = this.c;
                ((e.c0.a0.t.t.b) lVar.f1106d).a.execute(new e.c0.a0.t.l(lVar, str, true));
            }
        }
    }

    public final void f(Intent intent) {
        int i2 = 0;
        int intExtra = intent.getIntExtra("KEY_NOTIFICATION_ID", 0);
        int intExtra2 = intent.getIntExtra("KEY_FOREGROUND_SERVICE_TYPE", 0);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        Notification notification = (Notification) intent.getParcelableExtra("KEY_NOTIFICATION");
        n.c().a(f1181l, String.format("Notifying with (id: %s, workSpecId: %s, notificationType: %s)", Integer.valueOf(intExtra), stringExtra, Integer.valueOf(intExtra2)), new Throwable[0]);
        if (!(notification == null || this.f1189k == null)) {
            this.f1185g.put(stringExtra, new i(intExtra, notification, intExtra2));
            if (TextUtils.isEmpty(this.f1184f)) {
                this.f1184f = stringExtra;
                ((SystemForegroundService) this.f1189k).e(intExtra, intExtra2, notification);
                return;
            }
            SystemForegroundService systemForegroundService = (SystemForegroundService) this.f1189k;
            systemForegroundService.c.post(new d(systemForegroundService, intExtra, notification));
            if (intExtra2 != 0 && Build.VERSION.SDK_INT >= 29) {
                for (Map.Entry<String, i> entry : this.f1185g.entrySet()) {
                    i2 |= entry.getValue().b;
                }
                i iVar = this.f1185g.get(this.f1184f);
                if (iVar != null) {
                    ((SystemForegroundService) this.f1189k).e(iVar.a, i2, iVar.c);
                }
            }
        }
    }

    public void g() {
        this.f1189k = null;
        synchronized (this.f1183e) {
            this.f1188j.c();
        }
        this.c.f1108f.e(this);
    }
}
