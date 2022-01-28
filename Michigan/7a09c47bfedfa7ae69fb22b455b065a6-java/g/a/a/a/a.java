package g.a.a.a;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final BigInteger f6381a;

    /* renamed from: b  reason: collision with root package name */
    public static final BigInteger f6382b;

    /* renamed from: c  reason: collision with root package name */
    public static final BigInteger f6383c;

    /* renamed from: d  reason: collision with root package name */
    public static final BigInteger f6384d;

    /* renamed from: e  reason: collision with root package name */
    public static final BigInteger f6385e;

    /* renamed from: f  reason: collision with root package name */
    public static final BigInteger f6386f;

    static {
        BigInteger valueOf = BigInteger.valueOf(1024);
        f6381a = valueOf;
        BigInteger multiply = valueOf.multiply(valueOf);
        f6382b = multiply;
        BigInteger multiply2 = f6381a.multiply(multiply);
        f6383c = multiply2;
        BigInteger multiply3 = f6381a.multiply(multiply2);
        f6384d = multiply3;
        BigInteger multiply4 = f6381a.multiply(multiply3);
        f6385e = multiply4;
        f6381a.multiply(multiply4);
        BigInteger multiply5 = BigInteger.valueOf(1024).multiply(BigInteger.valueOf(1152921504606846976L));
        f6386f = multiply5;
        f6381a.multiply(multiply5);
    }

    public static void a(InputStream inputStream, File file) {
        try {
            FileOutputStream b2 = b(file, false);
            try {
                b.c(inputStream, b2);
                b2.close();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
            } finally {
                b.b(b2);
            }
        } catch (Throwable th) {
            b.a(inputStream);
            throw th;
        }
    }

    public static FileOutputStream b(File file, boolean z) {
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                throw new IOException("Directory '" + parentFile + "' could not be created");
            }
        } else if (file.isDirectory()) {
            throw new IOException("File '" + file + "' exists but is a directory");
        } else if (!file.canWrite()) {
            throw new IOException("File '" + file + "' cannot be written to");
        }
        return new FileOutputStream(file, z);
    }

    public static void c(File file, byte[] bArr) {
        Throwable th;
        FileOutputStream fileOutputStream;
        int length = bArr.length;
        try {
            fileOutputStream = b(file, false);
            try {
                fileOutputStream.write(bArr, 0, length);
                fileOutputStream.close();
                b.b(fileOutputStream);
            } catch (Throwable th2) {
                th = th2;
                b.b(fileOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            b.b(fileOutputStream);
            throw th;
        }
    }
}
