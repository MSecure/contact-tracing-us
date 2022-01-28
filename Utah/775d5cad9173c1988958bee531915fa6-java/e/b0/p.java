package e.b0;

import android.os.Build;
import androidx.work.ListenableWorker;
import androidx.work.OverwritingInputMerger;
import e.b0.x;

public final class p extends x {

    public static final class a extends x.a<a, p> {
        public a(Class<? extends ListenableWorker> cls) {
            super(cls);
            this.c.f1112d = OverwritingInputMerger.class.getName();
        }

        /* Return type fixed from 'e.b0.x' to match base method */
        @Override // e.b0.x.a
        public p b() {
            if (!this.a || Build.VERSION.SDK_INT < 23 || !this.c.f1118j.c) {
                return new p(this);
            }
            throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
        }

        /* Return type fixed from 'e.b0.x$a' to match base method */
        @Override // e.b0.x.a
        public a c() {
            return this;
        }
    }

    public p(a aVar) {
        super(aVar.b, aVar.c, aVar.f1182d);
    }
}
