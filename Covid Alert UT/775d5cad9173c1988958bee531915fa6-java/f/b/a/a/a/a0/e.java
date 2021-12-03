package f.b.a.a.a.a0;

import f.b.a.a.a.l0.v0;
import f.b.b.f.a.w;
import java.io.File;

public final class e {
    public final w a;
    public final v0 b;
    public final e.b0.w c;

    public static class a extends Exception {
    }

    public static class b extends RuntimeException {
        public b(Throwable th) {
            super(th);
        }
    }

    public e(w wVar, v0 v0Var, e.b0.w wVar2) {
        this.a = wVar;
        this.b = v0Var;
        this.c = wVar2;
    }

    public final boolean a(File file) {
        if (file.isDirectory()) {
            for (String str : file.list()) {
                if (!a(new File(file, str))) {
                    return false;
                }
            }
        }
        if (file.getName().equals("ExposureNotificationSharedPreferences.SHARED_PREFERENCES_FILE.xml")) {
            return true;
        }
        return file.delete();
    }

    public void b() {
        this.b.a.edit().putBoolean("ExposureNotificationSharedPreferences.MIGRATION_RUN_OR_NOT_NEEDED", true).apply();
    }
}
