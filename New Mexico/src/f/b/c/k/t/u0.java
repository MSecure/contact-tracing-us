package f.b.c.k.t;

import android.database.Cursor;
import f.b.a.c.b.o.b;
import f.b.c.d;
import f.b.c.k.t.r0;
import f.b.c.k.u.c;
import f.b.c.k.u.f;
import f.b.c.k.u.i;
import f.b.c.k.u.j;
import f.b.c.k.u.m;
import f.b.c.k.u.n;
import f.b.c.k.v.a;
import f.b.c.k.v.b;
import f.b.c.k.v.d;
import f.b.c.k.x.g;
import f.b.d.a.d;
import f.b.d.a.s;
import f.b.g.d0;
import f.b.g.n0;
import f.b.g.p1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
/* loaded from: classes.dex */
public final class u0 implements k0 {
    public final r0 a;
    public final h b;

    public u0(r0 r0Var, h hVar) {
        this.a = r0Var;
        this.b = hVar;
    }

    @Override // f.b.c.k.t.k0
    public void a(i iVar, m mVar) {
        boolean z;
        b.P0(!mVar.equals(m.c), "Cannot add document to the RemoteDocumentCache with a read time of zero", new Object[0]);
        String f2 = f(iVar.a);
        d dVar = mVar.b;
        h hVar = this.b;
        Objects.requireNonNull(hVar);
        a.b l2 = a.l();
        if (iVar instanceof j) {
            j jVar = (j) iVar;
            b.C0119b h2 = f.b.c.k.v.b.h();
            String j2 = hVar.a.j(jVar.a);
            h2.copyOnWrite();
            f.b.c.k.v.b.c((f.b.c.k.v.b) h2.instance, j2);
            p1 o = hVar.a.o(jVar.b.b);
            h2.copyOnWrite();
            f.b.c.k.v.b.d((f.b.c.k.v.b) h2.instance, o);
            l2.copyOnWrite();
            a.d((a) l2.instance, h2.build());
            z = jVar.c;
        } else if (iVar instanceof c) {
            c cVar = (c) iVar;
            d.b j3 = f.b.d.a.d.j();
            String j4 = hVar.a.j(cVar.a);
            j3.copyOnWrite();
            f.b.d.a.d.c((f.b.d.a.d) j3.instance, j4);
            Map<String, s> f3 = cVar.f3624d.a.u().f();
            j3.copyOnWrite();
            ((n0) f.b.d.a.d.d((f.b.d.a.d) j3.instance)).putAll(f3);
            p1 o2 = hVar.a.o(cVar.b.b);
            j3.copyOnWrite();
            f.b.d.a.d.e((f.b.d.a.d) j3.instance, o2);
            l2.copyOnWrite();
            a.e((a) l2.instance, j3.build());
            z = cVar.c.equals(c.a.COMMITTED_MUTATIONS);
        } else if (iVar instanceof n) {
            n nVar = (n) iVar;
            d.b h3 = f.b.c.k.v.d.h();
            String j5 = hVar.a.j(nVar.a);
            h3.copyOnWrite();
            f.b.c.k.v.d.c((f.b.c.k.v.d) h3.instance, j5);
            p1 o3 = hVar.a.o(nVar.b.b);
            h3.copyOnWrite();
            f.b.c.k.v.d.d((f.b.c.k.v.d) h3.instance, o3);
            l2.copyOnWrite();
            a.f((a) l2.instance, h3.build());
            l2.b(true);
            this.a.f3619i.execSQL("INSERT OR REPLACE INTO remote_documents (path, read_time_seconds, read_time_nanos, contents) VALUES (?, ?, ?, ?)", new Object[]{f2, Long.valueOf(dVar.b), Integer.valueOf(dVar.c), l2.build().toByteArray()});
            this.a.f3615e.a(iVar.a.b.q());
        } else {
            f.b.a.c.b.o.b.r0("Unknown document type %s", iVar.getClass().getCanonicalName());
            throw null;
        }
        l2.b(z);
        this.a.f3619i.execSQL("INSERT OR REPLACE INTO remote_documents (path, read_time_seconds, read_time_nanos, contents) VALUES (?, ?, ?, ?)", new Object[]{f2, Long.valueOf(dVar.b), Integer.valueOf(dVar.c), l2.build().toByteArray()});
        this.a.f3615e.a(iVar.a.b.q());
    }

    @Override // f.b.c.k.t.k0
    public i b(f fVar) {
        Throwable th;
        Cursor cursor = null;
        i iVar = null;
        try {
            Cursor rawQueryWithFactory = this.a.f3619i.rawQueryWithFactory(new s0(new Object[]{f(fVar)}), "SELECT contents FROM remote_documents WHERE path = ?", null, null);
            try {
                if (rawQueryWithFactory.moveToFirst()) {
                    iVar = e(rawQueryWithFactory.getBlob(0));
                }
                rawQueryWithFactory.close();
                return iVar;
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
        }
    }

    @Override // f.b.c.k.t.k0
    public void c(f fVar) {
        this.a.f3619i.execSQL("DELETE FROM remote_documents WHERE path = ?", new Object[]{f(fVar)});
    }

    @Override // f.b.c.k.t.k0
    public Map<f, i> d(Iterable<f> iterable) {
        ArrayList arrayList = new ArrayList();
        for (f fVar : iterable) {
            arrayList.add(f.b.a.c.b.o.b.m0(fVar.b));
        }
        HashMap hashMap = new HashMap();
        for (f fVar2 : iterable) {
            hashMap.put(fVar2, null);
        }
        r0 r0Var = this.a;
        List emptyList = Collections.emptyList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ArrayList arrayList2 = new ArrayList(emptyList);
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            while (it.hasNext() && i2 < 900 - emptyList.size()) {
                if (i2 > 0) {
                    sb.append(", ");
                }
                sb.append("?");
                arrayList2.add(it.next());
                i2++;
            }
            String sb2 = sb.toString();
            r0.c k2 = r0Var.k("SELECT contents FROM remote_documents WHERE path IN (" + sb2 + ") ORDER BY path");
            k2.a(arrayList2.toArray());
            k2.b(new g(this, hashMap) { // from class: f.b.c.k.t.t0
                public final u0 a;
                public final Map b;

                {
                    this.a = r1;
                    this.b = r2;
                }

                @Override // f.b.c.k.x.g
                public void a(Object obj) {
                    u0 u0Var = this.a;
                    Map map = this.b;
                    i e2 = u0Var.e(((Cursor) obj).getBlob(0));
                    map.put(e2.a, e2);
                }
            });
        }
        return hashMap;
    }

    public final i e(byte[] bArr) {
        try {
            return this.b.a(a.m(bArr));
        } catch (d0 e2) {
            f.b.a.c.b.o.b.r0("MaybeDocument failed to parse: %s", e2);
            throw null;
        }
    }

    public final String f(f fVar) {
        return f.b.a.c.b.o.b.m0(fVar.b);
    }
}
