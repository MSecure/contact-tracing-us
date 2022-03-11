package e.o.a;

import e.r.e0;
import e.r.f0;
import e.r.g0;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class h0 extends e0 {

    /* renamed from: i  reason: collision with root package name */
    public static final f0.b f1791i = new a();

    /* renamed from: f  reason: collision with root package name */
    public final boolean f1794f;
    public final HashMap<String, m> c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public final HashMap<String, h0> f1792d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<String, g0> f1793e = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public boolean f1795g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1796h = false;

    /* loaded from: classes.dex */
    public class a implements f0.b {
        @Override // e.r.f0.b
        public <T extends e0> T a(Class<T> cls) {
            return new h0(true);
        }
    }

    public h0(boolean z) {
        this.f1794f = z;
    }

    @Override // e.r.e0
    public void a() {
        if (e0.P(3)) {
            String str = "onCleared called for " + this;
        }
        this.f1795g = true;
    }

    public void c(m mVar) {
        if (!this.f1796h) {
            if ((this.c.remove(mVar.f1811f) != null) && e0.P(2)) {
                String str = "Updating retained Fragments: Removed " + mVar;
            }
        }
    }

    public boolean d(m mVar) {
        if (this.c.containsKey(mVar.f1811f) && this.f1794f) {
            return this.f1795g;
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
        return this.c.equals(h0Var.c) && this.f1792d.equals(h0Var.f1792d) && this.f1793e.equals(h0Var.f1793e);
    }

    public int hashCode() {
        int hashCode = this.f1792d.hashCode();
        return this.f1793e.hashCode() + ((hashCode + (this.c.hashCode() * 31)) * 31);
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
        Iterator<String> it2 = this.f1792d.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.f1793e.keySet().iterator();
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
