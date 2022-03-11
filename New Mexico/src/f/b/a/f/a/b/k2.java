package f.b.a.f.a.b;

import f.b.a.f.a.c.d;
import f.b.a.f.a.e.r;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class k2 {
    public final d0 a;
    public final r<v3> b;
    public final s1 c;

    /* renamed from: d */
    public final r<Executor> f3258d;

    /* renamed from: e */
    public final d1 f3259e;

    /* renamed from: f */
    public final d f3260f;

    /* renamed from: g */
    public final m2 f3261g;

    public k2(d0 d0Var, r<v3> rVar, s1 s1Var, r<Executor> rVar2, d1 d1Var, d dVar, m2 m2Var) {
        this.a = d0Var;
        this.b = rVar;
        this.c = s1Var;
        this.f3258d = rVar2;
        this.f3259e = d1Var;
        this.f3260f = dVar;
        this.f3261g = m2Var;
    }

    public final void a(h2 h2Var) {
        File p = this.a.p(h2Var.b, h2Var.c, h2Var.f3229d);
        d0 d0Var = this.a;
        String str = h2Var.b;
        int i2 = h2Var.c;
        long j2 = h2Var.f3229d;
        Objects.requireNonNull(d0Var);
        File file = new File(new File(d0Var.f(str, i2, j2), "_slices"), "_metadata");
        if (!p.exists() || !file.exists()) {
            throw new z0(String.format("Cannot find pack files to move for pack %s.", h2Var.b), h2Var.a);
        }
        File n = this.a.n(h2Var.b, h2Var.c, h2Var.f3229d);
        n.mkdirs();
        if (p.renameTo(n)) {
            new File(this.a.n(h2Var.b, h2Var.c, h2Var.f3229d), "merge.tmp").delete();
            File o = this.a.o(h2Var.b, h2Var.c, h2Var.f3229d);
            o.mkdirs();
            if (file.renameTo(o)) {
                if (this.f3260f.a()) {
                    try {
                        this.f3261g.b(h2Var.b, h2Var.c, h2Var.f3229d, h2Var.f3230e);
                        this.f3258d.a().execute(new Runnable(h2Var) { // from class: f.b.a.f.a.b.j2
                            public final /* synthetic */ h2 c;

                            {
                                this.c = r2;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                k2 k2Var = k2.this;
                                h2 h2Var2 = this.c;
                                k2Var.a.b(h2Var2.b, h2Var2.c, h2Var2.f3229d);
                            }
                        });
                    } catch (IOException e2) {
                        throw new z0(String.format("Could not write asset pack version tag for pack %s: %s", h2Var.b, e2.getMessage()), h2Var.a);
                    }
                } else {
                    d0 d0Var2 = this.a;
                    d0Var2.getClass();
                    this.f3258d.a().execute(new Runnable() { // from class: f.b.a.f.a.b.i2
                        @Override // java.lang.Runnable
                        public final void run() {
                            d0 d0Var3 = d0.this;
                            Iterator it = ((ArrayList) d0Var3.h()).iterator();
                            while (it.hasNext()) {
                                File file2 = (File) it.next();
                                if (file2.listFiles() != null) {
                                    d0.i(file2);
                                    long d2 = d0.d(file2, false);
                                    if (((long) d0Var3.b.a()) != d2) {
                                        try {
                                            new File(new File(file2, String.valueOf(d2)), "stale.tmp").createNewFile();
                                        } catch (IOException unused) {
                                            d0.c.b("Could not write staleness marker.", new Object[0]);
                                        }
                                    }
                                    for (File file3 : file2.listFiles()) {
                                        d0.i(file3);
                                    }
                                }
                            }
                        }
                    });
                }
                s1 s1Var = this.c;
                s1Var.b(new k1(s1Var, h2Var.b, h2Var.c, h2Var.f3229d));
                this.f3259e.a(h2Var.b);
                this.b.a().e(h2Var.a, h2Var.b);
                return;
            }
            throw new z0("Cannot move metadata files to final location.", h2Var.a);
        }
        throw new z0("Cannot move merged pack files to final location.", h2Var.a);
    }
}
