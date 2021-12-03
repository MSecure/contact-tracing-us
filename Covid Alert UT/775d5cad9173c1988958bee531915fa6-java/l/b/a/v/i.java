package l.b.a.v;

import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import l.b.a.x.j;

public abstract class i {
    public static final AtomicReference<i> a = new AtomicReference<>();

    public static class a {
        public static final i a;

        static {
            AtomicReference<i> atomicReference = i.a;
            atomicReference.compareAndSet(null, new o());
            a = atomicReference.get();
        }
    }

    public abstract String a(j jVar, long j2, p pVar, Locale locale);

    public abstract Iterator<Map.Entry<String, Long>> b(j jVar, p pVar, Locale locale);
}
