package b.l.d;

import androidx.fragment.app.Fragment;
import b.n.x;
import b.n.y;
import b.n.z;
import java.util.HashMap;
import java.util.Iterator;

public final class u extends x {
    public static final y.b g = new a();

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, Fragment> f1351a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<String, u> f1352b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public final HashMap<String, z> f1353c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public final boolean f1354d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1355e = false;
    public boolean f = false;

    public static class a implements y.b {
        @Override // b.n.y.b
        public <T extends x> T a(Class<T> cls) {
            return new u(true);
        }
    }

    public u(boolean z) {
        this.f1354d = z;
    }

    public boolean a(Fragment fragment) {
        if (!this.f1351a.containsKey(fragment.mWho)) {
            return true;
        }
        return this.f1354d ? this.f1355e : !this.f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || u.class != obj.getClass()) {
            return false;
        }
        u uVar = (u) obj;
        return this.f1351a.equals(uVar.f1351a) && this.f1352b.equals(uVar.f1352b) && this.f1353c.equals(uVar.f1353c);
    }

    public int hashCode() {
        int hashCode = this.f1352b.hashCode();
        return this.f1353c.hashCode() + ((hashCode + (this.f1351a.hashCode() * 31)) * 31);
    }

    @Override // b.n.x
    public void onCleared() {
        if (q.P(3)) {
            String str = "onCleared called for " + this;
        }
        this.f1355e = true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<Fragment> it = this.f1351a.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it2 = this.f1352b.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.f1353c.keySet().iterator();
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
