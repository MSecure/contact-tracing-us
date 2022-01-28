package e.b.j;

import e.b.h.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public abstract class b extends d {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<d> f4929a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public int f4930b = 0;

    public static final class a extends b {
        public a(Collection<d> collection) {
            this.f4929a.addAll(collection);
            b();
        }

        public a(d... dVarArr) {
            this(Arrays.asList(dVarArr));
        }

        @Override // e.b.j.d
        public boolean a(i iVar, i iVar2) {
            for (int i = 0; i < this.f4930b; i++) {
                if (!this.f4929a.get(i).a(iVar, iVar2)) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            return e.b.g.b.h(this.f4929a, " ");
        }
    }

    /* renamed from: e.b.j.b$b  reason: collision with other inner class name */
    public static final class C0119b extends b {
        public C0119b() {
        }

        public C0119b(d... dVarArr) {
            List asList = Arrays.asList(dVarArr);
            if (this.f4930b > 1) {
                this.f4929a.add(new a(asList));
            } else {
                this.f4929a.addAll(asList);
            }
            b();
        }

        @Override // e.b.j.d
        public boolean a(i iVar, i iVar2) {
            for (int i = 0; i < this.f4930b; i++) {
                if (this.f4929a.get(i).a(iVar, iVar2)) {
                    return true;
                }
            }
            return false;
        }

        public void c(d dVar) {
            this.f4929a.add(dVar);
            b();
        }

        public String toString() {
            return e.b.g.b.h(this.f4929a, ", ");
        }
    }

    public void b() {
        this.f4930b = this.f4929a.size();
    }
}
