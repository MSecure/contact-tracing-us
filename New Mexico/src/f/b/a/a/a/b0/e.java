package f.b.a.a.a.b0;

import f.b.a.a.a.n0.a1;
import f.b.b.f.a.w;
import java.io.File;
/* loaded from: classes.dex */
public final class e {
    public final w a;
    public final a1 b;
    public final e.c0.w c;

    /* loaded from: classes.dex */
    public static class a extends Exception {
    }

    /* loaded from: classes.dex */
    public static class b extends RuntimeException {
        public b(Throwable th) {
            super(th);
        }
    }

    public e(w wVar, a1 a1Var, e.c0.w wVar2) {
        this.a = wVar;
        this.b = a1Var;
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
        if (!file.getName().equals("ExposureNotificationSharedPreferences.SHARED_PREFERENCES_FILE.xml") && !file.getName().equals("shared_prefs")) {
            return file.delete();
        }
        return true;
    }

    public void b() {
        f.a.a.a.a.o(this.b.a, "ExposureNotificationSharedPreferences.MIGRATION_RUN_OR_NOT_NEEDED", true);
    }
}
