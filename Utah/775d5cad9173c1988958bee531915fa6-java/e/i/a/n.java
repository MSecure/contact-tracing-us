package e.i.a;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.util.Log;
import d.a.a.a.a;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class n {
    public static final Object c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public static String f1473d;

    /* renamed from: e  reason: collision with root package name */
    public static Set<String> f1474e = new HashSet();

    /* renamed from: f  reason: collision with root package name */
    public static final Object f1475f = new Object();

    /* renamed from: g  reason: collision with root package name */
    public static c f1476g;
    public final Context a;
    public final NotificationManager b;

    public static class a implements d {
        public final String a;
        public final int b;
        public final String c;

        /* renamed from: d  reason: collision with root package name */
        public final Notification f1477d;

        public a(String str, int i2, String str2, Notification notification) {
            this.a = str;
            this.b = i2;
            this.c = str2;
            this.f1477d = notification;
        }

        @Override // e.i.a.n.d
        public void a(d.a.a.a.a aVar) {
            aVar.x(this.a, this.b, this.c, this.f1477d);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("NotifyTask[");
            sb.append("packageName:");
            sb.append(this.a);
            sb.append(", id:");
            sb.append(this.b);
            sb.append(", tag:");
            return f.a.a.a.a.e(sb, this.c, "]");
        }
    }

    public static class b {
        public final ComponentName a;
        public final IBinder b;

        public b(ComponentName componentName, IBinder iBinder) {
            this.a = componentName;
            this.b = iBinder;
        }
    }

    public static class c implements Handler.Callback, ServiceConnection {
        public final Context a;
        public final HandlerThread b;
        public final Handler c;

        /* renamed from: d  reason: collision with root package name */
        public final Map<ComponentName, a> f1478d = new HashMap();

        /* renamed from: e  reason: collision with root package name */
        public Set<String> f1479e = new HashSet();

        public static class a {
            public final ComponentName a;
            public boolean b = false;
            public d.a.a.a.a c;

            /* renamed from: d  reason: collision with root package name */
            public ArrayDeque<d> f1480d = new ArrayDeque<>();

            /* renamed from: e  reason: collision with root package name */
            public int f1481e = 0;

            public a(ComponentName componentName) {
                this.a = componentName;
            }
        }

        public c(Context context) {
            this.a = context;
            HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
            this.b = handlerThread;
            handlerThread.start();
            this.c = new Handler(handlerThread.getLooper(), this);
        }

        /* JADX WARNING: Removed duplicated region for block: B:33:0x00c7  */
        /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
        public final void a(a aVar) {
            boolean z;
            String str;
            StringBuilder sb;
            if (Log.isLoggable("NotifManCompat", 3)) {
                StringBuilder h2 = f.a.a.a.a.h("Processing component ");
                h2.append(aVar.a);
                h2.append(", ");
                h2.append(aVar.f1480d.size());
                h2.append(" queued tasks");
                h2.toString();
            }
            if (!aVar.f1480d.isEmpty()) {
                if (aVar.b) {
                    z = true;
                } else {
                    boolean bindService = this.a.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(aVar.a), this, 33);
                    aVar.b = bindService;
                    if (bindService) {
                        aVar.f1481e = 0;
                    } else {
                        StringBuilder h3 = f.a.a.a.a.h("Unable to bind to listener ");
                        h3.append(aVar.a);
                        h3.toString();
                        this.a.unbindService(this);
                    }
                    z = aVar.b;
                }
                if (!z || aVar.c == null) {
                    b(aVar);
                    return;
                }
                while (true) {
                    d peek = aVar.f1480d.peek();
                    if (peek == null) {
                        break;
                    }
                    try {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            String str2 = "Sending task " + peek;
                        }
                        peek.a(aVar.c);
                        aVar.f1480d.remove();
                    } catch (DeadObjectException unused) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            sb = new StringBuilder();
                            str = "Remote service has died: ";
                            sb.append(str);
                            sb.append(aVar.a);
                            sb.toString();
                        }
                    } catch (RemoteException unused2) {
                        sb = new StringBuilder();
                        str = "RemoteException communicating with ";
                        sb.append(str);
                        sb.append(aVar.a);
                        sb.toString();
                        if (aVar.f1480d.isEmpty()) {
                        }
                    }
                }
                if (aVar.f1480d.isEmpty()) {
                    b(aVar);
                }
            }
        }

        public final void b(a aVar) {
            if (!this.c.hasMessages(3, aVar.a)) {
                int i2 = aVar.f1481e + 1;
                aVar.f1481e = i2;
                if (i2 > 6) {
                    StringBuilder h2 = f.a.a.a.a.h("Giving up on delivering ");
                    h2.append(aVar.f1480d.size());
                    h2.append(" tasks to ");
                    h2.append(aVar.a);
                    h2.append(" after ");
                    h2.append(aVar.f1481e);
                    h2.append(" retries");
                    h2.toString();
                    aVar.f1480d.clear();
                    return;
                }
                this.c.sendMessageDelayed(this.c.obtainMessage(3, aVar.a), (long) ((1 << (i2 - 1)) * 1000));
            }
        }

        public boolean handleMessage(Message message) {
            Set<String> set;
            int i2 = message.what;
            d.a.a.a.a aVar = null;
            if (i2 == 0) {
                d dVar = (d) message.obj;
                String string = Settings.Secure.getString(this.a.getContentResolver(), "enabled_notification_listeners");
                synchronized (n.c) {
                    if (string != null) {
                        if (!string.equals(n.f1473d)) {
                            String[] split = string.split(":", -1);
                            HashSet hashSet = new HashSet(split.length);
                            for (String str : split) {
                                ComponentName unflattenFromString = ComponentName.unflattenFromString(str);
                                if (unflattenFromString != null) {
                                    hashSet.add(unflattenFromString.getPackageName());
                                }
                            }
                            n.f1474e = hashSet;
                            n.f1473d = string;
                        }
                    }
                    set = n.f1474e;
                }
                if (!set.equals(this.f1479e)) {
                    this.f1479e = set;
                    List<ResolveInfo> queryIntentServices = this.a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
                    HashSet hashSet2 = new HashSet();
                    for (ResolveInfo resolveInfo : queryIntentServices) {
                        if (set.contains(resolveInfo.serviceInfo.packageName)) {
                            ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                            ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                            if (resolveInfo.serviceInfo.permission != null) {
                                String str2 = "Permission present on component " + componentName + ", not adding listener record.";
                            } else {
                                hashSet2.add(componentName);
                            }
                        }
                    }
                    Iterator it = hashSet2.iterator();
                    while (it.hasNext()) {
                        ComponentName componentName2 = (ComponentName) it.next();
                        if (!this.f1478d.containsKey(componentName2)) {
                            if (Log.isLoggable("NotifManCompat", 3)) {
                                String str3 = "Adding listener record for " + componentName2;
                            }
                            this.f1478d.put(componentName2, new a(componentName2));
                        }
                    }
                    Iterator<Map.Entry<ComponentName, a>> it2 = this.f1478d.entrySet().iterator();
                    while (it2.hasNext()) {
                        Map.Entry<ComponentName, a> next = it2.next();
                        if (!hashSet2.contains(next.getKey())) {
                            if (Log.isLoggable("NotifManCompat", 3)) {
                                StringBuilder h2 = f.a.a.a.a.h("Removing listener record for ");
                                h2.append(next.getKey());
                                h2.toString();
                            }
                            a value = next.getValue();
                            if (value.b) {
                                this.a.unbindService(this);
                                value.b = false;
                            }
                            value.c = null;
                            it2.remove();
                        }
                    }
                }
                for (a aVar2 : this.f1478d.values()) {
                    aVar2.f1480d.add(dVar);
                    a(aVar2);
                }
                return true;
            } else if (i2 == 1) {
                b bVar = (b) message.obj;
                ComponentName componentName3 = bVar.a;
                IBinder iBinder = bVar.b;
                a aVar3 = this.f1478d.get(componentName3);
                if (aVar3 != null) {
                    int i3 = a.AbstractBinderC0008a.a;
                    if (iBinder != null) {
                        IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.app.INotificationSideChannel");
                        aVar = (queryLocalInterface == null || !(queryLocalInterface instanceof d.a.a.a.a)) ? new a.AbstractBinderC0008a.C0009a(iBinder) : (d.a.a.a.a) queryLocalInterface;
                    }
                    aVar3.c = aVar;
                    aVar3.f1481e = 0;
                    a(aVar3);
                }
                return true;
            } else if (i2 == 2) {
                a aVar4 = this.f1478d.get((ComponentName) message.obj);
                if (aVar4 != null) {
                    if (aVar4.b) {
                        this.a.unbindService(this);
                        aVar4.b = false;
                    }
                    aVar4.c = null;
                }
                return true;
            } else if (i2 != 3) {
                return false;
            } else {
                a aVar5 = this.f1478d.get((ComponentName) message.obj);
                if (aVar5 != null) {
                    a(aVar5);
                }
                return true;
            }
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                String str = "Connected to service " + componentName;
            }
            this.c.obtainMessage(1, new b(componentName, iBinder)).sendToTarget();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                String str = "Disconnected from service " + componentName;
            }
            this.c.obtainMessage(2, componentName).sendToTarget();
        }
    }

    public interface d {
        void a(d.a.a.a.a aVar);
    }

    public n(Context context) {
        this.a = context;
        this.b = (NotificationManager) context.getSystemService("notification");
    }

    public void a(int i2, Notification notification) {
        Bundle bundle = notification.extras;
        if (bundle != null && bundle.getBoolean("android.support.useSideChannel")) {
            b(new a(this.a.getPackageName(), i2, null, notification));
            this.b.cancel(null, i2);
            return;
        }
        this.b.notify(null, i2, notification);
    }

    public final void b(d dVar) {
        synchronized (f1475f) {
            if (f1476g == null) {
                f1476g = new c(this.a.getApplicationContext());
            }
            f1476g.c.obtainMessage(0, dVar).sendToTarget();
        }
    }
}
