package c.b.c.a.j0.a;

public class e0 {

    /* renamed from: a  reason: collision with root package name */
    public i f3546a;

    /* renamed from: b  reason: collision with root package name */
    public volatile r0 f3547b;

    /* renamed from: c  reason: collision with root package name */
    public volatile i f3548c;

    static {
        q.a();
    }

    public r0 a(r0 r0Var) {
        i iVar;
        if (this.f3547b == null) {
            synchronized (this) {
                if (this.f3547b == null) {
                    try {
                        if (this.f3546a != null) {
                            this.f3547b = (r0) r0Var.getParserForType().a(this.f3546a, null);
                            iVar = this.f3546a;
                        } else {
                            this.f3547b = r0Var;
                            iVar = i.f3564c;
                        }
                        this.f3548c = iVar;
                    } catch (b0 unused) {
                        this.f3547b = r0Var;
                        this.f3548c = i.f3564c;
                    }
                }
            }
        }
        return this.f3547b;
    }

    public i b() {
        if (this.f3548c != null) {
            return this.f3548c;
        }
        i iVar = this.f3546a;
        if (iVar != null) {
            return iVar;
        }
        synchronized (this) {
            if (this.f3548c != null) {
                return this.f3548c;
            }
            this.f3548c = this.f3547b == null ? i.f3564c : this.f3547b.toByteString();
            return this.f3548c;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e0)) {
            return false;
        }
        e0 e0Var = (e0) obj;
        r0 r0Var = this.f3547b;
        r0 r0Var2 = e0Var.f3547b;
        return (r0Var == null && r0Var2 == null) ? b().equals(e0Var.b()) : (r0Var == null || r0Var2 == null) ? r0Var != null ? r0Var.equals(e0Var.a(r0Var.getDefaultInstanceForType())) : a(r0Var2.getDefaultInstanceForType()).equals(r0Var2) : r0Var.equals(r0Var2);
    }

    public int hashCode() {
        return 1;
    }
}
