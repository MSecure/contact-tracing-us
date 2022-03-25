package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import e.t.c;
import e.t.d;
import java.util.HashMap;

public class MultiInstanceInvalidationService extends Service {
    public int b = 0;
    public final HashMap<Integer, String> c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public final RemoteCallbackList<c> f286d = new a();

    /* renamed from: e  reason: collision with root package name */
    public final d f287e = new b();

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
            synchronized (MultiInstanceInvalidationService.this.f286d) {
                MultiInstanceInvalidationService.this.f286d.unregister(cVar);
                MultiInstanceInvalidationService.this.c.remove(Integer.valueOf(i2));
            }
        }

        public void k(int i2, String[] strArr) {
            synchronized (MultiInstanceInvalidationService.this.f286d) {
                String str = MultiInstanceInvalidationService.this.c.get(Integer.valueOf(i2));
                if (str == null) {
                    Log.w("ROOM", "Remote invalidation client ID not registered");
                    return;
                }
                int beginBroadcast = MultiInstanceInvalidationService.this.f286d.beginBroadcast();
                for (int i3 = 0; i3 < beginBroadcast; i3++) {
                    try {
                        int intValue = ((Integer) MultiInstanceInvalidationService.this.f286d.getBroadcastCookie(i3)).intValue();
                        String str2 = MultiInstanceInvalidationService.this.c.get(Integer.valueOf(intValue));
                        if (i2 != intValue && str.equals(str2)) {
                            try {
                                MultiInstanceInvalidationService.this.f286d.getBroadcastItem(i3).s(strArr);
                            } catch (RemoteException e2) {
                                Log.w("ROOM", "Error invoking a remote callback", e2);
                            }
                        }
                    } catch (Throwable th) {
                        MultiInstanceInvalidationService.this.f286d.finishBroadcast();
                        throw th;
                    }
                }
                MultiInstanceInvalidationService.this.f286d.finishBroadcast();
            }
        }

        public int m(c cVar, String str) {
            if (str == null) {
                return 0;
            }
            synchronized (MultiInstanceInvalidationService.this.f286d) {
                MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
                int i2 = multiInstanceInvalidationService.b + 1;
                multiInstanceInvalidationService.b = i2;
                if (multiInstanceInvalidationService.f286d.register(cVar, Integer.valueOf(i2))) {
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
        return this.f287e;
    }
}
