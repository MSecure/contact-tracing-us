package b.i.d;

import a.a.a.a.a;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class l {

    /* renamed from: c  reason: collision with root package name */
    public static final Object f1690c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public static String f1691d;

    /* renamed from: e  reason: collision with root package name */
    public static Set<String> f1692e = new HashSet();

    /* renamed from: f  reason: collision with root package name */
    public static final Object f1693f = new Object();

    /* renamed from: g  reason: collision with root package name */
    public static c f1694g;

    /* renamed from: a  reason: collision with root package name */
    public final Context f1695a;

    /* renamed from: b  reason: collision with root package name */
    public final NotificationManager f1696b;

    public static class a implements d {

        /* renamed from: a  reason: collision with root package name */
        public final String f1697a;

        /* renamed from: b  reason: collision with root package name */
        public final int f1698b;

        /* renamed from: c  reason: collision with root package name */
        public final String f1699c;

        /* renamed from: d  reason: collision with root package name */
        public final Notification f1700d;

        public a(String str, int i, String str2, Notification notification) {
            this.f1697a = str;
            this.f1698b = i;
            this.f1699c = str2;
            this.f1700d = notification;
        }

        @Override // b.i.d.l.d
        public void a(a.a.a.a.a aVar) {
            aVar.K(this.f1697a, this.f1698b, this.f1699c, this.f1700d);
        }

        public String toString() {
            return "NotifyTask[" + "packageName:" + this.f1697a + ", id:" + this.f1698b + ", tag:" + this.f1699c + "]";
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final ComponentName f1701a;

        /* renamed from: b  reason: collision with root package name */
        public final IBinder f1702b;

        public b(ComponentName componentName, IBinder iBinder) {
            this.f1701a = componentName;
            this.f1702b = iBinder;
        }
    }

    public static class c implements Handler.Callback, ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        public final Context f1703a;

        /* renamed from: b  reason: collision with root package name */
        public final HandlerThread f1704b;

        /* renamed from: c  reason: collision with root package name */
        public final Handler f1705c;

        /* renamed from: d  reason: collision with root package name */
        public final Map<ComponentName, a> f1706d = new HashMap();

        /* renamed from: e  reason: collision with root package name */
        public Set<String> f1707e = new HashSet();

        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public final ComponentName f1708a;

            /* renamed from: b  reason: collision with root package name */
            public boolean f1709b = false;

            /* renamed from: c  reason: collision with root package name */
            public a.a.a.a.a f1710c;

            /* renamed from: d  reason: collision with root package name */
            public ArrayDeque<d> f1711d = new ArrayDeque<>();

            /* renamed from: e  reason: collision with root package name */
            public int f1712e = 0;

            public a(ComponentName componentName) {
                this.f1708a = componentName;
            }
        }

        public c(Context context) {
            this.f1703a = context;
            HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
            this.f1704b = handlerThread;
            handlerThread.start();
            this.f1705c = new Handler(this.f1704b.getLooper(), this);
        }

        /* JADX WARNING: Removed duplicated region for block: B:33:0x00c6  */
        /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
        public final void a(a aVar) {
            boolean z;
            String str;
            StringBuilder sb;
            if (Log.isLoggable("NotifManCompat", 3)) {
                StringBuilder h = c.a.a.a.a.h("Processing component ");
                h.append(aVar.f1708a);
                h.append(", ");
                h.append(aVar.f1711d.size());
                h.append(" queued tasks");
                h.toString();
            }
            if (!aVar.f1711d.isEmpty()) {
                if (aVar.f1709b) {
                    z = true;
                } else {
                    boolean bindService = this.f1703a.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(aVar.f1708a), this, 33);
                    aVar.f1709b = bindService;
                    if (bindService) {
                        aVar.f1712e = 0;
                    } else {
                        StringBuilder h2 = c.a.a.a.a.h("Unable to bind to listener ");
                        h2.append(aVar.f1708a);
                        h2.toString();
                        this.f1703a.unbindService(this);
                    }
                    z = aVar.f1709b;
                }
                if (!z || aVar.f1710c == null) {
                    b(aVar);
                    return;
                }
                while (true) {
                    d peek = aVar.f1711d.peek();
                    if (peek == null) {
                        break;
                    }
                    try {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            String str2 = "Sending task " + peek;
                        }
                        peek.a(aVar.f1710c);
                        aVar.f1711d.remove();
                    } catch (DeadObjectException unused) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            sb = new StringBuilder();
                            str = "Remote service has died: ";
                            sb.append(str);
                            sb.append(aVar.f1708a);
                            sb.toString();
                        }
                    } catch (RemoteException unused2) {
                        sb = new StringBuilder();
                        str = "RemoteException communicating with ";
                        sb.append(str);
                        sb.append(aVar.f1708a);
                        sb.toString();
                        if (aVar.f1711d.isEmpty()) {
                        }
                    }
                }
                if (aVar.f1711d.isEmpty()) {
                    b(aVar);
                }
            }
        }

        public final void b(a aVar) {
            if (!this.f1705c.hasMessages(3, aVar.f1708a)) {
                int i = aVar.f1712e + 1;
                aVar.f1712e = i;
                if (i > 6) {
                    StringBuilder h = c.a.a.a.a.h("Giving up on delivering ");
                    h.append(aVar.f1711d.size());
                    h.append(" tasks to ");
                    h.append(aVar.f1708a);
                    h.append(" after ");
                    h.append(aVar.f1712e);
                    h.append(" retries");
                    h.toString();
                    aVar.f1711d.clear();
                    return;
                }
                this.f1705c.sendMessageDelayed(this.f1705c.obtainMessage(3, aVar.f1708a), (long) ((1 << (i - 1)) * 1000));
            }
        }

        public boolean handleMessage(Message message) {
            Set<String> set;
            int i = message.what;
            if (i == 0) {
                d dVar = (d) message.obj;
                String string = Settings.Secure.getString(this.f1703a.getContentResolver(), "enabled_notification_listeners");
                synchronized (l.f1690c) {
                    if (string != null) {
                        if (!string.equals(l.f1691d)) {
                            String[] split = string.split(":", -1);
                            HashSet hashSet = new HashSet(split.length);
                            for (String str : split) {
                                ComponentName unflattenFromString = ComponentName.unflattenFromString(str);
                                if (unflattenFromString != null) {
                                    hashSet.add(unflattenFromString.getPackageName());
                                }
                            }
                            l.f1692e = hashSet;
                            l.f1691d = string;
                        }
                    }
                    set = l.f1692e;
                }
                if (!set.equals(this.f1707e)) {
                    this.f1707e = set;
                    List<ResolveInfo> queryIntentServices = this.f1703a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
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
                        if (!this.f1706d.containsKey(componentName2)) {
                            if (Log.isLoggable("NotifManCompat", 3)) {
                                String str3 = "Adding listener record for " + componentName2;
                            }
                            this.f1706d.put(componentName2, new a(componentName2));
                        }
                    }
                    Iterator<Map.Entry<ComponentName, a>> it2 = this.f1706d.entrySet().iterator();
                    while (it2.hasNext()) {
                        Map.Entry<ComponentName, a> next = it2.next();
                        if (!hashSet2.contains(next.getKey())) {
                            if (Log.isLoggable("NotifManCompat", 3)) {
                                StringBuilder h = c.a.a.a.a.h("Removing listener record for ");
                                h.append(next.getKey());
                                h.toString();
                            }
                            a value = next.getValue();
                            if (value.f1709b) {
                                this.f1703a.unbindService(this);
                                value.f1709b = false;
                            }
                            value.f1710c = null;
                            it2.remove();
                        }
                    }
                }
                for (a aVar : this.f1706d.values()) {
                    aVar.f1711d.add(dVar);
                    a(aVar);
                }
                return true;
            } else if (i == 1) {
                b bVar = (b) message.obj;
                ComponentName componentName3 = bVar.f1701a;
                IBinder iBinder = bVar.f1702b;
                a aVar2 = this.f1706d.get(componentName3);
                if (aVar2 != null) {
                    aVar2.f1710c = a.AbstractBinderC0000a.e0(iBinder);
                    aVar2.f1712e = 0;
                    a(aVar2);
                }
                return true;
            } else if (i == 2) {
                a aVar3 = this.f1706d.get((ComponentName) message.obj);
                if (aVar3 != null) {
                    if (aVar3.f1709b) {
                        this.f1703a.unbindService(this);
                        aVar3.f1709b = false;
                    }
                    aVar3.f1710c = null;
                }
                return true;
            } else if (i != 3) {
                return false;
            } else {
                a aVar4 = this.f1706d.get((ComponentName) message.obj);
                if (aVar4 != null) {
                    a(aVar4);
                }
                return true;
            }
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                String str = "Connected to service " + componentName;
            }
            this.f1705c.obtainMessage(1, new b(componentName, iBinder)).sendToTarget();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                String str = "Disconnected from service " + componentName;
            }
            this.f1705c.obtainMessage(2, componentName).sendToTarget();
        }
    }

    public interface d {
        void a(a.a.a.a.a aVar);
    }

    public l(Context context) {
        this.f1695a = context;
        this.f1696b = (NotificationManager) context.getSystemService("notification");
    }
}
