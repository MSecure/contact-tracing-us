package b.q.d;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public final b f1491a;

    /* renamed from: b  reason: collision with root package name */
    public final a f1492b = new a();

    /* renamed from: c  reason: collision with root package name */
    public final List<View> f1493c = new ArrayList();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f1494a = 0;

        /* renamed from: b  reason: collision with root package name */
        public a f1495b;

        public void a(int i) {
            if (i >= 64) {
                a aVar = this.f1495b;
                if (aVar != null) {
                    aVar.a(i - 64);
                    return;
                }
                return;
            }
            this.f1494a &= ~(1 << i);
        }

        public int b(int i) {
            long j;
            a aVar = this.f1495b;
            if (aVar == null) {
                if (i >= 64) {
                    j = this.f1494a;
                }
                j = this.f1494a & ((1 << i) - 1);
            } else {
                if (i >= 64) {
                    return Long.bitCount(this.f1494a) + aVar.b(i - 64);
                }
                j = this.f1494a & ((1 << i) - 1);
            }
            return Long.bitCount(j);
        }

        public final void c() {
            if (this.f1495b == null) {
                this.f1495b = new a();
            }
        }

        public boolean d(int i) {
            if (i < 64) {
                return (this.f1494a & (1 << i)) != 0;
            }
            c();
            return this.f1495b.d(i - 64);
        }

        public void e(int i, boolean z) {
            if (i >= 64) {
                c();
                this.f1495b.e(i - 64, z);
                return;
            }
            boolean z2 = (this.f1494a & Long.MIN_VALUE) != 0;
            long j = (1 << i) - 1;
            long j2 = this.f1494a;
            this.f1494a = ((j2 & (~j)) << 1) | (j2 & j);
            if (z) {
                h(i);
            } else {
                a(i);
            }
            if (z2 || this.f1495b != null) {
                c();
                this.f1495b.e(0, z2);
            }
        }

        public boolean f(int i) {
            if (i >= 64) {
                c();
                return this.f1495b.f(i - 64);
            }
            long j = 1 << i;
            boolean z = (this.f1494a & j) != 0;
            long j2 = this.f1494a & (~j);
            this.f1494a = j2;
            long j3 = j - 1;
            this.f1494a = (j2 & j3) | Long.rotateRight((~j3) & j2, 1);
            a aVar = this.f1495b;
            if (aVar != null) {
                if (aVar.d(0)) {
                    h(63);
                }
                this.f1495b.f(0);
            }
            return z;
        }

        public void g() {
            this.f1494a = 0;
            a aVar = this.f1495b;
            if (aVar != null) {
                aVar.g();
            }
        }

        public void h(int i) {
            if (i >= 64) {
                c();
                this.f1495b.h(i - 64);
                return;
            }
            this.f1494a |= 1 << i;
        }

        public String toString() {
            if (this.f1495b == null) {
                return Long.toBinaryString(this.f1494a);
            }
            return this.f1495b.toString() + "xx" + Long.toBinaryString(this.f1494a);
        }
    }

    public interface b {
    }

    public f(b bVar) {
        this.f1491a = bVar;
    }

    public void a(View view, int i, boolean z) {
        int b2 = i < 0 ? ((RecyclerView.e) this.f1491a).b() : f(i);
        this.f1492b.e(b2, z);
        if (z) {
            i(view);
        }
        RecyclerView.e eVar = (RecyclerView.e) this.f1491a;
        RecyclerView.this.addView(view, b2);
        RecyclerView.this.dispatchChildAttached(view);
    }

    public void b(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int b2 = i < 0 ? ((RecyclerView.e) this.f1491a).b() : f(i);
        this.f1492b.e(b2, z);
        if (z) {
            i(view);
        }
        RecyclerView.e eVar = (RecyclerView.e) this.f1491a;
        if (eVar != null) {
            RecyclerView.d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                if (childViewHolderInt.isTmpDetached() || childViewHolderInt.shouldIgnore()) {
                    childViewHolderInt.clearTmpDetachFlag();
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Called attach on a child which is not detached: ");
                    sb.append(childViewHolderInt);
                    throw new IllegalArgumentException(c.a.a.a.a.j(RecyclerView.this, sb));
                }
            }
            RecyclerView.this.attachViewToParent(view, b2, layoutParams);
            return;
        }
        throw null;
    }

    public void c(int i) {
        RecyclerView.d0 childViewHolderInt;
        int f = f(i);
        this.f1492b.f(f);
        RecyclerView.e eVar = (RecyclerView.e) this.f1491a;
        View childAt = RecyclerView.this.getChildAt(f);
        if (!(childAt == null || (childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt)) == null)) {
            if (!childViewHolderInt.isTmpDetached() || childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.addFlags(RecyclerView.d0.FLAG_TMP_DETACHED);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("called detach on an already detached child ");
                sb.append(childViewHolderInt);
                throw new IllegalArgumentException(c.a.a.a.a.j(RecyclerView.this, sb));
            }
        }
        RecyclerView.this.detachViewFromParent((RecyclerView) f);
    }

    public View d(int i) {
        return ((RecyclerView.e) this.f1491a).a(f(i));
    }

    public int e() {
        return ((RecyclerView.e) this.f1491a).b() - this.f1493c.size();
    }

    public final int f(int i) {
        if (i < 0) {
            return -1;
        }
        int b2 = ((RecyclerView.e) this.f1491a).b();
        int i2 = i;
        while (i2 < b2) {
            int b3 = i - (i2 - this.f1492b.b(i2));
            if (b3 == 0) {
                while (this.f1492b.d(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += b3;
        }
        return -1;
    }

    public View g(int i) {
        return RecyclerView.this.getChildAt(i);
    }

    public int h() {
        return ((RecyclerView.e) this.f1491a).b();
    }

    public final void i(View view) {
        this.f1493c.add(view);
        RecyclerView.e eVar = (RecyclerView.e) this.f1491a;
        if (eVar != null) {
            RecyclerView.d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                childViewHolderInt.onEnteredHiddenState(RecyclerView.this);
                return;
            }
            return;
        }
        throw null;
    }

    public int j(View view) {
        int indexOfChild = RecyclerView.this.indexOfChild(view);
        if (indexOfChild != -1 && !this.f1492b.d(indexOfChild)) {
            return indexOfChild - this.f1492b.b(indexOfChild);
        }
        return -1;
    }

    public boolean k(View view) {
        return this.f1493c.contains(view);
    }

    public final boolean l(View view) {
        if (!this.f1493c.remove(view)) {
            return false;
        }
        RecyclerView.e eVar = (RecyclerView.e) this.f1491a;
        if (eVar != null) {
            RecyclerView.d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt == null) {
                return true;
            }
            childViewHolderInt.onLeftHiddenState(RecyclerView.this);
            return true;
        }
        throw null;
    }

    public String toString() {
        return this.f1492b.toString() + ", hidden list:" + this.f1493c.size();
    }
}
