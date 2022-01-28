package e.m.a;

import e.p.e0;
import e.p.f0;
import e.p.g0;
import java.util.HashMap;
import java.util.Iterator;

public final class h0 extends e0 {

    /* renamed from: i  reason: collision with root package name */
    public static final f0.b f1433i = new a();
    public final HashMap<String, m> c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public final HashMap<String, h0> f1434d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<String, g0> f1435e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public final boolean f1436f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1437g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1438h = false;

    public class a implements f0.b {
        @Override // e.p.f0.b
        public <T extends e0> T a(Class<T> cls) {
            return new h0(true);
        }
    }

    public h0(boolean z) {
        this.f1436f = z;
    }

    @Override // e.p.e0
    public void a() {
        if (e0.O(3)) {
            String str = "onCleared called for " + this;
        }
        this.f1437g = true;
    }

    public void c(m mVar) {
        if (!this.f1438h) {
            if ((this.c.remove(mVar.f1453f) != null) && e0.O(2)) {
                String str = "Updating retained Fragments: Removed " + mVar;
            }
        }
    }

    public boolean d(m mVar) {
        if (this.c.containsKey(mVar.f1453f) && this.f1436f) {
            return this.f1437g;
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h0.class != obj.getClass()) {
            return false;
        }
        h0 h0Var = (h0) obj;
        return this.c.equals(h0Var.c) && this.f1434d.equals(h0Var.f1434d) && this.f1435e.equals(h0Var.f1435e);
    }

    public int hashCode() {
        int hashCode = this.f1434d.hashCode();
        return this.f1435e.hashCode() + ((hashCode + (this.c.hashCode() * 31)) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<m> it = this.c.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it2 = this.f1434d.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.f1435e.keySet().iterator();
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
