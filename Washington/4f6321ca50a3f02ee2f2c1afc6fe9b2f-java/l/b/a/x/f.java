package l.b.a.x;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import l.b.a.d;
import l.b.a.q;

public abstract class f {

    public static final class a extends f implements Serializable {
        public final q b;

        public a(q qVar) {
            this.b = qVar;
        }

        @Override // l.b.a.x.f
        public q a(d dVar) {
            return this.b;
        }

        @Override // l.b.a.x.f
        public d b(l.b.a.f fVar) {
            return null;
        }

        @Override // l.b.a.x.f
        public List<q> c(l.b.a.f fVar) {
            return Collections.singletonList(this.b);
        }

        @Override // l.b.a.x.f
        public boolean d(d dVar) {
            return false;
        }

        @Override // l.b.a.x.f
        public boolean e() {
            return true;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                return this.b.equals(((a) obj).b);
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return bVar.e() && this.b.equals(bVar.a(d.f4040d));
        }

        @Override // l.b.a.x.f
        public boolean f(l.b.a.f fVar, q qVar) {
            return this.b.equals(qVar);
        }

        public int hashCode() {
            int i2 = this.b.c;
            return ((i2 + 31) ^ (((i2 + 31) ^ 1) ^ 1)) ^ 1;
        }

        public String toString() {
            StringBuilder h2 = f.a.a.a.a.h("FixedRules:");
            h2.append(this.b);
            return h2.toString();
        }
    }

    public abstract q a(d dVar);

    public abstract d b(l.b.a.f fVar);

    public abstract List<q> c(l.b.a.f fVar);

    public abstract boolean d(d dVar);

    public abstract boolean e();

    public abstract boolean f(l.b.a.f fVar, q qVar);
}
