package f.b.a.b.i;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class g implements Object<Executor> {

    public static final class a {
        public static final g a = new g();
    }

    public Object get() {
        return new h(Executors.newSingleThreadExecutor());
    }
}
