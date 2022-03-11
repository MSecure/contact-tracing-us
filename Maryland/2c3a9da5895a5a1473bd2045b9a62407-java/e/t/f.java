package e.t;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.lifecycle.LiveData;
import e.c.a.b.b;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class f {

    /* renamed from: l  reason: collision with root package name */
    public static final String[] f1873l = {"UPDATE", "DELETE", "INSERT"};
    public final HashMap<String, Integer> a;
    public final String[] b;
    public Map<String, Set<String>> c;

    /* renamed from: d  reason: collision with root package name */
    public final g f1874d;

    /* renamed from: e  reason: collision with root package name */
    public AtomicBoolean f1875e = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f1876f = false;

    /* renamed from: g  reason: collision with root package name */
    public volatile e.v.a.f.f f1877g;

    /* renamed from: h  reason: collision with root package name */
    public b f1878h;

    /* renamed from: i  reason: collision with root package name */
    public final e f1879i;

    /* renamed from: j  reason: collision with root package name */
    public final e.c.a.b.b<c, d> f1880j = new e.c.a.b.b<>();

    /* renamed from: k  reason: collision with root package name */
    public Runnable f1881k = new a();

    public class a implements Runnable {
        public a() {
        }

        /* JADX INFO: finally extract failed */
        public final Set<Integer> a() {
            HashSet hashSet = new HashSet();
            Cursor k2 = f.this.f1874d.k(new e.v.a.a("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"), null);
            while (k2.moveToNext()) {
                try {
                    hashSet.add(Integer.valueOf(k2.getInt(0)));
                } catch (Throwable th) {
                    k2.close();
                    throw th;
                }
            }
            k2.close();
            if (!hashSet.isEmpty()) {
                f.this.f1877g.d();
            }
            return hashSet;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v7, resolved type: android.database.sqlite.SQLiteDatabase */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x008a  */
        /* JADX WARNING: Removed duplicated region for block: B:74:? A[ADDED_TO_REGION, ORIG_RETURN, RETURN, SYNTHETIC] */
        public void run() {
            Set<Integer> set;
            Set<Integer> set2;
            Throwable e2;
            Throwable th;
            Set<Integer> a;
            ReentrantReadWriteLock.ReadLock readLock = f.this.f1874d.f1890i.readLock();
            try {
                readLock.lock();
                if (!f.this.c()) {
                    readLock.unlock();
                } else if (!f.this.f1875e.compareAndSet(true, false)) {
                    readLock.unlock();
                } else if (f.this.f1874d.h()) {
                    readLock.unlock();
                } else {
                    g gVar = f.this.f1874d;
                    if (gVar.f1888g) {
                        e.v.a.b I = gVar.f1885d.I();
                        SQLiteDatabase sQLiteDatabase = ((e.v.a.f.a) I).b;
                        sQLiteDatabase.beginTransaction();
                        try {
                            a = a();
                            try {
                                ((e.v.a.f.a) I).b.setTransactionSuccessful();
                            } catch (Throwable th2) {
                                th = th2;
                                ((e.v.a.f.a) I).b.endTransaction();
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            ((e.v.a.f.a) I).b.endTransaction();
                            throw th;
                        }
                        try {
                            ((e.v.a.f.a) I).b.endTransaction();
                            set = a;
                        } catch (SQLiteException | IllegalStateException e3) {
                            e2 = e3;
                            set2 = sQLiteDatabase;
                            try {
                                Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e2);
                                set = set2;
                                readLock.unlock();
                                if (set == null) {
                                }
                            } catch (Throwable th4) {
                                readLock.unlock();
                                throw th4;
                            }
                        }
                    } else {
                        set = a();
                    }
                    readLock.unlock();
                    if (set == null && !set.isEmpty()) {
                        synchronized (f.this.f1880j) {
                            Iterator<Map.Entry<c, d>> it = f.this.f1880j.iterator();
                            while (true) {
                                b.e eVar = (b.e) it;
                                if (eVar.hasNext()) {
                                    d dVar = (d) ((Map.Entry) eVar.next()).getValue();
                                    int length = dVar.a.length;
                                    Set<String> set3 = null;
                                    for (int i2 = 0; i2 < length; i2++) {
                                        if (set.contains(Integer.valueOf(dVar.a[i2]))) {
                                            if (length == 1) {
                                                set3 = dVar.f1884d;
                                            } else {
                                                if (set3 == null) {
                                                    set3 = new HashSet<>(length);
                                                }
                                                set3.add(dVar.b[i2]);
                                            }
                                        }
                                    }
                                    if (set3 != null) {
                                        dVar.c.a(set3);
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (SQLiteException | IllegalStateException e4) {
                e2 = e4;
                set2 = null;
                Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e2);
                set = set2;
                readLock.unlock();
                if (set == null) {
                }
            }
        }
    }

    public static class b {
        public final long[] a;
        public final boolean[] b;
        public final int[] c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f1882d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f1883e;

        public b(int i2) {
            long[] jArr = new long[i2];
            this.a = jArr;
            boolean[] zArr = new boolean[i2];
            this.b = zArr;
            this.c = new int[i2];
            Arrays.fill(jArr, 0L);
            Arrays.fill(zArr, false);
        }

        public int[] a() {
            synchronized (this) {
                if (this.f1882d) {
                    if (!this.f1883e) {
                        int length = this.a.length;
                        int i2 = 0;
                        while (true) {
                            int i3 = 1;
                            if (i2 < length) {
                                boolean z = this.a[i2] > 0;
                                boolean[] zArr = this.b;
                                if (z != zArr[i2]) {
                                    int[] iArr = this.c;
                                    if (!z) {
                                        i3 = 2;
                                    }
                                    iArr[i2] = i3;
                                } else {
                                    this.c[i2] = 0;
                                }
                                zArr[i2] = z;
                                i2++;
                            } else {
                                this.f1883e = true;
                                this.f1882d = false;
                                return this.c;
                            }
                        }
                    }
                }
                return null;
            }
        }
    }

    public static abstract class c {
        public final String[] a;

        public c(String[] strArr) {
            this.a = (String[]) Arrays.copyOf(strArr, strArr.length);
        }

        public abstract void a(Set<String> set);
    }

    public static class d {
        public final int[] a;
        public final String[] b;
        public final c c;

        /* renamed from: d  reason: collision with root package name */
        public final Set<String> f1884d;

        public d(c cVar, int[] iArr, String[] strArr) {
            Set<String> set;
            this.c = cVar;
            this.a = iArr;
            this.b = strArr;
            if (iArr.length == 1) {
                HashSet hashSet = new HashSet();
                hashSet.add(strArr[0]);
                set = Collections.unmodifiableSet(hashSet);
            } else {
                set = null;
            }
            this.f1884d = set;
        }
    }

    public static class e extends c {
        public final f b;
        public final WeakReference<c> c;

        public e(f fVar, c cVar) {
            super(cVar.a);
            this.b = fVar;
            this.c = new WeakReference<>(cVar);
        }

        @Override // e.t.f.c
        public void a(Set<String> set) {
            c cVar = this.c.get();
            if (cVar == null) {
                this.b.d(this);
            } else {
                cVar.a(set);
            }
        }
    }

    public f(g gVar, Map<String, String> map, Map<String, Set<String>> map2, String... strArr) {
        this.f1874d = gVar;
        this.f1878h = new b(strArr.length);
        this.a = new HashMap<>();
        this.c = map2;
        this.f1879i = new e(gVar);
        int length = strArr.length;
        this.b = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            String str = strArr[i2];
            Locale locale = Locale.US;
            String lowerCase = str.toLowerCase(locale);
            this.a.put(lowerCase, Integer.valueOf(i2));
            String str2 = map.get(strArr[i2]);
            if (str2 != null) {
                this.b[i2] = str2.toLowerCase(locale);
            } else {
                this.b[i2] = lowerCase;
            }
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            Locale locale2 = Locale.US;
            String lowerCase2 = entry.getValue().toLowerCase(locale2);
            if (this.a.containsKey(lowerCase2)) {
                String lowerCase3 = entry.getKey().toLowerCase(locale2);
                HashMap<String, Integer> hashMap = this.a;
                hashMap.put(lowerCase3, hashMap.get(lowerCase2));
            }
        }
    }

    public void a(c cVar) {
        d k2;
        boolean z;
        String[] e2 = e(cVar.a);
        int length = e2.length;
        int[] iArr = new int[length];
        int length2 = e2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            Integer num = this.a.get(e2[i2].toLowerCase(Locale.US));
            if (num != null) {
                iArr[i2] = num.intValue();
            } else {
                StringBuilder h2 = f.a.a.a.a.h("There is no table with name ");
                h2.append(e2[i2]);
                throw new IllegalArgumentException(h2.toString());
            }
        }
        d dVar = new d(cVar, iArr, e2);
        synchronized (this.f1880j) {
            k2 = this.f1880j.k(cVar, dVar);
        }
        if (k2 == null) {
            b bVar = this.f1878h;
            synchronized (bVar) {
                z = false;
                for (int i3 = 0; i3 < length; i3++) {
                    int i4 = iArr[i3];
                    long[] jArr = bVar.a;
                    long j2 = jArr[i4];
                    jArr[i4] = 1 + j2;
                    if (j2 == 0) {
                        bVar.f1882d = true;
                        z = true;
                    }
                }
            }
            if (z) {
                h();
            }
        }
    }

    public <T> LiveData<T> b(String[] strArr, boolean z, Callable<T> callable) {
        e eVar = this.f1879i;
        String[] e2 = e(strArr);
        for (String str : e2) {
            if (!this.a.containsKey(str.toLowerCase(Locale.US))) {
                throw new IllegalArgumentException(f.a.a.a.a.t("There is no table with name ", str));
            }
        }
        Objects.requireNonNull(eVar);
        return new j(eVar.b, eVar, z, callable, e2);
    }

    public boolean c() {
        if (!this.f1874d.j()) {
            return false;
        }
        if (!this.f1876f) {
            this.f1874d.f1885d.I();
        }
        if (this.f1876f) {
            return true;
        }
        Log.e("ROOM", "database is not initialized even though it is open");
        return false;
    }

    public void d(c cVar) {
        d l2;
        boolean z;
        synchronized (this.f1880j) {
            l2 = this.f1880j.l(cVar);
        }
        if (l2 != null) {
            b bVar = this.f1878h;
            int[] iArr = l2.a;
            synchronized (bVar) {
                z = false;
                for (int i2 : iArr) {
                    long[] jArr = bVar.a;
                    long j2 = jArr[i2];
                    jArr[i2] = j2 - 1;
                    if (j2 == 1) {
                        bVar.f1882d = true;
                        z = true;
                    }
                }
            }
            if (z) {
                h();
            }
        }
    }

    public final String[] e(String[] strArr) {
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            String lowerCase = str.toLowerCase(Locale.US);
            if (this.c.containsKey(lowerCase)) {
                hashSet.addAll(this.c.get(lowerCase));
            } else {
                hashSet.add(str);
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    public final void f(e.v.a.b bVar, int i2) {
        e.v.a.f.a aVar = (e.v.a.f.a) bVar;
        aVar.b.execSQL(f.a.a.a.a.r("INSERT OR IGNORE INTO room_table_modification_log VALUES(", i2, ", 0)"));
        String str = this.b[i2];
        StringBuilder sb = new StringBuilder();
        String[] strArr = f1873l;
        for (String str2 : strArr) {
            sb.setLength(0);
            sb.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
            sb.append("`");
            sb.append("room_table_modification_trigger_");
            sb.append(str);
            sb.append("_");
            sb.append(str2);
            sb.append("`");
            sb.append(" AFTER ");
            sb.append(str2);
            sb.append(" ON `");
            sb.append(str);
            sb.append("` BEGIN UPDATE ");
            sb.append("room_table_modification_log");
            sb.append(" SET ");
            sb.append("invalidated");
            sb.append(" = 1");
            sb.append(" WHERE ");
            sb.append("table_id");
            sb.append(" = ");
            sb.append(i2);
            sb.append(" AND ");
            sb.append("invalidated");
            sb.append(" = 0");
            sb.append("; END");
            aVar.b.execSQL(sb.toString());
        }
    }

    public final void g(e.v.a.b bVar, int i2) {
        String str = this.b[i2];
        StringBuilder sb = new StringBuilder();
        String[] strArr = f1873l;
        for (String str2 : strArr) {
            sb.setLength(0);
            sb.append("DROP TRIGGER IF EXISTS ");
            sb.append("`");
            sb.append("room_table_modification_trigger_");
            sb.append(str);
            sb.append("_");
            sb.append(str2);
            sb.append("`");
            ((e.v.a.f.a) bVar).b.execSQL(sb.toString());
        }
    }

    public void h() {
        if (this.f1874d.j()) {
            i(this.f1874d.f1885d.I());
        }
    }

    public void i(e.v.a.b bVar) {
        if (!((e.v.a.f.a) bVar).b.inTransaction()) {
            while (true) {
                try {
                    ReentrantReadWriteLock.ReadLock readLock = this.f1874d.f1890i.readLock();
                    readLock.lock();
                    try {
                        int[] a2 = this.f1878h.a();
                        if (a2 == null) {
                            readLock.unlock();
                            return;
                        }
                        int length = a2.length;
                        ((e.v.a.f.a) bVar).b.beginTransaction();
                        for (int i2 = 0; i2 < length; i2++) {
                            try {
                                int i3 = a2[i2];
                                if (i3 == 1) {
                                    f(bVar, i2);
                                } else if (i3 == 2) {
                                    g(bVar, i2);
                                }
                            } catch (Throwable th) {
                                ((e.v.a.f.a) bVar).b.endTransaction();
                                throw th;
                            }
                        }
                        ((e.v.a.f.a) bVar).b.setTransactionSuccessful();
                        ((e.v.a.f.a) bVar).b.endTransaction();
                        b bVar2 = this.f1878h;
                        synchronized (bVar2) {
                            bVar2.f1883e = false;
                        }
                    } finally {
                        readLock.unlock();
                    }
                } catch (SQLiteException | IllegalStateException e2) {
                    Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e2);
                    return;
                }
            }
        }
    }
}
