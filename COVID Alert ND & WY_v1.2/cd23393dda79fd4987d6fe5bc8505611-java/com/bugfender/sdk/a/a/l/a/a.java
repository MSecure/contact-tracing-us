package com.bugfender.sdk.a.a.l.a;

import android.util.Log;
import com.bugfender.sdk.a.a.h.g;
import com.bugfender.sdk.a.a.j.b;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;

public class a<T> implements Callable<Boolean> {
    private final b a;
    private final e<T> b;
    private final j<T> c;
    private final com.bugfender.sdk.a.a.i.a d;
    private final AtomicLong e;
    private final T f;

    public a(b bVar, j<T> jVar, T t, com.bugfender.sdk.a.a.i.a aVar, e<T> eVar, AtomicLong atomicLong) {
        this.a = bVar;
        this.c = jVar;
        this.f = t;
        this.d = aVar;
        this.b = eVar;
        this.e = atomicLong;
    }

    private g a() {
        return new g.b().b(0).a(g.c.d.a()).a(this.e.getAndIncrement()).a(new Date(System.currentTimeMillis())).c("bf_disk_error").b("").a("").d("Bugfender couldn't store the entry in disk due to an error.").f("").e("").a();
    }

    @Override // java.util.concurrent.Callable
    public Boolean call() {
        boolean a2 = this.c.a().a((Object) this.b.a(this.f));
        if (!a2) {
            Log.e(com.bugfender.sdk.a.a.b.E, "Bugfender couldn't store the log in disk due to an error.");
            new com.bugfender.sdk.a.a.l.a.p.b(this.a, this.d, a()).call();
        }
        return Boolean.valueOf(a2);
    }
}
