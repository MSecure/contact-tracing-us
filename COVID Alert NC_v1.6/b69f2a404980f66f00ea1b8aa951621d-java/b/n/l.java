package b.n;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import b.n.f;

public class l extends Service implements i {

    /* renamed from: b  reason: collision with root package name */
    public final v f1398b = new v(this);

    @Override // b.n.i
    public f getLifecycle() {
        return this.f1398b.f1414a;
    }

    public IBinder onBind(Intent intent) {
        this.f1398b.a(f.a.ON_START);
        return null;
    }

    public void onCreate() {
        this.f1398b.a(f.a.ON_CREATE);
        super.onCreate();
    }

    public void onDestroy() {
        v vVar = this.f1398b;
        vVar.a(f.a.ON_STOP);
        vVar.a(f.a.ON_DESTROY);
        super.onDestroy();
    }

    public void onStart(Intent intent, int i) {
        this.f1398b.a(f.a.ON_START);
        super.onStart(intent, i);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }
}
