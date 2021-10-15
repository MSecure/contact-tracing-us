package b.s;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.Looper;
import b.w.a.c;
import b.w.a.e;
import b.w.a.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public abstract class h {
    public static final String DB_IMPL_SUFFIX = "_Impl";
    public static final int MAX_BIND_PARAMETER_CNT = 999;
    public boolean mAllowMainThreadQueries;
    public final Map<String, Object> mBackingFieldMap = new ConcurrentHashMap();
    @Deprecated
    public List<b> mCallbacks;
    public final ReentrantReadWriteLock mCloseLock = new ReentrantReadWriteLock();
    @Deprecated
    public volatile b.w.a.b mDatabase;
    public final f mInvalidationTracker = createInvalidationTracker();
    public b.w.a.c mOpenHelper;
    public Executor mQueryExecutor;
    public final ThreadLocal<Integer> mSuspendingTransactionId = new ThreadLocal<>();
    public Executor mTransactionExecutor;
    public boolean mWriteAheadLoggingEnabled;

    public static class a<T extends h> {

        /* renamed from: a  reason: collision with root package name */
        public final Class<T> f2498a;

        /* renamed from: b  reason: collision with root package name */
        public final String f2499b;

        /* renamed from: c  reason: collision with root package name */
        public final Context f2500c;

        /* renamed from: d  reason: collision with root package name */
        public ArrayList<b> f2501d;

        /* renamed from: e  reason: collision with root package name */
        public Executor f2502e;

        /* renamed from: f  reason: collision with root package name */
        public Executor f2503f;

        /* renamed from: g  reason: collision with root package name */
        public c.AbstractC0052c f2504g;
        public boolean h;
        public c i = c.AUTOMATIC;
        public boolean j = true;
        public boolean k;
        public final d l = new d();
        public Set<Integer> m;
        public Set<Integer> n;

        public a(Context context, Class<T> cls, String str) {
            this.f2500c = context;
            this.f2498a = cls;
            this.f2499b = str;
        }

        public a<T> a(b.s.p.a... aVarArr) {
            if (this.n == null) {
                this.n = new HashSet();
            }
            for (b.s.p.a aVar : aVarArr) {
                this.n.add(Integer.valueOf(aVar.f2549a));
                this.n.add(Integer.valueOf(aVar.f2550b));
            }
            d dVar = this.l;
            if (dVar != null) {
                for (b.s.p.a aVar2 : aVarArr) {
                    int i2 = aVar2.f2549a;
                    int i3 = aVar2.f2550b;
                    TreeMap<Integer, b.s.p.a> treeMap = dVar.f2509a.get(Integer.valueOf(i2));
                    if (treeMap == null) {
                        treeMap = new TreeMap<>();
                        dVar.f2509a.put(Integer.valueOf(i2), treeMap);
                    }
                    b.s.p.a aVar3 = treeMap.get(Integer.valueOf(i3));
                    if (aVar3 != null) {
                        String str = "Overriding migration " + aVar3 + " with " + aVar2;
                    }
                    treeMap.put(Integer.valueOf(i3), aVar2);
                }
                return this;
            }
            throw null;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0028, code lost:
            if (r1 != null) goto L_0x002a;
         */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x003e  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x0068  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x0081  */
        /* JADX WARNING: Removed duplicated region for block: B:65:0x0164  */
        @SuppressLint({"RestrictedApi"})
        public T b() {
            Set<Integer> set;
            c cVar;
            Executor executor;
            if (this.f2500c == null) {
                throw new IllegalArgumentException("Cannot provide null context for the database.");
            } else if (this.f2498a != null) {
                if (this.f2502e == null && this.f2503f == null) {
                    executor = b.c.a.a.a.f1341d;
                    this.f2503f = executor;
                } else {
                    Executor executor2 = this.f2502e;
                    if (executor2 == null || this.f2503f != null) {
                        if (this.f2502e == null) {
                            executor = this.f2503f;
                        }
                        set = this.n;
                        if (!(set == null || this.m == null)) {
                            for (Integer num : set) {
                                if (this.m.contains(num)) {
                                    throw new IllegalArgumentException("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: " + num);
                                }
                            }
                        }
                        if (this.f2504g == null) {
                            this.f2504g = new b.w.a.g.d();
                        }
                        Context context = this.f2500c;
                        String str = this.f2499b;
                        c.AbstractC0052c cVar2 = this.f2504g;
                        d dVar = this.l;
                        ArrayList<b> arrayList = this.f2501d;
                        boolean z = this.h;
                        cVar = this.i;
                        if (cVar != null) {
                            if (cVar == c.AUTOMATIC) {
                                ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                                cVar = (activityManager == null || activityManager.isLowRamDevice()) ? c.TRUNCATE : c.WRITE_AHEAD_LOGGING;
                            }
                            a aVar = new a(context, str, cVar2, dVar, arrayList, z, cVar, this.f2502e, this.f2503f, false, this.j, this.k, this.m, null, null);
                            Class<T> cls = this.f2498a;
                            String name = cls.getPackage().getName();
                            String canonicalName = cls.getCanonicalName();
                            if (!name.isEmpty()) {
                                canonicalName = canonicalName.substring(name.length() + 1);
                            }
                            String str2 = canonicalName.replace('.', '_') + h.DB_IMPL_SUFFIX;
                            try {
                                T t = (T) ((h) Class.forName(name.isEmpty() ? str2 : name + "." + str2).newInstance());
                                t.init(aVar);
                                return t;
                            } catch (ClassNotFoundException unused) {
                                StringBuilder h2 = c.a.a.a.a.h("cannot find implementation for ");
                                h2.append(cls.getCanonicalName());
                                h2.append(". ");
                                h2.append(str2);
                                h2.append(" does not exist");
                                throw new RuntimeException(h2.toString());
                            } catch (IllegalAccessException unused2) {
                                StringBuilder h3 = c.a.a.a.a.h("Cannot access the constructor");
                                h3.append(cls.getCanonicalName());
                                throw new RuntimeException(h3.toString());
                            } catch (InstantiationException unused3) {
                                StringBuilder h4 = c.a.a.a.a.h("Failed to create an instance of ");
                                h4.append(cls.getCanonicalName());
                                throw new RuntimeException(h4.toString());
                            }
                        } else {
                            throw null;
                        }
                    } else {
                        this.f2503f = executor2;
                        set = this.n;
                        while (r1.hasNext()) {
                        }
                        if (this.f2504g == null) {
                        }
                        Context context2 = this.f2500c;
                        String str3 = this.f2499b;
                        c.AbstractC0052c cVar22 = this.f2504g;
                        d dVar2 = this.l;
                        ArrayList<b> arrayList2 = this.f2501d;
                        boolean z2 = this.h;
                        cVar = this.i;
                        if (cVar != null) {
                        }
                    }
                }
                this.f2502e = executor;
                set = this.n;
                while (r1.hasNext()) {
                }
                if (this.f2504g == null) {
                }
                Context context22 = this.f2500c;
                String str32 = this.f2499b;
                c.AbstractC0052c cVar222 = this.f2504g;
                d dVar22 = this.l;
                ArrayList<b> arrayList22 = this.f2501d;
                boolean z22 = this.h;
                cVar = this.i;
                if (cVar != null) {
                }
            } else {
                throw new IllegalArgumentException("Must provide an abstract class that extends RoomDatabase");
            }
        }
    }

    public static abstract class b {
        public void a(b.w.a.b bVar) {
        }
    }

    public enum c {
        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public HashMap<Integer, TreeMap<Integer, b.s.p.a>> f2509a = new HashMap<>();
    }

    public static boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public void assertNotMainThread() {
        if (!this.mAllowMainThreadQueries && isMainThread()) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    public void assertNotSuspendingTransaction() {
        if (!inTransaction() && this.mSuspendingTransactionId.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    @Deprecated
    public void beginTransaction() {
        assertNotMainThread();
        b.w.a.b p = this.mOpenHelper.p();
        this.mInvalidationTracker.i(p);
        ((b.w.a.g.a) p).f2616b.beginTransaction();
    }

    public abstract void clearAllTables();

    public void close() {
        if (isOpen()) {
            ReentrantReadWriteLock.WriteLock writeLock = this.mCloseLock.writeLock();
            try {
                writeLock.lock();
                f fVar = this.mInvalidationTracker;
                g gVar = fVar.k;
                if (gVar != null) {
                    if (gVar.i.compareAndSet(false, true)) {
                        gVar.f2489g.execute(gVar.m);
                    }
                    fVar.k = null;
                }
                this.mOpenHelper.close();
            } finally {
                writeLock.unlock();
            }
        }
    }

    public f compileStatement(String str) {
        assertNotMainThread();
        assertNotSuspendingTransaction();
        return new b.w.a.g.f(((b.w.a.g.a) this.mOpenHelper.p()).f2616b.compileStatement(str));
    }

    public abstract f createInvalidationTracker();

    public abstract b.w.a.c createOpenHelper(a aVar);

    @Deprecated
    public void endTransaction() {
        ((b.w.a.g.a) this.mOpenHelper.p()).f2616b.endTransaction();
        if (!inTransaction()) {
            f fVar = this.mInvalidationTracker;
            if (fVar.f2467e.compareAndSet(false, true)) {
                fVar.f2466d.getQueryExecutor().execute(fVar.l);
            }
        }
    }

    public Map<String, Object> getBackingFieldMap() {
        return this.mBackingFieldMap;
    }

    public Lock getCloseLock() {
        return this.mCloseLock.readLock();
    }

    public f getInvalidationTracker() {
        return this.mInvalidationTracker;
    }

    public b.w.a.c getOpenHelper() {
        return this.mOpenHelper;
    }

    public Executor getQueryExecutor() {
        return this.mQueryExecutor;
    }

    public ThreadLocal<Integer> getSuspendingTransactionId() {
        return this.mSuspendingTransactionId;
    }

    public Executor getTransactionExecutor() {
        return this.mTransactionExecutor;
    }

    public boolean inTransaction() {
        return ((b.w.a.g.a) this.mOpenHelper.p()).b();
    }

    public void init(a aVar) {
        b.w.a.c createOpenHelper = createOpenHelper(aVar);
        this.mOpenHelper = createOpenHelper;
        if (createOpenHelper instanceof l) {
            ((l) createOpenHelper).f2537g = aVar;
        }
        boolean z = aVar.f2458g == c.WRITE_AHEAD_LOGGING;
        this.mOpenHelper.setWriteAheadLoggingEnabled(z);
        this.mCallbacks = aVar.f2456e;
        this.mQueryExecutor = aVar.h;
        this.mTransactionExecutor = new n(aVar.i);
        this.mAllowMainThreadQueries = aVar.f2457f;
        this.mWriteAheadLoggingEnabled = z;
        if (aVar.j) {
            f fVar = this.mInvalidationTracker;
            fVar.k = new g(aVar.f2453b, aVar.f2454c, fVar, fVar.f2466d.getQueryExecutor());
        }
    }

    public void internalInitInvalidationTracker(b.w.a.b bVar) {
        f fVar = this.mInvalidationTracker;
        synchronized (fVar) {
            if (!fVar.f2468f) {
                ((b.w.a.g.a) bVar).f2616b.execSQL("PRAGMA temp_store = MEMORY;");
                ((b.w.a.g.a) bVar).f2616b.execSQL("PRAGMA recursive_triggers='ON';");
                ((b.w.a.g.a) bVar).f2616b.execSQL("CREATE TEMP TABLE room_table_modification_log(table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
                fVar.i(bVar);
                fVar.f2469g = new b.w.a.g.f(((b.w.a.g.a) bVar).f2616b.compileStatement("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1 "));
                fVar.f2468f = true;
            }
        }
    }

    public boolean isOpen() {
        b.w.a.b bVar = this.mDatabase;
        return bVar != null && ((b.w.a.g.a) bVar).f2616b.isOpen();
    }

    public Cursor query(e eVar) {
        return query(eVar, (CancellationSignal) null);
    }

    public Cursor query(e eVar, CancellationSignal cancellationSignal) {
        assertNotMainThread();
        assertNotSuspendingTransaction();
        if (cancellationSignal == null) {
            return ((b.w.a.g.a) this.mOpenHelper.p()).c(eVar);
        }
        b.w.a.g.a aVar = (b.w.a.g.a) this.mOpenHelper.p();
        return aVar.f2616b.rawQueryWithFactory(new b.w.a.g.b(aVar, eVar), eVar.a(), b.w.a.g.a.f2615c, null, cancellationSignal);
    }

    public Cursor query(String str, Object[] objArr) {
        return ((b.w.a.g.a) this.mOpenHelper.p()).c(new b.w.a.a(str, objArr));
    }

    public <V> V runInTransaction(Callable<V> callable) {
        beginTransaction();
        try {
            V call = callable.call();
            setTransactionSuccessful();
            endTransaction();
            return call;
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception e3) {
            throw e3;
        } catch (Throwable th) {
            endTransaction();
            throw th;
        }
    }

    public void runInTransaction(Runnable runnable) {
        beginTransaction();
        try {
            runnable.run();
            setTransactionSuccessful();
        } finally {
            endTransaction();
        }
    }

    @Deprecated
    public void setTransactionSuccessful() {
        ((b.w.a.g.a) this.mOpenHelper.p()).f2616b.setTransactionSuccessful();
    }
}
