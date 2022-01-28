package e.n.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class l0 {
    public final ArrayList<m> a = new ArrayList<>();
    public final HashMap<String, k0> b = new HashMap<>();
    public h0 c;

    public void a(m mVar) {
        if (!this.a.contains(mVar)) {
            synchronized (this.a) {
                this.a.add(mVar);
            }
            mVar.f1732l = true;
            return;
        }
        throw new IllegalStateException("Fragment already added: " + mVar);
    }

    public void b() {
        this.b.values().removeAll(Collections.singleton(null));
    }

    public boolean c(String str) {
        return this.b.get(str) != null;
    }

    public m d(String str) {
        k0 k0Var = this.b.get(str);
        if (k0Var != null) {
            return k0Var.c;
        }
        return null;
    }

    public m e(String str) {
        for (k0 k0Var : this.b.values()) {
            if (k0Var != null) {
                m mVar = k0Var.c;
                if (!str.equals(mVar.f1726f)) {
                    mVar = mVar.u.c.e(str);
                }
                if (mVar != null) {
                    return mVar;
                }
            }
        }
        return null;
    }

    public List<k0> f() {
        ArrayList arrayList = new ArrayList();
        for (k0 k0Var : this.b.values()) {
            if (k0Var != null) {
                arrayList.add(k0Var);
            }
        }
        return arrayList;
    }

    public List<m> g() {
        ArrayList arrayList = new ArrayList();
        Iterator<k0> it = this.b.values().iterator();
        while (it.hasNext()) {
            k0 next = it.next();
            arrayList.add(next != null ? next.c : null);
        }
        return arrayList;
    }

    public k0 h(String str) {
        return this.b.get(str);
    }

    public List<m> i() {
        ArrayList arrayList;
        if (this.a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.a) {
            arrayList = new ArrayList(this.a);
        }
        return arrayList;
    }

    public void j(k0 k0Var) {
        m mVar = k0Var.c;
        if (!c(mVar.f1726f)) {
            this.b.put(mVar.f1726f, k0Var);
            if (e0.O(2)) {
                String str = "Added fragment to active set " + mVar;
            }
        }
    }

    public void k(k0 k0Var) {
        m mVar = k0Var.c;
        if (mVar.B) {
            this.c.c(mVar);
        }
        if (this.b.put(mVar.f1726f, null) != null && e0.O(2)) {
            String str = "Removed fragment from active set " + mVar;
        }
    }

    public void l(m mVar) {
        synchronized (this.a) {
            this.a.remove(mVar);
        }
        mVar.f1732l = false;
    }
}
