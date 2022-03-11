package androidx.slice;

import e.b0.d;
import f.a.a.a.a;
/* loaded from: classes.dex */
public final class Slice implements d {
    public SliceSpec a;
    public SliceItem[] b = new SliceItem[0];
    public String[] c = new String[0];

    /* renamed from: d */
    public String f292d;

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
        StringBuilder i2 = a.i(str, "Slice ");
        String[] strArr = this.c;
        if (strArr.length > 0) {
            a(i2, strArr);
            i2.append(' ');
        }
        i2.append('[');
        i2.append(this.f292d);
        i2.append("] {\n");
        String str2 = str + "  ";
        int i3 = 0;
        while (true) {
            SliceItem[] sliceItemArr = this.b;
            if (i3 < sliceItemArr.length) {
                i2.append(sliceItemArr[i3].d(str2));
                i3++;
            } else {
                i2.append(str);
                i2.append('}');
                return i2.toString();
            }
        }
    }

    public String toString() {
        return b("");
    }
}
