package l.a.a.a;

import java.math.BigInteger;

public class a {
    public static final BigInteger a;
    public static final BigInteger b;
    public static final BigInteger c;

    /* renamed from: d  reason: collision with root package name */
    public static final BigInteger f4121d;

    /* renamed from: e  reason: collision with root package name */
    public static final BigInteger f4122e;

    /* renamed from: f  reason: collision with root package name */
    public static final BigInteger f4123f;

    static {
        BigInteger valueOf = BigInteger.valueOf(1024);
        a = valueOf;
        BigInteger multiply = valueOf.multiply(valueOf);
        b = multiply;
        BigInteger multiply2 = valueOf.multiply(multiply);
        c = multiply2;
        BigInteger multiply3 = valueOf.multiply(multiply2);
        f4121d = multiply3;
        BigInteger multiply4 = valueOf.multiply(multiply3);
        f4122e = multiply4;
        valueOf.multiply(multiply4);
        BigInteger multiply5 = BigInteger.valueOf(1024).multiply(BigInteger.valueOf(1152921504606846976L));
        f4123f = multiply5;
        valueOf.multiply(multiply5);
    }
}
