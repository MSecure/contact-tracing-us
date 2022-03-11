package f.b.a.b.i;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public final class g implements Object<Executor> {

    /* loaded from: classes.dex */
    public static final class a {
        public static final g a = new g();
    }

    public Object get() {
        return new h(Executors.newSingleThreadExecutor());
    }
}
