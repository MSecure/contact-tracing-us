package h.a.j1;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;

public class y extends c {
    public int b;
    public final Queue<j2> c = new ArrayDeque();

    public class a extends c {
        public a(y yVar) {
            super(null);
        }

        @Override // h.a.j1.y.c
        public int a(j2 j2Var, int i2) {
            return j2Var.E();
        }
    }

    public class b extends c {
        public int c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f3774d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ byte[] f3775e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(y yVar, int i2, byte[] bArr) {
            super(null);
            this.f3774d = i2;
            this.f3775e = bArr;
            this.c = i2;
        }

        @Override // h.a.j1.y.c
        public int a(j2 j2Var, int i2) {
            j2Var.O(this.f3775e, this.c, i2);
            this.c += i2;
            return 0;
        }
    }

    public static abstract class c {
        public int a;
        public IOException b;

        public c(a aVar) {
        }

        public abstract int a(j2 j2Var, int i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0049 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004a  */
    public final void A(c cVar, int i2) {
        y yVar;
        if (this.b >= i2) {
            if (!this.c.isEmpty()) {
                yVar = this;
                yVar.v();
            } else {
                yVar = this;
            }
            if (i2 <= 0 && !yVar.c.isEmpty()) {
                j2 peek = yVar.c.peek();
                int min = Math.min(i2, peek.b());
                try {
                    cVar.a = cVar.a(peek, min);
                } catch (IOException e2) {
                    cVar.b = e2;
                }
                if (!(cVar.b != null)) {
                    i2 -= min;
                    yVar.b -= min;
                    yVar.v();
                    if (i2 <= 0) {
                    }
                    if (i2 <= 0) {
                    }
                }
            } else if (i2 <= 0) {
                throw new AssertionError("Failed executing read operation");
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override // h.a.j1.j2
    public int E() {
        a aVar = new a(this);
        A(aVar, 1);
        return aVar.a;
    }

    /* renamed from: N */
    public y y(int i2) {
        if (b() >= i2) {
            this.b -= i2;
            y yVar = new y();
            while (i2 > 0) {
                j2 peek = this.c.peek();
                if (peek.b() > i2) {
                    yVar.d(peek.y(i2));
                    i2 = 0;
                } else {
                    yVar.d(this.c.poll());
                    i2 -= peek.b();
                }
            }
            return yVar;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // h.a.j1.j2
    public void O(byte[] bArr, int i2, int i3) {
        A(new b(this, i2, bArr), i3);
    }

    @Override // h.a.j1.j2
    public int b() {
        return this.b;
    }

    @Override // h.a.j1.c, h.a.j1.j2, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        while (!this.c.isEmpty()) {
            this.c.remove().close();
        }
    }

    public void d(j2 j2Var) {
        if (!(j2Var instanceof y)) {
            this.c.add(j2Var);
            this.b = j2Var.b() + this.b;
            return;
        }
        y yVar = (y) j2Var;
        while (!yVar.c.isEmpty()) {
            this.c.add(yVar.c.remove());
        }
        this.b += yVar.b;
        yVar.b = 0;
        yVar.close();
    }

    public final void v() {
        if (this.c.peek().b() == 0) {
            this.c.remove().close();
        }
    }
}
