package b.l.d;

import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class h0 {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<Fragment> f2029a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<String, g0> f2030b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public c0 f2031c;

    public void a(Fragment fragment) {
        if (!this.f2029a.contains(fragment)) {
            synchronized (this.f2029a) {
                this.f2029a.add(fragment);
            }
            fragment.mAdded = true;
            return;
        }
        throw new IllegalStateException("Fragment already added: " + fragment);
    }

    public void b() {
        this.f2030b.values().removeAll(Collections.singleton(null));
    }

    public boolean c(String str) {
        return this.f2030b.get(str) != null;
    }

    public Fragment d(String str) {
        g0 g0Var = this.f2030b.get(str);
        if (g0Var != null) {
            return g0Var.f2021c;
        }
        return null;
    }

    public Fragment e(String str) {
        Fragment findFragmentByWho;
        for (g0 g0Var : this.f2030b.values()) {
            if (!(g0Var == null || (findFragmentByWho = g0Var.f2021c.findFragmentByWho(str)) == null)) {
                return findFragmentByWho;
            }
        }
        return null;
    }

    public List<g0> f() {
        ArrayList arrayList = new ArrayList();
        for (g0 g0Var : this.f2030b.values()) {
            if (g0Var != null) {
                arrayList.add(g0Var);
            }
        }
        return arrayList;
    }

    public List<Fragment> g() {
        ArrayList arrayList = new ArrayList();
        Iterator<g0> it = this.f2030b.values().iterator();
        while (it.hasNext()) {
            g0 next = it.next();
            arrayList.add(next != null ? next.f2021c : null);
        }
        return arrayList;
    }

    public g0 h(String str) {
        return this.f2030b.get(str);
    }

    public List<Fragment> i() {
        ArrayList arrayList;
        if (this.f2029a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f2029a) {
            arrayList = new ArrayList(this.f2029a);
        }
        return arrayList;
    }

    public void j(g0 g0Var) {
        Fragment fragment = g0Var.f2021c;
        if (!c(fragment.mWho)) {
            this.f2030b.put(fragment.mWho, g0Var);
            if (fragment.mRetainInstanceChangedWhileDetached) {
                if (fragment.mRetainInstance) {
                    this.f2031c.a(fragment);
                } else {
                    this.f2031c.b(fragment);
                }
                fragment.mRetainInstanceChangedWhileDetached = false;
            }
            if (z.P(2)) {
                String str = "Added fragment to active set " + fragment;
            }
        }
    }

    public void k(g0 g0Var) {
        Fragment fragment = g0Var.f2021c;
        if (fragment.mRetainInstance) {
            this.f2031c.b(fragment);
        }
        if (this.f2030b.put(fragment.mWho, null) != null && z.P(2)) {
            String str = "Removed fragment from active set " + fragment;
        }
    }

    public void l(Fragment fragment) {
        synchronized (this.f2029a) {
            this.f2029a.remove(fragment);
        }
        fragment.mAdded = false;
    }
}
