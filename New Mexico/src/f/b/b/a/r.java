package f.b.b.a;

import java.util.Iterator;
/* loaded from: classes.dex */
public final class r {
    public final c a;
    public final boolean b;
    public final b c;

    /* renamed from: d */
    public final int f3378d;

    /* loaded from: classes.dex */
    public static abstract class a extends b<String> {

        /* renamed from: d */
        public final CharSequence f3379d;

        /* renamed from: e */
        public final c f3380e;

        /* renamed from: f */
        public final boolean f3381f;

        /* renamed from: g */
        public int f3382g = 0;

        /* renamed from: h */
        public int f3383h;

        public a(r rVar, CharSequence charSequence) {
            this.f3380e = rVar.a;
            this.f3381f = rVar.b;
            this.f3383h = rVar.f3378d;
            this.f3379d = charSequence;
        }

        public abstract int b(int i2);

        public abstract int c(int i2);
    }

    /* loaded from: classes.dex */
    public interface b {
        Iterator<String> a(r rVar, CharSequence charSequence);
    }

    public r(b bVar, boolean z, c cVar, int i2) {
        this.c = bVar;
        this.b = z;
        this.a = cVar;
        this.f3378d = i2;
    }
}
