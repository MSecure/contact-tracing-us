package com.bugfender.sdk.a.a.l.a.o;

import com.bugfender.sdk.a.a.g.a;
import com.bugfender.sdk.a.a.h.f;
import java.util.concurrent.Callable;

public class c<T> implements Callable<Boolean> {
    private final a<String> a;
    private f<T> b;

    public c(a<String> aVar, f<T> fVar) {
        this.a = aVar;
        this.b = fVar;
    }

    @Override // java.util.concurrent.Callable
    public Boolean call() {
        if (this.b.b() instanceof Float) {
            return Boolean.valueOf(this.a.a(this.b.a(), (Float) this.b.b()));
        }
        if (this.b.b() instanceof Integer) {
            return Boolean.valueOf(this.a.a(this.b.a(), (Integer) this.b.b()));
        }
        if (this.b.b() instanceof String) {
            return Boolean.valueOf(this.a.a(this.b.a(), (String) this.b.b()));
        }
        if (this.b.b() instanceof Boolean) {
            return Boolean.valueOf(this.a.a(this.b.a(), (Boolean) this.b.b()));
        }
        return false;
    }
}
