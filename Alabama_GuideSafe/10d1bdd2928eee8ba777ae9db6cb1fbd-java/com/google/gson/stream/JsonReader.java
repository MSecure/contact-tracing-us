package com.google.gson.stream;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.internal.JsonReaderInternalAccess;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

public class JsonReader implements Closeable {
    public static final char[] NON_EXECUTE_PREFIX = ")]}'\n".toCharArray();
    public final char[] buffer = new char[1024];
    public final Reader in;
    public boolean lenient = false;
    public int limit = 0;
    public int lineNumber = 0;
    public int lineStart = 0;
    public int[] pathIndices;
    public String[] pathNames;
    public int peeked = 0;
    public long peekedLong;
    public int peekedNumberLength;
    public String peekedString;
    public int pos = 0;
    public int[] stack;
    public int stackSize;

    static {
        JsonReaderInternalAccess.INSTANCE = new JsonReaderInternalAccess() {
            /* class com.google.gson.stream.JsonReader.AnonymousClass1 */
        };
    }

    public JsonReader(Reader reader) {
        int[] iArr = new int[32];
        this.stack = iArr;
        this.stackSize = 0;
        this.stackSize = 0 + 1;
        iArr[0] = 6;
        this.pathNames = new String[32];
        this.pathIndices = new int[32];
        if (reader != null) {
            this.in = reader;
            return;
        }
        throw new NullPointerException("in == null");
    }

    public void beginArray() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 3) {
            push(1);
            this.pathIndices[this.stackSize - 1] = 0;
            this.peeked = 0;
            return;
        }
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("Expected BEGIN_ARRAY but was ");
        outline17.append(peek());
        outline17.append(locationString());
        throw new IllegalStateException(outline17.toString());
    }

    public void beginObject() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 1) {
            push(3);
            this.peeked = 0;
            return;
        }
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("Expected BEGIN_OBJECT but was ");
        outline17.append(peek());
        outline17.append(locationString());
        throw new IllegalStateException(outline17.toString());
    }

    public final void checkLenient() throws IOException {
        if (!this.lenient) {
            syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
            throw null;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.peeked = 0;
        this.stack[0] = 8;
        this.stackSize = 1;
        this.in.close();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:142:0x01f8, code lost:
        if (r9 == 6) goto L_0x01fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0210, code lost:
        if (isLiteral(r6) != false) goto L_0x018a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0212, code lost:
        if (r9 != 2) goto L_0x0235;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0214, code lost:
        if (r15 == false) goto L_0x0235;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x021a, code lost:
        if (r11 != Long.MIN_VALUE) goto L_0x021e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x021c, code lost:
        if (r16 == false) goto L_0x0235;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0220, code lost:
        if (r11 != 0) goto L_0x0224;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x0222, code lost:
        if (r16 != false) goto L_0x0235;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x0224, code lost:
        if (r16 == false) goto L_0x0227;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x0227, code lost:
        r11 = -r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x0228, code lost:
        r20.peekedLong = r11;
        r20.pos += r19;
        r6 = 15;
        r20.peeked = 15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x0235, code lost:
        if (r9 == 2) goto L_0x023d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x0238, code lost:
        if (r9 == 4) goto L_0x023d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x023b, code lost:
        if (r9 != 7) goto L_0x018a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x023d, code lost:
        r20.peekedNumberLength = r19;
        r6 = 16;
        r20.peeked = 16;
     */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0174 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0175  */
    public int doPeek() throws IOException {
        int i;
        int i2;
        int i3;
        int i4;
        char c;
        int i5;
        String str;
        String str2;
        char c2;
        boolean z;
        int[] iArr = this.stack;
        int i6 = this.stackSize;
        int i7 = iArr[i6 - 1];
        char c3 = 1;
        if (i7 == 1) {
            iArr[i6 - 1] = 2;
        } else if (i7 == 2) {
            int nextNonWhitespace = nextNonWhitespace(true);
            if (nextNonWhitespace != 44) {
                if (nextNonWhitespace == 59) {
                    checkLenient();
                } else if (nextNonWhitespace == 93) {
                    this.peeked = 4;
                    return 4;
                } else {
                    syntaxError("Unterminated array");
                    throw null;
                }
            }
        } else if (i7 == 3 || i7 == 5) {
            this.stack[this.stackSize - 1] = 4;
            if (i7 == 5) {
                int nextNonWhitespace2 = nextNonWhitespace(true);
                if (nextNonWhitespace2 != 44) {
                    if (nextNonWhitespace2 == 59) {
                        checkLenient();
                    } else if (nextNonWhitespace2 == 125) {
                        this.peeked = 2;
                        return 2;
                    } else {
                        syntaxError("Unterminated object");
                        throw null;
                    }
                }
                z = true;
            } else {
                z = true;
            }
            int nextNonWhitespace3 = nextNonWhitespace(z);
            if (nextNonWhitespace3 == 34) {
                this.peeked = 13;
                return 13;
            } else if (nextNonWhitespace3 == 39) {
                checkLenient();
                this.peeked = 12;
                return 12;
            } else if (nextNonWhitespace3 != 125) {
                checkLenient();
                int i8 = this.pos;
                int i9 = z ? 1 : 0;
                int i10 = z ? 1 : 0;
                int i11 = z ? 1 : 0;
                this.pos = i8 - i9;
                if (isLiteral((char) nextNonWhitespace3)) {
                    this.peeked = 14;
                    return 14;
                }
                syntaxError("Expected name");
                throw null;
            } else if (i7 != 5) {
                this.peeked = 2;
                return 2;
            } else {
                syntaxError("Expected name");
                throw null;
            }
        } else if (i7 == 4) {
            iArr[i6 - 1] = 5;
            int nextNonWhitespace4 = nextNonWhitespace(true);
            if (nextNonWhitespace4 != 58) {
                if (nextNonWhitespace4 == 61) {
                    checkLenient();
                    if (this.pos < this.limit || fillBuffer(1)) {
                        char[] cArr = this.buffer;
                        int i12 = this.pos;
                        if (cArr[i12] == '>') {
                            this.pos = i12 + 1;
                        }
                    }
                } else {
                    syntaxError("Expected ':'");
                    throw null;
                }
            }
        } else if (i7 == 6) {
            if (this.lenient) {
                nextNonWhitespace(true);
                int i13 = this.pos - 1;
                this.pos = i13;
                char[] cArr2 = NON_EXECUTE_PREFIX;
                if (i13 + cArr2.length <= this.limit || fillBuffer(cArr2.length)) {
                    int i14 = 0;
                    while (true) {
                        char[] cArr3 = NON_EXECUTE_PREFIX;
                        if (i14 >= cArr3.length) {
                            this.pos += cArr3.length;
                            break;
                        } else if (this.buffer[this.pos + i14] != cArr3[i14]) {
                            break;
                        } else {
                            i14++;
                        }
                    }
                }
            }
            this.stack[this.stackSize - 1] = 7;
        } else if (i7 == 7) {
            if (nextNonWhitespace(false) == -1) {
                this.peeked = 17;
                return 17;
            }
            checkLenient();
            this.pos--;
        } else if (i7 == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        int nextNonWhitespace5 = nextNonWhitespace(true);
        if (nextNonWhitespace5 == 34) {
            this.peeked = 9;
            return 9;
        } else if (nextNonWhitespace5 != 39) {
            if (nextNonWhitespace5 == 44 || nextNonWhitespace5 == 59) {
                i = 1;
            } else if (nextNonWhitespace5 == 91) {
                this.peeked = 3;
                return 3;
            } else if (nextNonWhitespace5 == 93) {
                i = 1;
                if (i7 == 1) {
                    this.peeked = 4;
                    return 4;
                }
            } else if (nextNonWhitespace5 != 123) {
                int i15 = this.pos - 1;
                this.pos = i15;
                char c4 = this.buffer[i15];
                if (c4 == 't' || c4 == 'T') {
                    str2 = "true";
                    str = "TRUE";
                    i2 = 5;
                } else if (c4 == 'f' || c4 == 'F') {
                    str2 = "false";
                    str = "FALSE";
                    i2 = 6;
                } else {
                    if (c4 == 'n' || c4 == 'N') {
                        str2 = "null";
                        str = "NULL";
                        i2 = 7;
                    }
                    i2 = 0;
                    if (i2 == 0) {
                        return i2;
                    }
                    char[] cArr4 = this.buffer;
                    int i16 = this.pos;
                    int i17 = this.limit;
                    boolean z2 = true;
                    int i18 = 0;
                    char c5 = 0;
                    boolean z3 = false;
                    long j = 0;
                    while (true) {
                        if (i16 + i18 == i17) {
                            if (i18 == cArr4.length) {
                                break;
                            } else if (!fillBuffer(i18 + 1)) {
                                i3 = i18;
                                break;
                            } else {
                                i16 = this.pos;
                                i17 = this.limit;
                            }
                        }
                        char c6 = cArr4[i16 + i18];
                        if (c6 != '+') {
                            if (c6 != 'E' && c6 != 'e') {
                                if (c6 != '-') {
                                    if (c6 == '.') {
                                        i4 = i18;
                                        if (c5 != 2) {
                                            break;
                                        }
                                        c = 3;
                                    } else if (c6 < '0' || c6 > '9') {
                                        i3 = i18;
                                    } else {
                                        if (c5 == c3 || c5 == 0) {
                                            i5 = i18;
                                            j = (long) (-(c6 - '0'));
                                            c5 = 2;
                                        } else if (c5 != 2) {
                                            i5 = i18;
                                            if (c5 == 3) {
                                                c5 = 4;
                                            } else {
                                                if (c5 != 5) {
                                                }
                                                c5 = 7;
                                            }
                                        } else if (j == 0) {
                                            break;
                                        } else {
                                            i5 = i18;
                                            long j2 = (10 * j) - ((long) (c6 - '0'));
                                            int i19 = (j > -922337203685477580L ? 1 : (j == -922337203685477580L ? 0 : -1));
                                            z2 &= i19 > 0 || (i19 == 0 && j2 < j);
                                            j = j2;
                                        }
                                        i4 = i5;
                                        i18 = i4 + 1;
                                        c3 = 1;
                                    }
                                } else {
                                    i4 = i18;
                                    c = 6;
                                    if (c5 != 0) {
                                        if (c5 != 5) {
                                            break;
                                        }
                                    } else {
                                        c5 = 1;
                                        z3 = true;
                                        i18 = i4 + 1;
                                        c3 = 1;
                                    }
                                }
                            } else {
                                i4 = i18;
                                if (c5 != 2 && c5 != 4) {
                                    break;
                                }
                                c5 = 5;
                                i18 = i4 + 1;
                                c3 = 1;
                            }
                        } else {
                            i4 = i18;
                            if (c5 != 5) {
                                break;
                            }
                            c = 6;
                        }
                        c5 = c;
                        i18 = i4 + 1;
                        c3 = 1;
                    }
                    int i20 = 0;
                    if (i20 != 0) {
                        return i20;
                    }
                    if (isLiteral(this.buffer[this.pos])) {
                        checkLenient();
                        this.peeked = 10;
                        return 10;
                    }
                    syntaxError("Expected value");
                    throw null;
                }
                int length = str2.length();
                int i21 = 1;
                while (true) {
                    if (i21 < length) {
                        if ((this.pos + i21 >= this.limit && !fillBuffer(i21 + 1)) || ((c2 = this.buffer[this.pos + i21]) != str2.charAt(i21) && c2 != str.charAt(i21))) {
                            break;
                        }
                        i21++;
                    } else if ((this.pos + length >= this.limit && !fillBuffer(length + 1)) || !isLiteral(this.buffer[this.pos + length])) {
                        this.pos += length;
                        this.peeked = i2;
                    }
                }
                i2 = 0;
                if (i2 == 0) {
                }
            } else {
                this.peeked = 1;
                return 1;
            }
            if (i7 == i || i7 == 2) {
                checkLenient();
                this.pos -= i;
                this.peeked = 7;
                return 7;
            }
            syntaxError("Unexpected value");
            throw null;
        } else {
            checkLenient();
            this.peeked = 8;
            return 8;
        }
    }

    public void endArray() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 4) {
            int i2 = this.stackSize - 1;
            this.stackSize = i2;
            int[] iArr = this.pathIndices;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
            this.peeked = 0;
            return;
        }
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("Expected END_ARRAY but was ");
        outline17.append(peek());
        outline17.append(locationString());
        throw new IllegalStateException(outline17.toString());
    }

    public void endObject() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 2) {
            int i2 = this.stackSize - 1;
            this.stackSize = i2;
            this.pathNames[i2] = null;
            int[] iArr = this.pathIndices;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
            this.peeked = 0;
            return;
        }
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("Expected END_OBJECT but was ");
        outline17.append(peek());
        outline17.append(locationString());
        throw new IllegalStateException(outline17.toString());
    }

    public final boolean fillBuffer(int i) throws IOException {
        int i2;
        char[] cArr = this.buffer;
        int i3 = this.lineStart;
        int i4 = this.pos;
        this.lineStart = i3 - i4;
        int i5 = this.limit;
        if (i5 != i4) {
            int i6 = i5 - i4;
            this.limit = i6;
            System.arraycopy(cArr, i4, cArr, 0, i6);
        } else {
            this.limit = 0;
        }
        this.pos = 0;
        do {
            Reader reader = this.in;
            int i7 = this.limit;
            int read = reader.read(cArr, i7, cArr.length - i7);
            if (read == -1) {
                return false;
            }
            int i8 = this.limit + read;
            this.limit = i8;
            if (this.lineNumber == 0 && (i2 = this.lineStart) == 0 && i8 > 0 && cArr[0] == 65279) {
                this.pos++;
                this.lineStart = i2 + 1;
                i++;
            }
        } while (this.limit < i);
        return true;
    }

    public String getPath() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i = this.stackSize;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.stack[i2];
            if (i3 == 1 || i3 == 2) {
                sb.append('[');
                sb.append(this.pathIndices[i2]);
                sb.append(']');
            } else if (i3 == 3 || i3 == 4 || i3 == 5) {
                sb.append('.');
                String[] strArr = this.pathNames;
                if (strArr[i2] != null) {
                    sb.append(strArr[i2]);
                }
            }
        }
        return sb.toString();
    }

    public boolean hasNext() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    public final boolean isLiteral(char c) throws IOException {
        if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
            return false;
        }
        if (c != '#') {
            if (c == ',') {
                return false;
            }
            if (!(c == '/' || c == '=')) {
                if (c == '{' || c == '}' || c == ':') {
                    return false;
                }
                if (c != ';') {
                    switch (c) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        checkLenient();
        return false;
    }

    public String locationString() {
        return " at line " + (this.lineNumber + 1) + " column " + ((this.pos - this.lineStart) + 1) + " path " + getPath();
    }

    public boolean nextBoolean() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 5) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        } else if (i == 6) {
            this.peeked = 0;
            int[] iArr2 = this.pathIndices;
            int i3 = this.stackSize - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        } else {
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("Expected a boolean but was ");
            outline17.append(peek());
            outline17.append(locationString());
            throw new IllegalStateException(outline17.toString());
        }
    }

    public double nextDouble() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 15) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr[i2] = iArr[i2] + 1;
            return (double) this.peekedLong;
        }
        if (i == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else if (i == 8 || i == 9) {
            this.peekedString = nextQuotedValue(i == 8 ? '\'' : '\"');
        } else if (i == 10) {
            this.peekedString = nextUnquotedValue();
        } else if (i != 11) {
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("Expected a double but was ");
            outline17.append(peek());
            outline17.append(locationString());
            throw new IllegalStateException(outline17.toString());
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        if (this.lenient || (!Double.isNaN(parseDouble) && !Double.isInfinite(parseDouble))) {
            this.peekedString = null;
            this.peeked = 0;
            int[] iArr2 = this.pathIndices;
            int i3 = this.stackSize - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return parseDouble;
        }
        throw new MalformedJsonException("JSON forbids NaN and infinities: " + parseDouble + locationString());
    }

    public int nextInt() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 15) {
            long j = this.peekedLong;
            int i2 = (int) j;
            if (j == ((long) i2)) {
                this.peeked = 0;
                int[] iArr = this.pathIndices;
                int i3 = this.stackSize - 1;
                iArr[i3] = iArr[i3] + 1;
                return i2;
            }
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("Expected an int but was ");
            outline17.append(this.peekedLong);
            outline17.append(locationString());
            throw new NumberFormatException(outline17.toString());
        }
        if (i == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else if (i == 8 || i == 9 || i == 10) {
            if (i == 10) {
                this.peekedString = nextUnquotedValue();
            } else {
                this.peekedString = nextQuotedValue(i == 8 ? '\'' : '\"');
            }
            try {
                int parseInt = Integer.parseInt(this.peekedString);
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i4 = this.stackSize - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else {
            StringBuilder outline172 = GeneratedOutlineSupport.outline17("Expected an int but was ");
            outline172.append(peek());
            outline172.append(locationString());
            throw new IllegalStateException(outline172.toString());
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        int i5 = (int) parseDouble;
        if (((double) i5) == parseDouble) {
            this.peekedString = null;
            this.peeked = 0;
            int[] iArr3 = this.pathIndices;
            int i6 = this.stackSize - 1;
            iArr3[i6] = iArr3[i6] + 1;
            return i5;
        }
        StringBuilder outline173 = GeneratedOutlineSupport.outline17("Expected an int but was ");
        outline173.append(this.peekedString);
        outline173.append(locationString());
        throw new NumberFormatException(outline173.toString());
    }

    public long nextLong() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 15) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.peekedLong;
        }
        if (i == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else if (i == 8 || i == 9 || i == 10) {
            if (i == 10) {
                this.peekedString = nextUnquotedValue();
            } else {
                this.peekedString = nextQuotedValue(i == 8 ? '\'' : '\"');
            }
            try {
                long parseLong = Long.parseLong(this.peekedString);
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i3 = this.stackSize - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        } else {
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("Expected a long but was ");
            outline17.append(peek());
            outline17.append(locationString());
            throw new IllegalStateException(outline17.toString());
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        long j = (long) parseDouble;
        if (((double) j) == parseDouble) {
            this.peekedString = null;
            this.peeked = 0;
            int[] iArr3 = this.pathIndices;
            int i4 = this.stackSize - 1;
            iArr3[i4] = iArr3[i4] + 1;
            return j;
        }
        StringBuilder outline172 = GeneratedOutlineSupport.outline17("Expected a long but was ");
        outline172.append(this.peekedString);
        outline172.append(locationString());
        throw new NumberFormatException(outline172.toString());
    }

    public String nextName() throws IOException {
        String str;
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 14) {
            str = nextUnquotedValue();
        } else if (i == 12) {
            str = nextQuotedValue('\'');
        } else if (i == 13) {
            str = nextQuotedValue('\"');
        } else {
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("Expected a name but was ");
            outline17.append(peek());
            outline17.append(locationString());
            throw new IllegalStateException(outline17.toString());
        }
        this.peeked = 0;
        this.pathNames[this.stackSize - 1] = str;
        return str;
    }

    public final int nextNonWhitespace(boolean z) throws IOException {
        char[] cArr = this.buffer;
        int i = this.pos;
        int i2 = this.limit;
        while (true) {
            boolean z2 = true;
            if (i == i2) {
                this.pos = i;
                if (fillBuffer(1)) {
                    i = this.pos;
                    i2 = this.limit;
                } else if (!z) {
                    return -1;
                } else {
                    StringBuilder outline17 = GeneratedOutlineSupport.outline17("End of input");
                    outline17.append(locationString());
                    throw new EOFException(outline17.toString());
                }
            }
            int i3 = i + 1;
            char c = cArr[i];
            if (c == '\n') {
                this.lineNumber++;
                this.lineStart = i3;
            } else if (!(c == ' ' || c == '\r' || c == '\t')) {
                if (c == '/') {
                    this.pos = i3;
                    if (i3 == i2) {
                        this.pos = i3 - 1;
                        boolean fillBuffer = fillBuffer(2);
                        this.pos++;
                        if (!fillBuffer) {
                            return c;
                        }
                    }
                    checkLenient();
                    int i4 = this.pos;
                    char c2 = cArr[i4];
                    if (c2 == '*') {
                        this.pos = i4 + 1;
                        while (true) {
                            if (this.pos + 2 > this.limit && !fillBuffer(2)) {
                                z2 = false;
                                break;
                            }
                            char[] cArr2 = this.buffer;
                            int i5 = this.pos;
                            if (cArr2[i5] != '\n') {
                                for (int i6 = 0; i6 < 2; i6++) {
                                    if (this.buffer[this.pos + i6] == "*/".charAt(i6)) {
                                    }
                                }
                                break;
                            }
                            this.lineNumber++;
                            this.lineStart = i5 + 1;
                            this.pos++;
                        }
                        if (z2) {
                            i = this.pos + 2;
                            i2 = this.limit;
                        } else {
                            syntaxError("Unterminated comment");
                            throw null;
                        }
                    } else if (c2 != '/') {
                        return c;
                    } else {
                        this.pos = i4 + 1;
                        skipToEndOfLine();
                        i = this.pos;
                        i2 = this.limit;
                    }
                } else if (c == '#') {
                    this.pos = i3;
                    checkLenient();
                    skipToEndOfLine();
                    i = this.pos;
                    i2 = this.limit;
                } else {
                    this.pos = i3;
                    return c;
                }
            }
            i = i3;
        }
    }

    public void nextNull() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 7) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("Expected null but was ");
        outline17.append(peek());
        outline17.append(locationString());
        throw new IllegalStateException(outline17.toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005d, code lost:
        if (r2 != null) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005f, code lost:
        r2 = new java.lang.StringBuilder(java.lang.Math.max((r3 - r3) * 2, 16));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006d, code lost:
        r2.append(r0, r3, r3 - r3);
        r10.pos = r3;
     */
    public final String nextQuotedValue(char c) throws IOException {
        char[] cArr = this.buffer;
        StringBuilder sb = null;
        do {
            int i = this.pos;
            int i2 = this.limit;
            while (true) {
                while (i < i2) {
                    int i3 = i + 1;
                    char c2 = cArr[i];
                    if (c2 == c) {
                        this.pos = i3;
                        int i4 = (i3 - i) - 1;
                        if (sb == null) {
                            return new String(cArr, i, i4);
                        }
                        sb.append(cArr, i, i4);
                        return sb.toString();
                    } else if (c2 == '\\') {
                        this.pos = i3;
                        int i5 = (i3 - i) - 1;
                        if (sb == null) {
                            sb = new StringBuilder(Math.max((i5 + 1) * 2, 16));
                        }
                        sb.append(cArr, i, i5);
                        sb.append(readEscapeCharacter());
                        i = this.pos;
                        i2 = this.limit;
                    } else {
                        if (c2 == '\n') {
                            this.lineNumber++;
                            this.lineStart = i3;
                        }
                        i = i3;
                    }
                }
                break;
            }
        } while (fillBuffer(1));
        syntaxError("Unterminated string");
        throw null;
    }

    public String nextString() throws IOException {
        String str;
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 10) {
            str = nextUnquotedValue();
        } else if (i == 8) {
            str = nextQuotedValue('\'');
        } else if (i == 9) {
            str = nextQuotedValue('\"');
        } else if (i == 11) {
            str = this.peekedString;
            this.peekedString = null;
        } else if (i == 15) {
            str = Long.toString(this.peekedLong);
        } else if (i == 16) {
            str = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else {
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("Expected a string but was ");
            outline17.append(peek());
            outline17.append(locationString());
            throw new IllegalStateException(outline17.toString());
        }
        this.peeked = 0;
        int[] iArr = this.pathIndices;
        int i2 = this.stackSize - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004a, code lost:
        checkLenient();
     */
    public final String nextUnquotedValue() throws IOException {
        int i;
        String str;
        int i2 = 0;
        StringBuilder sb = null;
        while (true) {
            i = 0;
            while (true) {
                int i3 = this.pos;
                if (i3 + i < this.limit) {
                    char c = this.buffer[i3 + i];
                    if (!(c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ')) {
                        if (c != '#') {
                            if (c != ',') {
                                if (!(c == '/' || c == '=')) {
                                    if (!(c == '{' || c == '}' || c == ':')) {
                                        if (c != ';') {
                                            switch (c) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else if (i >= this.buffer.length) {
                    if (sb == null) {
                        sb = new StringBuilder(Math.max(i, 16));
                    }
                    sb.append(this.buffer, this.pos, i);
                    this.pos += i;
                    if (!fillBuffer(1)) {
                    }
                } else if (fillBuffer(i + 1)) {
                }
            }
        }
        i2 = i;
        if (sb == null) {
            str = new String(this.buffer, this.pos, i2);
        } else {
            sb.append(this.buffer, this.pos, i2);
            str = sb.toString();
        }
        this.pos += i2;
        return str;
    }

    public JsonToken peek() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        switch (i) {
            case 1:
                return JsonToken.BEGIN_OBJECT;
            case 2:
                return JsonToken.END_OBJECT;
            case 3:
                return JsonToken.BEGIN_ARRAY;
            case 4:
                return JsonToken.END_ARRAY;
            case 5:
            case 6:
                return JsonToken.BOOLEAN;
            case 7:
                return JsonToken.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonToken.STRING;
            case 12:
            case 13:
            case 14:
                return JsonToken.NAME;
            case 15:
            case 16:
                return JsonToken.NUMBER;
            case 17:
                return JsonToken.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public final void push(int i) {
        int i2 = this.stackSize;
        int[] iArr = this.stack;
        if (i2 == iArr.length) {
            int i3 = i2 * 2;
            this.stack = Arrays.copyOf(iArr, i3);
            this.pathIndices = Arrays.copyOf(this.pathIndices, i3);
            this.pathNames = (String[]) Arrays.copyOf(this.pathNames, i3);
        }
        int[] iArr2 = this.stack;
        int i4 = this.stackSize;
        this.stackSize = i4 + 1;
        iArr2[i4] = i;
    }

    public final char readEscapeCharacter() throws IOException {
        int i;
        int i2;
        if (this.pos != this.limit || fillBuffer(1)) {
            char[] cArr = this.buffer;
            int i3 = this.pos;
            int i4 = i3 + 1;
            this.pos = i4;
            char c = cArr[i3];
            if (c == '\n') {
                this.lineNumber++;
                this.lineStart = i4;
            } else if (!(c == '\"' || c == '\'' || c == '/' || c == '\\')) {
                if (c == 'b') {
                    return '\b';
                }
                if (c == 'f') {
                    return '\f';
                }
                if (c == 'n') {
                    return '\n';
                }
                if (c == 'r') {
                    return '\r';
                }
                if (c == 't') {
                    return '\t';
                }
                if (c != 'u') {
                    syntaxError("Invalid escape sequence");
                    throw null;
                } else if (i4 + 4 <= this.limit || fillBuffer(4)) {
                    char c2 = 0;
                    int i5 = this.pos;
                    int i6 = i5 + 4;
                    while (i5 < i6) {
                        char c3 = this.buffer[i5];
                        char c4 = (char) (c2 << 4);
                        if (c3 < '0' || c3 > '9') {
                            if (c3 >= 'a' && c3 <= 'f') {
                                i2 = c3 - 'a';
                            } else if (c3 < 'A' || c3 > 'F') {
                                StringBuilder outline17 = GeneratedOutlineSupport.outline17("\\u");
                                outline17.append(new String(this.buffer, this.pos, 4));
                                throw new NumberFormatException(outline17.toString());
                            } else {
                                i2 = c3 - 'A';
                            }
                            i = i2 + 10;
                        } else {
                            i = c3 - '0';
                        }
                        c2 = (char) (i + c4);
                        i5++;
                    }
                    this.pos += 4;
                    return c2;
                } else {
                    syntaxError("Unterminated escape sequence");
                    throw null;
                }
            }
            return c;
        }
        syntaxError("Unterminated escape sequence");
        throw null;
    }

    public final void skipQuotedValue(char c) throws IOException {
        char[] cArr = this.buffer;
        do {
            int i = this.pos;
            int i2 = this.limit;
            while (i < i2) {
                int i3 = i + 1;
                char c2 = cArr[i];
                if (c2 == c) {
                    this.pos = i3;
                    return;
                } else if (c2 == '\\') {
                    this.pos = i3;
                    readEscapeCharacter();
                    i = this.pos;
                    i2 = this.limit;
                } else {
                    if (c2 == '\n') {
                        this.lineNumber++;
                        this.lineStart = i3;
                    }
                    i = i3;
                }
            }
            this.pos = i;
        } while (fillBuffer(1));
        syntaxError("Unterminated string");
        throw null;
    }

    public final void skipToEndOfLine() throws IOException {
        char c;
        do {
            if (this.pos < this.limit || fillBuffer(1)) {
                char[] cArr = this.buffer;
                int i = this.pos;
                int i2 = i + 1;
                this.pos = i2;
                c = cArr[i];
                if (c == '\n') {
                    this.lineNumber++;
                    this.lineStart = i2;
                    return;
                }
            } else {
                return;
            }
        } while (c != '\r');
    }

    public void skipValue() throws IOException {
        int i;
        int i2 = 0;
        do {
            int i3 = this.peeked;
            if (i3 == 0) {
                i3 = doPeek();
            }
            if (i3 == 3) {
                push(1);
            } else if (i3 == 1) {
                push(3);
            } else {
                if (i3 == 4) {
                    this.stackSize--;
                } else if (i3 == 2) {
                    this.stackSize--;
                } else if (i3 == 14 || i3 == 10) {
                    while (true) {
                        i = 0;
                        while (true) {
                            int i4 = this.pos + i;
                            if (i4 < this.limit) {
                                char c = this.buffer[i4];
                                if (!(c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ')) {
                                    if (c != '#') {
                                        if (c != ',') {
                                            if (!(c == '/' || c == '=')) {
                                                if (!(c == '{' || c == '}' || c == ':')) {
                                                    if (c != ';') {
                                                        switch (c) {
                                                            case '[':
                                                            case ']':
                                                                break;
                                                            case '\\':
                                                                break;
                                                            default:
                                                                i++;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                this.pos = i4;
                                if (!fillBuffer(1)) {
                                }
                            }
                        }
                    }
                    checkLenient();
                    this.pos += i;
                    this.peeked = 0;
                } else if (i3 == 8 || i3 == 12) {
                    skipQuotedValue('\'');
                    this.peeked = 0;
                } else if (i3 == 9 || i3 == 13) {
                    skipQuotedValue('\"');
                    this.peeked = 0;
                } else {
                    if (i3 == 16) {
                        this.pos += this.peekedNumberLength;
                    }
                    this.peeked = 0;
                }
                i2--;
                this.peeked = 0;
            }
            i2++;
            this.peeked = 0;
        } while (i2 != 0);
        int[] iArr = this.pathIndices;
        int i5 = this.stackSize;
        int i6 = i5 - 1;
        iArr[i6] = iArr[i6] + 1;
        this.pathNames[i5 - 1] = "null";
    }

    public final IOException syntaxError(String str) throws IOException {
        StringBuilder outline17 = GeneratedOutlineSupport.outline17(str);
        outline17.append(locationString());
        throw new MalformedJsonException(outline17.toString());
    }

    public String toString() {
        return getClass().getSimpleName() + locationString();
    }
}
