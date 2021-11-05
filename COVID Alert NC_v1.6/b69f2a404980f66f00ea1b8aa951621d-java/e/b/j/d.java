package e.b.j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public abstract class d {

    public static final class a extends d {
        @Override // e.b.j.d
        public boolean a(e.b.h.i iVar, e.b.h.i iVar2) {
            return true;
        }

        public String toString() {
            return "*";
        }
    }

    public static final class a0 extends o {
        public a0(int i, int i2) {
            super(i, i2);
        }

        @Override // e.b.j.d.o
        public int b(e.b.h.i iVar, e.b.h.i iVar2) {
            return ((e.b.h.i) iVar2.f4861b).F().size() - iVar2.I();
        }

        @Override // e.b.j.d.o
        public String c() {
            return "nth-last-child";
        }
    }

    public static final class b extends d {

        /* renamed from: a  reason: collision with root package name */
        public String f4931a;

        public b(String str) {
            this.f4931a = str;
        }

        @Override // e.b.j.d
        public boolean a(e.b.h.i iVar, e.b.h.i iVar2) {
            return iVar2.o(this.f4931a);
        }

        public String toString() {
            return String.format("[%s]", this.f4931a);
        }
    }

    public static class b0 extends o {
        public b0(int i, int i2) {
            super(i, i2);
        }

        @Override // e.b.j.d.o
        public int b(e.b.h.i iVar, e.b.h.i iVar2) {
            c F = ((e.b.h.i) iVar2.f4861b).F();
            int i = 0;
            for (int I = iVar2.I(); I < F.size(); I++) {
                if (((e.b.h.i) F.get(I)).f4846d.equals(iVar2.f4846d)) {
                    i++;
                }
            }
            return i;
        }

        @Override // e.b.j.d.o
        public String c() {
            return "nth-last-of-type";
        }
    }

    public static abstract class c extends d {

        /* renamed from: a  reason: collision with root package name */
        public String f4932a;

        /* renamed from: b  reason: collision with root package name */
        public String f4933b;

        public c(String str, String str2, boolean z) {
            c.b.a.a.c.n.c.H1(str);
            c.b.a.a.c.n.c.H1(str2);
            this.f4932a = c.b.a.a.c.n.c.G1(str);
            boolean z2 = (str2.startsWith("'") && str2.endsWith("'")) || (str2.startsWith("\"") && str2.endsWith("\""));
            str2 = z2 ? str2.substring(1, str2.length() - 1) : str2;
            this.f4933b = z ? c.b.a.a.c.n.c.G1(str2) : z2 ? c.b.a.a.c.n.c.C1(str2) : c.b.a.a.c.n.c.G1(str2);
        }
    }

    public static class c0 extends o {
        public c0(int i, int i2) {
            super(i, i2);
        }

        @Override // e.b.j.d.o
        public int b(e.b.h.i iVar, e.b.h.i iVar2) {
            Iterator it = ((e.b.h.i) iVar2.f4861b).F().iterator();
            int i = 0;
            while (it.hasNext()) {
                e.b.h.i iVar3 = (e.b.h.i) it.next();
                if (iVar3.f4846d.equals(iVar2.f4846d)) {
                    i++;
                    continue;
                }
                if (iVar3 == iVar2) {
                    break;
                }
            }
            return i;
        }

        @Override // e.b.j.d.o
        public String c() {
            return "nth-of-type";
        }
    }

    /* renamed from: e.b.j.d$d  reason: collision with other inner class name */
    public static final class C0120d extends d {

        /* renamed from: a  reason: collision with root package name */
        public String f4934a;

        public C0120d(String str) {
            c.b.a.a.c.n.c.H1(str);
            this.f4934a = c.b.a.a.c.n.c.C1(str);
        }

        @Override // e.b.j.d
        public boolean a(e.b.h.i iVar, e.b.h.i iVar2) {
            e.b.h.b e2 = iVar2.e();
            if (e2 != null) {
                ArrayList arrayList = new ArrayList(e2.f4829b);
                for (int i = 0; i < e2.f4829b; i++) {
                    if (!e2.u(e2.f4830c[i])) {
                        arrayList.add(new e.b.h.a(e2.f4830c[i], e2.f4831d[i], e2));
                    }
                }
                for (e.b.h.a aVar : Collections.unmodifiableList(arrayList)) {
                    if (c.b.a.a.c.n.c.C1(aVar.f4825b).startsWith(this.f4934a)) {
                        return true;
                    }
                }
                return false;
            }
            throw null;
        }

        public String toString() {
            return String.format("[^%s]", this.f4934a);
        }
    }

    public static final class d0 extends d {
        @Override // e.b.j.d
        public boolean a(e.b.h.i iVar, e.b.h.i iVar2) {
            c cVar;
            e.b.h.m mVar = iVar2.f4861b;
            e.b.h.i iVar3 = (e.b.h.i) mVar;
            if (iVar3 == null || (iVar3 instanceof e.b.h.f)) {
                return false;
            }
            if (mVar == null) {
                cVar = new c(0);
            } else {
                List<e.b.h.i> E = ((e.b.h.i) mVar).E();
                c cVar2 = new c(E.size() - 1);
                for (e.b.h.i iVar4 : E) {
                    if (iVar4 != iVar2) {
                        cVar2.add(iVar4);
                    }
                }
                cVar = cVar2;
            }
            if (cVar.isEmpty()) {
                return true;
            }
            return false;
        }

        public String toString() {
            return ":only-child";
        }
    }

    public static final class e extends c {
        public e(String str, String str2) {
            super(str, str2, true);
        }

        @Override // e.b.j.d
        public boolean a(e.b.h.i iVar, e.b.h.i iVar2) {
            return iVar2.o(this.f4932a) && this.f4933b.equalsIgnoreCase(iVar2.c(this.f4932a).trim());
        }

        public String toString() {
            return String.format("[%s=%s]", this.f4932a, this.f4933b);
        }
    }

    public static final class e0 extends d {
        @Override // e.b.j.d
        public boolean a(e.b.h.i iVar, e.b.h.i iVar2) {
            e.b.h.i iVar3 = (e.b.h.i) iVar2.f4861b;
            if (iVar3 == null || (iVar3 instanceof e.b.h.f)) {
                return false;
            }
            Iterator it = iVar3.F().iterator();
            int i = 0;
            while (it.hasNext()) {
                if (((e.b.h.i) it.next()).f4846d.equals(iVar2.f4846d)) {
                    i++;
                }
            }
            if (i == 1) {
                return true;
            }
            return false;
        }

        public String toString() {
            return ":only-of-type";
        }
    }

    public static final class f extends c {
        public f(String str, String str2) {
            super(str, str2, true);
        }

        @Override // e.b.j.d
        public boolean a(e.b.h.i iVar, e.b.h.i iVar2) {
            return iVar2.o(this.f4932a) && c.b.a.a.c.n.c.C1(iVar2.c(this.f4932a)).contains(this.f4933b);
        }

        public String toString() {
            return String.format("[%s*=%s]", this.f4932a, this.f4933b);
        }
    }

    public static final class f0 extends d {
        @Override // e.b.j.d
        public boolean a(e.b.h.i iVar, e.b.h.i iVar2) {
            if (iVar instanceof e.b.h.f) {
                iVar = iVar.E().get(0);
            }
            return iVar2 == iVar;
        }

        public String toString() {
            return ":root";
        }
    }

    public static final class g extends c {
        public g(String str, String str2) {
            super(str, str2, false);
        }

        @Override // e.b.j.d
        public boolean a(e.b.h.i iVar, e.b.h.i iVar2) {
            return iVar2.o(this.f4932a) && c.b.a.a.c.n.c.C1(iVar2.c(this.f4932a)).endsWith(this.f4933b);
        }

        public String toString() {
            return String.format("[%s$=%s]", this.f4932a, this.f4933b);
        }
    }

    public static final class g0 extends d {
        @Override // e.b.j.d
        public boolean a(e.b.h.i iVar, e.b.h.i iVar2) {
            if (iVar2 instanceof e.b.h.n) {
                return true;
            }
            if (iVar2 != null) {
                ArrayList arrayList = new ArrayList();
                for (e.b.h.m mVar : iVar2.f) {
                    if (mVar instanceof e.b.h.o) {
                        arrayList.add((e.b.h.o) mVar);
                    }
                }
                Iterator it = Collections.unmodifiableList(arrayList).iterator();
                while (true) {
                    boolean z = false;
                    if (!it.hasNext()) {
                        return false;
                    }
                    e.b.h.o oVar = (e.b.h.o) it.next();
                    e.b.h.n nVar = new e.b.h.n(e.b.i.h.a(iVar2.f4846d.f4889b, e.b.i.f.f4883d), iVar2.f(), iVar2.e());
                    if (oVar != null) {
                        c.b.a.a.c.n.c.J1(nVar);
                        c.b.a.a.c.n.c.J1(oVar.f4861b);
                        e.b.h.m mVar2 = oVar.f4861b;
                        if (mVar2 != null) {
                            if (mVar2 == mVar2) {
                                z = true;
                            }
                            c.b.a.a.c.n.c.t1(z);
                            c.b.a.a.c.n.c.J1(nVar);
                            e.b.h.m mVar3 = nVar.f4861b;
                            if (mVar3 != null) {
                                mVar3.z(nVar);
                            }
                            int i = oVar.f4862c;
                            mVar2.n().set(i, nVar);
                            nVar.f4861b = mVar2;
                            nVar.f4862c = i;
                            oVar.f4861b = null;
                            nVar.B(oVar);
                        } else {
                            throw null;
                        }
                    } else {
                        throw null;
                    }
                }
            } else {
                throw null;
            }
        }

        public String toString() {
            return ":matchText";
        }
    }

    public static final class h extends d {

        /* renamed from: a  reason: collision with root package name */
        public String f4935a;

        /* renamed from: b  reason: collision with root package name */
        public Pattern f4936b;

        public h(String str, Pattern pattern) {
            this.f4935a = c.b.a.a.c.n.c.G1(str);
            this.f4936b = pattern;
        }

        @Override // e.b.j.d
        public boolean a(e.b.h.i iVar, e.b.h.i iVar2) {
            return iVar2.o(this.f4935a) && this.f4936b.matcher(iVar2.c(this.f4935a)).find();
        }

        public String toString() {
            return String.format("[%s~=%s]", this.f4935a, this.f4936b.toString());
        }
    }

    public static final class h0 extends d {

        /* renamed from: a  reason: collision with root package name */
        public Pattern f4937a;

        public h0(Pattern pattern) {
            this.f4937a = pattern;
        }

        @Override // e.b.j.d
        public boolean a(e.b.h.i iVar, e.b.h.i iVar2) {
            Pattern pattern = this.f4937a;
            if (iVar2 != null) {
                StringBuilder b2 = e.b.g.b.b();
                c.b.a.a.c.n.c.s2(new e.b.h.h(iVar2, b2), iVar2);
                return pattern.matcher(e.b.g.b.j(b2).trim()).find();
            }
            throw null;
        }

        public String toString() {
            return String.format(":matches(%s)", this.f4937a);
        }
    }

    public static final class i extends c {
        public i(String str, String str2) {
            super(str, str2, true);
        }

        @Override // e.b.j.d
        public boolean a(e.b.h.i iVar, e.b.h.i iVar2) {
            return !this.f4933b.equalsIgnoreCase(iVar2.c(this.f4932a));
        }

        public String toString() {
            return String.format("[%s!=%s]", this.f4932a, this.f4933b);
        }
    }

    public static final class i0 extends d {

        /* renamed from: a  reason: collision with root package name */
        public Pattern f4938a;

        public i0(Pattern pattern) {
            this.f4938a = pattern;
        }

        @Override // e.b.j.d
        public boolean a(e.b.h.i iVar, e.b.h.i iVar2) {
            return this.f4938a.matcher(iVar2.K()).find();
        }

        public String toString() {
            return String.format(":matchesOwn(%s)", this.f4938a);
        }
    }

    public static final class j extends c {
        public j(String str, String str2) {
            super(str, str2, false);
        }

        @Override // e.b.j.d
        public boolean a(e.b.h.i iVar, e.b.h.i iVar2) {
            return iVar2.o(this.f4932a) && c.b.a.a.c.n.c.C1(iVar2.c(this.f4932a)).startsWith(this.f4933b);
        }

        public String toString() {
            return String.format("[%s^=%s]", this.f4932a, this.f4933b);
        }
    }

    public static final class j0 extends d {

        /* renamed from: a  reason: collision with root package name */
        public String f4939a;

        public j0(String str) {
            this.f4939a = str;
        }

        @Override // e.b.j.d
        public boolean a(e.b.h.i iVar, e.b.h.i iVar2) {
            return iVar2.f4846d.f4890c.equals(this.f4939a);
        }

        public String toString() {
            return String.format("%s", this.f4939a);
        }
    }

    public static final class k extends d {

        /* renamed from: a  reason: collision with root package name */
        public String f4940a;

        public k(String str) {
            this.f4940a = str;
        }

        @Override // e.b.j.d
        public boolean a(e.b.h.i iVar, e.b.h.i iVar2) {
            String str = this.f4940a;
            if (!iVar2.p()) {
                return false;
            }
            String p = iVar2.g.p("class");
            int length = p.length();
            int length2 = str.length();
            if (length == 0 || length < length2) {
                return false;
            }
            if (length == length2) {
                return str.equalsIgnoreCase(p);
            }
            boolean z = false;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                if (Character.isWhitespace(p.charAt(i2))) {
                    if (!z) {
                        continue;
                    } else if (i2 - i == length2 && p.regionMatches(true, i, str, 0, length2)) {
                        return true;
                    } else {
                        z = false;
                    }
                } else if (!z) {
                    z = true;
                    i = i2;
                }
            }
            if (!z || length - i != length2) {
                return false;
            }
            return p.regionMatches(true, i, str, 0, length2);
        }

        public String toString() {
            return String.format(".%s", this.f4940a);
        }
    }

    public static final class k0 extends d {

        /* renamed from: a  reason: collision with root package name */
        public String f4941a;

        public k0(String str) {
            this.f4941a = str;
        }

        @Override // e.b.j.d
        public boolean a(e.b.h.i iVar, e.b.h.i iVar2) {
            return iVar2.f4846d.f4890c.endsWith(this.f4941a);
        }

        public String toString() {
            return String.format("%s", this.f4941a);
        }
    }

    public static final class l extends d {

        /* renamed from: a  reason: collision with root package name */
        public String f4942a;

        public l(String str) {
            this.f4942a = c.b.a.a.c.n.c.C1(str);
        }

        @Override // e.b.j.d
        public boolean a(e.b.h.i iVar, e.b.h.i iVar2) {
            return c.b.a.a.c.n.c.C1(iVar2.H()).contains(this.f4942a);
        }

        public String toString() {
            return String.format(":containsData(%s)", this.f4942a);
        }
    }

    public static final class m extends d {

        /* renamed from: a  reason: collision with root package name */
        public String f4943a;

        public m(String str) {
            this.f4943a = c.b.a.a.c.n.c.C1(str);
        }

        @Override // e.b.j.d
        public boolean a(e.b.h.i iVar, e.b.h.i iVar2) {
            return c.b.a.a.c.n.c.C1(iVar2.K()).contains(this.f4943a);
        }

        public String toString() {
            return String.format(":containsOwn(%s)", this.f4943a);
        }
    }

    public static final class n extends d {

        /* renamed from: a  reason: collision with root package name */
        public String f4944a;

        public n(String str) {
            this.f4944a = c.b.a.a.c.n.c.C1(str);
        }

        @Override // e.b.j.d
        public boolean a(e.b.h.i iVar, e.b.h.i iVar2) {
            if (iVar2 != null) {
                StringBuilder b2 = e.b.g.b.b();
                c.b.a.a.c.n.c.s2(new e.b.h.h(iVar2, b2), iVar2);
                return c.b.a.a.c.n.c.C1(e.b.g.b.j(b2).trim()).contains(this.f4944a);
            }
            throw null;
        }

        public String toString() {
            return String.format(":contains(%s)", this.f4944a);
        }
    }

    public static abstract class o extends d {

        /* renamed from: a  reason: collision with root package name */
        public final int f4945a;

        /* renamed from: b  reason: collision with root package name */
        public final int f4946b;

        public o(int i, int i2) {
            this.f4945a = i;
            this.f4946b = i2;
        }

        @Override // e.b.j.d
        public boolean a(e.b.h.i iVar, e.b.h.i iVar2) {
            e.b.h.i iVar3 = (e.b.h.i) iVar2.f4861b;
            if (iVar3 == null || (iVar3 instanceof e.b.h.f)) {
                return false;
            }
            int b2 = b(iVar, iVar2);
            int i = this.f4945a;
            if (i != 0) {
                int i2 = this.f4946b;
                if ((b2 - i2) * i < 0 || (b2 - i2) % i != 0) {
                    return false;
                }
                return true;
            } else if (b2 == this.f4946b) {
                return true;
            } else {
                return false;
            }
        }

        public abstract int b(e.b.h.i iVar, e.b.h.i iVar2);

        public abstract String c();

        public String toString() {
            if (this.f4945a == 0) {
                return String.format(":%s(%d)", c(), Integer.valueOf(this.f4946b));
            } else if (this.f4946b == 0) {
                return String.format(":%s(%dn)", c(), Integer.valueOf(this.f4945a));
            } else {
                return String.format(":%s(%dn%+d)", c(), Integer.valueOf(this.f4945a), Integer.valueOf(this.f4946b));
            }
        }
    }

    public static final class p extends d {

        /* renamed from: a  reason: collision with root package name */
        public String f4947a;

        public p(String str) {
            this.f4947a = str;
        }

        @Override // e.b.j.d
        public boolean a(e.b.h.i iVar, e.b.h.i iVar2) {
            return this.f4947a.equals(iVar2.p() ? iVar2.g.p("id") : "");
        }

        public String toString() {
            return String.format("#%s", this.f4947a);
        }
    }

    public static final class q extends r {
        public q(int i) {
            super(i);
        }

        @Override // e.b.j.d
        public boolean a(e.b.h.i iVar, e.b.h.i iVar2) {
            return iVar2.I() == this.f4948a;
        }

        public String toString() {
            return String.format(":eq(%d)", Integer.valueOf(this.f4948a));
        }
    }

    public static abstract class r extends d {

        /* renamed from: a  reason: collision with root package name */
        public int f4948a;

        public r(int i) {
            this.f4948a = i;
        }
    }

    public static final class s extends r {
        public s(int i) {
            super(i);
        }

        @Override // e.b.j.d
        public boolean a(e.b.h.i iVar, e.b.h.i iVar2) {
            return iVar2.I() > this.f4948a;
        }

        public String toString() {
            return String.format(":gt(%d)", Integer.valueOf(this.f4948a));
        }
    }

    public static final class t extends r {
        public t(int i) {
            super(i);
        }

        @Override // e.b.j.d
        public boolean a(e.b.h.i iVar, e.b.h.i iVar2) {
            return iVar != iVar2 && iVar2.I() < this.f4948a;
        }

        public String toString() {
            return String.format(":lt(%d)", Integer.valueOf(this.f4948a));
        }
    }

    public static final class u extends d {
        @Override // e.b.j.d
        public boolean a(e.b.h.i iVar, e.b.h.i iVar2) {
            for (e.b.h.m mVar : iVar2.i()) {
                if (!((mVar instanceof e.b.h.d) || (mVar instanceof e.b.h.p) || (mVar instanceof e.b.h.g))) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            return ":empty";
        }
    }

    public static final class v extends d {
        @Override // e.b.j.d
        public boolean a(e.b.h.i iVar, e.b.h.i iVar2) {
            e.b.h.i iVar3 = (e.b.h.i) iVar2.f4861b;
            return iVar3 != null && !(iVar3 instanceof e.b.h.f) && iVar2.I() == 0;
        }

        public String toString() {
            return ":first-child";
        }
    }

    public static final class w extends c0 {
        public w() {
            super(0, 1);
        }

        @Override // e.b.j.d.o
        public String toString() {
            return ":first-of-type";
        }
    }

    public static final class x extends d {
        @Override // e.b.j.d
        public boolean a(e.b.h.i iVar, e.b.h.i iVar2) {
            e.b.h.i iVar3 = (e.b.h.i) iVar2.f4861b;
            if (iVar3 == null || (iVar3 instanceof e.b.h.f) || iVar2.I() != iVar3.F().size() - 1) {
                return false;
            }
            return true;
        }

        public String toString() {
            return ":last-child";
        }
    }

    public static final class y extends b0 {
        public y() {
            super(0, 1);
        }

        @Override // e.b.j.d.o
        public String toString() {
            return ":last-of-type";
        }
    }

    public static final class z extends o {
        public z(int i, int i2) {
            super(i, i2);
        }

        @Override // e.b.j.d.o
        public int b(e.b.h.i iVar, e.b.h.i iVar2) {
            return iVar2.I() + 1;
        }

        @Override // e.b.j.d.o
        public String c() {
            return "nth-child";
        }
    }

    public abstract boolean a(e.b.h.i iVar, e.b.h.i iVar2);
}
