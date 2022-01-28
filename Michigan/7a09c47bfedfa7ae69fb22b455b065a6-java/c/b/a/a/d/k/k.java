package c.b.a.a.d.k;

import androidx.annotation.RecentlyNonNull;
import c.b.a.a.d.k.i;
import com.google.android.gms.common.api.Status;

public abstract class k<R extends i> implements j<R> {
    @Override // c.b.a.a.d.k.j
    public final void a(@RecentlyNonNull R r) {
        Status status = r.getStatus();
        if (status.t()) {
            c(r);
            return;
        }
        b(status);
        if (r instanceof g) {
            try {
                ((g) r).a();
            } catch (RuntimeException unused) {
                String.valueOf(r).length();
            }
        }
    }

    public abstract void b(@RecentlyNonNull Status status);

    public abstract void c(@RecentlyNonNull R r);
}
