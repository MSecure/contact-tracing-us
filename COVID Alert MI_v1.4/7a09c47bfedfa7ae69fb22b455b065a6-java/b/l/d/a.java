package b.l.d;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import b.l.d.i0;
import b.l.d.z;
import b.o.f;
import java.io.PrintWriter;
import java.util.ArrayList;

public final class a extends i0 implements z.l {
    public final z r;
    public boolean s;
    public int t;

    /* JADX WARNING: Illegal instructions before constructor call */
    public a(z zVar) {
        super(r0, r1 != null ? r1.f2143c.getClassLoader() : null);
        v M = zVar.M();
        w<?> wVar = zVar.q;
        this.t = -1;
        this.r = zVar;
    }

    @Override // b.l.d.z.l
    public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (z.P(2)) {
            String str = "Run: " + this;
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f2041g) {
            return true;
        }
        z zVar = this.r;
        if (zVar.f2181d == null) {
            zVar.f2181d = new ArrayList<>();
        }
        zVar.f2181d.add(this);
        return true;
    }

    @Override // b.l.d.i0
    public int d() {
        return l(false);
    }

    @Override // b.l.d.i0
    public void e() {
        if (!this.f2041g) {
            this.h = false;
            this.r.E(this, false);
            return;
        }
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }

    @Override // b.l.d.i0
    public void f() {
        if (!this.f2041g) {
            this.h = false;
            this.r.E(this, true);
            return;
        }
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }

    @Override // b.l.d.i0
    public void g(int i, Fragment fragment, String str, int i2) {
        super.g(i, fragment, str, i2);
        fragment.mFragmentManager = this.r;
    }

    @Override // b.l.d.i0
    public i0 i(Fragment fragment, f.b bVar) {
        if (fragment.mFragmentManager != this.r) {
            StringBuilder h = c.a.a.a.a.h("Cannot setMaxLifecycle for Fragment not attached to FragmentManager ");
            h.append(this.r);
            throw new IllegalArgumentException(h.toString());
        } else if (bVar == f.b.INITIALIZED && fragment.mState > -1) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + bVar + " after the Fragment has been created");
        } else if (bVar != f.b.DESTROYED) {
            super.i(fragment, bVar);
            return this;
        } else {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + bVar + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
        }
    }

    public void k(int i) {
        if (this.f2041g) {
            if (z.P(2)) {
                String str = "Bump nesting in " + this + " by " + i;
            }
            int size = this.f2035a.size();
            for (int i2 = 0; i2 < size; i2++) {
                i0.a aVar = this.f2035a.get(i2);
                Fragment fragment = aVar.f2043b;
                if (fragment != null) {
                    fragment.mBackStackNesting += i;
                    if (z.P(2)) {
                        StringBuilder h = c.a.a.a.a.h("Bump nesting of ");
                        h.append(aVar.f2043b);
                        h.append(" to ");
                        h.append(aVar.f2043b.mBackStackNesting);
                        h.toString();
                    }
                }
            }
        }
    }

    public int l(boolean z) {
        if (!this.s) {
            if (z.P(2)) {
                String str = "Commit: " + this;
                PrintWriter printWriter = new PrintWriter(new v0("FragmentManager"));
                m("  ", printWriter, true);
                printWriter.close();
            }
            this.s = true;
            this.t = this.f2041g ? this.r.i.getAndIncrement() : -1;
            this.r.B(this, z);
            return this.t;
        }
        throw new IllegalStateException("commit already called");
    }

    public void m(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.i);
            printWriter.print(" mIndex=");
            printWriter.print(this.t);
            printWriter.print(" mCommitted=");
            printWriter.println(this.s);
            if (this.f2040f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f2040f));
            }
            if (!(this.f2036b == 0 && this.f2037c == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f2036b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f2037c));
            }
            if (!(this.f2038d == 0 && this.f2039e == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f2038d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f2039e));
            }
            if (!(this.j == 0 && this.k == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.j));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.k);
            }
            if (!(this.l == 0 && this.m == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.l));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.m);
            }
        }
        if (!this.f2035a.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            int size = this.f2035a.size();
            for (int i = 0; i < size; i++) {
                i0.a aVar = this.f2035a.get(i);
                switch (aVar.f2042a) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    case 10:
                        str2 = "OP_SET_MAX_LIFECYCLE";
                        break;
                    default:
                        StringBuilder h = c.a.a.a.a.h("cmd=");
                        h.append(aVar.f2042a);
                        str2 = h.toString();
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(aVar.f2043b);
                if (z) {
                    if (!(aVar.f2044c == 0 && aVar.f2045d == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f2044c));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f2045d));
                    }
                    if (aVar.f2046e != 0 || aVar.f2047f != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f2046e));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f2047f));
                    }
                }
            }
        }
    }

    public void n() {
        int size = this.f2035a.size();
        for (int i = 0; i < size; i++) {
            i0.a aVar = this.f2035a.get(i);
            Fragment fragment = aVar.f2043b;
            if (fragment != null) {
                fragment.setPopDirection(false);
                fragment.setAnimations(aVar.f2044c, aVar.f2045d, aVar.f2046e, aVar.f2047f);
                fragment.setNextTransition(this.f2040f);
                fragment.setSharedElementNames(this.n, this.o);
            }
            switch (aVar.f2042a) {
                case 1:
                    this.r.i0(fragment, false);
                    this.r.a(fragment);
                    break;
                case 2:
                default:
                    StringBuilder h = c.a.a.a.a.h("Unknown cmd: ");
                    h.append(aVar.f2042a);
                    throw new IllegalArgumentException(h.toString());
                case 3:
                    this.r.d0(fragment);
                    break;
                case 4:
                    this.r.O(fragment);
                    break;
                case 5:
                    this.r.i0(fragment, false);
                    this.r.m0(fragment);
                    break;
                case 6:
                    this.r.k(fragment);
                    break;
                case 7:
                    this.r.i0(fragment, false);
                    this.r.c(fragment);
                    break;
                case 8:
                    this.r.k0(fragment);
                    break;
                case 9:
                    this.r.k0(null);
                    break;
                case 10:
                    this.r.j0(fragment, aVar.h);
                    break;
            }
            if (!this.p) {
                int i2 = aVar.f2042a;
            }
        }
    }

    public void o(boolean z) {
        for (int size = this.f2035a.size() - 1; size >= 0; size--) {
            i0.a aVar = this.f2035a.get(size);
            Fragment fragment = aVar.f2043b;
            if (fragment != null) {
                fragment.setPopDirection(true);
                fragment.setAnimations(aVar.f2044c, aVar.f2045d, aVar.f2046e, aVar.f2047f);
                int i = this.f2040f;
                int i2 = 8194;
                if (i != 4097) {
                    i2 = i != 4099 ? i != 8194 ? 0 : 4097 : 4099;
                }
                fragment.setNextTransition(i2);
                fragment.setSharedElementNames(this.o, this.n);
            }
            switch (aVar.f2042a) {
                case 1:
                    this.r.i0(fragment, true);
                    this.r.d0(fragment);
                    break;
                case 2:
                default:
                    StringBuilder h = c.a.a.a.a.h("Unknown cmd: ");
                    h.append(aVar.f2042a);
                    throw new IllegalArgumentException(h.toString());
                case 3:
                    this.r.a(fragment);
                    break;
                case 4:
                    this.r.m0(fragment);
                    break;
                case 5:
                    this.r.i0(fragment, true);
                    this.r.O(fragment);
                    break;
                case 6:
                    this.r.c(fragment);
                    break;
                case 7:
                    this.r.i0(fragment, true);
                    this.r.k(fragment);
                    break;
                case 8:
                    this.r.k0(null);
                    break;
                case 9:
                    this.r.k0(fragment);
                    break;
                case 10:
                    this.r.j0(fragment, aVar.f2048g);
                    break;
            }
            if (!this.p) {
                int i3 = aVar.f2042a;
            }
        }
    }

    public boolean p(int i) {
        int size = this.f2035a.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragment = this.f2035a.get(i2).f2043b;
            int i3 = fragment != null ? fragment.mContainerId : 0;
            if (i3 != 0 && i3 == i) {
                return true;
            }
        }
        return false;
    }

    public boolean q(ArrayList<a> arrayList, int i, int i2) {
        if (i2 == i) {
            return false;
        }
        int size = this.f2035a.size();
        int i3 = -1;
        for (int i4 = 0; i4 < size; i4++) {
            Fragment fragment = this.f2035a.get(i4).f2043b;
            int i5 = fragment != null ? fragment.mContainerId : 0;
            if (!(i5 == 0 || i5 == i3)) {
                for (int i6 = i; i6 < i2; i6++) {
                    a aVar = arrayList.get(i6);
                    int size2 = aVar.f2035a.size();
                    for (int i7 = 0; i7 < size2; i7++) {
                        Fragment fragment2 = aVar.f2035a.get(i7).f2043b;
                        if ((fragment2 != null ? fragment2.mContainerId : 0) == i5) {
                            return true;
                        }
                    }
                }
                i3 = i5;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((int) RecyclerView.a0.FLAG_IGNORE);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.t >= 0) {
            sb.append(" #");
            sb.append(this.t);
        }
        if (this.i != null) {
            sb.append(" ");
            sb.append(this.i);
        }
        sb.append("}");
        return sb.toString();
    }
}
