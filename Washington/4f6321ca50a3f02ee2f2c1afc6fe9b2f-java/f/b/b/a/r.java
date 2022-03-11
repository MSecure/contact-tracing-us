package f.b.b.a;

import java.util.Iterator;

public final class r {
    public final c a;
    public final boolean b;
    public final b c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2870d;

    public static abstract class a extends b<String> {

        /* renamed from: d  reason: collision with root package name */
        public final CharSequence f2871d;

        /* renamed from: e  reason: collision with root package name */
        public final c f2872e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f2873f;

        /* renamed from: g  reason: collision with root package name */
        public int f2874g = 0;

        /* renamed from: h  reason: collision with root package name */
        public int f2875h;

        public a(r rVar, CharSequence charSequence) {
            this.f2872e = rVar.a;
            this.f2873f = rVar.b;
            this.f2875h = rVar.f2870d;
            this.f2871d = charSequence;
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
        this.f2870d = i2;
    }
}
