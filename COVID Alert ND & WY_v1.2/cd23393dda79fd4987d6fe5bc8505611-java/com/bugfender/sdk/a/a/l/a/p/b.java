package com.bugfender.sdk.a.a.l.a.p;

import com.bugfender.sdk.a.a.d.b.d;
import com.bugfender.sdk.a.a.h.g;
import com.bugfender.sdk.a.a.h.h;
import com.bugfender.sdk.a.a.i.a;
import com.bugfender.sdk.a.a.j.c;
import com.bugfender.sdk.a.a.l.a.l;
import java.io.File;
import java.util.concurrent.Callable;

public class b implements Callable<l<Boolean>> {
    private final com.bugfender.sdk.a.a.j.b a;
    private final a b;
    private final g c;

    public b(com.bugfender.sdk.a.a.j.b bVar, a aVar) {
        this.a = bVar;
        this.b = aVar;
        this.c = null;
    }

    private com.bugfender.sdk.a.a.j.a<g> a(c<g> cVar) {
        return cVar.b(1);
    }

    @Override // java.util.concurrent.Callable
    public l<Boolean> call() {
        try {
            h c2 = this.a.c();
            if (c2.k() <= 0) {
                try {
                    long a2 = this.b.a(c2);
                    c2.a(a2);
                    this.a.d(a2);
                } catch (com.bugfender.sdk.a.a.d.b.b e) {
                    if (!(e instanceof d)) {
                        e.printStackTrace();
                    }
                    return new l<>(false, e);
                }
            }
            c<g> f = this.a.f();
            com.bugfender.sdk.a.a.j.a<g> a3 = a(f);
            if (this.c != null) {
                a3.a().add(this.c);
            }
            boolean z = true;
            if (a3.c() || a3.b().size() <= 0) {
                while (a3.c()) {
                    try {
                        this.b.a(c2.k(), a3.a());
                        z &= f.a(a3.b());
                        a3 = a(f);
                    } catch (com.bugfender.sdk.a.a.d.b.b e2) {
                        if (!(e2 instanceof d)) {
                            e2.printStackTrace();
                        }
                        return new l<>(false, e2);
                    }
                }
                return new l<>(Boolean.valueOf(z));
            }
            for (File file : a3.b()) {
                file.delete();
            }
            return new l<>(true, null);
        } catch (Throwable th) {
            if (!(th instanceof d) || !(th instanceof com.bugfender.sdk.a.a.i.c.a.a)) {
                th.printStackTrace();
            }
            return new l<>(false, th);
        }
    }

    public b(com.bugfender.sdk.a.a.j.b bVar, a aVar, g gVar) {
        this.c = gVar;
        this.a = bVar;
        this.b = aVar;
    }
}
