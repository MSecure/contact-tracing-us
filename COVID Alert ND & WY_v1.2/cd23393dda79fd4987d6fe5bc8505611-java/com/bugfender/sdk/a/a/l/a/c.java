package com.bugfender.sdk.a.a.l.a;

import com.bugfender.sdk.a.a.d.b.b;
import com.bugfender.sdk.a.a.h.d;
import com.bugfender.sdk.a.a.i.a;
import java.util.concurrent.Callable;

public class c implements Callable<d> {
    private final a a;
    private final com.bugfender.sdk.a.a.g.a<String> b;
    private final com.bugfender.sdk.a.a.h.c c;

    public c(a aVar, com.bugfender.sdk.a.a.h.c cVar, com.bugfender.sdk.a.a.g.a<String> aVar2) {
        this.a = aVar;
        this.c = cVar;
        this.b = aVar2;
    }

    @Override // java.util.concurrent.Callable
    public d call() {
        try {
            return this.a.a(this.c.a(), this.c, this.b.a(true));
        } catch (b e) {
            if (!(e instanceof com.bugfender.sdk.a.a.d.b.a)) {
                return d.d;
            }
            throw e;
        }
    }
}
