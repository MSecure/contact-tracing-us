package e.a.a.a;

import e.a.a.a.c.a;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class b {
    static {
        char c2 = File.separatorChar;
        e.a.a.a.c.b bVar = new e.a.a.a.c.b(4);
        PrintWriter printWriter = new PrintWriter(bVar);
        printWriter.println();
        bVar.toString();
        printWriter.close();
    }

    public static void a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void b(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public static int c(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                break;
            }
            outputStream.write(bArr, 0, read);
            j += (long) read;
        }
        if (j > 2147483647L) {
            return -1;
        }
        return (int) j;
    }

    public static byte[] d(InputStream inputStream) {
        a aVar = new a();
        c(inputStream, aVar);
        return aVar.b();
    }
}
