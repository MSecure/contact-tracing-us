package org.spongycastle.util.io;

import java.io.IOException;
import java.io.InputStream;

public final class Streams {
    public static int readFully(InputStream inputStream, byte[] bArr) throws IOException {
        int length = bArr.length;
        int i = 0;
        while (i < length) {
            int read = inputStream.read(bArr, 0 + i, length - i);
            if (read < 0) {
                break;
            }
            i += read;
        }
        return i;
    }
}
