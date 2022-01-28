package e.c.a.x;

import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicBoolean f5218a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public static final AtomicReference<h> f5219b = new AtomicReference<>();

    public static class a extends h {
        @Override // e.c.a.x.h
        public void a() {
            Iterator it = ServiceLoader.load(i.class, i.class.getClassLoader()).iterator();
            while (it.hasNext()) {
                try {
                    i.b((i) it.next());
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
