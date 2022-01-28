package com.bugfender.sdk.a.a.l.a.p;

import android.util.Log;
import com.bugfender.sdk.a.a.d.b.d;
import com.bugfender.sdk.a.a.h.e;
import com.bugfender.sdk.a.a.h.g;
import com.bugfender.sdk.a.a.h.h;
import com.bugfender.sdk.a.a.i.a;
import com.bugfender.sdk.a.a.j.b;
import com.bugfender.sdk.a.a.l.a.l;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class c implements Callable<l<Boolean>> {
    private final a a;
    private final b b;
    private final String c;
    private final com.bugfender.sdk.a.a.l.a.m.a d;
    private final List<h> e;

    public c(a aVar, b bVar, String str, com.bugfender.sdk.a.a.l.a.m.a aVar2) {
        this.a = aVar;
        this.b = bVar;
        this.c = str;
        this.d = aVar2;
        this.e = null;
    }

    private List<h> a() {
        List<h> list = this.e;
        if (list == null || list.size() <= 0) {
            return this.b.a();
        }
        return this.e;
    }

    @Override // java.util.concurrent.Callable
    public l<Boolean> call() {
        boolean z;
        try {
            List<h> a2 = a();
            Iterator<h> it = a2.iterator();
            int i = 0;
            while (true) {
                z = true;
                if (!it.hasNext()) {
                    break;
                }
                h next = it.next();
                try {
                    if (a(next, 30)) {
                        this.b.a(next.f());
                    } else {
                        com.bugfender.sdk.a.a.j.c<g> c2 = this.b.c(next);
                        com.bugfender.sdk.a.a.j.c<e> d2 = this.b.d(next);
                        com.bugfender.sdk.a.a.j.c<String> b2 = this.b.b(next);
                        com.bugfender.sdk.a.a.j.a<g> a3 = c2.a(1);
                        com.bugfender.sdk.a.a.j.a<e> d3 = d2.d();
                        com.bugfender.sdk.a.a.j.a<String> d4 = b2.d();
                        if (a3.c() || d3.c() || d4.c()) {
                            if (next.k() <= 0) {
                                long a4 = this.a.a(next);
                                next.a(a4);
                                this.b.a(next.f(), a4);
                            }
                            if (d3.c()) {
                                for (e eVar : d3.a()) {
                                    eVar.a(next.k());
                                    eVar.a(new com.bugfender.sdk.a.a.h.a(this.c));
                                    this.a.a(eVar);
                                }
                            }
                            while (a3.c()) {
                                this.a.a(next.k(), a3.a());
                                c2.a(a3.b());
                                a3 = c2.a(1);
                            }
                            if (d4.c()) {
                                this.d.a(next, d4.a());
                            }
                            this.b.a(next.f());
                            i++;
                        } else {
                            this.b.a(next.f());
                        }
                    }
                } catch (Exception e2) {
                    Log.e(com.bugfender.sdk.a.a.b.E, "There was a problem sending the old session " + next.f());
                    if (!(e2 instanceof d) && !(e2 instanceof com.bugfender.sdk.a.a.i.c.a.a)) {
                        this.b.a(next.f());
                    }
                }
            }
            if (a2.size() != 0 && i <= 0) {
                z = false;
            }
            return new l<>(Boolean.valueOf(z));
        } catch (Exception e3) {
            return new l<>(false, e3);
        }
    }

    private static boolean a(h hVar, int i) {
        return new Date().getTime() - hVar.m().getTime() >= TimeUnit.DAYS.toMillis((long) i);
    }

    public c(a aVar, b bVar, String str, List<h> list) {
        this.a = aVar;
        this.b = bVar;
        this.c = str;
        this.d = null;
        this.e = list;
    }
}
