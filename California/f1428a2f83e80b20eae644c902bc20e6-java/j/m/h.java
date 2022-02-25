package j.m;

import f.b.a.c.b.o.b;
import j.j.b.e;
import j.k.a;
import j.k.c;
import j.l.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class h extends g {
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0029 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    public static final boolean a(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        e.c(charSequence, "$this$contains");
        e.c(charSequence2, "other");
        if (charSequence2 instanceof String) {
            if (d(charSequence, (String) charSequence2, 0, z) >= 0) {
                return true;
            }
            return false;
        } else if (f(charSequence, charSequence2, 0, charSequence.length(), z, false, 16) < 0) {
            return false;
        }
        return true;
    }

    public static final boolean b(String str, String str2, boolean z) {
        return str == null ? str2 == null : !z ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public static final int c(CharSequence charSequence) {
        e.c(charSequence, "$this$lastIndex");
        return charSequence.length() - 1;
    }

    public static final int d(CharSequence charSequence, String str, int i2, boolean z) {
        e.c(charSequence, "$this$indexOf");
        e.c(str, "string");
        return (z || !(charSequence instanceof String)) ? f(charSequence, str, i2, charSequence.length(), z, false, 16) : ((String) charSequence).indexOf(str, i2);
    }

    public static final int e(CharSequence charSequence, CharSequence charSequence2, int i2, int i3, boolean z, boolean z2) {
        a aVar;
        if (!z2) {
            if (i2 < 0) {
                i2 = 0;
            }
            int length = charSequence.length();
            if (i3 > length) {
                i3 = length;
            }
            aVar = new c(i2, i3);
        } else {
            int c = c(charSequence);
            if (i2 > c) {
                i2 = c;
            }
            if (i3 < 0) {
                i3 = 0;
            }
            aVar = new a(i2, i3, -1);
        }
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            int i4 = aVar.b;
            int i5 = aVar.c;
            int i6 = aVar.f3992d;
            if (i6 < 0 ? i4 >= i5 : i4 <= i5) {
                while (!k(charSequence2, 0, charSequence, i4, charSequence2.length(), z)) {
                    if (i4 != i5) {
                        i4 += i6;
                    }
                }
                return i4;
            }
        } else {
            int i7 = aVar.b;
            int i8 = aVar.c;
            int i9 = aVar.f3992d;
            if (i9 < 0 ? i7 >= i8 : i7 <= i8) {
                while (!j((String) charSequence2, 0, (String) charSequence, i7, charSequence2.length(), z)) {
                    if (i7 != i8) {
                        i7 += i9;
                    }
                }
                return i7;
            }
        }
        return -1;
    }

    public static /* synthetic */ int f(CharSequence charSequence, CharSequence charSequence2, int i2, int i3, boolean z, boolean z2, int i4) {
        return e(charSequence, charSequence2, i2, i3, z, (i4 & 16) != 0 ? false : z2);
    }

    public static int g(CharSequence charSequence, char c, int i2, boolean z, int i3) {
        boolean z2;
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        e.c(charSequence, "$this$indexOf");
        if (!z) {
            return ((String) charSequence).indexOf(c, i2);
        }
        char[] cArr = {c};
        e.c(charSequence, "$this$indexOfAny");
        e.c(cArr, "chars");
        if (!z) {
            return ((String) charSequence).indexOf(b.P1(cArr), i2);
        }
        if (i2 < 0) {
            i2 = 0;
        }
        int c2 = c(charSequence);
        if (i2 <= c2) {
            while (true) {
                char charAt = charSequence.charAt(i2);
                int i4 = 0;
                while (true) {
                    if (i4 >= 1) {
                        z2 = false;
                        break;
                    } else if (b.u0(cArr[i4], charAt, z)) {
                        z2 = true;
                        break;
                    } else {
                        i4++;
                    }
                }
                if (!z2) {
                    if (i2 == c2) {
                        break;
                    }
                    i2++;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public static final boolean h(CharSequence charSequence) {
        boolean z;
        boolean z2;
        e.c(charSequence, "$this$isBlank");
        if (charSequence.length() == 0) {
            return true;
        }
        e.c(charSequence, "$this$indices");
        c cVar = new c(0, charSequence.length() - 1);
        if (!(cVar instanceof Collection) || !((Collection) cVar).isEmpty()) {
            Iterator it = cVar.iterator();
            while (true) {
                if (!((j.k.b) it).c) {
                    break;
                }
                char charAt = charSequence.charAt(((j.h.e) it).b());
                if (Character.isWhitespace(charAt) || Character.isSpaceChar(charAt)) {
                    z2 = true;
                    continue;
                } else {
                    z2 = false;
                    continue;
                }
                if (!z2) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z) {
            return true;
        }
        return false;
    }

    public static j.l.b i(CharSequence charSequence, String[] strArr, int i2, boolean z, int i3, int i4) {
        boolean z2 = false;
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        if ((i4 & 8) != 0) {
            i3 = 0;
        }
        if (i3 >= 0) {
            z2 = true;
        }
        if (z2) {
            e.c(strArr, "$this$asList");
            List asList = Arrays.asList(strArr);
            e.b(asList, "ArraysUtilJVM.asList(this)");
            return new b(charSequence, i2, i3, new i(asList, z));
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i3 + '.').toString());
    }

    public static final boolean j(String str, int i2, String str2, int i3, int i4, boolean z) {
        e.c(str, "$this$regionMatches");
        e.c(str2, "other");
        return !z ? str.regionMatches(i2, str2, i3, i4) : str.regionMatches(z, i2, str2, i3, i4);
    }

    public static final boolean k(CharSequence charSequence, int i2, CharSequence charSequence2, int i3, int i4, boolean z) {
        e.c(charSequence, "$this$regionMatchesImpl");
        e.c(charSequence2, "other");
        if (i3 < 0 || i2 < 0 || i2 > charSequence.length() - i4 || i3 > charSequence2.length() - i4) {
            return false;
        }
        for (int i5 = 0; i5 < i4; i5++) {
            if (!b.u0(charSequence.charAt(i2 + i5), charSequence2.charAt(i3 + i5), z)) {
                return false;
            }
        }
        return true;
    }

    public static final String l(String str, CharSequence charSequence) {
        e.c(str, "$this$removePrefix");
        e.c(charSequence, "prefix");
        e.c(str, "$this$startsWith");
        e.c(charSequence, "prefix");
        if (!o(str, (String) charSequence, false, 2)) {
            return str;
        }
        String substring = str.substring(charSequence.length());
        e.b(substring, "(this as java.lang.String).substring(startIndex)");
        return substring;
    }

    public static String m(String str, String str2, String str3, boolean z, int i2) {
        CharSequence charSequence;
        int i3 = 0;
        boolean z2 = (i2 & 4) != 0 ? false : z;
        e.c(str, "$this$replace");
        e.c(str2, "oldValue");
        e.c(str3, "newValue");
        String[] strArr = {str2};
        e.c(str, "$this$splitToSequence");
        e.c(strArr, "delimiters");
        j.l.b i4 = i(str, strArr, 0, z2, 0, 2);
        j jVar = new j(str);
        e.c(i4, "$this$map");
        e.c(jVar, "transform");
        d dVar = new d(i4, jVar);
        e.c(dVar, "$this$joinToString");
        e.c(str3, "separator");
        e.c("", "prefix");
        e.c("", "postfix");
        e.c("...", "truncated");
        StringBuilder sb = new StringBuilder();
        e.c(dVar, "$this$joinTo");
        e.c(sb, "buffer");
        e.c(str3, "separator");
        e.c("", "prefix");
        e.c("", "postfix");
        e.c("...", "truncated");
        sb.append((CharSequence) "");
        Iterator it = dVar.iterator();
        while (true) {
            d.a aVar = (d.a) it;
            if (aVar.hasNext()) {
                Object next = aVar.next();
                i3++;
                if (i3 > 1) {
                    sb.append((CharSequence) str3);
                }
                e.c(sb, "$this$appendElement");
                if (next != null ? next instanceof CharSequence : true) {
                    charSequence = (CharSequence) next;
                } else if (next instanceof Character) {
                    sb.append(((Character) next).charValue());
                } else {
                    charSequence = String.valueOf(next);
                }
                sb.append(charSequence);
            } else {
                sb.append((CharSequence) "");
                String sb2 = sb.toString();
                e.b(sb2, "joinTo(StringBuilder(), …ed, transform).toString()");
                return sb2;
            }
        }
    }

    public static List n(CharSequence charSequence, String[] strArr, boolean z, int i2, int i3) {
        int i4 = 0;
        boolean z2 = (i3 & 2) != 0 ? false : z;
        int i5 = (i3 & 4) != 0 ? 0 : i2;
        e.c(charSequence, "$this$split");
        e.c(strArr, "delimiters");
        int i6 = 10;
        boolean z3 = true;
        if (strArr.length == 1) {
            String str = strArr[0];
            if (!(str.length() == 0)) {
                if (i5 >= 0) {
                    int d2 = d(charSequence, str, 0, z2);
                    if (d2 == -1 || i5 == 1) {
                        return b.p1(charSequence.toString());
                    }
                    if (i5 <= 0) {
                        z3 = false;
                    }
                    if (z3 && i5 <= 10) {
                        i6 = i5;
                    }
                    ArrayList arrayList = new ArrayList(i6);
                    do {
                        arrayList.add(charSequence.subSequence(i4, d2).toString());
                        i4 = str.length() + d2;
                        if (z3 && arrayList.size() == i5 - 1) {
                            break;
                        }
                        d2 = d(charSequence, str, i4, z2);
                    } while (d2 != -1);
                    arrayList.add(charSequence.subSequence(i4, charSequence.length()).toString());
                    return arrayList;
                }
                throw new IllegalArgumentException(("Limit must be non-negative, but was " + i5 + '.').toString());
            }
        }
        j.l.b i7 = i(charSequence, strArr, 0, z2, i5, 2);
        e.c(i7, "$this$asIterable");
        j.l.c cVar = new j.l.c(i7);
        e.c(cVar, "$this$collectionSizeOrDefault");
        if (cVar instanceof Collection) {
            i6 = ((Collection) cVar).size();
        }
        ArrayList arrayList2 = new ArrayList(i6);
        Iterator it = cVar.iterator();
        while (it.hasNext()) {
            arrayList2.add(p(charSequence, (c) it.next()));
        }
        return arrayList2;
    }

    public static boolean o(String str, String str2, boolean z, int i2) {
        boolean z2 = (i2 & 2) != 0 ? false : z;
        e.c(str, "$this$startsWith");
        e.c(str2, "prefix");
        return !z2 ? str.startsWith(str2) : j(str, 0, str2, 0, str2.length(), z2);
    }

    public static final String p(CharSequence charSequence, c cVar) {
        e.c(charSequence, "$this$substring");
        e.c(cVar, "range");
        return charSequence.subSequence(Integer.valueOf(cVar.b).intValue(), Integer.valueOf(cVar.c).intValue() + 1).toString();
    }
}
