package androidx.lifecycle;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import e.r.h;
import e.r.i;
import e.r.l;
import e.r.v;
import e.r.w;
import e.y.b;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
/* loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements b<l> {
    @Override // e.y.b
    public List<Class<? extends b<?>>> a() {
        return Collections.emptyList();
    }

    @Override // e.y.b
    public l b(Context context) {
        if (!i.a.getAndSet(true)) {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new i.a());
        }
        v vVar = v.f1900j;
        Objects.requireNonNull(vVar);
        vVar.f1903f = new Handler();
        vVar.f1904g.e(h.a.ON_CREATE);
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new w(vVar));
        return vVar;
    }
}
