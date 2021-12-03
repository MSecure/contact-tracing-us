package androidx.lifecycle;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import e.q.h;
import e.q.i;
import e.q.l;
import e.q.v;
import e.q.w;
import e.x.b;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class ProcessLifecycleInitializer implements b<l> {
    @Override // e.x.b
    public List<Class<? extends b<?>>> a() {
        return Collections.emptyList();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // e.x.b
    public l b(Context context) {
        if (!i.a.getAndSet(true)) {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new i.a());
        }
        v vVar = v.f1815j;
        Objects.requireNonNull(vVar);
        vVar.f1818f = new Handler();
        vVar.f1819g.e(h.a.ON_CREATE);
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new w(vVar));
        return vVar;
    }
}
