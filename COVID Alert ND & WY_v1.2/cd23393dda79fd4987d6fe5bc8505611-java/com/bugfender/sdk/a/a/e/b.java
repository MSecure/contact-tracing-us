package com.bugfender.sdk.a.a.e;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class b {

    public static abstract class a implements Comparator<File> {
        private final Map<File, Long> a;

        /* renamed from: com.bugfender.sdk.a.a.e.b$a$a  reason: collision with other inner class name */
        class C0002a extends HashMap<File, Long> {
            final /* synthetic */ File[] a;

            C0002a(File[] fileArr) {
                this.a = fileArr;
                for (File file : fileArr) {
                    put(file, Long.valueOf(file.lastModified()));
                }
            }
        }

        public a(File[] fileArr) {
            this.a = new C0002a(fileArr);
        }

        /* renamed from: a */
        public int compare(File file, File file2) {
            return a(file, this.a.get(file), file2, this.a.get(file2));
        }

        public abstract int a(File file, Long l, File file2, Long l2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x001b  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    public static void a(File file, String str) {
        Throwable th;
        FileNotFoundException e;
        PrintWriter printWriter = null;
        try {
            PrintWriter printWriter2 = new PrintWriter(file);
            try {
                printWriter2.println(str);
                printWriter2.close();
            } catch (FileNotFoundException e2) {
                e = e2;
                printWriter = printWriter2;
                try {
                    e.printStackTrace();
                    if (printWriter == null) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (printWriter != null) {
                        printWriter.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                printWriter = printWriter2;
                if (printWriter != null) {
                }
                throw th;
            }
        } catch (FileNotFoundException e3) {
            e = e3;
            e.printStackTrace();
            if (printWriter == null) {
                printWriter.close();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0023  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    public static void b(File file, String str) {
        Throwable th;
        FileNotFoundException e;
        PrintWriter printWriter = null;
        try {
            PrintWriter printWriter2 = new PrintWriter(file);
            try {
                printWriter2.print("");
                printWriter2.flush();
                printWriter2.println(str);
                printWriter2.close();
            } catch (FileNotFoundException e2) {
                e = e2;
                printWriter = printWriter2;
                try {
                    e.printStackTrace();
                    if (printWriter == null) {
                        printWriter.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (printWriter != null) {
                        printWriter.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                printWriter = printWriter2;
                if (printWriter != null) {
                }
                throw th;
            }
        } catch (FileNotFoundException e3) {
            e = e3;
            e.printStackTrace();
            if (printWriter == null) {
            }
        }
    }

    public static String c(File file) {
        StringBuilder sb = new StringBuilder((int) file.length());
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(file)));
        while (scanner.hasNextLine()) {
            try {
                sb.append(scanner.nextLine());
            } finally {
                scanner.close();
            }
        }
        return sb.toString();
    }

    public static boolean a(File file) {
        File[] listFiles = file.listFiles();
        boolean z = true;
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                z = a(file2);
            } else {
                z = file2.delete();
            }
        }
        return z ? file.delete() : z;
    }

    public static boolean b(File file) {
        File[] listFiles = file.listFiles();
        boolean z = true;
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                z = a(file2);
            } else {
                z = file2.delete();
            }
        }
        return z;
    }

    public static void a(File[] fileArr, a aVar) {
        Arrays.sort(fileArr, aVar);
    }
}
