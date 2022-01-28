package b.r.d;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public final b f2332a;

    /* renamed from: b  reason: collision with root package name */
    public final a f2333b = new a();

    /* renamed from: c  reason: collision with root package name */
    public final List<View> f2334c = new ArrayList();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f2335a = 0;

        /* renamed from: b  reason: collision with root package name */
        public a f2336b;

        public void a(int i) {
            if (i >= 64) {
                a aVar = this.f2336b;
                if (aVar != null) {
                    aVar.a(i - 64);
                    return;
                }
                return;
            }
            this.f2335a &= ~(1 << i);
        }

        public int b(int i) {
            long j;
            a aVar = this.f2336b;
            if (aVar == null) {
                if (i >= 64) {
                    j = this.f2335a;
                }
                j = this.f2335a & ((1 << i) - 1);
            } else {
                if (i >= 64) {
                    return Long.bitCount(this.f2335a) + aVar.b(i - 64);
                }
                j = this.f2335a & ((1 << i) - 1);
            }
            return Long.bitCount(j);
        }

        public final void c() {
            if (this.f2336b == null) {
                this.f2336b = new a();
            }
        }

        public boolean d(int i) {
            if (i < 64) {
                return (this.f2335a & (1 << i)) != 0;
            }
            c();
            return this.f2336b.d(i - 64);
        }

        public void e(int i, boolean z) {
            if (i >= 64) {
                c();
                this.f2336b.e(i - 64, z);
                return;
            }
            boolean z2 = (this.f2335a & Long.MIN_VALUE) != 0;
            long j = (1 << i) - 1;
            long j2 = this.f2335a;
            this.f2335a = ((j2 & (~j)) << 1) | (j2 & j);
            if (z) {
                h(i);
            } else {
                a(i);
            }
            if (z2 || this.f2336b != null) {
                c();
                this.f2336b.e(0, z2);
            }
        }

        public boolean f(int i) {
            if (i >= 64) {
                c();
                return this.f2336b.f(i - 64);
            }
            long j = 1 << i;
            boolean z = (this.f2335a & j) != 0;
            long j2 = this.f2335a & (~j);
            this.f2335a = j2;
            long j3 = j - 1;
            this.f2335a = (j2 & j3) | Long.rotateRight((~j3) & j2, 1);
            a aVar = this.f2336b;
            if (aVar != null) {
                if (aVar.d(0)) {
                    h(63);
                }
                this.f2336b.f(0);
            }
            return z;
        }

        public void g() {
            this.f2335a = 0;
            a aVar = this.f2336b;
            if (aVar != null) {
                aVar.g();
            }
        }

        public void h(int i) {
            if (i >= 64) {
                c();
                this.f2336b.h(i - 64);
                return;
            }
            this.f2335a |= 1 << i;
        }

        public String toString() {
            if (this.f2336b == null) {
                return Long.toBinaryString(this.f2335a);
            }
            return this.f2336b.toString() + "xx" + Long.toBinaryString(this.f2335a);
        }
    }

    public interface b {
    }

    public f(b bVar) {
        this.f2332a = bVar;
    }

    public void a(View view, int i, boolean z) {
        int b2 = i < 0 ? ((b0) this.f2332a).b() : f(i);
        this.f2333b.e(b2, z);
        if (z) {
            i(view);
        }
        b0 b0Var = (b0) this.f2332a;
        b0Var.f2297a.addView(view, b2);
        RecyclerView recyclerView = b0Var.f2297a;
        if (recyclerView != null) {
            RecyclerView.a0 K = RecyclerView.K(view);
            recyclerView.T();
            RecyclerView.e eVar = recyclerView.m;
            if (eVar != null && K != null) {
                eVar.onViewAttachedToWindow(K);
                return;
            }
            return;
        }
        throw null;
    }

    public void b(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int b2 = i < 0 ? ((b0) this.f2332a).b() : f(i);
        this.f2333b.e(b2, z);
        if (z) {
            i(view);
        }
        b0 b0Var = (b0) this.f2332a;
        if (b0Var != null) {
            RecyclerView.a0 K = RecyclerView.K(view);
            if (K != null) {
                if (K.isTmpDetached() || K.shouldIgnore()) {
                    K.clearTmpDetachFlag();
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Called attach on a child which is not detached: ");
                    sb.append(K);
                    throw new IllegalArgumentException(c.a.a.a.a.l(b0Var.f2297a, sb));
                }
            }
            b0Var.f2297a.attachViewToParent(view, b2, layoutParams);
            return;
        }
        throw null;
    }

    public void c(int i) {
        RecyclerView.a0 K;
        int f2 = f(i);
        this.f2333b.f(f2);
        b0 b0Var = (b0) this.f2332a;
        View childAt = b0Var.f2297a.getChildAt(f2);
        if (!(childAt == null || (K = RecyclerView.K(childAt)) == null)) {
            if (!K.isTmpDetached() || K.shouldIgnore()) {
                K.addFlags(RecyclerView.a0.FLAG_TMP_DETACHED);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("called detach on an already detached child ");
                sb.append(K);
                throw new IllegalArgumentException(c.a.a.a.a.l(b0Var.f2297a, sb));
            }
        }
        b0Var.f2297a.detachViewFromParent((RecyclerView) f2);
    }

    public View d(int i) {
        return ((b0) this.f2332a).a(f(i));
    }

    public int e() {
        return ((b0) this.f2332a).b() - this.f2334c.size();
    }

    public final int f(int i) {
        if (i < 0) {
            return -1;
        }
        int b2 = ((b0) this.f2332a).b();
        int i2 = i;
        while (i2 < b2) {
            int b3 = i - (i2 - this.f2333b.b(i2));
            if (b3 == 0) {
                while (this.f2333b.d(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += b3;
        }
        return -1;
    }

    public View g(int i) {
        return ((b0) this.f2332a).f2297a.getChildAt(i);
    }

    public int h() {
        return ((b0) this.f2332a).b();
    }

    public final void i(View view) {
        this.f2334c.add(view);
        b0 b0Var = (b0) this.f2332a;
        if (b0Var != null) {
            RecyclerView.a0 K = RecyclerView.K(view);
            if (K != null) {
                K.onEnteredHiddenState(b0Var.f2297a);
                return;
            }
            return;
        }
        throw null;
    }

    public int j(View view) {
        int indexOfChild = ((b0) this.f2332a).f2297a.indexOfChild(view);
        if (indexOfChild != -1 && !this.f2333b.d(indexOfChild)) {
            return indexOfChild - this.f2333b.b(indexOfChild);
        }
        return -1;
    }

    public boolean k(View view) {
        return this.f2334c.contains(view);
    }

    public final boolean l(View view) {
        if (!this.f2334c.remove(view)) {
            return false;
        }
        b0 b0Var = (b0) this.f2332a;
        if (b0Var != null) {
            RecyclerView.a0 K = RecyclerView.K(view);
            if (K == null) {
                return true;
            }
            K.onLeftHiddenState(b0Var.f2297a);
            return true;
        }
        throw null;
    }

    public String toString() {
        return this.f2333b.toString() + ", hidden list:" + this.f2334c.size();
    }
}
