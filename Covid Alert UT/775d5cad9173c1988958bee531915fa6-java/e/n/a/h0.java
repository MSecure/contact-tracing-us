package e.n.a;

import e.q.e0;
import e.q.f0;
import e.q.g0;
import java.util.HashMap;
import java.util.Iterator;

public final class h0 extends e0 {

    /* renamed from: i  reason: collision with root package name */
    public static final f0.b f1706i = new a();
    public final HashMap<String, m> c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public final HashMap<String, h0> f1707d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<String, g0> f1708e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public final boolean f1709f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1710g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1711h = false;

    public class a implements f0.b {
        @Override // e.q.f0.b
        public <T extends e0> T a(Class<T> cls) {
            return new h0(true);
        }
    }

    public h0(boolean z) {
        this.f1709f = z;
    }

    @Override // e.q.e0
    public void a() {
        if (e0.O(3)) {
            String str = "onCleared called for " + this;
        }
        this.f1710g = true;
    }

    public void c(m mVar) {
        if (!this.f1711h) {
            if ((this.c.remove(mVar.f1726f) != null) && e0.O(2)) {
                String str = "Updating retained Fragments: Removed " + mVar;
            }
        }
    }

    public boolean d(m mVar) {
        if (this.c.containsKey(mVar.f1726f) && this.f1709f) {
            return this.f1710g;
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
        return this.c.equals(h0Var.c) && this.f1707d.equals(h0Var.f1707d) && this.f1708e.equals(h0Var.f1708e);
    }

    public int hashCode() {
        int hashCode = this.f1707d.hashCode();
        return this.f1708e.hashCode() + ((hashCode + (this.c.hashCode() * 31)) * 31);
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
        Iterator<String> it2 = this.f1707d.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.f1708e.keySet().iterator();
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
