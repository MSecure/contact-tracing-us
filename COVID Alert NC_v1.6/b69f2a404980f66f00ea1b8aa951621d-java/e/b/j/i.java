package e.b.j;

import e.b.j.d;
import java.util.Iterator;

public abstract class i extends d {

    /* renamed from: a  reason: collision with root package name */
    public d f4958a;

    public static class a extends i {
        public a(d dVar) {
            this.f4958a = dVar;
        }

        @Override // e.b.j.d
        public boolean a(e.b.h.i iVar, e.b.h.i iVar2) {
            if (iVar2 != null) {
                Iterator it = c.b.a.a.c.n.c.y(new d.a(), iVar2).iterator();
                while (it.hasNext()) {
                    e.b.h.i iVar3 = (e.b.h.i) it.next();
                    if (iVar3 != iVar2 && this.f4958a.a(iVar2, iVar3)) {
                        return true;
                    }
                }
                return false;
            }
            throw null;
        }

        public String toString() {
            return String.format(":has(%s)", this.f4958a);
        }
    }

    public static class b extends i {
        public b(d dVar) {
            this.f4958a = dVar;
        }

        @Override // e.b.j.d
        public boolean a(e.b.h.i iVar, e.b.h.i iVar2) {
            e.b.h.i iVar3;
            if (iVar == iVar2 || (iVar3 = (e.b.h.i) iVar2.f4861b) == null || !this.f4958a.a(iVar, iVar3)) {
                return false;
            }
            return true;
        }

        public String toString() {
            return String.format(":ImmediateParent%s", this.f4958a);
        }
    }

    public static class c extends i {
        public c(d dVar) {
            this.f4958a = dVar;
        }

        @Override // e.b.j.d
        public boolean a(e.b.h.i iVar, e.b.h.i iVar2) {
            e.b.h.i M;
            return (iVar == iVar2 || (M = iVar2.M()) == null || !this.f4958a.a(iVar, M)) ? false : true;
        }

        public String toString() {
            return String.format(":prev%s", this.f4958a);
        }
    }

    public static class d extends i {
        public d(d dVar) {
            this.f4958a = dVar;
        }

        @Override // e.b.j.d
        public boolean a(e.b.h.i iVar, e.b.h.i iVar2) {
            return !this.f4958a.a(iVar, iVar2);
        }

        public String toString() {
            return String.format(":not%s", this.f4958a);
        }
    }

    public static class e extends i {
        public e(d dVar) {
            this.f4958a = dVar;
        }

        @Override // e.b.j.d
        public boolean a(e.b.h.i iVar, e.b.h.i iVar2) {
            if (iVar == iVar2) {
                return false;
            }
            do {
                iVar2 = (e.b.h.i) iVar2.f4861b;
                if (this.f4958a.a(iVar, iVar2)) {
                    return true;
                }
            } while (iVar2 != iVar);
            return false;
        }

        public String toString() {
            return String.format(":parent%s", this.f4958a);
        }
    }

    public static class f extends i {
        public f(d dVar) {
            this.f4958a = dVar;
        }

        @Override // e.b.j.d
        public boolean a(e.b.h.i iVar, e.b.h.i iVar2) {
            if (iVar == iVar2) {
                return false;
            }
            do {
                iVar2 = iVar2.M();
                if (iVar2 == null) {
                    return false;
                }
            } while (!this.f4958a.a(iVar, iVar2));
            return true;
        }

        public String toString() {
            return String.format(":prev*%s", this.f4958a);
        }
    }

    public static class g extends d {
        @Override // e.b.j.d
        public boolean a(e.b.h.i iVar, e.b.h.i iVar2) {
            return iVar == iVar2;
        }
    }
}
