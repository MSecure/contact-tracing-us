package f.b.a.f.a.b;

import f.b.a.f.a.e.a;
import java.io.File;
import java.io.IOException;
/* loaded from: classes.dex */
public final class f2 {
    public static final a b = new a("MergeSliceTaskHandler");
    public final d0 a;

    public f2(d0 d0Var) {
        this.a = d0Var;
    }

    public static void b(File file, File file2) {
        if (file.isDirectory()) {
            file2.mkdirs();
            File[] listFiles = file.listFiles();
            for (File file3 : listFiles) {
                b(file3, new File(file2, file3.getName()));
            }
            if (!file.delete()) {
                String valueOf = String.valueOf(file);
                throw new z0(f.a.a.a.a.e(new StringBuilder(valueOf.length() + 28), "Unable to delete directory: ", valueOf));
            }
        } else if (file2.exists()) {
            String valueOf2 = String.valueOf(file2);
            throw new z0(f.a.a.a.a.e(new StringBuilder(valueOf2.length() + 51), "File clashing with existing file from other slice: ", valueOf2));
        } else if (!file.renameTo(file2)) {
            String valueOf3 = String.valueOf(file);
            throw new z0(f.a.a.a.a.e(new StringBuilder(valueOf3.length() + 21), "Unable to move file: ", valueOf3));
        }
    }

    public final void a(e2 e2Var) {
        File t = this.a.t(e2Var.b, e2Var.c, e2Var.f3215d, e2Var.f3216e);
        if (t.exists()) {
            File p = this.a.p(e2Var.b, e2Var.c, e2Var.f3215d);
            if (!p.exists()) {
                p.mkdirs();
            }
            b(t, p);
            try {
                this.a.a(e2Var.b, e2Var.c, e2Var.f3215d, this.a.k(e2Var.b, e2Var.c, e2Var.f3215d) + 1);
            } catch (IOException e2) {
                b.b("Writing merge checkpoint failed with %s.", e2.getMessage());
                throw new z0("Writing merge checkpoint failed.", e2, e2Var.a);
            }
        } else {
            throw new z0(String.format("Cannot find verified files for slice %s.", e2Var.f3216e), e2Var.a);
        }
    }
}
