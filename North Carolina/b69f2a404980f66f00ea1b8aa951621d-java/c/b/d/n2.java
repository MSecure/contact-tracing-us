package c.b.d;

import java.util.List;

public class n2 extends RuntimeException {
    public n2() {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public n2(List<String> list) {
        super(r0.toString());
        StringBuilder sb = new StringBuilder("Message missing required fields: ");
        boolean z = true;
        for (String str : list) {
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append(str);
        }
    }
}
