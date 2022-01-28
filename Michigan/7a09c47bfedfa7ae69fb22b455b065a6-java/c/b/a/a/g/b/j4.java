package c.b.a.a.g.b;

import b.x.t;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class j4 {

    /* renamed from: b  reason: collision with root package name */
    public volatile int f3330b = -1;

    public static final void b(j4 j4Var, byte[] bArr, int i) {
        try {
            c4 c4Var = new c4(bArr, 0, i);
            j4Var.a(c4Var);
            if (c4Var.f3239a.remaining() != 0) {
                throw new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", Integer.valueOf(c4Var.f3239a.remaining())));
            }
        } catch (IOException e2) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e2);
        }
    }

    public void a(c4 c4Var) {
    }

    public final int c() {
        int d2 = d();
        this.f3330b = d2;
        return d2;
    }

    public int d() {
        return 0;
    }

    /* renamed from: e */
    public j4 clone() {
        return (j4) super.clone();
    }

    public String toString() {
        String str;
        String str2;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            t.j4(null, this, new StringBuffer(), stringBuffer);
            return stringBuffer.toString();
        } catch (IllegalAccessException e2) {
            str2 = String.valueOf(e2.getMessage());
            if (str2.length() == 0) {
                str = new String("Error printing proto: ");
                return str;
            }
            return "Error printing proto: ".concat(str2);
        } catch (InvocationTargetException e3) {
            str2 = String.valueOf(e3.getMessage());
            if (str2.length() == 0) {
                str = new String("Error printing proto: ");
                return str;
            }
            return "Error printing proto: ".concat(str2);
        }
    }
}
