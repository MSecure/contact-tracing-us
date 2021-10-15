package b.l.d;

import androidx.fragment.app.Fragment;
import b.o.x;
import b.o.y;
import b.o.z;
import java.util.HashMap;
import java.util.Iterator;

public final class c0 extends x {
    public static final y.b h = new a();

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, Fragment> f1993a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<String, c0> f1994b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public final HashMap<String, z> f1995c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public final boolean f1996d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1997e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1998f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1999g = false;

    public class a implements y.b {
        @Override // b.o.y.b
        public <T extends x> T a(Class<T> cls) {
            return new c0(true);
        }
    }

    public c0(boolean z) {
        this.f1996d = z;
    }

    public void a(Fragment fragment) {
        if (this.f1999g) {
            z.P(2);
        } else if (!this.f1993a.containsKey(fragment.mWho)) {
            this.f1993a.put(fragment.mWho, fragment);
            if (z.P(2)) {
                String str = "Updating retained Fragments: Added " + fragment;
            }
        }
    }

    public void b(Fragment fragment) {
        if (this.f1999g) {
            z.P(2);
            return;
        }
        if ((this.f1993a.remove(fragment.mWho) != null) && z.P(2)) {
            String str = "Updating retained Fragments: Removed " + fragment;
        }
    }

    public boolean c(Fragment fragment) {
        if (!this.f1993a.containsKey(fragment.mWho)) {
            return true;
        }
        return this.f1996d ? this.f1997e : !this.f1998f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c0.class != obj.getClass()) {
            return false;
        }
        c0 c0Var = (c0) obj;
        return this.f1993a.equals(c0Var.f1993a) && this.f1994b.equals(c0Var.f1994b) && this.f1995c.equals(c0Var.f1995c);
    }

    public int hashCode() {
        int hashCode = this.f1994b.hashCode();
        return this.f1995c.hashCode() + ((hashCode + (this.f1993a.hashCode() * 31)) * 31);
    }

    @Override // b.o.x
    public void onCleared() {
        if (z.P(3)) {
            String str = "onCleared called for " + this;
        }
        this.f1997e = true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<Fragment> it = this.f1993a.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it2 = this.f1994b.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.f1995c.keySet().iterator();
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
