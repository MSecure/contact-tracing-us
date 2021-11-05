package b.l.d;

import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class y {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<Fragment> f1363a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<String, w> f1364b = new HashMap<>();

    public void a(Fragment fragment) {
        if (!this.f1363a.contains(fragment)) {
            synchronized (this.f1363a) {
                this.f1363a.add(fragment);
            }
            fragment.mAdded = true;
            return;
        }
        throw new IllegalStateException("Fragment already added: " + fragment);
    }

    public void b() {
        this.f1364b.values().removeAll(Collections.singleton(null));
    }

    public boolean c(String str) {
        return this.f1364b.containsKey(str);
    }

    public void d(int i) {
        Iterator<Fragment> it = this.f1363a.iterator();
        while (it.hasNext()) {
            w wVar = this.f1364b.get(it.next().mWho);
            if (wVar != null) {
                wVar.f1362c = i;
            }
        }
        for (w wVar2 : this.f1364b.values()) {
            if (wVar2 != null) {
                wVar2.f1362c = i;
            }
        }
    }

    public Fragment e(String str) {
        w wVar = this.f1364b.get(str);
        if (wVar != null) {
            return wVar.f1361b;
        }
        return null;
    }

    public List<Fragment> f() {
        ArrayList arrayList = new ArrayList();
        Iterator<w> it = this.f1364b.values().iterator();
        while (it.hasNext()) {
            w next = it.next();
            arrayList.add(next != null ? next.f1361b : null);
        }
        return arrayList;
    }

    public List<Fragment> g() {
        ArrayList arrayList;
        if (this.f1363a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f1363a) {
            arrayList = new ArrayList(this.f1363a);
        }
        return arrayList;
    }

    public void h(Fragment fragment) {
        synchronized (this.f1363a) {
            this.f1363a.remove(fragment);
        }
        fragment.mAdded = false;
    }
}
