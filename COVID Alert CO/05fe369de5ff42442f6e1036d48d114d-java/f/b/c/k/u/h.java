package f.b.c.k.u;

import f.a.a.a.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class h extends a<h> {
    public static final h c = new h(Collections.singletonList("__name__"));

    /* renamed from: d  reason: collision with root package name */
    public static final h f3309d = new h(Collections.emptyList());

    public h(List<String> list) {
        super(list);
    }

    public static h r(String str) {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        boolean z = false;
        while (i2 < str.length()) {
            char charAt = str.charAt(i2);
            if (charAt == '\\') {
                i2++;
                if (i2 != str.length()) {
                    charAt = str.charAt(i2);
                } else {
                    throw new IllegalArgumentException("Trailing escape character is not allowed");
                }
            } else if (charAt == '.') {
                if (!z) {
                    String sb2 = sb.toString();
                    if (!sb2.isEmpty()) {
                        StringBuilder sb3 = new StringBuilder();
                        arrayList.add(sb2);
                        sb = sb3;
                        i2++;
                    } else {
                        throw new IllegalArgumentException(a.d("Invalid field path (", str, "). Paths must not be empty, begin with '.', end with '.', or contain '..'"));
                    }
                }
            } else if (charAt == '`') {
                z = !z;
                i2++;
            }
            sb.append(charAt);
            i2++;
        }
        String sb4 = sb.toString();
        if (!sb4.isEmpty()) {
            arrayList.add(sb4);
            return new h(arrayList);
        }
        throw new IllegalArgumentException(a.d("Invalid field path (", str, "). Paths must not be empty, begin with '.', end with '.', or contain '..'"));
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0087 A[SYNTHETIC] */
    @Override // f.b.c.k.u.a
    public String c() {
        char charAt;
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            if (i2 > 0) {
                sb.append(".");
            }
            String replace = this.b.get(i2).replace("\\", "\\\\").replace("`", "\\`");
            boolean z = true;
            if (!replace.isEmpty() && ((charAt = replace.charAt(0)) == '_' || ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')))) {
                int i3 = 1;
                while (true) {
                    if (i3 >= replace.length()) {
                        break;
                    }
                    char charAt2 = replace.charAt(i3);
                    if (charAt2 != '_' && ((charAt2 < 'a' || charAt2 > 'z') && ((charAt2 < 'A' || charAt2 > 'Z') && (charAt2 < '0' || charAt2 > '9')))) {
                        break;
                    }
                    i3++;
                }
                if (z) {
                    replace = '`' + replace + '`';
                }
                sb.append(replace);
            }
            z = false;
            if (z) {
            }
            sb.append(replace);
        }
        return sb.toString();
    }

    /* Return type fixed from 'f.b.c.k.u.a' to match base method */
    @Override // f.b.c.k.u.a
    public h f(List list) {
        return new h(list);
    }

    public boolean s() {
        return equals(c);
    }
}
