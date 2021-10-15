package b.r.d;

import android.annotation.SuppressLint;
import android.os.Trace;
import androidx.recyclerview.widget.RecyclerView;
import b.i.h.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

public final class r implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    public static final ThreadLocal<r> f2426f = new ThreadLocal<>();

    /* renamed from: g  reason: collision with root package name */
    public static Comparator<c> f2427g = new a();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<RecyclerView> f2428b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public long f2429c;

    /* renamed from: d  reason: collision with root package name */
    public long f2430d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<c> f2431e = new ArrayList<>();

    public static class a implements Comparator<c> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
            if (r6.f2439d == null) goto L_0x001b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0025, code lost:
            if (r0 != false) goto L_0x001d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            return -1;
         */
        @Override // java.util.Comparator
        public int compare(c cVar, c cVar2) {
            c cVar3 = cVar;
            c cVar4 = cVar2;
            if ((cVar3.f2439d == null) == (cVar4.f2439d == null)) {
                boolean z = cVar3.f2436a;
                if (z == cVar4.f2436a) {
                    int i = cVar4.f2437b - cVar3.f2437b;
                    if (i != 0) {
                        return i;
                    }
                    int i2 = cVar3.f2438c - cVar4.f2438c;
                    if (i2 != 0) {
                        return i2;
                    }
                    return 0;
                }
            }
            return 1;
        }
    }

    @SuppressLint({"VisibleForTests"})
    public static class b implements RecyclerView.m.c {

        /* renamed from: a  reason: collision with root package name */
        public int f2432a;

        /* renamed from: b  reason: collision with root package name */
        public int f2433b;

        /* renamed from: c  reason: collision with root package name */
        public int[] f2434c;

        /* renamed from: d  reason: collision with root package name */
        public int f2435d;

        public void a(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            } else if (i2 >= 0) {
                int i3 = this.f2435d * 2;
                int[] iArr = this.f2434c;
                if (iArr == null) {
                    int[] iArr2 = new int[4];
                    this.f2434c = iArr2;
                    Arrays.fill(iArr2, -1);
                } else if (i3 >= iArr.length) {
                    int[] iArr3 = new int[(i3 * 2)];
                    this.f2434c = iArr3;
                    System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                }
                int[] iArr4 = this.f2434c;
                iArr4[i3] = i;
                iArr4[i3 + 1] = i2;
                this.f2435d++;
            } else {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
        }

        public void b(RecyclerView recyclerView, boolean z) {
            this.f2435d = 0;
            int[] iArr = this.f2434c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.m mVar = recyclerView.n;
            if (recyclerView.m != null && mVar != null && mVar.l) {
                if (z) {
                    if (!recyclerView.f282e.g()) {
                        mVar.j(recyclerView.m.getItemCount(), this);
                    }
                } else if (!recyclerView.N()) {
                    mVar.i(this.f2432a, this.f2433b, recyclerView.h0, this);
                }
                int i = this.f2435d;
                if (i > mVar.m) {
                    mVar.m = i;
                    mVar.n = z;
                    recyclerView.f280c.l();
                }
            }
        }

        public boolean c(int i) {
            if (this.f2434c != null) {
                int i2 = this.f2435d * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.f2434c[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f2436a;

        /* renamed from: b  reason: collision with root package name */
        public int f2437b;

        /* renamed from: c  reason: collision with root package name */
        public int f2438c;

        /* renamed from: d  reason: collision with root package name */
        public RecyclerView f2439d;

        /* renamed from: e  reason: collision with root package name */
        public int f2440e;
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.f2429c == 0) {
            this.f2429c = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        b bVar = recyclerView.g0;
        bVar.f2432a = i;
        bVar.f2433b = i2;
    }

    public void b(long j) {
        RecyclerView recyclerView;
        c cVar;
        int size = this.f2428b.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView2 = this.f2428b.get(i2);
            if (recyclerView2.getWindowVisibility() == 0) {
                recyclerView2.g0.b(recyclerView2, false);
                i += recyclerView2.g0.f2435d;
            }
        }
        this.f2431e.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView3 = this.f2428b.get(i4);
            if (recyclerView3.getWindowVisibility() == 0) {
                b bVar = recyclerView3.g0;
                int abs = Math.abs(bVar.f2433b) + Math.abs(bVar.f2432a);
                for (int i5 = 0; i5 < bVar.f2435d * 2; i5 += 2) {
                    if (i3 >= this.f2431e.size()) {
                        cVar = new c();
                        this.f2431e.add(cVar);
                    } else {
                        cVar = this.f2431e.get(i3);
                    }
                    int i6 = bVar.f2434c[i5 + 1];
                    cVar.f2436a = i6 <= abs;
                    cVar.f2437b = abs;
                    cVar.f2438c = i6;
                    cVar.f2439d = recyclerView3;
                    cVar.f2440e = bVar.f2434c[i5];
                    i3++;
                }
            }
        }
        Collections.sort(this.f2431e, f2427g);
        for (int i7 = 0; i7 < this.f2431e.size(); i7++) {
            c cVar2 = this.f2431e.get(i7);
            if (cVar2.f2439d != null) {
                RecyclerView.a0 c2 = c(cVar2.f2439d, cVar2.f2440e, cVar2.f2436a ? Long.MAX_VALUE : j);
                if (!(c2 == null || c2.mNestedRecyclerView == null || !c2.isBound() || c2.isInvalid() || (recyclerView = c2.mNestedRecyclerView.get()) == null)) {
                    if (recyclerView.D && recyclerView.f283f.h() != 0) {
                        recyclerView.e0();
                    }
                    b bVar2 = recyclerView.g0;
                    bVar2.b(recyclerView, true);
                    if (bVar2.f2435d != 0) {
                        try {
                            f.a("RV Nested Prefetch");
                            RecyclerView.x xVar = recyclerView.h0;
                            RecyclerView.e eVar = recyclerView.m;
                            xVar.f346d = 1;
                            xVar.f347e = eVar.getItemCount();
                            xVar.f349g = false;
                            xVar.h = false;
                            xVar.i = false;
                            for (int i8 = 0; i8 < bVar2.f2435d * 2; i8 += 2) {
                                c(recyclerView, bVar2.f2434c[i8], j);
                            }
                            Trace.endSection();
                        } catch (Throwable th) {
                            f.b();
                            throw th;
                        }
                    }
                }
                cVar2.f2436a = false;
                cVar2.f2437b = 0;
                cVar2.f2438c = 0;
                cVar2.f2439d = null;
                cVar2.f2440e = 0;
            } else {
                return;
            }
        }
    }

    public final RecyclerView.a0 c(RecyclerView recyclerView, int i, long j) {
        boolean z;
        int h = recyclerView.f283f.h();
        int i2 = 0;
        while (true) {
            if (i2 >= h) {
                z = false;
                break;
            }
            RecyclerView.a0 K = RecyclerView.K(recyclerView.f283f.g(i2));
            if (K.mPosition == i && !K.isInvalid()) {
                z = true;
                break;
            }
            i2++;
        }
        if (z) {
            return null;
        }
        RecyclerView.s sVar = recyclerView.f280c;
        try {
            recyclerView.V();
            RecyclerView.a0 j2 = sVar.j(i, false, j);
            if (j2 != null) {
                if (!j2.isBound() || j2.isInvalid()) {
                    sVar.a(j2, false);
                } else {
                    sVar.g(j2.itemView);
                }
            }
            return j2;
        } finally {
            recyclerView.W(false);
        }
    }

    public void run() {
        try {
            f.a("RV Prefetch");
            if (this.f2428b.isEmpty()) {
                this.f2429c = 0;
                Trace.endSection();
                return;
            }
            int size = this.f2428b.size();
            long j = 0;
            for (int i = 0; i < size; i++) {
                RecyclerView recyclerView = this.f2428b.get(i);
                if (recyclerView.getWindowVisibility() == 0) {
                    j = Math.max(recyclerView.getDrawingTime(), j);
                }
            }
            if (j == 0) {
                this.f2429c = 0;
                Trace.endSection();
                return;
            }
            b(TimeUnit.MILLISECONDS.toNanos(j) + this.f2430d);
            this.f2429c = 0;
            Trace.endSection();
        } catch (Throwable th) {
            this.f2429c = 0;
            f.b();
            throw th;
        }
    }
}
