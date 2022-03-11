package e.r;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import e.r.h;
/* loaded from: classes.dex */
public class o extends Service implements l {
    public final a0 b = new a0(this);

    @Override // e.r.l
    public h a() {
        return this.b.a;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        this.b.a(h.a.ON_START);
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        this.b.a(h.a.ON_CREATE);
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        a0 a0Var = this.b;
        a0Var.a(h.a.ON_STOP);
        a0Var.a(h.a.ON_DESTROY);
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i2) {
        this.b.a(h.a.ON_START);
        super.onStart(intent, i2);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        return super.onStartCommand(intent, i2, i3);
    }
}
