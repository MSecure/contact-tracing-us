package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import b.s.c;
import b.s.d;
import java.util.HashMap;

public class MultiInstanceInvalidationService extends Service {

    /* renamed from: b  reason: collision with root package name */
    public int f384b = 0;

    /* renamed from: c  reason: collision with root package name */
    public final HashMap<Integer, String> f385c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public final RemoteCallbackList<c> f386d = new a();

    /* renamed from: e  reason: collision with root package name */
    public final d.a f387e = new b();

    public class a extends RemoteCallbackList<c> {
        public a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.os.IInterface, java.lang.Object] */
        @Override // android.os.RemoteCallbackList
        public void onCallbackDied(c cVar, Object obj) {
            MultiInstanceInvalidationService.this.f385c.remove(Integer.valueOf(((Integer) obj).intValue()));
        }
    }

    public class b extends d.a {
        public b() {
        }

        @Override // b.s.d
        public void D(int i, String[] strArr) {
            synchronized (MultiInstanceInvalidationService.this.f386d) {
                String str = MultiInstanceInvalidationService.this.f385c.get(Integer.valueOf(i));
                if (str != null) {
                    int beginBroadcast = MultiInstanceInvalidationService.this.f386d.beginBroadcast();
                    for (int i2 = 0; i2 < beginBroadcast; i2++) {
                        try {
                            int intValue = ((Integer) MultiInstanceInvalidationService.this.f386d.getBroadcastCookie(i2)).intValue();
                            String str2 = MultiInstanceInvalidationService.this.f385c.get(Integer.valueOf(intValue));
                            if (i != intValue && str.equals(str2)) {
                                try {
                                    MultiInstanceInvalidationService.this.f386d.getBroadcastItem(i2).J(strArr);
                                } catch (RemoteException unused) {
                                }
                            }
                        } catch (Throwable th) {
                            MultiInstanceInvalidationService.this.f386d.finishBroadcast();
                            throw th;
                        }
                    }
                    MultiInstanceInvalidationService.this.f386d.finishBroadcast();
                }
            }
        }

        @Override // b.s.d
        public void X(c cVar, int i) {
            synchronized (MultiInstanceInvalidationService.this.f386d) {
                MultiInstanceInvalidationService.this.f386d.unregister(cVar);
                MultiInstanceInvalidationService.this.f385c.remove(Integer.valueOf(i));
            }
        }

        @Override // b.s.d
        public int g(c cVar, String str) {
            if (str == null) {
                return 0;
            }
            synchronized (MultiInstanceInvalidationService.this.f386d) {
                MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
                int i = multiInstanceInvalidationService.f384b + 1;
                multiInstanceInvalidationService.f384b = i;
                if (MultiInstanceInvalidationService.this.f386d.register(cVar, Integer.valueOf(i))) {
                    MultiInstanceInvalidationService.this.f385c.put(Integer.valueOf(i), str);
                    return i;
                }
                MultiInstanceInvalidationService multiInstanceInvalidationService2 = MultiInstanceInvalidationService.this;
                multiInstanceInvalidationService2.f384b--;
                return 0;
            }
        }
    }

    public IBinder onBind(Intent intent) {
        return this.f387e;
    }
}
