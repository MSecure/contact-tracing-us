package f.b.c.f;

import f.b.c.j.a;
import f.b.c.j.b;
import java.util.Map;

public final /* synthetic */ class r implements Runnable {
    public final Map.Entry b;
    public final a c;

    public r(Map.Entry entry, a aVar) {
        this.b = entry;
        this.c = aVar;
    }

    public void run() {
        Map.Entry entry = this.b;
        ((b) entry.getKey()).a(this.c);
    }
}
