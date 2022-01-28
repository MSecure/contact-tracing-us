package f.b.c;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserManager;
import com.google.firebase.components.ComponentDiscoveryService;
import e.b.a.m;
import f.b.a.c.b.l.l.c;
import f.b.a.c.b.m.l;
import f.b.c.f.d;
import f.b.c.f.g;
import f.b.c.f.k;
import f.b.c.f.o;
import f.b.c.f.r;
import f.b.c.f.s;
import f.b.c.f.t;
import f.b.c.n.f;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class a {

    /* renamed from: i  reason: collision with root package name */
    public static final Object f3206i = new Object();

    /* renamed from: j  reason: collision with root package name */
    public static final Executor f3207j = new d(null);

    /* renamed from: k  reason: collision with root package name */
    public static final Map<String, a> f3208k = new e.e.a();
    public final Context a;
    public final String b;
    public final c c;

    /* renamed from: d  reason: collision with root package name */
    public final k f3209d;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicBoolean f3210e = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    public final AtomicBoolean f3211f = new AtomicBoolean();

    /* renamed from: g  reason: collision with root package name */
    public final List<b> f3212g = new CopyOnWriteArrayList();

    /* renamed from: h  reason: collision with root package name */
    public final List<Object> f3213h = new CopyOnWriteArrayList();

    public interface b {
        void a(boolean z);
    }

    public static class c implements c.a {
        public static AtomicReference<c> a = new AtomicReference<>();

        @Override // f.b.a.c.b.l.l.c.a
        public void a(boolean z) {
            Object obj = a.f3206i;
            synchronized (a.f3206i) {
                Iterator it = new ArrayList(a.f3208k.values()).iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    if (aVar.f3210e.get()) {
                        for (b bVar : aVar.f3212g) {
                            bVar.a(z);
                        }
                    }
                }
            }
        }
    }

    public static class d implements Executor {
        public static final Handler b = new Handler(Looper.getMainLooper());

        public d(C0110a aVar) {
        }

        public void execute(Runnable runnable) {
            b.post(runnable);
        }
    }

    public static class e extends BroadcastReceiver {
        public static AtomicReference<e> b = new AtomicReference<>();
        public final Context a;

        public e(Context context) {
            this.a = context;
        }

        public void onReceive(Context context, Intent intent) {
            Object obj = a.f3206i;
            synchronized (a.f3206i) {
                for (a aVar : a.f3208k.values()) {
                    aVar.c();
                }
            }
            this.a.unregisterReceiver(this);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0152  */
    public a(Context context, String str, c cVar) {
        Bundle bundle;
        List<String> list;
        String str2;
        Objects.requireNonNull(context, "null reference");
        this.a = context;
        m.e.o(str);
        this.b = str;
        Objects.requireNonNull(cVar, "null reference");
        this.c = cVar;
        f.b.c.f.d<?> dVar = null;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, ComponentDiscoveryService.class), 128);
                if (serviceInfo == null) {
                    String str3 = ComponentDiscoveryService.class + " has no service info.";
                } else {
                    bundle = serviceInfo.metaData;
                    if (bundle != null) {
                        list = Collections.emptyList();
                    } else {
                        ArrayList arrayList = new ArrayList();
                        for (String str4 : bundle.keySet()) {
                            if ("com.google.firebase.components.ComponentRegistrar".equals(bundle.get(str4)) && str4.startsWith("com.google.firebase.components:")) {
                                arrayList.add(str4.substring(31));
                            }
                        }
                        list = arrayList;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (String str5 : list) {
                        try {
                            Class<?> cls = Class.forName(str5);
                            if (!g.class.isAssignableFrom(cls)) {
                                String.format("Class %s is not an instance of %s", str5, "com.google.firebase.components.ComponentRegistrar");
                            } else {
                                arrayList2.add((g) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                            }
                        } catch (ClassNotFoundException unused) {
                            String.format("Class %s is not an found.", str5);
                        } catch (IllegalAccessException unused2) {
                            String.format("Could not instantiate %s.", str5);
                        } catch (InstantiationException unused3) {
                            String.format("Could not instantiate %s.", str5);
                        } catch (NoSuchMethodException unused4) {
                            String.format("Could not instantiate %s", str5);
                        } catch (InvocationTargetException unused5) {
                            String.format("Could not instantiate %s", str5);
                        }
                    }
                    str2 = j.a.f4311f.toString();
                    Executor executor = f3207j;
                    f.b.c.f.d[] dVarArr = new f.b.c.f.d[8];
                    dVarArr[0] = f.b.c.f.d.c(context, Context.class, new Class[0]);
                    dVarArr[1] = f.b.c.f.d.c(this, a.class, new Class[0]);
                    dVarArr[2] = f.b.c.f.d.c(cVar, c.class, new Class[0]);
                    dVarArr[3] = f.b.a.c.b.o.b.I("fire-android", "");
                    dVarArr[4] = f.b.a.c.b.o.b.I("fire-core", "19.3.1");
                    dVarArr[5] = str2 != null ? f.b.a.c.b.o.b.I("kotlin", str2) : dVar;
                    d.b a2 = f.b.c.f.d.a(f.class);
                    a2.a(new o(f.b.c.n.e.class, 2, 0));
                    a2.c(f.b.c.n.b.a);
                    dVarArr[6] = a2.b();
                    d.b a3 = f.b.c.f.d.a(f.b.c.l.c.class);
                    a3.a(new o(Context.class, 1, 0));
                    a3.c(f.b.c.l.a.a);
                    dVarArr[7] = a3.b();
                    this.f3209d = new k(executor, arrayList2, dVarArr);
                }
            }
        } catch (PackageManager.NameNotFoundException unused6) {
        }
        bundle = null;
        if (bundle != null) {
        }
        ArrayList arrayList22 = new ArrayList();
        while (r13.hasNext()) {
        }
        try {
            str2 = j.a.f4311f.toString();
        } catch (NoClassDefFoundError unused7) {
            str2 = null;
        }
        Executor executor2 = f3207j;
        f.b.c.f.d[] dVarArr2 = new f.b.c.f.d[8];
        dVarArr2[0] = f.b.c.f.d.c(context, Context.class, new Class[0]);
        dVarArr2[1] = f.b.c.f.d.c(this, a.class, new Class[0]);
        dVarArr2[2] = f.b.c.f.d.c(cVar, c.class, new Class[0]);
        dVarArr2[3] = f.b.a.c.b.o.b.I("fire-android", "");
        dVarArr2[4] = f.b.a.c.b.o.b.I("fire-core", "19.3.1");
        dVarArr2[5] = str2 != null ? f.b.a.c.b.o.b.I("kotlin", str2) : dVar;
        d.b a22 = f.b.c.f.d.a(f.class);
        a22.a(new o(f.b.c.n.e.class, 2, 0));
        a22.c(f.b.c.n.b.a);
        dVarArr2[6] = a22.b();
        d.b a32 = f.b.c.f.d.a(f.b.c.l.c.class);
        a32.a(new o(Context.class, 1, 0));
        a32.c(f.b.c.l.a.a);
        dVarArr2[7] = a32.b();
        this.f3209d = new k(executor2, arrayList22, dVarArr2);
    }

    public static a b() {
        a aVar;
        synchronized (f3206i) {
            aVar = f3208k.get("[DEFAULT]");
            if (aVar == null) {
                throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + f.b.a.c.b.o.d.a() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
            }
        }
        return aVar;
    }

    public static a d(Context context) {
        synchronized (f3206i) {
            if (f3208k.containsKey("[DEFAULT]")) {
                return b();
            }
            c a2 = c.a(context);
            if (a2 == null) {
                return null;
            }
            return e(context, a2);
        }
    }

    public static a e(Context context, c cVar) {
        a aVar;
        AtomicReference<c> atomicReference = c.a;
        if (context.getApplicationContext() instanceof Application) {
            Application application = (Application) context.getApplicationContext();
            if (c.a.get() == null) {
                c cVar2 = new c();
                if (c.a.compareAndSet(null, cVar2)) {
                    f.b.a.c.b.l.l.c.a(application);
                    f.b.a.c.b.l.l.c cVar3 = f.b.a.c.b.l.l.c.f2634f;
                    Objects.requireNonNull(cVar3);
                    synchronized (cVar3) {
                        cVar3.f2635d.add(cVar2);
                    }
                }
            }
        }
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (f3206i) {
            Map<String, a> map = f3208k;
            m.e.t(!map.containsKey("[DEFAULT]"), "FirebaseApp name [DEFAULT] already exists!");
            m.e.r(context, "Application context cannot be null.");
            aVar = new a(context, "[DEFAULT]", cVar);
            map.put("[DEFAULT]", aVar);
        }
        aVar.c();
        return aVar;
    }

    public final void a() {
        m.e.t(!this.f3211f.get(), "FirebaseApp was deleted");
    }

    public final void c() {
        Queue<f.b.c.j.a<?>> queue;
        Set<Map.Entry<f.b.c.j.b<Object>, Executor>> emptySet;
        if (!(Build.VERSION.SDK_INT >= 24 ? ((UserManager) this.a.getSystemService(UserManager.class)).isUserUnlocked() : true)) {
            a();
            Context context = this.a;
            if (e.b.get() == null) {
                e eVar = new e(context);
                if (e.b.compareAndSet(null, eVar)) {
                    context.registerReceiver(eVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                    return;
                }
                return;
            }
            return;
        }
        a();
        k kVar = this.f3209d;
        a();
        boolean equals = "[DEFAULT]".equals(this.b);
        for (Map.Entry<f.b.c.f.d<?>, t<?>> entry : kVar.a.entrySet()) {
            t<?> value = entry.getValue();
            int i2 = entry.getKey().c;
            boolean z = false;
            if (!(i2 == 1)) {
                if (i2 == 2) {
                    z = true;
                }
                if (z) {
                    if (!equals) {
                    }
                }
            }
            value.get();
        }
        s sVar = kVar.f3224d;
        synchronized (sVar) {
            queue = sVar.b;
            if (queue != null) {
                sVar.b = null;
            } else {
                queue = null;
            }
        }
        if (queue != null) {
            for (f.b.c.j.a<?> aVar : queue) {
                Objects.requireNonNull(aVar);
                synchronized (sVar) {
                    Queue<f.b.c.j.a<?>> queue2 = sVar.b;
                    if (queue2 != null) {
                        queue2.add(aVar);
                    } else {
                        synchronized (sVar) {
                            ConcurrentHashMap<f.b.c.j.b<Object>, Executor> concurrentHashMap = sVar.a.get(null);
                            emptySet = concurrentHashMap == null ? Collections.emptySet() : concurrentHashMap.entrySet();
                        }
                        for (Map.Entry<f.b.c.j.b<Object>, Executor> entry2 : emptySet) {
                            entry2.getValue().execute(new r(entry2, aVar));
                        }
                    }
                }
            }
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        String str = this.b;
        a aVar = (a) obj;
        aVar.a();
        return str.equals(aVar.b);
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        l lVar = new l(this, null);
        lVar.a("name", this.b);
        lVar.a("options", this.c);
        return lVar.toString();
    }
}
