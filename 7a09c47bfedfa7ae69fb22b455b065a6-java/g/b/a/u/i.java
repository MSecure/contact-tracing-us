package g.b.a.u;

import g.b.a.w.j;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReference<i> f6595a = new AtomicReference<>();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final i f6596a = i.f6595a.get();

        static {
            i.f6595a.compareAndSet(null, new o());
        }
    }

    public static i a() {
        return a.f6596a;
    }

    public abstract String b(j jVar, long j, p pVar, Locale locale);

    public abstract Iterator<Map.Entry<String, Long>> c(j jVar, p pVar, Locale locale);
}
