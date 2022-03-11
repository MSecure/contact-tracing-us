package e.v;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
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
/* loaded from: classes.dex */
public class f {

    /* renamed from: l */
    public static final String[] f2049l = {"UPDATE", "DELETE", "INSERT"};
    public final String[] b;
    public Map<String, Set<String>> c;

    /* renamed from: d */
    public final g f2050d;

    /* renamed from: g */
    public volatile e.x.a.f.f f2053g;

    /* renamed from: h */
    public b f2054h;

    /* renamed from: i */
    public final e f2055i;

    /* renamed from: e */
    public AtomicBoolean f2051e = new AtomicBoolean(false);

    /* renamed from: f */
    public volatile boolean f2052f = false;

    /* renamed from: j */
    public final e.c.a.b.b<c, d> f2056j = new e.c.a.b.b<>();

    /* renamed from: k */
    public Runnable f2057k = new a();
    public final HashMap<String, Integer> a = new HashMap<>();

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
            f.this = r1;
        }

        /* JADX WARN: Finally extract failed */
        public final Set<Integer> a() {
            HashSet hashSet = new HashSet();
            Cursor k2 = f.this.f2050d.k(new e.x.a.a("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"), null);
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
                f.this.f2053g.d();
            }
            return hashSet;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Set<Integer> set;
            Throwable th;
            ReentrantReadWriteLock.ReadLock readLock = f.this.f2050d.f2066i.readLock();
            try {
                try {
                    readLock.lock();
                } finally {
                    readLock.unlock();
                }
            } catch (SQLiteException | IllegalStateException unused) {
                set = null;
            }
            if (f.this.c()) {
                if (f.this.f2051e.compareAndSet(true, false)) {
                    if (!f.this.f2050d.h()) {
                        g gVar = f.this.f2050d;
                        boolean z = gVar.f2064g;
                        if (z != 0) {
                            try {
                                e.x.a.b E = gVar.f2061d.E();
                                ((e.x.a.f.a) E).b.beginTransaction();
                                try {
                                    Set<Integer> a = a();
                                    try {
                                        ((e.x.a.f.a) E).b.setTransactionSuccessful();
                                        ((e.x.a.f.a) E).b.endTransaction();
                                        set = a;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        ((e.x.a.f.a) E).b.endTransaction();
                                        throw th;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                            } catch (SQLiteException | IllegalStateException unused2) {
                                set = z;
                            }
                        } else {
                            set = a();
                        }
                        if (!(set == null || set.isEmpty())) {
                            synchronized (f.this.f2056j) {
                                Iterator<Map.Entry<c, d>> it = f.this.f2056j.iterator();
                                while (true) {
                                    b.e eVar = (b.e) it;
                                    if (eVar.hasNext()) {
                                        d dVar = (d) ((Map.Entry) eVar.next()).getValue();
                                        int length = dVar.a.length;
                                        Set<String> set2 = null;
                                        for (int i2 = 0; i2 < length; i2++) {
                                            if (set.contains(Integer.valueOf(dVar.a[i2]))) {
                                                if (length == 1) {
                                                    set2 = dVar.f2060d;
                                                } else {
                                                    if (set2 == null) {
                                                        set2 = new HashSet<>(length);
                                                    }
                                                    set2.add(dVar.b[i2]);
                                                }
                                            }
                                        }
                                        if (set2 != null) {
                                            dVar.c.a(set2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public final long[] a;
        public final boolean[] b;
        public final int[] c;

        /* renamed from: d */
        public boolean f2058d;

        /* renamed from: e */
        public boolean f2059e;

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
                if (this.f2058d && !this.f2059e) {
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
                            this.f2059e = true;
                            this.f2058d = false;
                            return this.c;
                        }
                    }
                }
                return null;
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class c {
        public final String[] a;

        public c(String[] strArr) {
            this.a = (String[]) Arrays.copyOf(strArr, strArr.length);
        }

        public abstract void a(Set<String> set);
    }

    /* loaded from: classes.dex */
    public static class d {
        public final int[] a;
        public final String[] b;
        public final c c;

        /* renamed from: d */
        public final Set<String> f2060d;

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
            this.f2060d = set;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends c {
        public final f b;
        public final WeakReference<c> c;

        public e(f fVar, c cVar) {
            super(cVar.a);
            this.b = fVar;
            this.c = new WeakReference<>(cVar);
        }

        @Override // e.v.f.c
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
        this.f2050d = gVar;
        this.f2054h = new b(strArr.length);
        this.c = map2;
        this.f2055i = new e(gVar);
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
        synchronized (this.f2056j) {
            k2 = this.f2056j.k(cVar, dVar);
        }
        if (k2 == null) {
            b bVar = this.f2054h;
            synchronized (bVar) {
                z = false;
                for (int i3 = 0; i3 < length; i3++) {
                    int i4 = iArr[i3];
                    long[] jArr = bVar.a;
                    long j2 = jArr[i4];
                    jArr[i4] = 1 + j2;
                    if (j2 == 0) {
                        bVar.f2058d = true;
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
        e eVar = this.f2055i;
        String[] e2 = e(strArr);
        for (String str : e2) {
            if (!this.a.containsKey(str.toLowerCase(Locale.US))) {
                throw new IllegalArgumentException(f.a.a.a.a.x("There is no table with name ", str));
            }
        }
        Objects.requireNonNull(eVar);
        return new j(eVar.b, eVar, z, callable, e2);
    }

    public boolean c() {
        if (!this.f2050d.j()) {
            return false;
        }
        if (!this.f2052f) {
            this.f2050d.f2061d.E();
        }
        if (!this.f2052f) {
            return false;
        }
        return true;
    }

    public void d(c cVar) {
        d l2;
        boolean z;
        synchronized (this.f2056j) {
            l2 = this.f2056j.l(cVar);
        }
        if (l2 != null) {
            b bVar = this.f2054h;
            int[] iArr = l2.a;
            synchronized (bVar) {
                z = false;
                for (int i2 : iArr) {
                    long[] jArr = bVar.a;
                    long j2 = jArr[i2];
                    jArr[i2] = j2 - 1;
                    if (j2 == 1) {
                        bVar.f2058d = true;
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

    public final void f(e.x.a.b bVar, int i2) {
        e.x.a.f.a aVar = (e.x.a.f.a) bVar;
        aVar.b.execSQL(f.a.a.a.a.v("INSERT OR IGNORE INTO room_table_modification_log VALUES(", i2, ", 0)"));
        String str = this.b[i2];
        StringBuilder sb = new StringBuilder();
        String[] strArr = f2049l;
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

    public final void g(e.x.a.b bVar, int i2) {
        String str = this.b[i2];
        StringBuilder sb = new StringBuilder();
        String[] strArr = f2049l;
        for (String str2 : strArr) {
            sb.setLength(0);
            sb.append("DROP TRIGGER IF EXISTS ");
            sb.append("`");
            sb.append("room_table_modification_trigger_");
            sb.append(str);
            sb.append("_");
            sb.append(str2);
            sb.append("`");
            ((e.x.a.f.a) bVar).b.execSQL(sb.toString());
        }
    }

    public void h() {
        if (this.f2050d.j()) {
            i(this.f2050d.f2061d.E());
        }
    }

    public void i(e.x.a.b bVar) {
        if (!((e.x.a.f.a) bVar).b.inTransaction()) {
            while (true) {
                try {
                    ReentrantReadWriteLock.ReadLock readLock = this.f2050d.f2066i.readLock();
                    readLock.lock();
                    try {
                        int[] a2 = this.f2054h.a();
                        if (a2 != null) {
                            int length = a2.length;
                            ((e.x.a.f.a) bVar).b.beginTransaction();
                            for (int i2 = 0; i2 < length; i2++) {
                                int i3 = a2[i2];
                                if (i3 == 1) {
                                    f(bVar, i2);
                                } else if (i3 == 2) {
                                    g(bVar, i2);
                                }
                            }
                            ((e.x.a.f.a) bVar).b.setTransactionSuccessful();
                            ((e.x.a.f.a) bVar).b.endTransaction();
                            b bVar2 = this.f2054h;
                            synchronized (bVar2) {
                                bVar2.f2059e = false;
                            }
                        } else {
                            return;
                        }
                    } finally {
                        readLock.unlock();
                    }
                } catch (SQLiteException | IllegalStateException unused) {
                    return;
                }
            }
        }
    }
}
