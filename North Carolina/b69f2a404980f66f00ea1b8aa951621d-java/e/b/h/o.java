package e.b.h;

import e.b.h.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class o extends l {
    public o(String str) {
        this.f4860d = str;
    }

    public static boolean E(StringBuilder sb) {
        return sb.length() != 0 && sb.charAt(sb.length() - 1) == ' ';
    }

    /* renamed from: D */
    public o j() {
        return (o) super.clone();
    }

    @Override // e.b.h.m
    public String s() {
        return "#text";
    }

    @Override // e.b.h.m
    public String toString() {
        return t();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0061, code lost:
        if (e.b.g.b.e(B()) == false) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0063, code lost:
        q(r10, r11, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001e, code lost:
        if (e.b.g.b.e(B()) == false) goto L_0x0063;
     */
    @Override // e.b.h.m
    public void u(Appendable appendable, int i, f.a aVar) {
        List list;
        boolean z = aVar.f;
        if (z) {
            if (this.f4862c == 0) {
                m mVar = this.f4861b;
                if (mVar instanceof i) {
                    if (((i) mVar).f4846d.f4892e) {
                    }
                }
            }
            if (aVar.g) {
                m mVar2 = this.f4861b;
                if (mVar2 == null) {
                    list = Collections.emptyList();
                } else {
                    List<m> n = mVar2.n();
                    ArrayList arrayList = new ArrayList(n.size() - 1);
                    for (m mVar3 : n) {
                        if (mVar3 != this) {
                            arrayList.add(mVar3);
                        }
                    }
                    list = arrayList;
                }
                if (list.size() > 0) {
                }
            }
        }
        j.c(appendable, B(), aVar, false, z && !i.L(this.f4861b), z && (this.f4861b instanceof f));
    }

    @Override // e.b.h.m
    public void v(Appendable appendable, int i, f.a aVar) {
    }
}
