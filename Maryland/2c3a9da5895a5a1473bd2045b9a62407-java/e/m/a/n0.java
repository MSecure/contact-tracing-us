package e.m.a;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class n0 {
    public final ArrayList<l> a = new ArrayList<>();
    public final HashMap<String, m0> b = new HashMap<>();
    public j0 c;

    public void a(l lVar) {
        if (!this.a.contains(lVar)) {
            synchronized (this.a) {
                this.a.add(lVar);
            }
            lVar.f1637l = true;
            return;
        }
        throw new IllegalStateException("Fragment already added: " + lVar);
    }

    public void b() {
        this.b.values().removeAll(Collections.singleton(null));
    }

    public boolean c(String str) {
        return this.b.get(str) != null;
    }

    public l d(String str) {
        m0 m0Var = this.b.get(str);
        if (m0Var != null) {
            return m0Var.c;
        }
        return null;
    }

    public l e(String str) {
        for (m0 m0Var : this.b.values()) {
            if (m0Var != null) {
                l lVar = m0Var.c;
                if (!str.equals(lVar.f1631f)) {
                    lVar = lVar.u.c.e(str);
                }
                if (lVar != null) {
                    return lVar;
                }
            }
        }
        return null;
    }

    public int f(l lVar) {
        View view;
        View view2;
        ViewGroup viewGroup = lVar.E;
        if (viewGroup == null) {
            return -1;
        }
        int indexOf = this.a.indexOf(lVar);
        for (int i2 = indexOf - 1; i2 >= 0; i2--) {
            l lVar2 = this.a.get(i2);
            if (lVar2.E == viewGroup && (view2 = lVar2.F) != null) {
                return viewGroup.indexOfChild(view2) + 1;
            }
        }
        while (true) {
            indexOf++;
            if (indexOf >= this.a.size()) {
                return -1;
            }
            l lVar3 = this.a.get(indexOf);
            if (lVar3.E == viewGroup && (view = lVar3.F) != null) {
                return viewGroup.indexOfChild(view);
            }
        }
    }

    public List<m0> g() {
        ArrayList arrayList = new ArrayList();
        for (m0 m0Var : this.b.values()) {
            if (m0Var != null) {
                arrayList.add(m0Var);
            }
        }
        return arrayList;
    }

    public List<l> h() {
        ArrayList arrayList = new ArrayList();
        Iterator<m0> it = this.b.values().iterator();
        while (it.hasNext()) {
            m0 next = it.next();
            arrayList.add(next != null ? next.c : null);
        }
        return arrayList;
    }

    public m0 i(String str) {
        return this.b.get(str);
    }

    public List<l> j() {
        ArrayList arrayList;
        if (this.a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.a) {
            arrayList = new ArrayList(this.a);
        }
        return arrayList;
    }

    public void k(m0 m0Var) {
        l lVar = m0Var.c;
        if (!c(lVar.f1631f)) {
            this.b.put(lVar.f1631f, m0Var);
            if (f0.Q(2)) {
                String str = "Added fragment to active set " + lVar;
            }
        }
    }

    public void l(m0 m0Var) {
        l lVar = m0Var.c;
        if (lVar.B) {
            this.c.c(lVar);
        }
        if (this.b.put(lVar.f1631f, null) != null && f0.Q(2)) {
            String str = "Removed fragment from active set " + lVar;
        }
    }

    public void m(l lVar) {
        synchronized (this.a) {
            this.a.remove(lVar);
        }
        lVar.f1637l = false;
    }
}
