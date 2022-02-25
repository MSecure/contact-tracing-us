package h.a;

import f.b.a.c.b.o.b;
import h.a.a;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class v {

    /* renamed from: d  reason: collision with root package name */
    public static final a.c<String> f3982d = new a.c<>("io.grpc.EquivalentAddressGroup.authorityOverride");
    public final List<SocketAddress> a;
    public final a b;
    public final int c;

    public v(List<SocketAddress> list, a aVar) {
        b.o(!list.isEmpty(), "addrs is empty");
        List<SocketAddress> unmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        this.a = unmodifiableList;
        b.A(aVar, "attrs");
        this.b = aVar;
        this.c = unmodifiableList.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        if (this.a.size() != vVar.a.size()) {
            return false;
        }
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            if (!this.a.get(i2).equals(vVar.a.get(i2))) {
                return false;
            }
        }
        return this.b.equals(vVar.b);
    }

    public int hashCode() {
        return this.c;
    }

    public String toString() {
        StringBuilder h2 = f.a.a.a.a.h("[");
        h2.append(this.a);
        h2.append("/");
        h2.append(this.b);
        h2.append("]");
        return h2.toString();
    }
}
