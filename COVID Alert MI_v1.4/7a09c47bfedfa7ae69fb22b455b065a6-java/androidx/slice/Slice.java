package androidx.slice;

import b.z.d;

public final class Slice implements d {

    /* renamed from: a  reason: collision with root package name */
    public SliceSpec f393a;

    /* renamed from: b  reason: collision with root package name */
    public SliceItem[] f394b = new SliceItem[0];

    /* renamed from: c  reason: collision with root package name */
    public String[] f395c = new String[0];

    /* renamed from: d  reason: collision with root package name */
    public String f396d;

    public static void a(StringBuilder sb, String[] strArr) {
        if (!(strArr == null || strArr.length == 0)) {
            sb.append('(');
            int length = strArr.length - 1;
            for (int i = 0; i < length; i++) {
                sb.append(strArr[i]);
                sb.append(", ");
            }
            sb.append(strArr[length]);
            sb.append(")");
        }
    }

    public String b(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("Slice ");
        String[] strArr = this.f395c;
        if (strArr.length > 0) {
            a(sb, strArr);
            sb.append(' ');
        }
        sb.append('[');
        sb.append(this.f396d);
        sb.append("] {\n");
        String str2 = str + "  ";
        int i = 0;
        while (true) {
            SliceItem[] sliceItemArr = this.f394b;
            if (i < sliceItemArr.length) {
                sb.append(sliceItemArr[i].d(str2));
                i++;
            } else {
                sb.append(str);
                sb.append('}');
                return sb.toString();
            }
        }
    }

    public String toString() {
        return b("");
    }
}
