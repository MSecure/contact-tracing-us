package e.s;

import e.q.e0;
import e.q.f0;
import e.q.g0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

public class g extends e0 {

    /* renamed from: d  reason: collision with root package name */
    public static final f0.b f1843d = new a();
    public final HashMap<UUID, g0> c = new HashMap<>();

    public class a implements f0.b {
        @Override // e.q.f0.b
        public <T extends e0> T a(Class<T> cls) {
            return new g();
        }
    }

    @Override // e.q.e0
    public void a() {
        for (g0 g0Var : this.c.values()) {
            g0Var.a();
        }
        this.c.clear();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NavControllerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} ViewModelStores (");
        Iterator<UUID> it = this.c.keySet().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
