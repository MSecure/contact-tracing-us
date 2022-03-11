package h.a.j1;

import java.util.ArrayList;
/* loaded from: classes.dex */
public final class y0 {
    public final ArrayList<String> a = new ArrayList<>();

    public y0 a(Object obj) {
        this.a.add(String.valueOf(obj));
        return this;
    }

    public y0 b(String str, Object obj) {
        ArrayList<String> arrayList = this.a;
        arrayList.add(str + "=" + obj);
        return this;
    }

    public String toString() {
        return this.a.toString();
    }
}
