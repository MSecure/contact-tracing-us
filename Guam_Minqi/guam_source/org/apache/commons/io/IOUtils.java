package org.apache.commons.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import org.apache.commons.io.output.StringBuilderWriter;

public class IOUtils {
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
        StringBuilderWriter stringBuilderWriter = new StringBuilderWriter(4);
        PrintWriter printWriter = new PrintWriter(stringBuilderWriter);
        printWriter.println();
        stringBuilderWriter.toString();
        printWriter.close();
    }

    public static int copy(InputStream inputStream, OutputStream outputStream) throws IOException {
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
}
