package c.b.a.a.g.b;

import androidx.recyclerview.widget.RecyclerView;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class c4 {

    /* renamed from: a  reason: collision with root package name */
    public final ByteBuffer f3239a;

    /* renamed from: b  reason: collision with root package name */
    public g0 f3240b;

    /* renamed from: c  reason: collision with root package name */
    public int f3241c;

    public c4(byte[] bArr, int i, int i2) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr, i, i2);
        this.f3239a = wrap;
        wrap.order(ByteOrder.LITTLE_ENDIAN);
    }

    public static int a(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i2);
            if (charAt < 2048) {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt2 < 2048) {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i2) >= 65536) {
                                i2++;
                            } else {
                                StringBuilder sb = new StringBuilder(39);
                                sb.append("Unpaired surrogate at index ");
                                sb.append(i2);
                                throw new IllegalArgumentException(sb.toString());
                            }
                        }
                    }
                    i2++;
                }
                i3 += i;
            }
        }
        if (i3 >= length) {
            return i3;
        }
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("UTF-8 length does not fit in int: ");
        sb2.append(((long) i3) + 4294967296L);
        throw new IllegalArgumentException(sb2.toString());
    }

    public static int g(int i, j4 j4Var) {
        int s = s(i);
        int c2 = j4Var.c();
        return u(c2) + c2 + s;
    }

    public static int h(int i, String str) {
        return o(str) + s(i);
    }

    public static int i(int i, byte[] bArr) {
        return s(i) + u(bArr.length) + bArr.length;
    }

    public static int l(int i, long j) {
        return r(j) + s(i);
    }

    public static void m(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i;
        int i2;
        int i3;
        char charAt;
        if (!byteBuffer.isReadOnly()) {
            int i4 = 0;
            if (byteBuffer.hasArray()) {
                try {
                    byte[] array = byteBuffer.array();
                    int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
                    int remaining = byteBuffer.remaining();
                    int length = charSequence.length();
                    int i5 = remaining + arrayOffset;
                    while (i4 < length) {
                        int i6 = i4 + arrayOffset;
                        if (i6 >= i5 || (charAt = charSequence.charAt(i4)) >= 128) {
                            break;
                        }
                        array[i6] = (byte) charAt;
                        i4++;
                    }
                    if (i4 == length) {
                        i2 = arrayOffset + length;
                    } else {
                        i2 = arrayOffset + i4;
                        while (i4 < length) {
                            char charAt2 = charSequence.charAt(i4);
                            if (charAt2 < 128 && i2 < i5) {
                                i3 = i2 + 1;
                                array[i2] = (byte) charAt2;
                            } else if (charAt2 < 2048 && i2 <= i5 - 2) {
                                int i7 = i2 + 1;
                                array[i2] = (byte) ((charAt2 >>> 6) | 960);
                                i2 = i7 + 1;
                                array[i7] = (byte) ((charAt2 & '?') | RecyclerView.a0.FLAG_IGNORE);
                                i4++;
                            } else if ((charAt2 < 55296 || 57343 < charAt2) && i2 <= i5 - 3) {
                                int i8 = i2 + 1;
                                array[i2] = (byte) ((charAt2 >>> '\f') | 480);
                                int i9 = i8 + 1;
                                array[i8] = (byte) (((charAt2 >>> 6) & 63) | RecyclerView.a0.FLAG_IGNORE);
                                i3 = i9 + 1;
                                array[i9] = (byte) ((charAt2 & '?') | RecyclerView.a0.FLAG_IGNORE);
                            } else if (i2 <= i5 - 4) {
                                int i10 = i4 + 1;
                                if (i10 != charSequence.length()) {
                                    char charAt3 = charSequence.charAt(i10);
                                    if (Character.isSurrogatePair(charAt2, charAt3)) {
                                        int codePoint = Character.toCodePoint(charAt2, charAt3);
                                        int i11 = i2 + 1;
                                        array[i2] = (byte) ((codePoint >>> 18) | 240);
                                        int i12 = i11 + 1;
                                        array[i11] = (byte) (((codePoint >>> 12) & 63) | RecyclerView.a0.FLAG_IGNORE);
                                        int i13 = i12 + 1;
                                        array[i12] = (byte) (((codePoint >>> 6) & 63) | RecyclerView.a0.FLAG_IGNORE);
                                        i2 = i13 + 1;
                                        array[i13] = (byte) ((codePoint & 63) | RecyclerView.a0.FLAG_IGNORE);
                                        i4 = i10;
                                        i4++;
                                    } else {
                                        i4 = i10;
                                    }
                                }
                                StringBuilder sb = new StringBuilder(39);
                                sb.append("Unpaired surrogate at index ");
                                sb.append(i4 - 1);
                                throw new IllegalArgumentException(sb.toString());
                            } else {
                                StringBuilder sb2 = new StringBuilder(37);
                                sb2.append("Failed writing ");
                                sb2.append(charAt2);
                                sb2.append(" at index ");
                                sb2.append(i2);
                                throw new ArrayIndexOutOfBoundsException(sb2.toString());
                            }
                            i2 = i3;
                            i4++;
                        }
                    }
                    byteBuffer.position(i2 - byteBuffer.arrayOffset());
                } catch (ArrayIndexOutOfBoundsException e2) {
                    BufferOverflowException bufferOverflowException = new BufferOverflowException();
                    bufferOverflowException.initCause(e2);
                    throw bufferOverflowException;
                }
            } else {
                int length2 = charSequence.length();
                while (i4 < length2) {
                    char charAt4 = charSequence.charAt(i4);
                    char c2 = charAt4;
                    if (charAt4 >= 128) {
                        if (charAt4 < 2048) {
                            i = (charAt4 >>> 6) | 960;
                        } else if (charAt4 < 55296 || 57343 < charAt4) {
                            byteBuffer.put((byte) ((charAt4 >>> '\f') | 480));
                            i = ((charAt4 >>> 6) & 63) | RecyclerView.a0.FLAG_IGNORE;
                        } else {
                            int i14 = i4 + 1;
                            if (i14 != charSequence.length()) {
                                char charAt5 = charSequence.charAt(i14);
                                if (Character.isSurrogatePair(charAt4, charAt5)) {
                                    int codePoint2 = Character.toCodePoint(charAt4, charAt5);
                                    byteBuffer.put((byte) ((codePoint2 >>> 18) | 240));
                                    byteBuffer.put((byte) (((codePoint2 >>> 12) & 63) | RecyclerView.a0.FLAG_IGNORE));
                                    byteBuffer.put((byte) (((codePoint2 >>> 6) & 63) | RecyclerView.a0.FLAG_IGNORE));
                                    byteBuffer.put((byte) ((codePoint2 & 63) | RecyclerView.a0.FLAG_IGNORE));
                                    i4 = i14;
                                    i4++;
                                } else {
                                    i4 = i14;
                                }
                            }
                            StringBuilder sb3 = new StringBuilder(39);
                            sb3.append("Unpaired surrogate at index ");
                            sb3.append(i4 - 1);
                            throw new IllegalArgumentException(sb3.toString());
                        }
                        byteBuffer.put((byte) i);
                        c2 = (charAt4 & '?') | RecyclerView.a0.FLAG_IGNORE;
                    }
                    byteBuffer.put(c2 == 1 ? (byte) 1 : 0);
                    i4++;
                }
            }
        } else {
            throw new ReadOnlyBufferException();
        }
    }

    public static int o(String str) {
        int a2 = a(str);
        return u(a2) + a2;
    }

    public static int r(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if ((-16384 & j) == 0) {
            return 2;
        }
        if ((-2097152 & j) == 0) {
            return 3;
        }
        if ((-268435456 & j) == 0) {
            return 4;
        }
        if ((-34359738368L & j) == 0) {
            return 5;
        }
        if ((-4398046511104L & j) == 0) {
            return 6;
        }
        if ((-562949953421312L & j) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static int s(int i) {
        return u(i << 3);
    }

    public static int t(int i) {
        if (i >= 0) {
            return u(i);
        }
        return 10;
    }

    public static int u(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    public final void b(int i, j4 j4Var) {
        f((i << 3) | 2);
        if (j4Var.f3330b < 0) {
            j4Var.c();
        }
        f(j4Var.f3330b);
        j4Var.a(this);
    }

    public final void c(int i, String str) {
        f((i << 3) | 2);
        try {
            int u = u(str.length());
            if (u == u(str.length() * 3)) {
                int position = this.f3239a.position();
                if (this.f3239a.remaining() >= u) {
                    this.f3239a.position(position + u);
                    m(str, this.f3239a);
                    int position2 = this.f3239a.position();
                    this.f3239a.position(position);
                    f((position2 - position) - u);
                    this.f3239a.position(position2);
                    return;
                }
                throw new d4(position + u, this.f3239a.limit());
            }
            f(a(str));
            m(str, this.f3239a);
        } catch (BufferOverflowException e2) {
            d4 d4Var = new d4(this.f3239a.position(), this.f3239a.limit());
            d4Var.initCause(e2);
            throw d4Var;
        }
    }

    public final void d(int i, byte[] bArr) {
        f((i << 3) | 2);
        f(bArr.length);
        int length = bArr.length;
        if (this.f3239a.remaining() >= length) {
            this.f3239a.put(bArr, 0, length);
            return;
        }
        throw new d4(this.f3239a.position(), this.f3239a.limit());
    }

    public final void e(int i) {
        byte b2 = (byte) i;
        if (this.f3239a.hasRemaining()) {
            this.f3239a.put(b2);
            return;
        }
        throw new d4(this.f3239a.position(), this.f3239a.limit());
    }

    public final void f(int i) {
        while ((i & -128) != 0) {
            e((i & 127) | RecyclerView.a0.FLAG_IGNORE);
            i >>>= 7;
        }
        e(i);
    }

    public final void j(int i, int i2) {
        f((i << 3) | i2);
    }

    public final void k(int i, int i2) {
        f((i << 3) | 0);
        if (i2 >= 0) {
            f(i2);
        } else {
            q((long) i2);
        }
    }

    public final void n(int i, e2 e2Var) {
        if (this.f3240b == null) {
            this.f3240b = g0.e(this.f3239a);
        } else {
            if (this.f3241c != this.f3239a.position()) {
                this.f3240b.c(this.f3239a.array(), this.f3241c, this.f3239a.position() - this.f3241c);
            }
            g0 g0Var = this.f3240b;
            g0Var.i(i, e2Var);
            g0Var.b();
            this.f3241c = this.f3239a.position();
        }
        this.f3241c = this.f3239a.position();
        g0 g0Var2 = this.f3240b;
        g0Var2.i(i, e2Var);
        g0Var2.b();
        this.f3241c = this.f3239a.position();
    }

    public final void p(int i, long j) {
        f((i << 3) | 0);
        q(j);
    }

    public final void q(long j) {
        while ((-128 & j) != 0) {
            e((((int) j) & 127) | RecyclerView.a0.FLAG_IGNORE);
            j >>>= 7;
        }
        e((int) j);
    }
}
