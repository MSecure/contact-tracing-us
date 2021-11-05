package b.x;

import android.view.View;
import c.a.a.a.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class q {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Object> f2712a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public View f2713b;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList<i> f2714c = new ArrayList<>();

    @Deprecated
    public q() {
    }

    public q(View view) {
        this.f2713b = view;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.f2713b == qVar.f2713b && this.f2712a.equals(qVar.f2712a);
    }

    public int hashCode() {
        return this.f2712a.hashCode() + (this.f2713b.hashCode() * 31);
    }

    public String toString() {
        StringBuilder h = a.h("TransitionValues@");
        h.append(Integer.toHexString(hashCode()));
        h.append(":\n");
        String q = a.q(h.toString() + "    view = " + this.f2713b + "\n", "    values:");
        for (String str : this.f2712a.keySet()) {
            q = q + "    " + str + ": " + this.f2712a.get(str) + "\n";
        }
        return q;
    }
}
