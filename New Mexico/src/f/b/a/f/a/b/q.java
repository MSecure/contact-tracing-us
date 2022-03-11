package f.b.a.f.a.b;

import android.os.Bundle;
import f.b.a.f.a.h.n;
/* loaded from: classes.dex */
public final class q extends k<Void> {
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public final String f3273d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3274e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ s f3275f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(s sVar, n<Void> nVar, int i2, String str, int i3) {
        super(sVar, nVar);
        this.f3275f = sVar;
        this.c = i2;
        this.f3273d = str;
        this.f3274e = i3;
    }

    @Override // f.b.a.f.a.b.k, f.b.a.f.a.e.h0
    public final void B(Bundle bundle) {
        this.f3275f.f3289d.c(this.a);
        s.f3287g.b("onError(%d), retrying notifyModuleCompleted...", Integer.valueOf(bundle.getInt("error_code")));
        int i2 = this.f3274e;
        if (i2 > 0) {
            this.f3275f.j(this.c, this.f3273d, i2 - 1);
        }
    }
}
