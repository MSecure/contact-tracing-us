package b.r;

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
    public final HashMap<String, Integer> f1605a;

    /* renamed from: b  reason: collision with root package name */
    public final String[] f1606b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Set<String>> f1607c;

    /* renamed from: d  reason: collision with root package name */
    public final h f1608d;

    /* renamed from: e  reason: collision with root package name */
    public AtomicBoolean f1609e = new AtomicBoolean(false);
    public volatile boolean f = false;
    public volatile b.u.a.f g;
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
            Cursor query = f.this.f1608d.query(new b.u.a.a("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"));
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
                ((b.u.a.g.f) f.this.g).b();
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
            Lock closeLock = f.this.f1608d.getCloseLock();
            try {
                closeLock.lock();
                if (f.this.c()) {
                    try {
                        if (!f.this.f1609e.compareAndSet(true, false)) {
                            closeLock.unlock();
                        } else if (f.this.f1608d.inTransaction()) {
                            closeLock.unlock();
                        } else {
                            if (f.this.f1608d.mWriteAheadLoggingEnabled) {
                                b.u.a.b c2 = f.this.f1608d.getOpenHelper().c();
                                r5 = ((b.u.a.g.a) c2).f1742b;
                                r5.beginTransaction();
                                try {
                                    r5 = a();
                                    try {
                                        ((b.u.a.g.a) c2).f1742b.setTransactionSuccessful();
                                        ((b.u.a.g.a) c2).f1742b.endTransaction();
                                    } catch (Throwable th2) {
                                        th = th2;
                                        ((b.u.a.g.a) c2).f1742b.endTransaction();
                                        throw th;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    ((b.u.a.g.a) c2).f1742b.endTransaction();
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
                                            int length = dVar.f1617a.length;
                                            Set<String> set = null;
                                            for (int i = 0; i < length; i++) {
                                                if (r5.contains(Integer.valueOf(dVar.f1617a[i]))) {
                                                    if (length == 1) {
                                                        set = dVar.f1620d;
                                                    } else {
                                                        if (set == null) {
                                                            set = new HashSet<>(length);
                                                        }
                                                        set.add(dVar.f1618b[i]);
                                                    }
                                                }
                                            }
                                            if (set != null) {
                                                dVar.f1619c.b(set);
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
        public final long[] f1611a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean[] f1612b;

        /* renamed from: c  reason: collision with root package name */
        public final int[] f1613c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f1614d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f1615e;

        public b(int i) {
            long[] jArr = new long[i];
            this.f1611a = jArr;
            this.f1612b = new boolean[i];
            this.f1613c = new int[i];
            Arrays.fill(jArr, 0L);
            Arrays.fill(this.f1612b, false);
        }

        public int[] a() {
            synchronized (this) {
                if (this.f1614d) {
                    if (!this.f1615e) {
                        int length = this.f1611a.length;
                        int i = 0;
                        while (true) {
                            int i2 = 1;
                            if (i < length) {
                                boolean z = this.f1611a[i] > 0;
                                if (z != this.f1612b[i]) {
                                    int[] iArr = this.f1613c;
                                    if (!z) {
                                        i2 = 2;
                                    }
                                    iArr[i] = i2;
                                } else {
                                    this.f1613c[i] = 0;
                                }
                                this.f1612b[i] = z;
                                i++;
                            } else {
                                this.f1615e = true;
                                this.f1614d = false;
                                return this.f1613c;
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
        public final String[] f1616a;

        public c(String[] strArr) {
            this.f1616a = (String[]) Arrays.copyOf(strArr, strArr.length);
        }

        public boolean a() {
            return false;
        }

        public abstract void b(Set<String> set);
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final int[] f1617a;

        /* renamed from: b  reason: collision with root package name */
        public final String[] f1618b;

        /* renamed from: c  reason: collision with root package name */
        public final c f1619c;

        /* renamed from: d  reason: collision with root package name */
        public final Set<String> f1620d;

        public d(c cVar, int[] iArr, String[] strArr) {
            Set<String> set;
            this.f1619c = cVar;
            this.f1617a = iArr;
            this.f1618b = strArr;
            if (iArr.length == 1) {
                HashSet hashSet = new HashSet();
                hashSet.add(this.f1618b[0]);
                set = Collections.unmodifiableSet(hashSet);
            } else {
                set = null;
            }
            this.f1620d = set;
        }

        public void a(String[] strArr) {
            Set<String> set = null;
            if (this.f1618b.length == 1) {
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    } else if (strArr[i].equalsIgnoreCase(this.f1618b[0])) {
                        set = this.f1620d;
                        break;
                    } else {
                        i++;
                    }
                }
            } else {
                HashSet hashSet = new HashSet();
                for (String str : strArr) {
                    String[] strArr2 = this.f1618b;
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
                this.f1619c.b(set);
            }
        }
    }

    public static class e extends c {

        /* renamed from: b  reason: collision with root package name */
        public final f f1621b;

        /* renamed from: c  reason: collision with root package name */
        public final WeakReference<c> f1622c;

        public e(f fVar, c cVar) {
            super(cVar.f1616a);
            this.f1621b = fVar;
            this.f1622c = new WeakReference<>(cVar);
        }

        @Override // b.r.f.c
        public void b(Set<String> set) {
            c cVar = this.f1622c.get();
            if (cVar == null) {
                this.f1621b.d(this);
            } else {
                cVar.b(set);
            }
        }
    }

    public f(h hVar, Map<String, String> map, Map<String, Set<String>> map2, String... strArr) {
        this.f1608d = hVar;
        this.h = new b(strArr.length);
        this.f1605a = new HashMap<>();
        this.f1607c = map2;
        this.i = new e(this.f1608d);
        int length = strArr.length;
        this.f1606b = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            String lowerCase = strArr[i2].toLowerCase(Locale.US);
            this.f1605a.put(lowerCase, Integer.valueOf(i2));
            String str = map.get(strArr[i2]);
            if (str != null) {
                this.f1606b[i2] = str.toLowerCase(Locale.US);
            } else {
                this.f1606b[i2] = lowerCase;
            }
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String lowerCase2 = entry.getValue().toLowerCase(Locale.US);
            if (this.f1605a.containsKey(lowerCase2)) {
                String lowerCase3 = entry.getKey().toLowerCase(Locale.US);
                HashMap<String, Integer> hashMap = this.f1605a;
                hashMap.put(lowerCase3, hashMap.get(lowerCase2));
            }
        }
    }

    @SuppressLint({"RestrictedApi"})
    public void a(c cVar) {
        d h2;
        boolean z;
        String[] e2 = e(cVar.f1616a);
        int length = e2.length;
        int[] iArr = new int[length];
        int length2 = e2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            Integer num = this.f1605a.get(e2[i2].toLowerCase(Locale.US));
            if (num != null) {
                iArr[i2] = num.intValue();
            } else {
                StringBuilder g2 = c.a.a.a.a.g("There is no table with name ");
                g2.append(e2[i2]);
                throw new IllegalArgumentException(g2.toString());
            }
        }
        d dVar = new d(cVar, iArr, e2);
        synchronized (this.j) {
            h2 = this.j.h(cVar, dVar);
        }
        if (h2 == null) {
            b bVar = this.h;
            synchronized (bVar) {
                z = false;
                for (int i3 = 0; i3 < length; i3++) {
                    int i4 = iArr[i3];
                    long j2 = bVar.f1611a[i4];
                    bVar.f1611a[i4] = 1 + j2;
                    if (j2 == 0) {
                        bVar.f1614d = true;
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
            if (!this.f1605a.containsKey(str.toLowerCase(Locale.US))) {
                throw new IllegalArgumentException(c.a.a.a.a.o("There is no table with name ", str));
            }
        }
        if (eVar != null) {
            return new k(eVar.f1604b, eVar, z, callable, e2);
        }
        throw null;
    }

    public boolean c() {
        if (!this.f1608d.isOpen()) {
            return false;
        }
        if (!this.f) {
            this.f1608d.getOpenHelper().c();
        }
        return this.f;
    }

    @SuppressLint({"RestrictedApi"})
    public void d(c cVar) {
        d j2;
        boolean z;
        synchronized (this.j) {
            j2 = this.j.j(cVar);
        }
        if (j2 != null) {
            b bVar = this.h;
            int[] iArr = j2.f1617a;
            synchronized (bVar) {
                z = false;
                for (int i2 : iArr) {
                    long j3 = bVar.f1611a[i2];
                    bVar.f1611a[i2] = j3 - 1;
                    if (j3 == 1) {
                        bVar.f1614d = true;
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
            if (this.f1607c.containsKey(lowerCase)) {
                hashSet.addAll(this.f1607c.get(lowerCase));
            } else {
                hashSet.add(str);
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    public final void f(b.u.a.b bVar, int i2) {
        b.u.a.g.a aVar = (b.u.a.g.a) bVar;
        aVar.f1742b.execSQL(c.a.a.a.a.m("INSERT OR IGNORE INTO room_table_modification_log VALUES(", i2, ", 0)"));
        String str = this.f1606b[i2];
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
            aVar.f1742b.execSQL(sb.toString());
        }
    }

    public final void g(b.u.a.b bVar, int i2) {
        String str = this.f1606b[i2];
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
            ((b.u.a.g.a) bVar).f1742b.execSQL(sb.toString());
        }
    }

    public void h() {
        if (this.f1608d.isOpen()) {
            i(this.f1608d.getOpenHelper().c());
        }
    }

    public void i(b.u.a.b bVar) {
        b.u.a.g.a aVar = (b.u.a.g.a) bVar;
        if (!aVar.b()) {
            while (true) {
                Lock closeLock = this.f1608d.getCloseLock();
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
                        aVar.f1742b.beginTransaction();
                        for (int i2 = 0; i2 < length; i2++) {
                            try {
                                int i3 = a2[i2];
                                if (i3 == 1) {
                                    f(aVar, i2);
                                } else if (i3 == 2) {
                                    g(aVar, i2);
                                }
                            } catch (Throwable th) {
                                aVar.f1742b.endTransaction();
                                throw th;
                            }
                        }
                        aVar.f1742b.setTransactionSuccessful();
                        aVar.f1742b.endTransaction();
                        b bVar2 = this.h;
                        synchronized (bVar2) {
                            bVar2.f1615e = false;
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
