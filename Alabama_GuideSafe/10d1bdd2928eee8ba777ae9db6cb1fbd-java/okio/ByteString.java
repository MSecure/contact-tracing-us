package okio;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class ByteString implements Serializable, Comparable<ByteString> {
    public static final ByteString EMPTY = of(new byte[0]);
    public static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public final byte[] data;
    public transient int hashCode;
    public transient String utf8;

    public ByteString(byte[] bArr) {
        this.data = bArr;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00a2, code lost:
        r6 = null;
     */
    public static ByteString decodeBase64(String str) {
        int i;
        int i2;
        if (str != null) {
            int length = str.length();
            while (length > 0 && ((r6 = str.charAt(length - 1)) == '=' || r6 == '\n' || r6 == '\r' || r6 == ' ' || r6 == '\t')) {
                length = i2;
            }
            int i3 = (int) ((((long) length) * 6) / 8);
            byte[] bArr = new byte[i3];
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (true) {
                if (i4 < length) {
                    char charAt = str.charAt(i4);
                    if (charAt >= 'A' && charAt <= 'Z') {
                        i = charAt - 'A';
                    } else if (charAt >= 'a' && charAt <= 'z') {
                        i = charAt - 'G';
                    } else if (charAt >= '0' && charAt <= '9') {
                        i = charAt + 4;
                    } else if (charAt == '+' || charAt == '-') {
                        i = 62;
                    } else if (charAt == '/' || charAt == '_') {
                        i = 63;
                    } else {
                        if (!(charAt == '\n' || charAt == '\r' || charAt == ' ' || charAt == '\t')) {
                            break;
                        }
                        i4++;
                    }
                    i6 = (i6 << 6) | ((byte) i);
                    i5++;
                    if (i5 % 4 == 0) {
                        int i8 = i7 + 1;
                        bArr[i7] = (byte) (i6 >> 16);
                        int i9 = i8 + 1;
                        bArr[i8] = (byte) (i6 >> 8);
                        bArr[i9] = (byte) i6;
                        i7 = i9 + 1;
                    }
                    i4++;
                } else {
                    int i10 = i5 % 4;
                    if (i10 != 1) {
                        if (i10 == 2) {
                            bArr[i7] = (byte) ((i6 << 12) >> 16);
                            i7++;
                        } else if (i10 == 3) {
                            int i11 = i6 << 6;
                            int i12 = i7 + 1;
                            bArr[i7] = (byte) (i11 >> 16);
                            i7 = i12 + 1;
                            bArr[i12] = (byte) (i11 >> 8);
                        }
                        if (i7 != i3) {
                            byte[] bArr2 = new byte[i7];
                            System.arraycopy(bArr, 0, bArr2, 0, i7);
                            bArr = bArr2;
                        }
                    }
                }
            }
            if (bArr != null) {
                return new ByteString(bArr);
            }
            return null;
        }
        throw new IllegalArgumentException("base64 == null");
    }

    public static ByteString decodeHex(String str) {
        if (str.length() % 2 == 0) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) (decodeHexDigit(str.charAt(i2 + 1)) + (decodeHexDigit(str.charAt(i2)) << 4));
            }
            return of(bArr);
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline10("Unexpected hex string: ", str));
    }

    public static int decodeHexDigit(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        char c2 = 'a';
        if (c < 'a' || c > 'f') {
            c2 = 'A';
            if (c < 'A' || c > 'F') {
                throw new IllegalArgumentException("Unexpected hex digit: " + c);
            }
        }
        return (c - c2) + 10;
    }

    public static ByteString encodeString(String str, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        } else if (charset != null) {
            return new ByteString(str.getBytes(charset));
        } else {
            throw new IllegalArgumentException("charset == null");
        }
    }

    public static ByteString encodeUtf8(String str) {
        if (str != null) {
            ByteString byteString = new ByteString(str.getBytes(Util.UTF_8));
            byteString.utf8 = str;
            return byteString;
        }
        throw new IllegalArgumentException("s == null");
    }

    public static ByteString of(byte... bArr) {
        if (bArr != null) {
            return new ByteString((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public String base64() {
        byte[] bArr = this.data;
        byte[] bArr2 = Base64.MAP;
        byte[] bArr3 = new byte[(((bArr.length + 2) / 3) * 4)];
        int length = bArr.length - (bArr.length % 3);
        int i = 0;
        for (int i2 = 0; i2 < length; i2 += 3) {
            int i3 = i + 1;
            bArr3[i] = bArr2[(bArr[i2] & 255) >> 2];
            int i4 = i3 + 1;
            int i5 = i2 + 1;
            bArr3[i3] = bArr2[((bArr[i2] & 3) << 4) | ((bArr[i5] & 255) >> 4)];
            int i6 = i4 + 1;
            int i7 = i2 + 2;
            bArr3[i4] = bArr2[((bArr[i5] & 15) << 2) | ((bArr[i7] & 255) >> 6)];
            i = i6 + 1;
            bArr3[i6] = bArr2[bArr[i7] & 63];
        }
        int length2 = bArr.length % 3;
        if (length2 == 1) {
            int i8 = i + 1;
            bArr3[i] = bArr2[(bArr[length] & 255) >> 2];
            int i9 = i8 + 1;
            bArr3[i8] = bArr2[(bArr[length] & 3) << 4];
            bArr3[i9] = 61;
            bArr3[i9 + 1] = 61;
        } else if (length2 == 2) {
            int i10 = i + 1;
            bArr3[i] = bArr2[(bArr[length] & 255) >> 2];
            int i11 = i10 + 1;
            int i12 = length + 1;
            bArr3[i10] = bArr2[((bArr[i12] & 255) >> 4) | ((bArr[length] & 3) << 4)];
            bArr3[i11] = bArr2[(bArr[i12] & 15) << 2];
            bArr3[i11 + 1] = 61;
        }
        try {
            return new String(bArr3, "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
        if (r0 < r1) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        return 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0025, code lost:
        if (r7 < r8) goto L_0x0027;
     */
    @Override // java.lang.Comparable
    public int compareTo(ByteString byteString) {
        ByteString byteString2 = byteString;
        int size = size();
        int size2 = byteString2.size();
        int min = Math.min(size, size2);
        for (int i = 0; i < min; i++) {
            int i2 = getByte(i) & 255;
            int i3 = byteString2.getByte(i) & 255;
            if (i2 == i3) {
            }
        }
        if (size == size2) {
            return 0;
        }
    }

    public final ByteString digest(String str) {
        try {
            return of(MessageDigest.getInstance(str).digest(this.data));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            int size = byteString.size();
            byte[] bArr = this.data;
            if (size == bArr.length && byteString.rangeEquals(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public byte getByte(int i) {
        return this.data[i];
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode2 = Arrays.hashCode(this.data);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public String hex() {
        byte[] bArr = this.data;
        char[] cArr = new char[(bArr.length * 2)];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = HEX_DIGITS;
            cArr[i] = cArr2[(b >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public byte[] internalArray() {
        return this.data;
    }

    public boolean rangeEquals(int i, ByteString byteString, int i2, int i3) {
        return byteString.rangeEquals(i2, this.data, i, i3);
    }

    public ByteString sha1() {
        return digest("SHA-1");
    }

    public int size() {
        return this.data.length;
    }

    public ByteString substring(int i, int i2) {
        if (i >= 0) {
            byte[] bArr = this.data;
            if (i2 <= bArr.length) {
                int i3 = i2 - i;
                if (i3 < 0) {
                    throw new IllegalArgumentException("endIndex < beginIndex");
                } else if (i == 0 && i2 == bArr.length) {
                    return this;
                } else {
                    byte[] bArr2 = new byte[i3];
                    System.arraycopy(this.data, i, bArr2, 0, i3);
                    return new ByteString(bArr2);
                }
            } else {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline13(GeneratedOutlineSupport.outline17("endIndex > length("), this.data.length, ")"));
            }
        } else {
            throw new IllegalArgumentException("beginIndex < 0");
        }
    }

    public ByteString toAsciiLowercase() {
        int i = 0;
        while (true) {
            byte[] bArr = this.data;
            if (i >= bArr.length) {
                return this;
            }
            byte b = bArr[i];
            if (b < 65 || b > 90) {
                i++;
            } else {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i] = (byte) (b + 32);
                for (int i2 = i + 1; i2 < bArr2.length; i2++) {
                    byte b2 = bArr2[i2];
                    if (b2 >= 65 && b2 <= 90) {
                        bArr2[i2] = (byte) (b2 + 32);
                    }
                }
                return new ByteString(bArr2);
            }
        }
    }

    public byte[] toByteArray() {
        return (byte[]) this.data.clone();
    }

    public String toString() {
        if (this.data.length == 0) {
            return "[size=0]";
        }
        String utf82 = utf8();
        int length = utf82.length();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= length) {
                i = utf82.length();
                break;
            } else if (i2 == 64) {
                break;
            } else {
                int codePointAt = utf82.codePointAt(i);
                if ((!Character.isISOControl(codePointAt) || codePointAt == 10 || codePointAt == 13) && codePointAt != 65533) {
                    i2++;
                    i += Character.charCount(codePointAt);
                }
            }
        }
        i = -1;
        if (i != -1) {
            String replace = utf82.substring(0, i).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
            if (i >= utf82.length()) {
                return GeneratedOutlineSupport.outline11("[text=", replace, "]");
            }
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("[size=");
            outline17.append(this.data.length);
            outline17.append(" text=");
            outline17.append(replace);
            outline17.append("…]");
            return outline17.toString();
        } else if (this.data.length <= 64) {
            StringBuilder outline172 = GeneratedOutlineSupport.outline17("[hex=");
            outline172.append(hex());
            outline172.append("]");
            return outline172.toString();
        } else {
            StringBuilder outline173 = GeneratedOutlineSupport.outline17("[size=");
            outline173.append(this.data.length);
            outline173.append(" hex=");
            outline173.append(substring(0, 64).hex());
            outline173.append("…]");
            return outline173.toString();
        }
    }

    public String utf8() {
        String str = this.utf8;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.data, Util.UTF_8);
        this.utf8 = str2;
        return str2;
    }

    public void write(Buffer buffer) {
        byte[] bArr = this.data;
        buffer.write(bArr, 0, bArr.length);
    }

    public boolean rangeEquals(int i, byte[] bArr, int i2, int i3) {
        if (i >= 0) {
            byte[] bArr2 = this.data;
            return i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && Util.arrayRangeEquals(bArr2, i, bArr, i2, i3);
        }
    }
}
