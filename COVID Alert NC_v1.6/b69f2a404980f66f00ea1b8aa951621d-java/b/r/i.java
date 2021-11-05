package b.r;

import b.r.h;
import b.u.a.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

public class i extends c.a {

    /* renamed from: b  reason: collision with root package name */
    public a f1646b;

    /* renamed from: c  reason: collision with root package name */
    public final a f1647c;

    /* renamed from: d  reason: collision with root package name */
    public final String f1648d;

    /* renamed from: e  reason: collision with root package name */
    public final String f1649e;

    public static abstract class a {
        public final int version;

        public a(int i) {
            this.version = i;
        }

        public abstract void createAllTables(b.u.a.b bVar);

        public abstract void dropAllTables(b.u.a.b bVar);

        public abstract void onCreate(b.u.a.b bVar);

        public abstract void onOpen(b.u.a.b bVar);

        public abstract void onPostMigrate(b.u.a.b bVar);

        public abstract void onPreMigrate(b.u.a.b bVar);

        public abstract b onValidateSchema(b.u.a.b bVar);

        @Deprecated
        public void validateMigration(b.u.a.b bVar) {
            throw new UnsupportedOperationException("validateMigration is deprecated");
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f1650a;

        /* renamed from: b  reason: collision with root package name */
        public final String f1651b;

        public b(boolean z, String str) {
            this.f1650a = z;
            this.f1651b = str;
        }
    }

    public i(a aVar, a aVar2, String str, String str2) {
        super(aVar2.version);
        this.f1646b = aVar;
        this.f1647c = aVar2;
        this.f1648d = str;
        this.f1649e = str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0075, code lost:
        r3 = r5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:66:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    @Override // b.u.a.c.a
    public void b(b.u.a.b bVar, int i, int i2) {
        List<b.r.p.a> list;
        boolean z;
        boolean z2;
        a aVar = this.f1646b;
        boolean z3 = true;
        if (aVar != null) {
            h.d dVar = aVar.f1599d;
            ArrayList arrayList = null;
            if (dVar != null) {
                if (i == i2) {
                    list = Collections.emptyList();
                } else {
                    boolean z4 = i2 > i;
                    ArrayList arrayList2 = new ArrayList();
                    int i3 = i;
                    while (true) {
                        if (z4) {
                            if (i3 >= i2) {
                                break;
                            }
                        } else if (i3 <= i2) {
                            break;
                        }
                        TreeMap<Integer, b.r.p.a> treeMap = dVar.f1645a.get(Integer.valueOf(i3));
                        if (treeMap == null) {
                            break;
                        }
                        Iterator<Integer> it = (z4 ? treeMap.descendingKeySet() : treeMap.keySet()).iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = false;
                                continue;
                                break;
                            }
                            int intValue = it.next().intValue();
                            if (!z4 ? intValue < i2 || intValue >= i3 : intValue > i2 || intValue <= i3) {
                                z2 = false;
                                continue;
                            } else {
                                z2 = true;
                                continue;
                            }
                            if (z2) {
                                arrayList2.add(treeMap.get(Integer.valueOf(intValue)));
                                z = true;
                                i3 = intValue;
                                continue;
                                break;
                            }
                        }
                        if (!z) {
                            break;
                        }
                    }
                    list = arrayList;
                }
                if (list != null) {
                    this.f1647c.onPreMigrate(bVar);
                    for (b.r.p.a aVar2 : list) {
                        aVar2.a(bVar);
                    }
                    b onValidateSchema = this.f1647c.onValidateSchema(bVar);
                    if (onValidateSchema.f1650a) {
                        this.f1647c.onPostMigrate(bVar);
                        c(bVar);
                        if (z3) {
                            a aVar3 = this.f1646b;
                            if (aVar3 == null || aVar3.a(i, i2)) {
                                throw new IllegalStateException("A migration from " + i + " to " + i2 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
                            }
                            this.f1647c.dropAllTables(bVar);
                            this.f1647c.createAllTables(bVar);
                            return;
                        }
                        return;
                    }
                    StringBuilder g = c.a.a.a.a.g("Migration didn't properly handle: ");
                    g.append(onValidateSchema.f1651b);
                    throw new IllegalStateException(g.toString());
                }
            } else {
                throw null;
            }
        }
        z3 = false;
        if (z3) {
        }
    }

    public final void c(b.u.a.b bVar) {
        b.u.a.g.a aVar = (b.u.a.g.a) bVar;
        aVar.f1742b.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        aVar.f1742b.execSQL(c.a.a.a.a.p("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '", this.f1648d, "')"));
    }
}
