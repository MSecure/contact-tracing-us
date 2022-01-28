package e.b.i;

import c.b.a.a.c.n.c;
import e.b.h.b;

public class f {

    /* renamed from: c  reason: collision with root package name */
    public static final f f4882c = new f(false, false);

    /* renamed from: d  reason: collision with root package name */
    public static final f f4883d = new f(true, true);

    /* renamed from: a  reason: collision with root package name */
    public final boolean f4884a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f4885b;

    public f(boolean z, boolean z2) {
        this.f4884a = z;
        this.f4885b = z2;
    }

    public b a(b bVar) {
        if (bVar != null && !this.f4885b) {
            for (int i = 0; i < bVar.f4829b; i++) {
                String[] strArr = bVar.f4830c;
                strArr[i] = c.C1(strArr[i]);
            }
        }
        return bVar;
    }

    public String b(String str) {
        String trim = str.trim();
        return !this.f4884a ? c.C1(trim) : trim;
    }
}
