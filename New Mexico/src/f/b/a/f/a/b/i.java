package f.b.a.f.a.b;

import android.os.RemoteException;
import f.b.a.f.a.e.b;
import f.b.a.f.a.h.n;
/* loaded from: classes.dex */
public final class i extends b {
    public final /* synthetic */ int c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f3231d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f3232e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f3233f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ n f3234g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ s f3235h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(s sVar, n nVar, int i2, String str, String str2, int i3, n nVar2) {
        super(nVar);
        this.f3235h = sVar;
        this.c = i2;
        this.f3231d = str;
        this.f3232e = str2;
        this.f3233f = i3;
        this.f3234g = nVar2;
    }

    @Override // f.b.a.f.a.e.b
    public final void a() {
        try {
            s sVar = this.f3235h;
            sVar.f3289d.n.M(sVar.a, s.k(this.c, this.f3231d, this.f3232e, this.f3233f), s.h(), new m(this.f3235h, this.f3234g));
        } catch (RemoteException e2) {
            s.f3287g.b("getChunkFileDescriptor(%s, %s, %d, session=%d)", this.f3231d, this.f3232e, Integer.valueOf(this.f3233f), Integer.valueOf(this.c));
            this.f3234g.a(new RuntimeException(e2));
        }
    }
}
