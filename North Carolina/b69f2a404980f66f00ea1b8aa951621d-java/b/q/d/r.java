package b.q.d;

import android.annotation.SuppressLint;
import android.os.Trace;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

public final class r implements Runnable {
    public static final ThreadLocal<r> f = new ThreadLocal<>();
    public static Comparator<c> g = new a();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<RecyclerView> f1574b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public long f1575c;

    /* renamed from: d  reason: collision with root package name */
    public long f1576d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<c> f1577e = new ArrayList<>();

    public static class a implements Comparator<c> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
            if (r6.f1585d == null) goto L_0x001b;
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
            if ((cVar3.f1585d == null) == (cVar4.f1585d == null)) {
                boolean z = cVar3.f1582a;
                if (z == cVar4.f1582a) {
                    int i = cVar4.f1583b - cVar3.f1583b;
                    if (i != 0) {
                        return i;
                    }
                    int i2 = cVar3.f1584c - cVar4.f1584c;
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
    public static class b implements RecyclerView.o.c {

        /* renamed from: a  reason: collision with root package name */
        public int f1578a;

        /* renamed from: b  reason: collision with root package name */
        public int f1579b;

        /* renamed from: c  reason: collision with root package name */
        public int[] f1580c;

        /* renamed from: d  reason: collision with root package name */
        public int f1581d;

        public void a(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            } else if (i2 >= 0) {
                int i3 = this.f1581d * 2;
                int[] iArr = this.f1580c;
                if (iArr == null) {
                    int[] iArr2 = new int[4];
                    this.f1580c = iArr2;
                    Arrays.fill(iArr2, -1);
                } else if (i3 >= iArr.length) {
                    int[] iArr3 = new int[(i3 * 2)];
                    this.f1580c = iArr3;
                    System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                }
                int[] iArr4 = this.f1580c;
                iArr4[i3] = i;
                iArr4[i3 + 1] = i2;
                this.f1581d++;
            } else {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
        }

        public void b(RecyclerView recyclerView, boolean z) {
            this.f1581d = 0;
            int[] iArr = this.f1580c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.o oVar = recyclerView.mLayout;
            if (recyclerView.mAdapter != null && oVar != null && oVar.l) {
                if (z) {
                    if (!recyclerView.mAdapterHelper.g()) {
                        oVar.j(recyclerView.mAdapter.getItemCount(), this);
                    }
                } else if (!recyclerView.hasPendingAdapterUpdates()) {
                    oVar.i(this.f1578a, this.f1579b, recyclerView.mState, this);
                }
                int i = this.f1581d;
                if (i > oVar.m) {
                    oVar.m = i;
                    oVar.n = z;
                    recyclerView.mRecycler.m();
                }
            }
        }

        public boolean c(int i) {
            if (this.f1580c != null) {
                int i2 = this.f1581d * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.f1580c[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1582a;

        /* renamed from: b  reason: collision with root package name */
        public int f1583b;

        /* renamed from: c  reason: collision with root package name */
        public int f1584c;

        /* renamed from: d  reason: collision with root package name */
        public RecyclerView f1585d;

        /* renamed from: e  reason: collision with root package name */
        public int f1586e;
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.f1575c == 0) {
            this.f1575c = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        b bVar = recyclerView.mPrefetchRegistry;
        bVar.f1578a = i;
        bVar.f1579b = i2;
    }

    public void b(long j) {
        RecyclerView recyclerView;
        c cVar;
        int size = this.f1574b.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView2 = this.f1574b.get(i2);
            if (recyclerView2.getWindowVisibility() == 0) {
                recyclerView2.mPrefetchRegistry.b(recyclerView2, false);
                i += recyclerView2.mPrefetchRegistry.f1581d;
            }
        }
        this.f1577e.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView3 = this.f1574b.get(i4);
            if (recyclerView3.getWindowVisibility() == 0) {
                b bVar = recyclerView3.mPrefetchRegistry;
                int abs = Math.abs(bVar.f1579b) + Math.abs(bVar.f1578a);
                for (int i5 = 0; i5 < bVar.f1581d * 2; i5 += 2) {
                    if (i3 >= this.f1577e.size()) {
                        cVar = new c();
                        this.f1577e.add(cVar);
                    } else {
                        cVar = this.f1577e.get(i3);
                    }
                    int i6 = bVar.f1580c[i5 + 1];
                    cVar.f1582a = i6 <= abs;
                    cVar.f1583b = abs;
                    cVar.f1584c = i6;
                    cVar.f1585d = recyclerView3;
                    cVar.f1586e = bVar.f1580c[i5];
                    i3++;
                }
            }
        }
        Collections.sort(this.f1577e, g);
        for (int i7 = 0; i7 < this.f1577e.size(); i7++) {
            c cVar2 = this.f1577e.get(i7);
            if (cVar2.f1585d != null) {
                RecyclerView.d0 c2 = c(cVar2.f1585d, cVar2.f1586e, cVar2.f1582a ? RecyclerView.FOREVER_NS : j);
                if (!(c2 == null || c2.mNestedRecyclerView == null || !c2.isBound() || c2.isInvalid() || (recyclerView = c2.mNestedRecyclerView.get()) == null)) {
                    if (recyclerView.mDataSetHasChangedAfterLayout && recyclerView.mChildHelper.h() != 0) {
                        recyclerView.removeAndRecycleViews();
                    }
                    b bVar2 = recyclerView.mPrefetchRegistry;
                    bVar2.b(recyclerView, true);
                    if (bVar2.f1581d != 0) {
                        try {
                            b.i.h.b.a(RecyclerView.TRACE_NESTED_PREFETCH_TAG);
                            RecyclerView.a0 a0Var = recyclerView.mState;
                            RecyclerView.g gVar = recyclerView.mAdapter;
                            a0Var.f200d = 1;
                            a0Var.f201e = gVar.getItemCount();
                            a0Var.g = false;
                            a0Var.h = false;
                            a0Var.i = false;
                            for (int i8 = 0; i8 < bVar2.f1581d * 2; i8 += 2) {
                                c(recyclerView, bVar2.f1580c[i8], j);
                            }
                            Trace.endSection();
                        } catch (Throwable th) {
                            b.i.h.b.b();
                            throw th;
                        }
                    }
                }
                cVar2.f1582a = false;
                cVar2.f1583b = 0;
                cVar2.f1584c = 0;
                cVar2.f1585d = null;
                cVar2.f1586e = 0;
            } else {
                return;
            }
        }
    }

    public final RecyclerView.d0 c(RecyclerView recyclerView, int i, long j) {
        boolean z;
        int h = recyclerView.mChildHelper.h();
        int i2 = 0;
        while (true) {
            if (i2 >= h) {
                z = false;
                break;
            }
            RecyclerView.d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.g(i2));
            if (childViewHolderInt.mPosition == i && !childViewHolderInt.isInvalid()) {
                z = true;
                break;
            }
            i2++;
        }
        if (z) {
            return null;
        }
        RecyclerView.v vVar = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            RecyclerView.d0 k = vVar.k(i, false, j);
            if (k != null) {
                if (!k.isBound() || k.isInvalid()) {
                    vVar.a(k, false);
                } else {
                    vVar.h(k.itemView);
                }
            }
            return k;
        } finally {
            recyclerView.onExitLayoutOrScroll(false);
        }
    }

    public void run() {
        try {
            b.i.h.b.a(RecyclerView.TRACE_PREFETCH_TAG);
            if (this.f1574b.isEmpty()) {
                this.f1575c = 0;
                Trace.endSection();
                return;
            }
            int size = this.f1574b.size();
            long j = 0;
            for (int i = 0; i < size; i++) {
                RecyclerView recyclerView = this.f1574b.get(i);
                if (recyclerView.getWindowVisibility() == 0) {
                    j = Math.max(recyclerView.getDrawingTime(), j);
                }
            }
            if (j == 0) {
                this.f1575c = 0;
                Trace.endSection();
                return;
            }
            b(TimeUnit.MILLISECONDS.toNanos(j) + this.f1576d);
            this.f1575c = 0;
            Trace.endSection();
        } catch (Throwable th) {
            this.f1575c = 0;
            b.i.h.b.b();
            throw th;
        }
    }
}
