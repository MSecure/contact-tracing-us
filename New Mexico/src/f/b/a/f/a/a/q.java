package f.b.a.f.a.a;

import android.content.Context;
import java.io.File;
/* loaded from: classes.dex */
public final class q {
    public final Context a;

    public q(Context context) {
        this.a = context;
    }

    public static long a(File file) {
        if (!file.isDirectory()) {
            return file.length();
        }
        File[] listFiles = file.listFiles();
        long j2 = 0;
        if (listFiles != null) {
            for (File file2 : listFiles) {
                j2 += a(file2);
            }
        }
        return j2;
    }
}
