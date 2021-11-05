package c.b.a.a.g.b;

import android.database.ContentObserver;

public final class c extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f3233a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(b bVar) {
        super(null);
        this.f3233a = bVar;
    }

    public final void onChange(boolean z) {
        b bVar = this.f3233a;
        synchronized (bVar.f3225d) {
            bVar.f3226e = null;
        }
        b bVar2 = this.f3233a;
        synchronized (bVar2.f3227f) {
            for (d dVar : bVar2.f3228g) {
                dVar.a();
            }
        }
    }
}
