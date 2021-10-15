package b.s;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import androidx.lifecycle.LiveData;
import b.c.a.b.b;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;

public class f {
    public static final String[] m = {"UPDATE", "DELETE", "INSERT"};

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, Integer> f2463a;

    /* renamed from: b  reason: collision with root package name */
    public final String[] f2464b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Set<String>> f2465c;

    /* renamed from: d  reason: collision with root package name */
    public final h f2466d;

    /* renamed from: e  reason: collision with root package name */
    public AtomicBoolean f2467e = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f2468f = false;

    /* renamed from: g  reason: collision with root package name */
    public volatile b.w.a.f f2469g;
    public b h;
    public final e i;
    @SuppressLint({"RestrictedApi"})
    public final b.c.a.b.b<c, d> j = new b.c.a.b.b<>();
    public g k;
    public Runnable l = new a();

    public class a implements Runnable {
        public a() {
        }

        /* JADX INFO: finally extract failed */
        public final Set<Integer> a() {
            HashSet hashSet = new HashSet();
            Cursor query = f.this.f2466d.query(new b.w.a.a("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"));
            while (query.moveToNext()) {
                try {
                    hashSet.add(Integer.valueOf(query.getInt(0)));
                } catch (Throwable th) {
                    query.close();
                    throw th;
                }
            }
            query.close();
            if (!hashSet.isEmpty()) {
                ((b.w.a.g.f) f.this.f2469g).b();
            }
            return hashSet;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:? */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v0, types: [java.util.Set] */
        /* JADX WARN: Type inference failed for: r5v1 */
        /* JADX WARN: Type inference failed for: r5v2, types: [java.util.Set] */
        /* JADX WARN: Type inference failed for: r5v5, types: [android.database.sqlite.SQLiteDatabase] */
        /* JADX WARN: Type inference failed for: r5v8, types: [java.util.Set] */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0077, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0078, code lost:
            r0.unlock();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x007b, code lost:
            throw r1;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x0077 A[ExcHandler:  FINALLY, Splitter:B:1:0x000b] */
        /* JADX WARNING: Unknown variable types count: 1 */
        public void run() {
            ?? r5;
            Throwable th;
            Lock closeLock = f.this.f2466d.getCloseLock();
            try {
                closeLock.lock();
                if (f.this.c()) {
                    try {
                        if (!f.this.f2467e.compareAndSet(true, false)) {
                            closeLock.unlock();
                        } else if (f.this.f2466d.inTransaction()) {
                            closeLock.unlock();
                        } else {
                            if (f.this.f2466d.mWriteAheadLoggingEnabled) {
                                b.w.a.b p = f.this.f2466d.getOpenHelper().p();
                                r5 = ((b.w.a.g.a) p).f2616b;
                                r5.beginTransaction();
                                try {
                                    r5 = a();
                                    try {
                                        ((b.w.a.g.a) p).f2616b.setTransactionSuccessful();
                                        ((b.w.a.g.a) p).f2616b.endTransaction();
                                    } catch (Throwable th2) {
                                        th = th2;
                                        ((b.w.a.g.a) p).f2616b.endTransaction();
                                        throw th;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    ((b.w.a.g.a) p).f2616b.endTransaction();
                                    throw th;
                                }
                            } else {
                                r5 = a();
                            }
                            closeLock.unlock();
                            if (!(r5 == 0 || r5.isEmpty())) {
                                synchronized (f.this.j) {
                                    Iterator<Map.Entry<c, d>> it = f.this.j.iterator();
                                    while (true) {
                                        b.e eVar = (b.e) it;
                                        if (eVar.hasNext()) {
                                            d dVar = (d) ((Map.Entry) eVar.next()).getValue();
                                            int length = dVar.f2477a.length;
                                            Set<String> set = null;
                                            for (int i = 0; i < length; i++) {
                                                if (r5.contains(Integer.valueOf(dVar.f2477a[i]))) {
                                                    if (length == 1) {
                                                        set = dVar.f2480d;
                                                    } else {
                                                        if (set == null) {
                                                            set = new HashSet<>(length);
                                                        }
                                                        set.add(dVar.f2478b[i]);
                                                    }
                                                }
                                            }
                                            if (set != null) {
                                                dVar.f2479c.b(set);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } catch (SQLiteException | IllegalStateException unused) {
                        r5 = 0;
                    }
                }
            } catch (SQLiteException | IllegalStateException unused2) {
            } finally {
            }
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final long[] f2471a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean[] f2472b;

        /* renamed from: c  reason: collision with root package name */
        public final int[] f2473c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f2474d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f2475e;

        public b(int i) {
            long[] jArr = new long[i];
            this.f2471a = jArr;
            this.f2472b = new boolean[i];
            this.f2473c = new int[i];
            Arrays.fill(jArr, 0L);
            Arrays.fill(this.f2472b, false);
        }

        public int[] a() {
            synchronized (this) {
                if (this.f2474d) {
                    if (!this.f2475e) {
                        int length = this.f2471a.length;
                        int i = 0;
                        while (true) {
                            int i2 = 1;
                            if (i < length) {
                                boolean z = this.f2471a[i] > 0;
                                if (z != this.f2472b[i]) {
                                    int[] iArr = this.f2473c;
                                    if (!z) {
                                        i2 = 2;
                                    }
                                    iArr[i] = i2;
                                } else {
                                    this.f2473c[i] = 0;
                                }
                                this.f2472b[i] = z;
                                i++;
                            } else {
                                this.f2475e = true;
                                this.f2474d = false;
                                return this.f2473c;
                            }
                        }
                    }
                }
                return null;
            }
        }
    }

    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        public final String[] f2476a;

        public c(String[] strArr) {
            this.f2476a = (String[]) Arrays.copyOf(strArr, strArr.length);
        }

        public boolean a() {
            return false;
        }

        public abstract void b(Set<String> set);
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final int[] f2477a;

        /* renamed from: b  reason: collision with root package name */
        public final String[] f2478b;

        /* renamed from: c  reason: collision with root package name */
        public final c f2479c;

        /* renamed from: d  reason: collision with root package name */
        public final Set<String> f2480d;

        public d(c cVar, int[] iArr, String[] strArr) {
            Set<String> set;
            this.f2479c = cVar;
            this.f2477a = iArr;
            this.f2478b = strArr;
            if (iArr.length == 1) {
                HashSet hashSet = new HashSet();
                hashSet.add(this.f2478b[0]);
                set = Collections.unmodifiableSet(hashSet);
            } else {
                set = null;
            }
            this.f2480d = set;
        }

        public void a(String[] strArr) {
            Set<String> set = null;
            if (this.f2478b.length == 1) {
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    } else if (strArr[i].equalsIgnoreCase(this.f2478b[0])) {
                        set = this.f2480d;
                        break;
                    } else {
                        i++;
                    }
                }
            } else {
                HashSet hashSet = new HashSet();
                for (String str : strArr) {
                    String[] strArr2 = this.f2478b;
                    int length2 = strArr2.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length2) {
                            break;
                        }
                        String str2 = strArr2[i2];
                        if (str2.equalsIgnoreCase(str)) {
                            hashSet.add(str2);
                            break;
                        }
                        i2++;
                    }
                }
                if (hashSet.size() > 0) {
                    set = hashSet;
                }
            }
            if (set != null) {
                this.f2479c.b(set);
            }
        }
    }

    public static class e extends c {

        /* renamed from: b  reason: collision with root package name */
        public final f f2481b;

        /* renamed from: c  reason: collision with root package name */
        public final WeakReference<c> f2482c;

        public e(f fVar, c cVar) {
            super(cVar.f2476a);
            this.f2481b = fVar;
            this.f2482c = new WeakReference<>(cVar);
        }

        @Override // b.s.f.c
        public void b(Set<String> set) {
            c cVar = this.f2482c.get();
            if (cVar == null) {
                this.f2481b.d(this);
            } else {
                cVar.b(set);
            }
        }
    }

    public f(h hVar, Map<String, String> map, Map<String, Set<String>> map2, String... strArr) {
        this.f2466d = hVar;
        this.h = new b(strArr.length);
        this.f2463a = new HashMap<>();
        this.f2465c = map2;
        this.i = new e(this.f2466d);
        int length = strArr.length;
        this.f2464b = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            String lowerCase = strArr[i2].toLowerCase(Locale.US);
            this.f2463a.put(lowerCase, Integer.valueOf(i2));
            String str = map.get(strArr[i2]);
            if (str != null) {
                this.f2464b[i2] = str.toLowerCase(Locale.US);
            } else {
                this.f2464b[i2] = lowerCase;
            }
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String lowerCase2 = entry.getValue().toLowerCase(Locale.US);
            if (this.f2463a.containsKey(lowerCase2)) {
                String lowerCase3 = entry.getKey().toLowerCase(Locale.US);
                HashMap<String, Integer> hashMap = this.f2463a;
                hashMap.put(lowerCase3, hashMap.get(lowerCase2));
            }
        }
    }

    @SuppressLint({"RestrictedApi"})
    public void a(c cVar) {
        d g2;
        boolean z;
        String[] e2 = e(cVar.f2476a);
        int length = e2.length;
        int[] iArr = new int[length];
        int length2 = e2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            Integer num = this.f2463a.get(e2[i2].toLowerCase(Locale.US));
            if (num != null) {
                iArr[i2] = num.intValue();
            } else {
                StringBuilder h2 = c.a.a.a.a.h("There is no table with name ");
                h2.append(e2[i2]);
                throw new IllegalArgumentException(h2.toString());
            }
        }
        d dVar = new d(cVar, iArr, e2);
        synchronized (this.j) {
            g2 = this.j.g(cVar, dVar);
        }
        if (g2 == null) {
            b bVar = this.h;
            synchronized (bVar) {
                z = false;
                for (int i3 = 0; i3 < length; i3++) {
                    int i4 = iArr[i3];
                    long j2 = bVar.f2471a[i4];
                    bVar.f2471a[i4] = 1 + j2;
                    if (j2 == 0) {
                        bVar.f2474d = true;
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
        e eVar = this.i;
        String[] e2 = e(strArr);
        for (String str : e2) {
            if (!this.f2463a.containsKey(str.toLowerCase(Locale.US))) {
                throw new IllegalArgumentException(c.a.a.a.a.q("There is no table with name ", str));
            }
        }
        if (eVar != null) {
            return new k(eVar.f2462b, eVar, z, callable, e2);
        }
        throw null;
    }

    public boolean c() {
        if (!this.f2466d.isOpen()) {
            return false;
        }
        if (!this.f2468f) {
            this.f2466d.getOpenHelper().p();
        }
        return this.f2468f;
    }

    @SuppressLint({"RestrictedApi"})
    public void d(c cVar) {
        d h2;
        boolean z;
        synchronized (this.j) {
            h2 = this.j.h(cVar);
        }
        if (h2 != null) {
            b bVar = this.h;
            int[] iArr = h2.f2477a;
            synchronized (bVar) {
                z = false;
                for (int i2 : iArr) {
                    long j2 = bVar.f2471a[i2];
                    bVar.f2471a[i2] = j2 - 1;
                    if (j2 == 1) {
                        bVar.f2474d = true;
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
            if (this.f2465c.containsKey(lowerCase)) {
                hashSet.addAll(this.f2465c.get(lowerCase));
            } else {
                hashSet.add(str);
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    public final void f(b.w.a.b bVar, int i2) {
        b.w.a.g.a aVar = (b.w.a.g.a) bVar;
        aVar.f2616b.execSQL(c.a.a.a.a.o("INSERT OR IGNORE INTO room_table_modification_log VALUES(", i2, ", 0)"));
        String str = this.f2464b[i2];
        StringBuilder sb = new StringBuilder();
        String[] strArr = m;
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
            aVar.f2616b.execSQL(sb.toString());
        }
    }

    public final void g(b.w.a.b bVar, int i2) {
        String str = this.f2464b[i2];
        StringBuilder sb = new StringBuilder();
        String[] strArr = m;
        for (String str2 : strArr) {
            sb.setLength(0);
            sb.append("DROP TRIGGER IF EXISTS ");
            sb.append("`");
            sb.append("room_table_modification_trigger_");
            sb.append(str);
            sb.append("_");
            sb.append(str2);
            sb.append("`");
            ((b.w.a.g.a) bVar).f2616b.execSQL(sb.toString());
        }
    }

    public void h() {
        if (this.f2466d.isOpen()) {
            i(this.f2466d.getOpenHelper().p());
        }
    }

    public void i(b.w.a.b bVar) {
        b.w.a.g.a aVar = (b.w.a.g.a) bVar;
        if (!aVar.b()) {
            while (true) {
                Lock closeLock = this.f2466d.getCloseLock();
                closeLock.lock();
                try {
                    int[] a2 = this.h.a();
                    if (a2 == null) {
                        try {
                            return;
                        } catch (SQLiteException | IllegalStateException unused) {
                            return;
                        }
                    } else {
                        int length = a2.length;
                        aVar.f2616b.beginTransaction();
                        for (int i2 = 0; i2 < length; i2++) {
                            try {
                                int i3 = a2[i2];
                                if (i3 == 1) {
                                    f(aVar, i2);
                                } else if (i3 == 2) {
                                    g(aVar, i2);
                                }
                            } catch (Throwable th) {
                                aVar.f2616b.endTransaction();
                                throw th;
                            }
                        }
                        aVar.f2616b.setTransactionSuccessful();
                        aVar.f2616b.endTransaction();
                        b bVar2 = this.h;
                        synchronized (bVar2) {
                            bVar2.f2475e = false;
                        }
                        closeLock.unlock();
                    }
                } finally {
                    closeLock.unlock();
                }
            }
        }
    }
}
