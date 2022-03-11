package e.c0;

import android.os.Build;
import androidx.work.ListenableWorker;
import androidx.work.OverwritingInputMerger;
import e.c0.u;
import e.c0.x.s.o;

public final class n extends u {

    public static final class a extends u.a<a, n> {
        public a(Class<? extends ListenableWorker> cls) {
            super(cls);
            this.c.f1133d = OverwritingInputMerger.class.getName();
        }

        /* Return type fixed from 'e.c0.u' to match base method */
        @Override // e.c0.u.a
        public n b() {
            int i2 = Build.VERSION.SDK_INT;
            if (!this.a || i2 < 23 || !this.c.f1139j.c) {
                o oVar = this.c;
                if (!oVar.q || i2 < 23 || !oVar.f1139j.c) {
                    return new n(this);
                }
                throw new IllegalArgumentException("Cannot run in foreground with an idle mode constraint");
            }
            throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
        }

        /* Return type fixed from 'e.c0.u$a' to match base method */
        @Override // e.c0.u.a
        public a c() {
            return this;
        }
    }

    public n(a aVar) {
        super(aVar.b, aVar.c, aVar.f1024d);
    }
}
