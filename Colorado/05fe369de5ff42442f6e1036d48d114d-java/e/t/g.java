package e.t;

import android.app.ActivityManager;
import android.content.Context;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.Looper;
import e.v.a.c;
import e.v.a.e;
import e.v.a.f.f;
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

public abstract class g {
    @Deprecated
    public volatile e.v.a.b a;
    public Executor b;
    public Executor c;

    /* renamed from: d  reason: collision with root package name */
    public e.v.a.c f1701d;

    /* renamed from: e  reason: collision with root package name */
    public final f f1702e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1703f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1704g;
    @Deprecated

    /* renamed from: h  reason: collision with root package name */
    public List<b> f1705h;

    /* renamed from: i  reason: collision with root package name */
    public final ReentrantReadWriteLock f1706i = new ReentrantReadWriteLock();

    /* renamed from: j  reason: collision with root package name */
    public final ThreadLocal<Integer> f1707j = new ThreadLocal<>();

    public static class a<T extends g> {
        public final Class<T> a;
        public final String b;
        public final Context c;

        /* renamed from: d  reason: collision with root package name */
        public ArrayList<b> f1708d;

        /* renamed from: e  reason: collision with root package name */
        public Executor f1709e;

        /* renamed from: f  reason: collision with root package name */
        public Executor f1710f;

        /* renamed from: g  reason: collision with root package name */
        public c.AbstractC0054c f1711g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f1712h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f1713i = true;

        /* renamed from: j  reason: collision with root package name */
        public boolean f1714j;

        /* renamed from: k  reason: collision with root package name */
        public final d f1715k = new d();

        /* renamed from: l  reason: collision with root package name */
        public Set<Integer> f1716l;
        public Set<Integer> m;

        public a(Context context, Class<T> cls, String str) {
            this.c = context;
            this.a = cls;
            this.b = str;
        }

        public a<T> a(e.t.o.a... aVarArr) {
            if (this.m == null) {
                this.m = new HashSet();
            }
            for (e.t.o.a aVar : aVarArr) {
                this.m.add(Integer.valueOf(aVar.a));
                this.m.add(Integer.valueOf(aVar.b));
            }
            d dVar = this.f1715k;
            Objects.requireNonNull(dVar);
            for (e.t.o.a aVar2 : aVarArr) {
                int i2 = aVar2.a;
                int i3 = aVar2.b;
                TreeMap<Integer, e.t.o.a> treeMap = dVar.a.get(Integer.valueOf(i2));
                if (treeMap == null) {
                    treeMap = new TreeMap<>();
                    dVar.a.put(Integer.valueOf(i2), treeMap);
                }
                e.t.o.a aVar3 = treeMap.get(Integer.valueOf(i3));
                if (aVar3 != null) {
                    String str = "Overriding migration " + aVar3 + " with " + aVar2;
                }
                treeMap.put(Integer.valueOf(i3), aVar2);
            }
            return this;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0026, code lost:
            if (r2 != null) goto L_0x0028;
         */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x003c  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0066  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x0085  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x00bb  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x00e3 A[Catch:{ ClassNotFoundException -> 0x0161, IllegalAccessException -> 0x014a, InstantiationException -> 0x0133 }] */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x00e5 A[Catch:{ ClassNotFoundException -> 0x0161, IllegalAccessException -> 0x014a, InstantiationException -> 0x0133 }] */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x010d  */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x0117  */
        public T b() {
            Set<Integer> set;
            a aVar;
            ActivityManager activityManager;
            c cVar;
            String name;
            String str;
            e.v.a.c f2;
            Executor executor;
            c cVar2 = c.WRITE_AHEAD_LOGGING;
            if (this.c == null) {
                throw new IllegalArgumentException("Cannot provide null context for the database.");
            } else if (this.a != null) {
                Executor executor2 = this.f1709e;
                if (executor2 == null && this.f1710f == null) {
                    executor = e.c.a.a.a.f973d;
                    this.f1710f = executor;
                } else if (executor2 == null || this.f1710f != null) {
                    if (executor2 == null) {
                        executor = this.f1710f;
                    }
                    set = this.m;
                    if (!(set == null || this.f1716l == null)) {
                        for (Integer num : set) {
                            if (this.f1716l.contains(num)) {
                                throw new IllegalArgumentException("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: " + num);
                            }
                        }
                    }
                    if (this.f1711g == null) {
                        this.f1711g = new e.v.a.f.d();
                    }
                    Context context = this.c;
                    String str2 = this.b;
                    c.AbstractC0054c cVar3 = this.f1711g;
                    d dVar = this.f1715k;
                    ArrayList<b> arrayList = this.f1708d;
                    boolean z = this.f1712h;
                    activityManager = (ActivityManager) context.getSystemService("activity");
                    if (activityManager != null || activityManager.isLowRamDevice()) {
                        cVar = c.TRUNCATE;
                    } else {
                        cVar = cVar2;
                    }
                    aVar = new a(context, str2, cVar3, dVar, arrayList, z, cVar, this.f1709e, this.f1710f, false, this.f1713i, this.f1714j, this.f1716l, null, null);
                    Class<T> cls = this.a;
                    name = cls.getPackage().getName();
                    String canonicalName = cls.getCanonicalName();
                    boolean z2 = true;
                    if (!name.isEmpty()) {
                        canonicalName = canonicalName.substring(name.length() + 1);
                    }
                    str = canonicalName.replace('.', '_') + "_Impl";
                    T t = (T) ((g) Class.forName(name.isEmpty() ? str : name + "." + str).newInstance());
                    f2 = t.f(aVar);
                    t.f1701d = f2;
                    if (f2 instanceof k) {
                        ((k) f2).f1732g = aVar;
                    }
                    if (aVar.f1683g != cVar2) {
                        z2 = false;
                    }
                    f2.setWriteAheadLoggingEnabled(z2);
                    t.f1705h = aVar.f1681e;
                    t.b = aVar.f1684h;
                    t.c = new m(aVar.f1685i);
                    t.f1703f = aVar.f1682f;
                    t.f1704g = z2;
                    return t;
                } else {
                    this.f1710f = executor2;
                    set = this.m;
                    while (r2.hasNext()) {
                    }
                    if (this.f1711g == null) {
                    }
                    Context context2 = this.c;
                    String str22 = this.b;
                    c.AbstractC0054c cVar32 = this.f1711g;
                    d dVar2 = this.f1715k;
                    ArrayList<b> arrayList2 = this.f1708d;
                    boolean z3 = this.f1712h;
                    activityManager = (ActivityManager) context2.getSystemService("activity");
                    if (activityManager != null) {
                    }
                    cVar = c.TRUNCATE;
                    aVar = new a(context2, str22, cVar32, dVar2, arrayList2, z3, cVar, this.f1709e, this.f1710f, false, this.f1713i, this.f1714j, this.f1716l, null, null);
                    Class<T> cls2 = this.a;
                    name = cls2.getPackage().getName();
                    String canonicalName2 = cls2.getCanonicalName();
                    boolean z22 = true;
                    if (!name.isEmpty()) {
                    }
                    str = canonicalName2.replace('.', '_') + "_Impl";
                    if (name.isEmpty()) {
                    }
                    T t2 = (T) ((g) Class.forName(name.isEmpty() ? str : name + "." + str).newInstance());
                    f2 = t2.f(aVar);
                    t2.f1701d = f2;
                    if (f2 instanceof k) {
                    }
                    if (aVar.f1683g != cVar2) {
                    }
                    f2.setWriteAheadLoggingEnabled(z22);
                    t2.f1705h = aVar.f1681e;
                    t2.b = aVar.f1684h;
                    t2.c = new m(aVar.f1685i);
                    t2.f1703f = aVar.f1682f;
                    t2.f1704g = z22;
                    return t2;
                }
                this.f1709e = executor;
                set = this.m;
                while (r2.hasNext()) {
                }
                if (this.f1711g == null) {
                }
                Context context22 = this.c;
                String str222 = this.b;
                c.AbstractC0054c cVar322 = this.f1711g;
                d dVar22 = this.f1715k;
                ArrayList<b> arrayList22 = this.f1708d;
                boolean z32 = this.f1712h;
                activityManager = (ActivityManager) context22.getSystemService("activity");
                if (activityManager != null) {
                }
                cVar = c.TRUNCATE;
                aVar = new a(context22, str222, cVar322, dVar22, arrayList22, z32, cVar, this.f1709e, this.f1710f, false, this.f1713i, this.f1714j, this.f1716l, null, null);
                Class<T> cls22 = this.a;
                name = cls22.getPackage().getName();
                String canonicalName22 = cls22.getCanonicalName();
                boolean z222 = true;
                if (!name.isEmpty()) {
                }
                str = canonicalName22.replace('.', '_') + "_Impl";
                try {
                    if (name.isEmpty()) {
                    }
                    T t22 = (T) ((g) Class.forName(name.isEmpty() ? str : name + "." + str).newInstance());
                    f2 = t22.f(aVar);
                    t22.f1701d = f2;
                    if (f2 instanceof k) {
                    }
                    if (aVar.f1683g != cVar2) {
                    }
                    f2.setWriteAheadLoggingEnabled(z222);
                    t22.f1705h = aVar.f1681e;
                    t22.b = aVar.f1684h;
                    t22.c = new m(aVar.f1685i);
                    t22.f1703f = aVar.f1682f;
                    t22.f1704g = z222;
                    return t22;
                } catch (ClassNotFoundException unused) {
                    StringBuilder i2 = f.a.a.a.a.i("cannot find implementation for ");
                    i2.append(cls22.getCanonicalName());
                    i2.append(". ");
                    i2.append(str);
                    i2.append(" does not exist");
                    throw new RuntimeException(i2.toString());
                } catch (IllegalAccessException unused2) {
                    StringBuilder i3 = f.a.a.a.a.i("Cannot access the constructor");
                    i3.append(cls22.getCanonicalName());
                    throw new RuntimeException(i3.toString());
                } catch (InstantiationException unused3) {
                    StringBuilder i4 = f.a.a.a.a.i("Failed to create an instance of ");
                    i4.append(cls22.getCanonicalName());
                    throw new RuntimeException(i4.toString());
                }
            } else {
                throw new IllegalArgumentException("Must provide an abstract class that extends RoomDatabase");
            }
        }
    }

    public static abstract class b {
        public void a(e.v.a.b bVar) {
        }
    }

    public enum c {
        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING
    }

    public static class d {
        public HashMap<Integer, TreeMap<Integer, e.t.o.a>> a = new HashMap<>();
    }

    public g() {
        new ConcurrentHashMap();
        this.f1702e = e();
    }

    public void a() {
        if (!this.f1703f) {
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
            }
        }
    }

    public void b() {
        if (!h() && this.f1707j.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    @Deprecated
    public void c() {
        a();
        e.v.a.b E = this.f1701d.E();
        this.f1702e.i(E);
        ((e.v.a.f.a) E).b.beginTransaction();
    }

    public f d(String str) {
        a();
        b();
        return new f(((e.v.a.f.a) this.f1701d.E()).b.compileStatement(str));
    }

    public abstract f e();

    public abstract e.v.a.c f(a aVar);

    @Deprecated
    public void g() {
        ((e.v.a.f.a) this.f1701d.E()).b.endTransaction();
        if (!h()) {
            f fVar = this.f1702e;
            if (fVar.f1691e.compareAndSet(false, true)) {
                fVar.f1690d.b.execute(fVar.f1697k);
            }
        }
    }

    public boolean h() {
        return ((e.v.a.f.a) this.f1701d.E()).b.inTransaction();
    }

    public void i(e.v.a.b bVar) {
        f fVar = this.f1702e;
        synchronized (fVar) {
            if (!fVar.f1692f) {
                ((e.v.a.f.a) bVar).b.execSQL("PRAGMA temp_store = MEMORY;");
                ((e.v.a.f.a) bVar).b.execSQL("PRAGMA recursive_triggers='ON';");
                ((e.v.a.f.a) bVar).b.execSQL("CREATE TEMP TABLE room_table_modification_log(table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
                fVar.i(bVar);
                fVar.f1693g = new f(((e.v.a.f.a) bVar).b.compileStatement("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1 "));
                fVar.f1692f = true;
            }
        }
    }

    public boolean j() {
        e.v.a.b bVar = this.a;
        return bVar != null && ((e.v.a.f.a) bVar).b.isOpen();
    }

    public Cursor k(e eVar, CancellationSignal cancellationSignal) {
        a();
        b();
        if (cancellationSignal == null) {
            return ((e.v.a.f.a) this.f1701d.E()).d(eVar);
        }
        e.v.a.f.a aVar = (e.v.a.f.a) this.f1701d.E();
        return aVar.b.rawQueryWithFactory(new e.v.a.f.b(aVar, eVar), eVar.c(), e.v.a.f.a.c, null, cancellationSignal);
    }

    @Deprecated
    public void l() {
        ((e.v.a.f.a) this.f1701d.E()).b.setTransactionSuccessful();
    }
}
