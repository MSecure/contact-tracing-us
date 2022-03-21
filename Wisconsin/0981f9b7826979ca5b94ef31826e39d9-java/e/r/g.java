package e.r;

import e.p.a0;
import e.p.b0;
import e.p.c0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

public class g extends a0 {

    /* renamed from: d  reason: collision with root package name */
    public static final b0.b f1737d = new a();
    public final HashMap<UUID, c0> c = new HashMap<>();

    public class a implements b0.b {
        @Override // e.p.b0.b
        public <T extends a0> T a(Class<T> cls) {
            return new g();
        }
    }

    @Override // e.p.a0
    public void a() {
        for (c0 c0Var : this.c.values()) {
            c0Var.a();
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
