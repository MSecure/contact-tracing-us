package f.b.b.a;

import java.util.Iterator;

public final class r {
    public final c a;
    public final boolean b;
    public final b c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3123d;

    public static abstract class a extends b<String> {

        /* renamed from: d  reason: collision with root package name */
        public final CharSequence f3124d;

        /* renamed from: e  reason: collision with root package name */
        public final c f3125e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f3126f;

        /* renamed from: g  reason: collision with root package name */
        public int f3127g = 0;

        /* renamed from: h  reason: collision with root package name */
        public int f3128h;

        public a(r rVar, CharSequence charSequence) {
            this.f3125e = rVar.a;
            this.f3126f = rVar.b;
            this.f3128h = rVar.f3123d;
            this.f3124d = charSequence;
        }

        public abstract int b(int i2);

        public abstract int c(int i2);
    }

    public interface b {
        Iterator<String> a(r rVar, CharSequence charSequence);
    }

    public r(b bVar, boolean z, c cVar, int i2) {
        this.c = bVar;
        this.b = z;
        this.a = cVar;
        this.f3123d = i2;
    }
}
