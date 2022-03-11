package e.t;

import e.t.g;
import e.v.a.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.TreeMap;

public class h extends c.a {
    public a b;
    public final a c;

    /* renamed from: d  reason: collision with root package name */
    public final String f1903d;

    /* renamed from: e  reason: collision with root package name */
    public final String f1904e;

    public static abstract class a {
        public final int a;

        public a(int i2) {
            this.a = i2;
        }

        public abstract void a(e.v.a.b bVar);

        public abstract void b(e.v.a.b bVar);

        public abstract void c(e.v.a.b bVar);

        public abstract void d(e.v.a.b bVar);

        public abstract void e(e.v.a.b bVar);

        public abstract void f(e.v.a.b bVar);

        public abstract b g(e.v.a.b bVar);
    }

    public static class b {
        public final boolean a;
        public final String b;

        public b(boolean z, String str) {
            this.a = z;
            this.b = str;
        }
    }

    public h(a aVar, a aVar2, String str, String str2) {
        super(aVar2.a);
        this.b = aVar;
        this.c = aVar2;
        this.f1903d = str;
        this.f1904e = str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0079, code lost:
        r0 = r3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:63:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    @Override // e.v.a.c.a
    public void b(e.v.a.b bVar, int i2, int i3) {
        List<e.t.o.a> list;
        int i4;
        boolean z;
        boolean z2;
        a aVar = this.b;
        boolean z3 = true;
        if (aVar != null) {
            g.d dVar = aVar.f1864d;
            Objects.requireNonNull(dVar);
            if (i2 == i3) {
                list = Collections.emptyList();
            } else {
                boolean z4 = i3 > i2;
                ArrayList arrayList = new ArrayList();
                int i5 = i2;
                while (true) {
                    if (z4) {
                        if (i5 >= i3) {
                            break;
                        }
                    } else if (i5 <= i3) {
                        break;
                    }
                    TreeMap<Integer, e.t.o.a> treeMap = dVar.a.get(Integer.valueOf(i5));
                    if (treeMap == null) {
                        break;
                    }
                    Iterator<Integer> it = (z4 ? treeMap.descendingKeySet() : treeMap.keySet()).iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            i4 = i5;
                            z = false;
                            break;
                        }
                        i4 = it.next().intValue();
                        if (!z4 ? i4 < i3 || i4 >= i5 : i4 > i3 || i4 <= i5) {
                            z2 = false;
                            continue;
                        } else {
                            z2 = true;
                            continue;
                        }
                        if (z2) {
                            arrayList.add(treeMap.get(Integer.valueOf(i4)));
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        break;
                    }
                    i5 = i4;
                }
                list = null;
            }
            if (list != null) {
                this.c.f(bVar);
                for (e.t.o.a aVar2 : list) {
                    aVar2.a(bVar);
                }
                b g2 = this.c.g(bVar);
                if (g2.a) {
                    this.c.e(bVar);
                    c(bVar);
                    if (z3) {
                        a aVar3 = this.b;
                        if (aVar3 == null || aVar3.a(i2, i3)) {
                            throw new IllegalStateException("A migration from " + i2 + " to " + i3 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
                        }
                        this.c.b(bVar);
                        this.c.a(bVar);
                        return;
                    }
                    return;
                }
                StringBuilder h2 = f.a.a.a.a.h("Migration didn't properly handle: ");
                h2.append(g2.b);
                throw new IllegalStateException(h2.toString());
            }
        }
        z3 = false;
        if (z3) {
        }
    }

    public final void c(e.v.a.b bVar) {
        e.v.a.f.a aVar = (e.v.a.f.a) bVar;
        aVar.b.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        aVar.b.execSQL(f.a.a.a.a.c("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '", this.f1903d, "')"));
    }
}
