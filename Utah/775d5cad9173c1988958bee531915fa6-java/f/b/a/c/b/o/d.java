package f.b.a.c.b.o;

import android.os.Process;
import android.os.StrictMode;
import androidx.annotation.RecentlyNullable;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class d {
    public static String a;
    public static int b;

    /* JADX WARNING: Removed duplicated region for block: B:19:0x004b A[SYNTHETIC, Splitter:B:19:0x004b] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0052  */
    @RecentlyNullable
    public static String a() {
        BufferedReader bufferedReader;
        Throwable th;
        if (a == null) {
            if (b == 0) {
                b = Process.myPid();
            }
            int i2 = b;
            String str = null;
            str = null;
            str = null;
            BufferedReader bufferedReader2 = null;
            if (i2 > 0) {
                try {
                    StringBuilder sb = new StringBuilder(25);
                    sb.append("/proc/");
                    sb.append(i2);
                    sb.append("/cmdline");
                    bufferedReader = b(sb.toString());
                    try {
                        String readLine = bufferedReader.readLine();
                        Objects.requireNonNull(readLine, "null reference");
                        str = readLine.trim();
                        try {
                            bufferedReader.close();
                        } catch (IOException unused) {
                        }
                    } catch (IOException unused2) {
                        if (bufferedReader != null) {
                        }
                        a = str;
                        return a;
                    } catch (Throwable th2) {
                        bufferedReader2 = bufferedReader;
                        th = th2;
                        if (bufferedReader2 != null) {
                        }
                        throw th;
                    }
                } catch (IOException unused3) {
                    bufferedReader = null;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    a = str;
                    return a;
                } catch (Throwable th3) {
                    th = th3;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException unused4) {
                        }
                    }
                    throw th;
                }
            }
            a = str;
        }
        return a;
    }

    public static BufferedReader b(String str) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return new BufferedReader(new FileReader(str));
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }
}
