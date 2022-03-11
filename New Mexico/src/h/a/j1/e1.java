package h.a.j1;
/* loaded from: classes.dex */
public class e1 implements Runnable {
    public final /* synthetic */ z b;
    public final /* synthetic */ boolean c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ z0 f4182d;

    public e1(z0 z0Var, z zVar, boolean z) {
        this.f4182d = z0Var;
        this.b = zVar;
        this.c = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4182d.r.c(this.b, this.c);
    }
}
