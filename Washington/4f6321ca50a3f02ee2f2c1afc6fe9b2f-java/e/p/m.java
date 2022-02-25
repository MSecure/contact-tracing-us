package e.p;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import e.p.g;

public class m extends Service implements j {
    public final w b = new w(this);

    @Override // e.p.j
    public g a() {
        return this.b.a;
    }

    public IBinder onBind(Intent intent) {
        this.b.a(g.a.ON_START);
        return null;
    }

    public void onCreate() {
        this.b.a(g.a.ON_CREATE);
        super.onCreate();
    }

    public void onDestroy() {
        w wVar = this.b;
        wVar.a(g.a.ON_STOP);
        wVar.a(g.a.ON_DESTROY);
        super.onDestroy();
    }

    public void onStart(Intent intent, int i2) {
        this.b.a(g.a.ON_START);
        super.onStart(intent, i2);
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        return super.onStartCommand(intent, i2, i3);
    }
}
