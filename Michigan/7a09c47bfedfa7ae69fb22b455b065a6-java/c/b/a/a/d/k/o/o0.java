package c.b.a.a.d.k.o;

import b.x.t;
import c.b.a.a.d.k.e;
import c.b.a.a.d.k.i;
import c.b.a.a.d.k.l;
import com.google.android.gms.common.api.internal.BasePendingResult;

public final class o0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i f3033b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ p0 f3034c;

    public o0(p0 p0Var, i iVar) {
        this.f3034c = p0Var;
        this.f3033b = iVar;
    }

    public final void run() {
        try {
            BasePendingResult.zaa.set(Boolean.TRUE);
            l<? super R, ? extends i> lVar = this.f3034c.f3035a;
            t.C(lVar);
            this.f3034c.h.sendMessage(this.f3034c.h.obtainMessage(0, lVar.a(this.f3033b)));
            BasePendingResult.zaa.set(Boolean.FALSE);
            p0.d(this.f3033b);
            e eVar = this.f3034c.f3041g.get();
            if (eVar != null) {
                eVar.d(this.f3034c);
            }
        } catch (RuntimeException e2) {
            this.f3034c.h.sendMessage(this.f3034c.h.obtainMessage(1, e2));
            BasePendingResult.zaa.set(Boolean.FALSE);
            p0.d(this.f3033b);
            e eVar2 = this.f3034c.f3041g.get();
            if (eVar2 != null) {
                eVar2.d(this.f3034c);
            }
        } catch (Throwable th) {
            BasePendingResult.zaa.set(Boolean.FALSE);
            p0.d(this.f3033b);
            e eVar3 = this.f3034c.f3041g.get();
            if (eVar3 != null) {
                eVar3.d(this.f3034c);
            }
            throw th;
        }
    }
}
