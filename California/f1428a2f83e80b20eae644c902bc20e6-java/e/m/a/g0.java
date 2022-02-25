package e.m.a;

import e.p.a0;
import e.p.b0;
import e.p.c0;
import java.util.HashMap;
import java.util.Iterator;

public final class g0 extends a0 {

    /* renamed from: i  reason: collision with root package name */
    public static final b0.b f1595i = new a();
    public final HashMap<String, l> c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public final HashMap<String, g0> f1596d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<String, c0> f1597e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public final boolean f1598f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1599g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1600h = false;

    public class a implements b0.b {
        @Override // e.p.b0.b
        public <T extends a0> T a(Class<T> cls) {
            return new g0(true);
        }
    }

    public g0(boolean z) {
        this.f1598f = z;
    }

    @Override // e.p.a0
    public void a() {
        if (c0.Q(3)) {
            String str = "onCleared called for " + this;
        }
        this.f1599g = true;
    }

    public void c(l lVar) {
        if (!this.f1600h) {
            if ((this.c.remove(lVar.f1620f) != null) && c0.Q(2)) {
                String str = "Updating retained Fragments: Removed " + lVar;
            }
        }
    }

    public boolean d(l lVar) {
        if (this.c.containsKey(lVar.f1620f) && this.f1598f) {
            return this.f1599g;
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g0.class != obj.getClass()) {
            return false;
        }
        g0 g0Var = (g0) obj;
        return this.c.equals(g0Var.c) && this.f1596d.equals(g0Var.f1596d) && this.f1597e.equals(g0Var.f1597e);
    }

    public int hashCode() {
        int hashCode = this.f1596d.hashCode();
        return this.f1597e.hashCode() + ((hashCode + (this.c.hashCode() * 31)) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<l> it = this.c.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it2 = this.f1596d.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.f1597e.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
