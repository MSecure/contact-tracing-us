package e.y;

import android.view.View;
import f.a.a.a.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class p {
    public final Map<String, Object> a = new HashMap();
    public View b;
    public final ArrayList<h> c = new ArrayList<>();

    @Deprecated
    public p() {
    }

    public p(View view) {
        this.b = view;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return this.b == pVar.b && this.a.equals(pVar.a);
    }

    public int hashCode() {
        return this.a.hashCode() + (this.b.hashCode() * 31);
    }

    public String toString() {
        StringBuilder h2 = a.h("TransitionValues@");
        h2.append(Integer.toHexString(hashCode()));
        h2.append(":\n");
        StringBuilder i2 = a.i(h2.toString(), "    view = ");
        i2.append(this.b);
        i2.append("\n");
        String w = a.w(i2.toString(), "    values:");
        for (String str : this.a.keySet()) {
            w = w + "    " + str + ": " + this.a.get(str) + "\n";
        }
        return w;
    }
}
