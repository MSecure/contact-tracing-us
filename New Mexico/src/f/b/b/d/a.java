package f.b.b.d;

import java.math.RoundingMode;
import java.util.Objects;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: f.b.b.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0109a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0044, code lost:
        if (((r7 == java.math.RoundingMode.HALF_EVEN) & ((r0 & 1) != 0)) != false) goto L_0x0057;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0047, code lost:
        if (r1 > 0) goto L_0x0057;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004a, code lost:
        if (r5 > 0) goto L_0x0057;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004d, code lost:
        if (r5 < 0) goto L_0x0057;
     */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public static int a(int i2, int i3, RoundingMode roundingMode) {
        Objects.requireNonNull(roundingMode);
        if (i3 != 0) {
            int i4 = i2 / i3;
            int i5 = i2 - (i3 * i4);
            if (i5 == 0) {
                return i4;
            }
            boolean z = true;
            int i6 = ((i2 ^ i3) >> 31) | 1;
            switch (C0109a.a[roundingMode.ordinal()]) {
                case 1:
                    if (i5 != 0) {
                        z = false;
                    }
                    if (!z) {
                        throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
                    }
                    z = false;
                    break;
                case 2:
                    z = false;
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                case 7:
                case 8:
                    int abs = Math.abs(i5);
                    int abs2 = abs - (Math.abs(i3) - abs);
                    if (abs2 == 0) {
                        if (roundingMode != RoundingMode.HALF_UP) {
                            break;
                        }
                    }
                    break;
                default:
                    throw new AssertionError();
            }
            return z ? i4 + i6 : i4;
        }
        throw new ArithmeticException("/ by zero");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int b(int i2, RoundingMode roundingMode) {
        if (i2 > 0) {
            boolean z = true;
            switch (C0109a.a[roundingMode.ordinal()]) {
                case 1:
                    boolean z2 = i2 > 0;
                    if (((i2 - 1) & i2) != 0) {
                        z = false;
                    }
                    if (!z2 || !z) {
                        throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
                    }
                    break;
                case 2:
                case 3:
                    break;
                case 4:
                case 5:
                    return 32 - Integer.numberOfLeadingZeros(i2 - 1);
                case 6:
                case 7:
                case 8:
                    int numberOfLeadingZeros = Integer.numberOfLeadingZeros(i2);
                    return (31 - numberOfLeadingZeros) + ((~(~((-1257966797 >>> numberOfLeadingZeros) - i2))) >>> 31);
                default:
                    throw new AssertionError();
            }
            return 31 - Integer.numberOfLeadingZeros(i2);
        }
        throw new IllegalArgumentException("x (" + i2 + ") must be > 0");
    }
}
