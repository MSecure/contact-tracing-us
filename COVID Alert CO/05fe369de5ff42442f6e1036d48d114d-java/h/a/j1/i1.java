package h.a.j1;

import f.a.a.a.a;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class i1 {
    public static final long a = TimeUnit.SECONDS.toNanos(1);
    public static final /* synthetic */ int b = 0;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.List<?> */
    /* JADX WARN: Multi-variable type inference failed */
    public static List<Map<String, ?>> a(List<?> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (!(list.get(i2) instanceof Map)) {
                throw new ClassCastException(String.format("value %s for idx %d in %s is not object", list.get(i2), Integer.valueOf(i2), list));
            }
        }
        return list;
    }

    public static List<?> b(Map<String, ?> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (obj instanceof List) {
            return (List) obj;
        }
        throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not List", obj, str, map));
    }

    public static List<String> c(Map<String, ?> map, String str) {
        List b2 = b(map, str);
        if (b2 == null) {
            return null;
        }
        for (int i2 = 0; i2 < b2.size(); i2++) {
            if (!(b2.get(i2) instanceof String)) {
                throw new ClassCastException(String.format("value '%s' for idx %d in '%s' is not string", b2.get(i2), Integer.valueOf(i2), b2));
            }
        }
        return b2;
    }

    public static Double d(Map<String, ?> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (obj instanceof Double) {
            return (Double) obj;
        }
        throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not Double", obj, str, map));
    }

    public static Integer e(Map<String, ?> map, String str) {
        Double d2 = d(map, str);
        if (d2 == null) {
            return null;
        }
        int intValue = d2.intValue();
        if (((double) intValue) == d2.doubleValue()) {
            return Integer.valueOf(intValue);
        }
        throw new ClassCastException("Number expected to be integer: " + d2);
    }

    public static Map<String, ?> f(Map<String, ?> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (obj instanceof Map) {
            return (Map) obj;
        }
        throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not object", obj, str, map));
    }

    public static String g(Map<String, ?> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not String", obj, str, map));
    }

    public static Long h(Map<String, ?> map, String str) {
        String g2 = g(map, str);
        if (g2 == null) {
            return null;
        }
        try {
            return Long.valueOf(j(g2));
        } catch (ParseException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00a2  */
    public static long i(long j2, int i2) {
        long j3;
        int i3;
        boolean z;
        int i4;
        long j4 = (long) i2;
        long j5 = a;
        boolean z2 = false;
        if (j4 <= (-j5) || j4 >= j5) {
            long j6 = j4 / j5;
            j3 = j2 + j6;
            if (((j2 ^ j6) < 0) || ((j2 ^ j3) >= 0)) {
                i3 = (int) (j4 % j5);
            } else {
                throw new ArithmeticException("overflow: " + "checkedAdd" + "(" + j2 + ", " + j6 + ")");
            }
        } else {
            j3 = j2;
            i3 = i2;
        }
        if (j3 > 0 && i3 < 0) {
            i3 = (int) (((long) i3) + j5);
            j3--;
        }
        if (j3 < 0 && i3 > 0) {
            i3 = (int) (((long) i3) - j5);
            j3++;
        }
        if (j3 >= -315576000000L && j3 <= 315576000000L) {
            long j7 = (long) i3;
            if (j7 >= -999999999 && j7 < j5 && ((j3 >= 0 && i3 >= 0) || (i4 <= 0 && i3 <= 0))) {
                z = true;
                if (!z) {
                    long nanos = TimeUnit.SECONDS.toNanos(j3);
                    long j8 = (long) i3;
                    long j9 = nanos + j8;
                    boolean z3 = (j8 ^ nanos) < 0;
                    if ((nanos ^ j9) >= 0) {
                        z2 = true;
                    }
                    return z3 | z2 ? j9 : ((j9 >>> 63) ^ 1) + Long.MAX_VALUE;
                }
                throw new IllegalArgumentException(String.format("Duration is not valid. See proto definition for valid values. Seconds (%s) must be in range [-315,576,000,000, +315,576,000,000]. Nanos (%s) must be in range [-999,999,999, +999,999,999]. Nanos must have the same sign as seconds", Long.valueOf(j3), Integer.valueOf(i3)));
            }
        }
        z = false;
        if (!z) {
        }
    }

    public static long j(String str) {
        boolean z;
        String str2;
        int i2;
        if (str.isEmpty() || str.charAt(str.length() - 1) != 's') {
            throw new ParseException(a.c("Invalid duration string: ", str), 0);
        }
        if (str.charAt(0) == '-') {
            str = str.substring(1);
            z = true;
        } else {
            z = false;
        }
        String substring = str.substring(0, str.length() - 1);
        int indexOf = substring.indexOf(46);
        if (indexOf != -1) {
            str2 = substring.substring(indexOf + 1);
            substring = substring.substring(0, indexOf);
        } else {
            str2 = "";
        }
        long parseLong = Long.parseLong(substring);
        if (str2.isEmpty()) {
            i2 = 0;
        } else {
            int i3 = 0;
            for (int i4 = 0; i4 < 9; i4++) {
                i3 *= 10;
                if (i4 < str2.length()) {
                    if (str2.charAt(i4) < '0' || str2.charAt(i4) > '9') {
                        throw new ParseException("Invalid nanoseconds.", 0);
                    }
                    i3 = (str2.charAt(i4) - '0') + i3;
                }
            }
            i2 = i3;
        }
        if (parseLong >= 0) {
            if (z) {
                parseLong = -parseLong;
                i2 = -i2;
            }
            try {
                return i(parseLong, i2);
            } catch (IllegalArgumentException unused) {
                throw new ParseException("Duration value is out of range.", 0);
            }
        } else {
            throw new ParseException(a.c("Invalid duration string: ", str), 0);
        }
    }
}
