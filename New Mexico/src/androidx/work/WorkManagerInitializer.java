package androidx.work;

import android.content.Context;
import e.c0.a0.l;
import e.c0.c;
import e.c0.n;
import e.c0.w;
import e.y.b;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class WorkManagerInitializer implements b<w> {
    public static final String a = n.e("WrkMgrInitializer");

    @Override // e.y.b
    public List<Class<? extends b<?>>> a() {
        return Collections.emptyList();
    }

    @Override // e.y.b
    public w b(Context context) {
        n.c().a(a, "Initializing WorkManager with default configuration.", new Throwable[0]);
        l.i(context, new c(new c.a()));
        return l.h(context);
    }
}
