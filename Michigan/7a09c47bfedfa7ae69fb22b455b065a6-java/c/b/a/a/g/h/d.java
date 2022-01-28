package c.b.a.a.g.h;

import java.lang.ref.Reference;
import java.util.List;

public final class d extends c {

    /* renamed from: a  reason: collision with root package name */
    public final b f3857a = new b();

    @Override // c.b.a.a.g.h.c
    public final void a(Throwable th) {
        th.printStackTrace();
        b bVar = this.f3857a;
        while (true) {
            Reference<? extends Throwable> poll = bVar.f3840b.poll();
            if (poll == null) {
                break;
            }
            bVar.f3839a.remove(poll);
        }
        List<Throwable> list = bVar.f3839a.get(new e(th, null));
        if (list != null) {
            synchronized (list) {
                for (Throwable th2 : list) {
                    System.err.print("Suppressed: ");
                    th2.printStackTrace();
                }
            }
        }
    }
}
