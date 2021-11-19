package com.bugfender.sdk.a.a.l.a.n;

import com.bugfender.sdk.a.a.h.e;
import com.bugfender.sdk.a.a.h.h;
import com.bugfender.sdk.a.a.i.a;
import com.bugfender.sdk.a.a.j.c;
import com.bugfender.sdk.a.a.l.a.l;
import java.io.File;
import java.util.concurrent.Callable;

public class b implements Callable<l<Boolean>> {
    private final com.bugfender.sdk.a.a.j.b a;
    private final a b;
    private final String c;

    public b(com.bugfender.sdk.a.a.j.b bVar, a aVar, String str) {
        this.a = bVar;
        this.b = aVar;
        this.c = str;
    }

    @Override // java.util.concurrent.Callable
    public l<Boolean> call() {
        h c2 = this.a.c();
        c<e> b2 = this.a.b();
        com.bugfender.sdk.a.a.j.a<e> e = b2.e();
        if (e.c()) {
            if (c2.k() <= 0) {
                try {
                    long a2 = this.b.a(c2);
                    c2.a(a2);
                    this.a.d(a2);
                } catch (com.bugfender.sdk.a.a.d.b.b e2) {
                    return new l<>(false, e2);
                }
            }
            boolean z = false;
            for (e eVar : e.a()) {
                eVar.a((long) ((int) c2.k()));
                eVar.a(new com.bugfender.sdk.a.a.h.a(this.c));
                try {
                    this.b.a(eVar);
                    z = true;
                } catch (com.bugfender.sdk.a.a.d.b.b e3) {
                    return new l<>(false, e3);
                }
            }
            if (z) {
                b2.a(e.b());
            }
            return new l<>(Boolean.valueOf(z));
        }
        if (e.b().size() > 0) {
            for (File file : e.b()) {
                file.delete();
            }
        }
        return new l<>(true);
    }
}
