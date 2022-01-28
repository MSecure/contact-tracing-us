package b.r;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.Looper;
import b.u.a.c;
import b.u.a.e;
import b.u.a.f;
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
    public volatile b.u.a.b mDatabase;
    public final f mInvalidationTracker = createInvalidationTracker();
    public b.u.a.c mOpenHelper;
    public Executor mQueryExecutor;
    public final ThreadLocal<Integer> mSuspendingTransactionId = new ThreadLocal<>();
    public Executor mTransactionExecutor;
    public boolean mWriteAheadLoggingEnabled;

    public static class a<T extends h> {

        /* renamed from: a  reason: collision with root package name */
        public final Class<T> f1636a;

        /* renamed from: b  reason: collision with root package name */
        public final String f1637b;

        /* renamed from: c  reason: collision with root package name */
        public final Context f1638c;

        /* renamed from: d  reason: collision with root package name */
        public ArrayList<b> f1639d;

        /* renamed from: e  reason: collision with root package name */
        public Executor f1640e;
        public Executor f;
        public c.AbstractC0042c g;
        public boolean h;
        public c i = c.AUTOMATIC;
        public boolean j = true;
        public boolean k;
        public final d l = new d();
        public Set<Integer> m;
        public Set<Integer> n;

        public a(Context context, Class<T> cls, String str) {
            this.f1638c = context;
            this.f1636a = cls;
            this.f1637b = str;
        }

        public a<T> a(b.r.p.a... aVarArr) {
            if (this.n == null) {
                this.n = new HashSet();
            }
            for (b.r.p.a aVar : aVarArr) {
                this.n.add(Integer.valueOf(aVar.f1679a));
                this.n.add(Integer.valueOf(aVar.f1680b));
            }
            d dVar = this.l;
            if (dVar != null) {
                for (b.r.p.a aVar2 : aVarArr) {
                    int i2 = aVar2.f1679a;
                    int i3 = aVar2.f1680b;
                    TreeMap<Integer, b.r.p.a> treeMap = dVar.f1645a.get(Integer.valueOf(i2));
                    if (treeMap == null) {
                        treeMap = new TreeMap<>();
                        dVar.f1645a.put(Integer.valueOf(i2), treeMap);
                    }
                    b.r.p.a aVar3 = treeMap.get(Integer.valueOf(i3));
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
            if (this.f1638c == null) {
                throw new IllegalArgumentException("Cannot provide null context for the database.");
            } else if (this.f1636a != null) {
                if (this.f1640e == null && this.f == null) {
                    executor = b.c.a.a.a.f768d;
                    this.f = executor;
                } else {
                    Executor executor2 = this.f1640e;
                    if (executor2 == null || this.f != null) {
                        if (this.f1640e == null) {
                            executor = this.f;
                        }
                        set = this.n;
                        if (!(set == null || this.m == null)) {
                            for (Integer num : set) {
                                if (this.m.contains(num)) {
                                    throw new IllegalArgumentException("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: " + num);
                                }
                            }
                        }
                        if (this.g == null) {
                            this.g = new b.u.a.g.d();
                        }
                        Context context = this.f1638c;
                        String str = this.f1637b;
                        c.AbstractC0042c cVar2 = this.g;
                        d dVar = this.l;
                        ArrayList<b> arrayList = this.f1639d;
                        boolean z = this.h;
                        cVar = this.i;
                        if (cVar != null) {
                            if (cVar == c.AUTOMATIC) {
                                ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                                cVar = (activityManager == null || activityManager.isLowRamDevice()) ? c.TRUNCATE : c.WRITE_AHEAD_LOGGING;
                            }
                            a aVar = new a(context, str, cVar2, dVar, arrayList, z, cVar, this.f1640e, this.f, false, this.j, this.k, this.m, null, null);
                            Class<T> cls = this.f1636a;
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
                                StringBuilder g2 = c.a.a.a.a.g("cannot find implementation for ");
                                g2.append(cls.getCanonicalName());
                                g2.append(". ");
                                g2.append(str2);
                                g2.append(" does not exist");
                                throw new RuntimeException(g2.toString());
                            } catch (IllegalAccessException unused2) {
                                StringBuilder g3 = c.a.a.a.a.g("Cannot access the constructor");
                                g3.append(cls.getCanonicalName());
                                throw new RuntimeException(g3.toString());
                            } catch (InstantiationException unused3) {
                                StringBuilder g4 = c.a.a.a.a.g("Failed to create an instance of ");
                                g4.append(cls.getCanonicalName());
                                throw new RuntimeException(g4.toString());
                            }
                        } else {
                            throw null;
                        }
                    } else {
                        this.f = executor2;
                        set = this.n;
                        while (r1.hasNext()) {
                        }
                        if (this.g == null) {
                        }
                        Context context2 = this.f1638c;
                        String str3 = this.f1637b;
                        c.AbstractC0042c cVar22 = this.g;
                        d dVar2 = this.l;
                        ArrayList<b> arrayList2 = this.f1639d;
                        boolean z2 = this.h;
                        cVar = this.i;
                        if (cVar != null) {
                        }
                    }
                }
                this.f1640e = executor;
                set = this.n;
                while (r1.hasNext()) {
                }
                if (this.g == null) {
                }
                Context context22 = this.f1638c;
                String str32 = this.f1637b;
                c.AbstractC0042c cVar222 = this.g;
                d dVar22 = this.l;
                ArrayList<b> arrayList22 = this.f1639d;
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
        public void a(b.u.a.b bVar) {
        }
    }

    public enum c {
        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public HashMap<Integer, TreeMap<Integer, b.r.p.a>> f1645a = new HashMap<>();
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
        b.u.a.b c2 = this.mOpenHelper.c();
        this.mInvalidationTracker.i(c2);
        ((b.u.a.g.a) c2).f1742b.beginTransaction();
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
                        gVar.g.execute(gVar.m);
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
        return new b.u.a.g.f(((b.u.a.g.a) this.mOpenHelper.c()).f1742b.compileStatement(str));
    }

    public abstract f createInvalidationTracker();

    public abstract b.u.a.c createOpenHelper(a aVar);

    @Deprecated
    public void endTransaction() {
        ((b.u.a.g.a) this.mOpenHelper.c()).f1742b.endTransaction();
        if (!inTransaction()) {
            f fVar = this.mInvalidationTracker;
            if (fVar.f1609e.compareAndSet(false, true)) {
                fVar.f1608d.getQueryExecutor().execute(fVar.l);
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

    public b.u.a.c getOpenHelper() {
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
        return ((b.u.a.g.a) this.mOpenHelper.c()).b();
    }

    public void init(a aVar) {
        b.u.a.c createOpenHelper = createOpenHelper(aVar);
        this.mOpenHelper = createOpenHelper;
        if (createOpenHelper instanceof l) {
            ((l) createOpenHelper).g = aVar;
        }
        boolean z = aVar.g == c.WRITE_AHEAD_LOGGING;
        this.mOpenHelper.setWriteAheadLoggingEnabled(z);
        this.mCallbacks = aVar.f1600e;
        this.mQueryExecutor = aVar.h;
        this.mTransactionExecutor = new n(aVar.i);
        this.mAllowMainThreadQueries = aVar.f;
        this.mWriteAheadLoggingEnabled = z;
        if (aVar.j) {
            f fVar = this.mInvalidationTracker;
            fVar.k = new g(aVar.f1597b, aVar.f1598c, fVar, fVar.f1608d.getQueryExecutor());
        }
    }

    public void internalInitInvalidationTracker(b.u.a.b bVar) {
        f fVar = this.mInvalidationTracker;
        synchronized (fVar) {
            if (!fVar.f) {
                ((b.u.a.g.a) bVar).f1742b.execSQL("PRAGMA temp_store = MEMORY;");
                ((b.u.a.g.a) bVar).f1742b.execSQL("PRAGMA recursive_triggers='ON';");
                ((b.u.a.g.a) bVar).f1742b.execSQL("CREATE TEMP TABLE room_table_modification_log(table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
                fVar.i(bVar);
                fVar.g = new b.u.a.g.f(((b.u.a.g.a) bVar).f1742b.compileStatement("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1 "));
                fVar.f = true;
            }
        }
    }

    public boolean isOpen() {
        b.u.a.b bVar = this.mDatabase;
        return bVar != null && ((b.u.a.g.a) bVar).f1742b.isOpen();
    }

    public Cursor query(e eVar) {
        return query(eVar, (CancellationSignal) null);
    }

    public Cursor query(e eVar, CancellationSignal cancellationSignal) {
        assertNotMainThread();
        assertNotSuspendingTransaction();
        if (cancellationSignal == null) {
            return ((b.u.a.g.a) this.mOpenHelper.c()).d(eVar);
        }
        b.u.a.g.a aVar = (b.u.a.g.a) this.mOpenHelper.c();
        return aVar.f1742b.rawQueryWithFactory(new b.u.a.g.b(aVar, eVar), eVar.a(), b.u.a.g.a.f1741c, null, cancellationSignal);
    }

    public Cursor query(String str, Object[] objArr) {
        return ((b.u.a.g.a) this.mOpenHelper.c()).d(new b.u.a.a(str, objArr));
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
        ((b.u.a.g.a) this.mOpenHelper.c()).f1742b.setTransactionSuccessful();
    }
}
