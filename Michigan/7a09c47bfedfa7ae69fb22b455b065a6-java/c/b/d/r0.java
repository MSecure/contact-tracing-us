package c.b.d;

public class r0 {

    /* renamed from: a  reason: collision with root package name */
    public j f5777a;

    /* renamed from: b  reason: collision with root package name */
    public z f5778b;

    /* renamed from: c  reason: collision with root package name */
    public volatile i1 f5779c;

    /* renamed from: d  reason: collision with root package name */
    public volatile j f5780d;

    static {
        z.a();
    }

    public r0() {
    }

    public r0(z zVar, j jVar) {
        if (zVar == null) {
            throw new NullPointerException("found null ExtensionRegistry");
        } else if (jVar != null) {
            this.f5778b = zVar;
            this.f5777a = jVar;
        } else {
            throw new NullPointerException("found null ByteString");
        }
    }

    public i1 a(i1 i1Var) {
        j jVar;
        if (this.f5779c == null) {
            synchronized (this) {
                if (this.f5779c == null) {
                    try {
                        if (this.f5777a != null) {
                            this.f5779c = (i1) i1Var.getParserForType().parseFrom(this.f5777a, this.f5778b);
                            jVar = this.f5777a;
                        } else {
                            this.f5779c = i1Var;
                            jVar = j.f5320c;
                        }
                        this.f5780d = jVar;
                    } catch (o0 unused) {
                        this.f5779c = i1Var;
                        this.f5780d = j.f5320c;
                    }
                }
            }
        }
        return this.f5779c;
    }

    public j b() {
        if (this.f5780d != null) {
            return this.f5780d;
        }
        j jVar = this.f5777a;
        if (jVar != null) {
            return jVar;
        }
        synchronized (this) {
            if (this.f5780d != null) {
                return this.f5780d;
            }
            this.f5780d = this.f5779c == null ? j.f5320c : this.f5779c.toByteString();
            return this.f5780d;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r0)) {
            return false;
        }
        r0 r0Var = (r0) obj;
        i1 i1Var = this.f5779c;
        i1 i1Var2 = r0Var.f5779c;
        return (i1Var == null && i1Var2 == null) ? b().equals(r0Var.b()) : (i1Var == null || i1Var2 == null) ? i1Var != null ? i1Var.equals(r0Var.a(i1Var.getDefaultInstanceForType())) : a(i1Var2.getDefaultInstanceForType()).equals(i1Var2) : i1Var.equals(i1Var2);
    }

    public int hashCode() {
        return 1;
    }
}
