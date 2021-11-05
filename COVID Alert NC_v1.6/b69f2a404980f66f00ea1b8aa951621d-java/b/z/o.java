package b.z;

import androidx.work.ListenableWorker;
import androidx.work.OverwritingInputMerger;
import b.z.w;
import b.z.y.r.p;

public final class o extends w {

    public static final class a extends w.a<a, o> {
        public a(Class<? extends ListenableWorker> cls) {
            super(cls);
            this.f1941c.f2094d = OverwritingInputMerger.class.getName();
        }

        /* Return type fixed from 'b.z.w' to match base method */
        @Override // b.z.w.a
        public o b() {
            if (!this.f1939a || !this.f1941c.j.f1900c) {
                p pVar = this.f1941c;
                if (!pVar.q || !pVar.j.f1900c) {
                    return new o(this);
                }
                throw new IllegalArgumentException("Cannot run in foreground with an idle mode constraint");
            }
            throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
        }

        /* Return type fixed from 'b.z.w$a' to match base method */
        @Override // b.z.w.a
        public a c() {
            return this;
        }
    }

    public o(a aVar) {
        super(aVar.f1940b, aVar.f1941c, aVar.f1942d);
    }
}
