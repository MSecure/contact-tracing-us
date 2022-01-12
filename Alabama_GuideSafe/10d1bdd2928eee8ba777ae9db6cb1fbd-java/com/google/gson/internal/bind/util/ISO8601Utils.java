package com.google.gson.internal.bind.util;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ColorPropConverter;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class ISO8601Utils {
    public static final TimeZone TIMEZONE_UTC = TimeZone.getTimeZone("UTC");

    public static boolean checkOffset(String str, int i, char c) {
        return i < str.length() && str.charAt(i) == c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x00e1 A[Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01c8 A[Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01d0 }] */
    public static Date parse(String str, ParsePosition parsePosition) throws ParseException {
        String str2;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        TimeZone timeZone;
        int i6;
        int i7;
        char charAt;
        try {
            int index = parsePosition.getIndex();
            int i8 = index + 4;
            int parseInt = parseInt(str, index, i8);
            if (checkOffset(str, i8, '-')) {
                i8++;
            }
            int i9 = i8 + 2;
            int parseInt2 = parseInt(str, i8, i9);
            if (checkOffset(str, i9, '-')) {
                i9++;
            }
            int i10 = i9 + 2;
            int parseInt3 = parseInt(str, i9, i10);
            boolean checkOffset = checkOffset(str, i10, 'T');
            if (checkOffset || str.length() > i10) {
                if (checkOffset) {
                    int i11 = i10 + 1;
                    int i12 = i11 + 2;
                    i4 = parseInt(str, i11, i12);
                    if (checkOffset(str, i12, ':')) {
                        i12++;
                    }
                    int i13 = i12 + 2;
                    i3 = parseInt(str, i12, i13);
                    if (checkOffset(str, i13, ':')) {
                        i13++;
                    }
                    if (str.length() <= i13 || (charAt = str.charAt(i13)) == 'Z' || charAt == '+' || charAt == '-') {
                        i7 = i4;
                        i10 = i13;
                    } else {
                        i5 = i13 + 2;
                        i2 = parseInt(str, i13, i5);
                        if (i2 > 59 && i2 < 63) {
                            i2 = 59;
                        }
                        if (checkOffset(str, i5, '.')) {
                            int i14 = i5 + 1;
                            int i15 = i14 + 1;
                            while (true) {
                                if (i15 >= str.length()) {
                                    i15 = str.length();
                                    break;
                                }
                                char charAt2 = str.charAt(i15);
                                if (charAt2 < '0') {
                                    break;
                                } else if (charAt2 > '9') {
                                    break;
                                } else {
                                    i15++;
                                }
                            }
                            int min = Math.min(i15, i14 + 3);
                            i = parseInt(str, i14, min);
                            int i16 = min - i14;
                            if (i16 == 1) {
                                i *= 100;
                            } else if (i16 == 2) {
                                i *= 10;
                            }
                            i5 = i15;
                        } else {
                            i = 0;
                        }
                        if (str.length() <= i5) {
                            char charAt3 = str.charAt(i5);
                            if (charAt3 == 'Z') {
                                timeZone = TIMEZONE_UTC;
                                i6 = i5 + 1;
                            } else {
                                if (charAt3 != '+') {
                                    if (charAt3 != '-') {
                                        throw new IndexOutOfBoundsException("Invalid time zone indicator '" + charAt3 + "'");
                                    }
                                }
                                String substring = str.substring(i5);
                                if (substring.length() < 5) {
                                    substring = substring + "00";
                                }
                                i6 = i5 + substring.length();
                                if (!"+0000".equals(substring)) {
                                    if (!"+00:00".equals(substring)) {
                                        String str3 = "GMT" + substring;
                                        TimeZone timeZone2 = TimeZone.getTimeZone(str3);
                                        String id = timeZone2.getID();
                                        if (!id.equals(str3)) {
                                            if (!id.replace(ColorPropConverter.PACKAGE_DELIMITER, "").equals(str3)) {
                                                throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + str3 + " given, resolves to " + timeZone2.getID());
                                            }
                                        }
                                        timeZone = timeZone2;
                                    }
                                }
                                timeZone = TIMEZONE_UTC;
                            }
                            GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone);
                            gregorianCalendar.setLenient(false);
                            gregorianCalendar.set(1, parseInt);
                            gregorianCalendar.set(2, parseInt2 - 1);
                            gregorianCalendar.set(5, parseInt3);
                            gregorianCalendar.set(11, i4);
                            gregorianCalendar.set(12, i3);
                            gregorianCalendar.set(13, i2);
                            gregorianCalendar.set(14, i);
                            parsePosition.setIndex(i6);
                            return gregorianCalendar.getTime();
                        }
                        throw new IllegalArgumentException("No time zone indicator");
                    }
                } else {
                    i7 = 0;
                    i3 = 0;
                }
                i = 0;
                i2 = 0;
                i4 = i7;
                i5 = i10;
                if (str.length() <= i5) {
                }
            } else {
                GregorianCalendar gregorianCalendar2 = new GregorianCalendar(parseInt, parseInt2 - 1, parseInt3);
                parsePosition.setIndex(i10);
                return gregorianCalendar2.getTime();
            }
        } catch (IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException e) {
            if (str == null) {
                str2 = null;
            } else {
                str2 = '\"' + str + '\"';
            }
            String message = e.getMessage();
            if (message == null || message.isEmpty()) {
                StringBuilder outline17 = GeneratedOutlineSupport.outline17("(");
                outline17.append(e.getClass().getName());
                outline17.append(")");
                message = outline17.toString();
            }
            ParseException parseException = new ParseException("Failed to parse date [" + str2 + "]: " + message, parsePosition.getIndex());
            parseException.initCause(e);
            throw parseException;
        }
    }

    public static int parseInt(String str, int i, int i2) throws NumberFormatException {
        int i3;
        int i4;
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new NumberFormatException(str);
        }
        if (i < i2) {
            i4 = i + 1;
            int digit = Character.digit(str.charAt(i), 10);
            if (digit >= 0) {
                i3 = -digit;
            } else {
                StringBuilder outline17 = GeneratedOutlineSupport.outline17("Invalid number: ");
                outline17.append(str.substring(i, i2));
                throw new NumberFormatException(outline17.toString());
            }
        } else {
            i3 = 0;
            i4 = i;
        }
        while (i4 < i2) {
            int i5 = i4 + 1;
            int digit2 = Character.digit(str.charAt(i4), 10);
            if (digit2 >= 0) {
                i3 = (i3 * 10) - digit2;
                i4 = i5;
            } else {
                StringBuilder outline172 = GeneratedOutlineSupport.outline17("Invalid number: ");
                outline172.append(str.substring(i, i2));
                throw new NumberFormatException(outline172.toString());
            }
        }
        return -i3;
    }
}
