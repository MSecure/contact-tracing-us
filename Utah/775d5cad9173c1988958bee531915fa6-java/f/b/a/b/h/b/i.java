package f.b.a.b.h.b;

import f.a.a.a.a;
import java.util.List;
import java.util.Objects;

public final class i extends o {
    public final List<r> a;

    public i(List<r> list) {
        Objects.requireNonNull(list, "Null logRequests");
        this.a = list;
    }

    @Override // f.b.a.b.h.b.o
    public List<r> a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof o) {
            return this.a.equals(((o) obj).a());
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    public String toString() {
        StringBuilder h2 = a.h("BatchedLogRequest{logRequests=");
        h2.append(this.a);
        h2.append("}");
        return h2.toString();
    }
}
