package f.b.a.f.a.b;

import android.os.Bundle;
import android.os.RemoteException;
import f.b.a.f.a.e.b;
import f.b.a.f.a.h.n;
/* loaded from: classes.dex */
public final class g extends b {
    public final /* synthetic */ int c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f3222d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ n f3223e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f3224f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ s f3225g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(s sVar, n nVar, int i2, String str, n nVar2, int i3) {
        super(nVar);
        this.f3225g = sVar;
        this.c = i2;
        this.f3222d = str;
        this.f3223e = nVar2;
        this.f3224f = i3;
    }

    @Override // f.b.a.f.a.e.b
    public final void a() {
        try {
            s sVar = this.f3225g;
            String str = sVar.a;
            int i2 = this.c;
            String str2 = this.f3222d;
            Bundle bundle = new Bundle();
            bundle.putInt("session_id", i2);
            bundle.putString("module_name", str2);
            sVar.f3289d.n.P(str, bundle, s.h(), new q(this.f3225g, this.f3223e, this.c, this.f3222d, this.f3224f));
        } catch (RemoteException e2) {
            s.f3287g.c(e2, "notifyModuleCompleted", new Object[0]);
        }
    }
}
