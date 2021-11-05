package c.b.d;

import c.b.d.s;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class x extends z {

    /* renamed from: e  reason: collision with root package name */
    public static final x f4383e = new x(true);

    /* renamed from: d  reason: collision with root package name */
    public final Map<a, b> f4384d;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final s.b f4385a;

        /* renamed from: b  reason: collision with root package name */
        public final int f4386b;

        public a(s.b bVar, int i) {
            this.f4385a = bVar;
            this.f4386b = i;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f4385a == aVar.f4385a && this.f4386b == aVar.f4386b;
        }

        public int hashCode() {
            return (this.f4385a.hashCode() * 65535) + this.f4386b;
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final s.g f4387a;

        /* renamed from: b  reason: collision with root package name */
        public final e1 f4388b;
    }

    public x() {
        new HashMap();
        new HashMap();
        this.f4384d = new HashMap();
        new HashMap();
    }

    public x(boolean z) {
        super(z.f4415c);
        Collections.emptyMap();
        Collections.emptyMap();
        this.f4384d = Collections.emptyMap();
        Collections.emptyMap();
    }
}
