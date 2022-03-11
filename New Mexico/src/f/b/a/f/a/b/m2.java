package f.b.a.f.a.b;

import f.b.a.f.a.c.d;
import f.b.a.f.a.e.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;
/* loaded from: classes.dex */
public final class m2 {

    /* renamed from: d  reason: collision with root package name */
    public static final a f3266d = new a("PackMetadataManager");
    public final d0 a;
    public final o2 b;
    public final d c;

    public m2(d0 d0Var, o2 o2Var, d dVar) {
        this.a = d0Var;
        this.b = o2Var;
        this.c = dVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final String a(String str) {
        boolean z;
        if (!this.c.a()) {
            return "";
        }
        d0 d0Var = this.a;
        Objects.requireNonNull(d0Var);
        if (d0Var.u(str) != null) {
            z = true;
            if (z) {
                return "";
            }
            int a = this.b.a();
            d0 d0Var2 = this.a;
            File file = new File(d0Var2.o(str, a, d0Var2.l(str)), "properties.dat");
            try {
                if (file.exists()) {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    Properties properties = new Properties();
                    properties.load(fileInputStream);
                    fileInputStream.close();
                    String property = properties.getProperty("moduleVersionTag");
                    if (property != null) {
                        return property;
                    }
                }
                return String.valueOf(a);
            } catch (IOException unused) {
                f3266d.b("Failed to read pack version tag for pack %s", str);
                return "";
            }
        }
        z = false;
        if (z) {
        }
    }

    public final void b(String str, int i2, long j2, String str2) {
        if (str2 == null || str2.isEmpty()) {
            str2 = String.valueOf(i2);
        }
        Properties properties = new Properties();
        properties.put("moduleVersionTag", str2);
        d0 d0Var = this.a;
        Objects.requireNonNull(d0Var);
        File file = new File(d0Var.o(str, i2, j2), "properties.dat");
        file.getParentFile().mkdirs();
        file.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable unused) {
            }
            throw th;
        }
    }
}
