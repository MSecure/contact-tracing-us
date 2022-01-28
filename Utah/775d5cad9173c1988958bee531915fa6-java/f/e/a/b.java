package f.e.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import k.e;

public final class b {
    public final String a;
    public final int b;
    public final List<String> c;

    /* renamed from: d  reason: collision with root package name */
    public final String f3803d;

    /* renamed from: f.e.a.b$b  reason: collision with other inner class name */
    public static final class C0136b {
        public String a;
        public String b;
        public int c = -1;

        /* renamed from: d  reason: collision with root package name */
        public final List<String> f3804d;

        public C0136b() {
            ArrayList arrayList = new ArrayList();
            this.f3804d = arrayList;
            arrayList.add("");
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append("://");
            if (this.b.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.b);
                sb.append(']');
            } else {
                sb.append(this.b);
            }
            int i2 = this.c;
            if (i2 == -1) {
                i2 = b.b(this.a);
            }
            if (i2 != b.b(this.a)) {
                sb.append(':');
                sb.append(i2);
            }
            List<String> list = this.f3804d;
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                sb.append('/');
                sb.append(list.get(i3));
            }
            return sb.toString();
        }
    }

    public b(C0136b bVar, a aVar) {
        c("", 0, 0, false);
        c("", 0, 0, false);
        this.a = bVar.b;
        int i2 = bVar.c;
        this.b = i2 == -1 ? b(bVar.a) : i2;
        this.c = d(bVar.f3804d, false);
        this.f3803d = bVar.toString();
    }

    public static int a(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        char c3 = 'a';
        if (c2 < 'a' || c2 > 'f') {
            c3 = 'A';
            if (c2 < 'A' || c2 > 'F') {
                return -1;
            }
        }
        return (c2 - c3) + 10;
    }

    public static int b(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    public static String c(String str, int i2, int i3, boolean z) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8 = i2;
        while (i8 < i3) {
            char charAt = str.charAt(i8);
            if (charAt == '%' || (charAt == '+' && z)) {
                e eVar = new e();
                eVar.Z(str, i2, i8);
                while (i8 < i3) {
                    int codePointAt = str.codePointAt(i8);
                    if (codePointAt == 37 && (i7 = i8 + 2) < i3) {
                        int a2 = a(str.charAt(i8 + 1));
                        int a3 = a(str.charAt(i7));
                        if (!(a2 == -1 || a3 == -1)) {
                            eVar.V((a2 << 4) + a3);
                            i8 = i7;
                            i8 += Character.charCount(codePointAt);
                        }
                    } else if (codePointAt == 43 && z) {
                        eVar.V(32);
                        i8 += Character.charCount(codePointAt);
                    }
                    if (codePointAt < 128) {
                        i4 = codePointAt;
                    } else {
                        if (codePointAt < 2048) {
                            i5 = (codePointAt >> 6) | 192;
                        } else {
                            if (codePointAt < 65536) {
                                if (codePointAt < 55296 || codePointAt > 57343) {
                                    i6 = (codePointAt >> 12) | 224;
                                } else {
                                    eVar.V(63);
                                    i8 += Character.charCount(codePointAt);
                                }
                            } else if (codePointAt <= 1114111) {
                                eVar.V((codePointAt >> 18) | 240);
                                i6 = ((codePointAt >> 12) & 63) | 128;
                            } else {
                                StringBuilder h2 = f.a.a.a.a.h("Unexpected code point: ");
                                h2.append(Integer.toHexString(codePointAt));
                                throw new IllegalArgumentException(h2.toString());
                            }
                            eVar.V(i6);
                            i5 = ((codePointAt >> 6) & 63) | 128;
                        }
                        eVar.V(i5);
                        i4 = 128 | (codePointAt & 63);
                    }
                    eVar.V(i4);
                    i8 += Character.charCount(codePointAt);
                }
                return eVar.L();
            }
            i8++;
        }
        return str.substring(i2, i3);
    }

    public final List<String> d(List<String> list, boolean z) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            arrayList.add(next != null ? c(next, 0, next.length(), z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public boolean equals(Object obj) {
        return (obj instanceof b) && ((b) obj).f3803d.equals(this.f3803d);
    }

    public int hashCode() {
        return this.f3803d.hashCode();
    }

    public String toString() {
        return this.f3803d;
    }
}
