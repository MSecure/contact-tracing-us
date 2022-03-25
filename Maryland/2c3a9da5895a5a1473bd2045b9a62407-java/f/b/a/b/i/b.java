package f.b.a.b.i;

import f.b.a.b.d;
import f.b.a.b.i.i;
import java.util.Arrays;
import java.util.Objects;

public final class b extends i {
    public final String a;
    public final byte[] b;
    public final d c;

    /* renamed from: f.b.a.b.i.b$b  reason: collision with other inner class name */
    public static final class C0079b extends i.a {
        public String a;
        public byte[] b;
        public d c;

        @Override // f.b.a.b.i.i.a
        public i a() {
            String str = this.a == null ? " backendName" : "";
            if (this.c == null) {
                str = f.a.a.a.a.t(str, " priority");
            }
            if (str.isEmpty()) {
                return new b(this.a, this.b, this.c, null);
            }
            throw new IllegalStateException(f.a.a.a.a.t("Missing required properties:", str));
        }

        @Override // f.b.a.b.i.i.a
        public i.a b(String str) {
            Objects.requireNonNull(str, "Null backendName");
            this.a = str;
            return this;
        }

        @Override // f.b.a.b.i.i.a
        public i.a c(d dVar) {
            Objects.requireNonNull(dVar, "Null priority");
            this.c = dVar;
            return this;
        }
    }

    public b(String str, byte[] bArr, d dVar, a aVar) {
        this.a = str;
        this.b = bArr;
        this.c = dVar;
    }

    @Override // f.b.a.b.i.i
    public String b() {
        return this.a;
    }

    @Override // f.b.a.b.i.i
    public byte[] c() {
        return this.b;
    }

    @Override // f.b.a.b.i.i
    public d d() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (this.a.equals(iVar.b())) {
            return Arrays.equals(this.b, iVar instanceof b ? ((b) iVar).b : iVar.c()) && this.c.equals(iVar.d());
        }
    }

    public int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.b)) * 1000003) ^ this.c.hashCode();
    }
}
