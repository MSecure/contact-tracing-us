package e.b.h;

import e.b.c;
import e.b.g.b;
import e.b.h.f;
import e.b.j.f;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public abstract class m implements Cloneable {

    /* renamed from: b  reason: collision with root package name */
    public m f4861b;

    /* renamed from: c  reason: collision with root package name */
    public int f4862c;

    public static class a implements f {

        /* renamed from: a  reason: collision with root package name */
        public Appendable f4863a;

        /* renamed from: b  reason: collision with root package name */
        public f.a f4864b;

        public a(Appendable appendable, f.a aVar) {
            this.f4863a = appendable;
            this.f4864b = aVar;
            aVar.b();
        }

        @Override // e.b.j.f
        public void a(m mVar, int i) {
            if (!mVar.s().equals("#text")) {
                try {
                    mVar.v(this.f4863a, i, this.f4864b);
                } catch (IOException e2) {
                    throw new c(e2);
                }
            }
        }

        @Override // e.b.j.f
        public void b(m mVar, int i) {
            try {
                mVar.u(this.f4863a, i, this.f4864b);
            } catch (IOException e2) {
                throw new c(e2);
            }
        }
    }

    public m A() {
        m mVar = this;
        while (true) {
            m mVar2 = mVar.f4861b;
            if (mVar2 == null) {
                return mVar;
            }
            mVar = mVar2;
        }
    }

    public String a(String str) {
        c.b.a.a.c.n.c.H1(str);
        return !o(str) ? "" : b.k(f(), c(str));
    }

    public void b(int i, m... mVarArr) {
        c.b.a.a.c.n.c.J1(mVarArr);
        if (mVarArr.length != 0) {
            List<m> n = n();
            m w = mVarArr[0].w();
            if (w == null || w.h() != mVarArr.length) {
                for (m mVar : mVarArr) {
                    if (mVar == null) {
                        throw new IllegalArgumentException("Array must not contain any null objects");
                    }
                }
                for (m mVar2 : mVarArr) {
                    if (mVar2 != null) {
                        c.b.a.a.c.n.c.J1(this);
                        m mVar3 = mVar2.f4861b;
                        if (mVar3 != null) {
                            mVar3.z(mVar2);
                        }
                        mVar2.f4861b = this;
                    } else {
                        throw null;
                    }
                }
                n.addAll(i, Arrays.asList(mVarArr));
                x(i);
                return;
            }
            List<m> i2 = w.i();
            int length = mVarArr.length;
            while (true) {
                int i3 = length - 1;
                if (length <= 0 || mVarArr[i3] != i2.get(i3)) {
                    w.m();
                    n.addAll(i, Arrays.asList(mVarArr));
                    int length2 = mVarArr.length;
                } else {
                    length = i3;
                }
            }
            w.m();
            n.addAll(i, Arrays.asList(mVarArr));
            int length22 = mVarArr.length;
            while (true) {
                int i4 = length22 - 1;
                if (length22 > 0) {
                    mVarArr[i4].f4861b = this;
                    length22 = i4;
                } else {
                    x(i);
                    return;
                }
            }
        }
    }

    public String c(String str) {
        c.b.a.a.c.n.c.J1(str);
        if (!p()) {
            return "";
        }
        String p = e().p(str);
        return p.length() > 0 ? p : str.startsWith("abs:") ? a(str.substring(4)) : "";
    }

    public m d(String str, String str2) {
        e.b.i.f fVar = c.b.a.a.c.n.c.N1(this).f4888c;
        if (fVar != null) {
            String trim = str.trim();
            if (!fVar.f4885b) {
                trim = c.b.a.a.c.n.c.C1(trim);
            }
            b e2 = e();
            int t = e2.t(trim);
            if (t != -1) {
                e2.f4831d[t] = str2;
                if (!e2.f4830c[t].equals(trim)) {
                    e2.f4830c[t] = trim;
                }
            } else {
                e2.a(trim, str2);
            }
            return this;
        }
        throw null;
    }

    public abstract b e();

    public boolean equals(Object obj) {
        return this == obj;
    }

    public abstract String f();

    public m g(int i) {
        return n().get(i);
    }

    public abstract int h();

    public List<m> i() {
        return Collections.unmodifiableList(n());
    }

    /* renamed from: j */
    public m clone() {
        m k = k(null);
        LinkedList linkedList = new LinkedList();
        linkedList.add(k);
        while (!linkedList.isEmpty()) {
            m mVar = (m) linkedList.remove();
            int h = mVar.h();
            for (int i = 0; i < h; i++) {
                List<m> n = mVar.n();
                m k2 = n.get(i).k(mVar);
                n.set(i, k2);
                linkedList.add(k2);
            }
        }
        return k;
    }

    public m k(m mVar) {
        try {
            m mVar2 = (m) super.clone();
            mVar2.f4861b = mVar;
            mVar2.f4862c = mVar == null ? 0 : this.f4862c;
            return mVar2;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public abstract void l(String str);

    public abstract m m();

    public abstract List<m> n();

    public boolean o(String str) {
        c.b.a.a.c.n.c.J1(str);
        if (str.startsWith("abs:")) {
            String substring = str.substring(4);
            if ((e().t(substring) != -1) && !a(substring).equals("")) {
                return true;
            }
        }
        return e().t(str) != -1;
    }

    public abstract boolean p();

    public void q(Appendable appendable, int i, f.a aVar) {
        appendable.append('\n').append(b.i(i * aVar.h));
    }

    public m r() {
        m mVar = this.f4861b;
        if (mVar == null) {
            return null;
        }
        List<m> n = mVar.n();
        int i = this.f4862c + 1;
        if (n.size() > i) {
            return n.get(i);
        }
        return null;
    }

    public abstract String s();

    public String t() {
        StringBuilder b2 = b.b();
        c.b.a.a.c.n.c.s2(new a(b2, c.b.a.a.c.n.c.L1(this)), this);
        return b.j(b2);
    }

    public String toString() {
        return t();
    }

    public abstract void u(Appendable appendable, int i, f.a aVar);

    public abstract void v(Appendable appendable, int i, f.a aVar);

    public m w() {
        return this.f4861b;
    }

    public final void x(int i) {
        List<m> n = n();
        while (i < n.size()) {
            n.get(i).f4862c = i;
            i++;
        }
    }

    public void y() {
        c.b.a.a.c.n.c.J1(this.f4861b);
        this.f4861b.z(this);
    }

    public void z(m mVar) {
        c.b.a.a.c.n.c.t1(mVar.f4861b == this);
        int i = mVar.f4862c;
        n().remove(i);
        x(i);
        mVar.f4861b = null;
    }
}
