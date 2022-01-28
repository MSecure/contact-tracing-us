package androidx.work.impl.foreground;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.work.impl.WorkDatabase;
import b.n.l;
import b.z.m;
import b.z.y.k;
import b.z.y.q.c;
import b.z.y.s.s.b;
import java.util.UUID;

public class SystemForegroundService extends l implements c.a {
    public static final String g = m.e("SystemFgService");

    /* renamed from: c  reason: collision with root package name */
    public Handler f339c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f340d;

    /* renamed from: e  reason: collision with root package name */
    public c f341e;
    public NotificationManager f;

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f342b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Notification f343c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f344d;

        public a(int i, Notification notification, int i2) {
            this.f342b = i;
            this.f343c = notification;
            this.f344d = i2;
        }

        public void run() {
            if (Build.VERSION.SDK_INT >= 29) {
                SystemForegroundService.this.startForeground(this.f342b, this.f343c, this.f344d);
            } else {
                SystemForegroundService.this.startForeground(this.f342b, this.f343c);
            }
        }
    }

    public final void a() {
        this.f339c = new Handler(Looper.getMainLooper());
        this.f = (NotificationManager) getApplicationContext().getSystemService("notification");
        c cVar = new c(getApplicationContext());
        this.f341e = cVar;
        if (cVar.k != null) {
            m.c().b(c.l, "A callback already exists.", new Throwable[0]);
        } else {
            cVar.k = this;
        }
    }

    public void b(int i, int i2, Notification notification) {
        this.f339c.post(new a(i, notification, i2));
    }

    @Override // b.n.l
    public void onCreate() {
        super.onCreate();
        a();
    }

    @Override // b.n.l
    public void onDestroy() {
        super.onDestroy();
        this.f341e.h();
    }

    @Override // b.n.l
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        if (this.f340d) {
            m.c().d(g, "Re-initializing SystemForegroundService after a request to shut-down.", new Throwable[0]);
            this.f341e.h();
            a();
            this.f340d = false;
        }
        if (intent == null) {
            return 3;
        }
        c cVar = this.f341e;
        if (cVar != null) {
            String action = intent.getAction();
            if ("ACTION_START_FOREGROUND".equals(action)) {
                m.c().d(c.l, String.format("Started foreground service %s", intent), new Throwable[0]);
                String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
                WorkDatabase workDatabase = cVar.f2060c.f1971c;
                b.z.y.s.s.a aVar = cVar.f2061d;
                ((b) aVar).f2183a.execute(new b.z.y.q.b(cVar, workDatabase, stringExtra));
            } else if (!"ACTION_NOTIFY".equals(action)) {
                if ("ACTION_CANCEL_WORK".equals(action)) {
                    m.c().d(c.l, String.format("Stopping foreground work for %s", intent), new Throwable[0]);
                    String stringExtra2 = intent.getStringExtra("KEY_WORKSPEC_ID");
                    if (stringExtra2 == null || TextUtils.isEmpty(stringExtra2)) {
                        return 3;
                    }
                    k kVar = cVar.f2060c;
                    UUID fromString = UUID.fromString(stringExtra2);
                    if (kVar != null) {
                        ((b) kVar.f1972d).f2183a.execute(new b.z.y.s.a(kVar, fromString));
                        return 3;
                    }
                    throw null;
                } else if (!"ACTION_STOP_FOREGROUND".equals(action)) {
                    return 3;
                } else {
                    m.c().d(c.l, "Stopping foreground service", new Throwable[0]);
                    c.a aVar2 = cVar.k;
                    if (aVar2 == null) {
                        return 3;
                    }
                    SystemForegroundService systemForegroundService = (SystemForegroundService) aVar2;
                    systemForegroundService.f340d = true;
                    m.c().a(g, "All commands completed.", new Throwable[0]);
                    if (Build.VERSION.SDK_INT >= 26) {
                        systemForegroundService.stopForeground(true);
                    }
                    systemForegroundService.stopSelf();
                    return 3;
                }
            }
            cVar.g(intent);
            return 3;
        }
        throw null;
    }
}
