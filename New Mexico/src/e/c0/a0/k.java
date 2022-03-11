package e.c0.a0;

import android.content.Context;
import android.os.Build;
import e.c0.n;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes.dex */
public class k {
    public static final String a = n.e("WrkDbPathHelper");
    public static final String[] b = {"-journal", "-shm", "-wal"};

    public static void a(Context context) {
        File file;
        File databasePath = context.getDatabasePath("androidx.work.workdb");
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23 && databasePath.exists()) {
            n.c().a(a, "Migrating WorkDatabase to the no-backup directory", new Throwable[0]);
            HashMap hashMap = new HashMap();
            if (i2 >= 23) {
                File databasePath2 = context.getDatabasePath("androidx.work.workdb");
                if (i2 < 23) {
                    file = context.getDatabasePath("androidx.work.workdb");
                } else {
                    file = new File(context.getNoBackupFilesDir(), "androidx.work.workdb");
                }
                hashMap.put(databasePath2, file);
                String[] strArr = b;
                for (String str : strArr) {
                    hashMap.put(new File(databasePath2.getPath() + str), new File(file.getPath() + str));
                }
            }
            for (File file2 : hashMap.keySet()) {
                File file3 = (File) hashMap.get(file2);
                if (file2.exists() && file3 != null) {
                    if (file3.exists()) {
                        n.c().f(a, String.format("Over-writing contents of %s", file3), new Throwable[0]);
                    }
                    n.c().a(a, file2.renameTo(file3) ? String.format("Migrated %s to %s", file2, file3) : String.format("Renaming %s to %s failed", file2, file3), new Throwable[0]);
                }
            }
        }
    }
}
