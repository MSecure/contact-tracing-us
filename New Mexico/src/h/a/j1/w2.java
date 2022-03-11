package h.a.j1;

import h.a.f1;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public final class w2 {
    public static final w2 c = new w2(new f1[0]);
    public final f1[] a;
    public final AtomicBoolean b = new AtomicBoolean(false);

    public w2(f1[] f1VarArr) {
        this.a = f1VarArr;
    }

    public void a(long j2) {
        for (f1 f1Var : this.a) {
            Objects.requireNonNull(f1Var);
        }
    }
}
