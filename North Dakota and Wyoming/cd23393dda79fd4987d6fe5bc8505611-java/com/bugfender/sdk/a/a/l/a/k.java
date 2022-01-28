package com.bugfender.sdk.a.a.l.a;

import android.util.Log;
import com.bugfender.sdk.a.a.d.b.f.a;
import com.bugfender.sdk.a.a.h.h;
import com.bugfender.sdk.a.a.j.b;
import java.util.concurrent.Callable;

public class k implements Callable<Boolean> {
    private final b a;
    private final h b;

    public k(b bVar, h hVar) {
        this.a = bVar;
        this.b = hVar;
    }

    @Override // java.util.concurrent.Callable
    public Boolean call() {
        try {
            this.a.a(this.b);
            return true;
        } catch (a e) {
            Log.e(com.bugfender.sdk.a.a.b.E, e.getMessage());
            return false;
        }
    }
}
