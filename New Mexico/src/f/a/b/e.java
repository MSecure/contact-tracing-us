package f.a.b;
/* loaded from: classes.dex */
public class e implements r {
    public int a;
    public int b;
    public final int c;

    public e() {
        this.a = 2500;
        this.c = 1;
    }

    public e(int i2, int i3, float f2) {
        this.a = i2;
        this.c = i3;
    }

    @Override // f.a.b.r
    public int a() {
        return this.a;
    }

    @Override // f.a.b.r
    public void b(u uVar) {
        boolean z = true;
        int i2 = this.b + 1;
        this.b = i2;
        int i3 = this.a;
        this.a = i3 + ((int) (((float) i3) * 1.0f));
        if (i2 > this.c) {
            z = false;
        }
        if (!z) {
            throw uVar;
        }
    }

    @Override // f.a.b.r
    public int c() {
        return this.b;
    }
}
