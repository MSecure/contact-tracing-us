package f.b.a.f.a.b;

import android.os.RemoteException;
import f.b.a.f.a.e.b;
import f.b.a.f.a.h.n;
/* loaded from: classes.dex */
public final class f extends b {
    public final /* synthetic */ int c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f3217d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f3218e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f3219f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ n f3220g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ s f3221h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(s sVar, n nVar, int i2, String str, String str2, int i3, n nVar2) {
        super(nVar);
        this.f3221h = sVar;
        this.c = i2;
        this.f3217d = str;
        this.f3218e = str2;
        this.f3219f = i3;
        this.f3220g = nVar2;
    }

    @Override // f.b.a.f.a.e.b
    public final void a() {
        try {
            s sVar = this.f3221h;
            sVar.f3289d.n.w(sVar.a, s.k(this.c, this.f3217d, this.f3218e, this.f3219f), s.h(), new p(this.f3221h, this.f3220g));
        } catch (RemoteException e2) {
            s.f3287g.c(e2, "notifyChunkTransferred", new Object[0]);
        }
    }
}
