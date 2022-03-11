package androidx.work.impl.foreground;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.work.impl.WorkDatabase;
import e.c0.a0.l;
import e.c0.a0.r.c;
import e.c0.a0.t.t.b;
import e.c0.n;
import e.r.o;
import java.util.Objects;
import java.util.UUID;
/* loaded from: classes.dex */
public class SystemForegroundService extends o implements c.a {

    /* renamed from: g */
    public static final String f311g = n.e("SystemFgService");
    public Handler c;

    /* renamed from: d */
    public boolean f312d;

    /* renamed from: e */
    public c f313e;

    /* renamed from: f */
    public NotificationManager f314f;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ int b;
        public final /* synthetic */ Notification c;

        /* renamed from: d */
        public final /* synthetic */ int f315d;

        public a(int i2, Notification notification, int i3) {
            SystemForegroundService.this = r1;
            this.b = i2;
            this.c = notification;
            this.f315d = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Build.VERSION.SDK_INT >= 29) {
                SystemForegroundService.this.startForeground(this.b, this.c, this.f315d);
            } else {
                SystemForegroundService.this.startForeground(this.b, this.c);
            }
        }
    }

    public final void b() {
        this.c = new Handler(Looper.getMainLooper());
        this.f314f = (NotificationManager) getApplicationContext().getSystemService("notification");
        c cVar = new c(getApplicationContext());
        this.f313e = cVar;
        if (cVar.f1189k != null) {
            n.c().b(c.f1181l, "A callback already exists.", new Throwable[0]);
        } else {
            cVar.f1189k = this;
        }
    }

    public void e(int i2, int i3, Notification notification) {
        this.c.post(new a(i2, notification, i3));
    }

    @Override // e.r.o, android.app.Service
    public void onCreate() {
        super.onCreate();
        b();
    }

    @Override // e.r.o, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.f313e.g();
    }

    @Override // e.r.o, android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        super.onStartCommand(intent, i2, i3);
        if (this.f312d) {
            n.c().d(f311g, "Re-initializing SystemForegroundService after a request to shut-down.", new Throwable[0]);
            this.f313e.g();
            b();
            this.f312d = false;
        }
        if (intent == null) {
            return 3;
        }
        c cVar = this.f313e;
        Objects.requireNonNull(cVar);
        String action = intent.getAction();
        if ("ACTION_START_FOREGROUND".equals(action)) {
            n.c().d(c.f1181l, String.format("Started foreground service %s", intent), new Throwable[0]);
            String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
            WorkDatabase workDatabase = cVar.c.c;
            ((b) cVar.f1182d).a.execute(new e.c0.a0.r.b(cVar, workDatabase, stringExtra));
        } else if (!"ACTION_NOTIFY".equals(action)) {
            if ("ACTION_CANCEL_WORK".equals(action)) {
                n.c().d(c.f1181l, String.format("Stopping foreground work for %s", intent), new Throwable[0]);
                String stringExtra2 = intent.getStringExtra("KEY_WORKSPEC_ID");
                if (stringExtra2 == null || TextUtils.isEmpty(stringExtra2)) {
                    return 3;
                }
                l lVar = cVar.c;
                UUID fromString = UUID.fromString(stringExtra2);
                Objects.requireNonNull(lVar);
                ((b) lVar.f1106d).a.execute(new e.c0.a0.t.a(lVar, fromString));
                return 3;
            } else if (!"ACTION_STOP_FOREGROUND".equals(action)) {
                return 3;
            } else {
                n.c().d(c.f1181l, "Stopping foreground service", new Throwable[0]);
                c.a aVar = cVar.f1189k;
                if (aVar == null) {
                    return 3;
                }
                SystemForegroundService systemForegroundService = (SystemForegroundService) aVar;
                systemForegroundService.f312d = true;
                n.c().a(f311g, "All commands completed.", new Throwable[0]);
                if (Build.VERSION.SDK_INT >= 26) {
                    systemForegroundService.stopForeground(true);
                }
                systemForegroundService.stopSelf();
                return 3;
            }
        }
        cVar.f(intent);
        return 3;
    }
}
