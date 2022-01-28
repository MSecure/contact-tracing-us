package com.bugfender.sdk.a.a.l.a.o;

import com.bugfender.sdk.a.a.d.b.b;
import com.bugfender.sdk.a.a.h.c;
import com.bugfender.sdk.a.a.h.f;
import java.util.concurrent.Callable;

public class a implements Callable<Boolean> {
    private final com.bugfender.sdk.a.a.g.a<String> a;
    private final com.bugfender.sdk.a.a.i.a b;
    private final c c;
    private String d;

    public a(com.bugfender.sdk.a.a.g.a<String> aVar, com.bugfender.sdk.a.a.i.a aVar2, c cVar, String str) {
        this.a = aVar;
        this.b = aVar2;
        this.c = cVar;
        this.d = str;
    }

    @Override // java.util.concurrent.Callable
    public Boolean call() {
        try {
            this.b.a(this.c.a(), this.c.l(), new f<>(this.d, null));
            return Boolean.valueOf(this.a.a(this.d));
        } catch (b unused) {
            return false;
        }
    }
}
