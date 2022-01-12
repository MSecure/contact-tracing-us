package org.threeten.bp.format;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.concurrent.ConcurrentHashMap;

public final class DecimalStyle {
    public static final DecimalStyle STANDARD = new DecimalStyle('0', '+', '-', '.');
    public final char decimalSeparator;
    public final char negativeSign;
    public final char positiveSign;
    public final char zeroDigit;

    static {
        new ConcurrentHashMap(16, 0.75f, 2);
    }

    public DecimalStyle(char c, char c2, char c3, char c4) {
        this.zeroDigit = c;
        this.positiveSign = c2;
        this.negativeSign = c3;
        this.decimalSeparator = c4;
    }

    public String convertNumberToI18N(String str) {
        char c = this.zeroDigit;
        if (c == '0') {
            return str;
        }
        int i = c - '0';
        char[] charArray = str.toCharArray();
        for (int i2 = 0; i2 < charArray.length; i2++) {
            charArray[i2] = (char) (charArray[i2] + i);
        }
        return new String(charArray);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DecimalStyle)) {
            return false;
        }
        DecimalStyle decimalStyle = (DecimalStyle) obj;
        return this.zeroDigit == decimalStyle.zeroDigit && this.positiveSign == decimalStyle.positiveSign && this.negativeSign == decimalStyle.negativeSign && this.decimalSeparator == decimalStyle.decimalSeparator;
    }

    public int hashCode() {
        return this.zeroDigit + this.positiveSign + this.negativeSign + this.decimalSeparator;
    }

    public String toString() {
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("DecimalStyle[");
        outline17.append(this.zeroDigit);
        outline17.append(this.positiveSign);
        outline17.append(this.negativeSign);
        outline17.append(this.decimalSeparator);
        outline17.append("]");
        return outline17.toString();
    }
}
