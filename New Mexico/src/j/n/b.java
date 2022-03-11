package j.n;

import j.k.b.e;
import j.l.c;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
/* loaded from: classes.dex */
public final class b implements j.m.b<c> {
    public final CharSequence a;
    public final int b;
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public final j.k.a.c<CharSequence, Integer, j.c<Integer, Integer>> f4578d;

    /* loaded from: classes.dex */
    public static final class a implements Iterator<c> {
        public int b = -1;
        public int c;

        /* renamed from: d  reason: collision with root package name */
        public int f4579d;

        /* renamed from: e  reason: collision with root package name */
        public c f4580e;

        /* renamed from: f  reason: collision with root package name */
        public int f4581f;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
            int i2 = b.this.b;
            int length = b.this.a.length();
            if (length >= 0) {
                if (i2 < 0) {
                    i2 = 0;
                } else if (i2 > length) {
                    i2 = length;
                }
                this.c = i2;
                this.f4579d = i2;
                return;
            }
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + length + " is less than minimum 0.");
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x0018, code lost:
            if (r5 < r3) goto L_0x001a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump */
        public final void b() {
            c cVar;
            c cVar2;
            int i2 = this.f4579d;
            int i3 = 0;
            if (i2 < 0) {
                this.b = 0;
                this.f4580e = null;
                return;
            }
            b bVar = b.this;
            int i4 = bVar.c;
            if (i4 > 0) {
                int i5 = this.f4581f + 1;
                this.f4581f = i5;
            }
            if (i2 <= bVar.a.length()) {
                b bVar2 = b.this;
                j.c<Integer, Integer> c = bVar2.f4578d.c(bVar2.a, Integer.valueOf(this.f4579d));
                if (c == null) {
                    cVar = new c(this.c, h.c(b.this.a));
                    this.f4580e = cVar;
                    this.f4579d = -1;
                    this.b = 1;
                }
                int intValue = c.b.intValue();
                int intValue2 = c.c.intValue();
                int i6 = this.c;
                if (intValue <= Integer.MIN_VALUE) {
                    c cVar3 = c.f4575f;
                    cVar2 = c.f4574e;
                } else {
                    cVar2 = new c(i6, intValue - 1);
                }
                this.f4580e = cVar2;
                int i7 = intValue + intValue2;
                this.c = i7;
                if (intValue2 == 0) {
                    i3 = 1;
                }
                this.f4579d = i7 + i3;
                this.b = 1;
            }
            cVar = new c(this.c, h.c(b.this.a));
            this.f4580e = cVar;
            this.f4579d = -1;
            this.b = 1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.b == -1) {
                b();
            }
            return this.b == 1;
        }

        @Override // java.util.Iterator
        public c next() {
            if (this.b == -1) {
                b();
            }
            if (this.b != 0) {
                c cVar = this.f4580e;
                Objects.requireNonNull(cVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
                this.f4580e = null;
                this.b = -1;
                return cVar;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(CharSequence charSequence, int i2, int i3, j.k.a.c<? super CharSequence, ? super Integer, j.c<Integer, Integer>> cVar) {
        e.c(charSequence, "input");
        e.c(cVar, "getNextMatch");
        this.a = charSequence;
        this.b = i2;
        this.c = i3;
        this.f4578d = cVar;
    }

    @Override // j.m.b
    public Iterator<c> iterator() {
        return new a();
    }
}
