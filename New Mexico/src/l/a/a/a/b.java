package l.a.a.a;

import java.io.File;
import java.io.InputStream;
import java.io.PrintWriter;
import l.a.a.a.c.a;
/* loaded from: classes.dex */
public class b {
    static {
        char c = File.separatorChar;
        l.a.a.a.c.b bVar = new l.a.a.a.c.b(4);
        try {
            PrintWriter printWriter = new PrintWriter(bVar);
            printWriter.println();
            bVar.toString();
            printWriter.close();
        } finally {
            throw th;
        }
    }

    public static byte[] a(InputStream inputStream) {
        a aVar = new a();
        try {
            byte[] bArr = new byte[4096];
            long j2 = 0;
            while (true) {
                int read = inputStream.read(bArr);
                if (-1 != read) {
                    aVar.write(bArr, 0, read);
                    j2 += (long) read;
                } else {
                    int i2 = (j2 > 2147483647L ? 1 : (j2 == 2147483647L ? 0 : -1));
                    return aVar.d();
                }
            }
        } finally {
            throw th;
        }
    }
}
