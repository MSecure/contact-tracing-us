package e.v;

import android.app.ActivityManager;
import android.content.Context;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.Looper;
import e.x.a.c;
import e.x.a.e;
import e.x.a.f.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* loaded from: classes.dex */
public abstract class g {
    @Deprecated
    public volatile e.x.a.b a;
    public Executor b;
    public Executor c;

    /* renamed from: d */
    public e.x.a.c f2061d;

    /* renamed from: f */
    public boolean f2063f;

    /* renamed from: g */
    public boolean f2064g;
    @Deprecated

    /* renamed from: h */
    public List<b> f2065h;

    /* renamed from: i */
    public final ReentrantReadWriteLock f2066i = new ReentrantReadWriteLock();

    /* renamed from: j */
    public final ThreadLocal<Integer> f2067j = new ThreadLocal<>();

    /* renamed from: e */
    public final f f2062e = e();

    /* loaded from: classes.dex */
    public static class a<T extends g> {
        public final Class<T> a;
        public final String b;
        public final Context c;

        /* renamed from: d */
        public ArrayList<b> f2068d;

        /* renamed from: e */
        public Executor f2069e;

        /* renamed from: f */
        public Executor f2070f;

        /* renamed from: g */
        public c.AbstractC0064c f2071g;

        /* renamed from: h */
        public boolean f2072h;

        /* renamed from: j */
        public boolean f2074j;

        /* renamed from: l */
        public Set<Integer> f2076l;
        public Set<Integer> m;

        /* renamed from: i */
        public boolean f2073i = true;

        /* renamed from: k */
        public final d f2075k = new d();

        public a(Context context, Class<T> cls, String str) {
            this.c = context;
            this.a = cls;
            this.b = str;
        }

        public a<T> a(e.v.o.a... aVarArr) {
            if (this.m == null) {
                this.m = new HashSet();
            }
            for (e.v.o.a aVar : aVarArr) {
                this.m.add(Integer.valueOf(aVar.a));
                this.m.add(Integer.valueOf(aVar.b));
            }
            d dVar = this.f2075k;
            Objects.requireNonNull(dVar);
            for (e.v.o.a aVar2 : aVarArr) {
                int i2 = aVar2.a;
                int i3 = aVar2.b;
                TreeMap<Integer, e.v.o.a> treeMap = dVar.a.get(Integer.valueOf(i2));
                if (treeMap == null) {
                    treeMap = new TreeMap<>();
                    dVar.a.put(Integer.valueOf(i2), treeMap);
                }
                e.v.o.a aVar3 = treeMap.get(Integer.valueOf(i3));
                if (aVar3 != null) {
                    String str = "Overriding migration " + aVar3 + " with " + aVar2;
                }
                treeMap.put(Integer.valueOf(i3), aVar2);
            }
            return this;
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0026, code lost:
            if (r2 != null) goto L_0x0028;
         */
        /* JADX WARN: Removed duplicated region for block: B:26:0x003c  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00bb  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00e3  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00e5 A[Catch: ClassNotFoundException -> 0x0161, IllegalAccessException -> 0x014a, InstantiationException -> 0x0133, TryCatch #2 {ClassNotFoundException -> 0x0161, IllegalAccessException -> 0x014a, InstantiationException -> 0x0133, blocks: (B:43:0x00dd, B:46:0x00e5, B:47:0x00f9), top: B:66:0x00dd }] */
        /* JADX WARN: Removed duplicated region for block: B:50:0x010d  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x0117  */
        /* Code decompiled incorrectly, please refer to instructions dump */
        public T b() {
            Set<Integer> set;
            a aVar;
            ActivityManager activityManager;
            c cVar;
            Class<T> cls;
            String name;
            String str;
            e.x.a.c f2;
            Executor executor;
            c cVar2 = c.WRITE_AHEAD_LOGGING;
            if (this.c == null) {
                throw new IllegalArgumentException("Cannot provide null context for the database.");
            } else if (this.a != null) {
                Executor executor2 = this.f2069e;
                try {
                    if (executor2 == null && this.f2070f == null) {
                        executor = e.c.a.a.a.f1073d;
                        this.f2070f = executor;
                    } else {
                        if (executor2 != null && this.f2070f == null) {
                            this.f2070f = executor2;
                        } else if (executor2 == null) {
                            executor = this.f2070f;
                        }
                        set = this.m;
                        if (!(set == null || this.f2076l == null)) {
                            for (Integer num : set) {
                                if (this.f2076l.contains(num)) {
                                    throw new IllegalArgumentException("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: " + num);
                                }
                            }
                        }
                        if (this.f2071g == null) {
                            this.f2071g = new e.x.a.f.d();
                        }
                        Context context = this.c;
                        String str2 = this.b;
                        c.AbstractC0064c cVar3 = this.f2071g;
                        d dVar = this.f2075k;
                        ArrayList<b> arrayList = this.f2068d;
                        boolean z = this.f2072h;
                        activityManager = (ActivityManager) context.getSystemService("activity");
                        if (activityManager != null || activityManager.isLowRamDevice()) {
                            cVar = c.TRUNCATE;
                        } else {
                            cVar = cVar2;
                        }
                        aVar = new a(context, str2, cVar3, dVar, arrayList, z, cVar, this.f2069e, this.f2070f, false, this.f2073i, this.f2074j, this.f2076l, null, null);
                        cls = this.a;
                        name = cls.getPackage().getName();
                        String canonicalName = cls.getCanonicalName();
                        boolean z2 = true;
                        if (!name.isEmpty()) {
                            canonicalName = canonicalName.substring(name.length() + 1);
                        }
                        str = canonicalName.replace('.', '_') + "_Impl";
                        T t = (T) ((g) Class.forName(!name.isEmpty() ? str : name + "." + str).newInstance());
                        f2 = t.f(aVar);
                        t.f2061d = f2;
                        if (f2 instanceof k) {
                            ((k) f2).f2092g = aVar;
                        }
                        if (aVar.f2043g != cVar2) {
                            z2 = false;
                        }
                        f2.setWriteAheadLoggingEnabled(z2);
                        t.f2065h = aVar.f2041e;
                        t.b = aVar.f2044h;
                        t.c = new m(aVar.f2045i);
                        t.f2063f = aVar.f2042f;
                        t.f2064g = z2;
                        return t;
                    }
                    if (!name.isEmpty()) {
                    }
                    T t2 = (T) ((g) Class.forName(!name.isEmpty() ? str : name + "." + str).newInstance());
                    f2 = t2.f(aVar);
                    t2.f2061d = f2;
                    if (f2 instanceof k) {
                    }
                    if (aVar.f2043g != cVar2) {
                    }
                    f2.setWriteAheadLoggingEnabled(z2);
                    t2.f2065h = aVar.f2041e;
                    t2.b = aVar.f2044h;
                    t2.c = new m(aVar.f2045i);
                    t2.f2063f = aVar.f2042f;
                    t2.f2064g = z2;
                    return t2;
                } catch (ClassNotFoundException unused) {
                    StringBuilder h2 = f.a.a.a.a.h("cannot find implementation for ");
                    h2.append(cls.getCanonicalName());
                    h2.append(". ");
                    h2.append(str);
                    h2.append(" does not exist");
                    throw new RuntimeException(h2.toString());
                } catch (IllegalAccessException unused2) {
                    StringBuilder h3 = f.a.a.a.a.h("Cannot access the constructor");
                    h3.append(cls.getCanonicalName());
                    throw new RuntimeException(h3.toString());
                } catch (InstantiationException unused3) {
                    StringBuilder h4 = f.a.a.a.a.h("Failed to create an instance of ");
                    h4.append(cls.getCanonicalName());
                    throw new RuntimeException(h4.toString());
                }
                this.f2069e = executor;
                set = this.m;
                if (set == null) {
                    while (r2.hasNext()) {
                    }
                }
                if (this.f2071g == null) {
                }
                Context context2 = this.c;
                String str22 = this.b;
                c.AbstractC0064c cVar32 = this.f2071g;
                d dVar2 = this.f2075k;
                ArrayList<b> arrayList2 = this.f2068d;
                boolean z3 = this.f2072h;
                activityManager = (ActivityManager) context2.getSystemService("activity");
                if (activityManager != null) {
                }
                cVar = c.TRUNCATE;
                aVar = new a(context2, str22, cVar32, dVar2, arrayList2, z3, cVar, this.f2069e, this.f2070f, false, this.f2073i, this.f2074j, this.f2076l, null, null);
                cls = this.a;
                name = cls.getPackage().getName();
                String canonicalName2 = cls.getCanonicalName();
                boolean z22 = true;
                if (!name.isEmpty()) {
                }
                str = canonicalName2.replace('.', '_') + "_Impl";
            } else {
                throw new IllegalArgumentException("Must provide an abstract class that extends RoomDatabase");
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b {
        public void a(e.x.a.b bVar) {
        }
    }

    /* loaded from: classes.dex */
    public enum c {
        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING
    }

    /* loaded from: classes.dex */
    public static class d {
        public HashMap<Integer, TreeMap<Integer, e.v.o.a>> a = new HashMap<>();
    }

    public g() {
        new ConcurrentHashMap();
    }

    public void a() {
        if (!this.f2063f) {
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
            }
        }
    }

    public void b() {
        if (!h() && this.f2067j.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    @Deprecated
    public void c() {
        a();
        e.x.a.b E = this.f2061d.E();
        this.f2062e.i(E);
        ((e.x.a.f.a) E).b.beginTransaction();
    }

    public f d(String str) {
        a();
        b();
        return new f(((e.x.a.f.a) this.f2061d.E()).b.compileStatement(str));
    }

    public abstract f e();

    public abstract e.x.a.c f(a aVar);

    @Deprecated
    public void g() {
        ((e.x.a.f.a) this.f2061d.E()).b.endTransaction();
        if (!h()) {
            f fVar = this.f2062e;
            if (fVar.f2051e.compareAndSet(false, true)) {
                fVar.f2050d.b.execute(fVar.f2057k);
            }
        }
    }

    public boolean h() {
        return ((e.x.a.f.a) this.f2061d.E()).b.inTransaction();
    }

    public void i(e.x.a.b bVar) {
        f fVar = this.f2062e;
        synchronized (fVar) {
            if (!fVar.f2052f) {
                ((e.x.a.f.a) bVar).b.execSQL("PRAGMA temp_store = MEMORY;");
                ((e.x.a.f.a) bVar).b.execSQL("PRAGMA recursive_triggers='ON';");
                ((e.x.a.f.a) bVar).b.execSQL("CREATE TEMP TABLE room_table_modification_log(table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
                fVar.i(bVar);
                fVar.f2053g = new f(((e.x.a.f.a) bVar).b.compileStatement("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1 "));
                fVar.f2052f = true;
            }
        }
    }

    public boolean j() {
        e.x.a.b bVar = this.a;
        return bVar != null && ((e.x.a.f.a) bVar).b.isOpen();
    }

    public Cursor k(e eVar, CancellationSignal cancellationSignal) {
        a();
        b();
        if (cancellationSignal == null) {
            return ((e.x.a.f.a) this.f2061d.E()).d(eVar);
        }
        e.x.a.f.a aVar = (e.x.a.f.a) this.f2061d.E();
        return aVar.b.rawQueryWithFactory(new e.x.a.f.b(aVar, eVar), eVar.c(), e.x.a.f.a.c, null, cancellationSignal);
    }

    @Deprecated
    public void l() {
        ((e.x.a.f.a) this.f2061d.E()).b.setTransactionSuccessful();
    }
}
