package b.z.y;

import android.content.Context;
import b.z.m;
import java.io.File;
import java.util.HashMap;

public class j {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1967a = m.e("WrkDbPathHelper");

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f1968b = {"-journal", "-shm", "-wal"};

    public static String a() {
        return "androidx.work.workdb";
    }

    public static void b(Context context) {
        if (context.getDatabasePath("androidx.work.workdb").exists()) {
            m.c().a(f1967a, "Migrating WorkDatabase to the no-backup directory", new Throwable[0]);
            HashMap hashMap = new HashMap();
            File databasePath = context.getDatabasePath("androidx.work.workdb");
            File file = new File(context.getNoBackupFilesDir(), "androidx.work.workdb");
            hashMap.put(databasePath, file);
            String[] strArr = f1968b;
            for (String str : strArr) {
                hashMap.put(new File(databasePath.getPath() + str), new File(file.getPath() + str));
            }
            for (File file2 : hashMap.keySet()) {
                File file3 = (File) hashMap.get(file2);
                if (file2.exists() && file3 != null) {
                    if (file3.exists()) {
                        m.c().f(f1967a, String.format("Over-writing contents of %s", file3), new Throwable[0]);
                    }
                    m.c().a(f1967a, file2.renameTo(file3) ? String.format("Migrated %s to %s", file2, file3) : String.format("Renaming %s to %s failed", file2, file3), new Throwable[0]);
                }
            }
        }
    }
}
