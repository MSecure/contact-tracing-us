package c.b.a.a.c.k;

import c.b.a.a.c.c;

public final class n extends UnsupportedOperationException {

    /* renamed from: b  reason: collision with root package name */
    public final c f2310b;

    public n(c cVar) {
        this.f2310b = cVar;
    }

    public final String getMessage() {
        String valueOf = String.valueOf(this.f2310b);
        StringBuilder sb = new StringBuilder(valueOf.length() + 8);
        sb.append("Missing ");
        sb.append(valueOf);
        return sb.toString();
    }
}
