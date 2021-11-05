package e.c.a.u;

import e.c.a.w.j;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReference<i> f5127a = new AtomicReference<>();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final i f5128a = i.f5127a.get();

        static {
            i.f5127a.compareAndSet(null, new o());
        }
    }

    public static i a() {
        return a.f5128a;
    }

    public abstract String b(j jVar, long j, p pVar, Locale locale);

    public abstract Iterator<Map.Entry<String, Long>> c(j jVar, p pVar, Locale locale);
}
