package androidx.work.impl.foreground;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.work.impl.WorkDatabase;
import e.p.o;
import e.z.l;
import e.z.x.r.c;
import e.z.x.t.q.b;
import java.util.Objects;
import java.util.UUID;

public class SystemForegroundService extends o implements c.a {

    /* renamed from: g  reason: collision with root package name */
    public static final String f307g = l.e("SystemFgService");
    public Handler c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f308d;

    /* renamed from: e  reason: collision with root package name */
    public c f309e;

    /* renamed from: f  reason: collision with root package name */
    public NotificationManager f310f;

    public class a implements Runnable {
        public final /* synthetic */ int b;
        public final /* synthetic */ Notification c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f311d;

        public a(int i2, Notification notification, int i3) {
            this.b = i2;
            this.c = notification;
            this.f311d = i3;
        }

        public void run() {
            if (Build.VERSION.SDK_INT >= 29) {
                SystemForegroundService.this.startForeground(this.b, this.c, this.f311d);
            } else {
                SystemForegroundService.this.startForeground(this.b, this.c);
            }
        }
    }

    public final void b() {
        this.c = new Handler(Looper.getMainLooper());
        this.f310f = (NotificationManager) getApplicationContext().getSystemService("notification");
        c cVar = new c(getApplicationContext());
        this.f309e = cVar;
        if (cVar.f1986k != null) {
            l.c().b(c.f1978l, "A callback already exists.", new Throwable[0]);
        } else {
            cVar.f1986k = this;
        }
    }

    public void e(int i2, int i3, Notification notification) {
        this.c.post(new a(i2, notification, i3));
    }

    @Override // e.p.o
    public void onCreate() {
        super.onCreate();
        b();
    }

    @Override // e.p.o
    public void onDestroy() {
        super.onDestroy();
        this.f309e.d();
    }

    @Override // e.p.o
    public int onStartCommand(Intent intent, int i2, int i3) {
        super.onStartCommand(intent, i2, i3);
        if (this.f308d) {
            l.c().d(f307g, "Re-initializing SystemForegroundService after a request to shut-down.", new Throwable[0]);
            this.f309e.d();
            b();
            this.f308d = false;
        }
        if (intent == null) {
            return 3;
        }
        c cVar = this.f309e;
        Objects.requireNonNull(cVar);
        String action = intent.getAction();
        if ("ACTION_START_FOREGROUND".equals(action)) {
            l.c().d(c.f1978l, String.format("Started foreground service %s", intent), new Throwable[0]);
            String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
            WorkDatabase workDatabase = cVar.c.c;
            e.z.x.t.q.a aVar = cVar.f1979d;
            ((b) aVar).a.execute(new e.z.x.r.b(cVar, workDatabase, stringExtra));
        } else if (!"ACTION_NOTIFY".equals(action)) {
            if ("ACTION_CANCEL_WORK".equals(action)) {
                l.c().d(c.f1978l, String.format("Stopping foreground work for %s", intent), new Throwable[0]);
                String stringExtra2 = intent.getStringExtra("KEY_WORKSPEC_ID");
                if (stringExtra2 == null || TextUtils.isEmpty(stringExtra2)) {
                    return 3;
                }
                e.z.x.l lVar = cVar.c;
                UUID fromString = UUID.fromString(stringExtra2);
                Objects.requireNonNull(lVar);
                ((b) lVar.f1903d).a.execute(new e.z.x.t.a(lVar, fromString));
                return 3;
            } else if (!"ACTION_STOP_FOREGROUND".equals(action)) {
                return 3;
            } else {
                l.c().d(c.f1978l, "Stopping foreground service", new Throwable[0]);
                c.a aVar2 = cVar.f1986k;
                if (aVar2 == null) {
                    return 3;
                }
                SystemForegroundService systemForegroundService = (SystemForegroundService) aVar2;
                systemForegroundService.f308d = true;
                l.c().a(f307g, "All commands completed.", new Throwable[0]);
                if (Build.VERSION.SDK_INT >= 26) {
                    systemForegroundService.stopForeground(true);
                }
                systemForegroundService.stopSelf();
                return 3;
            }
        }
        cVar.b(intent);
        return 3;
    }
}
