package f.b.a.f.a.b;

import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.play.core.assetpacks.ExtractionForegroundService;
import f.b.a.f.a.e.a;
import f.b.a.f.a.e.j0;
import f.b.a.f.a.e.x;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class x0 implements ServiceConnection {
    public final a a = new a("ExtractionForegroundServiceConnection");
    public final List<j0> b = new ArrayList();
    public final Context c;

    /* renamed from: d */
    public ExtractionForegroundService f3334d;

    /* renamed from: e */
    public Notification f3335e;

    public x0(Context context) {
        this.c = context;
    }

    public final void a() {
        ArrayList arrayList;
        synchronized (this.b) {
            arrayList = new ArrayList(this.b);
            this.b.clear();
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            j0 j0Var = (j0) arrayList.get(i2);
            try {
                Bundle bundle = new Bundle();
                Bundle bundle2 = new Bundle();
                Parcel p = j0Var.p();
                int i3 = x.a;
                p.writeInt(1);
                bundle.writeToParcel(p, 0);
                p.writeInt(1);
                bundle2.writeToParcel(p, 0);
                j0Var.z(2, p);
            } catch (RemoteException unused) {
                this.a.b("Could not resolve Play Store service state update callback.", new Object[0]);
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.a.a("Starting foreground installation service.", new Object[0]);
        ExtractionForegroundService extractionForegroundService = ((w0) iBinder).a;
        this.f3334d = extractionForegroundService;
        extractionForegroundService.startForeground(-1883842196, this.f3335e);
        a();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
