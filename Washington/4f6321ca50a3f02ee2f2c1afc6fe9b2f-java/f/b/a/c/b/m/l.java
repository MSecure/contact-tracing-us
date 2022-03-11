package f.b.a.c.b.m;

import androidx.annotation.RecentlyNonNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class l {
    public final List<String> a = new ArrayList();
    public final Object b;

    public l(Object obj, k0 k0Var) {
        Objects.requireNonNull(obj, "null reference");
        this.b = obj;
    }

    @RecentlyNonNull
    public final l a(@RecentlyNonNull String str, Object obj) {
        List<String> list = this.a;
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
        sb.append(this.b.getClass().getSimpleName());
        sb.append('{');
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            sb.append(this.a.get(i2));
            if (i2 < size - 1) {
                sb.append(", ");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
