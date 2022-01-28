package com.facebook.imagepipeline.common;

import androidx.appcompat.app.AppCompatDelegateImpl;
import java.util.regex.Pattern;

public class BytesRange {
    public static Pattern sHeaderParsingRegEx;
    public final int from;
    public final int to;

    public BytesRange(int i, int i2) {
        this.from = i;
        this.to = i2;
    }

    public static BytesRange fromContentRangeHeader(String str) throws IllegalArgumentException {
        if (str == null) {
            return null;
        }
        if (sHeaderParsingRegEx == null) {
            sHeaderParsingRegEx = Pattern.compile("[-/ ]");
        }
        try {
            String[] split = sHeaderParsingRegEx.split(str);
            AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(split.length == 4);
            AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(split[0].equals("bytes"));
            int parseInt = Integer.parseInt(split[1]);
            int parseInt2 = Integer.parseInt(split[2]);
            int parseInt3 = Integer.parseInt(split[3]);
            AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(parseInt2 > parseInt);
            AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(parseInt3 > parseInt2);
            if (parseInt2 < parseInt3 - 1) {
                return new BytesRange(parseInt, parseInt2);
            }
            return new BytesRange(parseInt, Integer.MAX_VALUE);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(String.format(null, "Invalid Content-Range header value: \"%s\"", str), e);
        }
    }

    public static String valueOrEmpty(int i) {
        return i == Integer.MAX_VALUE ? "" : Integer.toString(i);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BytesRange)) {
            return false;
        }
        BytesRange bytesRange = (BytesRange) obj;
        return this.from == bytesRange.from && this.to == bytesRange.to;
    }

    public int hashCode() {
        return AppCompatDelegateImpl.ConfigurationImplApi17.hashCode(this.from, this.to);
    }

    public String toString() {
        return String.format(null, "%s-%s", valueOrEmpty(this.from), valueOrEmpty(this.to));
    }
}
