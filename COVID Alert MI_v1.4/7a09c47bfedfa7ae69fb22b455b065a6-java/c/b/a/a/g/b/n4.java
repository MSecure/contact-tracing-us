package c.b.a.a.g.b;

public enum n4 implements c1 {
    DEFAULT(0),
    UNMETERED_ONLY(1),
    UNMETERED_OR_DAILY(2),
    FAST_IF_RADIO_AWAKE(3),
    NEVER(4);
    

    /* renamed from: b  reason: collision with root package name */
    public final int f3377b;

    /* access modifiers changed from: public */
    n4(int i) {
        this.f3377b = i;
    }

    @Override // c.b.a.a.g.b.c1
    public final int c() {
        return this.f3377b;
    }
}
