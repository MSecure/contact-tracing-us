package e.m.a;

import android.graphics.Typeface;
import android.util.SparseArray;
import e.b.a.m;
import e.m.a.n.b;

public final class k {
    public final b a;
    public final char[] b;
    public final a c = new a(1024);

    /* renamed from: d  reason: collision with root package name */
    public final Typeface f1654d;

    public static class a {
        public final SparseArray<a> a;
        public g b;

        public a() {
            this.a = new SparseArray<>(1);
        }

        public a(int i2) {
            this.a = new SparseArray<>(i2);
        }

        public void a(g gVar, int i2, int i3) {
            int a2 = gVar.a(i2);
            SparseArray<a> sparseArray = this.a;
            a aVar = sparseArray == null ? null : sparseArray.get(a2);
            if (aVar == null) {
                aVar = new a();
                this.a.put(gVar.a(i2), aVar);
            }
            if (i3 > i2) {
                aVar.a(gVar, i2 + 1, i3);
            } else {
                aVar.b = gVar;
            }
        }
    }

    public k(Typeface typeface, b bVar) {
        this.f1654d = typeface;
        this.a = bVar;
        this.b = new char[(bVar.c() * 2)];
        int c2 = bVar.c();
        for (int i2 = 0; i2 < c2; i2++) {
            g gVar = new g(this, i2);
            Character.toChars(gVar.d(), this.b, i2 * 2);
            m.e.q(gVar, "emoji metadata cannot be null");
            m.e.i(gVar.b() > 0, "invalid metadata codepoint length");
            this.c.a(gVar, 0, gVar.b() - 1);
        }
    }
}
