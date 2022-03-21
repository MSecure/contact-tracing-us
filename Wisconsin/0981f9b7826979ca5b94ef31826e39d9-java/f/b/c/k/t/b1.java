package f.b.c.k.t;

import android.database.sqlite.SQLiteStatement;
import f.b.a.c.b.o.b;
import f.b.c.d;
import f.b.c.g.a.f;
import f.b.c.k.s.c0;
import f.b.c.k.u.m;
import f.b.c.k.v.c;
import f.b.c.k.w.h0;
import f.b.d.a.q;
import f.b.f.d0;
import f.b.f.j;
import f.b.f.p1;
import java.util.Iterator;
import java.util.Objects;

public final class b1 implements c1 {
    public final r0 a;
    public final h b;
    public int c;

    /* renamed from: d  reason: collision with root package name */
    public long f3080d;

    /* renamed from: e  reason: collision with root package name */
    public m f3081e = m.c;

    /* renamed from: f  reason: collision with root package name */
    public long f3082f;

    public b1(r0 r0Var, h hVar) {
        this.a = r0Var;
        this.b = hVar;
    }

    @Override // f.b.c.k.t.c1
    public m a() {
        return this.f3081e;
    }

    @Override // f.b.c.k.t.c1
    public void b(f<f.b.c.k.u.f> fVar, int i2) {
        SQLiteStatement compileStatement = this.a.f3110i.compileStatement("INSERT OR IGNORE INTO target_documents (target_id, path) VALUES (?, ?)");
        n0 n0Var = this.a.f3108g;
        Iterator<f.b.c.k.u.f> it = fVar.iterator();
        while (true) {
            f.a aVar = (f.a) it;
            if (aVar.hasNext()) {
                f.b.c.k.u.f fVar2 = (f.b.c.k.u.f) aVar.next();
                String s0 = b.s0(fVar2.b);
                r0 r0Var = this.a;
                Object[] objArr = {Integer.valueOf(i2), s0};
                Objects.requireNonNull(r0Var);
                compileStatement.clearBindings();
                r0.j(compileStatement, objArr);
                compileStatement.executeUpdateDelete();
                n0Var.j(fVar2);
            } else {
                return;
            }
        }
    }

    @Override // f.b.c.k.t.c1
    public void c(f<f.b.c.k.u.f> fVar, int i2) {
        SQLiteStatement compileStatement = this.a.f3110i.compileStatement("DELETE FROM target_documents WHERE target_id = ? AND path = ?");
        n0 n0Var = this.a.f3108g;
        Iterator<f.b.c.k.u.f> it = fVar.iterator();
        while (true) {
            f.a aVar = (f.a) it;
            if (aVar.hasNext()) {
                f.b.c.k.u.f fVar2 = (f.b.c.k.u.f) aVar.next();
                String s0 = b.s0(fVar2.b);
                r0 r0Var = this.a;
                Object[] objArr = {Integer.valueOf(i2), s0};
                Objects.requireNonNull(r0Var);
                compileStatement.clearBindings();
                r0.j(compileStatement, objArr);
                compileStatement.executeUpdateDelete();
                n0Var.j(fVar2);
            } else {
                return;
            }
        }
    }

    @Override // f.b.c.k.t.c1
    public void d(d1 d1Var) {
        int i2 = d1Var.b;
        String a2 = d1Var.a.a();
        d dVar = d1Var.f3087e.b;
        h hVar = this.b;
        Objects.requireNonNull(hVar);
        h0 h0Var = h0.LISTEN;
        boolean z = false;
        boolean z2 = true;
        b.a1(h0Var.equals(d1Var.f3086d), "Only queries with purpose %s may be stored, got %s", h0Var, d1Var.f3086d);
        c.b s = c.s();
        int i3 = d1Var.b;
        s.copyOnWrite();
        c.g((c) s.instance, i3);
        long j2 = d1Var.c;
        s.copyOnWrite();
        c.j((c) s.instance, j2);
        p1 p = hVar.a.p(d1Var.f3088f);
        s.copyOnWrite();
        c.e((c) s.instance, p);
        p1 p2 = hVar.a.p(d1Var.f3087e);
        s.copyOnWrite();
        c.h((c) s.instance, p2);
        j jVar = d1Var.f3089g;
        s.copyOnWrite();
        c.i((c) s.instance, jVar);
        c0 c0Var = d1Var.a;
        boolean c2 = c0Var.c();
        h0 h0Var2 = hVar.a;
        if (c2) {
            q.c h2 = h0Var2.h(c0Var);
            s.copyOnWrite();
            c.d((c) s.instance, h2);
        } else {
            q.d m = h0Var2.m(c0Var);
            s.copyOnWrite();
            c.c((c) s.instance, m);
        }
        r0 r0Var = this.a;
        r0Var.f3110i.execSQL("INSERT OR REPLACE INTO targets (target_id, canonical_id, snapshot_version_seconds, snapshot_version_nanos, resume_token, last_listen_sequence_number, target_proto) VALUES (?, ?, ?, ?, ?, ?, ?)", new Object[]{Integer.valueOf(i2), a2, Long.valueOf(dVar.b), Integer.valueOf(dVar.c), d1Var.f3089g.z(), Long.valueOf(d1Var.c), ((c) s.build()).toByteArray()});
        int i4 = d1Var.b;
        if (i4 > this.c) {
            this.c = i4;
            z = true;
        }
        long j3 = d1Var.c;
        if (j3 > this.f3080d) {
            this.f3080d = j3;
        } else {
            z2 = z;
        }
        if (z2) {
            h();
        }
    }

    @Override // f.b.c.k.t.c1
    public void e(m mVar) {
        this.f3081e = mVar;
        h();
    }

    @Override // f.b.c.k.t.c1
    public int f() {
        return this.c;
    }

    public final d1 g(byte[] bArr) {
        try {
            return this.b.c(c.t(bArr));
        } catch (d0 e2) {
            b.z0("TargetData failed to parse: %s", e2);
            throw null;
        }
    }

    public final void h() {
        r0 r0Var = this.a;
        r0Var.f3110i.execSQL("UPDATE target_globals SET highest_target_id = ?, highest_listen_sequence_number = ?, last_remote_snapshot_version_seconds = ?, last_remote_snapshot_version_nanos = ?, target_count = ?", new Object[]{Integer.valueOf(this.c), Long.valueOf(this.f3080d), Long.valueOf(this.f3081e.b.b), Integer.valueOf(this.f3081e.b.c), Long.valueOf(this.f3082f)});
    }
}
