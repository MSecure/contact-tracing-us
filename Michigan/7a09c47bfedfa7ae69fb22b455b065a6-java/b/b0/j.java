package b.b0;

import c.a.a.a.a;
import java.util.List;

public abstract class j {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1038a = m.e("InputMerger");

    public static j a(String str) {
        try {
            return (j) Class.forName(str).newInstance();
        } catch (Exception e2) {
            m.c().b(f1038a, a.q("Trouble instantiating + ", str), e2);
            return null;
        }
    }

    public abstract e b(List<e> list);
}
