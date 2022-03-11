package f.b.a.a.a.c0;

import f.b.a.a.a.a0.r;
import f.b.a.a.a.h0.a;
import f.b.a.a.a.t.p0.a;
import f.b.a.c.f.b.c;
import f.b.a.c.f.b.f;
import f.b.a.c.i.e;
import f.b.a.c.i.h;
import java.util.Set;
import l.b.a.d;
/* loaded from: classes.dex */
public class q1 {
    public static final a c = a.e("ENClientWrapper");

    /* renamed from: d */
    public static final d f2205d = d.n(10);
    public final c a;
    public final r b;

    public q1(c cVar, r rVar) {
        this.a = cVar;
        this.b = rVar;
    }

    public h<f> a() {
        return this.a.f().h(i.a).p(new e(this));
    }

    public h<Set<f.b.a.c.f.b.d>> b() {
        return this.a.getStatus();
    }

    public h<Boolean> c() {
        return this.a.isEnabled().d(new e() { // from class: f.b.a.a.a.c0.p
            @Override // f.b.a.c.i.e
            public final void b(Exception exc) {
                q1.this.b.d(a.b.CALL_IS_ENABLED, exc);
            }
        }).f(new f.b.a.c.i.f() { // from class: f.b.a.a.a.c0.l
            @Override // f.b.a.c.i.f
            public final void a(Object obj) {
                Boolean bool = (Boolean) obj;
                q1.this.b.f(a.b.CALL_IS_ENABLED);
            }
        });
    }

    public h<Void> d() {
        return this.a.start().d(new e() { // from class: f.b.a.a.a.c0.n
            @Override // f.b.a.c.i.e
            public final void b(Exception exc) {
                q1.this.b.d(a.b.CALL_START, exc);
            }
        }).f(new f.b.a.c.i.f() { // from class: f.b.a.a.a.c0.r
            @Override // f.b.a.c.i.f
            public final void a(Object obj) {
                Void r2 = (Void) obj;
                q1.this.b.f(a.b.CALL_START);
            }
        });
    }

    public h<Void> e() {
        return this.a.stop().d(new e() { // from class: f.b.a.a.a.c0.q
            @Override // f.b.a.c.i.e
            public final void b(Exception exc) {
                q1.this.b.d(a.b.CALL_STOP, exc);
            }
        }).f(new f.b.a.c.i.f() { // from class: f.b.a.a.a.c0.o
            @Override // f.b.a.c.i.f
            public final void a(Object obj) {
                Void r2 = (Void) obj;
                q1.this.b.f(a.b.CALL_STOP);
            }
        });
    }
}
