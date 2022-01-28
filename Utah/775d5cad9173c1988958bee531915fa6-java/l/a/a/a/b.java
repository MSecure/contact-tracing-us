package l.a.a.a;

import java.io.File;
import java.io.InputStream;
import java.io.PrintWriter;
import l.a.a.a.c.a;

public class b {
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001e, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001f, code lost:
        r0.addSuppressed(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0022, code lost:
        throw r2;
     */
    static {
        char c = File.separatorChar;
        l.a.a.a.c.b bVar = new l.a.a.a.c.b(4);
        PrintWriter printWriter = new PrintWriter(bVar);
        printWriter.println();
        bVar.toString();
        printWriter.close();
    }

    public static byte[] a(InputStream inputStream) {
        a aVar = new a();
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
    }
}
