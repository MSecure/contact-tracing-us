package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import b.r.c;
import b.r.d;
import java.util.HashMap;

public class MultiInstanceInvalidationService extends Service {

    /* renamed from: b  reason: collision with root package name */
    public int f278b = 0;

    /* renamed from: c  reason: collision with root package name */
    public final HashMap<Integer, String> f279c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public final RemoteCallbackList<c> f280d = new a();

    /* renamed from: e  reason: collision with root package name */
    public final d.a f281e = new b();

    public class a extends RemoteCallbackList<c> {
        public a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.os.IInterface, java.lang.Object] */
        @Override // android.os.RemoteCallbackList
        public void onCallbackDied(c cVar, Object obj) {
            MultiInstanceInvalidationService.this.f279c.remove(Integer.valueOf(((Integer) obj).intValue()));
        }
    }

    public class b extends d.a {
        public b() {
        }

        @Override // b.r.d
        public void G(int i, String[] strArr) {
            synchronized (MultiInstanceInvalidationService.this.f280d) {
                String str = MultiInstanceInvalidationService.this.f279c.get(Integer.valueOf(i));
                if (str != null) {
                    int beginBroadcast = MultiInstanceInvalidationService.this.f280d.beginBroadcast();
                    for (int i2 = 0; i2 < beginBroadcast; i2++) {
                        try {
                            int intValue = ((Integer) MultiInstanceInvalidationService.this.f280d.getBroadcastCookie(i2)).intValue();
                            String str2 = MultiInstanceInvalidationService.this.f279c.get(Integer.valueOf(intValue));
                            if (i != intValue && str.equals(str2)) {
                                try {
                                    MultiInstanceInvalidationService.this.f280d.getBroadcastItem(i2).M(strArr);
                                } catch (RemoteException unused) {
                                }
                            }
                        } catch (Throwable th) {
                            MultiInstanceInvalidationService.this.f280d.finishBroadcast();
                            throw th;
                        }
                    }
                    MultiInstanceInvalidationService.this.f280d.finishBroadcast();
                }
            }
        }

        @Override // b.r.d
        public void a0(c cVar, int i) {
            synchronized (MultiInstanceInvalidationService.this.f280d) {
                MultiInstanceInvalidationService.this.f280d.unregister(cVar);
                MultiInstanceInvalidationService.this.f279c.remove(Integer.valueOf(i));
            }
        }

        @Override // b.r.d
        public int j(c cVar, String str) {
            if (str == null) {
                return 0;
            }
            synchronized (MultiInstanceInvalidationService.this.f280d) {
                MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
                int i = multiInstanceInvalidationService.f278b + 1;
                multiInstanceInvalidationService.f278b = i;
                if (MultiInstanceInvalidationService.this.f280d.register(cVar, Integer.valueOf(i))) {
                    MultiInstanceInvalidationService.this.f279c.put(Integer.valueOf(i), str);
                    return i;
                }
                MultiInstanceInvalidationService multiInstanceInvalidationService2 = MultiInstanceInvalidationService.this;
                multiInstanceInvalidationService2.f278b--;
                return 0;
            }
        }
    }

    public IBinder onBind(Intent intent) {
        return this.f281e;
    }
}
