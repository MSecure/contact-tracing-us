package com.bugfender.sdk.a.a.l.a.o;

import com.bugfender.sdk.a.a.h.c;
import com.bugfender.sdk.a.a.h.f;
import com.bugfender.sdk.a.a.i.a;
import com.bugfender.sdk.a.a.l.a.l;
import java.util.Map;
import java.util.concurrent.Callable;

public class b implements Callable<l<Boolean>> {
    private final a a;
    private final com.bugfender.sdk.a.a.g.a<String> b;
    private final c c;

    public b(a aVar, com.bugfender.sdk.a.a.g.a<String> aVar2, c cVar) {
        this.a = aVar;
        this.b = aVar2;
        this.c = cVar;
    }

    @Override // java.util.concurrent.Callable
    public l<Boolean> call() {
        Map<String, ?> a2 = this.b.a();
        for (String str : a2.keySet()) {
            try {
                this.a.a(this.c.a(), this.c.l(), new f<>(str, a2.get(str)));
                this.b.b(str);
            } catch (com.bugfender.sdk.a.a.d.b.b e) {
                return new l<>(false, e);
            }
        }
        return new l<>(true);
    }
}
