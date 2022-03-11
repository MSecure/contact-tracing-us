package l.b.a.y;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import l.b.a.e;
import l.b.a.g;
import l.b.a.r;
/* loaded from: classes.dex */
public abstract class f {

    /* loaded from: classes.dex */
    public static final class a extends f implements Serializable {
        public final r b;

        public a(r rVar) {
            this.b = rVar;
        }

        @Override // l.b.a.y.f
        public r a(e eVar) {
            return this.b;
        }

        @Override // l.b.a.y.f
        public d b(g gVar) {
            return null;
        }

        @Override // l.b.a.y.f
        public List<r> c(g gVar) {
            return Collections.singletonList(this.b);
        }

        @Override // l.b.a.y.f
        public boolean d(e eVar) {
            return false;
        }

        @Override // l.b.a.y.f
        public boolean e() {
            return true;
        }

        @Override // java.lang.Object
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
            return bVar.e() && this.b.equals(bVar.a(e.f4611d));
        }

        @Override // l.b.a.y.f
        public boolean f(g gVar, r rVar) {
            return this.b.equals(rVar);
        }

        @Override // java.lang.Object
        public int hashCode() {
            int i2 = this.b.c;
            return ((i2 + 31) ^ (((i2 + 31) ^ 1) ^ 1)) ^ 1;
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder h2 = f.a.a.a.a.h("FixedRules:");
            h2.append(this.b);
            return h2.toString();
        }
    }

    public abstract r a(e eVar);

    public abstract d b(g gVar);

    public abstract List<r> c(g gVar);

    public abstract boolean d(e eVar);

    public abstract boolean e();

    public abstract boolean f(g gVar, r rVar);
}
