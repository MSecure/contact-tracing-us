package b.l.d;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import b.l.d.q;
import b.l.d.z;
import b.n.f;
import java.io.PrintWriter;
import java.util.ArrayList;

public final class a extends z implements q.e {
    public final q r;
    public boolean s;
    public int t;

    /* JADX WARNING: Illegal instructions before constructor call */
    public a(q qVar) {
        super(r0, r1 != null ? r1.f1321c.getClassLoader() : null);
        m N = qVar.N();
        n<?> nVar = qVar.n;
        this.t = -1;
        this.r = qVar;
    }

    public static boolean s(z.a aVar) {
        Fragment fragment = aVar.f1371b;
        return fragment != null && fragment.mAdded && fragment.mView != null && !fragment.mDetached && !fragment.mHidden && fragment.isPostponed();
    }

    @Override // b.l.d.q.e
    public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (q.P(2)) {
            String str = "Run: " + this;
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.g) {
            return true;
        }
        q qVar = this.r;
        if (qVar.f1331d == null) {
            qVar.f1331d = new ArrayList<>();
        }
        qVar.f1331d.add(this);
        return true;
    }

    @Override // b.l.d.z
    public int d() {
        return m(false);
    }

    @Override // b.l.d.z
    public void e() {
        if (!this.g) {
            this.h = false;
            this.r.E(this, false);
            return;
        }
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }

    @Override // b.l.d.z
    public void f() {
        if (!this.g) {
            this.h = false;
            this.r.E(this, true);
            return;
        }
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }

    @Override // b.l.d.z
    public void g(int i, Fragment fragment, String str, int i2) {
        super.g(i, fragment, str, i2);
        fragment.mFragmentManager = this.r;
    }

    @Override // b.l.d.z
    public z h(Fragment fragment) {
        q qVar = fragment.mFragmentManager;
        if (qVar == null || qVar == this.r) {
            b(new z.a(3, fragment));
            return this;
        }
        StringBuilder g = c.a.a.a.a.g("Cannot remove Fragment attached to a different FragmentManager. Fragment ");
        g.append(fragment.toString());
        g.append(" is already attached to a FragmentManager.");
        throw new IllegalStateException(g.toString());
    }

    @Override // b.l.d.z
    public z j(Fragment fragment, f.b bVar) {
        f.b bVar2 = f.b.CREATED;
        if (fragment.mFragmentManager == this.r) {
            if (bVar.compareTo(bVar2) >= 0) {
                super.j(fragment, bVar);
                return this;
            }
            throw new IllegalArgumentException("Cannot set maximum Lifecycle below " + bVar2);
        }
        StringBuilder g = c.a.a.a.a.g("Cannot setMaxLifecycle for Fragment not attached to FragmentManager ");
        g.append(this.r);
        throw new IllegalArgumentException(g.toString());
    }

    public void l(int i) {
        if (this.g) {
            if (q.P(2)) {
                String str = "Bump nesting in " + this + " by " + i;
            }
            int size = this.f1365a.size();
            for (int i2 = 0; i2 < size; i2++) {
                z.a aVar = this.f1365a.get(i2);
                Fragment fragment = aVar.f1371b;
                if (fragment != null) {
                    fragment.mBackStackNesting += i;
                    if (q.P(2)) {
                        StringBuilder g = c.a.a.a.a.g("Bump nesting of ");
                        g.append(aVar.f1371b);
                        g.append(" to ");
                        g.append(aVar.f1371b.mBackStackNesting);
                        g.toString();
                    }
                }
            }
        }
    }

    public int m(boolean z) {
        if (!this.s) {
            if (q.P(2)) {
                String str = "Commit: " + this;
                PrintWriter printWriter = new PrintWriter(new b.i.k.a("FragmentManager"));
                n("  ", printWriter, true);
                printWriter.close();
            }
            this.s = true;
            this.t = this.g ? this.r.i.getAndIncrement() : -1;
            this.r.B(this, z);
            return this.t;
        }
        throw new IllegalStateException("commit already called");
    }

    public void n(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.i);
            printWriter.print(" mIndex=");
            printWriter.print(this.t);
            printWriter.print(" mCommitted=");
            printWriter.println(this.s);
            if (this.f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f));
            }
            if (!(this.f1366b == 0 && this.f1367c == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1366b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1367c));
            }
            if (!(this.f1368d == 0 && this.f1369e == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1368d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1369e));
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
        if (!this.f1365a.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            int size = this.f1365a.size();
            for (int i = 0; i < size; i++) {
                z.a aVar = this.f1365a.get(i);
                switch (aVar.f1370a) {
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
                        StringBuilder g = c.a.a.a.a.g("cmd=");
                        g.append(aVar.f1370a);
                        str2 = g.toString();
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(aVar.f1371b);
                if (z) {
                    if (!(aVar.f1372c == 0 && aVar.f1373d == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f1372c));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f1373d));
                    }
                    if (aVar.f1374e != 0 || aVar.f != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f1374e));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f));
                    }
                }
            }
        }
    }

    public void o() {
        int size = this.f1365a.size();
        for (int i = 0; i < size; i++) {
            z.a aVar = this.f1365a.get(i);
            Fragment fragment = aVar.f1371b;
            if (fragment != null) {
                fragment.setNextTransition(this.f);
            }
            switch (aVar.f1370a) {
                case 1:
                    fragment.setNextAnim(aVar.f1372c);
                    this.r.k0(fragment, false);
                    this.r.b(fragment);
                    break;
                case 2:
                default:
                    StringBuilder g = c.a.a.a.a.g("Unknown cmd: ");
                    g.append(aVar.f1370a);
                    throw new IllegalArgumentException(g.toString());
                case 3:
                    fragment.setNextAnim(aVar.f1373d);
                    this.r.e0(fragment);
                    break;
                case 4:
                    fragment.setNextAnim(aVar.f1373d);
                    this.r.O(fragment);
                    break;
                case 5:
                    fragment.setNextAnim(aVar.f1372c);
                    this.r.k0(fragment, false);
                    this.r.o0(fragment);
                    break;
                case 6:
                    fragment.setNextAnim(aVar.f1373d);
                    this.r.k(fragment);
                    break;
                case 7:
                    fragment.setNextAnim(aVar.f1372c);
                    this.r.k0(fragment, false);
                    this.r.e(fragment);
                    break;
                case 8:
                    this.r.m0(fragment);
                    break;
                case 9:
                    this.r.m0(null);
                    break;
                case 10:
                    this.r.l0(fragment, aVar.h);
                    break;
            }
            if (!(this.p || aVar.f1370a == 1 || fragment == null)) {
                this.r.U(fragment);
            }
        }
        if (!this.p) {
            q qVar = this.r;
            qVar.V(qVar.m, true);
        }
    }

    public void p(boolean z) {
        for (int size = this.f1365a.size() - 1; size >= 0; size--) {
            z.a aVar = this.f1365a.get(size);
            Fragment fragment = aVar.f1371b;
            if (fragment != null) {
                int i = this.f;
                int i2 = 8194;
                if (i != 4097) {
                    i2 = i != 4099 ? i != 8194 ? 0 : 4097 : 4099;
                }
                fragment.setNextTransition(i2);
            }
            switch (aVar.f1370a) {
                case 1:
                    fragment.setNextAnim(aVar.f);
                    this.r.k0(fragment, true);
                    this.r.e0(fragment);
                    break;
                case 2:
                default:
                    StringBuilder g = c.a.a.a.a.g("Unknown cmd: ");
                    g.append(aVar.f1370a);
                    throw new IllegalArgumentException(g.toString());
                case 3:
                    fragment.setNextAnim(aVar.f1374e);
                    this.r.b(fragment);
                    break;
                case 4:
                    fragment.setNextAnim(aVar.f1374e);
                    this.r.o0(fragment);
                    break;
                case 5:
                    fragment.setNextAnim(aVar.f);
                    this.r.k0(fragment, true);
                    this.r.O(fragment);
                    break;
                case 6:
                    fragment.setNextAnim(aVar.f1374e);
                    this.r.e(fragment);
                    break;
                case 7:
                    fragment.setNextAnim(aVar.f);
                    this.r.k0(fragment, true);
                    this.r.k(fragment);
                    break;
                case 8:
                    this.r.m0(null);
                    break;
                case 9:
                    this.r.m0(fragment);
                    break;
                case 10:
                    this.r.l0(fragment, aVar.g);
                    break;
            }
            if (!(this.p || aVar.f1370a == 3 || fragment == null)) {
                this.r.U(fragment);
            }
        }
        if (!this.p && z) {
            q qVar = this.r;
            qVar.V(qVar.m, true);
        }
    }

    public boolean q(int i) {
        int size = this.f1365a.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragment = this.f1365a.get(i2).f1371b;
            int i3 = fragment != null ? fragment.mContainerId : 0;
            if (i3 != 0 && i3 == i) {
                return true;
            }
        }
        return false;
    }

    public boolean r(ArrayList<a> arrayList, int i, int i2) {
        if (i2 == i) {
            return false;
        }
        int size = this.f1365a.size();
        int i3 = -1;
        for (int i4 = 0; i4 < size; i4++) {
            Fragment fragment = this.f1365a.get(i4).f1371b;
            int i5 = fragment != null ? fragment.mContainerId : 0;
            if (!(i5 == 0 || i5 == i3)) {
                for (int i6 = i; i6 < i2; i6++) {
                    a aVar = arrayList.get(i6);
                    int size2 = aVar.f1365a.size();
                    for (int i7 = 0; i7 < size2; i7++) {
                        Fragment fragment2 = aVar.f1365a.get(i7).f1371b;
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
        StringBuilder sb = new StringBuilder((int) RecyclerView.d0.FLAG_IGNORE);
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
