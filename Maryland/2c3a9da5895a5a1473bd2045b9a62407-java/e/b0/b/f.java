package e.b0.b;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;

public final class f extends RecyclerView.r {
    public ViewPager2.e a;
    public final ViewPager2 b;
    public final RecyclerView c;

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayoutManager f983d;

    /* renamed from: e  reason: collision with root package name */
    public int f984e;

    /* renamed from: f  reason: collision with root package name */
    public int f985f;

    /* renamed from: g  reason: collision with root package name */
    public a f986g = new a();

    /* renamed from: h  reason: collision with root package name */
    public int f987h;

    /* renamed from: i  reason: collision with root package name */
    public int f988i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f989j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f990k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f991l;
    public boolean m;

    public static final class a {
        public int a;
        public float b;
        public int c;

        public void a() {
            this.a = -1;
            this.b = 0.0f;
            this.c = 0;
        }
    }

    public f(ViewPager2 viewPager2) {
        this.b = viewPager2;
        RecyclerView recyclerView = viewPager2.f305k;
        this.c = recyclerView;
        this.f983d = (LinearLayoutManager) recyclerView.getLayoutManager();
        e();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public void a(RecyclerView recyclerView, int i2) {
        ViewPager2.e eVar;
        int i3 = this.f984e;
        boolean z = true;
        if (!(i3 == 1 && this.f985f == 1) && i2 == 1) {
            this.m = false;
            this.f984e = 1;
            int i4 = this.f988i;
            if (i4 != -1) {
                this.f987h = i4;
                this.f988i = -1;
            } else if (this.f987h == -1) {
                this.f987h = this.f983d.m1();
            }
            d(1);
            return;
        }
        if (!(i3 == 1 || i3 == 4) || i2 != 2) {
            if ((i3 == 1 || i3 == 4) && i2 == 0) {
                f();
                if (!this.f990k) {
                    int i5 = this.f986g.a;
                    if (!(i5 == -1 || (eVar = this.a) == null)) {
                        eVar.b(i5, 0.0f, 0);
                    }
                } else {
                    a aVar = this.f986g;
                    if (aVar.c == 0) {
                        int i6 = this.f987h;
                        int i7 = aVar.a;
                        if (i6 != i7) {
                            c(i7);
                        }
                    } else {
                        z = false;
                    }
                }
                if (z) {
                    d(0);
                    e();
                }
            }
            if (this.f984e == 2 && i2 == 0 && this.f991l) {
                f();
                a aVar2 = this.f986g;
                if (aVar2.c == 0) {
                    int i8 = this.f988i;
                    int i9 = aVar2.a;
                    if (i8 != i9) {
                        if (i9 == -1) {
                            i9 = 0;
                        }
                        c(i9);
                    }
                    d(0);
                    e();
                }
            }
        } else if (this.f990k) {
            d(2);
            this.f989j = true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0037, code lost:
        if (r4.f987h != r6) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        if ((r6 < 0) == r4.b.a()) goto L_0x0022;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0057  */
    @Override // androidx.recyclerview.widget.RecyclerView.r
    public void b(RecyclerView recyclerView, int i2, int i3) {
        int i4;
        ViewPager2.e eVar;
        int i5;
        int i6;
        int i7;
        boolean z;
        this.f990k = true;
        f();
        if (this.f989j) {
            this.f989j = false;
            if (i3 <= 0) {
                if (i3 == 0) {
                }
                z = false;
                if (z) {
                    a aVar = this.f986g;
                    if (aVar.c != 0) {
                        i7 = aVar.a + 1;
                        this.f988i = i7;
                    }
                }
                i7 = this.f986g.a;
                this.f988i = i7;
            }
            z = true;
            if (z) {
            }
            i7 = this.f986g.a;
            this.f988i = i7;
        } else {
            if (this.f984e == 0) {
                i7 = this.f986g.a;
                if (i7 == -1) {
                    i7 = 0;
                }
            }
            a aVar2 = this.f986g;
            i4 = aVar2.a;
            if (i4 == -1) {
                i4 = 0;
            }
            float f2 = aVar2.b;
            int i8 = aVar2.c;
            eVar = this.a;
            if (eVar != null) {
                eVar.b(i4, f2, i8);
            }
            a aVar3 = this.f986g;
            i5 = aVar3.a;
            i6 = this.f988i;
            if ((i5 != i6 || i6 == -1) && aVar3.c == 0 && this.f985f != 1) {
                d(0);
                e();
            }
            return;
        }
        c(i7);
        a aVar22 = this.f986g;
        i4 = aVar22.a;
        if (i4 == -1) {
        }
        float f22 = aVar22.b;
        int i82 = aVar22.c;
        eVar = this.a;
        if (eVar != null) {
        }
        a aVar32 = this.f986g;
        i5 = aVar32.a;
        i6 = this.f988i;
        if (i5 != i6) {
        }
        d(0);
        e();
    }

    public final void c(int i2) {
        ViewPager2.e eVar = this.a;
        if (eVar != null) {
            eVar.c(i2);
        }
    }

    public final void d(int i2) {
        if ((this.f984e != 3 || this.f985f != 0) && this.f985f != i2) {
            this.f985f = i2;
            ViewPager2.e eVar = this.a;
            if (eVar != null) {
                eVar.a(i2);
            }
        }
    }

    public final void e() {
        this.f984e = 0;
        this.f985f = 0;
        this.f986g.a();
        this.f987h = -1;
        this.f988i = -1;
        this.f989j = false;
        this.f990k = false;
        this.m = false;
        this.f991l = false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0151, code lost:
        if (r4[r2 - 1][1] >= r3) goto L_0x0154;
     */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x017e  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x017b A[SYNTHETIC] */
    public final void f() {
        int i2;
        boolean z;
        boolean z2;
        int z3;
        int i3;
        boolean z4;
        int i4;
        int i5;
        int i6;
        int i7;
        a aVar = this.f986g;
        int m1 = this.f983d.m1();
        aVar.a = m1;
        if (m1 == -1) {
            aVar.a();
            return;
        }
        View u = this.f983d.u(m1);
        if (u == null) {
            aVar.a();
            return;
        }
        Objects.requireNonNull(this.f983d);
        int i8 = ((RecyclerView.n) u.getLayoutParams()).b.left;
        Objects.requireNonNull(this.f983d);
        int i9 = ((RecyclerView.n) u.getLayoutParams()).b.right;
        Objects.requireNonNull(this.f983d);
        int i10 = ((RecyclerView.n) u.getLayoutParams()).b.top;
        Objects.requireNonNull(this.f983d);
        int i11 = ((RecyclerView.n) u.getLayoutParams()).b.bottom;
        ViewGroup.LayoutParams layoutParams = u.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            i8 += marginLayoutParams.leftMargin;
            i9 += marginLayoutParams.rightMargin;
            i10 += marginLayoutParams.topMargin;
            i11 += marginLayoutParams.bottomMargin;
        }
        int height = u.getHeight() + i10 + i11;
        int width = u.getWidth() + i8 + i9;
        if (this.f983d.r == 0) {
            i2 = (u.getLeft() - i8) - this.c.getPaddingLeft();
            if (this.b.a()) {
                i2 = -i2;
            }
            height = width;
        } else {
            i2 = (u.getTop() - i10) - this.c.getPaddingTop();
        }
        int i12 = -i2;
        aVar.c = i12;
        if (i12 < 0) {
            LinearLayoutManager linearLayoutManager = this.f983d;
            b bVar = new b(linearLayoutManager);
            int z5 = linearLayoutManager.z();
            if (z5 != 0) {
                boolean z6 = bVar.a.r == 0;
                int[] iArr = new int[2];
                iArr[1] = 2;
                iArr[0] = z5;
                int[][] iArr2 = (int[][]) Array.newInstance(int.class, iArr);
                for (int i13 = 0; i13 < z5; i13++) {
                    View y = bVar.a.y(i13);
                    if (y != null) {
                        ViewGroup.LayoutParams layoutParams2 = y.getLayoutParams();
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : b.b;
                        int[] iArr3 = iArr2[i13];
                        if (z6) {
                            i5 = y.getLeft();
                            i4 = marginLayoutParams2.leftMargin;
                        } else {
                            i5 = y.getTop();
                            i4 = marginLayoutParams2.topMargin;
                        }
                        iArr3[0] = i5 - i4;
                        int[] iArr4 = iArr2[i13];
                        if (z6) {
                            i7 = y.getRight();
                            i6 = marginLayoutParams2.rightMargin;
                        } else {
                            i7 = y.getBottom();
                            i6 = marginLayoutParams2.bottomMargin;
                        }
                        iArr4[1] = i7 + i6;
                    } else {
                        throw new IllegalStateException("null view contained in the view hierarchy");
                    }
                }
                Arrays.sort(iArr2, new a(bVar));
                int i14 = 1;
                while (true) {
                    if (i14 >= z5) {
                        int i15 = iArr2[0][1] - iArr2[0][0];
                        if (iArr2[0][0] <= 0) {
                        }
                    } else if (iArr2[i14 - 1][1] != iArr2[i14][0]) {
                        break;
                    } else {
                        i14++;
                    }
                }
                z = false;
                if (!z || bVar.a.z() <= 1) {
                    z3 = bVar.a.z();
                    i3 = 0;
                    while (true) {
                        if (i3 < z3) {
                            z4 = false;
                            break;
                        } else if (b.a(bVar.a.y(i3))) {
                            z4 = true;
                            break;
                        } else {
                            i3++;
                        }
                    }
                    if (z4) {
                        z2 = true;
                        if (z2) {
                            throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
                        }
                        throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", Integer.valueOf(aVar.c)));
                    }
                }
                z2 = false;
                if (z2) {
                }
            }
            z = true;
            z3 = bVar.a.z();
            i3 = 0;
            while (true) {
                if (i3 < z3) {
                }
                i3++;
            }
            if (z4) {
            }
            z2 = false;
            if (z2) {
            }
        } else {
            aVar.b = height == 0 ? 0.0f : ((float) i12) / ((float) height);
        }
    }
}
