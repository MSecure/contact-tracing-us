package e.o.a;

import e.o.a.e0;
import e.o.a.m;
import e.o.a.m0;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class a extends m0 implements e0.l {
    public final e0 q;
    public boolean r;
    public int s;

    /* JADX WARN: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public a(e0 e0Var) {
        super(r0, r1 != null ? r1.c.getClassLoader() : null);
        a0 M = e0Var.M();
        b0<?> b0Var = e0Var.q;
        this.s = -1;
        this.q = e0Var;
    }

    @Override // e.o.a.e0.l
    public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (e0.P(2)) {
            String str = "Run: " + this;
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f1830g) {
            return true;
        }
        e0 e0Var = this.q;
        if (e0Var.f1773d == null) {
            e0Var.f1773d = new ArrayList<>();
        }
        e0Var.f1773d.add(this);
        return true;
    }

    @Override // e.o.a.m0
    public int d() {
        return i(false);
    }

    @Override // e.o.a.m0
    public int e() {
        return i(true);
    }

    @Override // e.o.a.m0
    public void f(int i2, m mVar, String str, int i3) {
        Class<?> cls = mVar.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            StringBuilder h2 = f.a.a.a.a.h("Fragment ");
            h2.append(cls.getCanonicalName());
            h2.append(" must be a public static class to be  properly recreated from instance state.");
            throw new IllegalStateException(h2.toString());
        }
        if (str != null) {
            String str2 = mVar.y;
            if (str2 == null || str.equals(str2)) {
                mVar.y = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + mVar + ": was " + mVar.y + " now " + str);
            }
        }
        if (i2 != 0) {
            if (i2 != -1) {
                int i4 = mVar.w;
                if (i4 == 0 || i4 == i2) {
                    mVar.w = i2;
                    mVar.x = i2;
                } else {
                    throw new IllegalStateException("Can't change container ID of fragment " + mVar + ": was " + mVar.w + " now " + i2);
                }
            } else {
                throw new IllegalArgumentException("Can't add fragment " + mVar + " with tag " + str + " to container view with no id");
            }
        }
        b(new m0.a(i3, mVar));
        mVar.s = this.q;
    }

    public void h(int i2) {
        if (this.f1830g) {
            if (e0.P(2)) {
                String str = "Bump nesting in " + this + " by " + i2;
            }
            int size = this.a.size();
            for (int i3 = 0; i3 < size; i3++) {
                m0.a aVar = this.a.get(i3);
                m mVar = aVar.b;
                if (mVar != null) {
                    mVar.r += i2;
                    if (e0.P(2)) {
                        StringBuilder h2 = f.a.a.a.a.h("Bump nesting of ");
                        h2.append(aVar.b);
                        h2.append(" to ");
                        h2.append(aVar.b.r);
                        h2.toString();
                    }
                }
            }
        }
    }

    public int i(boolean z) {
        if (!this.r) {
            if (e0.P(2)) {
                String str = "Commit: " + this;
                PrintWriter printWriter = new PrintWriter(new z0("FragmentManager"));
                j("  ", printWriter, true);
                printWriter.close();
            }
            this.r = true;
            this.s = this.f1830g ? this.q.f1778i.getAndIncrement() : -1;
            this.q.A(this, z);
            return this.s;
        }
        throw new IllegalStateException("commit already called");
    }

    public void j(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f1832i);
            printWriter.print(" mIndex=");
            printWriter.print(this.s);
            printWriter.print(" mCommitted=");
            printWriter.println(this.r);
            if (this.f1829f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f1829f));
            }
            if (!(this.b == 0 && this.c == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.c));
            }
            if (!(this.f1827d == 0 && this.f1828e == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1827d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1828e));
            }
            if (!(this.f1833j == 0 && this.f1834k == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f1833j));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f1834k);
            }
            if (!(this.f1835l == 0 && this.m == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f1835l));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.m);
            }
        }
        if (!this.a.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            int size = this.a.size();
            for (int i2 = 0; i2 < size; i2++) {
                m0.a aVar = this.a.get(i2);
                switch (aVar.a) {
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
                        StringBuilder h2 = f.a.a.a.a.h("cmd=");
                        h2.append(aVar.a);
                        str2 = h2.toString();
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(aVar.b);
                if (z) {
                    if (!(aVar.c == 0 && aVar.f1836d == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.c));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f1836d));
                    }
                    if (aVar.f1837e != 0 || aVar.f1838f != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f1837e));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f1838f));
                    }
                }
            }
        }
    }

    public void k() {
        e0 e0Var;
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            m0.a aVar = this.a.get(i2);
            m mVar = aVar.b;
            if (mVar != null) {
                mVar.E0(false);
                int i3 = this.f1829f;
                if (!(mVar.I == null && i3 == 0)) {
                    mVar.f();
                    mVar.I.f1822h = i3;
                }
                ArrayList<String> arrayList = this.n;
                ArrayList<String> arrayList2 = this.o;
                mVar.f();
                m.d dVar = mVar.I;
                dVar.f1823i = arrayList;
                dVar.f1824j = arrayList2;
            }
            switch (aVar.a) {
                case 1:
                    mVar.y0(aVar.c, aVar.f1836d, aVar.f1837e, aVar.f1838f);
                    this.q.h0(mVar, false);
                    this.q.a(mVar);
                    continue;
                case 2:
                default:
                    StringBuilder h2 = f.a.a.a.a.h("Unknown cmd: ");
                    h2.append(aVar.a);
                    throw new IllegalArgumentException(h2.toString());
                case 3:
                    mVar.y0(aVar.c, aVar.f1836d, aVar.f1837e, aVar.f1838f);
                    this.q.c0(mVar);
                    continue;
                case 4:
                    mVar.y0(aVar.c, aVar.f1836d, aVar.f1837e, aVar.f1838f);
                    this.q.O(mVar);
                    continue;
                case 5:
                    mVar.y0(aVar.c, aVar.f1836d, aVar.f1837e, aVar.f1838f);
                    this.q.h0(mVar, false);
                    this.q.l0(mVar);
                    continue;
                case 6:
                    mVar.y0(aVar.c, aVar.f1836d, aVar.f1837e, aVar.f1838f);
                    this.q.j(mVar);
                    continue;
                case 7:
                    mVar.y0(aVar.c, aVar.f1836d, aVar.f1837e, aVar.f1838f);
                    this.q.h0(mVar, false);
                    this.q.c(mVar);
                    continue;
                case 8:
                    e0Var = this.q;
                    break;
                case 9:
                    e0Var = this.q;
                    mVar = null;
                    break;
                case 10:
                    this.q.i0(mVar, aVar.f1840h);
                    continue;
            }
            e0Var.j0(mVar);
        }
    }

    public void l(boolean z) {
        e0 e0Var;
        for (int size = this.a.size() - 1; size >= 0; size--) {
            m0.a aVar = this.a.get(size);
            m mVar = aVar.b;
            if (mVar != null) {
                mVar.E0(true);
                int i2 = this.f1829f;
                int i3 = 8194;
                if (i2 != 4097) {
                    i3 = i2 != 4099 ? i2 != 8194 ? 0 : 4097 : 4099;
                }
                if (!(mVar.I == null && i3 == 0)) {
                    mVar.f();
                    mVar.I.f1822h = i3;
                }
                ArrayList<String> arrayList = this.o;
                ArrayList<String> arrayList2 = this.n;
                mVar.f();
                m.d dVar = mVar.I;
                dVar.f1823i = arrayList;
                dVar.f1824j = arrayList2;
            }
            switch (aVar.a) {
                case 1:
                    mVar.y0(aVar.c, aVar.f1836d, aVar.f1837e, aVar.f1838f);
                    this.q.h0(mVar, true);
                    this.q.c0(mVar);
                    continue;
                case 2:
                default:
                    StringBuilder h2 = f.a.a.a.a.h("Unknown cmd: ");
                    h2.append(aVar.a);
                    throw new IllegalArgumentException(h2.toString());
                case 3:
                    mVar.y0(aVar.c, aVar.f1836d, aVar.f1837e, aVar.f1838f);
                    this.q.a(mVar);
                    continue;
                case 4:
                    mVar.y0(aVar.c, aVar.f1836d, aVar.f1837e, aVar.f1838f);
                    this.q.l0(mVar);
                    continue;
                case 5:
                    mVar.y0(aVar.c, aVar.f1836d, aVar.f1837e, aVar.f1838f);
                    this.q.h0(mVar, true);
                    this.q.O(mVar);
                    continue;
                case 6:
                    mVar.y0(aVar.c, aVar.f1836d, aVar.f1837e, aVar.f1838f);
                    this.q.c(mVar);
                    continue;
                case 7:
                    mVar.y0(aVar.c, aVar.f1836d, aVar.f1837e, aVar.f1838f);
                    this.q.h0(mVar, true);
                    this.q.j(mVar);
                    continue;
                case 8:
                    e0Var = this.q;
                    mVar = null;
                    break;
                case 9:
                    e0Var = this.q;
                    break;
                case 10:
                    this.q.i0(mVar, aVar.f1839g);
                    continue;
            }
            e0Var.j0(mVar);
        }
    }

    public boolean m(int i2) {
        int size = this.a.size();
        for (int i3 = 0; i3 < size; i3++) {
            m mVar = this.a.get(i3).b;
            int i4 = mVar != null ? mVar.x : 0;
            if (i4 != 0 && i4 == i2) {
                return true;
            }
        }
        return false;
    }

    public boolean n(ArrayList<a> arrayList, int i2, int i3) {
        if (i3 == i2) {
            return false;
        }
        int size = this.a.size();
        int i4 = -1;
        for (int i5 = 0; i5 < size; i5++) {
            m mVar = this.a.get(i5).b;
            int i6 = mVar != null ? mVar.x : 0;
            if (!(i6 == 0 || i6 == i4)) {
                for (int i7 = i2; i7 < i3; i7++) {
                    a aVar = arrayList.get(i7);
                    int size2 = aVar.a.size();
                    for (int i8 = 0; i8 < size2; i8++) {
                        m mVar2 = aVar.a.get(i8).b;
                        if ((mVar2 != null ? mVar2.x : 0) == i6) {
                            return true;
                        }
                    }
                }
                i4 = i6;
            }
        }
        return false;
    }

    public m0 o(m mVar) {
        e0 e0Var = mVar.s;
        if (e0Var == null || e0Var == this.q) {
            b(new m0.a(3, mVar));
            return this;
        }
        StringBuilder h2 = f.a.a.a.a.h("Cannot remove Fragment attached to a different FragmentManager. Fragment ");
        h2.append(mVar.toString());
        h2.append(" is already attached to a FragmentManager.");
        throw new IllegalStateException(h2.toString());
    }

    public m0 p(m mVar) {
        e0 e0Var = mVar.s;
        if (e0Var == null || e0Var == this.q) {
            b(new m0.a(8, mVar));
            return this;
        }
        StringBuilder h2 = f.a.a.a.a.h("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment ");
        h2.append(mVar.toString());
        h2.append(" is already attached to a FragmentManager.");
        throw new IllegalStateException(h2.toString());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.s >= 0) {
            sb.append(" #");
            sb.append(this.s);
        }
        if (this.f1832i != null) {
            sb.append(" ");
            sb.append(this.f1832i);
        }
        sb.append("}");
        return sb.toString();
    }
}
