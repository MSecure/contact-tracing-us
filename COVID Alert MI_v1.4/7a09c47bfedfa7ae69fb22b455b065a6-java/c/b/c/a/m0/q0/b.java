package c.b.c.a.m0.q0;

import c.b.c.a.h0.c;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;

public class b implements c {

    /* renamed from: a  reason: collision with root package name */
    public final c f5175a;

    public b(c cVar) {
        this.f5175a = cVar;
    }

    @Override // c.b.c.a.h0.c
    public byte[] a(byte[] bArr, int i) {
        if (bArr == null) {
            throw new GeneralSecurityException("Invalid input provided.");
        } else if (i > 0) {
            InputStream a2 = this.f5175a.a(bArr);
            try {
                byte[] bArr2 = new byte[i];
                int i2 = 0;
                while (i2 < i) {
                    int read = a2.read(bArr2, i2, i - i2);
                    if (read > 0) {
                        i2 += read;
                    } else {
                        throw new GeneralSecurityException("Provided StreamingPrf terminated before providing requested number of bytes.");
                    }
                }
                return bArr2;
            } catch (IOException e2) {
                throw new GeneralSecurityException(e2);
            }
        } else {
            throw new GeneralSecurityException("Invalid outputLength specified.");
        }
    }
}
