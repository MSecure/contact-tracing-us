package f.b.b.a;

import java.util.Iterator;

public final class r {
    public final c a;
    public final boolean b;
    public final b c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2862d;

    public static abstract class a extends b<String> {

        /* renamed from: d  reason: collision with root package name */
        public final CharSequence f2863d;

        /* renamed from: e  reason: collision with root package name */
        public final c f2864e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f2865f;

        /* renamed from: g  reason: collision with root package name */
        public int f2866g = 0;

        /* renamed from: h  reason: collision with root package name */
        public int f2867h;

        public a(r rVar, CharSequence charSequence) {
            this.f2864e = rVar.a;
            this.f2865f = rVar.b;
            this.f2867h = rVar.f2862d;
            this.f2863d = charSequence;
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
        this.f2862d = i2;
    }
}
