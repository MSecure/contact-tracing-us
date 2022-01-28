package androidx.work;

import android.content.Context;
import e.b0.a0.l;
import e.b0.c;
import e.b0.n;
import e.b0.w;
import e.x.b;
import java.util.Collections;
import java.util.List;

public final class WorkManagerInitializer implements b<w> {
    public static final String a = n.e("WrkMgrInitializer");

    @Override // e.x.b
    public List<Class<? extends b<?>>> a() {
        return Collections.emptyList();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // e.x.b
    public w b(Context context) {
        n.c().a(a, "Initializing WorkManager with default configuration.", new Throwable[0]);
        l.h(context, new c(new c.a()));
        return l.g(context);
    }
}
