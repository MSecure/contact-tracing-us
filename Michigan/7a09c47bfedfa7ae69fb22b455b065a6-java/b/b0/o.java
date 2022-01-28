package b.b0;

import androidx.work.ListenableWorker;
import androidx.work.OverwritingInputMerger;
import b.b0.w;
import b.b0.y.r.p;

public final class o extends w {

    public static final class a extends w.a<a, o> {
        public a(Class<? extends ListenableWorker> cls) {
            super(cls);
            this.f1061c.f1237d = OverwritingInputMerger.class.getName();
        }

        /* Return type fixed from 'b.b0.w' to match base method */
        @Override // b.b0.w.a
        public o b() {
            if (!this.f1059a || !this.f1061c.j.f1011c) {
                p pVar = this.f1061c;
                if (!pVar.q || !pVar.j.f1011c) {
                    return new o(this);
                }
                throw new IllegalArgumentException("Cannot run in foreground with an idle mode constraint");
            }
            throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
        }

        /* Return type fixed from 'b.b0.w$a' to match base method */
        @Override // b.b0.w.a
        public a c() {
            return this;
        }
    }

    public o(a aVar) {
        super(aVar.f1060b, aVar.f1061c, aVar.f1062d);
    }
}
