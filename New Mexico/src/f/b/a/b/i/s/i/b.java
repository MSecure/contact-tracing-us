package f.b.a.b.i.s.i;

import f.a.a.a.a;
import f.b.a.b.i.f;
import f.b.a.b.i.i;
import java.util.Objects;
/* loaded from: classes.dex */
public final class b extends h {
    public final long a;
    public final i b;
    public final f c;

    public b(long j2, i iVar, f fVar) {
        this.a = j2;
        Objects.requireNonNull(iVar, "Null transportContext");
        this.b = iVar;
        Objects.requireNonNull(fVar, "Null event");
        this.c = fVar;
    }

    @Override // f.b.a.b.i.s.i.h
    public f a() {
        return this.c;
    }

    @Override // f.b.a.b.i.s.i.h
    public long b() {
        return this.a;
    }

    @Override // f.b.a.b.i.s.i.h
    public i c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.a == hVar.b() && this.b.equals(hVar.c()) && this.c.equals(hVar.a());
    }

    public int hashCode() {
        long j2 = this.a;
        return this.c.hashCode() ^ ((((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003);
    }

    public String toString() {
        StringBuilder h2 = a.h("PersistedEvent{id=");
        h2.append(this.a);
        h2.append(", transportContext=");
        h2.append(this.b);
        h2.append(", event=");
        h2.append(this.c);
        h2.append("}");
        return h2.toString();
    }
}
