package c.b.a.a.c.l;

import b.b.k.i;
import java.util.ArrayList;
import java.util.List;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    public final List<String> f2472a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final Object f2473b;

    public o(Object obj, i0 i0Var) {
        i.j.s(obj);
        this.f2473b = obj;
    }

    public final o a(String str, Object obj) {
        List<String> list = this.f2472a;
        i.j.s(str);
        String valueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(valueOf.length() + str.length() + 1);
        sb.append(str);
        sb.append("=");
        sb.append(valueOf);
        list.add(sb.toString());
        return this;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(100);
        sb.append(this.f2473b.getClass().getSimpleName());
        sb.append('{');
        int size = this.f2472a.size();
        for (int i = 0; i < size; i++) {
            sb.append(this.f2472a.get(i));
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
