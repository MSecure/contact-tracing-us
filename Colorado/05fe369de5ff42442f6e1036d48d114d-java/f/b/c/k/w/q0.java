package f.b.c.k.w;

import f.b.c.k.u.f;
import f.b.c.k.u.i;
import f.b.g.j;
import h.a.c1;
import java.util.List;

public abstract class q0 {

    public static final class b extends q0 {
        public final List<Integer> a;
        public final List<Integer> b;
        public final f c;

        /* renamed from: d  reason: collision with root package name */
        public final i f3354d;

        public b(List<Integer> list, List<Integer> list2, f fVar, i iVar) {
            super(null);
            this.a = list;
            this.b = list2;
            this.c = fVar;
            this.f3354d = iVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (!this.a.equals(bVar.a) || !this.b.equals(bVar.b) || !this.c.equals(bVar.c)) {
                return false;
            }
            i iVar = this.f3354d;
            i iVar2 = bVar.f3354d;
            return iVar != null ? iVar.equals(iVar2) : iVar2 == null;
        }

        public int hashCode() {
            int hashCode = (this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31;
            i iVar = this.f3354d;
            return hashCode + (iVar != null ? iVar.hashCode() : 0);
        }

        public String toString() {
            StringBuilder i2 = f.a.a.a.a.i("DocumentChange{updatedTargetIds=");
            i2.append(this.a);
            i2.append(", removedTargetIds=");
            i2.append(this.b);
            i2.append(", key=");
            i2.append(this.c);
            i2.append(", newDocument=");
            i2.append(this.f3354d);
            i2.append('}');
            return i2.toString();
        }
    }

    public static final class c extends q0 {
        public final int a;
        public final k b;

        public c(int i2, k kVar) {
            super(null);
            this.a = i2;
            this.b = kVar;
        }

        public String toString() {
            StringBuilder i2 = f.a.a.a.a.i("ExistenceFilterWatchChange{targetId=");
            i2.append(this.a);
            i2.append(", existenceFilter=");
            i2.append(this.b);
            i2.append('}');
            return i2.toString();
        }
    }

    public static final class d extends q0 {
        public final e a;
        public final List<Integer> b;
        public final j c;

        /* renamed from: d  reason: collision with root package name */
        public final c1 f3355d;

        public d(e eVar, List<Integer> list, j jVar, c1 c1Var) {
            super(null);
            f.b.a.c.b.o.b.M0(c1Var == null || eVar == e.Removed, "Got cause for a target change that was not a removal", new Object[0]);
            this.a = eVar;
            this.b = list;
            this.c = jVar;
            if (c1Var == null || c1Var.e()) {
                this.f3355d = null;
            } else {
                this.f3355d = c1Var;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            if (this.a != dVar.a || !this.b.equals(dVar.b) || !this.c.equals(dVar.c)) {
                return false;
            }
            c1 c1Var = this.f3355d;
            c1 c1Var2 = dVar.f3355d;
            if (c1Var != null) {
                if (c1Var2 == null || !c1Var.a.equals(c1Var2.a)) {
                    return false;
                }
                return true;
            } else if (c1Var2 == null) {
                return true;
            } else {
                return false;
            }
        }

        public int hashCode() {
            int hashCode = (this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31;
            c1 c1Var = this.f3355d;
            return hashCode + (c1Var != null ? c1Var.a.hashCode() : 0);
        }

        public String toString() {
            StringBuilder i2 = f.a.a.a.a.i("WatchTargetChange{changeType=");
            i2.append(this.a);
            i2.append(", targetIds=");
            i2.append(this.b);
            i2.append('}');
            return i2.toString();
        }
    }

    public enum e {
        NoChange,
        Added,
        Removed,
        Current,
        Reset
    }

    public q0(a aVar) {
    }
}
