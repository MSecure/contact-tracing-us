package com.bugfender.sdk.a.a.j;

import com.bugfender.sdk.a.a.e.b;
import java.io.File;
import java.io.FilenameFilter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class c<T> {
    public static int h = 65536;
    private static final int i = 1;
    private File a;
    private String b;
    private File c;
    private PrintWriter d;
    private final com.bugfender.sdk.a.a.c.a<T, String> e;
    private final com.bugfender.sdk.a.a.c.a<File, List<T>> f;
    private int g = 0;

    /* access modifiers changed from: package-private */
    public class a implements FilenameFilter {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        public boolean accept(File file, String str) {
            return str.startsWith(this.a);
        }
    }

    /* access modifiers changed from: private */
    public static class b extends b.a {
        public b(File[] fileArr) {
            super(fileArr);
        }

        @Override // com.bugfender.sdk.a.a.e.b.a
        public int a(File file, Long l, File file2, Long l2) {
            return l.compareTo(l2);
        }
    }

    public c(com.bugfender.sdk.a.a.c.a<T, String> aVar, com.bugfender.sdk.a.a.c.a<File, List<T>> aVar2, File file, String str) {
        this.e = aVar;
        this.f = aVar2;
        this.a = file;
        this.b = str;
    }

    public a<T> a(int i2) {
        return a(this.a, this.b, i2);
    }

    public a<T> b(int i2) {
        return a(this.a, this.b + "-", i2);
    }

    public File c() {
        return this.a;
    }

    public a<T> d() {
        return a(0);
    }

    public a<T> e() {
        return b(0);
    }

    public long f() {
        return a(this.a);
    }

    public boolean g() {
        PrintWriter printWriter = this.d;
        if (printWriter != null) {
            printWriter.close();
        }
        if (this.c == null) {
            return false;
        }
        File file = this.a;
        File file2 = new File(file, this.b + "-" + System.currentTimeMillis() + ".json");
        boolean renameTo = this.c.renameTo(file2);
        if (renameTo) {
            this.c = null;
            this.d = null;
            if (file2.length() == 0) {
                file2.delete();
            }
        }
        return renameTo;
    }

    public boolean a(T t) {
        try {
            String b2 = this.e.b(t);
            File file = this.c;
            if (file != null && !a(b2, file)) {
                g();
            }
            if (this.c == null) {
                this.c = new File(this.a, this.b);
            }
            if (this.d == null) {
                this.d = new PrintWriter(this.c);
            }
            this.d.println(b2);
            this.d.flush();
            return a(this.d.checkError());
        } catch (Exception unused) {
            return a(true);
        }
    }

    public boolean b() {
        File[] listFiles = this.a.listFiles();
        boolean z = true;
        for (File file : listFiles) {
            if (file.getName().startsWith(this.b + "-") && !file.delete()) {
                z = false;
            }
        }
        return z;
    }

    private boolean a(boolean z) {
        boolean z2 = !z;
        if (!z2 || this.g <= 0) {
            int i2 = this.g;
            if (i2 > 1) {
                return true;
            }
            if (z) {
                this.g = i2 + 1;
            }
            return z2;
        }
        this.g = 0;
        return true;
    }

    private boolean a(String str, File file) {
        return file.length() + ((long) str.getBytes().length) <= ((long) h);
    }

    public boolean a(List<File> list) {
        boolean z = true;
        for (File file : list) {
            z &= file.delete();
        }
        return z;
    }

    public boolean a() {
        for (File file : this.a.listFiles()) {
            file.delete();
        }
        return this.a.delete();
    }

    private long a(File file) {
        long j;
        if (!file.isDirectory()) {
            return file.length();
        }
        File[] listFiles = file.listFiles();
        long j2 = 0;
        for (File file2 : listFiles) {
            if (file2.isFile()) {
                j = file2.length();
            } else {
                j = a(file2);
            }
            j2 += j;
        }
        return j2;
    }

    private a<T> a(File file, String str, int i2) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        if (file != null) {
            File[] listFiles = file.listFiles(new a(str));
            com.bugfender.sdk.a.a.e.b.a(listFiles, new b(listFiles));
            if (i2 == 0) {
                i2 = Integer.MAX_VALUE;
            }
            int i3 = 0;
            while (i3 < listFiles.length && i3 < i2) {
                File file2 = listFiles[i3];
                linkedList2.add(file2);
                linkedList.addAll(this.f.b(file2));
                i3++;
            }
        }
        return new a<>(linkedList, linkedList2);
    }
}
