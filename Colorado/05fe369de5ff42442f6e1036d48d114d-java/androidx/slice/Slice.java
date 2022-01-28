package androidx.slice;

import e.y.d;
import f.a.a.a.a;

public final class Slice implements d {
    public SliceSpec a;
    public SliceItem[] b = new SliceItem[0];
    public String[] c = new String[0];

    /* renamed from: d  reason: collision with root package name */
    public String f291d;

    public static void a(StringBuilder sb, String[] strArr) {
        if (!(strArr == null || strArr.length == 0)) {
            sb.append('(');
            int length = strArr.length - 1;
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(strArr[i2]);
                sb.append(", ");
            }
            sb.append(strArr[length]);
            sb.append(")");
        }
    }

    public String b(String str) {
        StringBuilder j2 = a.j(str, "Slice ");
        String[] strArr = this.c;
        if (strArr.length > 0) {
            a(j2, strArr);
            j2.append(' ');
        }
        j2.append('[');
        j2.append(this.f291d);
        j2.append("] {\n");
        String str2 = str + "  ";
        int i2 = 0;
        while (true) {
            SliceItem[] sliceItemArr = this.b;
            if (i2 < sliceItemArr.length) {
                j2.append(sliceItemArr[i2].d(str2));
                i2++;
            } else {
                j2.append(str);
                j2.append('}');
                return j2.toString();
            }
        }
    }

    public String toString() {
        return b("");
    }
}
