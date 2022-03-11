package e.m.a;

import e.m.a.f0;
import e.m.a.l;
import e.m.a.o0;
import e.p.g;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public final class a extends o0 implements f0.m {
    public final f0 q;
    public boolean r;
    public int s;

    /* JADX WARNING: Illegal instructions before constructor call */
    public a(f0 f0Var) {
        super(r0, r1 != null ? r1.c.getClassLoader() : null);
        b0 M = f0Var.M();
        c0<?> c0Var = f0Var.q;
        this.s = -1;
        this.q = f0Var;
    }

    public static boolean n(o0.a aVar) {
        l lVar = aVar.b;
        return lVar != null && lVar.f1637l && lVar.F != null && !lVar.A && !lVar.z && lVar.F();
    }

    @Override // e.m.a.f0.m
    public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (f0.Q(2)) {
            String str = "Run: " + this;
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f1666g) {
            return true;
        }
        f0 f0Var = this.q;
        if (f0Var.f1604d == null) {
            f0Var.f1604d = new ArrayList<>();
        }
        f0Var.f1604d.add(this);
        return true;
    }

    @Override // e.m.a.o0
    public int c() {
        return h(false);
    }

    @Override // e.m.a.o0
    public void d() {
        if (!this.f1666g) {
            this.f1667h = false;
            this.q.E(this, false);
            return;
        }
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }

    @Override // e.m.a.o0
    public void e(int i2, l lVar, String str, int i3) {
        Class<?> cls = lVar.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            StringBuilder h2 = f.a.a.a.a.h("Fragment ");
            h2.append(cls.getCanonicalName());
            h2.append(" must be a public static class to be  properly recreated from instance state.");
            throw new IllegalStateException(h2.toString());
        }
        if (str != null) {
            String str2 = lVar.y;
            if (str2 == null || str.equals(str2)) {
                lVar.y = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + lVar + ": was " + lVar.y + " now " + str);
            }
        }
        if (i2 != 0) {
            if (i2 != -1) {
                int i4 = lVar.w;
                if (i4 == 0 || i4 == i2) {
                    lVar.w = i2;
                    lVar.x = i2;
                } else {
                    throw new IllegalStateException("Can't change container ID of fragment " + lVar + ": was " + lVar.w + " now " + i2);
                }
            } else {
                throw new IllegalArgumentException("Can't add fragment " + lVar + " with tag " + str + " to container view with no id");
            }
        }
        b(new o0.a(i3, lVar));
        lVar.s = this.q;
    }

    public void g(int i2) {
        if (this.f1666g) {
            if (f0.Q(2)) {
                String str = "Bump nesting in " + this + " by " + i2;
            }
            int size = this.a.size();
            for (int i3 = 0; i3 < size; i3++) {
                o0.a aVar = this.a.get(i3);
                l lVar = aVar.b;
                if (lVar != null) {
                    lVar.r += i2;
                    if (f0.Q(2)) {
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

    public int h(boolean z) {
        if (!this.r) {
            if (f0.Q(2)) {
                String str = "Commit: " + this;
                PrintWriter printWriter = new PrintWriter(new b1("FragmentManager"));
                i("  ", printWriter, true);
                printWriter.close();
            }
            this.r = true;
            this.s = this.f1666g ? this.q.f1609i.getAndIncrement() : -1;
            this.q.B(this, z);
            return this.s;
        }
        throw new IllegalStateException("commit already called");
    }

    public void i(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f1668i);
            printWriter.print(" mIndex=");
            printWriter.print(this.s);
            printWriter.print(" mCommitted=");
            printWriter.println(this.r);
            if (this.f1665f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f1665f));
            }
            if (!(this.b == 0 && this.c == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.c));
            }
            if (!(this.f1663d == 0 && this.f1664e == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1663d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1664e));
            }
            if (!(this.f1669j == 0 && this.f1670k == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f1669j));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f1670k);
            }
            if (!(this.f1671l == 0 && this.m == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f1671l));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.m);
            }
        }
        if (!this.a.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            int size = this.a.size();
            for (int i2 = 0; i2 < size; i2++) {
                o0.a aVar = this.a.get(i2);
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
                    if (!(aVar.c == 0 && aVar.f1672d == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.c));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f1672d));
                    }
                    if (aVar.f1673e != 0 || aVar.f1674f != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f1673e));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f1674f));
                    }
                }
            }
        }
    }

    public void j() {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            o0.a aVar = this.a.get(i2);
            l lVar = aVar.b;
            if (lVar != null) {
                int i3 = this.f1665f;
                if (!(lVar.I == null && i3 == 0)) {
                    lVar.f();
                    lVar.I.f1638d = i3;
                }
                ArrayList<String> arrayList = this.n;
                ArrayList<String> arrayList2 = this.o;
                lVar.f();
                l.c cVar = lVar.I;
                cVar.f1639e = arrayList;
                cVar.f1640f = arrayList2;
            }
            switch (aVar.a) {
                case 1:
                    lVar.u0(aVar.c);
                    this.q.j0(lVar, false);
                    this.q.b(lVar);
                    break;
                case 2:
                default:
                    StringBuilder h2 = f.a.a.a.a.h("Unknown cmd: ");
                    h2.append(aVar.a);
                    throw new IllegalArgumentException(h2.toString());
                case 3:
                    lVar.u0(aVar.f1672d);
                    this.q.e0(lVar);
                    break;
                case 4:
                    lVar.u0(aVar.f1672d);
                    this.q.P(lVar);
                    break;
                case 5:
                    lVar.u0(aVar.c);
                    this.q.j0(lVar, false);
                    this.q.n0(lVar);
                    break;
                case 6:
                    lVar.u0(aVar.f1672d);
                    this.q.k(lVar);
                    break;
                case 7:
                    lVar.u0(aVar.c);
                    this.q.j0(lVar, false);
                    this.q.d(lVar);
                    break;
                case 8:
                    this.q.l0(lVar);
                    break;
                case 9:
                    this.q.l0(null);
                    break;
                case 10:
                    this.q.k0(lVar, aVar.f1676h);
                    break;
            }
            if (!(this.p || aVar.a == 1 || lVar == null)) {
                if (f0.L) {
                    this.q.i(lVar).j();
                } else {
                    this.q.V(lVar);
                }
            }
        }
        if (!this.p) {
            f0 f0Var = this.q;
            f0Var.W(f0Var.p, true);
        }
    }

    public void k(boolean z) {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            o0.a aVar = this.a.get(size);
            l lVar = aVar.b;
            if (lVar != null) {
                int i2 = this.f1665f;
                int i3 = 8194;
                if (i2 != 4097) {
                    i3 = i2 != 4099 ? i2 != 8194 ? 0 : 4097 : 4099;
                }
                if (!(lVar.I == null && i3 == 0)) {
                    lVar.f();
                    lVar.I.f1638d = i3;
                }
                ArrayList<String> arrayList = this.o;
                ArrayList<String> arrayList2 = this.n;
                lVar.f();
                l.c cVar = lVar.I;
                cVar.f1639e = arrayList;
                cVar.f1640f = arrayList2;
            }
            switch (aVar.a) {
                case 1:
                    lVar.u0(aVar.f1674f);
                    this.q.j0(lVar, true);
                    this.q.e0(lVar);
                    break;
                case 2:
                default:
                    StringBuilder h2 = f.a.a.a.a.h("Unknown cmd: ");
                    h2.append(aVar.a);
                    throw new IllegalArgumentException(h2.toString());
                case 3:
                    lVar.u0(aVar.f1673e);
                    this.q.b(lVar);
                    break;
                case 4:
                    lVar.u0(aVar.f1673e);
                    this.q.n0(lVar);
                    break;
                case 5:
                    lVar.u0(aVar.f1674f);
                    this.q.j0(lVar, true);
                    this.q.P(lVar);
                    break;
                case 6:
                    lVar.u0(aVar.f1673e);
                    this.q.d(lVar);
                    break;
                case 7:
                    lVar.u0(aVar.f1674f);
                    this.q.j0(lVar, true);
                    this.q.k(lVar);
                    break;
                case 8:
                    this.q.l0(null);
                    break;
                case 9:
                    this.q.l0(lVar);
                    break;
                case 10:
                    this.q.k0(lVar, aVar.f1675g);
                    break;
            }
            if (!(this.p || aVar.a == 3 || lVar == null)) {
                if (f0.L) {
                    this.q.i(lVar).j();
                } else {
                    this.q.V(lVar);
                }
            }
        }
        if (!this.p && z) {
            f0 f0Var = this.q;
            f0Var.W(f0Var.p, true);
        }
    }

    public boolean l(int i2) {
        int size = this.a.size();
        for (int i3 = 0; i3 < size; i3++) {
            l lVar = this.a.get(i3).b;
            int i4 = lVar != null ? lVar.x : 0;
            if (i4 != 0 && i4 == i2) {
                return true;
            }
        }
        return false;
    }

    public boolean m(ArrayList<a> arrayList, int i2, int i3) {
        if (i3 == i2) {
            return false;
        }
        int size = this.a.size();
        int i4 = -1;
        for (int i5 = 0; i5 < size; i5++) {
            l lVar = this.a.get(i5).b;
            int i6 = lVar != null ? lVar.x : 0;
            if (!(i6 == 0 || i6 == i4)) {
                for (int i7 = i2; i7 < i3; i7++) {
                    a aVar = arrayList.get(i7);
                    int size2 = aVar.a.size();
                    for (int i8 = 0; i8 < size2; i8++) {
                        l lVar2 = aVar.a.get(i8).b;
                        if ((lVar2 != null ? lVar2.x : 0) == i6) {
                            return true;
                        }
                    }
                }
                i4 = i6;
            }
        }
        return false;
    }

    public o0 o(l lVar) {
        f0 f0Var = lVar.s;
        if (f0Var == null || f0Var == this.q) {
            b(new o0.a(3, lVar));
            return this;
        }
        StringBuilder h2 = f.a.a.a.a.h("Cannot remove Fragment attached to a different FragmentManager. Fragment ");
        h2.append(lVar.toString());
        h2.append(" is already attached to a FragmentManager.");
        throw new IllegalStateException(h2.toString());
    }

    public o0 p(l lVar, g.b bVar) {
        if (lVar.s == this.q) {
            g.b bVar2 = g.b.CREATED;
            if (bVar.compareTo(bVar2) >= 0) {
                b(new o0.a(10, lVar, bVar));
                return this;
            }
            throw new IllegalArgumentException("Cannot set maximum Lifecycle below " + bVar2);
        }
        StringBuilder h2 = f.a.a.a.a.h("Cannot setMaxLifecycle for Fragment not attached to FragmentManager ");
        h2.append(this.q);
        throw new IllegalArgumentException(h2.toString());
    }

    public o0 q(l lVar) {
        f0 f0Var = lVar.s;
        if (f0Var == null || f0Var == this.q) {
            b(new o0.a(8, lVar));
            return this;
        }
        StringBuilder h2 = f.a.a.a.a.h("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment ");
        h2.append(lVar.toString());
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
        if (this.f1668i != null) {
            sb.append(" ");
            sb.append(this.f1668i);
        }
        sb.append("}");
        return sb.toString();
    }
}
