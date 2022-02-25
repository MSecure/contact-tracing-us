package f.b.c.k.t;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import f.b.a.c.b.o.b;
import f.b.c.d;
import f.b.c.k.r.f;
import f.b.c.k.t.r0;
import f.b.c.k.u.l;
import f.b.c.k.u.p.e;
import f.b.c.k.v.e;
import f.b.c.k.w.t0;
import f.b.d.a.t;
import f.b.f.d0;
import f.b.f.j;
import f.b.f.p1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public final class q0 implements e0 {
    public final r0 a;
    public final h b;
    public final String c;

    /* renamed from: d  reason: collision with root package name */
    public int f3087d;

    /* renamed from: e  reason: collision with root package name */
    public j f3088e;

    public q0(r0 r0Var, h hVar, f fVar) {
        this.a = r0Var;
        this.b = hVar;
        String str = fVar.a;
        this.c = !(str != null) ? "" : str;
        this.f3088e = t0.s;
    }

    @Override // f.b.c.k.t.e0
    public j a() {
        return this.f3088e;
    }

    @Override // f.b.c.k.t.e0
    public void b(f.b.c.k.u.p.f fVar, j jVar) {
        Objects.requireNonNull(jVar);
        this.f3088e = jVar;
        l();
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x006d  */
    @Override // f.b.c.k.t.e0
    public void c() {
        Throwable th;
        Cursor cursor = null;
        try {
            Cursor rawQueryWithFactory = this.a.f3102i.rawQueryWithFactory(new s0(new Object[]{this.c}), "SELECT batch_id FROM mutations WHERE uid = ? LIMIT 1", null, null);
            try {
                boolean z = !rawQueryWithFactory.moveToFirst();
                rawQueryWithFactory.close();
                if (z) {
                    ArrayList arrayList = new ArrayList();
                    Cursor rawQueryWithFactory2 = this.a.f3102i.rawQueryWithFactory(new s0(new Object[]{this.c}), "SELECT path FROM document_mutations WHERE uid = ?", null, null);
                    while (rawQueryWithFactory2.moveToNext()) {
                        try {
                            arrayList.add(b.h0(rawQueryWithFactory2.getString(0)));
                        } catch (Throwable unused) {
                        }
                    }
                    rawQueryWithFactory2.close();
                    b.a1(arrayList.isEmpty(), "Document leak -- detected dangling mutation references when queue is empty. Dangling keys: %s", arrayList);
                    return;
                }
                return;
                throw th;
            } catch (Throwable th2) {
                th = th2;
                cursor = rawQueryWithFactory;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0046  */
    @Override // f.b.c.k.t.e0
    public f.b.c.k.u.p.f d(int i2) {
        Throwable th;
        Cursor cursor = null;
        f.b.c.k.u.p.f fVar = null;
        try {
            Cursor rawQueryWithFactory = this.a.f3102i.rawQueryWithFactory(new s0(new Object[]{1000000, this.c, Integer.valueOf(i2 + 1)}), "SELECT batch_id, SUBSTR(mutations, 1, ?) FROM mutations WHERE uid = ? AND batch_id >= ? ORDER BY batch_id ASC LIMIT 1", null, null);
            try {
                if (rawQueryWithFactory.moveToFirst()) {
                    fVar = k(rawQueryWithFactory.getInt(0), rawQueryWithFactory.getBlob(1));
                }
                rawQueryWithFactory.close();
                return fVar;
            } catch (Throwable th2) {
                th = th2;
                cursor = rawQueryWithFactory;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
            }
            throw th;
        }
    }

    @Override // f.b.c.k.t.e0
    public List<f.b.c.k.u.p.f> e(Iterable<f.b.c.k.u.f> iterable) {
        ArrayList arrayList = new ArrayList();
        for (f.b.c.k.u.f fVar : iterable) {
            arrayList.add(b.s0(fVar.b));
        }
        r0 r0Var = this.a;
        List asList = Arrays.asList(1000000, this.c);
        Iterator it = arrayList.iterator();
        ArrayList arrayList2 = new ArrayList();
        HashSet hashSet = new HashSet();
        int i2 = 0;
        while (it.hasNext()) {
            i2++;
            ArrayList arrayList3 = new ArrayList(asList);
            StringBuilder sb = new StringBuilder();
            int i3 = 0;
            while (it.hasNext() && i3 < 900 - asList.size()) {
                if (i3 > 0) {
                    sb.append(", ");
                }
                sb.append("?");
                arrayList3.add(it.next());
                i3++;
            }
            String sb2 = sb.toString();
            r0.c k2 = r0Var.k("SELECT DISTINCT dm.batch_id, SUBSTR(m.mutations, 1, ?) FROM document_mutations dm, mutations m WHERE dm.uid = ? AND dm.path IN (" + sb2 + ") AND dm.uid = m.uid AND dm.batch_id = m.batch_id ORDER BY dm.batch_id");
            k2.a(arrayList3.toArray());
            k2.b(new p0(this, hashSet, arrayList2));
        }
        if (i2 > 1) {
            Collections.sort(arrayList2, o0.a);
        }
        return arrayList2;
    }

    @Override // f.b.c.k.t.e0
    public f.b.c.k.u.p.f f(d dVar, List<e> list, List<e> list2) {
        int i2 = this.f3087d;
        this.f3087d = i2 + 1;
        f.b.c.k.u.p.f fVar = new f.b.c.k.u.p.f(i2, dVar, list, list2);
        h hVar = this.b;
        Objects.requireNonNull(hVar);
        e.b m = f.b.c.k.v.e.m();
        int i3 = fVar.a;
        m.copyOnWrite();
        f.b.c.k.v.e.c((f.b.c.k.v.e) m.instance, i3);
        p1 o = hVar.a.o(fVar.b);
        m.copyOnWrite();
        f.b.c.k.v.e.f((f.b.c.k.v.e) m.instance, o);
        for (f.b.c.k.u.p.e eVar : fVar.c) {
            t k2 = hVar.a.k(eVar);
            m.copyOnWrite();
            f.b.c.k.v.e.d((f.b.c.k.v.e) m.instance, k2);
        }
        for (f.b.c.k.u.p.e eVar2 : fVar.f3111d) {
            t k3 = hVar.a.k(eVar2);
            m.copyOnWrite();
            f.b.c.k.v.e.e((f.b.c.k.v.e) m.instance, k3);
        }
        r0 r0Var = this.a;
        r0Var.f3102i.execSQL("INSERT INTO mutations (uid, batch_id, mutations) VALUES (?, ?, ?)", new Object[]{this.c, Integer.valueOf(i2), ((f.b.c.k.v.e) m.build()).toByteArray()});
        HashSet hashSet = new HashSet();
        SQLiteStatement compileStatement = this.a.f3102i.compileStatement("INSERT INTO document_mutations (uid, path, batch_id) VALUES (?, ?, ?)");
        for (f.b.c.k.u.p.e eVar3 : list2) {
            f.b.c.k.u.f fVar2 = eVar3.a;
            if (hashSet.add(fVar2)) {
                String s0 = b.s0(fVar2.b);
                r0 r0Var2 = this.a;
                Object[] objArr = {this.c, s0, Integer.valueOf(i2)};
                Objects.requireNonNull(r0Var2);
                compileStatement.clearBindings();
                r0.j(compileStatement, objArr);
                compileStatement.executeUpdateDelete();
                this.a.f3098e.a((l) fVar2.b.q());
            }
        }
        return fVar;
    }

    @Override // f.b.c.k.t.e0
    public void g(j jVar) {
        Objects.requireNonNull(jVar);
        this.f3088e = jVar;
        l();
    }

    @Override // f.b.c.k.t.e0
    public List<f.b.c.k.u.p.f> h() {
        ArrayList arrayList = new ArrayList();
        Cursor rawQueryWithFactory = this.a.f3102i.rawQueryWithFactory(new s0(new Object[]{1000000, this.c}), "SELECT batch_id, SUBSTR(mutations, 1, ?) FROM mutations WHERE uid = ? ORDER BY batch_id ASC", null, null);
        while (rawQueryWithFactory.moveToNext()) {
            try {
                arrayList.add(k(rawQueryWithFactory.getInt(0), rawQueryWithFactory.getBlob(1)));
            } catch (Throwable unused) {
            }
        }
        rawQueryWithFactory.close();
        return arrayList;
        throw th;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0041  */
    @Override // f.b.c.k.t.e0
    public f.b.c.k.u.p.f i(int i2) {
        Throwable th;
        Cursor cursor = null;
        f.b.c.k.u.p.f fVar = null;
        try {
            Cursor rawQueryWithFactory = this.a.f3102i.rawQueryWithFactory(new s0(new Object[]{1000000, this.c, Integer.valueOf(i2)}), "SELECT SUBSTR(mutations, 1, ?) FROM mutations WHERE uid = ? AND batch_id = ?", null, null);
            try {
                if (rawQueryWithFactory.moveToFirst()) {
                    fVar = k(i2, rawQueryWithFactory.getBlob(0));
                }
                rawQueryWithFactory.close();
                return fVar;
            } catch (Throwable th2) {
                th = th2;
                cursor = rawQueryWithFactory;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
            }
            throw th;
        }
    }

    @Override // f.b.c.k.t.e0
    public void j(f.b.c.k.u.p.f fVar) {
        SQLiteStatement compileStatement = this.a.f3102i.compileStatement("DELETE FROM mutations WHERE uid = ? AND batch_id = ?");
        SQLiteStatement compileStatement2 = this.a.f3102i.compileStatement("DELETE FROM document_mutations WHERE uid = ? AND path = ? AND batch_id = ?");
        int i2 = fVar.a;
        r0 r0Var = this.a;
        Object[] objArr = {this.c, Integer.valueOf(i2)};
        Objects.requireNonNull(r0Var);
        compileStatement.clearBindings();
        r0.j(compileStatement, objArr);
        b.a1(compileStatement.executeUpdateDelete() != 0, "Mutation batch (%s, %d) did not exist", this.c, Integer.valueOf(fVar.a));
        for (f.b.c.k.u.p.e eVar : fVar.f3111d) {
            f.b.c.k.u.f fVar2 = eVar.a;
            String s0 = b.s0(fVar2.b);
            r0 r0Var2 = this.a;
            Object[] objArr2 = {this.c, s0, Integer.valueOf(i2)};
            Objects.requireNonNull(r0Var2);
            compileStatement2.clearBindings();
            r0.j(compileStatement2, objArr2);
            compileStatement2.executeUpdateDelete();
            this.a.f3100g.j(fVar2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0079  */
    public final f.b.c.k.u.p.f k(int i2, byte[] bArr) {
        Throwable th;
        Cursor cursor;
        try {
            if (bArr.length < 1000000) {
                return this.b.b(f.b.c.k.v.e.o(bArr));
            }
            ArrayList arrayList = new ArrayList();
            j jVar = j.c;
            arrayList.add(j.m(bArr, 0, bArr.length));
            boolean z = true;
            while (z) {
                try {
                    cursor = this.a.f3102i.rawQueryWithFactory(new s0(new Object[]{Integer.valueOf((arrayList.size() * 1000000) + 1), 1000000, this.c, Integer.valueOf(i2)}), "SELECT SUBSTR(mutations, ?, ?) FROM mutations WHERE uid = ? AND batch_id = ?", null, null);
                    try {
                        if (cursor.moveToFirst()) {
                            byte[] blob = cursor.getBlob(0);
                            j jVar2 = j.c;
                            arrayList.add(j.m(blob, 0, blob.length));
                            if (blob.length < 1000000) {
                                z = false;
                            }
                        }
                        cursor.close();
                    } catch (Throwable th2) {
                        th = th2;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor = null;
                    if (cursor != null) {
                    }
                    throw th;
                }
            }
            j jVar3 = j.c;
            int size = arrayList.size();
            return this.b.b(f.b.c.k.v.e.n(size == 0 ? j.c : j.h(arrayList.iterator(), size)));
        } catch (d0 e2) {
            b.z0("MutationBatch failed to parse: %s", e2);
            throw null;
        }
    }

    public final void l() {
        r0 r0Var = this.a;
        r0Var.f3102i.execSQL("INSERT OR REPLACE INTO mutation_queues (uid, last_acknowledged_batch_id, last_stream_token) VALUES (?, ?, ?)", new Object[]{this.c, -1, this.f3088e.z()});
    }

    @Override // f.b.c.k.t.e0
    public void start() {
        boolean z;
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        Cursor rawQuery = this.a.f3102i.rawQuery("SELECT uid FROM mutation_queues", null);
        while (true) {
            try {
                z = false;
                if (!rawQuery.moveToNext()) {
                    break;
                }
                arrayList.add(rawQuery.getString(0));
            } catch (Throwable unused) {
            }
        }
        rawQuery.close();
        this.f3087d = 0;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Cursor rawQueryWithFactory = this.a.f3102i.rawQueryWithFactory(new s0(new Object[]{(String) it.next()}), "SELECT MAX(batch_id) FROM mutations WHERE uid = ?", null, null);
            while (rawQueryWithFactory.moveToNext()) {
                try {
                    this.f3087d = Math.max(this.f3087d, rawQueryWithFactory.getInt(0));
                } catch (Throwable unused2) {
                }
            }
            rawQueryWithFactory.close();
        }
        this.f3087d++;
        try {
            Cursor rawQueryWithFactory2 = this.a.f3102i.rawQueryWithFactory(new s0(new Object[]{this.c}), "SELECT last_stream_token FROM mutation_queues WHERE uid = ?", null, null);
            if (rawQueryWithFactory2.moveToFirst()) {
                this.f3088e = j.l(rawQueryWithFactory2.getBlob(0));
                rawQueryWithFactory2.close();
                z = true;
            } else {
                rawQueryWithFactory2.close();
            }
            if (!z) {
                l();
                return;
            }
            return;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
        throw th;
        throw th;
    }
}
