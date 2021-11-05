package c.b.a.a.d.m;

import androidx.annotation.RecentlyNonNull;
import b.x.t;
import java.util.ArrayList;
import java.util.List;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    public final List<String> f3141a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final Object f3142b;

    public m(Object obj, m0 m0Var) {
        t.C(obj);
        this.f3142b = obj;
    }

    @RecentlyNonNull
    public final m a(@RecentlyNonNull String str, Object obj) {
        List<String> list = this.f3141a;
        t.C(str);
        String valueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(valueOf.length() + str.length() + 1);
        sb.append(str);
        sb.append("=");
        sb.append(valueOf);
        list.add(sb.toString());
        return this;
    }

    @RecentlyNonNull
    public final String toString() {
        StringBuilder sb = new StringBuilder(100);
        sb.append(this.f3142b.getClass().getSimpleName());
        sb.append('{');
        int size = this.f3141a.size();
        for (int i = 0; i < size; i++) {
            sb.append(this.f3141a.get(i));
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
