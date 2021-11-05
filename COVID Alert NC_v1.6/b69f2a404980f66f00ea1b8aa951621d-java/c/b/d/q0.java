package c.b.d;

public class q0 {

    /* renamed from: a  reason: collision with root package name */
    public j f4052a;

    /* renamed from: b  reason: collision with root package name */
    public z f4053b;

    /* renamed from: c  reason: collision with root package name */
    public volatile h1 f4054c;

    /* renamed from: d  reason: collision with root package name */
    public volatile j f4055d;

    static {
        z.a();
    }

    public q0() {
    }

    public q0(z zVar, j jVar) {
        if (zVar == null) {
            throw new NullPointerException("found null ExtensionRegistry");
        } else if (jVar != null) {
            this.f4053b = zVar;
            this.f4052a = jVar;
        } else {
            throw new NullPointerException("found null ByteString");
        }
    }

    public h1 a(h1 h1Var) {
        j jVar;
        if (this.f4054c == null) {
            synchronized (this) {
                if (this.f4054c == null) {
                    try {
                        if (this.f4052a != null) {
                            this.f4054c = (h1) h1Var.getParserForType().parseFrom(this.f4052a, this.f4053b);
                            jVar = this.f4052a;
                        } else {
                            this.f4054c = h1Var;
                            jVar = j.f3914c;
                        }
                        this.f4055d = jVar;
                    } catch (n0 unused) {
                        this.f4054c = h1Var;
                        this.f4055d = j.f3914c;
                    }
                }
            }
        }
        return this.f4054c;
    }

    public j b() {
        if (this.f4055d != null) {
            return this.f4055d;
        }
        j jVar = this.f4052a;
        if (jVar != null) {
            return jVar;
        }
        synchronized (this) {
            if (this.f4055d != null) {
                return this.f4055d;
            }
            this.f4055d = this.f4054c == null ? j.f3914c : this.f4054c.toByteString();
            return this.f4055d;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q0)) {
            return false;
        }
        q0 q0Var = (q0) obj;
        h1 h1Var = this.f4054c;
        h1 h1Var2 = q0Var.f4054c;
        return (h1Var == null && h1Var2 == null) ? b().equals(q0Var.b()) : (h1Var == null || h1Var2 == null) ? h1Var != null ? h1Var.equals(q0Var.a(h1Var.getDefaultInstanceForType())) : a(h1Var2.getDefaultInstanceForType()).equals(h1Var2) : h1Var.equals(h1Var2);
    }

    public int hashCode() {
        return 1;
    }
}
