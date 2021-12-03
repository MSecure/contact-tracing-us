package e.z;

import android.os.Build;
import androidx.work.ListenableWorker;
import androidx.work.OverwritingInputMerger;
import e.z.u;
import e.z.x.s.o;

public final class n extends u {

    public static final class a extends u.a<a, n> {
        public a(Class<? extends ListenableWorker> cls) {
            super(cls);
            this.c.f1988d = OverwritingInputMerger.class.getName();
        }

        /* Return type fixed from 'e.z.u' to match base method */
        @Override // e.z.u.a
        public n b() {
            if (!this.a || Build.VERSION.SDK_INT < 23 || !this.c.f1994j.c) {
                o oVar = this.c;
                if (!oVar.q || Build.VERSION.SDK_INT < 23 || !oVar.f1994j.c) {
                    return new n(this);
                }
                throw new IllegalArgumentException("Cannot run in foreground with an idle mode constraint");
            }
            throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
        }

        /* Return type fixed from 'e.z.u$a' to match base method */
        @Override // e.z.u.a
        public a c() {
            return this;
        }
    }

    public n(a aVar) {
        super(aVar.b, aVar.c, aVar.f1879d);
    }
}
