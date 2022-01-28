package com.bugfender.sdk.a.a.i.b.a;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.commons.io.FilenameUtils;

class a {
    private static final String a = "GMT";
    private static final TimeZone b = TimeZone.getTimeZone(a);

    a() {
    }

    public static String a(Date date) {
        return a(date, false, b);
    }

    public static String a(Date date, boolean z) {
        return a(date, z, b);
    }

    public static String a(Date date, boolean z, TimeZone timeZone) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder sb = new StringBuilder((z ? 4 : 0) + 19 + (timeZone.getRawOffset() == 0 ? 1 : 6));
        a(sb, gregorianCalendar.get(1), 4);
        char c = '-';
        sb.append('-');
        a(sb, gregorianCalendar.get(2) + 1, 2);
        sb.append('-');
        a(sb, gregorianCalendar.get(5), 2);
        sb.append('T');
        a(sb, gregorianCalendar.get(11), 2);
        sb.append(':');
        a(sb, gregorianCalendar.get(12), 2);
        sb.append(':');
        a(sb, gregorianCalendar.get(13), 2);
        if (z) {
            sb.append(FilenameUtils.EXTENSION_SEPARATOR);
            a(sb, gregorianCalendar.get(14), 3);
        }
        int offset = timeZone.getOffset(gregorianCalendar.getTimeInMillis());
        if (offset != 0) {
            int i = offset / 60000;
            int abs = Math.abs(i / 60);
            int abs2 = Math.abs(i % 60);
            if (offset >= 0) {
                c = '+';
            }
            sb.append(c);
            a(sb, abs, 2);
            sb.append(':');
            a(sb, abs2, 2);
        } else {
            sb.append('Z');
        }
        return sb.toString();
    }

    public static Date a(String str) {
        int i;
        try {
            int a2 = a(str, 0, 4);
            a(str, 4, '-');
            int a3 = a(str, 5, 7);
            a(str, 7, '-');
            int a4 = a(str, 8, 10);
            a(str, 10, 'T');
            int a5 = a(str, 11, 13);
            a(str, 13, ':');
            int a6 = a(str, 14, 16);
            a(str, 16, ':');
            int i2 = 19;
            int a7 = a(str, 17, 19);
            if (str.charAt(19) == '.') {
                a(str, 19, (char) FilenameUtils.EXTENSION_SEPARATOR);
                i2 = 23;
                i = a(str, 20, 23);
            } else {
                i = 0;
            }
            char charAt = str.charAt(i2);
            String str2 = a;
            if (charAt == '+' || charAt == '-') {
                str2 = str2 + str.substring(i2);
            } else if (charAt != 'Z') {
                throw new IndexOutOfBoundsException("Invalid time zone indicator " + charAt);
            }
            TimeZone timeZone = TimeZone.getTimeZone(str2);
            if (timeZone.getID().equals(str2)) {
                GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone);
                gregorianCalendar.setLenient(false);
                gregorianCalendar.set(1, a2);
                gregorianCalendar.set(2, a3 - 1);
                gregorianCalendar.set(5, a4);
                gregorianCalendar.set(11, a5);
                gregorianCalendar.set(12, a6);
                gregorianCalendar.set(13, a7);
                gregorianCalendar.set(14, i);
                return gregorianCalendar.getTime();
            }
            throw new IndexOutOfBoundsException();
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Failed to parse date " + str, e);
        } catch (NumberFormatException e2) {
            throw new IllegalArgumentException("Failed to parse date " + str, e2);
        } catch (IllegalArgumentException e3) {
            throw new IllegalArgumentException("Failed to parse date " + str, e3);
        }
    }

    private static void a(String str, int i, char c) {
        char charAt = str.charAt(i);
        if (charAt != c) {
            throw new IndexOutOfBoundsException("Expected '" + c + "' character but found '" + charAt + "'");
        }
    }

    private static int a(String str, int i, int i2) {
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new NumberFormatException(str);
        }
        int i3 = 0;
        if (i < i2) {
            int i4 = i + 1;
            int digit = Character.digit(str.charAt(i), 10);
            if (digit >= 0) {
                i3 = -digit;
                i = i4;
            } else {
                throw new NumberFormatException("Invalid number: " + str);
            }
        }
        while (i < i2) {
            int i5 = i + 1;
            int digit2 = Character.digit(str.charAt(i), 10);
            if (digit2 >= 0) {
                i3 = (i3 * 10) - digit2;
                i = i5;
            } else {
                throw new NumberFormatException("Invalid number: " + str);
            }
        }
        return -i3;
    }

    private static void a(StringBuilder sb, int i, int i2) {
        String num = Integer.toString(i);
        for (int length = i2 - num.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(num);
    }
}
