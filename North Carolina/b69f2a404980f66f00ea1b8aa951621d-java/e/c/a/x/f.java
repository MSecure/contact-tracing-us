package e.c.a.x;

import e.c.a.d;
import e.c.a.q;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public abstract class f {

    public static final class a extends f implements Serializable {

        /* renamed from: b  reason: collision with root package name */
        public final q f5217b;

        public a(q qVar) {
            this.f5217b = qVar;
        }

        @Override // e.c.a.x.f
        public q a(d dVar) {
            return this.f5217b;
        }

        @Override // e.c.a.x.f
        public d b(e.c.a.f fVar) {
            return null;
        }

        @Override // e.c.a.x.f
        public List<q> c(e.c.a.f fVar) {
            return Collections.singletonList(this.f5217b);
        }

        @Override // e.c.a.x.f
        public boolean d(d dVar) {
            return false;
        }

        @Override // e.c.a.x.f
        public boolean e() {
            return true;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                return this.f5217b.equals(((a) obj).f5217b);
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return bVar.e() && this.f5217b.equals(bVar.a(d.f4966d));
        }

        @Override // e.c.a.x.f
        public boolean f(e.c.a.f fVar, q qVar) {
            return this.f5217b.equals(qVar);
        }

        public int hashCode() {
            int i = this.f5217b.f5002b;
            return ((i + 31) ^ (((i + 31) ^ 1) ^ 1)) ^ 1;
        }

        public String toString() {
            StringBuilder g = c.a.a.a.a.g("FixedRules:");
            g.append(this.f5217b);
            return g.toString();
        }
    }

    public abstract q a(d dVar);

    public abstract d b(e.c.a.f fVar);

    public abstract List<q> c(e.c.a.f fVar);

    public abstract boolean d(d dVar);

    public abstract boolean e();

    public abstract boolean f(e.c.a.f fVar, q qVar);
}
