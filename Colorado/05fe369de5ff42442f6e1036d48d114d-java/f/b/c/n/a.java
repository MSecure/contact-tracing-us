package f.b.c.n;

import java.util.Objects;

public final class a extends e {
    public final String a;
    public final String b;

    public a(String str, String str2) {
        Objects.requireNonNull(str, "Null libraryName");
        this.a = str;
        Objects.requireNonNull(str2, "Null version");
        this.b = str2;
    }

    @Override // f.b.c.n.e
    public String a() {
        return this.a;
    }

    @Override // f.b.c.n.e
    public String b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.a.equals(eVar.a()) && this.b.equals(eVar.b());
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public String toString() {
        StringBuilder i2 = f.a.a.a.a.i("LibraryVersion{libraryName=");
        i2.append(this.a);
        i2.append(", version=");
        return f.a.a.a.a.f(i2, this.b, "}");
    }
}
