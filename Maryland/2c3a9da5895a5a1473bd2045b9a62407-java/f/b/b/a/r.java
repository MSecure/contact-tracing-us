package f.b.b.a;

import java.util.Iterator;

public final class r {
    public final c a;
    public final boolean b;
    public final b c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2966d;

    public static abstract class a extends b<String> {

        /* renamed from: d  reason: collision with root package name */
        public final CharSequence f2967d;

        /* renamed from: e  reason: collision with root package name */
        public final c f2968e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f2969f;

        /* renamed from: g  reason: collision with root package name */
        public int f2970g = 0;

        /* renamed from: h  reason: collision with root package name */
        public int f2971h;

        public a(r rVar, CharSequence charSequence) {
            this.f2968e = rVar.a;
            this.f2969f = rVar.b;
            this.f2971h = rVar.f2966d;
            this.f2967d = charSequence;
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
        this.f2966d = i2;
    }
}
