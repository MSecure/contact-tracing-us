package e.d;
/* loaded from: classes.dex */
public class n implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ CharSequence c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ e f1263d;

    public n(e eVar, int i2, CharSequence charSequence) {
        this.f1263d = eVar;
        this.b = i2;
        this.c = charSequence;
    }

    @Override // java.lang.Runnable
    public void run() {
        e eVar = this.f1263d;
        eVar.N0(this.b, this.c);
        eVar.I0();
    }
}
