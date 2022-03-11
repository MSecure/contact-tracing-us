package h.a.j1;

import f.b.b.a.d;
import java.util.logging.Logger;

public final class a3 {
    public static final Logger a = Logger.getLogger(a3.class.getName());
    public static final byte[] b = "-bin".getBytes(d.a);

    public static boolean a(byte[] bArr, byte[] bArr2) {
        int length = bArr.length - bArr2.length;
        if (length < 0) {
            return false;
        }
        for (int i2 = length; i2 < bArr.length; i2++) {
            if (bArr[i2] != bArr2[i2 - length]) {
                return false;
            }
        }
        return true;
    }
}
