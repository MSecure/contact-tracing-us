package f.b.a.f.a.b;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public final class a3 {
    public static final Pattern a = Pattern.compile("[0-9]+-(NAM|LFH)\\.dat");

    public static List<File> a(File file, File file2) {
        File[] fileArr;
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file2.listFiles(z2.a);
        if (listFiles == null) {
            fileArr = new File[0];
        } else {
            int length = listFiles.length;
            File[] fileArr2 = new File[length];
            for (File file3 : listFiles) {
                int parseInt = Integer.parseInt(file3.getName().split("-")[0]);
                if (parseInt > listFiles.length || fileArr2[parseInt] != null) {
                    throw new z0("Metadata folder ordering corrupt.");
                }
                fileArr2[parseInt] = file3;
            }
            fileArr = fileArr2;
        }
        for (File file4 : fileArr) {
            arrayList.add(file4);
            if (file4.getName().contains("LFH")) {
                FileInputStream fileInputStream = new FileInputStream(file4);
                try {
                    e3 c = new n0(fileInputStream).c();
                    if (((k0) c).a != null) {
                        File file5 = new File(file, ((k0) c).a);
                        if (file5.exists()) {
                            arrayList.add(file5);
                            fileInputStream.close();
                        } else {
                            throw new z0(String.format("Missing asset file %s during slice reconstruction.", file5.getCanonicalPath()));
                        }
                    } else {
                        throw new z0("Metadata files corrupt. Could not read local file header.");
                    }
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable unused) {
                    }
                    throw th;
                }
            }
        }
        return arrayList;
    }
}
