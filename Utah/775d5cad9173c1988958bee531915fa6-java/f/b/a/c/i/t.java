package f.b.a.c.i;

import java.util.Objects;

public final class t implements Runnable {
    public final /* synthetic */ h b;
    public final /* synthetic */ u c;

    public t(u uVar, h hVar) {
        this.c = uVar;
        this.b = hVar;
    }

    public final void run() {
        synchronized (this.c.b) {
            e eVar = this.c.c;
            if (eVar != null) {
                Exception k2 = this.b.k();
                Objects.requireNonNull(k2, "null reference");
                eVar.d(k2);
            }
        }
    }
}
