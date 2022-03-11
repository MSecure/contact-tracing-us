package e.c0;

import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public abstract class w {
    public abstract q a();

    public abstract q b(String str);

    public final q c(x xVar) {
        return d(Collections.singletonList(xVar));
    }

    public abstract q d(List<? extends x> list);

    public abstract q e(String str, g gVar, s sVar);

    public q f(String str, h hVar, p pVar) {
        return g(str, hVar, Collections.singletonList(pVar));
    }

    public abstract q g(String str, h hVar, List<p> list);
}
