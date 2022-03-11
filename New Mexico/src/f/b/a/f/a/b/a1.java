package f.b.a.f.a.b;

import f.b.a.f.a.e.a;
import f.b.a.f.a.e.r;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public final class a1 {

    /* renamed from: k */
    public static final a f3175k = new a("ExtractorLooper");
    public final s1 a;
    public final u0 b;
    public final c3 c;

    /* renamed from: d */
    public final f2 f3176d;

    /* renamed from: e */
    public final k2 f3177e;

    /* renamed from: f */
    public final r2 f3178f;

    /* renamed from: g */
    public final v2 f3179g;

    /* renamed from: h */
    public final r<v3> f3180h;

    /* renamed from: i */
    public final v1 f3181i;

    /* renamed from: j */
    public final AtomicBoolean f3182j = new AtomicBoolean(false);

    public a1(s1 s1Var, r<v3> rVar, u0 u0Var, c3 c3Var, f2 f2Var, k2 k2Var, r2 r2Var, v2 v2Var, v1 v1Var) {
        this.a = s1Var;
        this.f3180h = rVar;
        this.b = u0Var;
        this.c = c3Var;
        this.f3176d = f2Var;
        this.f3177e = k2Var;
        this.f3178f = r2Var;
        this.f3179g = v2Var;
        this.f3181i = v1Var;
    }

    public final void a(int i2, Exception exc) {
        try {
            s1 s1Var = this.a;
            s1Var.b(new r1(i2) { // from class: f.b.a.f.a.b.h1
                public final /* synthetic */ int b;

                {
                    this.b = r2;
                }

                @Override // f.b.a.f.a.b.r1
                public final Object a() {
                    s1.this.a(this.b).c.f3270d = 5;
                    return null;
                }
            });
            s1 s1Var2 = this.a;
            s1Var2.b(new g1(s1Var2, i2));
        } catch (z0 unused) {
            f3175k.b("Error during error handling: %s", exc.getMessage());
        }
    }
}
