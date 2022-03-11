package f.b.a.c.b.l;

import androidx.annotation.RecentlyNonNull;
import f.b.a.c.b.c;
/* loaded from: classes.dex */
public final class k extends UnsupportedOperationException {
    public final c b;

    public k(@RecentlyNonNull c cVar) {
        this.b = cVar;
    }

    @Override // java.lang.Throwable
    @RecentlyNonNull
    public final String getMessage() {
        String valueOf = String.valueOf(this.b);
        StringBuilder sb = new StringBuilder(valueOf.length() + 8);
        sb.append("Missing ");
        sb.append(valueOf);
        return sb.toString();
    }
}
