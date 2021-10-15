package c.b.a.a.d.k;

import androidx.annotation.RecentlyNonNull;
import c.b.a.a.d.c;

public final class n extends UnsupportedOperationException {

    /* renamed from: b  reason: collision with root package name */
    public final c f2947b;

    public n(@RecentlyNonNull c cVar) {
        this.f2947b = cVar;
    }

    @RecentlyNonNull
    public final String getMessage() {
        String valueOf = String.valueOf(this.f2947b);
        StringBuilder sb = new StringBuilder(valueOf.length() + 8);
        sb.append("Missing ");
        sb.append(valueOf);
        return sb.toString();
    }
}
