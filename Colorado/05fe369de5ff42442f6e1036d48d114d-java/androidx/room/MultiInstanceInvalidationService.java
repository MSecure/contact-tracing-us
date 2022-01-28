package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import e.t.c;
import e.t.d;
import java.util.HashMap;

public class MultiInstanceInvalidationService extends Service {
    public int b = 0;
    public final HashMap<Integer, String> c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public final RemoteCallbackList<c> f289d = new a();

    /* renamed from: e  reason: collision with root package name */
    public final d f290e = new b();

    public class a extends RemoteCallbackList<c> {
        public a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.os.IInterface, java.lang.Object] */
        @Override // android.os.RemoteCallbackList
        public void onCallbackDied(c cVar, Object obj) {
            MultiInstanceInvalidationService.this.c.remove(Integer.valueOf(((Integer) obj).intValue()));
        }
    }

    public class b extends d {
        public b() {
        }

        public void E(c cVar, int i2) {
            synchronized (MultiInstanceInvalidationService.this.f289d) {
                MultiInstanceInvalidationService.this.f289d.unregister(cVar);
                MultiInstanceInvalidationService.this.c.remove(Integer.valueOf(i2));
            }
        }

        public void k(int i2, String[] strArr) {
            synchronized (MultiInstanceInvalidationService.this.f289d) {
                String str = MultiInstanceInvalidationService.this.c.get(Integer.valueOf(i2));
                if (str != null) {
                    int beginBroadcast = MultiInstanceInvalidationService.this.f289d.beginBroadcast();
                    for (int i3 = 0; i3 < beginBroadcast; i3++) {
                        try {
                            int intValue = ((Integer) MultiInstanceInvalidationService.this.f289d.getBroadcastCookie(i3)).intValue();
                            String str2 = MultiInstanceInvalidationService.this.c.get(Integer.valueOf(intValue));
                            if (i2 != intValue && str.equals(str2)) {
                                try {
                                    MultiInstanceInvalidationService.this.f289d.getBroadcastItem(i3).w(strArr);
                                } catch (RemoteException unused) {
                                }
                            }
                        } catch (Throwable th) {
                            MultiInstanceInvalidationService.this.f289d.finishBroadcast();
                            throw th;
                        }
                    }
                    MultiInstanceInvalidationService.this.f289d.finishBroadcast();
                }
            }
        }

        public int q(c cVar, String str) {
            if (str == null) {
                return 0;
            }
            synchronized (MultiInstanceInvalidationService.this.f289d) {
                MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
                int i2 = multiInstanceInvalidationService.b + 1;
                multiInstanceInvalidationService.b = i2;
                if (multiInstanceInvalidationService.f289d.register(cVar, Integer.valueOf(i2))) {
                    MultiInstanceInvalidationService.this.c.put(Integer.valueOf(i2), str);
                    return i2;
                }
                MultiInstanceInvalidationService multiInstanceInvalidationService2 = MultiInstanceInvalidationService.this;
                multiInstanceInvalidationService2.b--;
                return 0;
            }
        }
    }

    public IBinder onBind(Intent intent) {
        return this.f290e;
    }
}
