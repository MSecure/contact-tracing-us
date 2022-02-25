package e.m.a;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class k0 {
    public final ArrayList<l> a = new ArrayList<>();
    public final HashMap<String, j0> b = new HashMap<>();
    public g0 c;

    public void a(l lVar) {
        if (!this.a.contains(lVar)) {
            synchronized (this.a) {
                this.a.add(lVar);
            }
            lVar.f1626l = true;
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
        j0 j0Var = this.b.get(str);
        if (j0Var != null) {
            return j0Var.c;
        }
        return null;
    }

    public l e(String str) {
        for (j0 j0Var : this.b.values()) {
            if (j0Var != null) {
                l lVar = j0Var.c;
                if (!str.equals(lVar.f1620f)) {
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

    public List<j0> g() {
        ArrayList arrayList = new ArrayList();
        for (j0 j0Var : this.b.values()) {
            if (j0Var != null) {
                arrayList.add(j0Var);
            }
        }
        return arrayList;
    }

    public List<l> h() {
        ArrayList arrayList = new ArrayList();
        Iterator<j0> it = this.b.values().iterator();
        while (it.hasNext()) {
            j0 next = it.next();
            arrayList.add(next != null ? next.c : null);
        }
        return arrayList;
    }

    public j0 i(String str) {
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

    public void k(j0 j0Var) {
        l lVar = j0Var.c;
        if (!c(lVar.f1620f)) {
            this.b.put(lVar.f1620f, j0Var);
            if (c0.Q(2)) {
                String str = "Added fragment to active set " + lVar;
            }
        }
    }

    public void l(j0 j0Var) {
        l lVar = j0Var.c;
        if (lVar.B) {
            this.c.c(lVar);
        }
        if (this.b.put(lVar.f1620f, null) != null && c0.Q(2)) {
            String str = "Removed fragment from active set " + lVar;
        }
    }

    public void m(l lVar) {
        synchronized (this.a) {
            this.a.remove(lVar);
        }
        lVar.f1626l = false;
    }
}
