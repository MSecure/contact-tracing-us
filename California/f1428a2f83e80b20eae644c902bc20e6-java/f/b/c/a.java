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
import android.util.Log;
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
    public static final Object f2944i = new Object();

    /* renamed from: j  reason: collision with root package name */
    public static final Executor f2945j = new d(null);

    /* renamed from: k  reason: collision with root package name */
    public static final Map<String, a> f2946k = new e.e.a();
    public final Context a;
    public final String b;
    public final c c;

    /* renamed from: d  reason: collision with root package name */
    public final k f2947d;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicBoolean f2948e = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    public final AtomicBoolean f2949f = new AtomicBoolean();

    /* renamed from: g  reason: collision with root package name */
    public final List<b> f2950g = new CopyOnWriteArrayList();

    /* renamed from: h  reason: collision with root package name */
    public final List<Object> f2951h = new CopyOnWriteArrayList();

    public interface b {
        void a(boolean z);
    }

    public static class c implements c.a {
        public static AtomicReference<c> a = new AtomicReference<>();

        @Override // f.b.a.c.b.l.l.c.a
        public void a(boolean z) {
            Object obj = a.f2944i;
            synchronized (a.f2944i) {
                Iterator it = new ArrayList(a.f2946k.values()).iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    if (aVar.f2948e.get()) {
                        for (b bVar : aVar.f2950g) {
                            bVar.a(z);
                        }
                    }
                }
            }
        }
    }

    public static class d implements Executor {
        public static final Handler b = new Handler(Looper.getMainLooper());

        public d(C0107a aVar) {
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
            Object obj = a.f2944i;
            synchronized (a.f2944i) {
                for (a aVar : a.f2946k.values()) {
                    aVar.c();
                }
            }
            this.a.unregisterReceiver(this);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0175  */
    public a(Context context, String str, c cVar) {
        Bundle bundle;
        List<String> list;
        String str2;
        Throwable e2;
        String str3;
        String str4;
        Objects.requireNonNull(context, "null reference");
        this.a = context;
        m.h.m(str);
        this.b = str;
        Objects.requireNonNull(cVar, "null reference");
        this.c = cVar;
        f.b.c.f.d<?> dVar = null;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                str4 = "Context has no PackageManager.";
            } else {
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, ComponentDiscoveryService.class), 128);
                if (serviceInfo == null) {
                    str4 = ComponentDiscoveryService.class + " has no service info.";
                } else {
                    bundle = serviceInfo.metaData;
                    if (bundle != null) {
                        Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
                        list = Collections.emptyList();
                    } else {
                        ArrayList arrayList = new ArrayList();
                        for (String str5 : bundle.keySet()) {
                            if ("com.google.firebase.components.ComponentRegistrar".equals(bundle.get(str5)) && str5.startsWith("com.google.firebase.components:")) {
                                arrayList.add(str5.substring(31));
                            }
                        }
                        list = arrayList;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (String str6 : list) {
                        try {
                            Class<?> cls = Class.forName(str6);
                            if (!g.class.isAssignableFrom(cls)) {
                                Log.w("ComponentDiscovery", String.format("Class %s is not an instance of %s", str6, "com.google.firebase.components.ComponentRegistrar"));
                            } else {
                                arrayList2.add((g) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                            }
                        } catch (ClassNotFoundException e3) {
                            e2 = e3;
                            str3 = String.format("Class %s is not an found.", str6);
                            Log.w("ComponentDiscovery", str3, e2);
                        } catch (IllegalAccessException e4) {
                            e2 = e4;
                            str3 = String.format("Could not instantiate %s.", str6);
                            Log.w("ComponentDiscovery", str3, e2);
                        } catch (InstantiationException e5) {
                            e2 = e5;
                            str3 = String.format("Could not instantiate %s.", str6);
                            Log.w("ComponentDiscovery", str3, e2);
                        } catch (NoSuchMethodException e6) {
                            e2 = e6;
                            str3 = String.format("Could not instantiate %s", str6);
                            Log.w("ComponentDiscovery", str3, e2);
                        } catch (InvocationTargetException e7) {
                            e2 = e7;
                            str3 = String.format("Could not instantiate %s", str6);
                            Log.w("ComponentDiscovery", str3, e2);
                        }
                    }
                    str2 = j.a.f3988f.toString();
                    Executor executor = f2945j;
                    f.b.c.f.d[] dVarArr = new f.b.c.f.d[8];
                    dVarArr[0] = f.b.c.f.d.c(context, Context.class, new Class[0]);
                    dVarArr[1] = f.b.c.f.d.c(this, a.class, new Class[0]);
                    dVarArr[2] = f.b.c.f.d.c(cVar, c.class, new Class[0]);
                    dVarArr[3] = f.b.a.c.b.o.b.N("fire-android", "");
                    dVarArr[4] = f.b.a.c.b.o.b.N("fire-core", "19.3.1");
                    dVarArr[5] = str2 != null ? f.b.a.c.b.o.b.N("kotlin", str2) : dVar;
                    d.b a2 = f.b.c.f.d.a(f.class);
                    a2.a(new o(f.b.c.n.e.class, 2, 0));
                    a2.c(f.b.c.n.b.a);
                    dVarArr[6] = a2.b();
                    d.b a3 = f.b.c.f.d.a(f.b.c.l.c.class);
                    a3.a(new o(Context.class, 1, 0));
                    a3.c(f.b.c.l.a.a);
                    dVarArr[7] = a3.b();
                    this.f2947d = new k(executor, arrayList2, dVarArr);
                }
            }
            Log.w("ComponentDiscovery", str4);
        } catch (PackageManager.NameNotFoundException unused) {
            Log.w("ComponentDiscovery", "Application info not found.");
        }
        bundle = null;
        if (bundle != null) {
        }
        ArrayList arrayList22 = new ArrayList();
        while (r14.hasNext()) {
        }
        try {
            str2 = j.a.f3988f.toString();
        } catch (NoClassDefFoundError unused2) {
            str2 = null;
        }
        Executor executor2 = f2945j;
        f.b.c.f.d[] dVarArr2 = new f.b.c.f.d[8];
        dVarArr2[0] = f.b.c.f.d.c(context, Context.class, new Class[0]);
        dVarArr2[1] = f.b.c.f.d.c(this, a.class, new Class[0]);
        dVarArr2[2] = f.b.c.f.d.c(cVar, c.class, new Class[0]);
        dVarArr2[3] = f.b.a.c.b.o.b.N("fire-android", "");
        dVarArr2[4] = f.b.a.c.b.o.b.N("fire-core", "19.3.1");
        dVarArr2[5] = str2 != null ? f.b.a.c.b.o.b.N("kotlin", str2) : dVar;
        d.b a22 = f.b.c.f.d.a(f.class);
        a22.a(new o(f.b.c.n.e.class, 2, 0));
        a22.c(f.b.c.n.b.a);
        dVarArr2[6] = a22.b();
        d.b a32 = f.b.c.f.d.a(f.b.c.l.c.class);
        a32.a(new o(Context.class, 1, 0));
        a32.c(f.b.c.l.a.a);
        dVarArr2[7] = a32.b();
        this.f2947d = new k(executor2, arrayList22, dVarArr2);
    }

    public static a b() {
        a aVar;
        synchronized (f2944i) {
            aVar = f2946k.get("[DEFAULT]");
            if (aVar == null) {
                throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + f.b.a.c.b.o.d.a() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
            }
        }
        return aVar;
    }

    public static a d(Context context) {
        synchronized (f2944i) {
            if (f2946k.containsKey("[DEFAULT]")) {
                return b();
            }
            c a2 = c.a(context);
            if (a2 == null) {
                Log.w("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
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
                    f.b.a.c.b.l.l.c cVar3 = f.b.a.c.b.l.l.c.f2403f;
                    Objects.requireNonNull(cVar3);
                    synchronized (cVar3) {
                        cVar3.f2404d.add(cVar2);
                    }
                }
            }
        }
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (f2944i) {
            Map<String, a> map = f2946k;
            m.h.r(!map.containsKey("[DEFAULT]"), "FirebaseApp name [DEFAULT] already exists!");
            m.h.p(context, "Application context cannot be null.");
            aVar = new a(context, "[DEFAULT]", cVar);
            map.put("[DEFAULT]", aVar);
        }
        aVar.c();
        return aVar;
    }

    public final void a() {
        m.h.r(!this.f2949f.get(), "FirebaseApp was deleted");
    }

    public final void c() {
        Queue<f.b.c.j.a<?>> queue;
        Set<Map.Entry<f.b.c.j.b<Object>, Executor>> emptySet;
        if (!(Build.VERSION.SDK_INT >= 24 ? ((UserManager) this.a.getSystemService(UserManager.class)).isUserUnlocked() : true)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Device in Direct Boot Mode: postponing initialization of Firebase APIs for app ");
            a();
            sb.append(this.b);
            Log.i("FirebaseApp", sb.toString());
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
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Device unlocked: initializing all Firebase APIs for app ");
        a();
        sb2.append(this.b);
        Log.i("FirebaseApp", sb2.toString());
        k kVar = this.f2947d;
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
        s sVar = kVar.f2962d;
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
