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
import android.os.Bundle;
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

public final class k {

    /* renamed from: c  reason: collision with root package name */
    public static final Object f997c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public static String f998d;

    /* renamed from: e  reason: collision with root package name */
    public static Set<String> f999e = new HashSet();
    public static final Object f = new Object();
    public static c g;

    /* renamed from: a  reason: collision with root package name */
    public final Context f1000a;

    /* renamed from: b  reason: collision with root package name */
    public final NotificationManager f1001b;

    public static class a implements d {

        /* renamed from: a  reason: collision with root package name */
        public final String f1002a;

        /* renamed from: b  reason: collision with root package name */
        public final int f1003b;

        /* renamed from: c  reason: collision with root package name */
        public final String f1004c;

        /* renamed from: d  reason: collision with root package name */
        public final Notification f1005d;

        public a(String str, int i, String str2, Notification notification) {
            this.f1002a = str;
            this.f1003b = i;
            this.f1004c = str2;
            this.f1005d = notification;
        }

        @Override // b.i.d.k.d
        public void a(a.a.a.a.a aVar) {
            aVar.N(this.f1002a, this.f1003b, this.f1004c, this.f1005d);
        }

        public String toString() {
            return "NotifyTask[" + "packageName:" + this.f1002a + ", id:" + this.f1003b + ", tag:" + this.f1004c + "]";
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final ComponentName f1006a;

        /* renamed from: b  reason: collision with root package name */
        public final IBinder f1007b;

        public b(ComponentName componentName, IBinder iBinder) {
            this.f1006a = componentName;
            this.f1007b = iBinder;
        }
    }

    public static class c implements Handler.Callback, ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        public final Context f1008a;

        /* renamed from: b  reason: collision with root package name */
        public final HandlerThread f1009b;

        /* renamed from: c  reason: collision with root package name */
        public final Handler f1010c;

        /* renamed from: d  reason: collision with root package name */
        public final Map<ComponentName, a> f1011d = new HashMap();

        /* renamed from: e  reason: collision with root package name */
        public Set<String> f1012e = new HashSet();

        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public final ComponentName f1013a;

            /* renamed from: b  reason: collision with root package name */
            public boolean f1014b = false;

            /* renamed from: c  reason: collision with root package name */
            public a.a.a.a.a f1015c;

            /* renamed from: d  reason: collision with root package name */
            public ArrayDeque<d> f1016d = new ArrayDeque<>();

            /* renamed from: e  reason: collision with root package name */
            public int f1017e = 0;

            public a(ComponentName componentName) {
                this.f1013a = componentName;
            }
        }

        public c(Context context) {
            this.f1008a = context;
            HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
            this.f1009b = handlerThread;
            handlerThread.start();
            this.f1010c = new Handler(this.f1009b.getLooper(), this);
        }

        /* JADX WARNING: Removed duplicated region for block: B:33:0x00c6  */
        /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
        public final void a(a aVar) {
            boolean z;
            String str;
            StringBuilder sb;
            if (Log.isLoggable("NotifManCompat", 3)) {
                StringBuilder g = c.a.a.a.a.g("Processing component ");
                g.append(aVar.f1013a);
                g.append(", ");
                g.append(aVar.f1016d.size());
                g.append(" queued tasks");
                g.toString();
            }
            if (!aVar.f1016d.isEmpty()) {
                if (aVar.f1014b) {
                    z = true;
                } else {
                    boolean bindService = this.f1008a.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(aVar.f1013a), this, 33);
                    aVar.f1014b = bindService;
                    if (bindService) {
                        aVar.f1017e = 0;
                    } else {
                        StringBuilder g2 = c.a.a.a.a.g("Unable to bind to listener ");
                        g2.append(aVar.f1013a);
                        g2.toString();
                        this.f1008a.unbindService(this);
                    }
                    z = aVar.f1014b;
                }
                if (!z || aVar.f1015c == null) {
                    b(aVar);
                    return;
                }
                while (true) {
                    d peek = aVar.f1016d.peek();
                    if (peek == null) {
                        break;
                    }
                    try {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            String str2 = "Sending task " + peek;
                        }
                        peek.a(aVar.f1015c);
                        aVar.f1016d.remove();
                    } catch (DeadObjectException unused) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            sb = new StringBuilder();
                            str = "Remote service has died: ";
                            sb.append(str);
                            sb.append(aVar.f1013a);
                            sb.toString();
                        }
                    } catch (RemoteException unused2) {
                        sb = new StringBuilder();
                        str = "RemoteException communicating with ";
                        sb.append(str);
                        sb.append(aVar.f1013a);
                        sb.toString();
                        if (aVar.f1016d.isEmpty()) {
                        }
                    }
                }
                if (aVar.f1016d.isEmpty()) {
                    b(aVar);
                }
            }
        }

        public final void b(a aVar) {
            if (!this.f1010c.hasMessages(3, aVar.f1013a)) {
                int i = aVar.f1017e + 1;
                aVar.f1017e = i;
                if (i > 6) {
                    StringBuilder g = c.a.a.a.a.g("Giving up on delivering ");
                    g.append(aVar.f1016d.size());
                    g.append(" tasks to ");
                    g.append(aVar.f1013a);
                    g.append(" after ");
                    g.append(aVar.f1017e);
                    g.append(" retries");
                    g.toString();
                    aVar.f1016d.clear();
                    return;
                }
                this.f1010c.sendMessageDelayed(this.f1010c.obtainMessage(3, aVar.f1013a), (long) ((1 << (i - 1)) * 1000));
            }
        }

        public boolean handleMessage(Message message) {
            Set<String> set;
            int i = message.what;
            if (i == 0) {
                d dVar = (d) message.obj;
                String string = Settings.Secure.getString(this.f1008a.getContentResolver(), "enabled_notification_listeners");
                synchronized (k.f997c) {
                    if (string != null) {
                        if (!string.equals(k.f998d)) {
                            String[] split = string.split(":", -1);
                            HashSet hashSet = new HashSet(split.length);
                            for (String str : split) {
                                ComponentName unflattenFromString = ComponentName.unflattenFromString(str);
                                if (unflattenFromString != null) {
                                    hashSet.add(unflattenFromString.getPackageName());
                                }
                            }
                            k.f999e = hashSet;
                            k.f998d = string;
                        }
                    }
                    set = k.f999e;
                }
                if (!set.equals(this.f1012e)) {
                    this.f1012e = set;
                    List<ResolveInfo> queryIntentServices = this.f1008a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
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
                        if (!this.f1011d.containsKey(componentName2)) {
                            if (Log.isLoggable("NotifManCompat", 3)) {
                                String str3 = "Adding listener record for " + componentName2;
                            }
                            this.f1011d.put(componentName2, new a(componentName2));
                        }
                    }
                    Iterator<Map.Entry<ComponentName, a>> it2 = this.f1011d.entrySet().iterator();
                    while (it2.hasNext()) {
                        Map.Entry<ComponentName, a> next = it2.next();
                        if (!hashSet2.contains(next.getKey())) {
                            if (Log.isLoggable("NotifManCompat", 3)) {
                                StringBuilder g = c.a.a.a.a.g("Removing listener record for ");
                                g.append(next.getKey());
                                g.toString();
                            }
                            a value = next.getValue();
                            if (value.f1014b) {
                                this.f1008a.unbindService(this);
                                value.f1014b = false;
                            }
                            value.f1015c = null;
                            it2.remove();
                        }
                    }
                }
                for (a aVar : this.f1011d.values()) {
                    aVar.f1016d.add(dVar);
                    a(aVar);
                }
                return true;
            } else if (i == 1) {
                b bVar = (b) message.obj;
                ComponentName componentName3 = bVar.f1006a;
                IBinder iBinder = bVar.f1007b;
                a aVar2 = this.f1011d.get(componentName3);
                if (aVar2 != null) {
                    aVar2.f1015c = a.AbstractBinderC0000a.c(iBinder);
                    aVar2.f1017e = 0;
                    a(aVar2);
                }
                return true;
            } else if (i == 2) {
                a aVar3 = this.f1011d.get((ComponentName) message.obj);
                if (aVar3 != null) {
                    if (aVar3.f1014b) {
                        this.f1008a.unbindService(this);
                        aVar3.f1014b = false;
                    }
                    aVar3.f1015c = null;
                }
                return true;
            } else if (i != 3) {
                return false;
            } else {
                a aVar4 = this.f1011d.get((ComponentName) message.obj);
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
            this.f1010c.obtainMessage(1, new b(componentName, iBinder)).sendToTarget();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                String str = "Disconnected from service " + componentName;
            }
            this.f1010c.obtainMessage(2, componentName).sendToTarget();
        }
    }

    public interface d {
        void a(a.a.a.a.a aVar);
    }

    public k(Context context) {
        this.f1000a = context;
        this.f1001b = (NotificationManager) context.getSystemService("notification");
    }

    public void a(int i, Notification notification) {
        Bundle bundle = notification.extras;
        if (bundle != null && bundle.getBoolean("android.support.useSideChannel")) {
            a aVar = new a(this.f1000a.getPackageName(), i, null, notification);
            synchronized (f) {
                if (g == null) {
                    g = new c(this.f1000a.getApplicationContext());
                }
                g.f1010c.obtainMessage(0, aVar).sendToTarget();
            }
            this.f1001b.cancel(null, i);
            return;
        }
        this.f1001b.notify(null, i, notification);
    }
}
