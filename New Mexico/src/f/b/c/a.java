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
import f.b.c.f.s;
import f.b.c.f.t;
import f.b.c.j.a;
import f.b.c.j.b;
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
/* loaded from: classes.dex */
public class a {

    /* renamed from: i */
    public static final Object f3461i = new Object();

    /* renamed from: j */
    public static final Executor f3462j = new d(null);

    /* renamed from: k */
    public static final Map<String, a> f3463k = new e.f.a();
    public final Context a;
    public final String b;
    public final c c;

    /* renamed from: d */
    public final k f3464d;

    /* renamed from: e */
    public final AtomicBoolean f3465e = new AtomicBoolean(false);

    /* renamed from: f */
    public final AtomicBoolean f3466f = new AtomicBoolean();

    /* renamed from: g */
    public final List<b> f3467g = new CopyOnWriteArrayList();

    /* renamed from: h */
    public final List<Object> f3468h = new CopyOnWriteArrayList();

    /* loaded from: classes.dex */
    public interface b {
        void a(boolean z);
    }

    /* loaded from: classes.dex */
    public static class c implements c.a {
        public static AtomicReference<c> a = new AtomicReference<>();

        @Override // f.b.a.c.b.l.l.c.a
        public void a(boolean z) {
            Object obj = a.f3461i;
            synchronized (a.f3461i) {
                Iterator it = new ArrayList(a.f3463k.values()).iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    if (aVar.f3465e.get()) {
                        for (b bVar : aVar.f3467g) {
                            bVar.a(z);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d implements Executor {
        public static final Handler b = new Handler(Looper.getMainLooper());

        public d(C0112a aVar) {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            b.post(runnable);
        }
    }

    /* loaded from: classes.dex */
    public static class e extends BroadcastReceiver {
        public static AtomicReference<e> b = new AtomicReference<>();
        public final Context a;

        public e(Context context) {
            this.a = context;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Object obj = a.f3461i;
            synchronized (a.f3461i) {
                for (a aVar : a.f3463k.values()) {
                    aVar.c();
                }
            }
            this.a.unregisterReceiver(this);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:2|(2:46|3)|(2:6|(1:8)(11:9|11|(1:13)(4:14|(4:17|(3:51|21|55)|52|15)|50|22)|23|(7:26|47|27|58|(3:57|29|60)(3:56|30|61)|59|24)|44|36|38|(1:40)|41|42))(1:5)|10|11|(0)(0)|23|(1:24)|44|36|38|(0)|41|42) */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0112, code lost:
        r13 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0152  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public a(Context context, String str, c cVar) {
        Bundle bundle;
        List<String> list;
        PackageManager packageManager;
        Objects.requireNonNull(context, "null reference");
        this.a = context;
        m.e.o(str);
        this.b = str;
        Objects.requireNonNull(cVar, "null reference");
        this.c = cVar;
        f.b.c.f.d<?> dVar = null;
        try {
            packageManager = context.getPackageManager();
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (packageManager != null) {
            ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, ComponentDiscoveryService.class), 128);
            if (serviceInfo == null) {
                String str2 = ComponentDiscoveryService.class + " has no service info.";
            } else {
                bundle = serviceInfo.metaData;
                if (bundle != null) {
                    list = Collections.emptyList();
                } else {
                    ArrayList arrayList = new ArrayList();
                    for (String str3 : bundle.keySet()) {
                        if ("com.google.firebase.components.ComponentRegistrar".equals(bundle.get(str3)) && str3.startsWith("com.google.firebase.components:")) {
                            arrayList.add(str3.substring(31));
                        }
                    }
                    list = arrayList;
                }
                ArrayList arrayList2 = new ArrayList();
                for (String str4 : list) {
                    try {
                        Class<?> cls = Class.forName(str4);
                        if (!g.class.isAssignableFrom(cls)) {
                            String.format("Class %s is not an instance of %s", str4, "com.google.firebase.components.ComponentRegistrar");
                        } else {
                            arrayList2.add((g) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                        }
                    } catch (ClassNotFoundException unused2) {
                        String.format("Class %s is not an found.", str4);
                    } catch (IllegalAccessException unused3) {
                        String.format("Could not instantiate %s.", str4);
                    } catch (InstantiationException unused4) {
                        String.format("Could not instantiate %s.", str4);
                    } catch (NoSuchMethodException unused5) {
                        String.format("Could not instantiate %s", str4);
                    } catch (InvocationTargetException unused6) {
                        String.format("Could not instantiate %s", str4);
                    }
                }
                String str5 = j.a.f4566f.toString();
                Executor executor = f3462j;
                f.b.c.f.d[] dVarArr = new f.b.c.f.d[8];
                dVarArr[0] = f.b.c.f.d.c(context, Context.class, new Class[0]);
                dVarArr[1] = f.b.c.f.d.c(this, a.class, new Class[0]);
                dVarArr[2] = f.b.c.f.d.c(cVar, c.class, new Class[0]);
                dVarArr[3] = f.b.a.c.b.o.b.J("fire-android", "");
                dVarArr[4] = f.b.a.c.b.o.b.J("fire-core", "19.3.1");
                dVarArr[5] = str5 != null ? f.b.a.c.b.o.b.J("kotlin", str5) : dVar;
                d.b a = f.b.c.f.d.a(f.class);
                a.a(new o(f.b.c.n.e.class, 2, 0));
                a.c(f.b.c.n.b.a);
                dVarArr[6] = a.b();
                d.b a2 = f.b.c.f.d.a(f.b.c.l.c.class);
                a2.a(new o(Context.class, 1, 0));
                a2.c(f.b.c.l.a.a);
                dVarArr[7] = a2.b();
                this.f3464d = new k(executor, arrayList2, dVarArr);
            }
        }
        bundle = null;
        if (bundle != null) {
        }
        ArrayList arrayList22 = new ArrayList();
        while (r13.hasNext()) {
        }
        String str52 = j.a.f4566f.toString();
        Executor executor2 = f3462j;
        f.b.c.f.d[] dVarArr2 = new f.b.c.f.d[8];
        dVarArr2[0] = f.b.c.f.d.c(context, Context.class, new Class[0]);
        dVarArr2[1] = f.b.c.f.d.c(this, a.class, new Class[0]);
        dVarArr2[2] = f.b.c.f.d.c(cVar, c.class, new Class[0]);
        dVarArr2[3] = f.b.a.c.b.o.b.J("fire-android", "");
        dVarArr2[4] = f.b.a.c.b.o.b.J("fire-core", "19.3.1");
        dVarArr2[5] = str52 != null ? f.b.a.c.b.o.b.J("kotlin", str52) : dVar;
        d.b a3 = f.b.c.f.d.a(f.class);
        a3.a(new o(f.b.c.n.e.class, 2, 0));
        a3.c(f.b.c.n.b.a);
        dVarArr2[6] = a3.b();
        d.b a22 = f.b.c.f.d.a(f.b.c.l.c.class);
        a22.a(new o(Context.class, 1, 0));
        a22.c(f.b.c.l.a.a);
        dVarArr2[7] = a22.b();
        this.f3464d = new k(executor2, arrayList22, dVarArr2);
    }

    public static a b() {
        a aVar;
        synchronized (f3461i) {
            aVar = f3463k.get("[DEFAULT]");
            if (aVar == null) {
                throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + f.b.a.c.b.o.d.a() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
            }
        }
        return aVar;
    }

    public static a d(Context context) {
        synchronized (f3461i) {
            if (f3463k.containsKey("[DEFAULT]")) {
                return b();
            }
            c a = c.a(context);
            if (a == null) {
                return null;
            }
            return e(context, a);
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
                    f.b.a.c.b.l.l.c cVar3 = f.b.a.c.b.l.l.c.f2675f;
                    Objects.requireNonNull(cVar3);
                    synchronized (cVar3) {
                        cVar3.f2676d.add(cVar2);
                    }
                }
            }
        }
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (f3461i) {
            Map<String, a> map = f3463k;
            m.e.t(!map.containsKey("[DEFAULT]"), "FirebaseApp name [DEFAULT] already exists!");
            m.e.r(context, "Application context cannot be null.");
            aVar = new a(context, "[DEFAULT]", cVar);
            map.put("[DEFAULT]", aVar);
        }
        aVar.c();
        return aVar;
    }

    public final void a() {
        m.e.t(!this.f3466f.get(), "FirebaseApp was deleted");
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
        k kVar = this.f3464d;
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
                if (z && equals) {
                }
            }
            value.get();
        }
        s sVar = kVar.f3479d;
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
                            entry2.getValue().execute(new Runnable(entry2, aVar) { // from class: f.b.c.f.r
                                public final Map.Entry b;
                                public final a c;

                                {
                                    this.b = r1;
                                    this.c = r2;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Map.Entry entry3 = this.b;
                                    ((b) entry3.getKey()).a(this.c);
                                }
                            });
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
