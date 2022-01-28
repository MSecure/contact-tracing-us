package b.o;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import b.o.f;

public class l extends Service implements i {

    /* renamed from: b  reason: collision with root package name */
    public final v f2229b = new v(this);

    @Override // b.o.i
    public f getLifecycle() {
        return this.f2229b.f2250a;
    }

    public IBinder onBind(Intent intent) {
        this.f2229b.a(f.a.ON_START);
        return null;
    }

    public void onCreate() {
        this.f2229b.a(f.a.ON_CREATE);
        super.onCreate();
    }

    public void onDestroy() {
        v vVar = this.f2229b;
        vVar.a(f.a.ON_STOP);
        vVar.a(f.a.ON_DESTROY);
        super.onDestroy();
    }

    public void onStart(Intent intent, int i) {
        this.f2229b.a(f.a.ON_START);
        super.onStart(intent, i);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }
}
