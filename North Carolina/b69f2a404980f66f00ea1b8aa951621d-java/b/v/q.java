package b.v;

import android.view.View;
import c.a.a.a.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class q {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Object> f1823a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public View f1824b;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList<i> f1825c = new ArrayList<>();

    @Deprecated
    public q() {
    }

    public q(View view) {
        this.f1824b = view;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.f1824b == qVar.f1824b && this.f1823a.equals(qVar.f1823a);
    }

    public int hashCode() {
        return this.f1823a.hashCode() + (this.f1824b.hashCode() * 31);
    }

    public String toString() {
        StringBuilder g = a.g("TransitionValues@");
        g.append(Integer.toHexString(hashCode()));
        g.append(":\n");
        String o = a.o(g.toString() + "    view = " + this.f1824b + "\n", "    values:");
        for (String str : this.f1823a.keySet()) {
            o = o + "    " + str + ": " + this.f1823a.get(str) + "\n";
        }
        return o;
    }
}
