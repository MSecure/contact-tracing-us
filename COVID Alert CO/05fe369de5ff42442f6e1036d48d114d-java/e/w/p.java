package e.w;

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
        StringBuilder i2 = a.i("TransitionValues@");
        i2.append(Integer.toHexString(hashCode()));
        i2.append(":\n");
        StringBuilder j2 = a.j(i2.toString(), "    view = ");
        j2.append(this.b);
        j2.append("\n");
        String c2 = a.c(j2.toString(), "    values:");
        for (String str : this.a.keySet()) {
            c2 = c2 + "    " + str + ": " + this.a.get(str) + "\n";
        }
        return c2;
    }
}
