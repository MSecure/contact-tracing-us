package f.b.c.k.w;

import f.b.c.k.w.b;
import f.b.c.k.x.m;
import h.a.c1;
import h.a.f;
import h.a.n0;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
/* loaded from: classes.dex */
public class q extends f.a<RespT> {
    public final /* synthetic */ d0 a;
    public final /* synthetic */ f[] b;
    public final /* synthetic */ t c;

    public q(t tVar, d0 d0Var, f[] fVarArr) {
        this.c = tVar;
        this.a = d0Var;
        this.b = fVarArr;
    }

    @Override // h.a.f.a
    public void a(c1 c1Var, n0 n0Var) {
        try {
            b.c cVar = (b.c) this.a;
            cVar.a.a(new Runnable(cVar, c1Var) { // from class: f.b.c.k.w.f
                public final b.c b;
                public final c1 c;

                {
                    this.b = r1;
                    this.c = r2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    b.c cVar2 = this.b;
                    c1 c1Var2 = this.c;
                    if (c1Var2.e()) {
                        m.a(m.a.DEBUG, b.this.getClass().getSimpleName(), "(%x) Stream closed.", Integer.valueOf(System.identityHashCode(b.this)));
                    } else {
                        m.a(m.a.WARN, b.this.getClass().getSimpleName(), "(%x) Stream closed with status: %s.", Integer.valueOf(System.identityHashCode(b.this)), c1Var2);
                    }
                    b bVar = b.this;
                    f.b.a.c.b.o.b.P0(bVar.d(), "Can't handle server close on non-started stream!", new Object[0]);
                    bVar.a(m0.Error, c1Var2);
                }
            });
        } catch (Throwable th) {
            this.c.a.c(th);
        }
    }

    @Override // h.a.f.a
    public void b(n0 n0Var) {
        try {
            b.c cVar = (b.c) this.a;
            cVar.a.a(new Runnable(cVar, n0Var) { // from class: f.b.c.k.w.c
                public final b.c b;
                public final n0 c;

                {
                    this.b = r1;
                    this.c = r2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Set<String> set;
                    b.c cVar2 = this.b;
                    n0 n0Var2 = this.c;
                    HashMap hashMap = new HashMap();
                    if (n0Var2.e()) {
                        set = Collections.emptySet();
                    } else {
                        HashSet hashSet = new HashSet(n0Var2.b);
                        for (int i2 = 0; i2 < n0Var2.b; i2++) {
                            hashSet.add(new String(n0Var2.g(i2), 0));
                        }
                        set = Collections.unmodifiableSet(hashSet);
                    }
                    for (String str : set) {
                        if (j.f3656d.contains(str.toLowerCase(Locale.ENGLISH))) {
                            hashMap.put(str, (String) n0Var2.d(n0.f.a(str, n0.c)));
                        }
                    }
                    if (!hashMap.isEmpty()) {
                        m.a(m.a.DEBUG, b.this.getClass().getSimpleName(), "(%x) Stream received headers: %s", Integer.valueOf(System.identityHashCode(b.this)), hashMap);
                    }
                }
            });
        } catch (Throwable th) {
            this.c.a.c(th);
        }
    }

    @Override // h.a.f.a
    public void c(RespT respt) {
        try {
            b.c cVar = (b.c) this.a;
            cVar.a.a(new Runnable(cVar, respt) { // from class: f.b.c.k.w.d
                public final b.c b;
                public final Object c;

                {
                    this.b = r1;
                    this.c = r2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    b.c cVar2 = this.b;
                    Object obj = this.c;
                    m.a(m.a.DEBUG, b.this.getClass().getSimpleName(), "(%x) Stream received: %s", Integer.valueOf(System.identityHashCode(b.this)), obj);
                    b.this.f(obj);
                }
            });
            this.b[0].b(1);
        } catch (Throwable th) {
            this.c.a.c(th);
        }
    }

    @Override // h.a.f.a
    public void d() {
    }
}
