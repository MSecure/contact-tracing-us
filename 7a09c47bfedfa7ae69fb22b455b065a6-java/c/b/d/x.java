package c.b.d;

import c.b.d.s;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class x extends z {

    /* renamed from: e  reason: collision with root package name */
    public static final x f5906e = new x(true);

    /* renamed from: d  reason: collision with root package name */
    public final Map<a, b> f5907d;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final s.b f5908a;

        /* renamed from: b  reason: collision with root package name */
        public final int f5909b;

        public a(s.b bVar, int i) {
            this.f5908a = bVar;
            this.f5909b = i;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f5908a == aVar.f5908a && this.f5909b == aVar.f5909b;
        }

        public int hashCode() {
            return (this.f5908a.hashCode() * 65535) + this.f5909b;
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final s.g f5910a;

        /* renamed from: b  reason: collision with root package name */
        public final f1 f5911b;
    }

    public x() {
        new HashMap();
        new HashMap();
        this.f5907d = new HashMap();
        new HashMap();
    }

    public x(boolean z) {
        super(z.f5942c);
        Collections.emptyMap();
        Collections.emptyMap();
        this.f5907d = Collections.emptyMap();
        Collections.emptyMap();
    }
}
