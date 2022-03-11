package e.m.a;

import e.p.a0;
import e.p.b0;
import e.p.c0;
import java.util.HashMap;
import java.util.Iterator;

public final class j0 extends a0 {

    /* renamed from: i  reason: collision with root package name */
    public static final b0.b f1623i = new a();
    public final HashMap<String, l> c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public final HashMap<String, j0> f1624d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<String, c0> f1625e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public final boolean f1626f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1627g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1628h = false;

    public class a implements b0.b {
        @Override // e.p.b0.b
        public <T extends a0> T a(Class<T> cls) {
            return new j0(true);
        }
    }

    public j0(boolean z) {
        this.f1626f = z;
    }

    @Override // e.p.a0
    public void a() {
        if (f0.Q(3)) {
            String str = "onCleared called for " + this;
        }
        this.f1627g = true;
    }

    public void c(l lVar) {
        if (!this.f1628h) {
            if ((this.c.remove(lVar.f1631f) != null) && f0.Q(2)) {
                String str = "Updating retained Fragments: Removed " + lVar;
            }
        }
    }

    public boolean d(l lVar) {
        if (this.c.containsKey(lVar.f1631f) && this.f1626f) {
            return this.f1627g;
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || j0.class != obj.getClass()) {
            return false;
        }
        j0 j0Var = (j0) obj;
        return this.c.equals(j0Var.c) && this.f1624d.equals(j0Var.f1624d) && this.f1625e.equals(j0Var.f1625e);
    }

    public int hashCode() {
        int hashCode = this.f1624d.hashCode();
        return this.f1625e.hashCode() + ((hashCode + (this.c.hashCode() * 31)) * 31);
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
        Iterator<String> it2 = this.f1624d.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.f1625e.keySet().iterator();
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
