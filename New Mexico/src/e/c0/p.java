package e.c0;

import android.os.Build;
import androidx.work.ListenableWorker;
import androidx.work.OverwritingInputMerger;
import e.c0.x;
/* loaded from: classes.dex */
public final class p extends x {

    /* loaded from: classes.dex */
    public static final class a extends x.a<a, p> {
        public a(Class<? extends ListenableWorker> cls) {
            super(cls);
            this.c.f1191d = OverwritingInputMerger.class.getName();
        }

        @Override // e.c0.x.a
        public p b() {
            if (!this.a || Build.VERSION.SDK_INT < 23 || !this.c.f1197j.c) {
                return new p(this);
            }
            throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
        }

        @Override // e.c0.x.a
        public a c() {
            return this;
        }
    }

    public p(a aVar) {
        super(aVar.b, aVar.c, aVar.f1261d);
    }
}
