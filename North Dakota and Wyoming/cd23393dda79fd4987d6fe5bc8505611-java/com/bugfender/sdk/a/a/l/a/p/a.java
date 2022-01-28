package com.bugfender.sdk.a.a.l.a.p;

import com.bugfender.sdk.a.a.j.b;
import java.util.concurrent.Callable;

public class a implements Callable<Boolean> {
    private final b a;

    public a(b bVar) {
        this.a = bVar;
    }

    @Override // java.util.concurrent.Callable
    public Boolean call() {
        return Boolean.valueOf(this.a.f().g());
    }
}
