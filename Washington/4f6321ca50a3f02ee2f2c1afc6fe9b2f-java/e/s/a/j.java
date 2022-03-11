package e.s.a;

import android.os.Trace;
import androidx.recyclerview.widget.RecyclerView;
import e.i.e.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

public final class j implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    public static final ThreadLocal<j> f1802f = new ThreadLocal<>();

    /* renamed from: g  reason: collision with root package name */
    public static Comparator<c> f1803g = new a();
    public ArrayList<RecyclerView> b = new ArrayList<>();
    public long c;

    /* renamed from: d  reason: collision with root package name */
    public long f1804d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<c> f1805e = new ArrayList<>();

    public static class a implements Comparator<c> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
            if (r0 == null) goto L_0x0023;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
            if (r0 != false) goto L_0x0022;
         */
        @Override // java.util.Comparator
        public int compare(c cVar, c cVar2) {
            c cVar3 = cVar;
            c cVar4 = cVar2;
            RecyclerView recyclerView = cVar3.f1807d;
            int i2 = 1;
            if ((recyclerView == null) == (cVar4.f1807d == null)) {
                boolean z = cVar3.a;
                if (z == cVar4.a) {
                    int i3 = cVar4.b - cVar3.b;
                    if (i3 != 0) {
                        return i3;
                    }
                    int i4 = cVar3.c - cVar4.c;
                    if (i4 != 0) {
                        return i4;
                    }
                    return 0;
                }
            }
            i2 = -1;
            return i2;
        }
    }

    public static class b implements RecyclerView.m.c {
        public int a;
        public int b;
        public int[] c;

        /* renamed from: d  reason: collision with root package name */
        public int f1806d;

        public void a(int i2, int i3) {
            if (i2 < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            } else if (i3 >= 0) {
                int i4 = this.f1806d * 2;
                int[] iArr = this.c;
                if (iArr == null) {
                    int[] iArr2 = new int[4];
                    this.c = iArr2;
                    Arrays.fill(iArr2, -1);
                } else if (i4 >= iArr.length) {
                    int[] iArr3 = new int[(i4 * 2)];
                    this.c = iArr3;
                    System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                }
                int[] iArr4 = this.c;
                iArr4[i4] = i2;
                iArr4[i4 + 1] = i3;
                this.f1806d++;
            } else {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
        }

        public void b(RecyclerView recyclerView, boolean z) {
            this.f1806d = 0;
            int[] iArr = this.c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.m mVar = recyclerView.n;
            if (recyclerView.m != null && mVar != null && mVar.f231k) {
                if (z) {
                    if (!recyclerView.f199e.g()) {
                        mVar.j(recyclerView.m.c(), this);
                    }
                } else if (!recyclerView.M()) {
                    mVar.i(this.a, this.b, recyclerView.i0, this);
                }
                int i2 = this.f1806d;
                if (i2 > mVar.f232l) {
                    mVar.f232l = i2;
                    mVar.m = z;
                    recyclerView.c.l();
                }
            }
        }

        public boolean c(int i2) {
            if (this.c != null) {
                int i3 = this.f1806d * 2;
                for (int i4 = 0; i4 < i3; i4 += 2) {
                    if (this.c[i4] == i2) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static class c {
        public boolean a;
        public int b;
        public int c;

        /* renamed from: d  reason: collision with root package name */
        public RecyclerView f1807d;

        /* renamed from: e  reason: collision with root package name */
        public int f1808e;
    }

    public void a(RecyclerView recyclerView, int i2, int i3) {
        if (recyclerView.isAttachedToWindow() && this.c == 0) {
            this.c = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        b bVar = recyclerView.h0;
        bVar.a = i2;
        bVar.b = i3;
    }

    public void b(long j2) {
        c cVar;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        c cVar2;
        int size = this.b.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            RecyclerView recyclerView3 = this.b.get(i3);
            if (recyclerView3.getWindowVisibility() == 0) {
                recyclerView3.h0.b(recyclerView3, false);
                i2 += recyclerView3.h0.f1806d;
            }
        }
        this.f1805e.ensureCapacity(i2);
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            RecyclerView recyclerView4 = this.b.get(i5);
            if (recyclerView4.getWindowVisibility() == 0) {
                b bVar = recyclerView4.h0;
                int abs = Math.abs(bVar.b) + Math.abs(bVar.a);
                for (int i6 = 0; i6 < bVar.f1806d * 2; i6 += 2) {
                    if (i4 >= this.f1805e.size()) {
                        cVar2 = new c();
                        this.f1805e.add(cVar2);
                    } else {
                        cVar2 = this.f1805e.get(i4);
                    }
                    int[] iArr = bVar.c;
                    int i7 = iArr[i6 + 1];
                    cVar2.a = i7 <= abs;
                    cVar2.b = abs;
                    cVar2.c = i7;
                    cVar2.f1807d = recyclerView4;
                    cVar2.f1808e = iArr[i6];
                    i4++;
                }
            }
        }
        Collections.sort(this.f1805e, f1803g);
        int i8 = 0;
        while (i8 < this.f1805e.size() && (recyclerView = (cVar = this.f1805e.get(i8)).f1807d) != null) {
            RecyclerView.b0 c2 = c(recyclerView, cVar.f1808e, cVar.a ? Long.MAX_VALUE : j2);
            if (!(c2 == null || c2.b == null || !c2.j() || c2.k() || (recyclerView2 = c2.b.get()) == null)) {
                if (recyclerView2.E && recyclerView2.f200f.h() != 0) {
                    recyclerView2.d0();
                }
                b bVar2 = recyclerView2.h0;
                bVar2.b(recyclerView2, true);
                if (bVar2.f1806d != 0) {
                    try {
                        int i9 = f.a;
                        Trace.beginSection("RV Nested Prefetch");
                        RecyclerView.y yVar = recyclerView2.i0;
                        RecyclerView.e eVar = recyclerView2.m;
                        yVar.f251d = 1;
                        yVar.f252e = eVar.c();
                        yVar.f254g = false;
                        yVar.f255h = false;
                        yVar.f256i = false;
                        for (int i10 = 0; i10 < bVar2.f1806d * 2; i10 += 2) {
                            c(recyclerView2, bVar2.c[i10], j2);
                        }
                        Trace.endSection();
                    } catch (Throwable th) {
                        int i11 = f.a;
                        Trace.endSection();
                        throw th;
                    }
                }
            }
            cVar.a = false;
            cVar.b = 0;
            cVar.c = 0;
            cVar.f1807d = null;
            cVar.f1808e = 0;
            i8++;
        }
    }

    public final RecyclerView.b0 c(RecyclerView recyclerView, int i2, long j2) {
        boolean z;
        int h2 = recyclerView.f200f.h();
        int i3 = 0;
        while (true) {
            if (i3 >= h2) {
                z = false;
                break;
            }
            RecyclerView.b0 K = RecyclerView.K(recyclerView.f200f.g(i3));
            if (K.c == i2 && !K.k()) {
                z = true;
                break;
            }
            i3++;
        }
        if (z) {
            return null;
        }
        RecyclerView.t tVar = recyclerView.c;
        try {
            recyclerView.U();
            RecyclerView.b0 j3 = tVar.j(i2, false, j2);
            if (j3 != null) {
                if (!j3.j() || j3.k()) {
                    tVar.a(j3, false);
                } else {
                    tVar.g(j3.a);
                }
            }
            return j3;
        } finally {
            recyclerView.V(false);
        }
    }

    public void run() {
        try {
            int i2 = f.a;
            Trace.beginSection("RV Prefetch");
            if (this.b.isEmpty()) {
                this.c = 0;
                Trace.endSection();
                return;
            }
            int size = this.b.size();
            long j2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                RecyclerView recyclerView = this.b.get(i3);
                if (recyclerView.getWindowVisibility() == 0) {
                    j2 = Math.max(recyclerView.getDrawingTime(), j2);
                }
            }
            if (j2 == 0) {
                this.c = 0;
                Trace.endSection();
                return;
            }
            b(TimeUnit.MILLISECONDS.toNanos(j2) + this.f1804d);
            this.c = 0;
            Trace.endSection();
        } catch (Throwable th) {
            this.c = 0;
            int i4 = f.a;
            Trace.endSection();
            throw th;
        }
    }
}
