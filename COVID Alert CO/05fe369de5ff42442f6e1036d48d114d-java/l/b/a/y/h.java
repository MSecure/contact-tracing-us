package l.b.a.y;

import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public abstract class h {
    public static final AtomicBoolean a = new AtomicBoolean(false);
    public static final AtomicReference<h> b = new AtomicReference<>();

    public static class a extends h {
        @Override // l.b.a.y.h
        public void a() {
            Iterator it = ServiceLoader.load(i.class, i.class.getClassLoader()).iterator();
            while (it.hasNext()) {
                try {
                    i.d((i) it.next());
                } catch (ServiceConfigurationError e2) {
                    if (!(e2.getCause() instanceof SecurityException)) {
                        throw e2;
                    }
                }
            }
        }
    }

    public abstract void a();
}
