package j.m;

import j.j.b.e;
import j.k.c;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public final class b implements j.l.b<c> {
    public final CharSequence a;
    public final int b;
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public final j.j.a.c<CharSequence, Integer, j.c<Integer, Integer>> f3999d;

    public static final class a implements Iterator<c> {
        public int b = -1;
        public int c;

        /* renamed from: d  reason: collision with root package name */
        public int f4000d;

        /* renamed from: e  reason: collision with root package name */
        public c f4001e;

        /* renamed from: f  reason: collision with root package name */
        public int f4002f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f4003g;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a(b bVar) {
            this.f4003g = bVar;
            int i2 = bVar.b;
            int length = bVar.a.length();
            if (length >= 0) {
                if (i2 < 0) {
                    i2 = 0;
                } else if (i2 > length) {
                    i2 = length;
                }
                this.c = i2;
                this.f4000d = i2;
                return;
            }
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + length + " is less than minimum " + 0 + '.');
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0018, code lost:
            if (r5 < r3) goto L_0x001a;
         */
        public final void b() {
            c cVar;
            c cVar2;
            int i2 = this.f4000d;
            int i3 = 0;
            if (i2 < 0) {
                this.b = 0;
                this.f4001e = null;
                return;
            }
            b bVar = this.f4003g;
            int i4 = bVar.c;
            if (i4 > 0) {
                int i5 = this.f4002f + 1;
                this.f4002f = i5;
            }
            if (i2 <= bVar.a.length()) {
                b bVar2 = this.f4003g;
                j.c<Integer, Integer> c2 = bVar2.f3999d.c(bVar2.a, Integer.valueOf(this.f4000d));
                if (c2 == null) {
                    cVar = new c(this.c, h.c(this.f4003g.a));
                    this.f4001e = cVar;
                    this.f4000d = -1;
                    this.b = 1;
                }
                int intValue = c2.b.intValue();
                int intValue2 = c2.c.intValue();
                int i6 = this.c;
                if (intValue <= Integer.MIN_VALUE) {
                    c cVar3 = c.f3996f;
                    cVar2 = c.f3995e;
                } else {
                    cVar2 = new c(i6, intValue - 1);
                }
                this.f4001e = cVar2;
                int i7 = intValue + intValue2;
                this.c = i7;
                if (intValue2 == 0) {
                    i3 = 1;
                }
                this.f4000d = i7 + i3;
                this.b = 1;
            }
            cVar = new c(this.c, h.c(this.f4003g.a));
            this.f4001e = cVar;
            this.f4000d = -1;
            this.b = 1;
        }

        public boolean hasNext() {
            if (this.b == -1) {
                b();
            }
            return this.b == 1;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.Iterator
        public c next() {
            if (this.b == -1) {
                b();
            }
            if (this.b != 0) {
                c cVar = this.f4001e;
                Objects.requireNonNull(cVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
                this.f4001e = null;
                this.b = -1;
                return cVar;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: j.j.a.c<? super java.lang.CharSequence, ? super java.lang.Integer, j.c<java.lang.Integer, java.lang.Integer>> */
    /* JADX WARN: Multi-variable type inference failed */
    public b(CharSequence charSequence, int i2, int i3, j.j.a.c<? super CharSequence, ? super Integer, j.c<Integer, Integer>> cVar) {
        e.c(charSequence, "input");
        e.c(cVar, "getNextMatch");
        this.a = charSequence;
        this.b = i2;
        this.c = i3;
        this.f3999d = cVar;
    }

    @Override // j.l.b
    public Iterator<c> iterator() {
        return new a(this);
    }
}
