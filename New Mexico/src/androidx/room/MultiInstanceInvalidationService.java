package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import e.v.c;
import e.v.d;
import java.util.HashMap;
/* loaded from: classes.dex */
public class MultiInstanceInvalidationService extends Service {
    public int b = 0;
    public final HashMap<Integer, String> c = new HashMap<>();

    /* renamed from: d */
    public final RemoteCallbackList<c> f290d = new a();

    /* renamed from: e */
    public final d f291e = new b();

    /* loaded from: classes.dex */
    public class a extends RemoteCallbackList<c> {
        public a() {
            MultiInstanceInvalidationService.this = r1;
        }

        @Override // android.os.RemoteCallbackList
        public void onCallbackDied(c cVar, Object obj) {
            MultiInstanceInvalidationService.this.c.remove(Integer.valueOf(((Integer) obj).intValue()));
        }
    }

    /* loaded from: classes.dex */
    public class b extends d {
        public b() {
            MultiInstanceInvalidationService.this = r1;
        }

        public void Q(c cVar, int i2) {
            synchronized (MultiInstanceInvalidationService.this.f290d) {
                MultiInstanceInvalidationService.this.f290d.unregister(cVar);
                MultiInstanceInvalidationService.this.c.remove(Integer.valueOf(i2));
            }
        }

        public void p(int i2, String[] strArr) {
            synchronized (MultiInstanceInvalidationService.this.f290d) {
                String str = MultiInstanceInvalidationService.this.c.get(Integer.valueOf(i2));
                if (str != null) {
                    int beginBroadcast = MultiInstanceInvalidationService.this.f290d.beginBroadcast();
                    for (int i3 = 0; i3 < beginBroadcast; i3++) {
                        int intValue = ((Integer) MultiInstanceInvalidationService.this.f290d.getBroadcastCookie(i3)).intValue();
                        String str2 = MultiInstanceInvalidationService.this.c.get(Integer.valueOf(intValue));
                        if (i2 != intValue && str.equals(str2)) {
                            try {
                                MultiInstanceInvalidationService.this.f290d.getBroadcastItem(i3).G(strArr);
                            } catch (RemoteException unused) {
                            }
                        }
                    }
                    MultiInstanceInvalidationService.this.f290d.finishBroadcast();
                }
            }
        }

        public int z(c cVar, String str) {
            if (str == null) {
                return 0;
            }
            synchronized (MultiInstanceInvalidationService.this.f290d) {
                MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
                int i2 = multiInstanceInvalidationService.b + 1;
                multiInstanceInvalidationService.b = i2;
                if (multiInstanceInvalidationService.f290d.register(cVar, Integer.valueOf(i2))) {
                    MultiInstanceInvalidationService.this.c.put(Integer.valueOf(i2), str);
                    return i2;
                }
                MultiInstanceInvalidationService multiInstanceInvalidationService2 = MultiInstanceInvalidationService.this;
                multiInstanceInvalidationService2.b--;
                return 0;
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f291e;
    }
}
