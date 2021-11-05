package androidx.work.impl.foreground;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.work.impl.WorkDatabase;
import b.b0.m;
import b.b0.y.k;
import b.b0.y.q.c;
import b.b0.y.s.s.b;
import b.o.l;
import java.util.UUID;

public class SystemForegroundService extends l implements c.a {

    /* renamed from: g  reason: collision with root package name */
    public static final String f473g = m.e("SystemFgService");

    /* renamed from: c  reason: collision with root package name */
    public Handler f474c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f475d;

    /* renamed from: e  reason: collision with root package name */
    public c f476e;

    /* renamed from: f  reason: collision with root package name */
    public NotificationManager f477f;

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f478b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Notification f479c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f480d;

        public a(int i, Notification notification, int i2) {
            this.f478b = i;
            this.f479c = notification;
            this.f480d = i2;
        }

        public void run() {
            if (Build.VERSION.SDK_INT >= 29) {
                SystemForegroundService.this.startForeground(this.f478b, this.f479c, this.f480d);
            } else {
                SystemForegroundService.this.startForeground(this.f478b, this.f479c);
            }
        }
    }

    public final void a() {
        this.f474c = new Handler(Looper.getMainLooper());
        this.f477f = (NotificationManager) getApplicationContext().getSystemService("notification");
        c cVar = new c(getApplicationContext());
        this.f476e = cVar;
        if (cVar.k != null) {
            m.c().b(c.l, "A callback already exists.", new Throwable[0]);
        } else {
            cVar.k = this;
        }
    }

    public void b(int i, int i2, Notification notification) {
        this.f474c.post(new a(i, notification, i2));
    }

    @Override // b.o.l
    public void onCreate() {
        super.onCreate();
        a();
    }

    @Override // b.o.l
    public void onDestroy() {
        super.onDestroy();
        this.f476e.h();
    }

    @Override // b.o.l
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        if (this.f475d) {
            m.c().d(f473g, "Re-initializing SystemForegroundService after a request to shut-down.", new Throwable[0]);
            this.f476e.h();
            a();
            this.f475d = false;
        }
        if (intent == null) {
            return 3;
        }
        c cVar = this.f476e;
        if (cVar != null) {
            String action = intent.getAction();
            if ("ACTION_START_FOREGROUND".equals(action)) {
                m.c().d(c.l, String.format("Started foreground service %s", intent), new Throwable[0]);
                String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
                WorkDatabase workDatabase = cVar.f1201c.f1096c;
                b.b0.y.s.s.a aVar = cVar.f1202d;
                ((b) aVar).f1334a.execute(new b.b0.y.q.b(cVar, workDatabase, stringExtra));
            } else if (!"ACTION_NOTIFY".equals(action)) {
                if ("ACTION_CANCEL_WORK".equals(action)) {
                    m.c().d(c.l, String.format("Stopping foreground work for %s", intent), new Throwable[0]);
                    String stringExtra2 = intent.getStringExtra("KEY_WORKSPEC_ID");
                    if (stringExtra2 == null || TextUtils.isEmpty(stringExtra2)) {
                        return 3;
                    }
                    k kVar = cVar.f1201c;
                    UUID fromString = UUID.fromString(stringExtra2);
                    if (kVar != null) {
                        ((b) kVar.f1097d).f1334a.execute(new b.b0.y.s.a(kVar, fromString));
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
                    systemForegroundService.f475d = true;
                    m.c().a(f473g, "All commands completed.", new Throwable[0]);
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
