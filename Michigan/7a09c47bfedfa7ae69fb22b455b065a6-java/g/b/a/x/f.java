package g.b.a.x;

import g.b.a.d;
import g.b.a.q;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public abstract class f {

    public static final class a extends f implements Serializable {

        /* renamed from: b  reason: collision with root package name */
        public final q f6706b;

        public a(q qVar) {
            this.f6706b = qVar;
        }

        @Override // g.b.a.x.f
        public q a(d dVar) {
            return this.f6706b;
        }

        @Override // g.b.a.x.f
        public d b(g.b.a.f fVar) {
            return null;
        }

        @Override // g.b.a.x.f
        public List<q> c(g.b.a.f fVar) {
            return Collections.singletonList(this.f6706b);
        }

        @Override // g.b.a.x.f
        public boolean d(d dVar) {
            return false;
        }

        @Override // g.b.a.x.f
        public boolean e() {
            return true;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                return this.f6706b.equals(((a) obj).f6706b);
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return bVar.e() && this.f6706b.equals(bVar.a(d.f6403d));
        }

        @Override // g.b.a.x.f
        public boolean f(g.b.a.f fVar, q qVar) {
            return this.f6706b.equals(qVar);
        }

        public int hashCode() {
            int i = this.f6706b.f6447c;
            return ((i + 31) ^ (((i + 31) ^ 1) ^ 1)) ^ 1;
        }

        public String toString() {
            StringBuilder h = c.a.a.a.a.h("FixedRules:");
            h.append(this.f6706b);
            return h.toString();
        }
    }

    public abstract q a(d dVar);

    public abstract d b(g.b.a.f fVar);

    public abstract List<q> c(g.b.a.f fVar);

    public abstract boolean d(d dVar);

    public abstract boolean e();

    public abstract boolean f(g.b.a.f fVar, q qVar);
}
